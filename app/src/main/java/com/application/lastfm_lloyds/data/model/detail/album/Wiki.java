
package com.application.lastfm_lloyds.data.model.detail.album;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "published",
    "summary",
    "content"
})
public class Wiki {

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
    public Wiki() {
    }

    /**
     * 
     * @param content
     * @param summary
     * @param published
     */
    public Wiki(String published, String summary, String content) {
        super();
        this.published = published;
        this.summary = summary;
        this.content = content;
    }

}
