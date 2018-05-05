package com.zevzikovas.aivaras.terraria.activities.both;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.activities.HSpearsActivity;
import com.zevzikovas.aivaras.terraria.activities.SpearsActivity;

public class BothSpearsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_both_spears);
    }
    public void SpearsList (View view) {
        Intent intent = new Intent(getApplicationContext(), SpearsActivity.class);
        startActivity(intent);
    }
    public void HSpearsList (View view) {
        Intent intent = new Intent(getApplicationContext(), HSpearsActivity.class);
        startActivity(intent);
    }
}