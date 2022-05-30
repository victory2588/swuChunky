package com.java.swuchunky;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.java.swuchunky.MainActivity;
import com.java.swuchunky.R;

public class dobi_mypage extends Fragment {

    dobiMainActivity activity;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.dobi_mypage, container, false);

        activity = (dobiMainActivity) getActivity();

        Button mypage_information = view.findViewById(R.id.mypage_information1);
        mypage_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getActivity(), wizard_reserve1_sel.class);
                //startActivity(intent);
            }
        });
        //activity.onNavigationItemSelected(4);
        // Inflate the layout for this fragment
        return view;
    }
}