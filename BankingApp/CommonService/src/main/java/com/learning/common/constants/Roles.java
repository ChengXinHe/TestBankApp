package com.learning.common.constants;

public enum Roles implements BaseEnum{
    ROLE_CUSTOMER(1, "ROLE_USER"),
    ROLE_STAFF(2,"ROLE_STAFF"),
    ROLE_ADMIN(3, "ROLE_ADMIN");

    private final int value;
    private final String name;

    Roles(int value, String name) {
        this.value = value;
        this.name = name;
    }


    @Override
    public Integer getCode() {
        return this.value;
    }

    @Override
    public String getName() {
        return this.name;
    }
}