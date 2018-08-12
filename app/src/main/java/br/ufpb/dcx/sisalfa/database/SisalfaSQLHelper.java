package br.ufpb.dcx.sisalfa.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SisalfaSQLHelper extends SQLiteOpenHelper {

    public SisalfaSQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Name and version of the database
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "dbLiterarum";

    // Table names
    public static final String CONTEXT_TABLE = "context_table";
    public static final String CHALLENGE_TABLE = "challenge_table";
    public static final String USER_TABLE = "user_table";
    public static final String SELECTED_CONTEXT_TABLE = "selected_context";

    // Common column names between all
    public static final String COLUMN_PKEY_ID = "pkey_id";

    // Common columns of the challenge and context
    public static final String COLUMN_WORD = "word";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_SOUND = "sound";
    public static final String COLUMN_VIDEO = "video";

    // SisContext specific column
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CREATEDAT = "createdat";
    public static final String COLUMN_UPDATEDAT = "updatedat";

    // User columns
    public static final String COLUMN_USERNAME = "user_name";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_FIRST_NAME = "first_name";
    public static final String COLUMN_LAST_NAME = "last_name";
    public static final String COLUMN_PHOTO = "photo";

    // Fkeys
    public static final String COLUMN_USER_FKEY = "user_fkey";
    public static final String COLUMN_CONTEXT_FKEY = "context_fkey";

    public static final String COLUMN_FIRST_CTX = "first";
    public static final String COLUMN_SECOND_CTX = "second";
    public static final String COLUMN_THIRD_CTX = "third";
    public static final String COLUMN_FOURTH_CTX = "fourth";
    public static final String COLUMN_FIFTH_CTX = "fifth";
    public static final String COLUMN_SIXTH_CTX = "sixth";
    public static final String COLUMN__COUNT = "count";





    private static final String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS "+ USER_TABLE +" (" +
            COLUMN_PKEY_ID +" INTEGER PRIMARY KEY, " +
            COLUMN_USERNAME + " TEXT NOT NULL UNIQUE, " +
            COLUMN_PASSWORD +" TEXT NOT NULL, "+
            COLUMN_EMAIL + " TEXT NOT NULL UNIQUE, " +
            COLUMN_FIRST_NAME + " TEXT NOT NULL, " +
            COLUMN_LAST_NAME +" TEXT, " +
            COLUMN_PHOTO + " TEXT)";

    private static final String CREATE_CONTEXT_TABLE = "CREATE TABLE IF NOT EXISTS "+ CONTEXT_TABLE +" (" +
            COLUMN_PKEY_ID +" INTEGER, " +
            COLUMN_NAME + " TEXT NOT NULL, " +
            COLUMN_IMAGE +" BLOB NOT NULL, "+
            COLUMN_SOUND + " TEXT, " +
            COLUMN_VIDEO + " TEXT, " +
            COLUMN_CREATEDAT + " TEXT, " +
            COLUMN_UPDATEDAT + " TEXT, " +
            COLUMN_USER_FKEY + " INTEGER NOT NULL)";


    private static final String CREATE_SELECTED_CONTEXT_TABLE = "CREATE TABLE IF NOT EXISTS "+ SELECTED_CONTEXT_TABLE +" (" +
            COLUMN_PKEY_ID +" INTEGER, " +
            COLUMN__COUNT + " INTEGER, " +
            COLUMN_FIRST_CTX + " INTEGER, " +
            COLUMN_SECOND_CTX +" INTEGER, "+
            COLUMN_THIRD_CTX + " INTEGER, " +
            COLUMN_FOURTH_CTX + " INTEGER, " +
            COLUMN_FIFTH_CTX + " INTEGER, " +
            COLUMN_SIXTH_CTX + " INTEGER)";

    private static final String CREATE_CHALLENGE_TABLE = "CREATE TABLE IF NOT EXISTS "+ CHALLENGE_TABLE +" (" +
            COLUMN_PKEY_ID +" INTEGER, " +
            COLUMN_WORD + " TEXT NOT NULL, " +
            COLUMN_IMAGE +" BLOB NOT NULL, "+
            COLUMN_SOUND + " TEXT, " +
            COLUMN_VIDEO + " TEXT, " +
            COLUMN_CONTEXT_FKEY + " INTEGER NOT NULL, " +
            COLUMN_CREATEDAT + " TEXT, " +
            COLUMN_UPDATEDAT + " TEXT, " +
            COLUMN_USER_FKEY + " INTEGER NOT NULL)";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
        sqLiteDatabase.execSQL(CREATE_CONTEXT_TABLE);
        sqLiteDatabase.execSQL(CREATE_CHALLENGE_TABLE);
        sqLiteDatabase.execSQL(CREATE_SELECTED_CONTEXT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CONTEXT_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CHALLENGE_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SELECTED_CONTEXT_TABLE);
        onCreate(sqLiteDatabase);
    }
}
