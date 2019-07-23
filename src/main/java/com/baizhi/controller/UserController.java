package com.baizhi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("user")
@RestController
public class UserController {


    @RequestMapping("out")
    public void out(HttpServletRequest request, HttpServletResponse resp) throws Exception {

//        做文件的导出
//        1.注入userService查询出所有的用户   list

//        2.导出

        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i+"");
//            user.setName("张三"+i+"号");
            user.setSex("男");
//            user.setBir(new Date());
            list.add(user);
        }

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生表"),
                User.class, list);



        String fileName = "用户报表("+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+").xls";

        fileName = new String(fileName.getBytes("gbk"),"iso-8859-1");
        resp.setContentType("application/vnd.ms-excel");
        resp.setHeader("content-disposition","attachment;filename="+fileName);
        workbook.write(resp.getOutputStream());

    }


}
