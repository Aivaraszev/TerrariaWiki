package com.zevzikovas.aivaras.terraria.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.zevzikovas.aivaras.terraria.R;

public class BothFlailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_both_flails);
    }
    public void HFlailsList (View view) {
        Intent intent = new Intent(getApplicationContext(), HSwordsActivity.class);
        startActivity(intent);
    }
    public void FlailsList (View view) {
        Intent intent = new Intent(getApplicationContext(), SwordsActivity.class);
        startActivity(intent);
    }
}
