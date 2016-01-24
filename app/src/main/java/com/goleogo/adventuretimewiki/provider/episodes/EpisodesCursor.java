package com.goleogo.adventuretimewiki.provider.episodes;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.goleogo.adventuretimewiki.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code episodes} table.
 */
public class EpisodesCursor extends AbstractCursor implements EpisodesModel {
    public EpisodesCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(EpisodesColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Episode title
     * Can be {@code null}.
     */
    @Nullable
    public String getTitle() {
        String res = getStringOrNull(EpisodesColumns.TITLE);
        return res;
    }
}
