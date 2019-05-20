
package com.application.lastfm_lloyds.data.model.detail.track;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "tag"
})
public class Toptags {

    @JsonProperty("tag")
    public List<Tag> tag = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Toptags() {
    }

    /**
     * 
     * @param tag
     */
    public Toptags(List<Tag> tag) {
        super();
        this.tag = tag;
    }

}
