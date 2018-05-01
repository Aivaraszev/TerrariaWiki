package com.zevzikovas.aivaras.terraria.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.zevzikovas.aivaras.terraria.R;

public class BothBoomerangsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_both_boomernags);
    }
    public void BoomerangsList (View view) {
        Intent intent = new Intent(getApplicationContext(), BoomerangsActivity.class);
        startActivity(intent);
    }
    public void HBoomerangsList (View view) {
        Intent intent = new Intent(getApplicationContext(), HBoomerangsActivity.class);
        startActivity(intent);
    }
}
