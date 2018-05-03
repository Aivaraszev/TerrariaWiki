package com.zevzikovas.aivaras.terraria.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Spears;

import java.util.ArrayList;
import java.util.List;

public class SpearsRepository {
    private static final String TABLE_NAME = "spears";

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

    public SpearsRepository(SQLiteOpenHelper dbHelper) {
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
    public void fill(SQLiteDatabase db) {
        prepareSpears(db, "Spear", R.drawable.item_spear, 8, "6.5 (Strong)", "4%", "30 (Average)", "3.7", "None", "None", "None", "White", "None", "2 Silver");
        prepareSpears(db, "Triden", R.drawable.item_trident, 11, "5 (Average)", "4%", "30 (Average)", "4", "None", "None", "None", "Blue", "None", "20 Silver");
        prepareSpears(db, "The Rotted Fork", R.drawable.item_the_rotted_fork, 14, "5 (Average)", "4%", "30 (Average)", "4", "None", "None", "None", "Blue", "None", "20 Silver");
        prepareSpears(db, "Swordfish", R.drawable.item_swordfish, 19, "4.25 (Average)", "4%", "19 (Very Fast)", "4", "None", "None", "None", "Green", "None", "50 Silver");
        prepareSpears(db, "Dark Lance", R.drawable.item_dark_lance, 29, "5 (Average)", "4%", "21 (Fast)", "3", "None", "None", "None", "Orange", "None", "54 Silver");
    }

    private void prepareSpears(SQLiteDatabase db, String name, int picture, int damage, String knockback, String critical_chance, String use_time, String velocity, String tooltip, String grants_buff, String inflicts_debuff, String rarity, String buy_price, String sell_price) {
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

    public void addSpears(Spears spears) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, spears.name);
        values.put(PICTURE, spears.picture);
        values.put(DAMAGE, spears.damage);
        values.put(KNOCKBACK, spears.knockback);
        values.put(CRITICAL_CHANCE, spears.critical_chance);
        values.put(USE_TIME, spears.use_time);
        values.put(VELOCITY, spears.velocity);
        values.put(TOOLTIP, spears.tooltip);
        values.put(GRANTS_BUFF, spears.grants_buff);
        values.put(INFLICTS_DEBUFF, spears.inflicts_debuff);
        values.put(RARITY, spears.rarity);
        values.put(BUY_PRICE, spears.buy_price);
        values.put(SELL_PRICE, spears.sell_price);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Spears> getAllSpear() {
        List<Spears> spear = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Spears spears = new Spears(
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

                spear.add(spears);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return spear;
    }

    public Spears getSpear(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE ID = " + id;
        Cursor cursor = db.rawQuery(selectQuery, null);
        Spears spears = null;

        if (cursor.moveToFirst()) {
            spears = new Spears(
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

        return spears;
    }
}