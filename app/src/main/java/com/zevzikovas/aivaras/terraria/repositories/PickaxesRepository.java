package com.zevzikovas.aivaras.terraria.repositories;

import android.content.ContentValues;
import android.content.Context;
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
        private static final String RARITY = "rarity";
        private static final String PRICE = "price";
        private static final String POWER = "power";
        private SQLiteOpenHelper dbHelper;


    public PickaxesRepository(SQLiteOpenHelper dbHelper) {this.dbHelper = dbHelper; }

    public void create(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME + " (" +
                        ID + " INTEGER PRIMARY KEY," +
                        NAME + " TEXT," +
                        PICTURE + " INTEGER," +
                        DAMAGE + " INTEGER," +
                        KNOCKBACK + " INTEGER," +
                        RARITY + " TEXT," +
                        PRICE + " INTEGER" +
                        POWER + "INTEGER" +
                        ")"
        );
    }

    public void drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public void fill(SQLiteDatabase db) {


        preparePickaxes(db, "Copper Pickaxe", R.drawable.item_copper_pickaxe, 11, 2,"White", 20 ,20);
        preparePickaxes(db, "Tin Pickaxe", R.drawable.item_tin_pickaxe, 11, 2,"White", 20 ,20);
        preparePickaxes(db, "Cactus Pickaxe", R.drawable.item_cactus_pickaxe, 11, 2,"White", 20 ,20);
        preparePickaxes(db, "Iron Pickaxe", R.drawable.item_iron_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Lead Pickaxe", R.drawable.item_lead_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Silver Pickaxe", R.drawable.item_silver_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Tungsten Pickaxe", R.drawable.item_tungsten_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Bone Pickaxe", R.drawable.item_bone_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Gold Pickaxe", R.drawable.item_gold_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Candy Cane Pickaxe", R.drawable.item_candy_cane_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Platinum Pickaxe", R.drawable.item_platinum_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Nightmare Pickaxe", R.drawable.item_nightmare_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Deathbringer Pickaxe", R.drawable.item_deathbringer_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Reaver Shark", R.drawable.item_reaver_shark, 11, "White", 20 ,20);
        preparePickaxes(db, "Molten Pickaxe", R.drawable.item_molten_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Cobalt Pickaxe", R.drawable.item_cobalt_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Palladium Pickaxe", R.drawable.item_palladium_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Mythril Pickaxe", R.drawable.item_mythril_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Orichalcum Pickaxe", R.drawable.item_orichalcum_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Adamantite Pickaxe", R.drawable.item_adamantite_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Titanium Pickaxe", R.drawable.item_titanium_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Pickaxe Axe", R.drawable.item_pickaxe_axe, 11, "White", 20 ,20);
        preparePickaxes(db, "Chlorophyte Pickaxe", R.drawable.item_chlorophyte_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Spectre Pickaxe", R.drawable.item_spectre_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Shroomite Digging Claw", R.drawable.item_shroomite_digging_claw, 11, "White", 20 ,20);
        preparePickaxes(db, "Picksaw", R.drawable.item_picksaw, 11, "White", 20 ,20);
        preparePickaxes(db, "Solar Flare Pickaxe", R.drawable.item_solar_flare_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Vortex Pickaxe", R.drawable.item_vortex_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Nebula Pickaxe", R.drawable.item_nebula_pickaxe, 11, "White", 20 ,20);
        preparePickaxes(db, "Stardust Pickaxe", R.drawable.item_stardust_pickaxe, 11, "White", 20 ,20);
    }

    private void preparePickaxes(SQLiteDatabase db, String name, int picture, int damage, int knockback, String rarity, int price, int power) {
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(PICTURE, picture);
        values.put(DAMAGE, damage);
        values.put(KNOCKBACK, knockback);
        values.put(RARITY, rarity);
        values.put(PRICE, price);
        values.put(POWER, power);
        db.insert(TABLE_NAME, null, values);
    }
        public void addPickaxes(Pickaxes pickaxes) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(NAME, pickaxes.name);
            values.put(PICTURE, pickaxes.picture);
            values.put(DAMAGE, pickaxes.damage);
            values.put(KNOCKBACK, pickaxes.knockback);
            values.put(RARITY, pickaxes.rarity);
            values.put(PRICE, pickaxes.price);
            values.put(POWER, pickaxes.power);

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
                        cursor.getInt(4),
                        cursor.getString(5),
                        cursor.getInt(6),
                        cursor.getInt(7)
                );

                pickaxe.add(pickaxes);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return pickaxe;
    }
}