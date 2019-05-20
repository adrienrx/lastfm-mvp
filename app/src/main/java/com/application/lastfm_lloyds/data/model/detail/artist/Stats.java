
package com.application.lastfm_lloyds.data.model.detail.artist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "listeners",
    "playcount"
})
public class Stats {

    @JsonProperty("listeners")
    public String listeners;
    @JsonProperty("playcount")
    public String playcount;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Stats() {
    }

    /**
     * 
     * @param listeners
     * @param playcount
     */
    public Stats(String listeners, String playcount) {
        super();
        this.listeners = listeners;
        this.playcount = playcount;
    }

}
