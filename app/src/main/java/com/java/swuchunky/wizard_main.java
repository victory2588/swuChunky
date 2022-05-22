package com.java.swuchunky;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.java.swuchunky.MainActivity;
import com.java.swuchunky.R;
//import com.prolificinteractive.materialcalendarview.CalendarDay;
//import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.ArrayList;
import java.util.Calendar;

public class wizard_main extends Fragment {

    wizardMainActivity activity;
    wizard_main.wizardAdapter adapter;

    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (wizardMainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment

        //뷰 넘어가는 부분
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.wizard_main, container, false);

        ListView listView = (ListView) view.findViewById(R.id.wizard_main_listView);
        //어댑터 안에 데이터 담기
        adapter = new wizard_main.wizardAdapter();

        adapter.addItem(new wizard_main_Item("홍선미 도비", "거실 청소, 설거지, 분리수거", "2022년 10월 5일", R.drawable.living));
        adapter.addItem(new wizard_main_Item("홍선미 도비", "거실 청소, 설거지, 분리수거", "2022년 10월 5일", R.drawable.living));
        adapter.addItem(new wizard_main_Item("홍선미 도비", "거실 청소, 설거지, 분리수거", "2022년 10월 5일", R.drawable.living));
        adapter.addItem(new wizard_main_Item("홍선미 도비", "거실 청소, 설거지, 분리수거", "2022년 10월 5일", R.drawable.living));
        adapter.addItem(new wizard_main_Item("홍선미 도비", "거실 청소, 설거지, 분리수거", "2022년 10월 5일", R.drawable.living));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                wizard_main_Item item = (wizard_main_Item) adapter.getItem(position);
                Toast.makeText(getActivity().getApplicationContext(), "선택 :" + item.getName(), Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

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

            return view;
        }
    }
}