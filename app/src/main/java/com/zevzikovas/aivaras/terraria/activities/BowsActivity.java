package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.activities.descriptions.BowsDescriptionActivity;
import com.zevzikovas.aivaras.terraria.adapters.BowsListAdapter;
import com.zevzikovas.aivaras.terraria.adapters.BowsListAdapter;
import com.zevzikovas.aivaras.terraria.models.Bows;
import com.zevzikovas.aivaras.terraria.models.Bows;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

import java.util.List;

public class BowsActivity extends Activity {
    ListView bowsListView;
    BowsListAdapter bowsListAdapter;
    List<Bows> bows;
    RepositoryManager repositoryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bows);
        repositoryManager = new RepositoryManager(this);

        bows = repositoryManager.BowsRepository.getAllBow();

        bowsListAdapter = new BowsListAdapter(this, R.layout.bows_list_item, bows);

        bowsListView = findViewById(R.id.BowsList);
        bowsListView.setAdapter(bowsListAdapter);
        bowsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getApplicationContext(), BowsDescriptionActivity.class);

                int bowsId = bows.get(position).id;
                i.putExtra("bowsId", bowsId);

                startActivity(i);
            }
        });


    }
}