package com.sleepingsquirrel.service.impl;

import com.sleepingsquirrel.dao.impl.WebContentDaoImpl;
import com.sleepingsquirrel.instance.User;
import com.sleepingsquirrel.instance.WebContent;
import com.sleepingsquirrel.service.twiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class twiterImpl implements twiter {
    @Override
    public int updatecomment(WebContent temp) {
        SimpleDateFormat SDF = new SimpleDateFormat("yyyy-mm-dd HH:MM");
        Date now = new Date();
        temp.setKind("comment");
        temp.setTime(SDF.format(now));
        temp.setNum(temp.getEmail()+temp.getTime());
        WebContentDaoImpl WCDI = new WebContentDaoImpl();
        if (WCDI.add(temp)) return 1;
        return 0;
    }

    @Override
    public int updatepic(WebContent temp) {
        SimpleDateFormat SDF = new SimpleDateFormat("yyyy-mm-dd HH:MM");
        Date now = new Date();
        temp.setKind("picture");
        temp.setTime(SDF.format(now));
        temp.setNum(temp.getEmail()+temp.getTime());
        WebContentDaoImpl WCDI = new WebContentDaoImpl();
        if (WCDI.add(temp)) return 1;
        return 0;
    }

    @Override
    public List<WebContent> getAll(User user) {
        WebContentDaoImpl WCDI = new WebContentDaoImpl();
        return WCDI.getAll(user);
    }
}
