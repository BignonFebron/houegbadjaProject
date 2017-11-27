package com.bootcamp.models;

import com.bootcamp.enums.MediaType;

/**
 * Created by darextossa on 11/26/17.
 */
public class Media {
    private String name;
    private MediaType mediaType;
    private String link;

    public Media() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
