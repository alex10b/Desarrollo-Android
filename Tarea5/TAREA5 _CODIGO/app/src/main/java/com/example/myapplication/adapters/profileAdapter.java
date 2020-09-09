package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Fragments.perfil;
import com.example.myapplication.Mascota;
import com.example.myapplication.R;

import java.util.ArrayList;

public class profileAdapter extends BaseAdapter {

    private Context cn;
    public profileAdapter(Context cn){
   this.cn=cn;

    }
    @Override
    public int getCount() {
        return fotos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView imageView;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) cn
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_perfil, viewGroup, false);



            }

        imageView  = view.findViewById(R.id.imagen);



       imageView.setImageResource(fotos[position]);
        TextView textView = view.findViewById(R.id.votos);
        textView.setText("2");
        return  view;
    }
    private int[] fotos= {
            R.drawable.max, R.drawable.max, R.drawable.max, R.drawable.max,
                    R.drawable.perromano,R.drawable.perromano,R.drawable.max,R.drawable.max,
                    R.drawable.max,R.drawable.max,R.drawable.max,R.drawable.max,
                    R.drawable.max,R.drawable.max,R.drawable.max,R.drawable.max
    } ;
}
