package com.goleogo.adventuretimewiki.provider.episodes;

import android.net.Uri;
import android.provider.BaseColumns;

import com.goleogo.adventuretimewiki.provider.AdvTimeProvider;

/**
 * Episodes.
 */
public class EpisodesColumns implements BaseColumns {
    public static final String TABLE_NAME = "episodes";
    public static final Uri CONTENT_URI = Uri.parse(AdvTimeProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Episode title_Card
     */
    public static final String TITLE_CARD = "title_card";

    /**
     * Episode description
     */
    public static final String DESCRIPTION = "description";

    /**
     * Episode title
     */
    public static final String TITLE = "title";

    /**
     * Episode air_date
     */
    public static final String AIR_DATE = "air_date";




    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            TITLE_CARD,
            DESCRIPTION,
            TITLE,
            AIR_DATE,
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(TITLE_CARD) || c.contains("." + TITLE_CARD)) return true;
            if (c.equals(DESCRIPTION) || c.contains("." + DESCRIPTION)) return true;
            if (c.equals(TITLE) || c.contains("." + TITLE)) return true;
            if (c.equals(AIR_DATE) || c.contains("." + AIR_DATE)) return true;
        }
        return false;
    }

}
