package com.github.vasiliz.rocketswheel.backend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.github.vasiliz.rocketswheel.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BackendSample extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("user");

        Button button = findViewById(R.id.addButton);
        button.setOnClickListener(v -> {

            reference.setValue(new User(2, "lol", "s"));
        });

        Button button1 = findViewById(R.id.getButton);
        button1.setOnClickListener(v -> {
            reference.addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot pDataSnapshot) {
                    String s = pDataSnapshot.getValue(String.class);
                    Log.d("Tag", s.toString());

                }

                @Override
                public void onCancelled(DatabaseError pDatabaseError) {
                    Log.w("Tag", "Failed to read value.", pDatabaseError.toException());
                }
            });
        });
    }
}
