package com.android.picassohttputils;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/7/16.
 */
public class DBManager {
    private Dao mDao;
    public DBManager(Context context) throws SQLException {
        DBHelper mHelp=new DBHelper(context);
        mDao=mHelp.getDao(User.class);
    }
    public void insert(String url,String jsonStr) throws SQLException {
        User user=new User();
        user.setJsonStr(jsonStr);
        user.setUrl(url);
        List<User> list = mDao.queryForEq("url", url);
        if(list==null ||list.size()==0){
            mDao.create(user);
        }else {
            User u = list.get(0);
            mDao.delete(u);
            mDao.create(user);
        }
    }
    public List<User> query(String url) throws SQLException {
        List<User> list = mDao.queryForEq("url", url);
        return list;
    }
}
