package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.activities.descriptions.HBowsDescriptionActivity;
import com.zevzikovas.aivaras.terraria.activities.descriptions.HBowsDescriptionActivity;
import com.zevzikovas.aivaras.terraria.adapters.HBowsListAdapter;
import com.zevzikovas.aivaras.terraria.adapters.HBowsListAdapter;
import com.zevzikovas.aivaras.terraria.models.HBows;
import com.zevzikovas.aivaras.terraria.models.HBows;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

import java.util.List;

public class HBowsActivity extends Activity {
    ListView hbowsListView;
    HBowsListAdapter hbowsListAdapter;
    List<HBows> hbows;
    RepositoryManager repositoryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hbows);
        repositoryManager = new RepositoryManager(this);

        hbows = repositoryManager.HBowsRepository.getAllHBow();

        hbowsListAdapter = new HBowsListAdapter(this, R.layout.hbows_list_item, hbows);

        hbowsListView = findViewById(R.id.HBowsList);
        hbowsListView.setAdapter(hbowsListAdapter);
        hbowsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getApplicationContext(), HBowsDescriptionActivity.class);

                int hbowsId = hbows.get(position).id;
                i.putExtra("hbowsId", hbowsId);

                startActivity(i);
            }
        });
    }
}