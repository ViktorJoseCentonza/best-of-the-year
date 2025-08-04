package org.lessons.java.best_of_the_year.classes;

import java.util.Random;

public class Media {
    private static int mediaCounter = 0;
    private String title;
    private int likes;
    private int id;

    public Media(String title) {
        this.id = mediaCounter;
        mediaCounter++;
        this.title = title;
        Random rand = new Random();
        this.likes = rand.nextInt(100);
    }

    public Media(String title, int likes) {
        this.id = mediaCounter;
        mediaCounter++;
        this.title = title;
        this.likes = likes;
    }

    public int getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getLikes() {
        return this.likes;
    }

    public void addLike() {
        this.likes++;
    }

    public void removeLike() {
        if (this.likes > 0) {
            this.likes--;
        } else {
            System.out.println("there's no like to remove!");
        }

    }

    @Override
    public String toString() {
        return this.title;
    }
}
