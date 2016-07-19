package com.android.ormlitedemo;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2016/7/15.
 */
public class DBManager {
    private Dao mDao;
    private DBHelper mDBHelper;
    private Context mContext;
    public DBManager(Context mContext) throws SQLException {
        mDBHelper=new DBHelper(mContext);
        mDao=mDBHelper.getDao(Student.class);
    }
    public void insert(Student student) throws SQLException {
        mDao.create(student);
    }
    public List<Student> queryAll() throws SQLException {
        List list = mDao.queryForAll();
        return list;
    }
    public void delete(Student student) throws SQLException {
        mDao.delete(student);
    }
    public void update(Student student) throws SQLException {
        student.setName("小泽玛利亚");
        student.setAge(38);
        mDao.createOrUpdate(student);
    }
    public List<Student> queryForTerm() throws SQLException {
        QueryBuilder builder=mDao.queryBuilder();
        builder.where().eq("name","苍井空");
        builder.orderBy("id",true);
        List list = builder.query();
        return list;
    }
    public void deleteBatch(String name) throws SQLException {
        DeleteBuilder builder=mDao.deleteBuilder();
        builder.where().eq("name",name);
        builder.delete();
    }
    public void updateBatch(String name , int age) throws SQLException {
        UpdateBuilder builder=mDao.updateBuilder();
        builder.where().eq("name",name);
        builder.updateColumnValue("age",age);
        builder.update();
    }
    public void insertBatch() throws Exception {
        mDao.callBatchTasks(new Callable() {
            @Override
            public Object call() throws Exception {
                for (int i = 0; i <10 ; i++) {
                    Student s=new Student();
                    s.setAge(30);
                    s.setName("吉泽明步");
                    mDao.create(s);
                }
                return null;
            }
        });
    }
}
