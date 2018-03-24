package com.zevzikovas.aivaras.terraria.activities;
        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

        import java.util.ArrayList;
        import java.util.List;

public class DataBase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "itemsDataBase";

    private static final String NAME = "item";

    private static final String ID = "id";
    private static final String RECIPE = "pavadinimas";
    private static final String PRODUCTS = "items";


    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String lentelesAprasas =
                "CREATE TABLE " + NAME + "(" +
                        ID + " INTEGER PRIMARY KEY," +
                        RECIPE + " TEXT," +
                        PRODUCTS + " TEXT," +

                        ")";
        db.execSQL(lentelesAprasas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String lentelesTrynimoSQL = "DROP TABLE IF EXISTS " + NAME;

        // Drop older table if existed
        db.execSQL(lentelesTrynimoSQL);

        // Create tables again
        onCreate(db);
    }
    void addItems(Items items) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(RECIPE, items.items);
        values.put(PRODUCTS, items.products);


        // Inserting Row
        db.insert(NAME, null, values);
        db.close(); // Closing database connection
    }

    public List<Items> paimtiVisusItems() {
        List<Items> recipeSarasas = new ArrayList<Items>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Select All Query
        String selectQuery = "SELECT * FROM " + NAME;

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Items recipe = new Items(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );
                // Adding contact to list
                itemsSarasas.add(items);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        // return contact list
        return itemsSarasas;
    }

}