package models;

public class Student {
    private int id;
    private String name, reg;
    private int age;
    private float per;

    public Student(int id, String name, String reg, int age, float per) {
        this.id = id;
        this.name = name;
        this.reg = reg;
        this.age = age;
        this.per = per;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getReg() { return reg; }
    public int getAge() { return age; }
    public float getPer() { return per; }

}