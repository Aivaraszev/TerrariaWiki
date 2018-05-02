package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.activities.descriptions.HBoomerangsDescriptionActivity;
import com.zevzikovas.aivaras.terraria.adapters.HBoomerangsListAdapter;
import com.zevzikovas.aivaras.terraria.models.HBoomerangs;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

import java.util.List;

public class HBoomerangsActivity extends Activity {
    ListView hboomerangsListView;
    HBoomerangsListAdapter hboomerangsListAdapter;
    List<HBoomerangs> hboomerangs;
    RepositoryManager repositoryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hboomerangs);
        repositoryManager = new RepositoryManager(this);

        hboomerangs = repositoryManager.HBoomerangsRepository.getAllHBoomerang();

        hboomerangsListAdapter = new HBoomerangsListAdapter(this, R.layout.hboomerangs_list_item, hboomerangs);

        hboomerangsListView = findViewById(R.id.HBoomerangsList);
        hboomerangsListView.setAdapter(hboomerangsListAdapter);
        hboomerangsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getApplicationContext(), HBoomerangsDescriptionActivity.class);

                int hboomerangsId = hboomerangs.get(position).id;
                i.putExtra("hboomerangsId", hboomerangsId);

                startActivity(i);
            }
        });
    }
}