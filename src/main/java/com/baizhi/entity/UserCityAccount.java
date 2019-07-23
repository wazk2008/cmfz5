package com.baizhi.entity;

public class UserCityAccount {
    private String name;    //name
    private Integer value;    //value

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public UserCityAccount() {
    }

    public UserCityAccount(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "UserCityAccount{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
