
package com.application.lastfm_lloyds.data.model.search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "for"
})
public class Attr implements Serializable
{

    @JsonProperty("for")
    public String _for;
    private final static long serialVersionUID = 4815047794711098540L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attr() {
    }

    /**
     * 
     * @param _for
     */
    public Attr(String _for) {
        super();
        this._for = _for;
    }

}
