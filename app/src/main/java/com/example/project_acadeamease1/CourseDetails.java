package com.example.project_acadeamease1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CourseDetails extends AppCompatActivity {
    private MyFragmentAdapter adapter;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details2);

        String subject = getIntent().getStringExtra("subject");
        String instructor = getIntent().getStringExtra("instructor");

        // Update UI with the retrieved data
        TextView subjectTextView = findViewById(R.id.subjectTextView);
        TextView instructorTextView = findViewById(R.id.instructorTextView);

        subjectTextView.setText(" " + subject);
        instructorTextView.setText(" " + instructor);

        // Find the ViewPager2
        viewPager = findViewById(R.id.viewPager);

        // Initialize the adapter
        adapter = new MyFragmentAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        // Attach the TabLayout to the ViewPager2 using TabLayoutMediator
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Albums");
                    break;
                case 1:
                    tab.setText("Notes");
                    break;
                case 2:
                    tab.setText("Files");
                    break;
            }
        }).attach();
    }
}
