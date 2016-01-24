package com.goleogo.adventuretimewiki;


import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.goleogo.adventuretimewiki.provider.characters.CharactersCursor;
import com.squareup.picasso.Picasso;

/**
 * Created by leosss on 20/01/16.
 */
public class AdapterCharacter extends SimpleCursorAdapter{
    TextView name;
    ImageView image;
    TextView sex;
    Context context;

    public AdapterCharacter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Cursor cursor = getCursor();
        CharactersCursor charactersCursor = new CharactersCursor(cursor);
        charactersCursor.moveToPosition(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_character, parent, false);
        }

        //int id = character.getId();
        name = (TextView) convertView.findViewById(R.id.name);
        image = (ImageView)convertView.findViewById(R.id.img);
        System.out.println("------------------>>> "+charactersCursor.getFullName());

        name.setText(charactersCursor.getFullName());

        if(charactersCursor.getImage() == null || charactersCursor.getImage() == ""){
            //pendiente imagen 'no image'
        }else {
            Picasso.with(context)
                    .load(charactersCursor.getImage())
                    .fit()
                    .into(image);
        }
        return convertView;

    }
}