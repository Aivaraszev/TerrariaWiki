package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.HBoomerangs;
import com.zevzikovas.aivaras.terraria.models.HBoomerangs;

import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

public class HBoomerangsDescriptionActivity extends Activity {

    RepositoryManager repositoryManager = new RepositoryManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hboomerangs_description);

        Intent i = getIntent();
        HBoomerangs hboomerangs = repositoryManager.HBoomerangsRepository.getHboomerang(i.getIntExtra("hboomerangsId", 0));

        TextView hboomerangsDamage = findViewById(R.id.hboomerangsDamage);
        TextView hboomerangsKnockback = findViewById(R.id.hboomerangsKnockback);
        TextView hboomerangsCritical_chance = findViewById(R.id.hboomerangsCritical_chance);
        TextView hboomerangsUse_time = findViewById(R.id.hboomerangsUse_time);
        TextView hboomerangsVelocity = findViewById(R.id.hboomerangsVelocity);
        TextView hboomerangsTooltip = findViewById(R.id.hboomerangsTooltip);
        TextView hboomerangsGrants_buff = findViewById(R.id.hboomerangsGrants_buff);
        TextView hboomerangsInflicts_debuff = findViewById(R.id.hboomerangsInflicts_debuff);
        TextView hboomerangsRarity = findViewById(R.id.hboomerangsRarity);
        TextView hboomerangsBuy_price = findViewById(R.id.hboomerangsBuy_price);
        TextView hboomerangsSell_price = findViewById(R.id.hboomerangsSell_price);

        hboomerangsDamage.setText(Integer.toString(hboomerangs.damage));
        hboomerangsKnockback.setText((hboomerangs.knockback));
        hboomerangsCritical_chance.setText((hboomerangs.critical_chance));
        hboomerangsUse_time.setText((hboomerangs.use_time));
        hboomerangsVelocity.setText((hboomerangs.velocity));
        hboomerangsTooltip.setText((hboomerangs.tooltip));
        hboomerangsGrants_buff.setText((hboomerangs.grants_buff));
        hboomerangsInflicts_debuff.setText((hboomerangs.inflicts_debuff));
        hboomerangsRarity.setText((hboomerangs.rarity));
        hboomerangsBuy_price.setText((hboomerangs.buy_price));
        hboomerangsSell_price.setText((hboomerangs.sell_price));
    }
}