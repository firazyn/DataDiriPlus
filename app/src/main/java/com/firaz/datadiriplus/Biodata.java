package com.firaz.datadiriplus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Biodata extends AppCompatActivity {
    public static String PARCEL_FILLEDIT = "parcel_filledit";
    private TextView showNama, showNPM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);

        FormData fData = getIntent().getParcelableExtra(PARCEL_FILLEDIT);
        showNama = (TextView)findViewById(R.id.show_nama);
        showNPM = (TextView)findViewById(R.id.show_npm);

        String textNama = "Nama Lengkap: "+fData.getNama();
        String textNPM = "NPM: "+fData.getNPM();

        showNama.setText(textNama);
        showNPM.setText(textNPM);
    }
}