package com.zevzikovas.aivaras.terraria.activities.both;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.activities.FlailsActivity;
import com.zevzikovas.aivaras.terraria.activities.HFlailsActivity;

public class BothFlailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_both_flails);
    }
    public void HFlailsList (View view) {
        Intent intent = new Intent(getApplicationContext(), HFlailsActivity.class);
        startActivity(intent);
    }
    public void FlailsList (View view) {
        Intent intent = new Intent(getApplicationContext(), FlailsActivity.class);
        startActivity(intent);
    }
}