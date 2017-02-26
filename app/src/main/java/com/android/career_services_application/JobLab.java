package com.android.career_services_application;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by icyhot on 25/02/2017.
 */

public class JobLab {

    private static JobLab sJobLab;
    private List<Job> mJobs;

    public static JobLab get(Context context) {
        if (sJobLab == null) {
            sJobLab = new JobLab(context);
        }
        return sJobLab;
    }

    private JobLab(Context context) {
        mJobs = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Job job = new Job();
            job.setTitle("Job #" + i);
            job.setSolved(i % 2 == 0);
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
