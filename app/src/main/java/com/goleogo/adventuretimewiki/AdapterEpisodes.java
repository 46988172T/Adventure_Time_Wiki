package com.goleogo.adventuretimewiki;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.goleogo.adventuretimewiki.provider.episodes.EpisodesCursor;
import com.squareup.picasso.Picasso;

/**
 * Created by leosss on 24/01/16.
 */

public class AdapterEpisodes extends SimpleCursorAdapter {

    TextView nameEpisode;
    TextView airdateEpisode;
    ImageView titlecardEpisode;
    TextView descriptionEpisode;
    Context context;

    public AdapterEpisodes(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Cursor cursor = getCursor();
        EpisodesCursor episodesCursor = new EpisodesCursor(cursor);
        episodesCursor.moveToPosition(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_episode, parent, false);
        }

        //int id = character.getId();
        nameEpisode = (TextView) convertView.findViewById(R.id.name);
        titlecardEpisode = (ImageView)convertView.findViewById(R.id.img);


        nameEpisode.setText(episodesCursor.getTitle());

        if(episodesCursor.getTitleCard() == null || episodesCursor.getTitleCard() == "" ){
            //pendiente imagen 'no image'
        }else {
            Picasso.with(context)
                    .load(episodesCursor.getTitleCard())
                    .fit()
                    .into(titlecardEpisode);
        }
        return convertView;

    }

}
