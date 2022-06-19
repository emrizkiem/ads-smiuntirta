package com.emrizkiem.myfirstapps.learn.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;

import com.emrizkiem.myfirstapps.R;
import com.emrizkiem.myfirstapps.learn.recyclerview.adapter.ListHeroAdapter;
import com.emrizkiem.myfirstapps.learn.recyclerview.data.Hero;

import java.util.ArrayList;

public class RecyclerviewActivity extends AppCompatActivity {

    private RecyclerView rvHeroes;
    private ArrayList<Hero> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        rvHeroes = findViewById(R.id.rvHero);
        rvHeroes.setHasFixedSize(true);

        list.addAll(getListHeroes());
        showRecyclerList();
    }

    private ArrayList<Hero> getListHeroes() {
        String[] dataName = getResources().getStringArray(R.array.data_hero);
        String[] dataDescription =
                getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto =
                getResources().obtainTypedArray(R.array.data_photo);

        ArrayList<Hero> listHero = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Hero hero = new Hero();
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            hero.setPhoto(dataPhoto.getResourceId(i, -1));

            listHero.add(hero);
        }

        return listHero;
    }

    private void showRecyclerList() {
        if (getApplicationContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvHeroes.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        }
        ListHeroAdapter adapter = new ListHeroAdapter(list);
        rvHeroes.setAdapter(adapter);
    }
}