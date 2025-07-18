package org.lessons.java.best_of_the_year.classes;

import java.util.ArrayList;

public class Media {
    private int id;
    private String title;
    private int likes;

    public Media(int id, String title) {
        this.id = id;
        this.title = title;
        this.likes = (int) (Math.random() * 101);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addLike() {
        this.likes++;
    }

    public void removeLike() {
        this.likes--;
    }

    public static ArrayList<Media> getBestMedia(Media[] existingMedia) {

        ArrayList<Media> bestMedia = new ArrayList<Media>();

        for (int i = 0; i < existingMedia.length; i++) {
            int j = 0;
            if (bestMedia.size() == 0) {
                bestMedia.add(existingMedia[i]);
                continue;
            }
            do {

                if (existingMedia[i].likes > bestMedia.get(j).likes && existingMedia[i] != bestMedia.get(j)) {
                    bestMedia.add(j, existingMedia[i]);
                    if (bestMedia.size() > 10) {
                        bestMedia.remove(bestMedia.size() - 1);
                    }
                    break;
                }
                j++;
            } while (j < bestMedia.size());
            if (j == bestMedia.size() && bestMedia.size() < 10) {
                bestMedia.add(bestMedia.size(), existingMedia[i]);
            }
        }

        return bestMedia;
    }
}
