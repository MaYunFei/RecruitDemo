package com.demo.kaiyun.androiddemo.ui.student;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.kaiyun.androiddemo.App;
import com.demo.kaiyun.androiddemo.R;
import com.demo.kaiyun.androiddemo.base.BaseFragment;
import com.demo.kaiyun.androiddemo.base.ResponseHandle;
import com.demo.kaiyun.androiddemo.bean.Company;
import com.demo.kaiyun.androiddemo.http.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView mRvMain;
    private ArrayList<String> array = new ArrayList<>();
    private CardListAdapter adapter;
    private SwipeRefreshLayout mRefreshLayout;
    private List<Company> mCompanyList = new ArrayList<>();

    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.home_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);

        mRvMain = (RecyclerView) view.findViewById(R.id.rv_main);
        mRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.refreshLayout);
        mRefreshLayout.setOnRefreshListener(this);
        FragmentActivity activity = getActivity();
        getData();


        adapter = new CardListAdapter(view.getContext(),array);
        mRvMain.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvMain.setAdapter(adapter);

    }

    private void getData(){
        mApiService.getCompanyList().enqueue(new ResponseHandle<List<Company>>() {
            @Override
            protected void onSuccess(List<Company> data) {
                mCompanyList.clear();
                mCompanyList.addAll(data);
                for (Company company : data) {
                    array.add(company.getName() +"\n " + company.getIntroduce());
                    if (mRefreshLayout != null){
                        mRefreshLayout.setRefreshing(false);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onRefresh() {
        getData();
    }


    public class CardListAdapter  extends RecyclerView.Adapter<CardListAdapter.MyViewHolder>{
        private Context context;
        private ArrayList<String> list ;
//        private IcardViewChanger icardViewChanger;
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
                    Company company = mCompanyList.get(position);

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
