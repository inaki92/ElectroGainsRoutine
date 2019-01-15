package com.example.user.electrogainsroutine.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.user.electrogainsroutine.API_Connection.API_RequestExercisesCAT;
import com.example.user.electrogainsroutine.Data.ExercisesCAT;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExercisesViewModel extends ViewModel {

    private MutableLiveData<List<ExercisesCAT>> ExerciseList;

    public LiveData<List<ExercisesCAT>> getExercises(){

        if (ExerciseList == null){
            ExerciseList = new MutableLiveData<List<ExercisesCAT>>();
            loadExercises();
        }
        return ExerciseList;
    }

    private void loadExercises(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_RequestExercisesCAT.BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build();

        API_RequestExercisesCAT api = retrofit.create(API_RequestExercisesCAT.class);
        Call<List<ExercisesCAT>> call = api.getExercises();

        call.enqueue(new Callback<List<ExercisesCAT>>() {
            @Override
            public void onResponse(Call<List<ExercisesCAT>> call, Response<List<ExercisesCAT>> response) {
                //setting the list to our MutableLiveData
                ExerciseList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ExercisesCAT>> call, Throwable t) {

            }
        });
    }
}
