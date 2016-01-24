package com.goleogo.adventuretimewiki.provider.episodes;

import android.support.annotation.Nullable;

import com.goleogo.adventuretimewiki.provider.base.BaseModel;

/**
 * A human being which is part of a team.
 */
public interface EpisodesModel extends BaseModel {

    /**
     * Episode title
     * Can be {@code null}.
     */
    @Nullable
    String getTitle();

    /**
     * Episode description
     * Can be {@code null}.
     */
    @Nullable
    String getDescription();

    /**
     * Episode air_date
     * Can be {@code null}.
     */
    @Nullable
    String getAirDate();

    /**
     * Episode title_card
     * Can be {@code null}.
     */
    @Nullable
    String getTitleCard();
}


