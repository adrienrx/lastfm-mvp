
package com.application.lastfm_lloyds.data.model.detail.album;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "#text",
    "fulltrack"
})
public class Streamable {

    @JsonProperty("#text")
    public String text;
    @JsonProperty("fulltrack")
    public String fulltrack;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Streamable() {
    }

    /**
     * 
     * @param text
     * @param fulltrack
     */
    public Streamable(String text, String fulltrack) {
        super();
        this.text = text;
        this.fulltrack = fulltrack;
    }

}
