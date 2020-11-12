package com.api.integration.dataatwork.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Job {

    @JsonProperty("job_uuid")
    private String jobUuid;

    @JsonProperty("job_title")
    private String jobTitle;

    @JsonProperty("normalized_job_title")
    private String normalizedJobTitle;

    private Double importance;

    private Double level;

    public String getJobUuid() {
        return jobUuid;
    }

    public void setJobUuid(String jobUuid) {
        this.jobUuid = jobUuid;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getNormalizedJobTitle() {
        return normalizedJobTitle;
    }

    public void setNormalizedJobTitle(String normalizedJobTitle) {
        this.normalizedJobTitle = normalizedJobTitle;
    }

    public Double getImportance() {
        return importance;
    }

    public void setImportance(Double importance) {
        this.importance = importance;
    }

    public Double getLevel() {
        return level;
    }

    public void setLevel(Double level) {
        this.level = level;
    }

}