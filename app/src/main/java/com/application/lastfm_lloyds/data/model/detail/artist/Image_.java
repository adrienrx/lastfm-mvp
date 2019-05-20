
package com.application.lastfm_lloyds.data.model.detail.artist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "#text",
    "size"
})
public class Image_ {

    @JsonProperty("#text")
    public String text;
    @JsonProperty("size")
    public String size;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Image_() {
    }

    /**
     * 
     * @param text
     * @param size
     */
    public Image_(String text, String size) {
        super();
        this.text = text;
        this.size = size;
    }

}
