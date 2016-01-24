package com.goleogo.adventuretimewiki.provider.characters;

import android.net.Uri;
import android.provider.BaseColumns;

import com.goleogo.adventuretimewiki.provider.AdvTimeProvider;

/**
 * Characters.
 */
public class CharactersColumns implements BaseColumns {
    public static final String TABLE_NAME = "characters";
    public static final Uri CONTENT_URI = Uri.parse(AdvTimeProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Full name
     */
    public static final String FULL_NAME = "full_name";

    /**
     * Sex
     */
    public static final String SEX = "sex";

    /**
     * Image
     */
    public static final String IMAGE = "image";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            FULL_NAME,
            SEX,
            IMAGE
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(FULL_NAME) || c.contains("." + FULL_NAME)) return true;
            if (c.equals(SEX) || c.contains("." + SEX)) return true;
            if (c.equals(IMAGE) || c.contains("." + IMAGE)) return true;
        }
        return false;
    }

}
