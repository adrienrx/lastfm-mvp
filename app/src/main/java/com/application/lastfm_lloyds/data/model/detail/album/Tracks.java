
package com.application.lastfm_lloyds.data.model.detail.album;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "track"
})
public class Tracks {

    @JsonProperty("track")
    public List<Track> track = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Tracks() {
    }

    /**
     * 
     * @param track
     */
    public Tracks(List<Track> track) {
        super();
        this.track = track;
    }

}
