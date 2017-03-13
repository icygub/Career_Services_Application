package com.android.career_services_application;

import java.util.Date;
import java.util.UUID;

/**
 * Created by icyhot on 24/02/2017.
 */

public class Job {

    private UUID mId;
    private String mTitle;
    private String mCompany;
    private String mLocation;
    private String mDescription;
    private Date mDate;

    public Job() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void setCompany(String company) {
        this.mCompany = company;
    }

    public String getCompany() {
        return mCompany;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        this.mLocation = location;
    }



    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

}
