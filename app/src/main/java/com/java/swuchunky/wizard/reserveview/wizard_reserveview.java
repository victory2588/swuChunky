package com.java.swuchunky.wizard.reserveview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.java.swuchunky.MainActivity;
import com.java.swuchunky.R;
import com.java.swuchunky.wizard.reserveview.wizardItem;
import com.java.swuchunky.wizard.reserveview.wizardItemView;

import java.util.ArrayList;

public class wizard_reserveview extends Fragment {
    MainActivity activity;

    wizardAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                @Nullable Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.wizard_reserveview, container, false);

        activity = (MainActivity) getActivity();
        //activity.onFragmentChanged(2);

        ListView listView = (ListView) view.findViewById(R.id.wizard_reserveview_listView);
        //어댑터 안에 데이터 담기
        adapter = new wizardAdapter();

        adapter.addItem(new wizardItem("거실 청소, 설거지, 분리수거", "일급 : 50,000원 /n집 주소 : 경기도 김포시", R.drawable.living));
        adapter.addItem(new wizardItem("거실 청소, 설거지, 분리수거", "일급 : 50,000원 /n집 주소 : 경기도 김포시", R.drawable.living));
        adapter.addItem(new wizardItem("거실 청소, 설거지, 분리수거", "일급 : 50,000원 /n집 주소 : 경기도 김포시", R.drawable.living));
        adapter.addItem(new wizardItem("거실 청소, 설거지, 분리수거", "일급 : 50,000원 /n집 주소 : 경기도 김포시", R.drawable.living));
        adapter.addItem(new wizardItem("거실 청소, 설거지, 분리수거", "일급 : 50,000원 /n집 주소 : 경기도 김포시", R.drawable.living));

        // 리스트 뷰에 어댑터 설정
        listView.setAdapter(adapter);

        // 이벤트 처리 리스너 설정
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                wizardItem item = (wizardItem) adapter.getItem(position);
                Toast.makeText(getActivity().getApplicationContext(), "선택 :" + item.getName(), Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    class wizardAdapter extends BaseAdapter {
        ArrayList<wizardItem> items = new ArrayList<wizardItem>();

        // Generate > implement methods
        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(wizardItem item) {
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

            wizardItem item = items.get(position);

            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImage(item.getResId());

            return view;
        }
    }
}
        /*
        public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState){
            super.onViewCreated(view, savedInstanceState);
        }

         */


