package com.java.swuchunky;

public class reservation_info {
    private String date;
    private String time;
    private String address;
    private String category;
    private String request_item;

    public reservation_info(){}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRequest_item() {
        return request_item;
    }

    public void setRequest_item(String request_item) {
        this.request_item = request_item;
    }
}
