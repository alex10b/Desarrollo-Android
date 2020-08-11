package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Contacto extends AppCompatActivity  {
    Button btn;
    EditText correo;
    EditText subj;
    EditText msj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        btn = findViewById(R.id.btnEnviar);
        correo = findViewById(R.id.mail);
        subj = findViewById(R.id.subj);
        msj = findViewById(R.id.mensaje);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senEmail();
                Toast.makeText(getApplicationContext(),"Listo!", Toast.LENGTH_LONG).show();

            }
        });
    }
    private void senEmail() {
        String mEmail = correo.getText().toString();
        String mSubject = subj.getText().toString();
        String mMessage = msj.getText().toString();


        JavaMailAPI javaMailAPI = new JavaMailAPI(this, mEmail, mSubject, mMessage);

        javaMailAPI.execute();
    }
}


