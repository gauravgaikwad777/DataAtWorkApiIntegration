package com.api.integration.dataatwork.manager;

import com.api.integration.dataatwork.model.JobDetail;
import com.api.integration.dataatwork.service.JobService;
import com.api.integration.dataatwork.service.RequestBinService;
import com.api.integration.dataatwork.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;

@Component
public class JobManager {

    @Autowired
    SkillService skillService;

    @Autowired
    JobService jobService;

    @Autowired
    RequestBinService requestBinService;

    Logger logger = LoggerFactory.getLogger(JobManager.class);

    public JobDetail getJobsForSkill(String skill) {
            //Get Skill ID for the skill name
            String skillId = skillService.getSkillId(skill);
            if (StringUtils.isEmpty(skillId)) {
                return new JobDetail();
            }

            //Get Jobs for the Skill ID
            JobDetail jobDetail = jobService.getJobs(skillId);

            //Pass all Jobs to the third party RequestBin.net service
            requestBinService.postJobs(jobDetail);

            return jobDetail;
    }
}
