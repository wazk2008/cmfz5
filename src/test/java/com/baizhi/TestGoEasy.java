package com.baizhi;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import io.goeasy.GoEasy;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestGoEasy {

    @Test
    public void test1(){

        //第一个参数：REST Host       第二个参数：appks
        GoEasy goEasy = new GoEasy( "http://rest-hangzhou.goeasy.io","BC-268c25f44f5841ff93a8f4e6aa24193a");
//        第一个参数：channel的名称      第二个参数：发送的内容
        goEasy.publish("154-test", "Hello, world!");

    }








}
