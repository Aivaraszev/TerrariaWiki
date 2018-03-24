package com.zevzikovas.aivaras.terraria.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zevzikovas.aivaras.terraria.R;
import com.zevzikovas.aivaras.terraria.models.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemsRepository extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "terraria_wiki_db";

    private static final String TABLE_NAME = "items";

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PICTURE = "picture";
    private static final String DAMAGE = "damage";
    private static final String RARITY = "rarity";
    private static final String PRICE = "price";


    public ItemsRepository(Context context) {
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

        prepareItem(db, "Copper Short Sword", R.drawable.item_copper_shortsword, 15, "Green", 22);
        prepareItem(db, "Tin Short Sword", R.drawable.item_tin_shortsword, 15, "Green", 22);
        prepareItem(db, "Wooden Sword", R.drawable.item_wooden_sword, 15, "Green", 22);
        prepareItem(db, "Boreal Wood Sword", R.drawable.item_copper_broadsword, 15, "Green", 22);
        prepareItem(db, "Iron Short Sword", R.drawable.item_iron_shortsword, 15, "Green", 22);
        prepareItem(db, "Palm Wood Sword", R.drawable.item_palm_wood_sword, 15, "Green", 22);
        prepareItem(db, "Rich Mahogany Sword", R.drawable.item_rich_mahogany_sword, 15, "Green", 22);
        prepareItem(db, "Cactus Sword", R.drawable.item_cactus_sword, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_lead_shortsword, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_silver_shortsword, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_tin_broadsword, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_ebonwood_sword, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_iron_broadsword, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_shadewood_sword, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_tungsten_shortsword, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_gold_short_sword, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_lead_broadsword, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
        prepareItem(db, "Bee Keeper", R.drawable.item_bee_keeper, 15, "Green", 22);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private void prepareItem(SQLiteDatabase db, String name, int picture, int damage, String rarity, int price) {
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(PICTURE, picture);
        values.put(DAMAGE, damage);
        values.put(RARITY, rarity);
        values.put(PRICE, price);
        db.insert(TABLE_NAME, null, values);
    }

    public void addItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, item.name);
        values.put(PICTURE, item.picture);
        values.put(DAMAGE, item.damage);
        values.put(RARITY, item.rarity);
        values.put(PRICE, item.price);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Item item = new Item(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        cursor.getString(4),
                        cursor.getInt(5)
                );

                items.add(item);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return items;
    }
}