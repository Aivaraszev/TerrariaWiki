package com.zevzikovas.aivaras.terraria.repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Others;

import java.util.ArrayList;
import java.util.List;

public class OthersRepository {
    private static final String TABLE_NAME = "others";

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

    public OthersRepository(SQLiteOpenHelper dbHelper) {
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
        prepareOthers(db, "Shadowflame Knife", R.drawable.item_shadowflame_knife, 38, "5.75 (Average)", "7%", "11 (Very Fast)", "13", "Inflicts Shadowflame on hit", "None", "Shadowflame (Losing life)", "Pink", "None", "2 Gold");
        prepareOthers(db, "Sleepy Octopod", R.drawable.item_sleepy_octopod, 40, "7 (Strong)", "4%", "30 (Average)", "24", "Charges power as it is swung to smash enemies", "None","None", "Pink", "None", "1 Gold");
        prepareOthers(db, "Scourge of the Corruptor", R.drawable.item_scourge_of_the_corruptor, 64, "5 (Average)", "4%", "19 (Very Fast)", "14", "A powerful javelin that unleashes tiny eaters", "None", "None", "Yellow", "None", "20 Gold");
        prepareOthers(db, "Vamipre Knives", R.drawable.item_vampire_knives, 31, "2.75 (Very Weak)", "4%", "15 (Very Fast)", "15", "Rapidly throws life stealing daggers", "None", "None", "Yellow", "None", "20 Gold");
        prepareOthers(db, "Sky Dragon's Fury", R.drawable.item_sky_dragons_fury, 70, "8 (Average)", "4%", "30 (Average)", "24", "Right Click while holding for an alternate attack!", "None", "None", "Yellow", "None", "5 Gold");
        prepareOthers(db, "Daybreak", R.drawable.item_daybreak, 150, "5 (Average)", "4%", "15 (Very Fast)", "10", "Rend your foes asunder with a spear of light!'", "None", "Daybroken (Incinerated by solar rays)", "Red", "None","10 Gold");

    }

    private void prepareOthers(SQLiteDatabase db, String name, int picture, int damage, String knockback, String critical_chance, String use_time, String velocity, String tooltip, String grants_buff, String inflicts_debuff, String rarity, String buy_price, String sell_price) {
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

    public void addOthers(Others others) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, others.name);
        values.put(PICTURE, others.picture);
        values.put(DAMAGE, others.damage);
        values.put(KNOCKBACK, others.knockback);
        values.put(CRITICAL_CHANCE, others.critical_chance);
        values.put(USE_TIME, others.use_time);
        values.put(VELOCITY, others.velocity);
        values.put(TOOLTIP, others.tooltip);
        values.put(GRANTS_BUFF, others.grants_buff);
        values.put(INFLICTS_DEBUFF, others.inflicts_debuff);
        values.put(RARITY, others.rarity);
        values.put(BUY_PRICE, others.buy_price);
        values.put(SELL_PRICE, others.sell_price);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Others> getAllOther() {
        List<Others> other = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Others others = new Others(
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

                other.add(others);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return other;
    }

    public Others getOther(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE ID = " + id;
        Cursor cursor = db.rawQuery(selectQuery, null);
        Others others = null;

        if (cursor.moveToFirst()) {
            others = new Others(
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

        return others;
    }
}