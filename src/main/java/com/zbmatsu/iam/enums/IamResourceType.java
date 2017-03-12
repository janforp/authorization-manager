package com.zbmatsu.iam.enums;

/**
 * Created by Janita on 2017/1/1.
 */
public enum  IamResourceType {

    BUTTON("button"),

    MENU("menu"),

    LINK("link");

    private final String resourceType;

    private IamResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    @Override
    public String toString() {
        return resourceType;
    }
}
