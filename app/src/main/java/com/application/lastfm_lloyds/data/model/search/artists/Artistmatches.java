
package com.application.lastfm_lloyds.data.model.search.artists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "artist"
})
public class Artistmatches implements Serializable
{

    @JsonProperty("artist")
    public List<Artist> artist = null;
    private final static long serialVersionUID = -893479575111503364L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Artistmatches() {
    }

    /**
     * 
     * @param artist
     */
    public Artistmatches(List<Artist> artist) {
        super();
        this.artist = artist;
    }

}
