package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.adapters.HSpearsListAdapter;
import com.zevzikovas.aivaras.terraria.models.HSpears;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

import java.util.List;

public class HSpearsActivity extends Activity {
    ListView hspearsListView;
    HSpearsListAdapter hspearsListAdapter;
    List<HSpears> hspears;
    RepositoryManager repositoryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hspears);
        repositoryManager = new RepositoryManager(this);

        hspears = repositoryManager.HSpearsRepository.getAllHSpear();

        hspearsListAdapter = new HSpearsListAdapter(this, R.layout.hspears_list_item, hspears);

        hspearsListView = findViewById(R.id.HSpearsList);
        hspearsListView.setAdapter(hspearsListAdapter);
        hspearsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getApplicationContext(), HSpearsDescriptionActivity.class);

                int hspearsId = hspears.get(position).id;
                i.putExtra("hspearsId", hspearsId);

                startActivity(i);
            }
        });


    }
}