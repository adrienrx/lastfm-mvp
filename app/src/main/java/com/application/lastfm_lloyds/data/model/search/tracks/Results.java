
package com.application.lastfm_lloyds.data.model.search.tracks;

import com.application.lastfm_lloyds.data.model.search.Attr;
import com.application.lastfm_lloyds.data.model.search.OpensearchQuery;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "opensearch:Query",
    "opensearch:totalResults",
    "opensearch:startIndex",
    "opensearch:itemsPerPage",
    "trackmatches",
    "@attr"
})
public class Results implements Serializable
{

    @JsonProperty("opensearch:Query")
    public OpensearchQuery opensearchQuery;
    @JsonProperty("opensearch:totalResults")
    public String opensearchTotalResults;
    @JsonProperty("opensearch:startIndex")
    public String opensearchStartIndex;
    @JsonProperty("opensearch:itemsPerPage")
    public String opensearchItemsPerPage;
    @JsonProperty("trackmatches")
    public Trackmatches trackmatches;
    @JsonProperty("@attr")
    public Attr attr;
    private final static long serialVersionUID = 4813419432862020920L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Results() {
    }

    /**
     * 
     * @param opensearchItemsPerPage
     * @param opensearchQuery
     * @param opensearchStartIndex
     * @param attr
     * @param opensearchTotalResults
     * @param trackmatches
     */
    public Results(OpensearchQuery opensearchQuery, String opensearchTotalResults, String opensearchStartIndex, String opensearchItemsPerPage, Trackmatches trackmatches, Attr attr) {
        super();
        this.opensearchQuery = opensearchQuery;
        this.opensearchTotalResults = opensearchTotalResults;
        this.opensearchStartIndex = opensearchStartIndex;
        this.opensearchItemsPerPage = opensearchItemsPerPage;
        this.trackmatches = trackmatches;
        this.attr = attr;
    }

}
