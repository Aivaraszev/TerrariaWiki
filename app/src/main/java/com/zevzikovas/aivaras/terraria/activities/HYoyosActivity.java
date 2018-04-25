package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.adapters.HYoyosListAdapter;
import com.zevzikovas.aivaras.terraria.models.HYoyos;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

import java.util.List;

public class HYoyosActivity  extends Activity {
    ListView hyoyosListView;
    HYoyosListAdapter hyoyosListAdapter;
    List<HYoyos> hyoyos;
    RepositoryManager repositoryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hyoyos);
        repositoryManager = new RepositoryManager(this);

        hyoyos = repositoryManager.HYoyosRepository.getAllHYoyos();

        hyoyosListAdapter = new HYoyosListAdapter(this, R.layout.hyoyos_list_item, hyoyos);

        hyoyosListView = findViewById(R.id.HYoyosList);
        hyoyosListView.setAdapter(hyoyosListAdapter);
        hyoyosListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getApplicationContext(), HYoyosDescriptionActivity.class);

                int hyoyosId = hyoyos.get(position).id;
                i.putExtra("hyoyosId", hyoyosId);

                startActivity(i);
            }
        });


    }
}
