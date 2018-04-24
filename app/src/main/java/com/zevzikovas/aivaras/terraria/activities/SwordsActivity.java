package com.zevzikovas.aivaras.terraria.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.adapters.SwordsListAdapter;
import com.zevzikovas.aivaras.terraria.models.Swords;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

import java.util.List;

public class SwordsActivity extends Activity {
    ListView swordsListView;
    SwordsListAdapter swordsListAdapter;
    List<Swords> swords;
    RepositoryManager repositoryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swords);
        repositoryManager = new RepositoryManager(this);

        swords = repositoryManager.swordsRepository.getAllSword();

        swordsListAdapter = new SwordsListAdapter(this, R.layout.swords_list_item, swords);

        swordsListView = findViewById(R.id.SwordsList);
        swordsListView.setAdapter(swordsListAdapter);
        swordsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getApplicationContext(), SwordsDescriptionActivity.class);

                int swordsId = swords.get(position).id;
                i.putExtra("swordsId", swordsId);

                startActivity(i);
            }
        });


    }
}