package com.example.user.electrogainsroutine.API_Connection;

import com.example.user.electrogainsroutine.Data.ExercisesCAT;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface API_RequestExercisesCAT {
    String BASE_URL = "https://wger.de/";
    String Exercises_url = "api/v2/exercisecategory/";

    //@Headers("Aut:"+)
    @GET(Exercises_url)
    Call<List<ExercisesCAT>> getExercises();


}
