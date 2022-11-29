package org.example;

public class Task2_User {
    private String name;
    private int age;

    Task2_User(String name, int age) {
        this.name = name;
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException();
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "{name: " + getName() + ", age: " + getAge() + "}";
    }
}
