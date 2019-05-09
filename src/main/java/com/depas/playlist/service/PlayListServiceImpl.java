package com.depas.playlist.service;

import com.depas.playlist.PlayList;
import com.depas.playlist.Song;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.naming.NameNotFoundException;
import java.util.*;

@Service
public class PlayListServiceImpl implements PlayListService {

    private static final Logger logger = LoggerFactory.getLogger(PlayListServiceImpl.class);

    ApplicationContext applicationContext;

    List<PlayList> playLists = new ArrayList<>();

    public PlayListServiceImpl(){

        logger.debug("instantiating playlistservice");


        // create some default playlist
        String playlist1 = "70s";
        Set<Song> songs = new HashSet<>();
        songs.add(new Song("One Of These Nights", "Eagles", 1975));
        songs.add(new Song("Listen To What The Man Said", "Wings", 1975));
        songs.add(new Song("I’m Not In Love", "10cc", 1975));
        songs.add(new Song("Tell Me Something Good", "Rufus Featuring Chaka Khan", 1974));
        songs.add(new Song("Sundown", "Gordon Lightfoot", 1974));
        songs.add(new Song("Let’s Get It On", "Marvin Gaye", 1973));
        songs.add(new Song("Brandy (You’re A Fine Girl)", "Looking Glass", 1972));
        songs.add(new Song("Long Cool Woman (In A Black Dress)", "The Hollies", 1972));
        songs.add(new Song("I’m Still In Love With You", "Al Green", 1972));
        songs.add(new Song("How Can You Mend A Broken Heart", "Bee Gees", 1971));

        PlayList playList1 = new PlayList.PlayListBuilder(playlist1)
                .addSongs(songs)
                .build();

        String playlist2 = "60s";
        songs = new HashSet<>();
        songs.add(new Song("Crystal Blue Persuasion", "Tommy James And The Shondells", 1969));
        songs.add(new Song("A Boy Named Sue", "Johnny Cash", 1969));
        songs.add(new Song("Summer In The City", "The Lovin’ Spoonful", 1966));
        songs.add(new Song("Paperback Writer", "The Beatles", 1966));
        songs.add(new Song("The Little Old Lady (From Pasadena)", "Jan & Dean", 1964));
        songs.add(new Song("House Of The Rising Sun", "The Animals", 1964));
        songs.add(new Song("Wipe Out", "The Surfaris", 1963));
        songs.add(new Song("Only The Lonely (Know How I Feel", "Roy Orbison", 1960));


        PlayList playList2 = new PlayList.PlayListBuilder(playlist2)
                .addSongs(songs)
                .build();

        logger.debug("add playlist: " + playList1);
        playLists.add(playList1);
        logger.debug("add playlist: " + playList2);
        playLists.add(playList2);
    }

    @Override
    public List<PlayList> getPlayLists() {
        return playLists;
    }

    @Override
    public Optional<PlayList> getPlayList(String playListName) {
        return playLists.stream()
                .filter(p -> p.getName().equals(playListName))
                .findAny();
    }

}
