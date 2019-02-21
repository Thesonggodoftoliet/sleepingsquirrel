package com.sleepingsquirrel.dao;

import com.sleepingsquirrel.instance.User;
import com.sleepingsquirrel.instance.WebContent;

import java.util.List;

public interface WebContentDao {
    boolean add(WebContent web);

    List getAll(User user);
}
