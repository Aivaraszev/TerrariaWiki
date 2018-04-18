package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.adapters.ItemListAdapter;
import com.zevzikovas.aivaras.terraria.models.Item;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

import java.util.List;

public class ItemsActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        public void HswordsList (View view) {
            Intent intent = new Intent(getApplicationContext(), HswordsActivity.class);
            startActivity(intent);
        }
    }

