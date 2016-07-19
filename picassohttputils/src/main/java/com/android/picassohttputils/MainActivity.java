package com.android.picassohttputils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.sql.SQLException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private Data mData;
    private MyAdapter adapter;
    private DBManager mManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView= (ListView) findViewById(R.id.lv);
        try {
            mManager=new DBManager(this);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setData();
    }

    private void setData() {
        OkHttpUtils.get().url(Content.URL).build().execute(new Callback<Data>() {
            @Override
            public Data parseNetworkResponse(Response response) throws Exception {
                String jsonStr=response.body().string();
                mManager.insert(Content.URL,jsonStr);
                Gson gson=new Gson();
                mData = gson.fromJson(jsonStr, Data.class);
                return mData;
            }

            @Override
            public void onError(Call call, Exception e) {
                try {
                    List<User> query = mManager.query(Content.URL);
                    User user = query.get(0);
                    String jsonStr=user.getJsonStr();
                    Gson gson=new Gson();
                    Data data1 = gson.fromJson(jsonStr, Data.class);
                    adapter=new MyAdapter(data1);
                    mListView.setAdapter(adapter);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void onResponse(Call call, Data data) {
                adapter=new MyAdapter(mData);
                mListView.setAdapter(adapter);
            }
        });
    }
}
