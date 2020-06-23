package com.entity;

public class Student {
    private int sno;
    private String sname;

    public Student() {
        super();
    }

    public Student(int sno, String sname) {
        super();
        this.sno = sno;
        this.sname = sname;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Student [sno=" + sno + ", sname=" + sname + "]";
    }
}
