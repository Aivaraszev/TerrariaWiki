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
//TODO: make "crafting"
    public void fill(SQLiteDatabase db) {
        prepareHswords(db, "Pearlwood Sword", R.drawable.item_pearlwood_sword, 11, "5", "4%", 20, "None", "None", "None", "None", "White", "None", "20 Copper");
        prepareHswords(db, "Classy Cane", R.drawable.item_classy_cane, 16, "3.5", "4%", 14, "None", "None", "None","None", "Green", "None", "50 Silver");
        prepareHswords(db, "Slap Hand", R.drawable.item_slap_hand, 35, "20", "19%", 20, "None", "None", "None", "None", "Light Red", "25 Gold", "5 Gold");
        prepareHswords(db, "Breaker Blade", R.drawable.item_breaker_blade, 39, "8", "4%", 29, "None", "None", "None", "None", "Light Red", "None", "3 Gold");
        prepareHswords(db, "Cobalt Sword", R.drawable.item_cobalt_sword, 39, "3.85", "4%", 22, "None", "None", "None", "None", "Light Red", "None", "1 Gold 50 Silver");
        prepareHswords(db, "Palladium Sword", R.drawable.item_palladium_sword, 41, "4.75", "4%", 24, "None", "None", "None", "None", "Light Red", "None","1 Gold 84 Silver");
        prepareHswords(db, "Phasesaber", R.drawable.item_phasesaber, 41, "3", "4%", 24, "None", "None", "None", "None", "Light Red", "None", "54 Silver");
        prepareHswords(db, "Ice Sickle", R.drawable.item_ice_sickle, 42, "5.5", "4%", 24, "8", "Shoots an icy sickle", "None", "None", "Pink", "None", "5 Gold");
        prepareHswords(db, "Brand of the Inferno", R.drawable.item_brand_of_the_inferno, 44, "6.5", "4%", 24, "24", "Right Click to guard with a shield", "Striking Moment", "None", "Pink", "None", "1 Gold");
        prepareHswords(db, "Mythril Sword", R.drawable.item_mythril_sword, 44, "6", "4%", 25, "None", "None", "None", "None", "Light Red", "None", "2 Gold 7 Silver");
        prepareHswords(db, "Orichalcum Sword", R.drawable.item_orichalcum_sword, 47, "6", "4%", 25, "None", "None", "None", "None", "Light Red", "None", "2 Gold 53 Silver");
        prepareHswords(db, "Chlorophyte Saber", R.drawable.item_chlorophyte_saber, 48, "4", "4%", 15, "8", "Shoots a spore cloud", "None", "None", "Lime", "None", "5 Gold 52 Silver");
        prepareHswords(db, "Cutlass", R.drawable.item_cutlass, 49, "4", "4%", 17, "None", "None", "None", "None", "Light Red", "None", "3 Gold 60 Silver");
        prepareHswords(db, "Frostbrand", R.drawable.item_frostbrand, 49, "4.5", "4%", 22, "12", "Shoots an icy bolt", "None", "None", "Pink", "None", "5 Gold");
        prepareHswords(db, "Adamantite Sword", R.drawable.item_adamantite_sword, 50, "6", "4%", 26, "None", "None", "None", "None", "Light Red", "None", "2 Gold 76 Silver");
        prepareHswords(db, "Seedler", R.drawable.item_seedler, 50, "6", "4%", 22, "12", "None", "None", "None", "Pink", "None", "10 Gold");
        prepareHswords(db, "Beam Sword", R.drawable.item_beam_sword, 52, "6.5", "4%", 14, "11", "Shoots a beam of light", "None", "None", "Light Red", "None", "10 Gold");
        prepareHswords(db, "Titanium Sword", R.drawable.item_titanium_sword, 52, "6", "4%", 25, "None", "None", "None", "None", "Light Red", "None", "3 Gold 22 Silver");
        prepareHswords(db, "Bladetongue", R.drawable.item_bladetongue, 55, "5.75", "4%", 27, "None", "Spits an Ichor stream on contact", "None", "Ichor", "Pink", "None", "4 Gold");
        prepareHswords(db, "Death Sickle", R.drawable.item_death_sickle, 57, "7", "4%", 24, "9", "Shoots a deathly sickle", "None", "None", "Light Purple", "None", "5 Gold");
        prepareHswords(db, "Excalibur", R.drawable.item_excalibur, 57, "4.5", "4%", 24, "None", "None", "None", "None", "Pink", "None", "4 Gold 60 Silver");
        prepareHswords(db, "True Excalibur", R.drawable.item_true_excalibur, 66, "4.5", "4%", 15, "11", "None", "None", "None", "Yellow", "None", "10 Gold");
        prepareHswords(db, "Fetid Baghnakhs", R.drawable.item_fetid_baghnakhs, 70, "6", "4%",6, "None", "None", "None", "None", "Pink", "None", "8 Gold");
        prepareHswords(db, "Keybrand", R.drawable.item_keybrand, 70, "6.5", "17%", 19, "None", "None", "None", "None", "Yellow", "None", "2 Gold 76 Silver");
        prepareHswords(db, "Psycho Knife", R.drawable.item_psycho_knife, 70, "3.5", "4%", 19, "None", "Allows you to go into stealth mode", "None", "None", "Yellow", "None", "5 Gold");
        prepareHswords(db, "Chlorophyte Claymore", R.drawable.item_chlorophyte_claymore, 75, "6", "4%", 25, "8", "Shoots a powerful orb", "None", "None", "Lime", "None", "5 Gold 52 Silver");
        prepareHswords(db, "The Horseman's Blade", R.drawable.item_the_horsemans_blade, 75, "7.5", "4%", 25, "12", "Summons Pumpkin heads to attack your enemies", "None", "None", "Yellow", "None", "10 Gold");
        prepareHswords(db, "Christmas Tree Sword", R.drawable.item_christmas_tree_sword, 86, "7", "4%", 22, "None", "None", "None", "None", "Yellow", "None", "10 Gold");
        prepareHswords(db, "True Night's Edge", R.drawable.item_true_nights_edge, 90, "4.75", "4%", 25, "10", "None", "None", "None", "Yellow", "None", "10 Gold");
        prepareHswords(db, "Terra Blade", R.drawable.item_terra_blade, 95, "6.5", "4%", 15, "12", "None", "None", "None", "Yellow", "None", "20 Gold");
        prepareHswords(db, "Flying Dragon", R.drawable.item_flying_dragon, 90, "5.5", "4%", 24, "17", "Unleashes the heart's energy forward", "None", "None", "Yellow", "None", "5 Gold");
        prepareHswords(db, "Influx Waver", R.drawable.item_influx_waver, 110, "4.5","4%", 19, "11", "None", "None", "None", "Yellow", "None", "10 Gold");
        prepareHswords(db, "Star Wrath", R.drawable.item_star_wrath, 110, "6.5", "4%", 15, "8", "None", "None", "None", "Cyan","None", "20 Gold");
        prepareHswords(db, "Meowmere", R.drawable.item_meowmere, 200, "6.5", "4%", 15, "12", "None", "None", "None", "Red", "None", "20 Gold");
    }

    private void prepareHswords(SQLiteDatabase db, String name, int picture, int damage, String knockback, String critical_chance, int use_time, String velocity, String tooltip, String grants_buff, String inflicts_debuff, String rarity, String buy_price, String sell_price) {
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

    public void addHswords(Hswords hswords) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, hswords.name);
        values.put(PICTURE, hswords.picture);
        values.put(DAMAGE, hswords.damage);
        values.put(KNOCKBACK, hswords.knockback);
        values.put(CRITICAL_CHANCE, hswords.critical_chance);
        values.put(USE_TIME, hswords.use_time);
        values.put(VELOCITY, hswords.velocity);
        values.put(TOOLTIP, hswords.tooltip);
        values.put(GRANTS_BUFF, hswords.grants_buff);
        values.put(INFLICTS_DEBUFF, hswords.inflicts_debuff);
        values.put(RARITY, hswords.rarity);
        values.put(BUY_PRICE, hswords.buy_price);
        values.put(SELL_PRICE, hswords.sell_price);

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

                hsword.add(hswords);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return hsword;
    }

    public Hswords getSword(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE ID = " + id;
        Cursor cursor = db.rawQuery(selectQuery, null);
        Hswords hswords = null;

        if (cursor.moveToFirst()) {
            hswords = new Hswords(
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

        return hswords;
    }
}