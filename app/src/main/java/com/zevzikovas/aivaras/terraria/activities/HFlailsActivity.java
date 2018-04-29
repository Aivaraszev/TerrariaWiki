package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.adapters.HFlailsListAdapter;
import com.zevzikovas.aivaras.terraria.models.HFlails;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

import java.util.List;

public class HFlailsActivity extends Activity {
    ListView hflailsListView;
    HFlailsListAdapter hflailsListAdapter;
    List<HFlails> hflails;
    RepositoryManager repositoryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hflails);
        repositoryManager = new RepositoryManager(this);

        hflails = repositoryManager.HFlailsRepository.getAllHFlails();

        hflailsListAdapter = new HFlailsListAdapter(this, R.layout.hflails_list_item, hflails);

        hflailsListView = findViewById(R.id.HFlailsList);
        hflailsListView.setAdapter(hflailsListAdapter);
        hflailsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getApplicationContext(), HFlailsDescriptionActivity.class);

                int hflailsId = hflails.get(position).id;
                i.putExtra("hflailsId", hflailsId);

                startActivity(i);
            }
        });


    }
}