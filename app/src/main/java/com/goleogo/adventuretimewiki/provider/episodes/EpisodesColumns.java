package com.goleogo.adventuretimewiki.provider.episodes;

import android.net.Uri;
import android.provider.BaseColumns;

import com.goleogo.adventuretimewiki.provider.AdvTimeProvider;
import com.goleogo.adventuretimewiki.provider.characters.CharactersColumns;
import com.goleogo.adventuretimewiki.provider.episodes.EpisodesColumns;

/**
 * A human being which is part of a team.
 */
public class EpisodesColumns implements BaseColumns {
    public static final String TABLE_NAME = "episodes";
    public static final Uri CONTENT_URI = Uri.parse(AdvTimeProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Episode title
     */
    public static final String TITLE = "title";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            TITLE
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(TITLE) || c.contains("." + TITLE)) return true;
        }
        return false;
    }

}
