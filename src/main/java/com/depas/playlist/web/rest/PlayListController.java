package com.depas.playlist.web.rest;

import com.depas.playlist.PlayList;
import com.depas.playlist.service.PlayListService;
import com.depas.playlist.web.rest.data.PlayListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayListController {

    @Autowired
    @Qualifier("playListServiceImpl")
    PlayListService playListService;

    @GetMapping(value = "/playlists")
    public ResponseEntity<PlayListDTO> index(Model m) {

        PlayListDTO playLists = new PlayListDTO(playListService.getPlayLists());
        return new ResponseEntity<>(playLists, HttpStatus.OK);
    }
}
