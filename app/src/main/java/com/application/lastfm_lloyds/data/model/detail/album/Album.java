
package com.application.lastfm_lloyds.data.model.detail.album;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "artist",
    "mbid",
    "url",
    "image",
    "listeners",
    "playcount",
    "tracks",
    "tags",
    "wiki"
})
public class Album {

    @JsonProperty("name")
    public String name;
    @JsonProperty("artist")
    public String artist;
    @JsonProperty("mbid")
    public String mbid;
    @JsonProperty("url")
    public String url;
    @JsonProperty("image")
    public List<Image> image = null;
    @JsonProperty("listeners")
    public String listeners;
    @JsonProperty("playcount")
    public String playcount;
    @JsonProperty("tracks")
    public Tracks tracks;
    @JsonProperty("tags")
    public Tags tags;
    @JsonProperty("wiki")
    public Wiki wiki;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Album() {
    }

    /**
     * 
     * @param tags
     * @param listeners
     * @param mbid
     * @param name
     * @param image
     * @param playcount
     * @param tracks
     * @param artist
     * @param wiki
     * @param url
     */
    public Album(String name, String artist, String mbid, String url, List<Image> image, String listeners, String playcount, Tracks tracks, Tags tags, Wiki wiki) {
        super();
        this.name = name;
        this.artist = artist;
        this.mbid = mbid;
        this.url = url;
        this.image = image;
        this.listeners = listeners;
        this.playcount = playcount;
        this.tracks = tracks;
        this.tags = tags;
        this.wiki = wiki;
    }

}
