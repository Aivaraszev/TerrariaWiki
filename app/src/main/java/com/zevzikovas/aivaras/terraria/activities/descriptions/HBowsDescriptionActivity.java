package com.zevzikovas.aivaras.terraria.activities.descriptions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.HBows;

import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

public class HBowsDescriptionActivity extends Activity {

    RepositoryManager repositoryManager = new RepositoryManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hbows_description);

        Intent i = getIntent();
        HBows hbows = repositoryManager.HBowsRepository.getHBows(i.getIntExtra("hbowsId", 0));

        TextView hbowsDamage = findViewById(R.id.hbowDamage);
        TextView hbowsKnockback = findViewById(R.id.hbowKnockback);
        TextView hbowsCritical_chance = findViewById(R.id.hbowCritical_chance);
        TextView hbowsUse_time = findViewById(R.id.hbowUse_time);
        TextView hbowsVelocity = findViewById(R.id.hbowVelocity);
        TextView hbowsTooltip = findViewById(R.id.hbowTooltip);
        TextView hbowsGrants_buff = findViewById(R.id.hbowGrants_buff);
        TextView hbowsInflicts_debuff = findViewById(R.id.hbowInflicts_debuff);
        TextView hbowsRarity = findViewById(R.id.hbowRarity);
        TextView hbowsBuy_price = findViewById(R.id.hbowBuy_price);
        TextView hbowsSell_price = findViewById(R.id.hbowSell_price);

        hbowsDamage.setText(Integer.toString(hbows.damage));
        hbowsKnockback.setText((hbows.knockback));
        hbowsCritical_chance.setText((hbows.critical_chance));
        hbowsUse_time.setText((hbows.use_time));
        hbowsVelocity.setText((hbows.velocity));
        hbowsTooltip.setText((hbows.tooltip));
        hbowsGrants_buff.setText((hbows.grants_buff));
        hbowsInflicts_debuff.setText((hbows.inflicts_debuff));
        hbowsRarity.setText((hbows.rarity));
        hbowsBuy_price.setText((hbows.buy_price));
        hbowsSell_price.setText((hbows.sell_price));
    }
}