package com.zevzikovas.aivaras.terraria.repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.HFlails;

import java.util.ArrayList;
import java.util.List;

public class HFlailsRepository {
    private static final String TABLE_NAME = "hflails";

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

    public HFlailsRepository(SQLiteOpenHelper dbHelper) {
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
        prepareHFlails(db, "Wooden Boomerang", R.drawable.item_wooden_boomerang, 8, "5 (Average)", "4%", "15 (Very Fast)", "6.5", "None", "None", "None", "White", "None", "10 Silver");
        prepareHFlails(db, "Enchanted Boomerang", R.drawable.item_enchanted_boomerang, 13, "8 (Very Strong)", "4%", "14 (Very Fast)", "10", "None", "None","None", "Blue", "None", "1 Gold");
        prepareHFlails(db, "Fruit Chakram", R.drawable.item_fruitcake_chakram, 14, "8 (Very Strong)", "4%", "14 (Very Fast)", "11", "None", "None", "None", "Blue", "None", "1 Gold");
        prepareHFlails(db, "Bloody Machete", R.drawable.item_bloody_machete, 15, "5 (Average)", "4%", "14 (Very Fast)", "15", "None", "None", "None", "Green", "None", "1 Gold");
        prepareHFlails(db, "Ice Boomerang", R.drawable.item_ice_boomerang, 16, "8.5 (Very Strong)", "6%", "14 (Very Fast)", "11.5", "None", "None", "None", "Blue", "None", "1 Gold");
        prepareHFlails(db, "Thorn Chakram", R.drawable.item_thorn_chakram, 25, "8 (Very Strong)", "4%", "14 (Very Fast)", "11", "None", "None", "Poisoned (Slowly losing life)", "Orange", "None","1 Gold");
        prepareHFlails(db, "Flamarang", R.drawable.item_flamarang, 32, "8 (Very Strong)", "4%", "14 (Very Fast)", "11", "None", "None", "On Fire! (Slowly losing life)", "Orange", "None", "2 Gold");

    }

    private void prepareHFlails(SQLiteDatabase db, String name, int picture, int damage, String knockback, String critical_chance, String use_time, String velocity, String tooltip, String grants_buff, String inflicts_debuff, String rarity, String buy_price, String sell_price) {
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

    public void addHFlails(HFlails hflails) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, hflails.name);
        values.put(PICTURE, hflails.picture);
        values.put(DAMAGE, hflails.damage);
        values.put(KNOCKBACK, hflails.knockback);
        values.put(CRITICAL_CHANCE, hflails.critical_chance);
        values.put(USE_TIME, hflails.use_time);
        values.put(VELOCITY, hflails.velocity);
        values.put(TOOLTIP, hflails.tooltip);
        values.put(GRANTS_BUFF, hflails.grants_buff);
        values.put(INFLICTS_DEBUFF, hflails.inflicts_debuff);
        values.put(RARITY, hflails.rarity);
        values.put(BUY_PRICE, hflails.buy_price);
        values.put(SELL_PRICE, hflails.sell_price);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<HFlails> getAllHFlails() {
        List<HFlails> hflail = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HFlails hflails = new HFlails(
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

                hflail.add(hflails);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return hflail;
    }

    public HFlails getHFlail(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE ID = " + id;
        Cursor cursor = db.rawQuery(selectQuery, null);
        HFlails hflails = null;

        if (cursor.moveToFirst()) {
            hflails = new HFlails(
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

        return hflails;
    }
}