package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;

public class PickaxesDescriptionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickaxes_description);

        Intent i = getIntent();
        TextView pickaxesId = findViewById(R.id.pickaxesId);
        pickaxesId.setText(String.valueOf(i.getIntExtra("pickaxesId", 0)));
    }
}