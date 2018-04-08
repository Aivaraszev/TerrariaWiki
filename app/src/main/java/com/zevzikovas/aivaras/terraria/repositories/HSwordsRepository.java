package com.zevzikovas.aivaras.terraria.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Hswords;

import java.util.ArrayList;
import java.util.List;

public class HSwordsRepository {
    private static final String TABLE_NAME = "hswords";

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PICTURE = "picture";
    private static final String DAMAGE = "damage";
    private static final String RARITY = "rarity";
    private static final String PRICE = "price";
    private SQLiteOpenHelper dbHelper;

    public HSwordsRepository(SQLiteOpenHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public void create(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME + " (" +
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
        prepareHswords(db, "Pearlwood sword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_classy_cane, 16, "Green", 5000);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
        prepareHswords(db, "Copper Shortsword", R.drawable.item_pearlwood_sword, 11, "White", 20);
    }

    private void prepareHswords(SQLiteDatabase db, String name, int picture, int damage, String rarity, int price) {
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(PICTURE, picture);
        values.put(DAMAGE, damage);
        values.put(RARITY, rarity);
        values.put(PRICE, price);
        db.insert(TABLE_NAME, null, values);
    }

    public void addHswords(Hswords hswords) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, hswords.name);
        values.put(PICTURE, hswords.picture);
        values.put(DAMAGE, hswords.damage);
        values.put(RARITY, hswords.rarity);
        values.put(PRICE, hswords.price);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Hswords> getAllHsword() {
        List<Hswords> hsword = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Hswords hswords = new Hswords(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        cursor.getString(4),
                        cursor.getInt(5)
                );

                hsword.add(hswords);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return hsword;
    }
}