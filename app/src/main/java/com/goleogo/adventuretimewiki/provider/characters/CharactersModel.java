package com.goleogo.adventuretimewiki.provider.characters;

import com.goleogo.adventuretimewiki.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * A human being which is part of a team.
 */
public interface CharactersModel extends BaseModel {

    /**
     * Full name
     * Can be {@code null}.
     */
    @Nullable
    String getFullName();

    /**
     * Sex
     * Can be {@code null}.
     */
    @Nullable
    String getSex();

    /**
     * Image
     * Can be {@code null}.
     */
    @Nullable
    String getImage();
}
