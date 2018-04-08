package com.zevzikovas.aivaras.terraria.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class PickaxesRepository  extends SQLiteOpenHelper {

     private static final int DATABASE_VERSION = 1;

        private static final String DATABASE_NAME = "terraria_wiki_db";

        private static final String TABLE_NAME = "Pickaxes";

        private static final String ID = "id";
        private static final String NAME = "name";
        private static final String PICTURE = "picture";
        private static final String DAMAGE = "damage";
        private static final String RARITY = "rarity";
        private static final String PRICE = "price";


        public PickaxesRepository(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
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

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }

        private void preparePickaxes(SQLiteDatabase db, String name, int picture, int damage, String rarity, int price) {
            ContentValues values = new ContentValues();
            values.put(NAME, name);
            values.put(PICTURE, picture);
            values.put(DAMAGE, damage);
            values.put(RARITY, rarity);
            values.put(PRICE, price);
            db.insert(TABLE_NAME, null, values);
        }

        public void addPickaxes(Pickaxes pickaxes) {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(NAME, pickaxes.name);
            values.put(PICTURE, pickaxes.picture);
            values.put(DAMAGE, pickaxes.damage);
            values.put(RARITY, pickaxes.rarity);
            values.put(PRICE, pickaxes.price);

            db.insert(TABLE_NAME, null, values);
            db.close();
        }

        public List<Pickaxes> getAllPickaxe() {
            List<Pickaxes> pickaxe = new ArrayList<>();
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT * FROM " + TABLE_NAME;
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    Pickaxes pickaxes = new Pickaxes(
                            cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getInt(2),
                            cursor.getInt(3),
                            cursor.getString(4),
                            cursor.getInt(5)
                    );

                    pickaxe.add(pickaxes);
                } while (cursor.moveToNext());
            }

            cursor.close();
            db.close();

            return pickaxe;
        }
    }
}
