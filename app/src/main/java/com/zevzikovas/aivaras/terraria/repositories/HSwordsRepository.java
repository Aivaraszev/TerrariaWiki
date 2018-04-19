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
    private static final String KNOCKBACK = "knockback";
    private static final String CRITICAL_CHANCE = "critical chance";
    private static final String USE_TIME = "use time";
    private static final String RARITY = "rarity";
    private static final String PRICE = "price";
    private SQLiteOpenHelper dbHelper;

    public HSwordsRepository(SQLiteOpenHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public void create(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME + " (" +
                        ID + "INTEGER PRIMARY KEY," +
                        NAME + "TEXT," +
                        PICTURE + "INTEGER," +
                        DAMAGE + "INTEGER," +
                        KNOCKBACK + "INTEGER," +
                        CRITICAL_CHANCE + "TEXT," +
                        USE_TIME + "INTEGER," +
                        RARITY + "TEXT," +
                        PRICE + "INTEGER" +
                        ")"
        );
    }

    public void drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public void fill(SQLiteDatabase db) {
        prepareHswords(db, "Pearlwood sword", R.drawable.item_pearlwood_sword, 11, "White", 20,);
        prepareHswords(db, "Classy Cane", R.drawable.item_classy_cane, 16, 3, 3, "Light Red", 3);
        prepareHswords(db, "Slap Hand", R.drawable.item_slap_hand, 35, "Light Red", 50000);
        prepareHswords(db, "Breaker Blade", R.drawable.item_breaker_blade, 39, "Light Red", 30000);
        prepareHswords(db, "Cobalt Sword", R.drawable.item_cobalt_sword, 39, "Light Red", 13800);
        prepareHswords(db, "Palladium Sword", R.drawable.item_palladium_sword, 41, "Light Red", 18400);
        prepareHswords(db, "Phasesaber", R.drawable.item_phasesaber, 41, "Light Red", 5400);
        prepareHswords(db, "Ice Sickle", R.drawable.item_ice_sickle, 42, "Pink", 50000);
        prepareHswords(db, "Brand of the Inferno", R.drawable.item_brand_of_the_inferno, 44, "Pink", 10000);
        prepareHswords(db, "Mythril Sword", R.drawable.item_mythril_sword, 44, "Light Red", 20700);
        prepareHswords(db, "Orichalcum Sword", R.drawable.item_orichalcum_sword, 47, "Light Red", 25300);
        prepareHswords(db, "Chlorophyte Saber", R.drawable.item_chlorophyte_saber, 48, "Lime", 55200);
        prepareHswords(db, "Cutlass", R.drawable.item_cutlass, 11, "White", 20);
        prepareHswords(db, "Frostbrand", R.drawable.item_frostbrand, 11, "White", 20);
        prepareHswords(db, "Adamantite Sword", R.drawable.item_adamantite_sword, 11, "White", 20);
        prepareHswords(db, "Seedler", R.drawable.item_seedler, 11, "White", 20);
        prepareHswords(db, "Beam Sword", R.drawable.item_beam_sword, 11, "White", 20);
        prepareHswords(db, "Titanium Sword", R.drawable.item_titanium_sword, 11, "White", 20);
        prepareHswords(db, "Bladetongue", R.drawable.item_bladetongue, 11, "White", 20);
        prepareHswords(db, "Death Sickle", R.drawable.item_death_sickle, 11, "White", 20);
        prepareHswords(db, "Excalibur", R.drawable.item_excalibur, 11, "White", 20);
        prepareHswords(db, "True Excalibur", R.drawable.item_true_excalibur, 11, "White", 20);
        prepareHswords(db, "Fetid Baghnakhs", R.drawable.item_fetid_baghnakhs, 11, "White", 20);
        prepareHswords(db, "Keybrand", R.drawable.item_keybrand, 11, "White", 20);
        prepareHswords(db, "Psycho Knife", R.drawable.item_psycho_knife, 11, "White", 20);
        prepareHswords(db, "Chlorophyte Claymore", R.drawable.item_chlorophyte_claymore, 11, "White", 20);
        prepareHswords(db, "The Horseman's Blade", R.drawable.item_the_horsemans_blade, 11, "White", 20);
        prepareHswords(db, "Christmas Tree Sword", R.drawable.item_christmas_tree_sword, 11, "White", 20);
        prepareHswords(db, "True Night's Edge", R.drawable.item_true_nights_edge, 11, "White", 20);
        prepareHswords(db, "Terra Blade", R.drawable.item_terra_blade, 11, "White", 20);
        prepareHswords(db, "Flying Dragon", R.drawable.item_flying_dragon, 11, "White", 20);
        prepareHswords(db, "Influx Waver", R.drawable.item_influx_waver, 11, "White", 20);
        prepareHswords(db, "Star Wrath", R.drawable.item_star_wrath, 11, "White", 20);
        prepareHswords(db, "Meowmere", R.drawable.item_meowmere, 11, "White", 20);
    }

    private void prepareHswords(SQLiteDatabase db, String name, int picture, int damage, int knockback, String critical_chance, int use_time, String rarity, int price) {
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(PICTURE, picture);
        values.put(DAMAGE, damage);
        values.put(KNOCKBACK, knockback);
        values.put(CRITICAL_CHANCE, critical_chance);
        values.put(USE_TIME, use_time);
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
        values.put(KNOCKBACK, hswords.knockback);
        values.put(CRITICAL_CHANCE, hswords.critical_chance);
        values.put(USE_TIME, hswords.use_time);
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
                        cursor.getInt(4),
                        cursor.getString(5),
                        cursor.getInt(6),
                        cursor.getString(7),
                        cursor.getInt(8)
                );

                hsword.add(hswords);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return hsword;
    }
}