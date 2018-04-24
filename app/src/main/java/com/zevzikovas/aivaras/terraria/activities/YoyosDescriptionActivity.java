package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Yoyos;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

public class YoyosDescriptionActivity extends Activity {

    RepositoryManager repositoryManager = new RepositoryManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoyos_description);

        Intent i = getIntent();
        Yoyos yoyos = repositoryManager.YoyosRepository.getYoyos(i.getIntExtra("yoyosId", 0));

        TextView yoyosDamage = findViewById(R.id.yoyosDamage);
        TextView yoyosKnockback = findViewById(R.id.yoyosKnockback);
        TextView yoyosCritical_chance = findViewById(R.id.yoyosCritical_chance);
        TextView yoyosUse_time = findViewById(R.id.yoyosUse_time);
        TextView yoyosVelocity = findViewById(R.id.yoyosVelocity);
        TextView yoyosTooltip = findViewById(R.id.yoyosTooltip);
        TextView yoyosGrants_buff = findViewById(R.id.yoyosGrants_buff);
        TextView yoyosInflicts_debuff = findViewById(R.id.yoyosInflicts_debuff);
        TextView yoyosRarity = findViewById(R.id.yoyosRarity);
        TextView yoyosBuy_price = findViewById(R.id.yoyosBuy_price);
        TextView yoyosSell_price = findViewById(R.id.yoyosSell_price);

        yoyosDamage.setText(Integer.toString(yoyos.damage));
        yoyosKnockback.setText((yoyos.knockback));
        yoyosCritical_chance.setText((yoyos.critical_chance));
        yoyosUse_time.setText(Integer.toString(yoyos.use_time));
        yoyosVelocity.setText((yoyos.velocity));
        yoyosTooltip.setText((yoyos.tooltip));
        yoyosGrants_buff.setText((yoyos.grants_buff));
        yoyosInflicts_debuff.setText((yoyos.inflicts_debuff));
        yoyosRarity.setText((yoyos.rarity));
        yoyosBuy_price.setText((yoyos.buy_price));
        yoyosSell_price.setText((yoyos.sell_price));
    }
}