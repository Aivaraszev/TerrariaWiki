package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Flails;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

public class FlailsDescriptionActivity extends Activity {

    RepositoryManager repositoryManager = new RepositoryManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boomerangs_description);

        Intent i = getIntent();
        Boomerangs boomerang = repositoryManager.BoomerangsRepository.getBoomerang(i.getIntExtra("boomerangsId", 0));

        TextView boomerangDamage = findViewById(R.id.boomerangDamage);
        TextView boomerangKnockback = findViewById(R.id.boomerangKnockback);
        TextView boomerangCritical_chance = findViewById(R.id.boomerangCritical_chance);
        TextView boomerangUse_time = findViewById(R.id.boomerangUse_time);
        TextView boomerangVelocity = findViewById(R.id.boomerangVelocity);
        TextView boomerangTooltip = findViewById(R.id.boomerangTooltip);
        TextView boomerangGrants_buff = findViewById(R.id.boomerangGrants_buff);
        TextView boomerangInflicts_debuff = findViewById(R.id.boomerangInflicts_debuff);
        TextView boomerangRarity = findViewById(R.id.boomerangRarity);
        TextView boomerangBuy_price = findViewById(R.id.boomerangBuy_price);
        TextView boomerangSell_price = findViewById(R.id.boomerangSell_price);

        boomerangDamage.setText(Integer.toString(boomerang.damage));
        boomerangKnockback.setText((boomerang.knockback));
        boomerangCritical_chance.setText((boomerang.critical_chance));
        boomerangUse_time.setText((boomerang.use_time));
        boomerangVelocity.setText((boomerang.velocity));
        boomerangTooltip.setText((boomerang.tooltip));
        boomerangGrants_buff.setText((boomerang.grants_buff));
        boomerangInflicts_debuff.setText((boomerang.inflicts_debuff));
        boomerangRarity.setText((boomerang.rarity));
        boomerangBuy_price.setText((boomerang.buy_price));
        boomerangSell_price.setText((boomerang.sell_price));
    }
}