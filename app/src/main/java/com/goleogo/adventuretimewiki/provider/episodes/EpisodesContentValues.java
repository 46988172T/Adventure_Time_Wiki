package com.goleogo.adventuretimewiki.provider.episodes;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.goleogo.adventuretimewiki.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code episodes} table.
 */
public class EpisodesContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return EpisodesColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable EpisodesSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable EpisodesSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Episode title
     */
    public EpisodesContentValues putTitle(@Nullable String value) {
        mContentValues.put(EpisodesColumns.TITLE, value);
        return this;
    }

    public EpisodesContentValues putTitleNull() {
        mContentValues.putNull(EpisodesColumns.TITLE);
        return this;
    }

    /**
     * Episode description
     */
    public EpisodesContentValues putDescription(@Nullable String value) {
        mContentValues.put(EpisodesColumns.DESCRIPTION, value);
        return this;
    }

    public EpisodesContentValues putDescriptionNull() {
        mContentValues.putNull(EpisodesColumns.DESCRIPTION);
        return this;
    }
    /**
     * Episode air_date
     */
    public EpisodesContentValues putAirDate(@Nullable String value) {
        mContentValues.put(EpisodesColumns.AIR_DATE, value);
        return this;
    }

    public EpisodesContentValues putAirDateNull() {
        mContentValues.putNull(EpisodesColumns.AIR_DATE);
        return this;
    }
    /**
     * Episode title_card
     */
    public EpisodesContentValues putTitleCard(@Nullable String value) {
        mContentValues.put(EpisodesColumns.TITLE_CARD, value);
        return this;
    }

    public EpisodesContentValues putTitleCardNull() {
        mContentValues.putNull(EpisodesColumns.TITLE_CARD);
        return this;
    }
}
