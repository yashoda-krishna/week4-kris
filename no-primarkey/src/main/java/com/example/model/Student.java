package com.example.model;



public class Student {
    private String name;
    private int age;
    private String course;

    public Student() { }

    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public String getName() { return name; }
    public Student setName(String name) { this.name = name; return this; }

    public int getAge() { return age; }
    public Student setAge(int age) { this.age = age; return this; }

    public String getCourse() { return course; }
    public Student setCourse(String course) { this.course = course; return this; }

    @Override
    public String toString() {
        return "Student{name='%s', age=%d, course='%s'}".formatted(name, age, course);
    }
}
