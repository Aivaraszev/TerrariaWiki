package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Hswords;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

public class HswordDescriptionActivity extends Activity {

    RepositoryManager repositoryManager = new RepositoryManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hswords_description);

        Intent i = getIntent();
        Hswords hsword = repositoryManager.hSwordsRepository.getSword(i.getIntExtra("hswordsId", 0));

        TextView hswordsDamage = findViewById(R.id.hswordsDamage);

        hswordsDamage.setText(Integer.toString(hsword.damage));
    }
}