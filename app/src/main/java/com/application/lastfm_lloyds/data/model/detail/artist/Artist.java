
package com.application.lastfm_lloyds.data.model.detail.artist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "mbid",
    "url",
    "image",
    "streamable",
    "ontour",
    "stats",
    "similar",
    "tags",
    "bio"
})
public class Artist {

    @JsonProperty("name")
    public String name;
    @JsonProperty("mbid")
    public String mbid;
    @JsonProperty("url")
    public String url;
    @JsonProperty("image")
    public List<Image> image = null;
    @JsonProperty("streamable")
    public String streamable;
    @JsonProperty("ontour")
    public String ontour;
    @JsonProperty("stats")
    public Stats stats;
    @JsonProperty("similar")
    public Similar similar;
    @JsonProperty("tags")
    public Tags tags;
    @JsonProperty("bio")
    public Bio bio;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Artist() {
    }

    /**
     * 
     * @param tags
     * @param ontour
     * @param mbid
     * @param bio
     * @param stats
     * @param name
     * @param streamable
     * @param image
     * @param url
     * @param similar
     */
    public Artist(String name, String mbid, String url, List<Image> image, String streamable, String ontour, Stats stats, Similar similar, Tags tags, Bio bio) {
        super();
        this.name = name;
        this.mbid = mbid;
        this.url = url;
        this.image = image;
        this.streamable = streamable;
        this.ontour = ontour;
        this.stats = stats;
        this.similar = similar;
        this.tags = tags;
        this.bio = bio;
    }

}
