package com.example.myapplication.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.myapplication.Mascota;
import com.example.myapplication.R;
import com.example.myapplication.adapters.profileAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class perfil extends Fragment {



private GridView gridView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate (R.layout.fragment_perfil, container, false);

        gridView =  v.findViewById(R.id.grid);
        gridView.setAdapter(new profileAdapter(v.getContext()));

        return v;

    }


}
