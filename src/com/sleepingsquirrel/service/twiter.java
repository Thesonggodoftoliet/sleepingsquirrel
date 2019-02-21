package com.sleepingsquirrel.service;

import com.sleepingsquirrel.instance.User;
import com.sleepingsquirrel.instance.WebContent;

import java.util.List;

public interface twiter {
    int updatecomment(WebContent temp);

    int updatepic(WebContent temp);

    List<WebContent> getAll(User user);
}
