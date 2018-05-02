package com.zevzikovas.aivaras.terraria.activities.descriptions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.HSpears;

import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

public class HSpearsDescriptionActivity extends Activity {

    RepositoryManager repositoryManager = new RepositoryManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hspears_description);

        Intent i = getIntent();
        HSpears hspear = repositoryManager.HSpearsRepository.getHspear(i.getIntExtra("hspearsId", 0));

        TextView hspearsDamage = findViewById(R.id.hspearsDamage);
        TextView hspearsKnockback = findViewById(R.id.hspearsKnockback);
        TextView hspearsCritical_chance = findViewById(R.id.hspearsCritical_chance);
        TextView hspearsUse_time = findViewById(R.id.hspearsUse_time);
        TextView hspearsVelocity = findViewById(R.id.hspearsVelocity);
        TextView hspearsTooltip = findViewById(R.id.hspearsTooltip);
        TextView hspearsGrants_buff = findViewById(R.id.hspearsGrants_buff);
        TextView hspearsInflicts_debuff = findViewById(R.id.hspearsInflicts_debuff);
        TextView hspearsRarity = findViewById(R.id.hspearsRarity);
        TextView hspearsBuy_price = findViewById(R.id.hspearsBuy_price);
        TextView hspearsSell_price = findViewById(R.id.hspearsSell_price);

        hspearsDamage.setText(Integer.toString(hspear.damage));
        hspearsKnockback.setText((hspear.knockback));
        hspearsCritical_chance.setText((hspear.critical_chance));
        hspearsUse_time.setText((hspear.use_time));
        hspearsVelocity.setText((hspear.velocity));
        hspearsTooltip.setText((hspear.tooltip));
        hspearsGrants_buff.setText((hspear.grants_buff));
        hspearsInflicts_debuff.setText((hspear.inflicts_debuff));
        hspearsRarity.setText((hspear.rarity));
        hspearsBuy_price.setText((hspear.buy_price));
        hspearsSell_price.setText((hspear.sell_price));
    }
}