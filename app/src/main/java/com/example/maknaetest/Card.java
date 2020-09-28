package com.example.maknaetest;

public class Card {
    // 카드뷰 리스트에  들어갈 요소들 변수 선언
    private String title; // ex)기분전환이필요해
    private String category; // 안쓰는 코드
    private String description; // 안쓰는 코드
    private int thumbnail; // 배경사진
    private int heart; // heart_full

    public Card() { //기본 생성자
    }
 // FragmentRecommend.java의 24번line
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
