package com.goleogo.adventuretimewiki.provider.characters;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.goleogo.adventuretimewiki.provider.base.AbstractSelection;

/**
 * Selection for the {@code characters} table.
 */
public class CharactersSelection extends AbstractSelection<CharactersSelection> {
    @Override
    protected Uri baseUri() {
        return CharactersColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code CharactersCursor} object, which is positioned before the first entry, or null.
     */
    public CharactersCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new CharactersCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public CharactersCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code CharactersCursor} object, which is positioned before the first entry, or null.
     */
    public CharactersCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new CharactersCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public CharactersCursor query(Context context) {
        return query(context, null);
    }


    public CharactersSelection id(long... value) {
        addEquals("characters." + CharactersColumns._ID, toObjectArray(value));
        return this;
    }

    public CharactersSelection idNot(long... value) {
        addNotEquals("characters." + CharactersColumns._ID, toObjectArray(value));
        return this;
    }

    public CharactersSelection orderById(boolean desc) {
        orderBy("characters." + CharactersColumns._ID, desc);
        return this;
    }

    public CharactersSelection orderById() {
        return orderById(false);
    }

    public CharactersSelection fullName(String... value) {
        addEquals(CharactersColumns.FULL_NAME, value);
        return this;
    }

    public CharactersSelection fullNameNot(String... value) {
        addNotEquals(CharactersColumns.FULL_NAME, value);
        return this;
    }

    public CharactersSelection fullNameLike(String... value) {
        addLike(CharactersColumns.FULL_NAME, value);
        return this;
    }

    public CharactersSelection fullNameContains(String... value) {
        addContains(CharactersColumns.FULL_NAME, value);
        return this;
    }

    public CharactersSelection fullNameStartsWith(String... value) {
        addStartsWith(CharactersColumns.FULL_NAME, value);
        return this;
    }

    public CharactersSelection fullNameEndsWith(String... value) {
        addEndsWith(CharactersColumns.FULL_NAME, value);
        return this;
    }

    public CharactersSelection orderByFullName(boolean desc) {
        orderBy(CharactersColumns.FULL_NAME, desc);
        return this;
    }

    public CharactersSelection orderByFullName() {
        orderBy(CharactersColumns.FULL_NAME, false);
        return this;
    }

    public CharactersSelection sex(String... value) {
        addEquals(CharactersColumns.SEX, value);
        return this;
    }

    public CharactersSelection sexNot(String... value) {
        addNotEquals(CharactersColumns.SEX, value);
        return this;
    }

    public CharactersSelection sexLike(String... value) {
        addLike(CharactersColumns.SEX, value);
        return this;
    }

    public CharactersSelection sexContains(String... value) {
        addContains(CharactersColumns.SEX, value);
        return this;
    }

    public CharactersSelection sexStartsWith(String... value) {
        addStartsWith(CharactersColumns.SEX, value);
        return this;
    }

    public CharactersSelection sexEndsWith(String... value) {
        addEndsWith(CharactersColumns.SEX, value);
        return this;
    }

    public CharactersSelection orderBySex(boolean desc) {
        orderBy(CharactersColumns.SEX, desc);
        return this;
    }

    public CharactersSelection orderBySex() {
        orderBy(CharactersColumns.SEX, false);
        return this;
    }

    public CharactersSelection image(String... value) {
        addEquals(CharactersColumns.IMAGE, value);
        return this;
    }

    public CharactersSelection imageNot(String... value) {
        addNotEquals(CharactersColumns.IMAGE, value);
        return this;
    }

    public CharactersSelection imageLike(String... value) {
        addLike(CharactersColumns.IMAGE, value);
        return this;
    }

    public CharactersSelection imageContains(String... value) {
        addContains(CharactersColumns.IMAGE, value);
        return this;
    }

    public CharactersSelection imageStartsWith(String... value) {
        addStartsWith(CharactersColumns.IMAGE, value);
        return this;
    }

    public CharactersSelection imageEndsWith(String... value) {
        addEndsWith(CharactersColumns.IMAGE, value);
        return this;
    }

    public CharactersSelection orderByImage(boolean desc) {
        orderBy(CharactersColumns.IMAGE, desc);
        return this;
    }

    public CharactersSelection orderByImage() {
        orderBy(CharactersColumns.IMAGE, false);
        return this;
    }
}
