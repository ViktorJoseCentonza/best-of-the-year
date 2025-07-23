package org.lessons.java.best_of_the_year.classes;

import java.util.ArrayList;

public class Song extends Media {

    private static int generalId = 0;
    private final int id;

    static private ArrayList<Song> existingSongs = new ArrayList<Song>();

    public Song(String title) {
        super(title);
        this.id = generalId;
        generalId++;
        existingSongs.add(this);
    }

    public Song(String title, int likes) {
        super(title, likes);
        this.id = generalId;
        generalId++;
        existingSongs.add(this);
    }

    public int getId() {
        return id;
    }

    public static Song getSong(int i) {
        if (i >= existingSongs.size() || i < 0) {
            return null;
        }
        return existingSongs.get(i);
    }

    public static ArrayList<Song> getBest() {

        ArrayList<Song> BestSongs = new ArrayList<Song>();

        for (int i = 0; i < existingSongs.size(); i++) {
            int j = 0;
            if (BestSongs.size() == 0) {
                BestSongs.add(existingSongs.get(i));
                continue;
            }
            do {

                if (existingSongs.get(i).getLikes() > BestSongs.get(j).getLikes()
                        && existingSongs.get(i) != BestSongs.get(j)) {
                    BestSongs.add(j, existingSongs.get(i));
                    if (BestSongs.size() > 10) {
                        BestSongs.remove(BestSongs.size() - 1);
                    }
                    break;
                }
                j++;
            } while (j < BestSongs.size());
            if (j == BestSongs.size() && BestSongs.size() < 10) {
                BestSongs.add(BestSongs.size(), existingSongs.get(i));
            }
        }

        return BestSongs;
    }

    @Override
    public String toString() {
        return super.toString() + " id: " + this.id;
    }
}
