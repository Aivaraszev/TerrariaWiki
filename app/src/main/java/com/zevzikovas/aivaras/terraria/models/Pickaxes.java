package com.zevzikovas.aivaras.terraria.models;

public class Pickaxes {
    public int id;
    public String name;
    public int picture;
    public int damage;
    public String rarity;
    public int price;

    public Pickaxes(int id, String name, int picture, int damage, String rarity, int price) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.damage = damage;
        this.rarity = rarity;
        this.price = price;
    }

    public Pickaxes(String name, int picture, int damage, String rarity, int price) {
        this.name = name;
        this.picture = picture;
        this.damage = damage;
        this.rarity = rarity;
        this.price = price;
    }
}
