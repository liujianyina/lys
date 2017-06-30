package com.yznu.lys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 刘剑银 on 2017/6/27.
 */
public class BaseController {

    @Autowired
    private HttpServletRequest request;


    @Autowired
    protected HttpSession session;

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpSession getSession() {
        return session;
    }
}

