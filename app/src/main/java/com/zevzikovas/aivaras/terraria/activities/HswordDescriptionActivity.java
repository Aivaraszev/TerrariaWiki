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
        TextView hswordsKnockback = findViewById(R.id.hswordsKnockback);
        TextView hswordsCritical_chance = findViewById(R.id.hswordsCritical_chance);
        TextView hswordsUse_time = findViewById(R.id.hswordsUse_time);
        TextView hswordsVelocity = findViewById(R.id.hswordsVelocity);
        TextView hswordsTooltip = findViewById(R.id.hswordsTooltip);
        TextView hswordsGrants_buff = findViewById(R.id.hswordsGrants_buff);
        TextView hswordsInflicts_debuff = findViewById(R.id.hswordsInflicts_debuff);
        TextView hswordsRarity = findViewById(R.id.hswordsRarity);
        TextView hswordsBuy_price = findViewById(R.id.hswordsBuy_price);
        TextView hswordsSell_price = findViewById(R.id.hswordsSell_price);

        hswordsDamage.setText(Integer.toString(hsword.damage));
        hswordsKnockback.setText((hsword.knockback));
        hswordsCritical_chance.setText((hsword.critical_chance));
        hswordsUse_time.setText(Integer.toString(hsword.use_time));
        hswordsVelocity.setText((hsword.velocity));
        hswordsTooltip.setText((hsword.tooltip));
        hswordsGrants_buff.setText((hsword.grants_buff));
        hswordsInflicts_debuff.setText((hsword.inflicts_debuff));
        hswordsRarity.setText((hsword.rarity));
        hswordsBuy_price.setText((hsword.buy_price));
        hswordsSell_price.setText((hsword.sell_price));
    }
}