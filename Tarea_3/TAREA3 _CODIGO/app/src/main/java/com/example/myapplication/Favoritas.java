package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Favoritas extends AppCompatActivity {
    private RecyclerView rv ;
    private ArrayList<Mascota> aM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas2);
        Toolbar myChildToolbar = findViewById(R.id.miActionBarMain);

        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        ab.setDisplayShowTitleEnabled(false);
        Button btn =  findViewById(R.id.btnEstrella);
        if (btn.getVisibility()==View.VISIBLE){
            btn.setVisibility(View.GONE);
        }
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        rv = findViewById(R.id.rvMascota);
        LinearLayoutManager lnm = new LinearLayoutManager(this);

        lnm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(lnm);
        llenarMascotas();
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

