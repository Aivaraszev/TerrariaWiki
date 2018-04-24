package com.zevzikovas.aivaras.terraria.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.PointerIcon;
import android.widget.TextView;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Pickaxes;
import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;
public class PickaxesDescriptionActivity extends Activity {

    RepositoryManager repositoryManager = new RepositoryManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickaxes_description);

        Intent i = getIntent();
        Pickaxes pickaxes = repositoryManager.PickaxesRepository.getSword(i.getIntExtra("hswordsId", 0));

        TextView pickaxesDamage = findViewById(R.id.hswordsDamage);
        TextView pickaxesKnockback = findViewById(R.id.hswordsKnockback);
        TextView pickaxesBonus = findViewById(R.id.hswordsKnockback);
        TextView pickaxesCritical_chance = findViewById(R.id.hswordsCritical_chance);
        TextView pickaxesUse_time = findViewById(R.id.hswordsUse_time);
        TextView pickaxesTool_speed = findViewById(R.id.hswordsUse_time);
        TextView pickaxesRarity = findViewById(R.id.hswordsRarity);
        TextView pickaxesBuy_price = findViewById(R.id.hswordsBuy_price);
        TextView pickaxesSell_price = findViewById(R.id.hswordsSell_price);
        TextView pickaxesPickaxe_power = findViewById(R.id.hswordsSell_price);
        TextView pickaxesAxe_power = findViewById(R.id.hswordsSell_price);

        pickaxesDamage.setText(Integer.toString(pickaxes.damage));
        pickaxesKnockback.setText((pickaxes.knockback));
        pickaxesBonus.setText((pickaxes.bonus));
        pickaxesCritical_chance.setText((pickaxes.critical_chance));
        pickaxesUse_time.setText((pickaxes.use_time));
        pickaxesTool_speed.setText(Integer.toString(pickaxes.tool_speed));
        pickaxesRarity.setText((pickaxes.rarity));
        pickaxesBuy_price.setText((pickaxes.buy_price));
        pickaxesSell_price.setText((pickaxes.sell_price));
        pickaxesPickaxe_power.setText((pickaxes.pickaxe_power));
        pickaxesAxe_power.setText((pickaxes.axe_power));
    }
}