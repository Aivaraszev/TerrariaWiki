package com.zevzikovas.aivaras.terraria.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.zevzikovas.aivaras.terraria.R;

public class WeaponsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapons);
    }
    public void BothSwordsActivity (View view) {
        Intent intent = new Intent(getApplicationContext(), BothSwordsActivity.class);
        startActivity(intent);
    }
    public void BothYoyosActivity (View view) {
        Intent intent = new Intent(getApplicationContext(), BothYoyosActivity.class);
        startActivity(intent);
    }
    public void BothSpearsActivity (View view) {
        Intent intent = new Intent(getApplicationContext(), BothSpearsActivity.class);
        startActivity(intent);
    }
    public void BothBoomerangsActivity (View view) {
        Intent intent = new Intent(getApplicationContext(), BothBoomerangsActivity.class);
        startActivity(intent);
    }
}
