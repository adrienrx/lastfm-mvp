
package com.application.lastfm_lloyds.data.model.detail.artist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "artist"
})
public class ArtistDetailResponse {

    @JsonProperty("artist")
    public Artist artist;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ArtistDetailResponse() {
    }

    /**
     * 
     * @param artist
     */
    public ArtistDetailResponse(Artist artist) {
        super();
        this.artist = artist;
    }

}
