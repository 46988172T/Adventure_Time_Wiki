
package com.goleogo.adventuretimewiki.JSON;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Character {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("episode")
    @Expose
    private List<Episode> episode = new ArrayList<Episode>();
    @SerializedName("species")
    @Expose
    private List<Species> species = new ArrayList<Species>();
    @SerializedName("relatives_many")
    @Expose
    private List<RelativesMany> relativesMany = new ArrayList<RelativesMany>();
    @SerializedName("occupations")
    @Expose
    private List<Occupation> occupations = new ArrayList<Occupation>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Character() {
    }

    /**
     * 
     * @param occupations
     * @param id
     * @param sex
     * @param episode
     * @param species
     * @param created
     * @param link
     * @param name
     * @param image
     * @param relativesMany
     * @param fullName
     * @param modified
     */
    public Character(Integer id, String name, String fullName, String sex, String link, String image, String created, String modified, List<Episode> episode, List<Species> species, List<RelativesMany> relativesMany, List<Occupation> occupations) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.sex = sex;
        this.link = link;
        this.image = image;
        this.created = created;
        this.modified = modified;
        this.episode = episode;
        this.species = species;
        this.relativesMany = relativesMany;
        this.occupations = occupations;
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

    /**
     * 
     * @return
     *     The fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 
     * @param fullName
     *     The full_name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * 
     * @return
     *     The sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * 
     * @param sex
     *     The sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 
     * @return
     *     The link
     */
    public String getLink() {
        return link;
    }

    /**
     * 
     * @param link
     *     The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 
     * @return
     *     The image
     */
    public String getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 
     * @return
     *     The created
     */
    public String getCreated() {
        return created;
    }

    /**
     * 
     * @param created
     *     The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * 
     * @return
     *     The modified
     */
    public String getModified() {
        return modified;
    }

    /**
     * 
     * @param modified
     *     The modified
     */
    public void setModified(String modified) {
        this.modified = modified;
    }

    /**
     * 
     * @return
     *     The episode
     */
    public List<Episode> getEpisode() {
        return episode;
    }

    /**
     * 
     * @param episode
     *     The episode
     */
    public void setEpisode(List<Episode> episode) {
        this.episode = episode;
    }

    /**
     * 
     * @return
     *     The species
     */
    public List<Species> getSpecies() {
        return species;
    }

    /**
     * 
     * @param species
     *     The species
     */
    public void setSpecies(List<Species> species) {
        this.species = species;
    }

    /**
     * 
     * @return
     *     The relativesMany
     */
    public List<RelativesMany> getRelativesMany() {
        return relativesMany;
    }

    /**
     * 
     * @param relativesMany
     *     The relatives_many
     */
    public void setRelativesMany(List<RelativesMany> relativesMany) {
        this.relativesMany = relativesMany;
    }

    /**
     * 
     * @return
     *     The occupations
     */
    public List<Occupation> getOccupations() {
        return occupations;
    }

    /**
     * 
     * @param occupations
     *     The occupations
     */
    public void setOccupations(List<Occupation> occupations) {
        this.occupations = occupations;
    }

}
