package com.demo.kaiyun.androiddemo.ui.company;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.kaiyun.androiddemo.R;
import com.demo.kaiyun.androiddemo.base.BaseActivity;
import com.demo.kaiyun.androiddemo.base.ResponseHandle;
import com.demo.kaiyun.androiddemo.bean.Company;
import com.demo.kaiyun.androiddemo.bean.PostedItem;
import com.demo.kaiyun.androiddemo.ui.student.HomeFragment;
import com.demo.kaiyun.androiddemo.ui.student.JobListActivity;
import com.demo.kaiyun.androiddemo.ui.student.MeFragment;
import com.demo.kaiyun.androiddemo.ui.student.ResumeFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CompanyMainActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private Toolbar toolbar;
    private Company data;
    List<PostedItem> mPostedList = new ArrayList<>();
    private ArrayList<String> array = new ArrayList<>();
    private RecyclerView mRvMain;
    private SwipeRefreshLayout mRefreshLayout;
    private CardListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_main);

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        data = ((Company) getIntent().getSerializableExtra("data"));
        setTitle(data.getName());

        mRvMain = (RecyclerView) findViewById(R.id.rv_main);
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refreshLayout);
        mRefreshLayout.setOnRefreshListener(this);
        adapter = new CardListAdapter(this,array);
        mRvMain.setLayoutManager(new LinearLayoutManager(this));
        mRvMain.setAdapter(adapter);
        getData();
    }


    private void getData() {
        mApiService.queryJobInfoByCompanyId(data.getId()).enqueue(new ResponseHandle<List<PostedItem>>() {
            @Override
            protected void onSuccess(List<PostedItem> data) {
                mPostedList.clear();
                mPostedList.addAll(data);
                array.clear();
                for (PostedItem postedItem : data) {
                    array.add(postedItem.getJob().getName() + "\n " + "投递人数 ：" + postedItem.getSize());
                }
                adapter.notifyDataSetChanged();
                if (mRefreshLayout != null) {
                    mRefreshLayout.setRefreshing(false);
                }

            }

            @Override
            protected void onError() {
                super.onError();
                if (mRefreshLayout != null) {
                    mRefreshLayout.setRefreshing(false);
                }
            }
        });

    }

    @Override
    public void onRefresh() {
        getData();
    }

    public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.MyViewHolder> {
        private Context context;
        private ArrayList<String> list;

        //        private IcardViewChanger icardViewChanger;
        public CardListAdapter(Context context, ArrayList<String> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public CardListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            CardListAdapter.MyViewHolder holder = new CardListAdapter.MyViewHolder(LayoutInflater.from(
                    context).inflate(R.layout.fragment_home_item, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(CardListAdapter.MyViewHolder holder, final int position) {
            holder.tv.setText(list.get(position));
//            if (icardViewChanger!=null){
//                icardViewChanger.changeCardView(holder.cardView);
//            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PostedItem postedItem = mPostedList.get(position);
                    JobStudentActivity.startJobStudentActivity(v.getContext(),postedItem.getJob().getId());
                }
            });

        }


        @Override
        public int getItemCount() {
            return list.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;
            CardView cardView;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.text);
                cardView = (CardView) view.findViewById(R.id.cardView);
            }
        }
    }


}
