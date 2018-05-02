package com.zevzikovas.aivaras.terraria.activities.descriptions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Others;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

public class OthersDescriptionActivity extends Activity {

    RepositoryManager repositoryManager = new RepositoryManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others_description);

        Intent i = getIntent();
        Others others = repositoryManager.OthersRepository.getOther(i.getIntExtra("othersId", 0));

        TextView othersDamage = findViewById(R.id.othersDamage);
        TextView othersKnockback = findViewById(R.id.othersKnockback);
        TextView othersCritical_chance = findViewById(R.id.othersCritical_chance);
        TextView othersUse_time = findViewById(R.id.othersUse_time);
        TextView hothersVelocity = findViewById(R.id.othersVelocity);
        TextView othersTooltip = findViewById(R.id.othersTooltip);
        TextView othersGrants_buff = findViewById(R.id.othersGrants_buff);
        TextView othersInflicts_debuff = findViewById(R.id.othersInflicts_debuff);
        TextView othersRarity = findViewById(R.id.othersRarity);
        TextView othersBuy_price = findViewById(R.id.othersBuy_price);
        TextView othersSell_price = findViewById(R.id.othersSell_price);

        othersDamage.setText(Integer.toString(others.damage));
        othersKnockback.setText((others.knockback));
        othersCritical_chance.setText((others.critical_chance));
        othersUse_time.setText((others.use_time));
        hothersVelocity.setText((others.velocity));
        othersTooltip.setText((others.tooltip));
        othersGrants_buff.setText((others.grants_buff));
        othersInflicts_debuff.setText((others.inflicts_debuff));
        othersRarity.setText((others.rarity));
        othersBuy_price.setText((others.buy_price));
        othersSell_price.setText((others.sell_price));
    }
}