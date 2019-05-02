package ch.avirtualfriend.myspots.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SpotDatabaseHelper extends SQLiteOpenHelper {

    private static final String CREATE_CMD =
            "CREATE TABLE Spots ("
            +"id" + "INTEGER PRIMARY KEY AUTOINCREMENT,"
            +"name" + "TEXT,"
            +"longitude" + "REAL,"
            +"latitude" + "REAL,"
            +"inputeDate" + "TEXT,"
            +"comment" + "TEXT)";


    public SpotDatabaseHelper(Context context) {
        super(context, "SpotDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CMD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
