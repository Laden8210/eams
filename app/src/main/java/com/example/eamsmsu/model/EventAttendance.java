package com.example.eamsmsu.model;

import com.google.gson.annotations.SerializedName;

public class EventAttendance {
    @SerializedName("eventid")
    private String eventId;

    @SerializedName("title_event")
    private String titleEvent;

    @SerializedName("venue")
    private String venue;

    @SerializedName("duration")
    private String duration;

    @SerializedName("from_")
    private String from;

    @SerializedName("to_")
    private String to;

    @SerializedName("student_id")
    private String studentId;

    @SerializedName("stud_fname")
    private String studFname;

    @SerializedName("stud_lname")
    private String studLname;

    @SerializedName("attendance_details")
    private String attendanceDetails;

    @SerializedName("program")
    private String program;

    @SerializedName("yrlevel")
    private String yrlevel;
    @SerializedName("stud_section")
    private String studSection;


    public EventAttendance(String eventId, String titleEvent, String venue, String duration, String from, String to, String studentId, String studFname, String studLname, String attendanceDetails, String program, String yrlevel, String studSection) {
        this.eventId = eventId;
        this.titleEvent = titleEvent;
        this.venue = venue;
        this.duration = duration;
        this.from = from;
        this.to = to;
        this.studentId = studentId;
        this.studFname = studFname;
        this.studLname = studLname;
        this.attendanceDetails = attendanceDetails;
        this.program = program;
        this.yrlevel = yrlevel;
        this.studSection = studSection;
    }

    public EventAttendance() {
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getTitleEvent() {
        return titleEvent;
    }

    public void setTitleEvent(String titleEvent) {
        this.titleEvent = titleEvent;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudFname() {
        return studFname;
    }

    public void setStudFname(String studFname) {
        this.studFname = studFname;
    }

    public String getStudLname() {
        return studLname;
    }

    public void setStudLname(String studLname) {
        this.studLname = studLname;
    }

    public String getAttendanceDetails() {
        return attendanceDetails;
    }

    public void setAttendanceDetails(String attendanceDetails) {
        this.attendanceDetails = attendanceDetails;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getYrlevel() {
        return yrlevel;
    }

    public void setYrlevel(String yrlevel) {
        this.yrlevel = yrlevel;
    }

    public String getStudSection() {
        return studSection;
    }

    public void setStudSection(String studSection) {
        this.studSection = studSection;
    }
}
