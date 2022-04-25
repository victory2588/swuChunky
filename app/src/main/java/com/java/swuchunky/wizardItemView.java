package com.java.swuchunky;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class wizardItemView extends LinearLayout {

    TextView clean_info;
    TextView clean_category;
    ImageView clean_image;

    // Generate > Constructor

    public wizardItemView(Context context) {
        super(context);

        init(context);
    }

    public wizardItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    // singer_item.xml을 inflation
    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.wizard_item, this, true);

        clean_info = (TextView) findViewById(R.id.clean_info);
        clean_category = (TextView) findViewById(R.id.clean_category);
        clean_image = (ImageView) findViewById(R.id.clean_image);
    }

    public void setName(String name) {
        clean_info.setText(name);
    }

    public void setMobile(String mobile) {
        clean_category.setText(mobile);
    }

    public void setImage(int resId) {
        clean_image.setImageResource(resId);
    }

}
