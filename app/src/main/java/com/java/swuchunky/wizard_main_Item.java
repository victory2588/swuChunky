package com.java.swuchunky;

public class wizard_main_Item {
    String name;
    String category;
    String date;
    int resId;
    String request;

    // Generate > Constructor
    public wizard_main_Item(String name, String category, String date, int resId, String request) {
        this.name = name;
        this.category = category;
        this.date = date;
        this.resId = resId;
        this.request = request;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    // Generate > Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRequest() {
        return date;
    }

    public void setRequest(String request) {
        this.request = request;
    }

}
