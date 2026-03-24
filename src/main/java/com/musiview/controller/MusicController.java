package com.musiview.controller;

import com.musiview.model.Music;
import com.musiview.service.MusicService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/musics")
public class MusicController {

    private final MusicService service;

    public MusicController(MusicService service) {
        this.service = service;
    }

    @PostMapping
    public Music add(@RequestBody Music music) {
        return service.save(music);
    }
}