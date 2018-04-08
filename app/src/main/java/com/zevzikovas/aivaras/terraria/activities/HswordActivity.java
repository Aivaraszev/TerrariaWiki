package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.adapters.HswordsListAdapter;
import com.zevzikovas.aivaras.terraria.models.Hswords;
import com.zevzikovas.aivaras.terraria.repositories.HSwordsRepository;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

import java.util.List;


public class HswordActivity extends Activity {

    ListView hswordsListView;
    HswordsListAdapter hswordsListAdapter;
    List<Hswords> hsword;
    RepositoryManager repositoryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hsword);

        repositoryManager = new RepositoryManager(this);

        hsword = repositoryManager.hSwordsRepository.getAllHsword();

        hswordsListAdapter = new HswordsListAdapter(this, R.layout.hswords_list_item, hsword);

        hswordsListView = findViewById(R.id.HswordList);
        hswordsListView.setAdapter(hswordsListAdapter);
        hswordsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getApplicationContext(), HswordDescriptionActivity.class);

                int hswordsId = hsword.get(position).id;
                i.putExtra("hswordsId", hswordsId);

                startActivity(i);
            }
        });
    }
}