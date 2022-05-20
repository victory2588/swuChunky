package com.java.swuchunky;

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

import java.util.ArrayList;

public class wizard_reserveview extends Fragment {
    wizardMainActivity activity;

    wizardAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                @Nullable Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.wizard_reserveview, container, false);

        activity = (wizardMainActivity) getActivity();

        ListView listView = (ListView) view.findViewById(R.id.wizard_reserveview_listView);
        //어댑터 안에 데이터 담기
        adapter = new wizardAdapter();

        adapter.addItem(new wizard_reserveview_Item("거실 청소, 설거지, 분리수거", "일급 : 50,000원 /n집 주소 : 서울 관악구", R.drawable.living));
        adapter.addItem(new wizard_reserveview_Item("화장실 청소, 설거지, 분리수거", "일급 : 35,000원 /n집 주소 : 경기도 김포시", R.drawable.toilet));
        adapter.addItem(new wizard_reserveview_Item("냉장고 정리, 설거지, 분리수거", "일급 : 20,000원 /n집 주소 : 서울 동작구", R.drawable.sofa));
        adapter.addItem(new wizard_reserveview_Item("사무실 청소, 분리수거", "일급 : 70,000원 /n집 주소 : 경기도 김포시", R.drawable.company));
        adapter.addItem(new wizard_reserveview_Item("곰팡이 제거", "일급 : 85,000원 /n집 주소 : 경기도 구리시", R.drawable.special));

        // 리스트 뷰에 어댑터 설정
        listView.setAdapter(adapter);

        // 이벤트 처리 리스너 설정
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                wizard_reserveview_Item item = (wizard_reserveview_Item) adapter.getItem(position);
                Toast.makeText(getActivity().getApplicationContext(), "선택 :" + item.getName(), Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    class wizardAdapter extends BaseAdapter {
        ArrayList<wizard_reserveview_Item> items = new ArrayList<wizard_reserveview_Item>();

        // Generate > implement methods
        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(wizard_reserveview_Item item) {
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

            wizard_reserveview_Item item = items.get(position);

            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImage(item.getResId());

            return view;
        }
    }
}



