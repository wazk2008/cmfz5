//package com.baizhi.poi;
//
//import cn.afterturn.easypoi.excel.ExcelExportUtil;
//import cn.afterturn.easypoi.excel.entity.ExportParams;
//import com.baizhi.entity.User;
//import org.apache.poi.ss.usermodel.Workbook;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class EasyOut {
//
//    public static void main(String[] args) throws Exception {
//        //以单表的user为例
//        List<User> list = new ArrayList<User>();
//        for (int i = 0; i < 10; i++) {
//            User user = new User();
//            user.setId(i+"");
//            user.setName("张三"+i+"号");
//            user.setSex("男");
////            user.setSex("C:/Users/Public/Pictures/Sample Pictures/Desert.jpg");
//            user.setBir(new Date());
//            list.add(user);
//        }
//
//        //开始easypoi导出
//        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生表"),
//                User.class, list);
//
//        workbook.write(new FileOutputStream(new File("D:/后期项目/day7/用户信息easy.xls")));
//
//
//    }
//
//}
