package com.demo.kaiyun.androiddemo.ui.student;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.demo.kaiyun.androiddemo.R;
import com.demo.kaiyun.androiddemo.base.BaseFragment;
import com.demo.kaiyun.androiddemo.base.ResponseHandle;
import com.demo.kaiyun.androiddemo.bean.Job;
import com.demo.kaiyun.androiddemo.bean.SendedJob;
import com.demo.kaiyun.androiddemo.ui.LoginActivity;
import com.demo.kaiyun.androiddemo.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;


public class MeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    private ArrayList<String> array = new ArrayList<>();
    private RecyclerView mRvMain;
    private CardListAdapter adapter;
    private SwipeRefreshLayout mRefreshLayout;
    private List<SendedJob> sendedJobList = new ArrayList<>();



    private Button btnExit;

    public MeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        initView(view);
        return view;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        mRvMain = (RecyclerView) view.findViewById(R.id.rv_main);
        mRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.refreshLayout);
        mRefreshLayout.setOnRefreshListener(this);
        adapter = new CardListAdapter(view.getContext(),array);
        mRvMain.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvMain.setAdapter(adapter);

        getData();

    }

    private void getData(){
        mApiService.getJob(SPUtils.getUserId())
                .enqueue(new ResponseHandle<List<SendedJob>>() {
                    @Override
                    protected void onSuccess(List<SendedJob> data) {
                        sendedJobList.clear();
                        sendedJobList.addAll(data);
                        array.clear();
                        for (SendedJob sendedJob : data) {
                            array.add(sendedJob.getCompany().getName() +"\n" + sendedJob.getJob().getName());

                        }
                        adapter.notifyDataSetChanged();
                        mRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    protected void onError() {
                        super.onError();
                        mRefreshLayout.setRefreshing(false);
                    }
                });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void initView(View view) {
        btnExit = (Button) view.findViewById(R.id.btn_exit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SPUtils.clearUserId();
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().finish();
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
//                    Job job = mJobList.get(position);
//                    JobInfoActivity.startJobInfoActivity(context,job);
//                    JobListActivity.startJobList(getContext(),company);
                    SendedJob sendedJob = sendedJobList.get(position);
                    Job job = sendedJob.getJob();
                    JobInfoActivity.startJobInfoActivity(context,job);

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
