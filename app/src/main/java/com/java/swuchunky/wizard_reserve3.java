package com.java.swuchunky;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class wizard_reserve3 extends AppCompatActivity{
    ImageButton living, move, sofa, animal,special, company, trash, toilet;
    Button reservation_uploadbtn;
    EditText request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wizard_reserve3);

        reservation_uploadbtn = (Button) findViewById(R.id.reservation3_uploadbtn);
        living = (ImageButton) findViewById(R.id.reservation3_living);
        move = (ImageButton) findViewById(R.id.reservation3_move);
        sofa = (ImageButton) findViewById(R.id.reservation3_sofa);
        animal = (ImageButton) findViewById(R.id.reservation3_animal);
        special = (ImageButton) findViewById(R.id.reservation3_special);
        company = (ImageButton) findViewById(R.id.reservation3_company);
        trash = (ImageButton) findViewById(R.id.reservation3_trash);
        toilet = (ImageButton) findViewById(R.id.reservation3_toilet);
        request= findViewById(R.id.wizard_reserve_rqt);

    }
}
