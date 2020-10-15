package com.firaz.datadiriplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView helloNama;
    private Button btnWeb, btnFillEditForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloNama = (TextView)findViewById(R.id.hello);
        btnFillEditForm = (Button)findViewById(R.id.btn_fe_form);
        btnWeb = (Button)findViewById(R.id.btn_web);

        btnFillEditForm.setOnClickListener(this);
        btnWeb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            //Move Activity (+ for Result)
            case R.id.btn_fe_form:
                Intent toFill = new Intent(MainActivity.this, FillEditActivity.class);
                startActivityForResult(toFill, 1);
                break;
            //Implicit Intent
            case R.id.btn_web:
                Intent toWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.github.com/firazyn"));
                startActivity(toWeb);
                break;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == 100) {
                String resultNama = data.getStringExtra(FillEditActivity.RESULT_NAMA);
                helloNama.setText("Hello, "+resultNama+"!");
            }
        }

    }
}