package com.example.jobschedular;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ExampleJobService extends JobService {
    private static final String TAG = "ExampleJobService";
    private boolean jobCancelled = false;

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.e(TAG, "Job started");
        doBackgroundWork(params);

        return true;
    }

    int j;
    private void doBackgroundWork(final JobParameters params)
    {
        Log.e(TAG, "run: " + j++);


        /*for (int i = 0; i < 10; i++) {
            Log.e(TAG, "run: " + i);
            //Toast.makeText(getApplicationContext(),i+"",Toast.LENGTH_SHORT).show();
            if (jobCancelled) {
                return;
            }
        }*/
        //new MainActivity().scheduleJob(new View(this));

        Log.e(TAG, "Job finished");
//        new MainActivity().scheduleJob(null);
        jobFinished(params, false);

        rescheduleJob();

    }

    private void rescheduleJob() {
        ComponentName componentName = new ComponentName(this, ExampleJobService.class);
        JobInfo info = new JobInfo.Builder(123, componentName)
                //.setRequiresCharging(true)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setPersisted(true)
                //.setPeriodic(321)
                .build();

        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        int resultCode = scheduler.schedule(info);
        if (resultCode == JobScheduler.RESULT_SUCCESS) {
            Log.e(TAG, "Job scheduled");
        } else {
            Log.e(TAG, "Job scheduling failed");
        }
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.e(TAG, "Job cancelled before completion");
        jobCancelled = true;
        return true;
    }
}
