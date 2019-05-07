package com.depas.playlist;

import java.util.HashSet;
import java.util.Set;

public class PlayList {

    private final String name;
    private final Set<Song> songs;

    private PlayList(PlayListBuilder builder){
       this.name = builder.name;
       this.songs = builder.songs;
    }

    public String getName() {
        return name;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName())
                .append(" [name=").append(name)
                .append(", songs=").append(songs)
                .append("]");
        return sb.toString();
    }

    public static class PlayListBuilder {

        private final String name;
        private final Set<Song> songs = new HashSet<>();

        public PlayListBuilder(final String name){
            this.name = name;
        }

        public PlayListBuilder addSong(final Song song){
            this.songs.add(song);
            return this;
        }

        public PlayListBuilder addSongs(final Set<Song> songsIn){
            System.out.println(songsIn);
            boolean worked = this.songs.addAll(songsIn);
            songsIn.forEach(s -> this.songs.add(s));
            return this;
        }

        public PlayList build(){
            return new PlayList(this);
        }
    }
}
