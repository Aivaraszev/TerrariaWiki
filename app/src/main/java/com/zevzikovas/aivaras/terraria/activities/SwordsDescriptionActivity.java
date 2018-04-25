package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Swords;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

public class SwordsDescriptionActivity extends Activity {

    RepositoryManager repositoryManager = new RepositoryManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swords_description);

        Intent i = getIntent();
        Swords sword = repositoryManager.swordsRepository.getSword(i.getIntExtra("swordsId", 0));

        TextView swordsDamage = findViewById(R.id.swordsDamage);
        TextView swordsKnockback = findViewById(R.id.swordsKnockback);
        TextView swordsCritical_chance = findViewById(R.id.swordsCritical_chance);
        TextView swordsUse_time = findViewById(R.id.swordsUse_time);
        TextView swordsVelocity = findViewById(R.id.swordsVelocity);
        TextView swordsTooltip = findViewById(R.id.swordsTooltip);
        TextView swordsGrants_buff = findViewById(R.id.swordsGrants_buff);
        TextView swordsInflicts_debuff = findViewById(R.id.swordsInflicts_debuff);
        TextView swordsRarity = findViewById(R.id.swordsRarity);
        TextView swordsBuy_price = findViewById(R.id.swordsBuy_price);
        TextView swordsSell_price = findViewById(R.id.swordsSell_price);

        swordsDamage.setText(Integer.toString(sword.damage));
        swordsKnockback.setText((sword.knockback));
        swordsCritical_chance.setText((sword.critical_chance));
        swordsUse_time.setText((sword.use_time));
        swordsVelocity.setText((sword.velocity));
        swordsTooltip.setText((sword.tooltip));
        swordsGrants_buff.setText((sword.grants_buff));
        swordsInflicts_debuff.setText((sword.inflicts_debuff));
        swordsRarity.setText((sword.rarity));
        swordsBuy_price.setText((sword.buy_price));
        swordsSell_price.setText((sword.sell_price));
    }
}