package com.suep.sos.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "answer")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    int surveyId;
    int detailId;
    int ans;
    String multi;
    String context;
    int rate;

    public Answer(int id, int surveyId, int detailId, int ans, String multi, String context, int rate) {
        this.id = id;
        this.surveyId = surveyId;
        this.detailId = detailId;
        this.ans = ans;
        this.multi = multi;
        this.context = context;
        this.rate = rate;
    }

    public Answer() {
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", surveyId=" + surveyId +
                ", detailId=" + detailId +
                ", ans=" + ans +
                ", multi='" + multi + '\'' +
                ", context='" + context + '\'' +
                ", rate=" + rate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public int getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

    public String getMulti() {
        return multi;
    }

    public void setMulti(String multi) {
        this.multi = multi;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
