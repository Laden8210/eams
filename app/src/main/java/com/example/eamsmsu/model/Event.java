package com.example.eamsmsu.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Event implements Parcelable {

    @SerializedName("eventid")
    private int eventId;

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

    @SerializedName("officer_id")
    private int officerId;

    @SerializedName("program_idd")
    private String programId;

    @SerializedName("time_in_morning")
    private String timeInMorning;

    @SerializedName("time_out_morning")
    private String timeOutMorning;

    @SerializedName("time_in_afternoon")
    private String timeInAfternoon;

    @SerializedName("time_out_afternoon")
    private String timeOutAfternoon;

    @SerializedName("amount")
    private String amount;

    @SerializedName("sem")
    private String semester;

    @SerializedName("dt_event")
    private String dateTimeEvent;

    @SerializedName("program")
    private String program;

    public Event() {
    }

    public Event(int eventId, String titleEvent, String venue, String duration, String from, String to, int officerId, String programId, String timeInMorning, String timeOutMorning, String timeInAfternoon, String timeOutAfternoon, String amount, String semester, String dateTimeEvent, String program) {
        this.eventId = eventId;
        this.titleEvent = titleEvent;
        this.venue = venue;
        this.duration = duration;
        this.from = from;
        this.to = to;
        this.officerId = officerId;
        this.programId = programId;
        this.timeInMorning = timeInMorning;
        this.timeOutMorning = timeOutMorning;
        this.timeInAfternoon = timeInAfternoon;
        this.timeOutAfternoon = timeOutAfternoon;
        this.amount = amount;
        this.semester = semester;
        this.dateTimeEvent = dateTimeEvent;
        this.program = program;
    }

    protected Event(Parcel in) {
        eventId = in.readInt();
        titleEvent = in.readString();
        venue = in.readString();
        duration = in.readString();
        from = in.readString();
        to = in.readString();
        officerId = in.readInt();
        programId = in.readString();
        timeInMorning = in.readString();
        timeOutMorning = in.readString();
        timeInAfternoon = in.readString();
        timeOutAfternoon = in.readString();
        amount = in.readString();
        semester = in.readString();
        dateTimeEvent = in.readString();
        program = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(eventId);
        dest.writeString(titleEvent);
        dest.writeString(venue);
        dest.writeString(duration);
        dest.writeString(from);
        dest.writeString(to);
        dest.writeInt(officerId);
        dest.writeString(programId);
        dest.writeString(timeInMorning);
        dest.writeString(timeOutMorning);
        dest.writeString(timeInAfternoon);
        dest.writeString(timeOutAfternoon);
        dest.writeString(amount);
        dest.writeString(semester);
        dest.writeString(dateTimeEvent);
        dest.writeString(program);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
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

    public int getOfficerId() {
        return officerId;
    }

    public void setOfficerId(int officerId) {
        this.officerId = officerId;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getTimeInMorning() {
        return timeInMorning;
    }

    public void setTimeInMorning(String timeInMorning) {
        this.timeInMorning = timeInMorning;
    }

    public String getTimeOutMorning() {
        return timeOutMorning;
    }

    public void setTimeOutMorning(String timeOutMorning) {
        this.timeOutMorning = timeOutMorning;
    }

    public String getTimeInAfternoon() {
        return timeInAfternoon;
    }

    public void setTimeInAfternoon(String timeInAfternoon) {
        this.timeInAfternoon = timeInAfternoon;
    }

    public String getTimeOutAfternoon() {
        return timeOutAfternoon;
    }

    public void setTimeOutAfternoon(String timeOutAfternoon) {
        this.timeOutAfternoon = timeOutAfternoon;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDateTimeEvent() {
        return dateTimeEvent;
    }

    public void setDateTimeEvent(String dateTimeEvent) {
        this.dateTimeEvent = dateTimeEvent;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
