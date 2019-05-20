
package com.application.lastfm_lloyds.data.model.search.tracks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "results"
})
public class TrackResponse implements Serializable
{

    @JsonProperty("results")
    public Results results;
    private final static long serialVersionUID = 2967545285712161635L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TrackResponse() {
    }

    /**
     * 
     * @param results
     */
    public TrackResponse(Results results) {
        super();
        this.results = results;
    }

}
