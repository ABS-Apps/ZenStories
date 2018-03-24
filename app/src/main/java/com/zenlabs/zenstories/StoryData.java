package com.zenlabs.zenstories;

import java.io.Serializable;

public class StoryData implements Serializable {
    private String title;
    private int id;
    private String story;

    public StoryData(String title, int id, String story) {
        this.title = title;
        this.id = id;
        this.story = story;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }
}
