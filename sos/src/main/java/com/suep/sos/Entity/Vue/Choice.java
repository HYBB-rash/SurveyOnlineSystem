package com.suep.sos.Entity.Vue;

public class Choice {

    private String value;

    @Override
    public String toString() {
        return "Choice{" +
                "value='" + value + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
