package com.depas.playlist.web.rest;

import com.depas.playlist.PlayList;
import com.depas.playlist.service.PlayListService;
import com.depas.playlist.service.PlayListServiceImpl;
import com.depas.playlist.web.rest.data.PlayListDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PlayListController {
    private static final Logger logger = LoggerFactory.getLogger(PlayListServiceImpl.class);

    @Autowired
    @Qualifier("playListServiceImpl")
    PlayListService playListService;

    @GetMapping(value = "/playlists", produces = "application/json")
    public ResponseEntity<PlayListDTO> getPlayLists() {

        logger.debug("Getting all playlist");
        return new ResponseEntity<>(new PlayListDTO(playListService.getPlayLists()), HttpStatus.OK);
    }

    @GetMapping(value = "/playlist/{playListName}", produces = "application/json")
    public ResponseEntity<PlayListDTO> getPlayListByName(@PathVariable("playListName") final String playListName){

        logger.debug("Getting playlist with name " + playListName);
        return new ResponseEntity<>(playListService.getPlayList(playListName)
                                        .map(PlayListDTO::new)
                                        .orElseGet(PlayListDTO::new), HttpStatus.OK);
    }
}
