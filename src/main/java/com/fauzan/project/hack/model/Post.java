package com.fauzan.project.hack.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

/**
 * Created by Intellij IDEA
 * User : fauzan
 * Date : 27/01/20
 */

public class Post {
    private final UUID id;
    @NotBlank
    private String author;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    public Post(@JsonProperty("id") UUID id,
                @JsonProperty("author") String author,
                @JsonProperty("title") String title,
                @JsonProperty("content") String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
