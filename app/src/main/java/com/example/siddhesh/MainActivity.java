package com.example.siddhesh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    Button mplaybtn;
    TextView mtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mplaybtn = findViewById(R.id.playbtn);
        mtext = findViewById(R.id.introtext);

// using play button to start our game.
        mplaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mplaybtn.setVisibility(View.GONE);
                mtext.setVisibility(View.GONE);
                Fragment fragment= new stage1();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment); // fragment container id in first parameter is the  container(Main layout id) of Activity
                transaction.addToBackStack(null);  // this will manage backstack
                transaction.commit();
            }
        });
    }
}
