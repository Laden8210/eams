package com.example.eamsmsu.model;

import com.google.gson.annotations.SerializedName;

public class Officer {
    @SerializedName("officerid")
    private String officerId;

    @SerializedName("off_fname")
    private String offFname;

    @SerializedName("off_mname")
    private String offMname;

    @SerializedName("off_lname")
    private String offLname;

    @SerializedName("off_mobile")
    private String offMobile;

    @SerializedName("off_pos")
    private String offPos;

    @SerializedName("off_pic")
    private String offPic;

    @SerializedName("off_username")
    private String offUsername;

    @SerializedName("off_passw")
    private String offPassw;

    @SerializedName("dt_off")
    private String dtOff;

    public Officer() {
    }

    public Officer(String offFname, String offMname, String offLname, String offMobile, String offPos, String offPic, String offUsername, String offPassw, String dtOff) {
        this.offFname = offFname;
        this.offMname = offMname;
        this.offLname = offLname;
        this.offMobile = offMobile;
        this.offPos = offPos;
        this.offPic = offPic;
        this.offUsername = offUsername;
        this.offPassw = offPassw;
        this.dtOff = dtOff;
    }

    public Officer(String officerId, String offFname, String offMname, String offLname, String offMobile, String offPos, String offPic, String offUsername, String offPassw, String dtOff) {
        this.officerId = officerId;
        this.offFname = offFname;
        this.offMname = offMname;
        this.offLname = offLname;
        this.offMobile = offMobile;
        this.offPos = offPos;
        this.offPic = offPic;
        this.offUsername = offUsername;
        this.offPassw = offPassw;
        this.dtOff = dtOff;
    }

    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }

    public String getOffFname() {
        return offFname;
    }

    public void setOffFname(String offFname) {
        this.offFname = offFname;
    }

    public String getOffMname() {
        return offMname;
    }

    public void setOffMname(String offMname) {
        this.offMname = offMname;
    }

    public String getOffLname() {
        return offLname;
    }

    public void setOffLname(String offLname) {
        this.offLname = offLname;
    }

    public String getOffMobile() {
        return offMobile;
    }

    public void setOffMobile(String offMobile) {
        this.offMobile = offMobile;
    }

    public String getOffPos() {
        return offPos;
    }

    public void setOffPos(String offPos) {
        this.offPos = offPos;
    }

    public String getOffPic() {
        return offPic;
    }

    public void setOffPic(String offPic) {
        this.offPic = offPic;
    }

    public String getOffUsername() {
        return offUsername;
    }

    public void setOffUsername(String offUsername) {
        this.offUsername = offUsername;
    }

    public String getOffPassw() {
        return offPassw;
    }

    public void setOffPassw(String offPassw) {
        this.offPassw = offPassw;
    }

    public String getDtOff() {
        return dtOff;
    }

    public void setDtOff(String dtOff) {
        this.dtOff = dtOff;
    }
}
