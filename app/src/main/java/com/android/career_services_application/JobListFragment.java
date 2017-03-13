package com.android.career_services_application;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.android.careerservices.R;

import java.util.List;

/**
 * Created by icyhot on 25/02/2017.
 */

public class JobListFragment extends Fragment{

    private RecyclerView mJobRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_job_list, container, false);
        mJobRecyclerView = (RecyclerView) view
                .findViewById(R.id.job_recycler_view);
        mJobRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_job_list, menu);
    }

    private void updateUI() {
        JobList jobList = JobList.get(getActivity());
        List<Job> jobs = jobList.getJobs();
        JobAdapter mAdapter = new JobAdapter(jobs);
        mJobRecyclerView.setAdapter(mAdapter);
    }

    private class JobHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Job mJob;
        private TextView mTitleTextView;
        private TextView mCompanyTextView;
        private TextView mLocationTextView;
        private TextView mDescriptionTextView;
        private TextView mDateTextView;

        public JobHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_job, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.job_title);
            mCompanyTextView = (TextView) itemView.findViewById(R.id.job_company);
            mLocationTextView = (TextView) itemView.findViewById(R.id.job_location);
            mDescriptionTextView = (TextView) itemView.findViewById(R.id.job_description);
            //mDateTextView = (TextView) itemView.findViewById(R.id.job_date);
        }

        public void bind(Job job) {
            mJob = job;
            mTitleTextView.setText(mJob.getTitle());
            mCompanyTextView.setText(mJob.getCompany());
            mLocationTextView.setText(mJob.getLocation());
            mDescriptionTextView.setText(mJob.getDescription());
            //mDateTextView.setText(mJob.getDate().toString());
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(),
                    mJob.getTitle() + " clicked!", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    private class JobAdapter extends RecyclerView.Adapter<JobHolder> {
        private List<Job> mJobs;

        public JobAdapter(List<Job> jobs) {
            mJobs = jobs;
        }

        @Override
        public JobHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new JobHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(JobHolder holder, int position) {
            Job job = mJobs.get(position);
            holder.bind(job);
        }

        @Override
        public int getItemCount() {
            return mJobs.size();
        }
    }
}
