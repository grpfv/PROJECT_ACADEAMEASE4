package com.example.project_acadeamease1;


import com.google.firebase.Timestamp;

public class CourseModel {

    String subject;
    String instructor;
    String caption;
    Timestamp timestamp;

    public CourseModel() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    //public String getCaption() {return caption;}
   // public void setCaption(String caption){this.caption = caption; }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}

