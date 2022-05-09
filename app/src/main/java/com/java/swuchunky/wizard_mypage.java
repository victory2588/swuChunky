package com.java.swuchunky;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.java.swuchunky.MainActivity;
import com.java.swuchunky.R;

public class wizard_mypage extends Fragment {

    wizardMainActivity activity;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.wizard_mypage, container, false);

        activity = (wizardMainActivity) getActivity();
        //activity.onNavigationItemSelected(4);
        // Inflate the layout for this fragment
        return view;
    }
}