package com.zevzikovas.aivaras.terraria.repositories;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RepositoryManager extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 8;

    private static final String DATABASE_NAME = "terraria_wiki_db";

    public SwordsRepository swordsRepository = new SwordsRepository(this);
    public HSwordsRepository hSwordsRepository = new HSwordsRepository(this);
    public PickaxesRepository pickaxesRepository = new PickaxesRepository(this);
    public PickaxesRepository YoyosRepository = new PickaxesRepository(this);

    public RepositoryManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        swordsRepository.create(db);
        hSwordsRepository.create(db);
        pickaxesRepository.create(db);
        YoyosRepository.create(db);

        swordsRepository.fill(db);
        hSwordsRepository.fill(db);
        pickaxesRepository.fill(db);
        YoyosRepository.fill(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        swordsRepository.drop(db);
        hSwordsRepository.drop(db);
        pickaxesRepository.drop(db);
        YoyosRepository.drop(db);

        onCreate(db);
    }
}
