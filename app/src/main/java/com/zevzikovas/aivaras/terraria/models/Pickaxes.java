package com.zevzikovas.aivaras.terraria.models;

public class Pickaxes {
          public int id;
          public String name;
          public int picture;
          public int damage;
          public String knockback;
          public String bonus;
          public String critical_chanse;
          public int use_time;
          public int tool_speed;
          public String rarity;
          public String buy_price;
          public String sell_price;
          public String pickaxe_power;
          public String axe_power;

    public Pickaxes (int id, String name, int picture, int damage, String knockback, String bonus, String critical_chanse, int use_time, int tool_speed, String rarity, String buy_price, String sell_price, String pickaxe_power, String axe_power) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.damage = damage;
        this.knockback = knockback;
        this.bonus = bonus;
        this.critical_chanse = critical_chanse;
        this.use_time = use_time;
        this.tool_speed = tool_speed;
        this.rarity = rarity;
        this.buy_price = buy_price;
        this.sell_price = sell_price;
        this.pickaxe_power = pickaxe_power;
        this.axe_power = axe_power;
    }

    public Pickaxes (String name, int picture, int damage, String knockback, String bonus, String critical_chanse, int use_time, int tool_speed, String rarity, String buy_price, String sell_price, String pickaxe_power, String axe_power) {
        this.name = name;
        this.picture = picture;
        this.damage = damage;
        this.knockback = knockback;
        this.bonus = bonus;
        this.critical_chanse = critical_chanse;
        this.use_time = use_time;
        this.tool_speed = tool_speed;
        this.rarity = rarity;
        this.buy_price = buy_price;
        this.sell_price = sell_price;
        this.pickaxe_power = pickaxe_power;
        this.axe_power = axe_power;
    }
}