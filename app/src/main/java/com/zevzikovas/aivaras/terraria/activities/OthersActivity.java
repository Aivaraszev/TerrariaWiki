package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.adapters.OthersListAdapter;
import com.zevzikovas.aivaras.terraria.models.Hswords;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

import java.util.List;

public class OthersActivity extends Activity {
    ListView othersListView;
    OthersListAdapter othersListAdapter;
    List<Hswords> others;
    RepositoryManager repositoryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hswords);
        repositoryManager = new RepositoryManager(this);

        hswords = repositoryManager.hSwordsRepository.getAllHsword();

        hswordsListAdapter = new OthersListAdapter(this, R.layout.hswords_list_item, hswords);

        hswordsListView = findViewById(R.id.HswordsList);
        hswordsListView.setAdapter(othersListAdapter);
        hswordsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getApplicationContext(), HswordDescriptionActivity.class);

                int hswordsId = hswords.get(position).id;
                i.putExtra("hswordsId", hswordsId);

                startActivity(i);
            }
        });


    }
}