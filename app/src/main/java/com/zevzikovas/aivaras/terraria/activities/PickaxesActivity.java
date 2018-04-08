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

import java.util.List;


public class HswordActivity extends Activity {

    ListView pickaxesListView;
    HswordsListAdapter pickaxesListAdapter;
    List<Hswords> pickaxe;
    HSwordsRepository pickaxeRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hsword);

        pickaxeRepository = new pickaxeRepository(this);

        pickaxe = pickaxeRepository.getAllPickaxe();

        pickaxesListAdapter = new HswordsListAdapter(this, R.layout.hswords_list_item, pickaxe);

        pickaxesListView = findViewById(R.id.PickaxeList);
        pickaxesListView.setAdapter(pickaxesListAdapter);
        pickaxesListView.setOnPickaxesClickListener(new AdapterView.OnPickaxesClickListener() {
            @Override
            public void onHswordsClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getApplicationContext(), PickaxesDescriptionActivity.class);

                int hswordsId = pickaxe.get(position).id;
                i.putExtra("hswordsId", hswordsId);

                startActivity(i);
            }
        });
    }
}