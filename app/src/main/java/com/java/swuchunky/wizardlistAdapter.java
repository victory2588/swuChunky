package com.java.swuchunky;

import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class wizardlistAdapter extends BaseAdapter {
    private ArrayList<wizard_main_Item> listCustom = new ArrayList<>();

    // ListView에 보여질 Item 수
    @Override
    public int getCount() {
        return listCustom.size();
    }

    // 하나의 Item(ImageView 1, TextView 2)
    @Override
    public Object getItem(int position) {
        return listCustom.get(position);
    }

    // Item의 id : Item을 구별하기 위한 것으로 position 사용
    @Override
    public long getItemId(int position) {
        return position;
    }

    // 실제로 Item이 보여지는 부분
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.wizard_main_item,null, false);

            holder = new CustomViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.dobi_image);
            holder.textTitle = (TextView) convertView.findViewById(R.id.dobi_name);
            holder.textContent1 = (TextView) convertView.findViewById(R.id.clean_info);
            holder.textContent2 = (TextView) convertView.findViewById(R.id.clean_info1);
            holder.textContent3 = (TextView) convertView.findViewById(R.id.clean_info2);

            convertView.setTag(holder);
        } else {
            holder = (CustomViewHolder) convertView.getTag();
        }

        wizard_main_Item dto = listCustom.get(position);

        holder.imageView.setImageResource(dto.getResId());
        holder.textTitle.setText(dto.getName());
        holder.textContent1.setText(dto.getCategory());
        holder.textContent2.setText(dto.getDate());
        holder.textContent3.setText(dto.getRequest());

        return convertView;
    }

    class CustomViewHolder {
        ImageView imageView;
        TextView textTitle;
        TextView textContent1;
        TextView textContent2;
        TextView textContent3;
    }

    // MainActivity에서 Adapter에있는 ArrayList에 data를 추가시켜주는 함수
    public void addItem(wizard_main_Item dto) {
        listCustom.add(dto);
    }
}


/* //수정
    class wizardAdapter extends BaseAdapter {
        ArrayList<wizard_main_Item> items = new ArrayList<>();

        // Generate > implement methods
        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(wizard_main_Item item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // 뷰 객체 재사용
            wizardItemView view = null;
            if (convertView == null) {
                view = new wizardItemView(getActivity().getApplicationContext());
            } else {
                view = (wizardItemView) convertView;
            }

            wizard_main_Item item = items.get(position);

            view.setName(item.getName());
            //view.setCategory(item.getCategory());
            view.setImage(item.getResId());

            return view;*/