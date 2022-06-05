package com.java.swuchunky;

import static java.sql.Types.NULL;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoadingActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private DatabaseReference firebaseDatabase;
    public String role;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_activity);

        FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();
        firebaseDatabase= FirebaseDatabase.getInstance().getReference();

        Query LoginQuery=firebaseDatabase.child("wizard").child("user").orderByChild("idToken").equalTo(user.getUid());
        LoginQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    userAccount account=dataSnapshot.getValue(userAccount.class);
                    Log.d("데이터 검색", account.getEmail());
                    Log.d("데이터 키", dataSnapshot.getKey());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        /*firebaseDatabase.child("wizard").child("user").child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userAccount account=snapshot.getValue(userAccount.class);
                role=account.getRole().trim();

                Log.d("역할 정보",role);

                if(role.equals("dobi")){

                    Intent intent = new Intent(LoadingActivity.this, dobiMainActivity.class); //getApplicationContext()
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"요정님 환영합니다!",Toast.LENGTH_SHORT).show();
                }
                else if(role.equals("wizard")){
                    Intent intent = new Intent(LoadingActivity.this, wizardMainActivity.class); //getApplicationContext()
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"마법사님 환영합니다!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"역할을 선택해주세요!",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });*/

    }
}
