
package com.shilpa.recordfilter.entity;


public class Enquiry {
   private int id;
   private Course course;
   private String firstName,lastName,email;
   private int courseId; 

    public Enquiry() {
    }

    public Enquiry(int id, Course course,int courseId, String firstName, String lastName, String email) {
        this.id = id;
        this.course = course;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.courseId= courseId;
    }

    public int getId() {
        return id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
