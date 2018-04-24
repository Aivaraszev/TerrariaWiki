package com.zevzikovas.aivaras.terraria.models;

public class Swords {
    public int id;
    public String name;
    public int picture;
    public int damage;
    public String knockback;
    public String critical_chance;
    public int use_time;
    public String velocity;
    public String tooltip;
    public String grants_buff;
    public String inflicts_debuff;
    public String rarity;
    public String buy_price;
    public String sell_price;

    public Swords (int id, String name, int picture, int damage, String knockback, String critical_chance, int use_time, String velocity, String tooltip, String grants_buff, String inflicts_debuff, String rarity, String buy_price, String sell_price) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.damage = damage;
        this.knockback = knockback;
        this.critical_chance = critical_chance;
        this.use_time = use_time;
        this.velocity = velocity;
        this.tooltip = tooltip;
        this.grants_buff = grants_buff;
        this.inflicts_debuff = inflicts_debuff;
        this.rarity = rarity;
        this.buy_price = buy_price;
        this.sell_price = sell_price;
    }

    public Swords (String name, int picture, int damage, String knockback, String critical_chance, int use_time, String velocity, String tooltip, String grants_buff, String inflicts_debuff, String rarity, String buy_price, String sell_price) {
        this.name = name;
        this.picture = picture;
        this.damage = damage;
        this.knockback = knockback;
        this.critical_chance = critical_chance;
        this.use_time = use_time;
        this.velocity = velocity;
        this.tooltip = tooltip;
        this.grants_buff = grants_buff;
        this.inflicts_debuff = inflicts_debuff;
        this.rarity = rarity;
        this.buy_price = buy_price;
        this.sell_price = sell_price;
    }
}