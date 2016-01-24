package com.goleogo.adventuretimewiki;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;


import com.goleogo.adventuretimewiki.provider.episodes.EpisodesColumns;
import com.goleogo.adventuretimewiki.provider.episodes.EpisodesCursor;
import com.squareup.picasso.Picasso;

/**
 * Created by leosss on 24/01/16.
 */
public class EpisodeDetail extends AppCompatActivity{
    TextView nameEpisode;
    ImageView image;
    TextView description;
    TextView air_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent i = getIntent();
        Long episode_id = i.getLongExtra("episode_id", -1);

        Cursor cursor = this.getContentResolver().query(
                EpisodesColumns.CONTENT_URI,
                null,
                EpisodesColumns._ID + " = ?",
                new String[]{String.valueOf(episode_id)},
                null);

        EpisodesCursor episodesCursor = new EpisodesCursor(cursor);
        cursor.moveToNext();

        nameEpisode = (TextView)findViewById(R.id.tvNameDetailE);
        image = (ImageView)findViewById(R.id.imgDetailE);
        description = (TextView)findViewById(R.id.tvDescriptionFill);
        air_date = (TextView)findViewById(R.id.tvAirDateFill);

        nameEpisode.setText(episodesCursor.getTitle());
        Picasso.with(getBaseContext())
                .load(episodesCursor.getTitleCard())
                .fit()
                .into(image);
        description.setText(episodesCursor.getDescription());
        air_date.setText(episodesCursor.getAirDate());

    }
}
