package com.example.user.electrogainsroutine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;

public class WelcomeActivity extends AppCompatActivity {

    @BindView(R.id.play_hard_btn)
    Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ExercisesActivity.class);
                getApplicationContext().startActivity(intent);
            }
        });
    }
}
