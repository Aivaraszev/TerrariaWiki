package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Spears;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

public class SpearsDescriptionActivity extends Activity {

    RepositoryManager repositoryManager = new RepositoryManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spears_description);

        Intent i = getIntent();
        Spears spear = repositoryManager.SpearsRepository.getSpear(i.getIntExtra("spearsId", 0));

        TextView spearsDamage = findViewById(R.id.spearsDamage);
        TextView spearsKnockback = findViewById(R.id.spearsKnockback);
        TextView spearsCritical_chance = findViewById(R.id.spearsCritical_chance);
        TextView spearsUse_time = findViewById(R.id.spearsUse_time);
        TextView spearsVelocity = findViewById(R.id.spearsVelocity);
        TextView spearsTooltip = findViewById(R.id.spearsTooltip);
        TextView spearsGrants_buff = findViewById(R.id.spearsGrants_buff);
        TextView spearsInflicts_debuff = findViewById(R.id.spearsInflicts_debuff);
        TextView spearsRarity = findViewById(R.id.spearsRarity);
        TextView spearsBuy_price = findViewById(R.id.spearsBuy_price);
        TextView spearsSell_price = findViewById(R.id.spearsSell_price);

        spearsDamage.setText(Integer.toString(spear.damage));
        spearsKnockback.setText((spear.knockback));
        spearsCritical_chance.setText((spear.critical_chance));
        spearsUse_time.setText((spear.use_time));
        spearsVelocity.setText((spear.velocity));
        spearsTooltip.setText((spear.tooltip));
        spearsGrants_buff.setText((spear.grants_buff));
        spearsInflicts_debuff.setText((spear.inflicts_debuff));
        spearsRarity.setText((spear.rarity));
        spearsBuy_price.setText((spear.buy_price));
        spearsSell_price.setText((spear.sell_price));
    }
}