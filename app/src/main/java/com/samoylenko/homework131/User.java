package com.samoylenko.homework131;

public class User {
    private String fmn;
    private Integer age;

    public User() {
    }

    User(String fmn, Integer age) {
        this.fmn = fmn;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "ФИО = '" + fmn + '\'' +
                ", возраст = " + age +
                '}';
    }

    public String getFmn() {
        return fmn;
    }

    public void setFmn(String fmn) {
        this.fmn = fmn;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
