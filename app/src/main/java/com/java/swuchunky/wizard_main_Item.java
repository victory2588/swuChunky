package com.java.swuchunky;

public class wizard_main_Item {
    String name;
    String category;
    String date;
    int resId;

    // Generate > Constructor
    public wizard_main_Item(String name, String category, String date, int resId) {
        this.name = name;
        this.category = category;
        this.date = date;
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

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    // Generate > toString() : 아이템을 문자열로 출력

    @Override
    public String toString() {
        return "SingerItem{" +
                "name='" + name + '\'' +
                ", mobile='" + category + '\'' +
                '}';
    }
}
