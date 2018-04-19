package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.zevzikovas.aivaras.terraria.R;
import java.util.List;

public class ItemsActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
    }
        public void WeaponsList (View view) {
            Intent intent = new Intent(getApplicationContext(), WeaponsActivity.class);
            startActivity(intent);
        }
      public void PickaxesList (View view) {
            Intent intent = new Intent(getApplicationContext(), WeaponsActivity.class);
            startActivity(intent);
    }

    }

