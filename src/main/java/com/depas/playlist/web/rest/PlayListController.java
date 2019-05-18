package com.depas.playlist.web.rest;

import com.depas.playlist.service.PlayListService;
import com.depas.playlist.web.exception.RecordNotFoundException;
import com.depas.playlist.web.rest.data.PlayListDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayListController {
    private final Log logger = LogFactory.getLog(this.getClass());

    private final PlayListService playListService;

    public PlayListController(@Qualifier("playListServiceImpl") PlayListService playListService) {
        this.playListService = playListService;
    }

    @GetMapping(value = "/playlists", produces = "application/json")
    public ResponseEntity<PlayListDTO> getPlayLists() {

        logger.debug("Getting all playlist");

        if (true){
            throw new RuntimeException("Test Error");
        }

        return new ResponseEntity<>(new PlayListDTO(playListService.getPlayLists()), HttpStatus.OK);
    }

    @GetMapping(value = "/playlist/{playListName}", produces = "application/json")
    public ResponseEntity<PlayListDTO> getPlayListByName(@PathVariable("playListName") final String playListName){

        logger.debug("Getting playlist with name " + playListName);
        return new ResponseEntity<>(playListService.getPlayList(playListName)
                                        .map(PlayListDTO::new)
                                        .orElseThrow(() ->
                                            new RecordNotFoundException("Playlist " + playListName + " was not found."))
                                            , HttpStatus.OK);
                                        // this will not throw an error but return an empty list
//                                        .orElseGet(PlayListDTO::new), HttpStatus.OK);

    }
}
