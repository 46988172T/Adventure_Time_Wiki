package com.goleogo.adventuretimewiki;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.goleogo.adventuretimewiki.provider.episodes.EpisodesColumns;

/**
 * Created by leosss on 24/01/16.
 */
public class EpisodesActivity  extends AppCompatActivity implements android.app.LoaderManager.LoaderCallbacks<Cursor> {

    AdapterEpisodes adapterEpisodes;
    GridView gridviewEpisodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.episode_activity);
        gridviewEpisodes = (GridView) findViewById(R.id.gridViewEpisode);

        getLoaderManager().initLoader(0, null, (android.app.LoaderManager.LoaderCallbacks<Cursor>) this);

        adapterEpisodes = new AdapterEpisodes(this,
                R.layout.item_episode,
                null,
                new String[]{},
                new int[]{},
                0);

        gridviewEpisodes.setAdapter(adapterEpisodes);

        gridviewEpisodes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this,
                EpisodesColumns.CONTENT_URI,
                null,
                null,
                null,
                "_id");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapterEpisodes.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapterEpisodes.swapCursor(null);
    }

}
