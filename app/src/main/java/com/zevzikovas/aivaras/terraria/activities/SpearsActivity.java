package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.adapters.SpearsListAdapter;
import com.zevzikovas.aivaras.terraria.models.Spears;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

import java.util.List;

public class SpearsActivity extends Activity {
    ListView spearsListView;
    SpearsListAdapter spearsListAdapter;
    List<Spears> spears;
    RepositoryManager repositoryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hspears);
        repositoryManager = new RepositoryManager(this);

        spears = repositoryManager.SpearsRepository.getAllSpear();

        spearsListAdapter = new SpearsListAdapter(this, R.layout.spears_list_item, spears);

        spearsListView = findViewById(R.id.SpearsList);
        spearsListView.setAdapter(spearsListAdapter);
        spearsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getApplicationContext(), SpearsDescriptionActivity.class);

                int spearsId = spears.get(position).id;
                i.putExtra("spearsId", spearsId);

                startActivity(i);
            }
        });


    }
}