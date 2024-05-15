package com.jobhunter.mapper;

import com.jobhunter.model.Job;

public interface JobUpdater extends Updater<Job>{

    @Override
    Job update(Job oldJob, Job newJob);

}
