package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;

public class HswordDescriptionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hswords_description);

        Intent i = getIntent();
        TextView hswordsId = findViewById(R.id.hswordsId);
        TextView hswordsDamage = findViewById(R.id.hswordsDamage);
        hswordsId.setText(String.valueOf(i.getIntExtra("hswordsId", 0)));
        hswordsDamage.setText(String.valueOf(i.getIntExtra("hswordsDamage", 0)));
    }
}
