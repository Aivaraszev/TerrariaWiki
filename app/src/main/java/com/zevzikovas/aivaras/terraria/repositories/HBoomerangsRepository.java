package com.zevzikovas.aivaras.terraria.repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.HBoomerangs;

import java.util.ArrayList;
import java.util.List;

public class HBoomerangsRepository {
    private static final String TABLE_NAME = "hboomerangs";

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

    public HBoomerangsRepository(SQLiteOpenHelper dbHelper) {
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
                        USE_TIME + " TEXT," +
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
        prepareHboomerangs(db, "Flying Knife", R.drawable.item_flying_knife, 40, "4.5 (Average)", "4%", "14 (Very Fast)", "17", "Throws a controllable flying knife", "None", "None", "Light Purple", "None", "8 Gold");
        prepareHboomerangs(db, "Light disc", R.drawable.item_light_disc, 57, "8 (Very Strong)", "4%", "14 (Very Fast)", "13", "Stacks up to 5 ", "None","None", "Pink", "None", "10 Gold");
        prepareHboomerangs(db, "Bananarang", R.drawable.item_bananarang, 55, "6.5 (Strong)", "4%", "13 (Very Fast)", "14", "None", "None", "None", "Pink", "None", "1 Gold 50 Silver");
        prepareHboomerangs(db, "Possessed Hatchet", R.drawable.item_possessed_hatchet, 80, "5 (Average)", "4%", "13 (Very Fast)", "12", "Chases after your enemy", "None", "None", "Lime", "None", "10 Gold");
        prepareHboomerangs(db, "Paladins Hammer", R.drawable.item_paladins_hammer, 90, "9 (Very Strong)", "4%", "14 (Very Fast)", "14", "None", "None", "None", "Yellow", "None", "10 Gold");
    }

    private void prepareHboomerangs(SQLiteDatabase db, String name, int picture, int damage, String knockback, String critical_chance, String use_time, String velocity, String tooltip, String grants_buff, String inflicts_debuff, String rarity, String buy_price, String sell_price) {
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

    public void addHBoomerangs(HBoomerangs hboomerangs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, hboomerangs.name);
        values.put(PICTURE, hboomerangs.picture);
        values.put(DAMAGE, hboomerangs.damage);
        values.put(KNOCKBACK, hboomerangs.knockback);
        values.put(CRITICAL_CHANCE, hboomerangs.critical_chance);
        values.put(USE_TIME, hboomerangs.use_time);
        values.put(VELOCITY, hboomerangs.velocity);
        values.put(TOOLTIP, hboomerangs.tooltip);
        values.put(GRANTS_BUFF, hboomerangs.grants_buff);
        values.put(INFLICTS_DEBUFF, hboomerangs.inflicts_debuff);
        values.put(RARITY, hboomerangs.rarity);
        values.put(BUY_PRICE, hboomerangs.buy_price);
        values.put(SELL_PRICE, hboomerangs.sell_price);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<HBoomerangs> getAllHBoomerang() {
        List<HBoomerangs> hboomerang = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HBoomerangs hboomerangs = new HBoomerangs(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9),
                        cursor.getString(10),
                        cursor.getString(11),
                        cursor.getString(12),
                        cursor.getString(13)
                );

                hboomerang.add(hboomerangs);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return hboomerang;
    }

    public HBoomerangs getHBoomerang(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE ID = " + id;
        Cursor cursor = db.rawQuery(selectQuery, null);
        HBoomerangs hboomerangs = null;

        if (cursor.moveToFirst()) {
            hboomerangs = new HBoomerangs(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getInt(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
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

        return hboomerangs;
    }
}