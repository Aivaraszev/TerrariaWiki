package com.zevzikovas.aivaras.terraria.repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Swords;

import java.util.ArrayList;
import java.util.List;

public class ItemsRepository {
    private static final String TABLE_NAME = "items";

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PICTURE = "picture";
    private static final String DAMAGE = "damage";
    private static final String RARITY = "rarity";
    private static final String PRICE = "price";
    private SQLiteOpenHelper dbHelper;

    public ItemsRepository(SQLiteOpenHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public void create(SQLiteDatabase db) {
        db.execSQL(
            "CREATE TABLE " + TABLE_NAME + "(" +
                ID + " INTEGER PRIMARY KEY," +
                NAME + " TEXT," +
                PICTURE + " INTEGER," +
                DAMAGE + " INTEGER," +
                RARITY + " TEXT," +
                PRICE + " INTEGER" +
            ")"
        );
    }

    public void drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public void fill(SQLiteDatabase db) {
        prepareItem(db, "Copper Shortsword", R.drawable.item_copper_shortsword, 5, "White", 70);
        prepareItem(db, "Tin Shortsword", R.drawable.item_tin_shortsword, 7, "White", 105);
        prepareItem(db, "Wooden Sword", R.drawable.item_wooden_sword, 7, "White", 20);
        prepareItem(db, "Boreal Wood Sword", R.drawable.item_boreal_wood_sword, 8, "White", 20);
        prepareItem(db, "Copper Broadsword", R.drawable.item_copper_broadsword, 7, "White", 90);
        prepareItem(db, "Iron Shortsword", R.drawable.item_iron_shortsword, 8, "White", 280);
        prepareItem(db, "Palm Wood Sword", R.drawable.item_palm_wood_sword, 8, "White", 20);
        prepareItem(db, "Rich Mahogany Sword", R.drawable.item_rich_mahogany_sword, 8, "White", 20);
        prepareItem(db, "Cactus Sword", R.drawable.item_cactus_sword, 9, "White", 360);
        prepareItem(db, "Lead Shortsword", R.drawable.item_lead_shortsword, 9, "White", 420);
        prepareItem(db, "Silver Shortsword", R.drawable.item_silver_shortsword, 9, "White", 700);
        prepareItem(db, "Tin BroadSword", R.drawable.item_tin_broadsword, 9, "White", 135);
        prepareItem(db, "Ebonwood Sword", R.drawable.item_ebonwood_sword, 10, "White", 20);
        prepareItem(db, "Iron Broadsword", R.drawable.item_iron_broadsword, 10, "White", 360);
        prepareItem(db, "Shadewood Sword", R.drawable.item_shadewood_sword, 10, "White", 20);
        prepareItem(db, "Tungsten Shortsword", R.drawable.item_tungsten_shortsword, 10, "White", 1050);
        prepareItem(db, "Gold Shortsword", R.drawable.item_gold_short_sword, 11, "White", 1400);
        prepareItem(db, "Lead Broadsword", R.drawable.item_lead_broadsword, 11, "White", 540);
        prepareItem(db, "Silver Broadsword", R.drawable.item_silver_broadsword, 11, "White", 900);
        prepareItem(db, "Bladed Glove", R.drawable.item_bladed_glove, 12, "Green", 10000);
        prepareItem(db, "Tungsten Broadsword", R.drawable.item_tungsten_broadsword, 12, "White", 1350);
        prepareItem(db, "Zombie Arm", R.drawable.item_zombie_arm, 12, "White", 400);
        prepareItem(db, "Gold Broadsword", R.drawable.item_gold_broadsword, 13, "White", 1800);
        prepareItem(db, "Platinum Shortsword", R.drawable.item_platinum_shortsword, 15, "White", 2100);
        prepareItem(db, "Mandible Blade", R.drawable.item_mandible_blade, 14, "Green", 1000);
        prepareItem(db, "Stylish Scissors", R.drawable.item_stylish_scissors, 14, "Green", 5000);
        prepareItem(db, "Platinum Broadsword", R.drawable.item_platinum_broadsword, 16, "White", 2700);
        prepareItem(db, "Bone Sword", R.drawable.item_bone_sword, 16, "Orange", 1800);
        prepareItem(db, "Candy Cane Sword", R.drawable.item_candy_cane_sword, 16, "Blue", 48000);
        prepareItem(db, "Katana", R.drawable.item_katana, 15, "Blue", 48000);
        prepareItem(db, "Ice Blade", R.drawable.item_ice_blade, 17, "Blue", 4000);
        prepareItem(db, "Light's Bane", R.drawable.item_lights_bane, 17, "Blue", 2700);
        prepareItem(db, "Muramasa", R.drawable.item_muramasa, 19, "Green", 54);
        prepareItem(db, "Arkhalis", R.drawable.item_arkhalis, 20, "Green", 8000);
        prepareItem(db, "Exotic Scimitar", R.drawable.item_exotic_scimitar, 20, "Green", 5000);
        prepareItem(db, "Phaseblade", R.drawable.item_phaseblade, 15, "Blue", 22);
        prepareItem(db, "Blood Butcherer", R.drawable.item_blood_butcherer, 22, "Blue", 2700);
        prepareItem(db, "Starfury", R.drawable.item_starfury, 22, "Green", 10000);
        prepareItem(db, "Enchanted Sword", R.drawable.item_enchanted_sword, 24, "Green", 4000);
        prepareItem(db, "Purple Clubberfish", R.drawable.item_purple_clubberfish, 24, "Blue", 10000);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 26, "Orange", 5400);
        prepareItem(db, "Falcon Blade", R.drawable.item_falcon_blade, 30, "Light Red", 2000);
        prepareItem(db, "Blade of Grass", R.drawable.item_blade_of_grass, 28, "Orange", 5000);
        prepareItem(db, "Fiery Greatsword", R.drawable.item_fiery_greatsword, 36, "Orange", 5400);
        prepareItem(db, "Night's Edge", R.drawable.item_nights_edge, 42, "Orange", 10800);
    }

    private void prepareItem(SQLiteDatabase db, String name, int picture, int damage, String rarity, int price) {
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(PICTURE, picture);
        values.put(DAMAGE, damage);
        values.put(RARITY, rarity);
        values.put(PRICE, price);
        db.insert(TABLE_NAME, null, values);
    }

    public void addItem(Swords item) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, item.name);
        values.put(PICTURE, item.picture);
        values.put(DAMAGE, item.damage);
        values.put(RARITY, item.rarity);
        values.put(PRICE, item.price);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Swords> getAllItems() {
        List<Swords> items = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Swords item = new Swords(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        cursor.getString(4),
                        cursor.getInt(5)
                );

                items.add(item);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return items;
    }
}