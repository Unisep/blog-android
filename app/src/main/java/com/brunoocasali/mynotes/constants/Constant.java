package com.brunoocasali.mynotes.constants;

/**
 * Created by bruno on 02/05/15.
 */
public class Constant {
    // Databases
    public static final String DATABASE_NAME = "my_notes_production";

    // Tables
    public static final String TABLE_NOTEBOOKS = "notebooks";
    public static final String TABLE_NOTES = "notes";

    // Columns from NOTEBOOKS and NOTES
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_ON_UPDATE = "on_update";
    public static final String COLUMN_ON_CREATE = "on_create";
    public static final String COLUMN_NOTEBOOK_ID = "id_notebook";

    // Version
    public static final int DATABASE_CURRENT_VERSION = 1;
}
