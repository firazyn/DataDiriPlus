package com.firaz.datadiriplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FormFilled extends AppCompatActivity implements View.OnClickListener {
    public static String EXTRA_NAMA = "extra_nama";
    public static String EXTRA_NPM = "extra_npm";
    private TextView showNama, showNPM;
    private Button backToHome, btnBiodata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_filled);

        showNama = (TextView)findViewById(R.id.show_nama);
        showNPM = (TextView)findViewById(R.id.show_npm);
        backToHome = (Button)findViewById(R.id.back_to_home);
        btnBiodata = (Button)findViewById(R.id.btn_bio);

        backToHome.setOnClickListener(this);
        btnBiodata.setOnClickListener(this);

        String nama = getIntent().getStringExtra(EXTRA_NAMA);
        String NPM = getIntent().getStringExtra(EXTRA_NPM);

        showNama.setText("Nama Lengkap: "+String.valueOf(nama));
        showNPM.setText("NPM: "+String.valueOf(NPM));
    }

    @Override
    public void onClick(View v) {
        String nama = getIntent().getStringExtra(EXTRA_NAMA);
        String NPM = getIntent().getStringExtra(EXTRA_NPM);

        switch (v.getId()) {
            case R.id.back_to_home:
                //Mengirimkan result ke FillEdit
                Intent resultNama = new Intent();
                resultNama.putExtra(EXTRA_NAMA, nama);
                setResult(200, resultNama);
                finish();
                break;

            case R.id.btn_bio:
                //Memindahkan Objek ke Biodata
                FormData fData = new FormData();
                fData.setNama(nama);
                fData.setNPM(NPM);
                //Memindahkan Objek ke Biodata

                Intent toBio = new Intent(FormFilled.this, Biodata.class);
                toBio.putExtra(Biodata.PARCEL_FILLEDIT, fData);
                startActivity(toBio);
                break;
        }

    }
}