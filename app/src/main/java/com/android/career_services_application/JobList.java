package com.android.career_services_application;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by icyhot on 25/02/2017.
 * This class will eventually be substituted by the Database class.
 */

public class JobList {

    private static JobList sJobList;
    private List<Job> mJobs;

    public static JobList get(Context context) {
        if (sJobList == null) {
            sJobList = new JobList(context);
        }
        return sJobList;
    }

    private JobList(Context context) {
        mJobs = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Job job = new Job();
            job.setTitle("Job #" + i);
            mJobs.add(job);
        }
    }

    public List<Job> getJobs() {
        return mJobs;
    }

    public Job getJob(UUID id) {
        for (Job job : mJobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }

        return null;
    }
}
