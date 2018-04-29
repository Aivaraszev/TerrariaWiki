package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.adapters.BoomerangsListAdapter;
import com.zevzikovas.aivaras.terraria.models.Boomerangs;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

import java.util.List;

public class BoomerangsActivity extends Activity {
    ListView boomerangsListView;
    BoomerangsListAdapter boomerangsListAdapter;
    List<Boomerangs> boomerangs;
    RepositoryManager repositoryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hswords);
        repositoryManager = new RepositoryManager(this);

        boomerangs = repositoryManager.BoomerangsRepository.getAllBoomerang();

        boomerangsListAdapter = new BoomerangsListAdapter(this, R.layout.boomerangs_list_item, boomerangs);

        boomerangsListView = findViewById(R.id.HswordsList);
        boomerangsListView.setAdapter(boomerangsListAdapter);
        boomerangsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getApplicationContext(), BoomerangsDescriptionActivity.class);

                int boomerangsId = boomerangs.get(position).id;
                i.putExtra("boomerangsId", boomerangsId);

                startActivity(i);
            }
        });


    }
}