package com.example.user.electrogainsroutine.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.electrogainsroutine.Data.ExercisesCAT;
import com.example.user.electrogainsroutine.R;

import java.util.List;

import butterknife.BindView;

public class ExcersiseAdapter extends RecyclerView.Adapter<ExcersiseAdapter.ExerciseViewHolder> {

    Context mCtx;
    List<ExercisesCAT> ExerciseList;

    public ExcersiseAdapter(Context mCtx, List<ExercisesCAT> excersiseList){
        this.mCtx = mCtx;
        this.ExerciseList = excersiseList;

    }

    class ExerciseViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.muscle_name)
        TextView muscleName;

        public ExerciseViewHolder(@NonNull View itemView) {
            super(itemView);

            muscleName = itemView.findViewById(R.id.muscle_name);

            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mCtx,BioActivity.class);
                    intent.putExtra("bio",heroBio);
                    intent.putExtra("realname",heroRealName);
                    mCtx.startActivity(intent);
                }
            });*/
        }
    }

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recycler_excersie_category,viewGroup,false);
        return new ExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExcersiseAdapter.ExerciseViewHolder exerciseHolder, int i) {
        final ExercisesCAT exersise =ExerciseList.get(i);

        exerciseHolder.muscleName.setText(ExerciseList.get(i).getResults().get(i).getName());
    }

    @Override
    public int getItemCount() {
        return ExerciseList.size();
    }
}
