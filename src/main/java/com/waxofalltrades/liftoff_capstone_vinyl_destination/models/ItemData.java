package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import java.util.ArrayList;

public class ItemData {

    public static ArrayList<Album> findByTerm(String term, Iterable<Album> allAlbums){
        ArrayList <Album> results = new ArrayList<>();

        for (Album album : allAlbums){
            if (album.getName().toLowerCase().contains(term.toLowerCase())){
                results.add(album);
            } else if (album.getArtist().getName().toLowerCase().contains(term.toLowerCase())){
                results.add(album);
            } else if (album.getGenre().getName().toLowerCase().contains(term.toLowerCase())) {
                results.add(album);
            }
        }
        return results;
    }
}
