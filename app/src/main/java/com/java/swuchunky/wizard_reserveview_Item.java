package com.java.swuchunky;

import android.widget.ImageView;

//wizard_reserveveiw에서의 리스트 아이템
public class wizard_reserveview_Item {
    ImageView image;
    String category;
    String pay;
    String date;

    public wizard_reserveview_Item(ImageView image, String category, String pay, String date) {
        this.image = image;
        this.category = category;
        this.pay = pay;
        this.date = date;
    }

    public ImageView getImage(){
        return image;
    }
    public void setImage(ImageView image){
        this.image = image;
    }

    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }

    public String getPay(){
        return pay;
    }
    public void setPay(String pay){
        this.pay = pay;
    }

    public String getDate(){
        return pay;
    }
    public void setDate(String date){
        this.date = date;
    }
}