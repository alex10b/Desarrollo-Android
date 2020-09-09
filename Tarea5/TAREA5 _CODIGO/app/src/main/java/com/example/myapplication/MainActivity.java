package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SeekBar;

import com.example.myapplication.Fragments.perfil;
import com.example.myapplication.Fragments.recyclerView;
import com.example.myapplication.adapters.MascotaAdaptador;
import com.example.myapplication.adapters.ViewPagerAdapter;
import com.example.myapplication.adapters.profileAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

private ViewPager viewPager;
private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button btn = findViewById(R.id.btnEstrella);
       tabLayout = findViewById(R.id.tabLayout);
       viewPager = findViewById(R.id.viewPager);

        Toolbar myChildToolbar = findViewById(R.id.miActionBarMain);

        setSupportActionBar(myChildToolbar);

        ActionBar ab = getSupportActionBar();

        ab.setDisplayShowTitleEnabled(false);


       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this,Favoritas.class);

           startActivity(intent);
           }
       });

        setUpViewpager();

    }


private  ArrayList<Fragment> agregar(){
    ArrayList<Fragment> e =new ArrayList<>();
    e.add(new recyclerView());
    e.add(new perfil());

    return e;
}

    public  void setUpViewpager(){
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), agregar()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_profile);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_opc,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i = new Intent();

        switch (item.getItemId()){
            case R.id.menu_acerca: i =new Intent(this,AcercaDe.class); break;
            case R.id.menu_contacto: i =new Intent(this,Contacto.class); break;

        }


        startActivity(i);
        return super.onContextItemSelected(item);

    }

}
