package com.brunoocasali.mynotes.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.brunoocasali.mynotes.constants.Constant;

/**
 * Created by bruno on 02/05/15.
 */
public class OpenHelper extends SQLiteOpenHelper {

    public OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                      int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createNotebooksTable(db);
        createNoteTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2) {

    }

    private void createNotebooksTable(SQLiteDatabase db){
        String sql = "CREATE TABLE " + Constant.TABLE_NOTEBOOKS + "(" +
                Constant.COLUMN_ID + " INTEGER PRIMARY KEY, " +
                Constant.COLUMN_TITLE + " TEXT NOT NULL, " +
                Constant.COLUMN_DESCRIPTION + " TEXT, " +
                Constant.COLUMN_ON_UPDATE + " on_update INTEGER, " +
                Constant.COLUMN_ON_CREATE + " on_create INTEGER)";

        db.execSQL(sql);
    }

    private void createNoteTable(SQLiteDatabase db){
        String sql = "CREATE TABLE " + Constant.TABLE_NOTES + "(" +
                Constant.COLUMN_ID + " INTEGER PRIMARY KEY, " +
                Constant.COLUMN_TITLE + " TEXT NOT NULL, " +
                Constant.COLUMN_TEXT + " TEXT, " +
                Constant.COLUMN_ON_UPDATE + " on_update INTEGER, " +
                Constant.COLUMN_ON_CREATE + " on_create INTEGER)" +
                Constant.COLUMN_NOTEBOOK_ID + " REFERENCES notebooks(id))";

        db.execSQL(sql);
    }
}
