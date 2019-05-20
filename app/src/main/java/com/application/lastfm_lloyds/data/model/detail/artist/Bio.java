
package com.application.lastfm_lloyds.data.model.detail.artist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "links",
    "published",
    "summary",
    "content"
})
public class Bio {

    @JsonProperty("links")
    public Links links;
    @JsonProperty("published")
    public String published;
    @JsonProperty("summary")
    public String summary;
    @JsonProperty("content")
    public String content;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Bio() {
    }

    /**
     * 
     * @param content
     * @param summary
     * @param links
     * @param published
     */
    public Bio(Links links, String published, String summary, String content) {
        super();
        this.links = links;
        this.published = published;
        this.summary = summary;
        this.content = content;
    }

}
