
package com.application.lastfm_lloyds.data.model.detail.album;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "url"
})
public class Tag {

    @JsonProperty("name")
    public String name;
    @JsonProperty("url")
    public String url;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Tag() {
    }

    /**
     * 
     * @param name
     * @param url
     */
    public Tag(String name, String url) {
        super();
        this.name = name;
        this.url = url;
    }

}
