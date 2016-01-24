
package com.goleogo.adventuretimewiki.JSON;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Occupation {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Occupation() {
    }

    /**
     * 
     * @param id
     * @param title
     */
    public Occupation(Integer id, String title) {
        this.id = id;
        this.title = title;
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

}
