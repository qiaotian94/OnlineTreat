package com.example.qiaotian.onlinetreatapp.javabean;

/**
 * Created by qiaotian on 2018/4/26.
 */




public class ApplicationBean {
    private String name;
    private int icon;
    private String title;
    private Type type;
    private String information;

    /**
     * 应用类型
     */
    public enum Type {
        TypeOne, TypeTwo, TypeThree
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
