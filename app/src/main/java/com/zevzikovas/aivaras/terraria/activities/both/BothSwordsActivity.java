package com.zevzikovas.aivaras.terraria.activities.both;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.activities.HswordsActivity;
import com.zevzikovas.aivaras.terraria.activities.SwordsActivity;

public class BothSwordsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_both_swords);
    }
    public void HswordsList (View view) {
        Intent intent = new Intent(getApplicationContext(), HswordsActivity.class);
        startActivity(intent);
    }
    public void SwordsList (View view) {
        Intent intent = new Intent(getApplicationContext(), SwordsActivity.class);
        startActivity(intent);
    }
}
