package com.zevzikovas.aivaras.terraria.repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Yoyos;

import java.util.ArrayList;
import java.util.List;

public class YoyosRepository {



    private static final String TABLE_NAME = "yoyos";

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

    public YoyosRepository(SQLiteOpenHelper dbHelper) {
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

    public void fill(SQLiteDatabase db) {
        prepareYoyos(db, "Wooden Yoyo", R.drawable.item_wooden_yoyo, 11, "5", "4%", 20, "None", "None", "None", "None", "White", "None", "20 Copper");
        prepareYoyos(db, "Rally", R.drawable.item_rally, 16, "3.5", "4%", 14, "None", "None", "None","None", "Green", "None", "50 Silver");
        prepareYoyos(db, "Malaise", R.drawable.item_malaise, 35, "20", "19%", 20, "None", "None", "None", "None", "Light Red", "25 Gold", "5 Gold");
        prepareYoyos(db, "Artery", R.drawable.item_artery, 39, "8", "4%", 29, "None", "None", "None", "None", "Light Red", "None", "3 Gold");
        prepareYoyos(db, "Amazon", R.drawable.item_amazon, 39, "3.85", "4%", 22, "None", "None", "None", "None", "Light Red", "None", "1 Gold 50 Silver");
        prepareYoyos(db, "Code 1", R.drawable.item_code_1, 41, "4.75", "4%", 24, "None", "None", "None", "None", "Light Red", "None","1 Gold 84 Silver");
        prepareYoyos(db, "Valor", R.drawable.item_valor, 41, "3", "4%", 24, "None", "None", "None", "None", "Light Red", "None", "54 Silver");
        prepareYoyos(db, "Cascade", R.drawable.item_cascade, 42, "5.5", "4%", 24, "8", "Shoots an icy sickle", "None", "None", "Pink", "None", "5 Gold");

    }

    private void prepareYoyos(SQLiteDatabase db, String name, int picture, int damage, String knockback, String critical_chance, int use_time, String velocity, String tooltip, String grants_buff, String inflicts_debuff, String rarity, String buy_price, String sell_price) {
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

    public void addYoyos(Yoyos yoyos) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, yoyos.name);
        values.put(PICTURE, yoyos.picture);
        values.put(DAMAGE, yoyos.damage);
        values.put(KNOCKBACK, yoyos.knockback);
        values.put(CRITICAL_CHANCE, yoyos.critical_chance);
        values.put(USE_TIME, yoyos.use_time);
        values.put(VELOCITY, yoyos.velocity);
        values.put(TOOLTIP, yoyos.tooltip);
        values.put(GRANTS_BUFF, yoyos.grants_buff);
        values.put(INFLICTS_DEBUFF, yoyos.inflicts_debuff);
        values.put(RARITY, yoyos.rarity);
        values.put(BUY_PRICE, yoyos.buy_price);
        values.put(SELL_PRICE, yoyos.sell_price);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Yoyos> getAllYoyos() {
        List<Yoyos> yoyo = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Yoyos yoyos = new Yoyos(
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

                yoyo.add(yoyos);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return yoyo;
    }

    public Yoyos getYoyos(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE ID = " + id;
        Cursor cursor = db.rawQuery(selectQuery, null);
        Yoyos yoyos = null;

        if (cursor.moveToFirst()) {
            yoyos = new Yoyos(
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

        return yoyos;
    }
}