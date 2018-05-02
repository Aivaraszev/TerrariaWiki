package com.zevzikovas.aivaras.terraria.activities.descriptions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.HYoyos;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

public class HYoyosDescriptionActivity extends Activity {

    RepositoryManager repositoryManager = new RepositoryManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hyoyos_description);

        Intent i = getIntent();
        HYoyos hyoyos = repositoryManager.HYoyosRepository.getHYoyo(i.getIntExtra("hyoyosId", 0));

        TextView hyoyosDamage = findViewById(R.id.hyoyosDamage);
        TextView hyoyosKnockback = findViewById(R.id.hyoyosKnockback);
        TextView hyoyosCritical_chance = findViewById(R.id.hyoyosCritical_chance);
        TextView hyoyosUse_time = findViewById(R.id.hyoyosUse_time);
        TextView hyoyosVelocity = findViewById(R.id.hyoyosVelocity);
        TextView hyoyosGrants_buff = findViewById(R.id.hyoyosGrants_buff);
        TextView hyoyosInflicts_debuff = findViewById(R.id.hyoyosInflicts_debuff);
        TextView hyoyosRarity = findViewById(R.id.hyoyosRarity);
        TextView hyoyosBuy_price = findViewById(R.id.hyoyosBuy_price);
        TextView hyoyosSell_price = findViewById(R.id.hyoyosSell_price);

        hyoyosDamage.setText(Integer.toString(hyoyos.damage));
        hyoyosKnockback.setText((hyoyos.knockback));
        hyoyosCritical_chance.setText((hyoyos.critical_chance));
        hyoyosUse_time.setText((hyoyos.use_time));
        hyoyosVelocity.setText((hyoyos.velocity));
        hyoyosGrants_buff.setText((hyoyos.grants_buff));
        hyoyosInflicts_debuff.setText((hyoyos.inflicts_debuff));
        hyoyosRarity.setText((hyoyos.rarity));
        hyoyosBuy_price.setText((hyoyos.buy_price));
        hyoyosSell_price.setText((hyoyos.sell_price));
    }
}