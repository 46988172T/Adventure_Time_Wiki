package com.goleogo.adventuretimewiki;

import android.content.Context;
import android.util.Log;

import com.goleogo.adventuretimewiki.JSON.*;
import com.goleogo.adventuretimewiki.JSON.Character;
import com.goleogo.adventuretimewiki.provider.characters.CharactersColumns;
import com.goleogo.adventuretimewiki.provider.characters.CharactersContentValues;
import com.goleogo.adventuretimewiki.provider.episodes.EpisodesColumns;
import com.goleogo.adventuretimewiki.provider.episodes.EpisodesContentValues;

import java.util.Arrays;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by leosss on 20/01/16.
 */
public class ApiAdvTimeClass{
    final String BASE_URL = "http://adventuretimeapi.com/api/v1/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    ApiAdvTimeInterface apiService = retrofit.create(ApiAdvTimeInterface.class);

    public ApiAdvTimeClass(){
        super();
    }

    public void getCharacters(final Context context) {

        for (int i = 1; i < 6; i++) {
            Call<Character> call = apiService.characters(String.valueOf(i));
            call.enqueue(new Callback<Character>() {
                @Override
                public void onResponse(final Response<Character> response, Retrofit retrofit) {

                    if (response.isSuccess()) {
                        Character character = response.body();

                        CharactersContentValues charactersContentValues = new CharactersContentValues();
                        charactersContentValues.putFullName(character.getFullName());
                        charactersContentValues.putSex(character.getSex());
                        System.out.println("-----------------------------------------" + character.getFullName());
                        charactersContentValues.putImage(character.getImage());
                        context.getContentResolver().insert(CharactersColumns.CONTENT_URI, charactersContentValues.values());
                    }

                }

                @Override
                public void onFailure(Throwable t) {
                    Log.w(null, Arrays.toString(t.getStackTrace()));
                    System.out.println("ERROR AL DESCARGAR INFO");
                }
            });
        }
    }

    public void getEpisodes(final Context context) {

        for (int i = 1; i < 4; i++) {
            Call<Episode> call = apiService.episodes(String.valueOf(i));
            call.enqueue(new Callback<Episode>() {
                @Override
                public void onResponse(final Response<Episode> response, Retrofit retrofit) {

                    if (response.isSuccess()) {
                        Episode episode = response.body();

                        EpisodesContentValues episodesContentValues = new EpisodesContentValues();
                        episodesContentValues.putTitleCard(episode.getTitleCard());
                        episodesContentValues.putDescription(episode.getDescription());
                        episodesContentValues.putTitle(episode.getTitle());
                        episodesContentValues.putAirDate(episode.getAirDate());
                        System.out.println("-----------------------------------------" + episode.getTitle());

                        context.getContentResolver().insert(EpisodesColumns.CONTENT_URI, episodesContentValues.values());
                    }

                }

                @Override
                public void onFailure(Throwable t) {
                    Log.w(null, Arrays.toString(t.getStackTrace()));
                    System.out.println("ERROR AL DESCARGAR INFO");
                }
            });
        }
    }
}

interface ApiAdvTimeInterface {
    @GET("characters/{id}")
    Call<Character> characters(
            @Path("id") String id
    );

    @GET("episodes/{id}")
    Call<Episode> episodes(
            @Path("id") String id
    );
}