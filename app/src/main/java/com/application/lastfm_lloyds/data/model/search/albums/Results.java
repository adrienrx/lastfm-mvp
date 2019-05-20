
package com.application.lastfm_lloyds.data.model.search.albums;

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
    "albummatches",
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
    @JsonProperty("albummatches")
    public Albummatches albummatches;
    @JsonProperty("@attr")
    public Attr attr;
    private final static long serialVersionUID = 6873199231467344427L;

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
     * @param albummatches
     * @param opensearchStartIndex
     * @param attr
     * @param opensearchTotalResults
     */
    public Results(OpensearchQuery opensearchQuery, String opensearchTotalResults, String opensearchStartIndex, String opensearchItemsPerPage, Albummatches albummatches, Attr attr) {
        super();
        this.opensearchQuery = opensearchQuery;
        this.opensearchTotalResults = opensearchTotalResults;
        this.opensearchStartIndex = opensearchStartIndex;
        this.opensearchItemsPerPage = opensearchItemsPerPage;
        this.albummatches = albummatches;
        this.attr = attr;
    }

}
