package com.musiview.controller;
import com.musiview.model.Playlist;
import com.musiview.service.PlaylistService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/playlists")
@CrossOrigin
public class PlaylistController {

    private final PlaylistService service;

    public PlaylistController(PlaylistService service) {
        this.service=service;
    }

    @PostMapping
    public Playlist create(@RequestBody Playlist playlist) {
        return service.create(playlist);
    }

    @GetMapping
    public List<Playlist> list() {
        return service.list();
    }
}