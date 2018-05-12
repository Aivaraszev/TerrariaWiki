package com.zevzikovas.aivaras.terraria.activities.both;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.activities.BowsActivity;
import com.zevzikovas.aivaras.terraria.activities.BowsActivity;
import com.zevzikovas.aivaras.terraria.activities.HBowsActivity;

public class BothBowsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_both_bows);
    }
    public void BowsList (View view) {
        Intent intent = new Intent(getApplicationContext(), BowsActivity.class);
        startActivity(intent);
    }
    public void HBowsList (View view) {
        Intent intent = new Intent(getApplicationContext(), HBowsActivity.class);
        startActivity(intent);
    }
}