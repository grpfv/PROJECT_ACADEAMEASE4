package com.example.project_acadeamease1;


import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CourseDetails extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details2);

        // Retrieve data from the intent
        String subject = getIntent().getStringExtra("subject");
        String instructor = getIntent().getStringExtra("instructor");

        // Update UI with the retrieved data
        TextView subjectTextView = findViewById(R.id.subjectTextView);
        TextView instructorTextView = findViewById(R.id.instructorTextView);

        subjectTextView.setText(" " + subject);
        instructorTextView.setText(" " + instructor);
    }
}
