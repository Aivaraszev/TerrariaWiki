package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.activities.descriptions.OthersDescriptionActivity;
import com.zevzikovas.aivaras.terraria.adapters.OthersListAdapter;
import com.zevzikovas.aivaras.terraria.models.Others;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

import java.util.List;

public class OthersActivity extends Activity {
    ListView othersListView;
    OthersListAdapter othersListAdapter;
    List<Others> others;
    RepositoryManager repositoryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);
        repositoryManager = new RepositoryManager(this);

        others = repositoryManager.OthersRepository.getAllOther();

        othersListAdapter = new OthersListAdapter(this, R.layout.others_list_item, others);

        othersListView = findViewById(R.id.OthersList);
        othersListView.setAdapter(othersListAdapter);
        othersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getApplicationContext(), OthersDescriptionActivity.class);

                int othersId = others.get(position).id;
                i.putExtra("othersId", othersId);

                startActivity(i);
            }
        });


    }
}