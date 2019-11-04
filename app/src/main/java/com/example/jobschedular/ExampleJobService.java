package com.example.jobschedular;

import android.app.job.JobParameters;
import android.app.job.JobService;
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
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this,1000);
                Log.e(TAG, "run: " + j++);
            }
        };
        runnable.run();

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
        jobFinished(params, true);
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.e(TAG, "Job cancelled before completion");
        jobCancelled = true;
        return true;
    }
}
