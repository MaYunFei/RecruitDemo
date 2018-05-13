package com.demo.kaiyun.androiddemo.ui.student;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.kaiyun.androiddemo.R;
import com.demo.kaiyun.androiddemo.base.BaseActivity;
import com.demo.kaiyun.androiddemo.base.ResponseHandle;
import com.demo.kaiyun.androiddemo.bean.Company;
import com.demo.kaiyun.androiddemo.bean.Job;

import java.util.ArrayList;
import java.util.List;

public class JobListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {
    private Company mCompany;
    private List<Job> mJobList = new ArrayList<>();

    private ArrayList<String> array = new ArrayList<>();
    private RecyclerView mRvMain;
    private CardListAdapter adapter;
    private SwipeRefreshLayout mRefreshLayout;
//    private TextView mTvName,mTvintroduce,mTvAddress;


    public static void startJobList(Context context, Company company){
        Intent intent = new Intent(context,JobListActivity.class);
        intent.putExtra("data",company);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRvMain = (RecyclerView) findViewById(R.id.rv_main);
        mRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.refreshLayout);
        mRefreshLayout.setOnRefreshListener(this);
        adapter = new CardListAdapter(this,array);
        mRvMain.setLayoutManager(new LinearLayoutManager(this));
        mRvMain.setAdapter(adapter);


        mCompany = (Company) getIntent().getSerializableExtra("data");
        if (mCompany == null){
            showMessage("数据错误");
            finish();
            return;
        }
        setTitle(mCompany.getName()+" 招聘职位");
        ((TextView)findViewById(R.id.tv_name)).setText(mCompany.getName());
        ((TextView)findViewById(R.id.tv_introduce)).setText(mCompany.getIntroduce());
        ((TextView)findViewById(R.id.tv_address)).setText(mCompany.getAddress());
        getData();
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (!isFinishing()) {
            onBackPressed();
        }
        return super.onSupportNavigateUp();
    }

    @Override
    public void onRefresh() {
        getData();
    }

    private void getData() {
        mApiService.getJobByCompanyId(mCompany.getId())
                .enqueue(new ResponseHandle<List<Job>>() {
                    @Override
                    protected void onSuccess(List<Job> data) {
                        mJobList.clear();
                        mJobList.addAll(data);
                        array.clear();
                        for (Job job : data) {
                            array.add(job.getName() +"\n" + "专业：" + job.getEducation()+"\n"+"薪资："+job.getMoney());

                            if (mRefreshLayout != null){
                                mRefreshLayout.setRefreshing(false);
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }

    public class CardListAdapter  extends RecyclerView.Adapter<CardListAdapter.MyViewHolder>{
        private Context context;
        private ArrayList<String> list ;
        public CardListAdapter(Context context,ArrayList<String> list){
            this.context = context;
            this.list = list;
        }
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    context).inflate(R.layout.fragment_home_item, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.tv.setText(list.get(position));
//            if (icardViewChanger!=null){
//                icardViewChanger.changeCardView(holder.cardView);
//            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Job job = mJobList.get(position);
//                    JobListActivity.startJobList(getContext(),company);

                }
            });

        }


        @Override
        public int getItemCount() {
            return list.size();
        }
        class MyViewHolder extends RecyclerView.ViewHolder
        {

            TextView tv;
            CardView cardView;
            public MyViewHolder(View view)
            {
                super(view);
                tv = (TextView) view.findViewById(R.id.text);
                cardView = (CardView) view.findViewById(R.id.cardView);
            }
        }
    }
}
