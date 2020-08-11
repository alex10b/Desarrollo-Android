package com.example.myapplication.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.Mascota;
import com.example.myapplication.R;
import com.example.myapplication.adapters.MascotaAdaptador;

import java.util.ArrayList;

public class recyclerView extends Fragment {
    private RecyclerView rv ;
    private ArrayList<Mascota> aM;
    public recyclerView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_recycler_view, container, false);

        rv = v.findViewById(R.id.rvMascota);
        LinearLayoutManager lnm = new LinearLayoutManager(getActivity());
        Button btnL =  v.findViewById(R.id.btnEstrella);

        lnm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(lnm);
        llenarMascotas();
        Mascota m = aM.get(4);
        int fotos[]={R.drawable.max,R.drawable.max,R.drawable.max,R.drawable.max,R.drawable.max,R.drawable.max,R.drawable.max,R.drawable.max,R.drawable.max,R.drawable.max};
        m.setFotos(fotos);
        perfil fragment = (perfil) getFragmentManager().findFragmentById(R.id.fragment_id);
        Bundle bundle = new Bundle();
        bundle.putInt("n", 1);


      //  fragment.setArguments(bundle);


        inicializarAdaptador();
        return v;
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
        MascotaAdaptador adaptador = new MascotaAdaptador(aM,getActivity());

        rv.setAdapter(adaptador);
    }


}
