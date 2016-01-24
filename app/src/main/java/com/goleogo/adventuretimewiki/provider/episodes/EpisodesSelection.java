package com.goleogo.adventuretimewiki.provider.episodes;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.goleogo.adventuretimewiki.provider.base.AbstractSelection;

/**
 * Selection for the {@code episodes} table.
 */
public class EpisodesSelection extends AbstractSelection<EpisodesSelection> {
    @Override
    protected Uri baseUri() {
        return EpisodesColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code EpisodesCursor} object, which is positioned before the first entry, or null.
     */
    public EpisodesCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new EpisodesCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public EpisodesCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code EpisodesCursor} object, which is positioned before the first entry, or null.
     */
    public EpisodesCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new EpisodesCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public EpisodesCursor query(Context context) {
        return query(context, null);
    }


    public EpisodesSelection id(long... value) {
        addEquals("episodes." + EpisodesColumns._ID, toObjectArray(value));
        return this;
    }

    public EpisodesSelection idNot(long... value) {
        addNotEquals("episodes." + EpisodesColumns._ID, toObjectArray(value));
        return this;
    }

    public EpisodesSelection orderById(boolean desc) {
        orderBy("episodes." + EpisodesColumns._ID, desc);
        return this;
    }

    public EpisodesSelection orderById() {
        return orderById(false);
    }

    public EpisodesSelection title(String... value) {
        addEquals(EpisodesColumns.TITLE, value);
        return this;
    }

    public EpisodesSelection titleNot(String... value) {
        addNotEquals(EpisodesColumns.TITLE, value);
        return this;
    }

    public EpisodesSelection titleLike(String... value) {
        addLike(EpisodesColumns.TITLE, value);
        return this;
    }

    public EpisodesSelection titleContains(String... value) {
        addContains(EpisodesColumns.TITLE, value);
        return this;
    }

    public EpisodesSelection titleStartsWith(String... value) {
        addStartsWith(EpisodesColumns.TITLE, value);
        return this;
    }

    public EpisodesSelection titleEndsWith(String... value) {
        addEndsWith(EpisodesColumns.TITLE, value);
        return this;
    }

    public EpisodesSelection orderByTitle(boolean desc) {
        orderBy(EpisodesColumns.TITLE, desc);
        return this;
    }

    public EpisodesSelection orderByTitle() {
        orderBy(EpisodesColumns.TITLE, false);
        return this;
    }
}
