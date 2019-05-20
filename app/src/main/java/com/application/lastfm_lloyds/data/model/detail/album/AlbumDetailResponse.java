
package com.application.lastfm_lloyds.data.model.detail.album;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "album"
})
public class AlbumDetailResponse {

    @JsonProperty("album")
    public Album album;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlbumDetailResponse() {
    }

    /**
     * 
     * @param album
     */
    public AlbumDetailResponse(Album album) {
        super();
        this.album = album;
    }

}
