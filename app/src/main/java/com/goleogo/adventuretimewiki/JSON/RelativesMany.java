
package com.goleogo.adventuretimewiki.JSON;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RelativesMany {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RelativesMany() {
    }

    /**
     * 
     * @param id
     * @param name
     */
    public RelativesMany(Integer id, String name) {
        this.id = id;
        this.name = name;
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
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

}
