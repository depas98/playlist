package com.depas.playlist.web.rest.data;

import com.depas.playlist.PlayList;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayListDTO {
    private List<PlayList> playlists;

    public PlayListDTO() {
        this.playlists = new ArrayList<>();
    }

    public PlayListDTO(PlayList playlist) {
        this.playlists = new ArrayList<>();
        this.playlists.add(playlist);
    }

    public PlayListDTO(List<PlayList> playlists) {
        this.playlists = playlists;
    }

    @JsonProperty("playlists")
    public List<PlayList> getPlaylists() {
        return playlists;
    }
}
