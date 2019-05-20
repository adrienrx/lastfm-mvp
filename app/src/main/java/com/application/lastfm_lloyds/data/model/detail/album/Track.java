
package com.application.lastfm_lloyds.data.model.detail.album;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "url",
    "duration",
    "@attr",
    "streamable",
    "artist"
})
public class Track {

    @JsonProperty("name")
    public String name;
    @JsonProperty("url")
    public String url;
    @JsonProperty("duration")
    public String duration;
    @JsonProperty("@attr")
    public Attr attr;
    @JsonProperty("streamable")
    public Streamable streamable;
    @JsonProperty("artist")
    public Artist artist;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Track() {
    }

    /**
     * 
     * @param duration
     * @param name
     * @param streamable
     * @param attr
     * @param artist
     * @param url
     */
    public Track(String name, String url, String duration, Attr attr, Streamable streamable, Artist artist) {
        super();
        this.name = name;
        this.url = url;
        this.duration = duration;
        this.attr = attr;
        this.streamable = streamable;
        this.artist = artist;
    }

}
