
package com.application.lastfm_lloyds.data.model.search.artists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "results"
})
public class ArtistsResponse implements Serializable
{

    @JsonProperty("results")
    public Results results;
    private final static long serialVersionUID = -1494638787901945165L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ArtistsResponse() {
    }

    /**
     * 
     * @param results
     */
    public ArtistsResponse(Results results) {
        super();
        this.results = results;
    }

}
