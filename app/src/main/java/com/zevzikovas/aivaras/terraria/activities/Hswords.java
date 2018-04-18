package com.zevzikovas.aivaras.terraria.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;

import com.zevzikovas.aivaras.terraria.R;

public class Hswords extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hswords);
    }
    repositoryManager = new RepositoryManager(this);

    items = repositoryManager.itemsRepository.getAllItems();

    itemListAdapter = new ItemListAdapter(this, R.layout.item_list_item, items);

    itemListView = findViewById(R.id.ItemsList);
        itemListView.setAdapter(itemListAdapter);
        itemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Intent i = new Intent(getApplicationContext(), ItemDescriptionActivity.class);

            int itemId = items.get(position).id;
            i.putExtra("itemId", itemId);

            startActivity(i);
        }
    }

}
