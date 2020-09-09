package com.example.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.Contacto;
import com.example.myapplication.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    Context context;

    public BaseDatos(Context context) {
        super(context, BaseDatosConstantes.BaseDatosName, null, BaseDatosConstantes.Version);
        this.context =context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
String queryCreateTableMacota = "CREATE TABLE "+ BaseDatosConstantes.MASCOTA + "("+
                          BaseDatosConstantes.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                          BaseDatosConstantes.TABLE_MASCOTA_NOMBRE + " TEXT, "+

                            BaseDatosConstantes.TABLE_MASCOTA_IMG + " INTEGER )";
String queryCreateTableLikes = "CREATE TABLE "+ BaseDatosConstantes.LIKES_TABLE_NAME + "("+
                                BaseDatosConstantes.ID_LIKE + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                BaseDatosConstantes.ID_MASCOTA + " INTEGER, " +
                                BaseDatosConstantes.VOTOS + " INTEGER, " +
                                "FOREIGN KEY " + "(" +BaseDatosConstantes.ID_MASCOTA +")" +
                                "REFERENCES " + BaseDatosConstantes.MASCOTA +"("+ BaseDatosConstantes.TABLE_MASCOTA_ID +")" + ")";
            db.execSQL(queryCreateTableMacota);
            db.execSQL(queryCreateTableLikes);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BaseDatosConstantes.MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS " + BaseDatosConstantes.LIKES_TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerMascotas(){
        ArrayList<Mascota> mascota = new ArrayList<>();

        String query = "SELECT * FROM " +  BaseDatosConstantes.MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
           Mascota mascotaActual = new Mascota();
           mascotaActual.setId(registros.getInt(0));
           mascotaActual.setNombre(registros.getString(1));
           mascotaActual.setImg(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+BaseDatosConstantes.VOTOS +") as likes " +
                    " FROM " + BaseDatosConstantes.LIKES_TABLE_NAME +
                    " WHERE " + BaseDatosConstantes.TABLE_MASCOTA_ID + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setVotos(registrosLikes.getInt(0));
            }else {
                mascotaActual.setVotos(0);
            }

            mascota.add(mascotaActual);

        }

        db.close();

        return mascota;
    }
    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(BaseDatosConstantes.MASCOTA,null, contentValues);
        db.close();
    }

    public void insertarLikesMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(BaseDatosConstantes.LIKES_TABLE_NAME, null, contentValues);
        db.close();
    }
    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;

        String query = "SELECT COUNT("+BaseDatosConstantes.VOTOS+")" +
                " FROM " + BaseDatosConstantes.LIKES_TABLE_NAME +
                " WHERE " + BaseDatosConstantes.ID_MASCOTA+ "="+ mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }
}
