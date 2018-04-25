package com.zevzikovas.aivaras.terraria.repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.HYoyos;

import java.util.ArrayList;
import java.util.List;

public class HYoyosRepository {
    private static final String TABLE_NAME = "yoyos";

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PICTURE = "picture";
    private static final String DAMAGE = "damage";
    private static final String KNOCKBACK = "knockback";
    private static final String CRITICAL_CHANCE = "critical_chance";
    private static final String USE_TIME = "use_time";
    private static final String VELOCITY = "velocity";
    private static final String GRANTS_BUFF = "grants_buff";
    private static final String INFLICTS_DEBUFF = "inflicts_debuff";
    private static final String RARITY = "rarity";
    private static final String BUY_PRICE = "buy_price";
    private static final String SELL_PRICE = "sell_price";

    private SQLiteOpenHelper dbHelper;

    public HYoyosRepository(SQLiteOpenHelper dbHelper) {
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
        prepareYoyos(db, "Format:C", R.drawable.item_format_c, 29, "3.25 (Weak)", "4%", "24 (Fast)", "16",  "None", "None", "Orange", "20 Gold", "4 Gold");
        prepareYoyos(db, "Gradient", R.drawable.item_gradient, 34, "3.8 (Weak)", "4%", "24 (Fast)", "16",  "None","None", "Orange", "20 Gold", "4 Gold");
        prepareYoyos(db, "Chik", R.drawable.item_chik, 39, "3.15 (Weak)", "4%", "24 (Fast)", "16",  "None", "None", "Light Red", "None", "4 Gold");
        prepareYoyos(db, "Hel-Fire", R.drawable.item_hel_fire, 41, "4.5 (Average)", "4%", "24 (Fast)", "16",  "None", "On Fire!", "Light Red", "None", "4 Gold");
        prepareYoyos(db, "Amarok", R.drawable.item_amarok, 43, "2.8 (Very Weak)", "4%", "24", "16",  "None", "Frostburn", "Light Red", "None", "4 Gold");
        prepareYoyos(db, "Code 2", R.drawable.item_code_2, 47, "3.8 (Weak)", "4%", "24 (Fast)", "16",  "None", "None", "Pink", "25 Gold","5 Gold");
        prepareYoyos(db, "Yelets", R.drawable.item_yelets, 60, "3.1 (Weak)", "4%", "24 (Fast)", "16",  "None", "None", "Lime", "None", "5 Gold");
        prepareYoyos(db, "Red's Throw", R.drawable.item_reds_throw, 70, "8.5 (Very Strong)", "4%", "24 (Fast)", "16", "None", "None", "Cyan", "None", "4 Gold");
        prepareYoyos(db, "Valkyrie Yoyo", R.drawable.item_valkyrie_yoyo, 70, "8.5 (Very Strong)", "4%", "24 (Fast)", "16",  "None", "None", "Cyan", "None", "4 Gold");
        prepareYoyos(db, "Kraken", R.drawable.item_kraken, 90, "4.3 (Average)", "4%", "24 (Fast)", "16",  "None", "None", "Yellow", "None","11 Gold");
        prepareYoyos(db, "The Eye of Cthulhu", R.drawable.item_the_eye_of_cthulhu, 115, "3.5 (Weak)", "4%", "24 (Fast)", "16",  "None", "None", "Yellow", "None", "11 Gold 50 Silver");
        prepareYoyos(db, "Terrarian", R.drawable.item_terrarian, 190, "6.5 (Strong)", "14%", "25 (Fast)", "16", "None", "None", "Red", "None", "10 Gold");

    }

    private void prepareYoyos(SQLiteDatabase db, String name, int picture, int damage, String knockback, String critical_chance, String use_time, String velocity, String grants_buff, String inflicts_debuff, String rarity, String buy_price, String sell_price) {
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(PICTURE, picture);
        values.put(DAMAGE, damage);
        values.put(KNOCKBACK, knockback);
        values.put(CRITICAL_CHANCE, critical_chance);
        values.put(USE_TIME, use_time);
        values.put(VELOCITY, velocity);
        values.put(GRANTS_BUFF, grants_buff);
        values.put(INFLICTS_DEBUFF, inflicts_debuff);
        values.put(RARITY, rarity);
        values.put(BUY_PRICE, buy_price);
        values.put(SELL_PRICE, sell_price);

        db.insert(TABLE_NAME, null, values);
    }

    public void addHYoyos(HYoyos hyoyos) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, hyoyos.name);
        values.put(PICTURE, hyoyos.picture);
        values.put(DAMAGE, hyoyos.damage);
        values.put(KNOCKBACK, hyoyos.knockback);
        values.put(CRITICAL_CHANCE, hyoyos.critical_chance);
        values.put(USE_TIME, hyoyos.use_time);
        values.put(VELOCITY, hyoyos.velocity);
        values.put(GRANTS_BUFF, hyoyos.grants_buff);
        values.put(INFLICTS_DEBUFF, hyoyos.inflicts_debuff);
        values.put(RARITY, hyoyos.rarity);
        values.put(BUY_PRICE, hyoyos.buy_price);
        values.put(SELL_PRICE, hyoyos.sell_price);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<HYoyos> getAllHYoyos() {
        List<HYoyos> hyoyo = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HYoyos hyoyos = new HYoyos(
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
                        cursor.getString(12)
                );

                hyoyo.add(hyoyos);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return hyoyo;
    }

    public HYoyos getHYoyo(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE ID = " + id;
        Cursor cursor = db.rawQuery(selectQuery, null);
        HYoyos hyoyos = null;

        if (cursor.moveToFirst()) {
            hyoyos = new HYoyos(
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
                    cursor.getString(12)
            );
        }

        cursor.close();
        db.close();

        return hyoyos;
    }
}