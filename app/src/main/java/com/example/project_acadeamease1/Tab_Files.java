package com.example.project_acadeamease1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Objects;


public class Tab_Files extends Fragment {

    private FloatingActionButton selectPdfButton;
    private MaterialButton uploadBtn, showAllBtn;
    private ProgressBar progressBar;
    private TextView fileName;

    private Uri pdfFileUri;

    private final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Files");
    private final StorageReference storageReference = FirebaseStorage.getInstance().getReference();

    private final ActivityResultLauncher<String> launcher = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            uri -> {
                pdfFileUri = uri;
                String fileNameText = uri != null ? Objects.requireNonNull(DocumentFile.fromSingleUri(requireActivity(), uri)).getName() : null;
                fileName.setText(String.valueOf(fileNameText));
            }
    );


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab_files, container, false);

        selectPdfButton = view.findViewById(R.id.selectPdfButton);
        uploadBtn = view.findViewById(R.id.uploadBtn);
        //showAllBtn = view.findViewById(R.id.showAllBtn);
        progressBar = view.findViewById(R.id.progressBar);
        fileName = view.findViewById(R.id.fileName);

        selectPdfButton.setOnClickListener(v -> launcher.launch("application/pdf"));

        uploadBtn.setOnClickListener(v -> {
            if (pdfFileUri != null) {
                uploadFileToFirebase(pdfFileUri);
            } else {
                Toast.makeText(requireContext(), "Please select a PDF file", Toast.LENGTH_SHORT).show();
            }
        });

       /* showAllBtn.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), ShowAllFilesActivity.class);
            startActivity(intent);
        });*/

        return view;
    }
    private void uploadFileToFirebase(Uri uri) {
        progressBar.setVisibility(View.VISIBLE);
        String fileName = DocumentFile.fromSingleUri(requireActivity(), uri).getName();
        final StorageReference fileReference = storageReference.child(fileName);
        fileReference.putFile(uri)
                .addOnSuccessListener(taskSnapshot -> {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(requireContext(), "File Uploaded", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(requireContext(), "Failed to upload file", Toast.LENGTH_SHORT).show();
                });
    }


}
