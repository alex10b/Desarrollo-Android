package com.example.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

  ArrayList<Mascota> mascotas;
  Activity activity;
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.rVTextVotos.setText(String.valueOf(mascota.getVotos()));
        holder.img.setImageResource(mascota.getImg());
        holder.rVTextName.setText(mascota.getNombre());
        holder.rVImgBtnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascota.setVotos((mascota.getVotos())+1);
                holder.rVTextVotos.setText(String.valueOf(mascota.getVotos()));
                Toast.makeText(activity,"Diste like a "+ mascota.getNombre(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return this.mascotas.size();
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

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            rVImgBtnLike = itemView.findViewById(R.id.cVImageBtn);
            rVTextName = itemView.findViewById(R.id.cVName);
            rVTextVotos = itemView.findViewById(R.id.cVNumber);
            img = itemView.findViewById(R.id.imageVC);
        }
    }
}
