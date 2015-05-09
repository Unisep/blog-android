package com.brunoocasali.mynotes.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.brunoocasali.mynotes.constants.Constant;
import com.brunoocasali.mynotes.helper.OpenHelper;
import com.brunoocasali.mynotes.vo.NoteVO;
import com.brunoocasali.mynotes.vo.NotebookVO;

import java.util.Date;

/**
 * Created by bruno on 09/05/15.
 */
public class NoteDAO {
    private OpenHelper helper;

    public NoteDAO(Context context){
        this.helper = new OpenHelper(context, Constant.DATABASE_NAME, null,
                Constant.DATABASE_CURRENT_VERSION);
    }

    public void save(NoteVO note){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Constant.COLUMN_TITLE, note.getTitle());
        values.put(Constant.COLUMN_ON_CREATE, new Date().getTime());
        values.put(Constant.COLUMN_ON_UPDATE, (Integer) null);
        values.put(Constant.COLUMN_DESCRIPTION, note.getDescription());
        values.put(Constant.COLUMN_NOTEBOOK_ID, note.getNotebook().getId());

        db.insert(Constant.TABLE_NOTES, null, values);
        db.close();
    }

    public Cursor list(){
        SQLiteDatabase db = helper.getReadableDatabase();

        String[] columns = {
                Constant.COLUMN_ID,
                Constant.COLUMN_TITLE,
                Constant.COLUMN_ON_CREATE,
                Constant.COLUMN_ON_UPDATE,
                Constant.COLUMN_DESCRIPTION
        };

        return db.query(Constant.TABLE_NOTES, columns, null, null, null, null, Constant.COLUMN_ON_CREATE);
    }

    public void destroy(long id){
        SQLiteDatabase db = helper.getWritableDatabase();

        String[] condition = { String.valueOf(id) };

        db.delete(Constant.TABLE_NOTES, "_id = ?", condition);
        db.close();
    }

    public void update(NoteVO note){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Constant.COLUMN_TITLE, note.getTitle());
        values.put(Constant.COLUMN_ON_UPDATE, new Date().getTime());
        values.put(Constant.COLUMN_DESCRIPTION, note.getDescription());
        values.put(Constant.COLUMN_NOTEBOOK_ID, note.getNotebook().getId());

        String[] condition = { String.valueOf(note.getId()) };

        db.update(Constant.TABLE_NOTES, values, "_id = ?", condition);
        db.close();
    }

    public NoteVO select(Integer id){
        SQLiteDatabase db = helper.getReadableDatabase();

        String[] columns = {
                Constant.COLUMN_ID,
                Constant.COLUMN_TITLE,
                Constant.COLUMN_ON_CREATE,
                Constant.COLUMN_ON_UPDATE,
                Constant.COLUMN_DESCRIPTION,
                Constant.COLUMN_NOTEBOOK_ID
        };

        String[] condition = { String.valueOf(id) };

        Cursor cursor = db.query(Constant.TABLE_NOTES, columns, "_id = ?", condition,
                null, null, Constant.COLUMN_ON_CREATE);

        NoteVO note = new NoteVO();

        if (cursor.moveToFirst()){
            note.setId(cursor.getInt(cursor.getColumnIndex(Constant.COLUMN_ID)));
            note.setTitle(cursor.getString(cursor.getColumnIndex(Constant.COLUMN_TITLE)));
            note.setOnCreate(new Date(cursor.getInt(cursor.getColumnIndex(Constant.COLUMN_ON_CREATE))));
            note.setOnUpdate(new Date(cursor.getInt(cursor.getColumnIndex(Constant.COLUMN_ON_UPDATE))));
            note.setDescription(cursor.getString(cursor.getColumnIndex(Constant.COLUMN_DESCRIPTION)));

            NotebookVO notebook = new NotebookVO();
            notebook.setId(cursor.getInt(cursor.getColumnIndex(Constant.COLUMN_DESCRIPTION)));
            note.setNotebook(notebook);
        }

        db.close();
        return note;
    }
}
