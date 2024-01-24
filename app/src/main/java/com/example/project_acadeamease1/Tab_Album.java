package com.example.project_acadeamease1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.project_acadeamease1.MyAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.Query;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class Tab_Album extends Fragment {
    RecyclerView recyclerView;
    private MyAdapter adapter;
    
    private ArrayList<DataClass> dataList;
    private StorageReference storageReference;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize Firebase Storage reference
        storageReference = FirebaseStorage.getInstance().getReference("Bbfrf4bLzOVeho2KxRgS");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab_album, container, false);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        dataList = new ArrayList<>();
        adapter = new MyAdapter(dataList, requireContext());
        recyclerView.setAdapter(adapter);

        // Add your Firebase Storage data retrieval logic here
        fetchFirebaseData();

        fab.setOnClickListener(view1 -> {
            Intent intent = new Intent(requireActivity(), UploadActivity.class);
            startActivity(intent);
            requireActivity().finish();
        });

        return view;
    }

    private void fetchFirebaseData() {
        // Retrieve data from Firebase Storage and update dataList
        // Example: Fetch images from a specific folder in storage
        // You should replace "your_folder_name" with your actual folder name
        StorageReference imagesRef = storageReference.child("Bbfrf4bLzOVeho2KxRgS");
        imagesRef.listAll()
                .addOnSuccessListener(listResult -> {
                    for (StorageReference item : listResult.getItems()) {
                        // Get download URL for each item
                        item.getDownloadUrl().addOnSuccessListener(uri -> {
                            DataClass dataClass = new DataClass(uri.toString(), "Image Caption");
                            dataList.add(dataClass);
                            adapter.notifyDataSetChanged();
                        });
                    }
                })
                .addOnFailureListener(e -> {
                    // Handle failure
                });
    }}

