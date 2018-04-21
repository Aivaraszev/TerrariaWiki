package com.zevzikovas.aivaras.terraria.repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Pickaxes;

import java.util.ArrayList;
import java.util.List;

public class PickaxesRepository {
        private static final String TABLE_NAME = "Pickaxes";

        private static final String ID = "id";
        private static final String NAME = "name";
        private static final String PICTURE = "picture";
        private static final String DAMAGE = "damage";
        private static final String KNOCKBACK = "knockback";
        private static final String BONUS = "bonus";
        private static final String CRITICAL_CHANSE = "critical_chanse";
        private static final String USE_TIME = "use time";
        private static final String TOOL_SPEED = "tool_speed";
        private static final String RARITY = "rarity";
        private static final String BUY_PRICE = "buy_price";
        private static final String SELL_PRICE = "sell_price";
        private static final String PICKAXE_POWER = "pickaxe_power";
        private static final String AXE_POWER = "axe_power";
        private SQLiteOpenHelper dbHelper;


    public PickaxesRepository(SQLiteOpenHelper dbHelper) {this.dbHelper = dbHelper; }

    public void create(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME + " (" +
                        ID + "INTEGER PRIMARY KEY," +
                        NAME + "TEXT," +
                        PICTURE + "INTEGER," +
                        DAMAGE + "INTEGER," +
                        KNOCKBACK + "TEXT," +
                        BONUS + "TEXT," +
                        CRITICAL_CHANSE + "TEXT," +
                        USE_TIME + "TEXT," +
                        TOOL_SPEED + "INTEGER," +
                        RARITY + "TEXT," +
                        BUY_PRICE + "TEXT," +
                        SELL_PRICE + "TEXT," +
                        PICKAXE_POWER + "TEXT," +
                        AXE_POWER + "TEXT" +
                        ")"
        );
    }

    public void drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public void fill(SQLiteDatabase db) {

        preparePickaxes(db, "Copper Pickaxe", R.drawable.item_copper_pickaxe, 4, "2 (Very Weak)","-1 range", "4%", "22 (Fast)",15, "White", "5 Silver" ,"1 Silver", "35%", "None");
        preparePickaxes(db, "Tin Pickaxe", R.drawable.item_tin_pickaxe, 5, "2 (Very Weak)","None","4%","20 (Very Fast)",14,"White", "None","1 Silver 50 Copper", "35%", "None");
        preparePickaxes(db, "Cactus Pickaxe", R.drawable.item_cactus_pickaxe, 5, "2 (Very Weak)","None", "4%","22 (Fast)",15,"White", "None" ,"4 Silver", "35%", "None");
        preparePickaxes(db, "Iron Pickaxe", R.drawable.item_iron_pickaxe, 5, "2 (Very Weak)","None", "4%","19 (Very Fast)",13,"White", "20 Silver" ,"4 Silver", "40%", "None");
        preparePickaxes(db, "Lead Pickaxe", R.drawable.item_lead_pickaxe, 6, "2 (Very Weak)","None", "4%", "18 (Very Fast)",12,"White", "None" ,"6 Silver", "43%", "None");
        preparePickaxes(db, "Silver Pickaxe", R.drawable.item_silver_pickaxe, 6, "2 (Very Weak)","None", "4%","18 (Very Fast)",11,"White", "None" ,"10 Silver", "45%", "None");
        preparePickaxes(db, "Tungsten Pickaxe", R.drawable.item_tungsten_pickaxe, 6, "2 (Very Weak)","None", "4%","20 (Very Fast)",19,"White", "None" ,"15 Silver", "50%", "None");
        preparePickaxes(db, "Bone Pickaxe", R.drawable.item_bone_pickaxe, 8, "3 (Very Weak)","None", "4%","18 (Very Fast)",11,"Blue", "None" ,"30 Silver", "50%", "None");
        preparePickaxes(db, "Gold Pickaxe", R.drawable.item_gold_pickaxe, 6, "2 (Very Weak)","None", "4%","19 (Very Fast)",17,"White", "None" ,"20 Silver", "55%", "None");
        preparePickaxes(db, "Candy Cane Pickaxe", R.drawable.item_candy_cane_pickaxe, 7, "2.5 (Very Weak)","None", "4%","19 (Very Fast)",16,"White", "None" ,"20 Silver", "55%", "None");
        preparePickaxes(db, "Platinum Pickaxe", R.drawable.item_platinum_pickaxe, 7, "2 (Very Weak)","None", "4%","18 (Very Fast)",15,"White", "None" ,"30 Silver", "59%", "None");
        preparePickaxes(db, "Nightmare Pickaxe", R.drawable.item_nightmare_pickaxe, 9, "3 (Very Weak)","None", "4%","19 (Very Fast)",15,"Blue", "None" ,"36 Silver", "65%", "None");
        preparePickaxes(db, "Deathbringer Pickaxe", R.drawable.item_deathbringer_pickaxe, 12, "3.5 (Weak)","None", "4%","21 (Fast)",14,"Blue", "None" ,"36 Silver", "70%", "None");
        preparePickaxes(db, "Reaver Shark", R.drawable.item_reaver_shark, 16, "3 (Very Weak)","None", "4%","21 (Fast)",18,"Orange", "None" ,"1 Gold 50 Silver", "100%", "None");
        preparePickaxes(db, "Molten Pickaxe", R.drawable.item_molten_pickaxe, 12, "2 (Very Weak)","Inflicts Debuff On Fire!","4%","22(Fast)",15,"Orange", "None" ,"54 Silver", "100%", "None");
        preparePickaxes(db, "Cobalt Pickaxe", R.drawable.item_cobalt_pickaxe, 5, "5 (Average)","None", "4%","24 (Fast)",13,"Light Red", "None" ,"1 Gold 8 Silver", "110%", "None");
        preparePickaxes(db, "Palladium Pickaxe", R.drawable.item_palladium_pickaxe, 12, "5 (Average)","None", "4%","24 (Fast)",11,"Light Red", "None" ,"1 Gold 44 Silver", "130%", "None");
        preparePickaxes(db, "Mythril Pickaxe", R.drawable.item_mythril_pickaxe, 15, "5 (Average)","None", "4%","24 (Fast)",10,"Light Red", "None" ,"1 Gold 62 Silver", "150%", "None");
        preparePickaxes(db, "Orichalcum Pickaxe", R.drawable.item_orichalcum_pickaxe, 17, "5 (Average)","None", "4%","24 (Fast)",8,"Light Red", "None" ,"1 Gold 98 Silver", "165%", "None");
        preparePickaxes(db, "Adamantite Pickaxe", R.drawable.item_adamantite_pickaxe, 20, "5 (Average)","None", "4%","24 (Fast)",24,"Light Red", "None" ,"2 Gold 16 Silver", "180%", "None");
        preparePickaxes(db, "Titanium Pickaxe", R.drawable.item_titanium_pickaxe, 27, "5 (Average)","None", "4%","24 (Fast)",7,"Light Red", "None" ,"2 Gold 52 Silver", "190%", "None");
        preparePickaxes(db, "Pickaxe Axe", R.drawable.item_pickaxe_axe, 35, "4.75 (Average)","None", "4%","24 (Fast)",7,"Light Red", "None" ,"4 Gold 40 Silver", "200%", "110%");
        preparePickaxes(db, "Chlorophyte Pickaxe", R.drawable.item_chlorophyte_pickaxe, 40, "5 (Average)","+1 range", "4%","24 (Fast)",7,"Lime", "None" ,"4 Gold 32 Silver", "200%", "None");
        preparePickaxes(db, "Spectre Pickaxe", R.drawable.item_spectre_pickaxe, 32, "5.25 (Average)","None", "4%","23 (Fast)",10,"Yellow", "None" ,"4 Gold 32 Silver", "200%", "None");
        preparePickaxes(db, "Shroomite Digging Claw", R.drawable.item_shroomite_digging_claw, 45, "6 (Average)","-1 range", "4%","11 (Very Fast)",4,"Yellow", "None" ,"1 Gold", "200%", "125%");
        preparePickaxes(db, "Picksaw", R.drawable.item_picksaw, 34, "5.5 (Average)","+1 range", "4%","15 (Very Fast)",6,"Lime", "None" ,"4 Gold 32 Silver", "210%", "125%");
        preparePickaxes(db, "Solar Flare Pickaxe", R.drawable.item_solar_flare_pickaxe, 80, "5.5 (Average)","+4 range", "4%","11 (Very Fast)",6,"Red", "None" ,"5 Gold", "225%", "None");
        preparePickaxes(db, "Vortex Pickaxe", R.drawable.item_vortex_pickaxe, 80, "5.5 (Average)","+4 range", "4%","11 (Very Fast)",6,"Red", "None" ,"5 Gold", "225%", "None");
        preparePickaxes(db, "Nebula Pickaxe", R.drawable.item_nebula_pickaxe, 80, "5.5 (Average)","+4 range", "4%","11 (Very Fast)",6,"Red", "None" ,"5 Gold", "225%", "None");
        preparePickaxes(db, "Stardust Pickaxe", R.drawable.item_stardust_pickaxe, 80, "5.5 (Average)","+4 range", "4%","11 (Very Fast)",6,"Red", "None" ,"5 Gold", "225%", "None");
    }

    private void preparePickaxes(SQLiteDatabase db, String name, int picture, int damage, String knockback, String bonus, String critical_chanse, String use_time, int tool_speed, String rarity, String buy_price, String sell_price, String pickaxe_power, String axe_power) {
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(PICTURE, picture);
        values.put(DAMAGE, damage);
        values.put(KNOCKBACK, knockback);
        values.put(BONUS, bonus);
        values.put(CRITICAL_CHANSE, critical_chanse);
        values.put(USE_TIME, use_time);
        values.put(TOOL_SPEED, tool_speed);
        values.put(RARITY, rarity);
        values.put(BUY_PRICE, buy_price);
        values.put(SELL_PRICE, sell_price);
        values.put(PICKAXE_POWER, pickaxe_power);
        values.put(AXE_POWER, axe_power);
        db.insert(TABLE_NAME, null, values);
    }
        public void addPickaxes(Pickaxes pickaxes) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(NAME, pickaxes.name);
            values.put(PICTURE, pickaxes.picture);
            values.put(DAMAGE, pickaxes.damage);
            values.put(KNOCKBACK, pickaxes.knockback);
            values.put(BONUS, pickaxes.bonus);
            values.put(CRITICAL_CHANSE, pickaxes.critical_chanse);
            values.put(USE_TIME, pickaxes.use_time);
            values.put(TOOL_SPEED, pickaxes.tool_speed);
            values.put(RARITY, pickaxes.rarity);
            values.put(BUY_PRICE, pickaxes.buy_price);
            values.put(SELL_PRICE, pickaxes.sell_price);
            values.put(PICKAXE_POWER, pickaxes.pickaxe_power);
            values.put(AXE_POWER, pickaxes.axe_power);
            db.insert(TABLE_NAME, null, values);
            db.close();
        }

    public List<Pickaxes> getAllPickaxes() {
        List<Pickaxes> pickaxe = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
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
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getInt(8),
                        cursor.getString(9),
                        cursor.getString(10),
                        cursor.getString(11),
                        cursor.getString(12),
                        cursor.getString(13)
                );

                pickaxe.add(pickaxes);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return pickaxe;
    }
}