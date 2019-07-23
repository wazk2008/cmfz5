package com.baizhi.poi;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.baizhi.entity.Course;
import com.baizhi.entity.User;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.List;

public class EasyIn {

    public static void main(String[] args) throws Exception {
        ImportParams params = new ImportParams();
//
        params.setTitleRows(0);
//
        params.setHeadRows(2);
        long start = new Date().getTime();

        List<Course> list = ExcelImportUtil.importExcel(
                new FileInputStream(new File("D:/后期项目/day7/用户信息easy.xls")),
                Course.class, params);

        System.out.println(new Date().getTime() - start);
        System.out.println(list.size());

        for (Course course : list) {
            System.out.println(course);
        }



    }

}
