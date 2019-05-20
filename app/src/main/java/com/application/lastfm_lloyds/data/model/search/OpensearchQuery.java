
package com.application.lastfm_lloyds.data.model.search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "#text",
    "role",
    "searchTerms",
    "startPage"
})
public class OpensearchQuery implements Serializable
{

    @JsonProperty("#text")
    public String text;
    @JsonProperty("role")
    public String role;
    @JsonProperty("searchTerms")
    public String searchTerms;
    @JsonProperty("startPage")
    public String startPage;
    private final static long serialVersionUID = -668476182364481496L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OpensearchQuery() {
    }

    /**
     * 
     * @param text
     * @param searchTerms
     * @param role
     * @param startPage
     */
    public OpensearchQuery(String text, String role, String searchTerms, String startPage) {
        super();
        this.text = text;
        this.role = role;
        this.searchTerms = searchTerms;
        this.startPage = startPage;
    }

}
