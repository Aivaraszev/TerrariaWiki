package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.adapters.YoyosListAdapter;
import com.zevzikovas.aivaras.terraria.models.Yoyos;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

import java.util.List;

public class YoyosActivity  extends Activity {
    ListView yoyosListView;
    YoyosListAdapter yoyosListAdapter;
    List<Yoyos> yoyos;
    RepositoryManager repositoryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoyos);
        repositoryManager = new RepositoryManager(this);

        yoyos = repositoryManager.YoyosRepository.getAllYoyos();

        yoyosListAdapter = new YoyosListAdapter(this, R.layout.yoyos_list_item, yoyos);

        yoyosListView = findViewById(R.id.YoyosList);
        yoyosListView.setAdapter(yoyosListAdapter);
        yoyosListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getApplicationContext(), YoyosDescriptionActivity.class);

                int yoyosId = yoyos.get(position).id;
                i.putExtra("yoyosId", yoyosId);

                startActivity(i);
            }
        });


    }
}
