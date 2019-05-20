
package com.application.lastfm_lloyds.data.model.search.artists;

import com.application.lastfm_lloyds.data.model.search.Image;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "listeners",
    "mbid",
    "url",
    "streamable",
    "image"
})
public class Artist implements Serializable
{

    @JsonProperty("name")
    public String name;
    @JsonProperty("listeners")
    public String listeners;
    @JsonProperty("mbid")
    public String mbid;
    @JsonProperty("url")
    public String url;
    @JsonProperty("streamable")
    public String streamable;
    @JsonProperty("image")
    public List<Image> image = null;
    private final static long serialVersionUID = -3302684278621740451L;
    public final String type = "Artist";

    /**
     * No args constructor for use in serialization
     * 
     */
    public Artist() {
    }

    /**
     * 
     * @param listeners
     * @param mbid
     * @param name
     * @param image
     * @param streamable
     * @param url
     */
    public Artist(String name, String listeners, String mbid, String url, String streamable, List<Image> image) {
        super();
        this.name = name;
        this.listeners = listeners;
        this.mbid = mbid;
        this.url = url;
        this.streamable = streamable;
        this.image = image;
    }

}
