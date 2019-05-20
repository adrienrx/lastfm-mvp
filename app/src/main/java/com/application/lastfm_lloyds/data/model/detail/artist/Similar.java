
package com.application.lastfm_lloyds.data.model.detail.artist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "artist"
})
public class Similar {

    @JsonProperty("artist")
    public List<Artist_> artist = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Similar() {
    }

    /**
     * 
     * @param artist
     */
    public Similar(List<Artist_> artist) {
        super();
        this.artist = artist;
    }

}
