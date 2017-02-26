package com.android.career_services_application;

import android.support.v4.app.Fragment;

/**
 * Created by icyhot on 25/02/2017.
 */

public class JobListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new JobListFragment();
    }
}
