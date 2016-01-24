package com.goleogo.adventuretimewiki;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.goleogo.adventuretimewiki.provider.characters.CharactersColumns;
import com.goleogo.adventuretimewiki.provider.characters.CharactersCursor;
import com.squareup.picasso.Picasso;

/**
 * Created by leosss on 24/01/16.
 */
public class CharacterDetail extends AppCompatActivity {
    TextView name;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent i = getIntent();
        Long character_id = i.getLongExtra("character_id", -1);

        Cursor cursor = this.getContentResolver().query(
                CharactersColumns.CONTENT_URI,
                null,
                CharactersColumns._ID + " = ?",
                new String[]{String.valueOf(character_id)},
                null);

        CharactersCursor charactersCursor = new CharactersCursor(cursor);
        cursor.moveToNext();

        name = (TextView)findViewById(R.id.textViewName);
        image = (ImageView)findViewById(R.id.imgDetail);


        name.setText(charactersCursor.getFullName());
        Picasso.with(getBaseContext())
                .load(charactersCursor.getImage())
                .fit()
                .into(image);

    }
}
