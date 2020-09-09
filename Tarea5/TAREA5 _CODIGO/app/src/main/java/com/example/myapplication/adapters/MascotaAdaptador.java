package com.example.myapplication.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Mascota;
import com.example.myapplication.R;
import com.example.myapplication.model.ConstructorMascota;

import java.util.ArrayList;
import java.util.Set;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

  ArrayList<Mascota> mascotas;
  Activity activity;
  Set<String> set = null;
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, int position) {
        final ConstructorMascota ma = new ConstructorMascota(activity.getApplicationContext());
        final SharedPreferences sp = activity.getSharedPreferences("misPreferencias", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();
        if(mascotas.size()!=0){
           final Mascota mascota = mascotas.get(position);
           holder.rVTextVotos.setText(String.valueOf(ma.obtenerLikesContacto(mascota)));
           holder.img.setImageResource(mascota.getImg());
           holder.rVTextName.setText(mascota.getNombre());

           holder.rVImgBtnLike.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   ma.darLikeCotnacto(mascota);
                   int num = sp.getInt("num",0);


                   editor.putInt("num",num++);
                   editor.putInt(String.valueOf(num),num);

                   num = num++;


                   holder.rVTextVotos.setText(String.valueOf(ma.obtenerLikesContacto(mascota)));
                   Toast.makeText(activity,"Diste like a "+ mascota.getNombre(), Toast.LENGTH_SHORT).show();

               }
           });

       }


    }

    @Override
    public int getItemCount() {
        if(this.mascotas==null){
            return 0;
        }else{
            return this.mascotas.size();
        }

    }
 public  MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas =mascotas;
        this.activity=activity;

 }
    public class MascotaViewHolder extends RecyclerView.ViewHolder {
        TextView rVTextName;
        TextView rVTextVotos;
        ImageButton rVImgBtnLike;
        ImageView img;
        Button estrella;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            rVImgBtnLike = itemView.findViewById(R.id.cVImageBtn);
            rVTextName = itemView.findViewById(R.id.cVName);
            rVTextVotos = itemView.findViewById(R.id.cVNumber);
            img = itemView.findViewById(R.id.imageVC);
            estrella = itemView.findViewById(R.id.btnEstrella);
        }
    }
}
