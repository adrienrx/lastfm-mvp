
package com.application.lastfm_lloyds.data.model.detail.album;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "rank"
})
public class Attr {

    @JsonProperty("rank")
    public String rank;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attr() {
    }

    /**
     * 
     * @param rank
     */
    public Attr(String rank) {
        super();
        this.rank = rank;
    }

}
