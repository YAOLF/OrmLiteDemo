package com.android.ormlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private List<Student> mList;
    private MyAdapter mAdapter;
    private DBManager mManager;
    private Button mBtnInsert,mBtnQuery,mBtnUpdateBatch,mBtnDeleteBatch,mBtnInsertBatch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        try {
            mManager=new DBManager(this);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        mBtnInsert= (Button) findViewById(R.id.inset);
        mBtnQuery= (Button) findViewById(R.id.querytrem);
        mBtnUpdateBatch= (Button) findViewById(R.id.updatebatch);
        mBtnDeleteBatch= (Button) findViewById(R.id.deletebatch);
        mBtnInsertBatch= (Button) findViewById(R.id.insetbatch);
        mBtnInsert.setOnClickListener(this);
        mBtnQuery.setOnClickListener(this);
        mBtnUpdateBatch.setOnClickListener(this);
        mBtnDeleteBatch.setOnClickListener(this);
        mBtnInsertBatch.setOnClickListener(this);
        mRecyclerView= (RecyclerView) findViewById(R.id.rv);
        mAdapter=new MyAdapter();
        mAdapter.setList(new ArrayList<Student>());
        mAdapter.setOnRecyclerItemClickListener(new MyAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onRecyclerItemClick(int position) {
                try {
                    mManager.delete(mList.get(position));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                query();
            }
        });
        mAdapter.setOnRecyclerItemLongClickListener(new MyAdapter.OnRecyclerItemLongClickListener() {
            @Override
            public void onRecyclerItemLongClick(int position) {
                try {
                    mManager.update(mList.get(position));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                query();
            }
        });
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);


    }
    public void query(){
        try {
            mList= mManager.queryAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mAdapter.setList(mList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.inset:
                Student s=new Student();
                s.setName("苍井空");
                s.setAge(28);
                try {
                    mManager.insert(s);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                query();
                break;
            case R.id.querytrem:
                try {
                   mList= mManager.queryForTerm();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                mAdapter.setList(mList);
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.deletebatch:
                try {
                    mManager.deleteBatch("苍井空");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                query();
                break;
            case R.id.updatebatch:
                try {
                    mManager.updateBatch("吉泽明步",33);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                query();
                break;
            case R.id.insetbatch:
                try {
                    mManager.insertBatch();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                query();
                break;
        }
    }
}
