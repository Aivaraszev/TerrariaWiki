package com.zevzikovas.aivaras.terraria.models;

public class Hswords {
    public int id;
    public String name;
    public int picture;
    public int damage;
    public int knockback;
    public String critical_chance;
    public int use_time;
    public String rarity;
    public int price;

    public Hswords (int id, String name, int picture, int damage,int knockback, String critical_chance, int use_time, String rarity, int price) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.damage = damage;
        this.knockback = knockback;
        this.critical_chance = critical_chance;
        this.use_time = use_time;
        this.rarity = rarity;
        this.price = price;
    }

    public Hswords (String name, int picture, int damage, int knockback, String critical_chance, String rarity, int price) {
        this.name = name;
        this.picture = picture;
        this.damage = damage;
        this.knockback = knockback;
        this.critical_chance = critical_chance;
        this.rarity = rarity;
        this.price = price;
    }
}