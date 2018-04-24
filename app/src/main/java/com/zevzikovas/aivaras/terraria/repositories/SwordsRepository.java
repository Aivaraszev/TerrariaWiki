package com.zevzikovas.aivaras.terraria.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Swords;

import java.util.ArrayList;
import java.util.List;

public class SwordsRepository {
    private static final String TABLE_NAME = "swords";

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PICTURE = "picture";
    private static final String DAMAGE = "damage";
    private static final String KNOCKBACK = "knockback";
    private static final String CRITICAL_CHANCE = "critical_chance";
    private static final String USE_TIME = "use_time";
    private static final String VELOCITY = "velocity";
    private static final String TOOLTIP = "tooltip";
    private static final String GRANTS_BUFF = "grants_buff";
    private static final String INFLICTS_DEBUFF = "inflicts_debuff";
    private static final String RARITY = "rarity";
    private static final String BUY_PRICE = "buy_price";
    private static final String SELL_PRICE = "sell_price";

    private SQLiteOpenHelper dbHelper;

    public SwordsRepository(SQLiteOpenHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public void create(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME + " (" +
                        ID + " INTEGER PRIMARY KEY," +
                        NAME + " TEXT," +
                        PICTURE + " INTEGER," +
                        DAMAGE + " INTEGER," +
                        KNOCKBACK + " TEXT," +
                        CRITICAL_CHANCE + " TEXT," +
                        USE_TIME + " INTEGER," +
                        VELOCITY + " TEXT," +
                        TOOLTIP + " TEXT," +
                        GRANTS_BUFF + " TEXT," +
                        INFLICTS_DEBUFF + " TEXT," +
                        RARITY + " TEXT," +
                        BUY_PRICE + " TEXT," +
                        SELL_PRICE + " TEXT" +
                        ")"
        );
    }

