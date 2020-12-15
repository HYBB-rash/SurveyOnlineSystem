package com.suep.sos.Entity.Vue;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;

public class VueSurvey {

    private Integer userId;
    private String surveyTitle;
    private String instruction;
    private List<VueQuestion> forms;

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("{");
        builder.append("\"userId\":")
                .append(userId);
        builder.append(",\"surveyTitle\":\"")
                .append(surveyTitle).append('\"');
        builder.append(",\"instruction\":\"")
                .append(instruction).append('\"');
        builder.append(",\"forms\":")
                .append(forms);
        builder.append('}');
        return builder.toString();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSurveyTitle() {
        return surveyTitle;
    }

    public void setSurveyTitle(String surveyTitle) {
        this.surveyTitle = surveyTitle;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public List<VueQuestion> getForms() {
        return forms;
    }

    public void setForms(List<VueQuestion> forms) {
        this.forms = forms;
    }
}
