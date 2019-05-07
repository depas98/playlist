package com.depas.playlist;

import java.util.Objects;

public class Song {

    private String name;
    private String artist;
    private int year;

    public Song(String name, String artist, int year){
        this.name = name;
        this.artist = artist;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }


    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        if (!(o instanceof Song)){
            return false;
        }

        Song song = (Song) o;
        return song.name.equalsIgnoreCase(name)
                && song.artist.equalsIgnoreCase(artist)
                && song.year == year;
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + (artist == null ? 0 : artist.hashCode());
        result = 31 * result + year;

        return result;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName())
                .append(" [name=").append(name)
                .append(", artist=").append(artist)
                .append(", year=").append(year)
                .append("]");
        return sb.toString();
    }
}
