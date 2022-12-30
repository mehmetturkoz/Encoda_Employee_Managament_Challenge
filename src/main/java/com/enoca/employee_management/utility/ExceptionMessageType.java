package com.enoca.employee_management.utility;

public enum ExceptionMessageType {

    FIND_BY_ID("Entity is not found");

    private String value;

    ExceptionMessageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
