package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.HFlails;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

public class HFlailsDescriptionActivity extends Activity {

    RepositoryManager repositoryManager = new RepositoryManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hflails_description);

        Intent i = getIntent();
        HFlails hflail = repositoryManager.HFlailsRepository.getHFlail(i.getIntExtra("hflailsId", 0));

        TextView hflailDamage = findViewById(R.id.hflailDamage);
        TextView hflailKnockback = findViewById(R.id.hflailKnockback);
        TextView hflailCritical_chance = findViewById(R.id.hflailCritical_chance);
        TextView hflailUse_time = findViewById(R.id.hflailUse_time);
        TextView hflailVelocity = findViewById(R.id.hflailVelocity);
        TextView hflailTooltip = findViewById(R.id.hflailTooltip);
        TextView hflailGrants_buff = findViewById(R.id.hflailGrants_buff);
        TextView hflailInflicts_debuff = findViewById(R.id.hflailInflicts_debuff);
        TextView hflailRarity = findViewById(R.id.hflailRarity);
        TextView hflailBuy_price = findViewById(R.id.hflailBuy_price);
        TextView hflailSell_price = findViewById(R.id.hflailSell_price);

        hflailDamage.setText(Integer.toString(hflail.damage));
        hflailKnockback.setText((hflail.knockback));
        hflailCritical_chance.setText((hflail.critical_chance));
        hflailUse_time.setText((hflail.use_time));
        hflailVelocity.setText((hflail.velocity));
        hflailTooltip.setText((hflail.tooltip));
        hflailGrants_buff.setText((hflail.grants_buff));
        hflailInflicts_debuff.setText((hflail.inflicts_debuff));
        hflailRarity.setText((hflail.rarity));
        hflailBuy_price.setText((hflail.buy_price));
        hflailSell_price.setText((hflail.sell_price));
    }
}