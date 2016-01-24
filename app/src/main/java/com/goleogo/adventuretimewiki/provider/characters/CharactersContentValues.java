package com.goleogo.adventuretimewiki.provider.characters;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.goleogo.adventuretimewiki.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code characters} table.
 */
public class CharactersContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return CharactersColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable CharactersSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable CharactersSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Full name
     */
    public CharactersContentValues putFullName(@Nullable String value) {
        mContentValues.put(CharactersColumns.FULL_NAME, value);
        return this;
    }

    public CharactersContentValues putFullNameNull() {
        mContentValues.putNull(CharactersColumns.FULL_NAME);
        return this;
    }

    /**
     * Sex
     */
    public CharactersContentValues putSex(@Nullable String value) {
        mContentValues.put(CharactersColumns.SEX, value);
        return this;
    }

    public CharactersContentValues putSexNull() {
        mContentValues.putNull(CharactersColumns.SEX);
        return this;
    }

    /**
     * Image
     */
    public CharactersContentValues putImage(@Nullable String value) {
        mContentValues.put(CharactersColumns.IMAGE, value);
        return this;
    }

    public CharactersContentValues putImageNull() {
        mContentValues.putNull(CharactersColumns.IMAGE);
        return this;
    }
}
