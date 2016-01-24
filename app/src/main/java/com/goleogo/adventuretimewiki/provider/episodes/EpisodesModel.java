package com.goleogo.adventuretimewiki.provider.episodes;

import com.goleogo.adventuretimewiki.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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
}
