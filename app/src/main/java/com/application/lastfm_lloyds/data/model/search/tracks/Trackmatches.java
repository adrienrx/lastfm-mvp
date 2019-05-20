
package com.application.lastfm_lloyds.data.model.search.tracks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "track"
})
public class Trackmatches implements Serializable
{

    @JsonProperty("track")
    public List<Track> track = null;
    private final static long serialVersionUID = -3244578490998196019L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Trackmatches() {
    }

    /**
     * 
     * @param track
     */
    public Trackmatches(List<Track> track) {
        super();
        this.track = track;
    }

}
