package com.baizhi.poi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.Course;
import com.baizhi.entity.Student;
import com.baizhi.entity.Teacher;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EasyOut2 {

    public static void main(String[] args) throws Exception {
//        模拟数据
        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Course course = new Course();
            course.setId("c"+i);
            course.setName("java"+i+"班");
            course.setTeacher(new Teacher("t"+i,"李老师"+i+"号"));
            List<Student> list = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                Student student = new Student();
                student.setId("s"+j);
                student.setName("老王"+j+"号");
//                student.setPhoto("C:/Users/Public/Pictures/Sample Pictures/Desert.jpg");
                student.setPhoto("女");
                student.setBir(new Date());
                list.add(student);
            }
            course.setStudents(list);
            courses.add(course);
        }
        //导出
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("测试1","课程学生信息表"),
                Course.class, courses);

        workbook.write(new FileOutputStream(new File("D:/后期项目/day7/用户信息easy.xls")));





    }



}
