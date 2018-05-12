package com.zevzikovas.aivaras.terraria.activities.descriptions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Bows;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;

public class BowsDescriptionActivity extends Activity {

    RepositoryManager repositoryManager = new RepositoryManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bows_description);

        Intent i = getIntent();
        Bows bow = repositoryManager.BowsRepository.getBow(i.getIntExtra("bowsId", 0));

        TextView bowDamage = findViewById(R.id.bowDamage);
        TextView bowKnockback = findViewById(R.id.bowKnockback);
        TextView bowCritical_chance = findViewById(R.id.bowCritical_chance);
        TextView bowUse_time = findViewById(R.id.bowUse_time);
        TextView bowVelocity = findViewById(R.id.bowVelocity);
        TextView bowTooltip = findViewById(R.id.bowTooltip);
        TextView bowGrants_buff = findViewById(R.id.bowGrants_buff);
        TextView bowInflicts_debuff = findViewById(R.id.bowInflicts_debuff);
        TextView bowRarity = findViewById(R.id.bowRarity);
        TextView bowBuy_price = findViewById(R.id.bowBuy_price);
        TextView bowSell_price = findViewById(R.id.bowSell_price);

        bowDamage.setText(Integer.toString(bow.damage));
        bowKnockback.setText((bow.knockback));
        bowCritical_chance.setText((bow.critical_chance));
        bowUse_time.setText((bow.use_time));
        bowVelocity.setText((bow.velocity));
        bowTooltip.setText((bow.tooltip));
        bowGrants_buff.setText((bow.grants_buff));
        bowInflicts_debuff.setText((bow.inflicts_debuff));
        bowRarity.setText((bow.rarity));
        bowBuy_price.setText((bow.buy_price));
        bowSell_price.setText((bow.sell_price));
    }
}