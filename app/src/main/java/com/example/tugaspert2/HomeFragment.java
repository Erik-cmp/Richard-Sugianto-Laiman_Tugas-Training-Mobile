package com.example.tugaspert2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeFragment extends Fragment {

    TextView textView1;
    EditText editText1;
    Button submitBtn;
    AlertDialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        textView1 = v.findViewById(R.id.tv1);
        editText1 = v.findViewById(R.id.et1);
        submitBtn = v.findViewById(R.id.submit_btn);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Konfirmasi").setMessage("Apakah anda ingin mengubah teks?").setPositiveButton("Iya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView1.setText(editText1.getText().toString());
            }
        }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(getActivity(), "Perubahan tidak jadi", Toast.LENGTH_SHORT).show();
            }
        });

        dialog = builder.create();

        submitBtn.setOnClickListener(view -> {
            dialog.show();
        });

        return v;
    }
}