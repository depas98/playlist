package com.depas.playlist.service;

import com.depas.playlist.PlayList;

import java.util.List;
import java.util.Optional;

public interface PlayListService {

     List<PlayList> getPlayLists();

     Optional<PlayList> getPlayList(String playListName);
}
