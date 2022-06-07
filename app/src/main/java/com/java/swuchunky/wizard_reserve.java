package com.java.swuchunky;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.java.swuchunky.MainActivity;
import com.java.swuchunky.R;

public class wizard_reserve extends Fragment {

    wizardMainActivity activity;
    wizard_reserve1_sel reserve1_sel;

    public static wizard_reserve newInstance() {
        return new wizard_reserve();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.wizard_reserve, container, false);

        activity = (wizardMainActivity) getActivity();

        ImageButton reservelist_btn=view.findViewById(R.id.reservelist_img);
        ImageButton reserve_sel_btn = view.findViewById(R.id.reserve_sel_btn);
        reserve_sel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), wizard_reserve1_sel.class);
                startActivity(intent);
            }
        });
        reservelist_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((wizardMainActivity)getActivity()).replaceFragment(wizard_findwork.newInstance());
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
