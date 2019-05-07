package com.depas.playlist.web.rest.data;

import com.depas.playlist.PlayList;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayListDTO {
    private List<PlayList> playlists;

    public PlayListDTO(List<PlayList> playlists) {
        this.playlists = playlists;
    }

    @JsonProperty("playlists")
    public List<PlayList> getPlaylists() {
        return playlists;
    }
}
