package com.example.jamie.myapp;

/**
 * Created by horseee on 2017/10/31.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBHelper extends SQLiteOpenHelper{

    public static final String PointDatabase = "Point_Info";
    public static final String PointDate = "DateID";
    public static final String PointID = "RecordID";
    public static final String PointLa = "Latitude";
    public static final String PointLo = "Longitude";
    public static final String PointSpeed = "Speed";

    public static final String DisDatabase = "Run_Dis";
    public static final String DisDate = "DateID";
    public static final String RunDis = "Distance";

    public static final String UserDatabase = "User_Info";
    public static final String UserID = "UserID";
    public static final String Password = "Password";
    public static final String Gender = "Gender";
    public static final String Age = "Age";

    public static final String TAG = "Database: ";



    public DBHelper(Context context) {
        super(context, "PointInfo", null, 1);
    }

    // onCreate function is called the first time DBHelper is created.
    // It means that if one database is created, than this function will not be called again
    // So if you want to create a new database, put it in onOpen.
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists Point_Info(" +
                "RecordID integer, " +
                "DateID varchar," +
                "Latitude double, " +
                "Longitude double, " +
                "Speed float," +
                "primary key (RecordId,DateId)" +
                ");"
        );

        db.execSQL("create table if not exists Run_Dis(" +
                "DateID varchar primary key," +
                "Distance float "+
                ");"
        );

        db.execSQL("create table if not exists User_Info(" +
                "UserID varchar primary key, " +
                "Password varchar, " +
                "Gender int, " +
                "Age int" +
                ")"
        );
    }

    // onOpen will be called when the database is open.
    // So most of the create database SQL is put in this function (Solving the problem in onCreate).
    public void onOpen(SQLiteDatabase db) {
        db.execSQL("create table if not exists Point_Info(" +
                "RecordID integer, " +
                "DateID varchar," +
                "Latitude double, " +
                "Longitude double, " +
                "Speed float," +
                "primary key (RecordId,DateId)" +
                ");"
        );

        db.execSQL("create table if not exists Run_Dis(" +
                "DateID varchar primary key," +
                "Distance float "+
                ");"
        );

        db.execSQL("create table if not exists User_Info(" +
                "UserID varchar primary key, " +
                "Password varchar, " +
                "Gender int, " +
                "Age int" +
                ")"
        );
    }

    // Get position(latitude, longitude) from the amaplocation.
    // Use ContentValues class to insert data.
    public void insertPointPosition(String DateID, int Recordptr, double la, double lo, float spe) {
        SQLiteDatabase db = getWritableDatabase();      // get the database list.
        ContentValues cv = new ContentValues();
        cv.put(PointDate, DateID);
        cv.put(PointID, Recordptr);
        cv.put(PointLa, la);
        cv.put(PointLo, lo);
        cv.put(PointSpeed, spe);
        db.insert(PointDatabase, null, cv);
    }

    //Get DateID and dis from the amaplocation.
    //DateID is the primary key for user's one running record.
    public void insertDistance(String DateID, float dis) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DisDate, DateID);
        cv.put(RunDis, dis);
        db.insert(DisDatabase, null, cv);
    }

    //Get ID , password , isMale , age FROM SignUpActivity
    public void insertUser(String ID, String key, int isMale, int age) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(UserID, ID);
        cv.put(Password, key);
        cv.put(Gender, isMale);
        cv.put(Age, age);
        db.insert(UserDatabase, null, cv);
    }


    public Cursor getAllPointCostData() {
        SQLiteDatabase db = getWritableDatabase();
        return db.query(PointDatabase, null, null, null, null, null, "RecordID ASC");
    }

    public void deleteAllData() {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(PointDatabase, null, null);
    }

    public Cursor getOnePointData(String dateID) {
        SQLiteDatabase db = getWritableDatabase();
        String selection = "DateID = ?";
        String[] selectionArgs = {dateID};
        Log.e(TAG, "Start Querying");
        return db.query(PointDatabase, null, selection, selectionArgs, null, null, "RecordID ASC");
    }

    public Cursor getDateDis(String dateID) {
        SQLiteDatabase db = getWritableDatabase();
        String selection = "DateID = ?";
        String[] selectionArgs = {dateID};
        Log.e(TAG, "Start Querying");
        return db.query(DisDatabase, null, selection, selectionArgs, null, null, null);
    }

    public boolean IsPasswordCorrext(String ID, String key) {
        SQLiteDatabase db = getWritableDatabase();
        String selection = "UserID = ?";  // "?" is important .If no "?", query will not call the selectionArgs
        String[] selectionArgs = {ID};
        //Cursor is the pointer to header of the first record that meet the condition.
        //Cursor query  (String table, String[] columns, String selection, String[] selectionArgs,String groupBy, String having, String orderBy, String limit)
        Cursor cursor = db.query(UserDatabase, null, selection, selectionArgs, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String CorrectKey = cursor.getString(cursor.getColumnIndex(Password));
                Log.e(TAG, "GETKEY = " + CorrectKey);       //Log is to show the record in the andriod monitor
                return  CorrectKey.equals(key);
            }
        }
        return false;
    }

    public void DropUserInfo() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE USER_INFO");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }
}

