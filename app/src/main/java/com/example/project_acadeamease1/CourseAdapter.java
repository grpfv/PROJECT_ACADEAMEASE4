package com.example.project_acadeamease1;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class CourseAdapter extends FirestoreRecyclerAdapter<CourseModel, CourseAdapter.CourseViewHolder> {

    Context context;

    public CourseAdapter(@NonNull FirestoreRecyclerOptions<CourseModel> options, Context context) {
        super(options);
        this.context = context;

        
    }

    @Override
    protected void onBindViewHolder(@NonNull CourseViewHolder holder, int position, @NonNull CourseModel course) {
        holder.courseSubject.setText(course.subject);

        holder.itemView.setOnClickListener(v->{
            Intent intent = new Intent(context, CourseDetails.class);
            intent.putExtra("subject",course.subject);
            intent.putExtra("instructor", course.instructor);

            String courseId = this.getSnapshots().getSnapshot(position).getId();
            intent.putExtra("courseId",courseId);
            context.startActivity(intent);
        });


    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_course_item, parent, false);
        return new CourseViewHolder(view);
    }

    class CourseViewHolder extends RecyclerView.ViewHolder{

        TextView courseSubject;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            courseSubject = itemView.findViewById(R.id.course_Subject);
        }
    }

}

