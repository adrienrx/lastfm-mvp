
package com.application.lastfm_lloyds.data.model.search.tracks;

import com.application.lastfm_lloyds.data.model.search.Image;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "artist",
    "url",
    "streamable",
    "listeners",
    "image",
    "mbid"
})
public class Track implements Serializable
{

    @JsonProperty("name")
    public String name;
    @JsonProperty("artist")
    public String artist;
    @JsonProperty("url")
    public String url;
    @JsonProperty("streamable")
    public String streamable;
    @JsonProperty("listeners")
    public String listeners;
    @JsonProperty("image")
    public List<Image> image = null;
    @JsonProperty("mbid")
    public String mbid;
    private final static long serialVersionUID = 5610576727119071631L;
    public final String type = "Track";

    /**
     * No args constructor for use in serialization
     * 
     */
    public Track() {
    }

    /**
     * 
     * @param listeners
     * @param mbid
     * @param name
     * @param image
     * @param streamable
     * @param artist
     * @param url
     */
    public Track(String name, String artist, String url, String streamable, String listeners, List<Image> image, String mbid) {
        super();
        this.name = name;
        this.artist = artist;
        this.url = url;
        this.streamable = streamable;
        this.listeners = listeners;
        this.image = image;
        this.mbid = mbid;
    }

}
