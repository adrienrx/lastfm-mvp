
package com.application.lastfm_lloyds.data.model.detail.track;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "track"
})
public class TrackDetailResponse {

    @JsonProperty("track")
    public Track track;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TrackDetailResponse() {
    }

    /**
     * 
     * @param track
     */
    public TrackDetailResponse(Track track) {
        super();
        this.track = track;
    }

}
