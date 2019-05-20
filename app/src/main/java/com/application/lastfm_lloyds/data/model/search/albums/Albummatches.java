
package com.application.lastfm_lloyds.data.model.search.albums;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "album"
})
public class Albummatches implements Serializable
{

    @JsonProperty("album")
    public List<Album> album = null;
    private final static long serialVersionUID = -6812826189528386409L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Albummatches() {
    }

    /**
     * 
     * @param album
     */
    public Albummatches(List<Album> album) {
        super();
        this.album = album;
    }

}
