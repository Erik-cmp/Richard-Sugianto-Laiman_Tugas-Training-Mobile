package com.example.tugaspert2;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SecondFragment extends Fragment {

    Button loadingButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_second, container, false);

        loadingButton = v.findViewById(R.id.loading_btn);

        ProgressDialog progressDialog = new ProgressDialog((getContext()));
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Aplikasi sedang mengunduh...");
        progressDialog.setCancelable(true);


        loadingButton.setOnClickListener(view -> {
            progressDialog.show();
        });

        return v;
    }
}