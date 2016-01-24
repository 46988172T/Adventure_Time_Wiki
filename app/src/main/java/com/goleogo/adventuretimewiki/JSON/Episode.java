
package com.goleogo.adventuretimewiki.JSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Episode {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("title_card")
    @Expose
    private String title_card;
    @SerializedName("air_date")
    @Expose
    private String air_date;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Episode() {
    }

    /**
     * 
     * @param id
     * @param title
     */
    public Episode(Integer id, String title, String description, String air_date, String title_card) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.air_date = air_date;
        this.title_card = title_card;
    }

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The airDate
     */
    public String getAirDate() {
        return air_date;
    }

    /**
     *
     * @param airDate
     * The air_date
     */
    public void setAirDate(String airDate) {
        this.air_date = airDate;
    }

    /**
     *
     * @return
     * The titleCard
     */
    public String getTitleCard() {
        return title_card;
    }

    /**
     *
     * @param titleCard
     * The title_card
     */
    public void setTitleCard(String titleCard) {
        this.title_card = titleCard;
    }

}
