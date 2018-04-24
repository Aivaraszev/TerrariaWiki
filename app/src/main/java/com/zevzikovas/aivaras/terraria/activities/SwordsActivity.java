package com.zevzikovas.aivaras.terraria.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.adapters.ItemListAdapter;
import com.zevzikovas.aivaras.terraria.models.Swords;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

import java.util.List;

public class SwordsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swords);

        ListView swordsListView;
        ItemListAdapter itemListAdapter;
        final List<Swords> Swords;
        RepositoryManager repositoryManager;

        repositoryManager = new RepositoryManager(this);

        Swords = repositoryManager.SwordsRepository.getAllItems();

        itemListAdapter = new ItemListAdapter(this, R.layout.swords_list_item, Swords);

        SwordsListView = findViewById(R.id.SwordsList);
        SwordsListView.setAdapter(SwordsListAdapter);
        SwordsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getApplicationContext(), SwordsDescriptionActivity.class);

                int swordId = Swords.get(position).id;
                i.putExtra("swordId", swordId);

                startActivity(i);
            }
        });


    }
}