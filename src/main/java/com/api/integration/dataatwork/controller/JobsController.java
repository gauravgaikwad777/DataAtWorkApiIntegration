package com.api.integration.dataatwork.controller;

import com.api.integration.dataatwork.manager.JobManager;
import com.api.integration.dataatwork.model.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class JobsController {

    @Autowired
    JobManager jobManager;

    @GetMapping("/api/jobs")
    public JobDetail getJobsForSkills(@RequestParam(value = "skill", defaultValue = "engineering and technology") String skill) {
        return jobManager.getJobsForSkill(skill);
    }
    @ExceptionHandler({Exception.class})
    public void handleError(HttpServletRequest req, HttpServletResponse res, Exception ex) throws IOException {
        res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        res.getWriter().write(ex.getMessage());
        res.getWriter().flush();
        res.getWriter().close();
    }
}
