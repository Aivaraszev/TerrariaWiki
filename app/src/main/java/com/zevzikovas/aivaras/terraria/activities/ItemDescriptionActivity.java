package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;

public class ItemDescriptionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);

        Intent i = getIntent();
        TextView itemId = findViewById(R.id.itemId);
        itemId.setText(String.valueOf(i.getIntExtra("itemId", 0)));
    }
}
