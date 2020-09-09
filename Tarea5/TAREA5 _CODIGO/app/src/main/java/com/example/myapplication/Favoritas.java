package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.adapters.MascotaAdaptador;
import com.example.myapplication.model.ConstructorMascota;

import java.util.ArrayList;
import java.util.Set;

public class Favoritas extends AppCompatActivity {
    private RecyclerView rv ;
    private ArrayList<Mascota> aM=null;
    private TextView tx;
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_opc,menu);
        return true;
    }
    private void llenarMascotas(){
        aM=null;
        tx=findViewById(R.id.textoMascota);
        tx.setText("");
         ConstructorMascota m = new ConstructorMascota(getApplicationContext());

         aM = m.obtenerDatos();

       for(int i=4; i>=0; i--){

           int nu = m.obtenerLikesContacto(aM.get(i));
           if(nu==0){
               aM.remove(i);
           }

           if(aM.isEmpty()){
               tx.setText("No Hay Mascotas Likeadas");
           }

       }






    }
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(aM,this);

        rv.setAdapter(adaptador);
    }
}

