package com.goleogo.adventuretimewiki.provider.characters;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.goleogo.adventuretimewiki.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code characters} table.
 */
public class CharactersCursor extends AbstractCursor implements CharactersModel {
    public CharactersCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(CharactersColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Full name
     * Can be {@code null}.
     */
    @Nullable
    public String getFullName() {
        String res = getStringOrNull(CharactersColumns.FULL_NAME);
        return res;
    }

    /**
     * Sex
     * Can be {@code null}.
     */
    @Nullable
    public String getSex() {
        String res = getStringOrNull(CharactersColumns.SEX);
        return res;
    }

    /**
     * Image
     * Can be {@code null}.
     */
    @Nullable
    public String getImage() {
        String res = getStringOrNull(CharactersColumns.IMAGE);
        return res;
    }
}
