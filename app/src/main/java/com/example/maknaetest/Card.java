package com.example.maknaetest;

public class Card {
    private String title;
    private String category;
    private String description;
    private int thumbnail;
    private int heart;

    public Card() {
    }

    public Card(String title, String category, String description, int thumbnail, int heart) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.thumbnail = thumbnail;
        this.heart = heart;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public int getHeart() {
        return heart;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }
}
