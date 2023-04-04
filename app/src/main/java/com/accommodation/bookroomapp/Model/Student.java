package com.accommodation.bookroomapp.Model;

public class Student {

    String regNo;
    String hostel;
    int room;


    public Student() {
    }

    public Student(String regNo, String hostel, int room) {
        this.regNo = regNo;
        this.hostel = hostel;
        this.room = room;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getHostel() {
        return hostel;
    }

    public void setHostel(String hostel) {
        this.hostel = hostel;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
}
