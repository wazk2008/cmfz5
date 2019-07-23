package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.util.Date;

@ExcelTarget(value = "Student")
public class Student {
    @Excel(name = "学号")
    private String id;
    @Excel(name = "姓名")
    private String name;
    @Excel(name = "性别")
    private String photo;
    @Excel(name = "生日",format = "yyyy-MM-dd HH:mm:ss")
    private Date bir;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public Student() {
    }

    public Student(String id, String name, String photo, Date bir) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.bir = bir;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", bir=" + bir +
                '}';
    }
}