    public void drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }
    //TODO: make "crafting"
    public void fill(SQLiteDatabase db) {
        prepareSwords(db, "Copper Shortsword", R.drawable.item_copper_shortsword, 5, "4", "4%", 12, "None", "None", "None", "None", "White", "None", "70 Copper");
        prepareSwords(db, "Tin Shortsword", R.drawable.item_tin_shortsword, 7, "4", "4%", 11, "None", "None", "None", "None", "White", "None", "1 Silver 5 Copper");
        prepareSwords(db, "Wooden Sword", R.drawable.item_wooden_sword, 7, "4", "4%", 24, "None", "None", "None", "None", "White", "None", "20 Copper");
        prepareSwords(db, "Boreal Wood Sword", R.drawable.item_boreal_wood_sword, 8, "5", "4%", 22, "None", "None", "None", "None", "White", "None", "20 Copper");
        prepareSwords(db, "Copper Broadsword", R.drawable.item_copper_broadsword, 8, "5", "4%", 22, "None", "None", "None", "None", "White", "None", "90 Copper");
        prepareSwords(db, "Iron Shortsword", R.drawable.item_iron_shortsword, );
        prepareSwords(db, "Palm Wood Sword", R.drawable.item_palm_wood_sword, );
        prepareSwords(db, "Rich Mahogany Sword", R.drawable.item_rich_mahogany_sword, );
        prepareSwords(db, "Cactus Sword", R.drawable.item_cactus_sword, );
        prepareSwords(db, "Lead Shortsword", R.drawable.item_lead_shortsword, );
        prepareSwords(db, "Silver Shortsword", R.drawable.item_silver_shortsword, );
        prepareSwords(db, "Tin BroadSword", R.drawable.item_tin_broadsword, );
        prepareSwords(db, "Ebonwood Sword", R.drawable.item_ebonwood_sword, );
        prepareSwords(db, "Iron Broadsword", R.drawable.item_iron_broadsword, );
        prepareSwords(db, "Shadewood Sword", R.drawable.item_shadewood_sword, );
        prepareSwords(db, "Tungsten Shortsword", R.drawable.item_tungsten_shortsword, );
        prepareSwords(db, "Gold Shortsword", R.drawable.item_gold_short_sword, );
        prepareSwords(db, "Lead Broadsword", R.drawable.item_lead_broadsword, );
        prepareSwords(db, "Silver Broadsword", R.drawable.item_silver_broadsword, );
        prepareSwords(db, "Bladed Glove", R.drawable.item_bladed_glove, );
        prepareSwords(db, "Tungsten Broadsword", R.drawable.item_tungsten_broadsword, );
        prepareSwords(db, "Zombie Arm", R.drawable.item_zombie_arm, );
        prepareSwords(db, "Gold Broadsword", R.drawable.item_gold_broadsword, );
        prepareSwords(db, "Platinum Shortsword", R.drawable.item_platinum_shortsword, );
        prepareSwords(db, "Mandible Blade", R.drawable.item_mandible_blade, );
        prepareSwords(db, "Stylish Scissors", R.drawable.item_stylish_scissors, );
        prepareSwords(db, "Platinum Broadsword", R.drawable.item_platinum_broadsword, );
        prepareSwords(db, "Bone Sword", R.drawable.item_bone_sword, );
        prepareSwords(db, "Candy Cane Sword", R.drawable.item_candy_cane_sword, );
        prepareSwords(db, "Katana", R.drawable.item_katana, );
        prepareSwords(db, "Ice Blade", R.drawable.item_ice_blade, );
        prepareSwords(db, "Light's Bane", R.drawable.item_lights_bane, );
        prepareSwords(db, "Muramasa", R.drawable.item_muramasa, );
        prepareSwords(db, "Arkhalis", R.drawable.item_arkhalis, );
        prepareSwords(db, "Exotic Scimitar", R.drawable.item_exotic_scimitar, );
        prepareSwords(db, "Phaseblade", R.drawable.item_phaseblade, );
        prepareSwords(db, "Blood Butcherer", R.drawable.item_blood_butcherer, );
        prepareSwords(db, "Starfury", R.drawable.item_starfury, );
        prepareSwords(db, "Enchanted Sword", R.drawable.item_enchanted_sword, );
        prepareSwords(db, "Purple Clubberfish", R.drawable.item_purple_clubberfish, );
        prepareSwords(db, "Bee Keeper", R.drawable.item_bee_keeper, );
        prepareSwords(db, "Falcon Blade", R.drawable.item_falcon_blade, );
        prepareSwords(db, "Blade of Grass", R.drawable.item_blade_of_grass, );
        prepareSwords(db, "Fiery Greatsword", R.drawable.item_fiery_greatsword, );
        prepareSwords(db, "Night's Edge", R.drawable.item_nights_edge, );
    }

    private void prepareSwords(SQLiteDatabase db, String name, int picture, int damage, String knockback, String critical_chance, int use_time, String velocity, String tooltip, String grants_buff, String inflicts_debuff, String rarity, String buy_price, String sell_price) {
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(PICTURE, picture);
        values.put(DAMAGE, damage);
        values.put(KNOCKBACK, knockback);
        values.put(CRITICAL_CHANCE, critical_chance);
        values.put(USE_TIME, use_time);
        values.put(VELOCITY, velocity);
        values.put(TOOLTIP, tooltip);
        values.put(GRANTS_BUFF, grants_buff);
        values.put(INFLICTS_DEBUFF, inflicts_debuff);
        values.put(RARITY, rarity);
        values.put(BUY_PRICE, buy_price);
        values.put(SELL_PRICE, sell_price);

        db.insert(TABLE_NAME, null, values);
    }

    public void addSwords(Swords swords) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, swords.name);
        values.put(PICTURE, swords.picture);
        values.put(DAMAGE, swords.damage);
        values.put(KNOCKBACK, swords.knockback);
        values.put(CRITICAL_CHANCE, swords.critical_chance);
        values.put(USE_TIME, swords.use_time);
        values.put(VELOCITY, swords.velocity);
        values.put(TOOLTIP, swords.tooltip);
        values.put(GRANTS_BUFF, swords.grants_buff);
        values.put(INFLICTS_DEBUFF, swords.inflicts_debuff);
        values.put(RARITY, swords.rarity);
        values.put(BUY_PRICE, swords.buy_price);
        values.put(SELL_PRICE, swords.sell_price);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Swords> getAllSword() {
        List<Swords> sword = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Swords swords = new Swords(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getInt(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9),
                        cursor.getString(10),
                        cursor.getString(11),
                        cursor.getString(12),
                        cursor.getString(13)
                );

                sword.add(swords);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return sword;
    }

    public Swords getSword(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE ID = " + id;
        Cursor cursor = db.rawQuery(selectQuery, null);
        Swords swords = null;

        if (cursor.moveToFirst()) {
            swords = new Swords(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getInt(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getInt(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11),
                    cursor.getString(12),
                    cursor.getString(13)
            );
        }

        cursor.close();
        db.close();

        return swords;
    }
}