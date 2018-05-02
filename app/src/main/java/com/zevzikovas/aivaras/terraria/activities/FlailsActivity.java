package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.activities.descriptions.FlailsDescriptionActivity;
import com.zevzikovas.aivaras.terraria.adapters.FlailsListAdapter;
import com.zevzikovas.aivaras.terraria.models.Flails;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

import java.util.List;

public class FlailsActivity extends Activity {
    ListView flailsListView;
    FlailsListAdapter flailsListAdapter;
    List<Flails> flails;
    RepositoryManager repositoryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flails);
        repositoryManager = new RepositoryManager(this);

        flails = repositoryManager.FlailsRepository.getAllFlails();

        flailsListAdapter = new FlailsListAdapter(this, R.layout.flails_list_item, flails);

        flailsListView = findViewById(R.id.FlailsList);
        flailsListView.setAdapter(flailsListAdapter);
        flailsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getApplicationContext(), FlailsDescriptionActivity.class);

                int flailsId = flails.get(position).id;
                i.putExtra("flailsId", flailsId);

                startActivity(i);
            }
        });


    }
}