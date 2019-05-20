
package com.application.lastfm_lloyds.data.model.search.albums;

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
    "image",
    "streamable",
    "mbid"
})
public class Album implements Serializable
{

    @JsonProperty("name")
    public String name;
    @JsonProperty("artist")
    public String artist;
    @JsonProperty("url")
    public String url;
    @JsonProperty("image")
    public List<Image> image = null;
    @JsonProperty("streamable")
    public String streamable;
    @JsonProperty("mbid")
    public String mbid;
    private final static long serialVersionUID = 9172870432691280450L;
    public final String type = "Album";

    /**
     * No args constructor for use in serialization
     * 
     */
    public Album() {
    }

    /**
     * 
     * @param mbid
     * @param name
     * @param streamable
     * @param image
     * @param artist
     * @param url
     */
    public Album(String name, String artist, String url, List<Image> image, String streamable, String mbid) {
        super();
        this.name = name;
        this.artist = artist;
        this.url = url;
        this.image = image;
        this.streamable = streamable;
        this.mbid = mbid;
    }

}
