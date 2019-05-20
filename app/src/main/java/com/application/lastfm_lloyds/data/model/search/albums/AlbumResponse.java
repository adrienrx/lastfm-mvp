
package com.application.lastfm_lloyds.data.model.search.albums;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "results"
})
public class AlbumResponse implements Serializable
{

    @JsonProperty("results")
    public Results results;
    private final static long serialVersionUID = -6340416920059335319L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlbumResponse() {
    }

    /**
     * 
     * @param results
     */
    public AlbumResponse(Results results) {
        super();
        this.results = results;
    }

}
