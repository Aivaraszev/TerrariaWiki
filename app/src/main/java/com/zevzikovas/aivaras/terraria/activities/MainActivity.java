package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zevzikovas.aivaras.terraria.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GameInfo (View view) {
        Intent intent = new Intent(getApplicationContext(), GameInfoActivity.class);
        startActivity(intent);
    }
    public void ItemsList(View view) {
        Intent intent = new Intent(getApplicationContext(), ItemsActivity.class);
        startActivity(intent);
    }
}
