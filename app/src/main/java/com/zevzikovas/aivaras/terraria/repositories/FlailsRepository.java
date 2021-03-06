package com.zevzikovas.aivaras.terraria.repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Flails;

import java.util.ArrayList;
import java.util.List;

public class FlailsRepository {
    private static final String TABLE_NAME = "flails";

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

    public FlailsRepository(SQLiteOpenHelper dbHelper) {
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
        prepareFlails(db, "Chain Knife", R.drawable.item_chain_knife, 11, "3.5 (Weak)", "4%", "19 (Very Fast)", "12", "None", "None", "None", "Green", "None", "2 Silver");
        prepareFlails(db, "Ball O' Hurt", R.drawable.item_ball_o_hurt, 15, "6.5 (Strong)", "4%", "44 (Very Slow)", "12", "None", "None", "None", "Blue", "None", "54 Silver");
        prepareFlails(db, "The Meatball", R.drawable.item_the_meatball, 16, "6.5 (Strong)", "4%", "44 (Very Slow)", "12", "None", "None", "None", "Blue", "none", "54 Silver");
        prepareFlails(db, "Blue Moon", R.drawable.item_blue_moon, 23, "7 (Strong)", "4%", "44 (Very Slow)", "12", "None", "None", "None", "Green", "None", "54 Silver");
        prepareFlails(db, "Sunfury", R.drawable.item_sunfury, 35, "7.75 (Very Strong)", "11%", "44 (Very Slow)", "12", "None", "None", "On Fire (Slowly losing life)", "Orange", "None", "54 Silver");
    }

    private void prepareFlails(SQLiteDatabase db, String name, int picture, int damage, String knockback, String critical_chance, String use_time, String velocity, String tooltip, String grants_buff, String inflicts_debuff, String rarity, String buy_price, String sell_price) {
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

    public void addFlails(Flails flails) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, flails.name);
        values.put(PICTURE, flails.picture);
        values.put(DAMAGE, flails.damage);
        values.put(KNOCKBACK, flails.knockback);
        values.put(CRITICAL_CHANCE, flails.critical_chance);
        values.put(USE_TIME, flails.use_time);
        values.put(VELOCITY, flails.velocity);
        values.put(TOOLTIP, flails.tooltip);
        values.put(GRANTS_BUFF, flails.grants_buff);
        values.put(INFLICTS_DEBUFF, flails.inflicts_debuff);
        values.put(RARITY, flails.rarity);
        values.put(BUY_PRICE, flails.buy_price);
        values.put(SELL_PRICE, flails.sell_price);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Flails> getAllFlails() {
        List<Flails> flail = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Flails flails = new Flails(
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

                flail.add(flails);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return flail;
    }

    public Flails getFlail(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE ID = " + id;
        Cursor cursor = db.rawQuery(selectQuery, null);
        Flails flails = null;

        if (cursor.moveToFirst()) {
            flails = new Flails(
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

        return flails;
    }
}