package com.musiview.controller;

import com.musiview.model.Music;
import com.musiview.service.MusicService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/musics")
public class MusicController {

    private final MusicService service;

    public MusicController(MusicService service) {
        this.service = service;
    }

    @PostMapping
    public Music add(@RequestBody Music music, @RequestParam Long playlistId) {
        return service.save(music, playlistId);
    }

    @GetMapping
    public List<Music> list(@RequestParam Long playlistId) {
        return service.listByPlaylist(playlistId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public Music update(@PathVariable Long id,
                        @RequestBody Music updateMusic) {
        return service.update(id, updateMusic);
    }
}

