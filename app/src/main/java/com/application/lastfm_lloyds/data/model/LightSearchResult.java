package com.application.lastfm_lloyds.data.model;

public class LightSearchResult {
    private String head;
    private String type;
    private String image;
    private String mbid;

    public LightSearchResult(final String head, final String type, final String image, final String mbid) {
        this.head = head;
        this.type = type;
        this.image = image;
        this.mbid = mbid;
    }

    public String getHead() {
        return head;
    }

    public String getType() {
        return type;
    }

    public String getImage() {
        return image;
    }

    public String getMbid() {
        return mbid;
    }
}
