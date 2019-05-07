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
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(SpotDataBaseContract.SpotEntry.COLUMN_ID, spot.getId());
        values.put(SpotDatabaseHelper.COLUMN_NAME, spot.getName());
        values.put(SpotDatabaseHelper.COLUMN_COMMENT, spot.getComments());
        values.put(SpotDatabaseHelper.COLUMN_LATITUDE, spot.getLatitude());
        values.put(SpotDatabaseHelper.COLUMN_LONGITUDE, spot.getLongitude());
        //values.put(SpotDatabaseHelper.COLUMN_INPUTDATE, spot.getInputDate().toString());

        long newRowId = db.insert(SpotDatabaseHelper.TABLE_NAME, null, values);

        db.close();

        return newRowId;
    }
}
