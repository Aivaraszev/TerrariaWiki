package com.zevzikovas.aivaras.terraria.activities.descriptions;

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
        setContentView(R.layout.activity_flails_description);

        Intent i = getIntent();
        Flails flail = repositoryManager.FlailsRepository.getFlail(i.getIntExtra("flailsId", 0));

        TextView flailDamage = findViewById(R.id.flailDamage);
        TextView flailKnockback = findViewById(R.id.flailKnockback);
        TextView flailCritical_chance = findViewById(R.id.flailCritical_chance);
        TextView flailUse_time = findViewById(R.id.flailUse_time);
        TextView flailVelocity = findViewById(R.id.flailVelocity);
        TextView flailTooltip = findViewById(R.id.flailTooltip);
        TextView flailGrants_buff = findViewById(R.id.flailGrants_buff);
        TextView flailInflicts_debuff = findViewById(R.id.flailInflicts_debuff);
        TextView flailRarity = findViewById(R.id.flailRarity);
        TextView flailBuy_price = findViewById(R.id.flailBuy_price);
        TextView flailSell_price = findViewById(R.id.flailSell_price);

        flailDamage.setText(Integer.toString(flail.damage));
        flailKnockback.setText((flail.knockback));
        flailCritical_chance.setText((flail.critical_chance));
        flailUse_time.setText((flail.use_time));
        flailVelocity.setText((flail.velocity));
        flailTooltip.setText((flail.tooltip));
        flailGrants_buff.setText((flail.grants_buff));
        flailInflicts_debuff.setText((flail.inflicts_debuff));
        flailRarity.setText((flail.rarity));
        flailBuy_price.setText((flail.buy_price));
        flailSell_price.setText((flail.sell_price));
    }
}