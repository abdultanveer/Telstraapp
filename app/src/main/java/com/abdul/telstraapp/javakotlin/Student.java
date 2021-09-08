package com.abdul.telstraapp.javakotlin;

public   class Student {

    public static String COLLEGE_NAME = "IIT";

    static  int age = 30;

    public static void main(String[] args) {
        age = 31;
        Person person = new Person("abdul",321);
        person.getName();
    }

}
