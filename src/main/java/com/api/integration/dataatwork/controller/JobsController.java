package com.api.integration.dataatwork.controller;

import com.api.integration.dataatwork.manager.JobManager;
import com.api.integration.dataatwork.model.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobsController {

    @Autowired
    JobManager jobManager;

    @GetMapping("/api/jobs")
    public JobDetail getJobsForSkills(@RequestParam(value = "skill", defaultValue = "engineering and technology") String skill) {
        return jobManager.getJobsForSkill(skill);
    }
}
