package ch.avirtualfriend.myspots.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ch.avirtualfriend.myspots.models.Spot;

public class SpotDatabaseHelper extends SQLiteOpenHelper {

    /*private static final String CREATE_CMD =
            "CREATE TABLE Spots ("
            +"id" + "INTEGER PRIMARY KEY AUTOINCREMENT,"
            +"name" + "TEXT,"
            +"longitude" + "REAL,"
            +"latitude" + "REAL,"
            +"inputeDate" + "TEXT,"
            +"comment" + "TEXT)";*/
    public static final String TABLE_NAME = "SPOTS";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_LONGITUDE = "LONGITUDE";
    public static final String COLUMN_LATITUDE = "LATITUDE";
    public static final String COLUMN_INPUTDATE = "INPUTDATE";
    public static final String COLUMN_COMMENT = "COMMENT";

    private static final int DATABASE_VERSION = 1;
    private static final String DB_NAME = "MYSPOTS.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE "+ TABLE_NAME +" (" +
                    COLUMN_ID + "INTEGER PRIMARY KEY," +
                    COLUMN_NAME + "TEXT," +
                    COLUMN_LONGITUDE + "REAL," +
                    COLUMN_LATITUDE + "REAL," +
                    COLUMN_INPUTDATE + "TEXT," +
                    COLUMN_COMMENT + "TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public SpotDatabaseHelper(Context context) {
        super(context, "DB_NAME", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
