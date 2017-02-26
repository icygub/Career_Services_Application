package com.android.career_services_application;

import java.util.Date;
import java.util.UUID;

/**
 * Created by icyhot on 24/02/2017.
 */

public class Job {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

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

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
