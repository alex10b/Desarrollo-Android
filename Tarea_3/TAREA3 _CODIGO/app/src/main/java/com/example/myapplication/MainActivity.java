package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView rv ;
private ArrayList<Mascota> aM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button btn = findViewById(R.id.btnEstrella);
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this,Favoritas.class);

           startActivity(intent);
           }
       });
        rv = findViewById(R.id.rvMascota);
        LinearLayoutManager lnm = new LinearLayoutManager(this);
        Button btnL =  findViewById(R.id.btnEstrella);

        lnm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(lnm);
        llenarMascotas();
        btnL.setText(String.valueOf(aM.size()));
        inicializarAdaptador();

    }
    private void llenarMascotas(){
      aM=new ArrayList<>();
        aM.add(new Mascota("Pancho",0,R.drawable.perro));

        aM.add(new Mascota("Sugar",0,R.drawable.perrorisa));

        aM.add(new Mascota("Salt",0,R.drawable.perromano));

        aM.add(new Mascota("Selfie",0,R.drawable.headgehog));
        aM.add(new Mascota("Max",0,R.drawable.max));


    }
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(aM,this);

        rv.setAdapter(adaptador);
    }
}
