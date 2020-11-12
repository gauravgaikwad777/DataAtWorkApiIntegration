package com.api.integration.dataatwork.model;

//import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;

public class Skills {

    private String uuid;

    private String suggestion;

    private String normalizedSkillName;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getNormalizedSkillName() {
        return normalizedSkillName;
    }

    public void setNormalizedSkillName(String normalizedSkillName) {
        this.normalizedSkillName = normalizedSkillName;
    }

}