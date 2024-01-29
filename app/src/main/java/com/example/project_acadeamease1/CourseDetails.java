package com.example.project_acadeamease1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

<<<<<<< Updated upstream
import androidx.appcompat.app.AppCompatActivity;
=======
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
>>>>>>> Stashed changes
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
<<<<<<< Updated upstream
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
=======
import android.widget.TextView;


>>>>>>> Stashed changes

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

<<<<<<< Updated upstream
        // Initialize the adapter
        adapter = new MyFragmentAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager.setAdapter(adapter);
=======

        tabLayout.addTab(tabLayout.newTab().setText("Album"));
        tabLayout.addTab(tabLayout.newTab().setText("Notes"));
        tabLayout.addTab(tabLayout.newTab().setText("Files"));


        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new FragmentAdapter(fragmentManager, getLifecycle());
        viewPager.setAdapter(adapter);

        String subject = getIntent().getStringExtra("subject");
        String instructor = getIntent().getStringExtra("instructor");

        // Update UI with the retrieved data
        TextView subjectTextView = findViewById(R.id.subjectTextView);
        TextView instructorTextView = findViewById(R.id.instructorTextView);

        subjectTextView.setText(" " + subject);
        instructorTextView.setText(" " + instructor);


>>>>>>> Stashed changes
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
