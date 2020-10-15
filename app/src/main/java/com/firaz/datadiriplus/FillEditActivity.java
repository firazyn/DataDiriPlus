package com.firaz.datadiriplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.firaz.datadiriplus.FormFilled.EXTRA_NAMA;
import static com.firaz.datadiriplus.FormFilled.EXTRA_NPM;

public class FillEditActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtName, edtNPM;
    private Button btnDataDiri;

    public static String RESULT_NAMA = "result_nama";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_edit);

        edtName = (EditText)findViewById(R.id.edt_name);
        edtNPM = (EditText)findViewById(R.id.edt_npm);
        btnDataDiri = (Button)findViewById(R.id.btn_datadiri);

        btnDataDiri.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_datadiri) {
            String nama = edtName.getText().toString().trim();
            String NPM = edtNPM.getText().toString().trim();
            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(nama)) {
                isEmptyFields = true;
                edtName.setError("Nama tidak boleh kosong");
            }
            if (TextUtils.isEmpty(NPM)) {
                isEmptyFields = true;
                edtNPM.setError("NPM tidak boleh kosong");
            }
            if(!isEmptyFields) {
                //Explicit Intent (Move act with data)
                Intent toFilled = new Intent(FillEditActivity.this, FormFilled.class);
                toFilled.putExtra(EXTRA_NAMA, nama);
                toFilled.putExtra(EXTRA_NPM, NPM);
                startActivityForResult(toFilled, 2);
            }
        }
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data ) {
        super.onActivityResult(requestCode, resultCode, data);
        //Menerima result dan mengirimkannya ke Main
        if (requestCode == 2) {
            if (resultCode == 200) {
                String resultNamaFilled = data.getStringExtra(EXTRA_NAMA);
                Intent resultNama = new Intent();
                resultNama.putExtra(RESULT_NAMA, resultNamaFilled);
                setResult(100, resultNama);
                finish();
            }
        }
    }
}