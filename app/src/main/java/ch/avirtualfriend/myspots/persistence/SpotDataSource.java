package ch.avirtualfriend.myspots.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import ch.avirtualfriend.myspots.models.Spot;

public class SpotDataSource {

    private SQLiteDatabase db;
    private SpotDatabaseHelper dbHelper;

    public SpotDataSource(Context context) {

        this.dbHelper = new SpotDatabaseHelper(context);
    }

    public long insertSpot(Spot spot){
        // db = this.getContext();
        //get data repository in write mode
        db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(SpotDataBaseContract.SpotEntry.COLUMN_ID, spot.getId());
        values.put(SpotDatabaseHelper.COLUMN_NAME, "name");
        values.put(SpotDatabaseHelper.COLUMN_COMMENT, "comm");
        values.put(SpotDatabaseHelper.COLUMN_LATITUDE, 1.256);
        values.put(SpotDatabaseHelper.COLUMN_LONGITUDE, 1.259);
        values.put(SpotDatabaseHelper.COLUMN_INPUTDATE, "date*");

        long newRowId = db.insert(SpotDatabaseHelper.TABLE_NAME, null, values);

        db.close();

        return newRowId;
    }
}
