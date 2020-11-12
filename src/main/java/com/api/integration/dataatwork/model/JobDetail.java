package com.api.integration.dataatwork.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"skill_uuid", "skill_name", "normalized_skill_name", "jobs"})
public class JobDetail {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("skill_uuid")
    private String skillUuid;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("skill_name")
    private String skillName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("normalized_skill_name")
    private String normalizedSkillName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("errorCode")
    private String errorCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("errorMessage")
    private String errorMessage;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Job> jobs = null;

    public JobDetail(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public JobDetail() {
        super();
    }

    public String getSkillUuid() {
        return skillUuid;
    }

    public void setSkillUuid(String skillUuid) {
        this.skillUuid = skillUuid;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getNormalizedSkillName() {
        return normalizedSkillName;
    }

    public void setNormalizedSkillName(String normalizedSkillName) {
        this.normalizedSkillName = normalizedSkillName;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

}