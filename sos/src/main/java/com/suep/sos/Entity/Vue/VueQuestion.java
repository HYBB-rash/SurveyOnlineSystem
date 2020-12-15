package com.suep.sos.Entity.Vue;

import java.util.Arrays;
import java.util.List;

public class VueQuestion {

    private Long id;
    private String question;
    private Integer type;
    private String context;
    private Integer ans;
    private List<PostId> multi;
    private Boolean flag;
    private List<Choice> choices;

    @Override
    public String toString() {
        return "VueQuestion{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", type=" + type +
                ", context='" + context + '\'' +
                ", ans=" + ans +
                ", multi=" + multi +
                ", flag=" + flag +
                ", choices=" + choices +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getAns() {
        return ans;
    }

    public void setAns(Integer ans) {
        this.ans = ans;
    }

    public List<PostId> getMulti() {
        return multi;
    }

    public void setMulti(List<PostId> multi) {
        this.multi = multi;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
