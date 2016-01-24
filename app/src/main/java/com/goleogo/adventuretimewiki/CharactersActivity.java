package com.goleogo.adventuretimewiki;

import android.app.ListActivity;
import android.content.CursorLoader;
import android.content.Intent;

import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.goleogo.adventuretimewiki.JSON.*;
import com.goleogo.adventuretimewiki.provider.characters.CharactersColumns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leosss on 20/01/16.
 */
public class CharactersActivity  extends AppCompatActivity implements android.app.LoaderManager.LoaderCallbacks<Cursor>{

    Adapter adapter;
    GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_activity);
        gridview = (GridView)findViewById(R.id.gridView);

        getLoaderManager().initLoader(0, null,(android.app.LoaderManager.LoaderCallbacks<Cursor>)this);

        adapter = new Adapter(this,
                R.layout.item_character,
                null,
                new String[]{   },
                new int[]{  },
                0);

        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
                CharactersColumns.CONTENT_URI,
                null,
                null,
                null,
                "_id");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }


}
