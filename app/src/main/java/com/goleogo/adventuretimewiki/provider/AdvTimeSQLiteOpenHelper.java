package com.goleogo.adventuretimewiki.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.goleogo.adventuretimewiki.BuildConfig;
import com.goleogo.adventuretimewiki.provider.characters.CharactersColumns;
import com.goleogo.adventuretimewiki.provider.episodes.EpisodesColumns;

public class AdvTimeSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = AdvTimeSQLiteOpenHelper.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "advtimewiki.db";
    private static final int DATABASE_VERSION = 1;
    private static AdvTimeSQLiteOpenHelper sInstance;
    private final Context mContext;
    private final AdvTimeSQLiteOpenHelperCallbacks mOpenHelperCallbacks;

    // @formatter:off
    public static final String SQL_CREATE_TABLE_CHARACTERS = "CREATE TABLE IF NOT EXISTS "
            + CharactersColumns.TABLE_NAME + " ( "
            + CharactersColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CharactersColumns.FULL_NAME + " TEXT, "
            + CharactersColumns.SEX + " TEXT, "
            + CharactersColumns.IMAGE + " TEXT "
            + " );";

    public static final String SQL_CREATE_TABLE_EPISODES = "CREATE TABLE IF NOT EXISTS "
            + EpisodesColumns.TABLE_NAME + " ( "
            + EpisodesColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + EpisodesColumns.TITLE + " TEXT "
            + " );";

    // @formatter:on

    public static AdvTimeSQLiteOpenHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static AdvTimeSQLiteOpenHelper newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */
    private static AdvTimeSQLiteOpenHelper newInstancePreHoneycomb(Context context) {
        return new AdvTimeSQLiteOpenHelper(context);
    }

    private AdvTimeSQLiteOpenHelper(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
        mContext = context;
        mOpenHelperCallbacks = new AdvTimeSQLiteOpenHelperCallbacks();
    }


    /*
     * Post Honeycomb.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static AdvTimeSQLiteOpenHelper newInstancePostHoneycomb(Context context) {
        return new AdvTimeSQLiteOpenHelper(context, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private AdvTimeSQLiteOpenHelper(Context context, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new AdvTimeSQLiteOpenHelperCallbacks();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_CHARACTERS);
        db.execSQL(SQL_CREATE_TABLE_EPISODES);
        mOpenHelperCallbacks.onPostCreate(mContext, db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            setForeignKeyConstraintsEnabled(db);
        }
        mOpenHelperCallbacks.onOpen(mContext, db);
    }

    private void setForeignKeyConstraintsEnabled(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            setForeignKeyConstraintsEnabledPreJellyBean(db);
        } else {
            setForeignKeyConstraintsEnabledPostJellyBean(db);
        }
    }

    private void setForeignKeyConstraintsEnabledPreJellyBean(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setForeignKeyConstraintsEnabledPostJellyBean(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mOpenHelperCallbacks.onUpgrade(mContext, db, oldVersion, newVersion);
    }
}
