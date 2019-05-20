
package com.application.lastfm_lloyds.data.model.detail.track;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "mbid",
    "url",
    "duration",
    "streamable",
    "listeners",
    "playcount",
    "artist",
    "album",
    "toptags",
    "wiki"
})
public class Track {

    @JsonProperty("name")
    public String name;
    @JsonProperty("mbid")
    public String mbid;
    @JsonProperty("url")
    public String url;
    @JsonProperty("duration")
    public String duration;
    @JsonProperty("streamable")
    public Streamable streamable;
    @JsonProperty("listeners")
    public String listeners;
    @JsonProperty("playcount")
    public String playcount;
    @JsonProperty("artist")
    public Artist artist;
    @JsonProperty("album")
    public Album album;
    @JsonProperty("toptags")
    public Toptags toptags;
    @JsonProperty("wiki")
    public Wiki wiki;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Track() {
    }

    /**
     * 
     * @param listeners
     * @param duration
     * @param mbid
     * @param toptags
     * @param album
     * @param name
     * @param streamable
     * @param playcount
     * @param artist
     * @param wiki
     * @param url
     */
    public Track(String name, String mbid, String url, String duration, Streamable streamable, String listeners, String playcount, Artist artist, Album album, Toptags toptags, Wiki wiki) {
        super();
        this.name = name;
        this.mbid = mbid;
        this.url = url;
        this.duration = duration;
        this.streamable = streamable;
        this.listeners = listeners;
        this.playcount = playcount;
        this.artist = artist;
        this.album = album;
        this.toptags = toptags;
        this.wiki = wiki;
    }

}
