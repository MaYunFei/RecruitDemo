package com.demo.kaiyun.androiddemo.ui.company;

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
import com.demo.kaiyun.androiddemo.bean.Student;

import java.util.ArrayList;
import java.util.List;

public class JobStudentActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private int jobId;
    List<Student> studentList = new ArrayList<>();
    private ArrayList<String> array = new ArrayList<>();
    private RecyclerView mRvMain;
    private SwipeRefreshLayout mRefreshLayout;
    private CardListAdapter adapter;

    public static void startJobStudentActivity(Context context, int jobId){
        Intent intent = new Intent(context,JobStudentActivity.class);
        intent.putExtra("data",jobId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_student);
        jobId = getIntent().getIntExtra("data", -1);
        if (jobId == -1){
            finish();
            return;
        }
        setTitle("投递学生列表");

        mRvMain = (RecyclerView) findViewById(R.id.rv_main);
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refreshLayout);
        mRefreshLayout.setOnRefreshListener(this);
        adapter = new CardListAdapter(this,array);
        mRvMain.setLayoutManager(new LinearLayoutManager(this));
        mRvMain.setAdapter(adapter);
        getData();

    }

    @Override
    public void onRefresh() {
        getData();
    }

    private void getData() {
        mApiService.queryStudentByJobId(jobId).enqueue(new ResponseHandle<List<Student>>() {
            @Override
            protected void onSuccess(List<Student> data) {

                studentList.clear();
                studentList.addAll(data);
                array.clear();
                for (Student student : data) {
                    array.add("姓名：" +student.getName() + "\n "
                            + "性别 ：" + student.getSex() + "年龄 ："+ student.getAgo()+ "\n "
                            +"经验：" +student.getExperience());
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
                    Student student = studentList.get(position);
//                    JobStudentActivity.startJobStudentActivity(v.getContext(),postedItem.getJob().getId());
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
