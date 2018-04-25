package com.zevzikovas.aivaras.terraria.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.zevzikovas.aivaras.terraria.R;

public class BothYoyosActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_both_yoyos);
    }
    public void YoyosList (View view) {
        Intent intent = new Intent(getApplicationContext(), YoyosActivity.class);
        startActivity(intent);
    }
    public void HYoyosList (View view) {
        Intent intent = new Intent(getApplicationContext(), HYoyosActivity.class);
        startActivity(intent);
    }
}
