package com.example.eamsmsu.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Student implements Parcelable {

    @SerializedName("studentid")
    private String studentId;

    @SerializedName("student_id")
    private String studentIdNumber;

    @SerializedName("stud_fname")
    private String firstName;

    @SerializedName("stud_mname")
    private String middleName;

    @SerializedName("stud_lname")
    private String lastName;

    @SerializedName("stud_programid")
    private String programId;

    @SerializedName("yrlevel")
    private String yearLevel;

    @SerializedName("stud_section")
    private String section;

    @SerializedName("stud_mobile")
    private String mobile;

    @SerializedName("stud_profpic")
    private String profilePicture;

    @SerializedName("stud_username")
    private String username;

    @SerializedName("stud_password")
    private String password;

    @SerializedName("dt_student")
    private String dateTime;

    @SerializedName("program")
    private String program;

    public Student() {
    }


    public Student(String studentId, String studentIdNumber, String firstName, String middleName, String lastName, String programId, String yearLevel, String section, String mobile, String profilePicture, String username, String password, String dateTime, String program) {
        this.studentId = studentId;
        this.studentIdNumber = studentIdNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.programId = programId;
        this.yearLevel = yearLevel;
        this.section = section;
        this.mobile = mobile;
        this.profilePicture = profilePicture;
        this.username = username;
        this.password = password;
        this.dateTime = dateTime;
        this.program = program;
    }

    protected Student(Parcel in) {
        studentId = in.readString();
        studentIdNumber = in.readString();
        firstName = in.readString();
        middleName = in.readString();
        lastName = in.readString();
        programId = in.readString();
        yearLevel = in.readString();
        section = in.readString();
        mobile = in.readString();
        profilePicture = in.readString();
        username = in.readString();
        password = in.readString();
        dateTime = in.readString();
        program = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentIdNumber() {
        return studentIdNumber;
    }

    public void setStudentIdNumber(String studentIdNumber) {
        this.studentIdNumber = studentIdNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(String yearLevel) {
        this.yearLevel = yearLevel;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(studentId);
        parcel.writeString(studentIdNumber);
        parcel.writeString(firstName);
        parcel.writeString(middleName);
        parcel.writeString(lastName);
        parcel.writeString(programId);
        parcel.writeString(yearLevel);
        parcel.writeString(section);
        parcel.writeString(mobile);
        parcel.writeString(profilePicture);
        parcel.writeString(username);
        parcel.writeString(password);
        parcel.writeString(dateTime);
        parcel.writeString(program);
    }
}
