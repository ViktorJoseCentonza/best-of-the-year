package org.lessons.java.best_of_the_year.classes;

public class Media {
    private String title;
    private int likes;

    public Media(String title) {
        this.title = title;
        this.likes = (int) (Math.random() * 101);
    }

    public Media(String title, int likes) {
        this.title = title;
        this.likes = likes;
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
        this.likes--;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
