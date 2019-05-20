
package com.application.lastfm_lloyds.data.model.detail.track;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "mbid",
    "url"
})
public class Artist {

    @JsonProperty("name")
    public String name;
    @JsonProperty("mbid")
    public String mbid;
    @JsonProperty("url")
    public String url;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Artist() {
    }

    /**
     * 
     * @param mbid
     * @param name
     * @param url
     */
    public Artist(String name, String mbid, String url) {
        super();
        this.name = name;
        this.mbid = mbid;
        this.url = url;
    }

}
