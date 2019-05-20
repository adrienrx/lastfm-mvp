
package com.application.lastfm_lloyds.data.model.detail.artist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "#text",
    "rel",
    "href"
})
public class Link {

    @JsonProperty("#text")
    public String text;
    @JsonProperty("rel")
    public String rel;
    @JsonProperty("href")
    public String href;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Link() {
    }

    /**
     * 
     * @param text
     * @param rel
     * @param href
     */
    public Link(String text, String rel, String href) {
        super();
        this.text = text;
        this.rel = rel;
        this.href = href;
    }

}
