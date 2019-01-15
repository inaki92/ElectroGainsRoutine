package com.example.user.electrogainsroutine;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.electrogainsroutine.Adapter.ExcersiseAdapter;
import com.example.user.electrogainsroutine.Data.ExercisesCAT;
import com.example.user.electrogainsroutine.ViewModel.ExercisesViewModel;

import java.util.List;

public class ExercisesActivity extends AppCompatActivity {

    RecyclerView mRecycler;
    ExcersiseAdapter mAdapter;

    List<ExercisesCAT> exercisesCATList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycler = findViewById(R.id.main_recycler);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new GridLayoutManager(this,2));

        ExercisesViewModel model = ViewModelProviders.of(this).get(ExercisesViewModel.class);

        model.getExercises().observe(this, new Observer<List<ExercisesCAT>>() {
            @Override
            public void onChanged(@Nullable List<ExercisesCAT> heroList) {
                mAdapter = new ExcersiseAdapter(ExercisesActivity.this, exercisesCATList);
                mRecycler.setAdapter(mAdapter);
            }
        });
    }
}
