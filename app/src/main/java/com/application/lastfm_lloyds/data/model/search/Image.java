
package com.application.lastfm_lloyds.data.model.search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "#text",
    "size"
})
public class Image implements Serializable
{

    @JsonProperty("#text")
    public String text;
    @JsonProperty("size")
    public String size;
    private final static long serialVersionUID = -2663740089579598173L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Image() {
    }

    /**
     * 
     * @param text
     * @param size
     */
    public Image(String text, String size) {
        super();
        this.text = text;
        this.size = size;
    }

}
