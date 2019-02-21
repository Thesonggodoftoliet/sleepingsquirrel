package com.sleepingsquirrel.dao.impl;

import com.sleepingsquirrel.dao.WebContentDao;
import com.sleepingsquirrel.instance.User;
import com.sleepingsquirrel.instance.WebContent;
import com.sleepingsquirrel.utils.JdbcUtils;

import java.util.List;

public class WebContentDaoImpl implements WebContentDao {
    @Override
    public boolean add(WebContent web) {
        String sql = "insert into webcontent values(?,?,?,?,?);";
        int tag = JdbcUtils.executeSQL(sql, web.getNum(),web.getEmail(),web.getTime(),web.getKind(),web.getContent());
        if (tag == 1) return true;
        return false;
    }

    @Override
    public List getAll(User user) {
        String sql = "select * from webcontent where email ="+user.getUseremail();
        return JdbcUtils.getList(WebContent.class,sql);
    }
}
