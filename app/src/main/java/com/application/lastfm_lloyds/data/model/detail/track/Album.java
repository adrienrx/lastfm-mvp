
package com.application.lastfm_lloyds.data.model.detail.track;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "artist",
    "title",
    "mbid",
    "url",
    "image",
    "@attr"
})
public class Album {

    @JsonProperty("artist")
    public String artist;
    @JsonProperty("title")
    public String title;
    @JsonProperty("mbid")
    public String mbid;
    @JsonProperty("url")
    public String url;
    @JsonProperty("image")
    public List<Image> image = null;
    @JsonProperty("@attr")
    public Attr attr;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Album() {
    }

    /**
     * 
     * @param title
     * @param mbid
     * @param image
     * @param attr
     * @param artist
     * @param url
     */
    public Album(String artist, String title, String mbid, String url, List<Image> image, Attr attr) {
        super();
        this.artist = artist;
        this.title = title;
        this.mbid = mbid;
        this.url = url;
        this.image = image;
        this.attr = attr;
    }

}
