package com.example.myapplication.model;

import android.content.ContentValues;
import android.content.Context;

import com.example.myapplication.Mascota;
import com.example.myapplication.R;
import com.example.myapplication.db.BaseDatos;
import com.example.myapplication.db.BaseDatosConstantes;

import java.util.ArrayList;

public class ConstructorMascota {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascota(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        if(db.obtenerMascotas().isEmpty()){
            insertarMascotas(db);
        }

        return  db.obtenerMascotas();
    }



    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(BaseDatosConstantes.TABLE_MASCOTA_NOMBRE, "Pancho");
        contentValues.put(BaseDatosConstantes.TABLE_MASCOTA_IMG, R.drawable.perromano);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();

        contentValues.put(BaseDatosConstantes.TABLE_MASCOTA_NOMBRE, "Juan");
        contentValues.put(BaseDatosConstantes.TABLE_MASCOTA_IMG, R.drawable.headgehog);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();

        contentValues.put(BaseDatosConstantes.TABLE_MASCOTA_NOMBRE, "Mario");
        contentValues.put(BaseDatosConstantes.TABLE_MASCOTA_IMG, R.drawable.perrorisa);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();

        contentValues.put(BaseDatosConstantes.TABLE_MASCOTA_NOMBRE, "Thomas");
        contentValues.put(BaseDatosConstantes.TABLE_MASCOTA_IMG, R.drawable.perro);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();

        contentValues.put(BaseDatosConstantes.TABLE_MASCOTA_NOMBRE, "Max");
        contentValues.put(BaseDatosConstantes.TABLE_MASCOTA_IMG, R.drawable.max);

        db.insertarMascota(contentValues);




    }

    public void darLikeCotnacto(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(BaseDatosConstantes.ID_MASCOTA, mascota.getId());
        contentValues.put(BaseDatosConstantes.VOTOS, LIKE);
        db.insertarLikesMascota(contentValues);
    }

    public int obtenerLikesContacto(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }


}
