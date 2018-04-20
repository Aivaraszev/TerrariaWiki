package com.zevzikovas.aivaras.terraria.models;

public class Hswords {
    public int id;
    public String name;
    public int picture;
    public int damage;
    public String knockback;
    public String critical_chance;
    public int use_time;
    public String tooltip;
    public String rarity;
    public String buy_price;
    public String sell_price;

    public Hswords (int id, String name, int picture, int damage,String knockback, String critical_chance, int use_time, String tooltip, String rarity, String buy_price, String sell_price) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.damage = damage;
        this.knockback = knockback;
        this.critical_chance = critical_chance;
        this.use_time = use_time;
        this.tooltip = tooltip;
        this.rarity = rarity;
        this.buy_price = buy_price;
        this.sell_price = sell_price;
    }

    public Hswords (String name, int picture, int damage, String knockback, String critical_chance, int use_time, String tooltip, String rarity, String buy_price, String sell_price) {
        this.name = name;
        this.picture = picture;
        this.damage = damage;
        this.knockback = knockback;
        this.critical_chance = critical_chance;
        this.use_time = use_time;
        this.tooltip = tooltip;
        this.rarity = rarity;
        this.buy_price = buy_price;
        this.sell_price = sell_price;
    }
}