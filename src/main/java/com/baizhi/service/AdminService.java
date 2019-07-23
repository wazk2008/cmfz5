package com.baizhi.service;

import com.baizhi.entity.Album;

import javax.servlet.http.HttpServletRequest;

public interface AdminService {
    /**
     * 管理员登录
     * @param username
     * @param password
     * @param enCode
     */
    void login(String username, String password, String enCode, HttpServletRequest request);




}
