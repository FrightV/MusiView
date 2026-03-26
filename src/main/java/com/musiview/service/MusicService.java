package com.musiview.service;

import com.musiview.model.Music;
import com.musiview.repository.MusicRepository;
import org.springframework.stereotype.Service;
import com.musiview.util.LinkUtils;

@Service
public class MusicService {

    private final MusicRepository repository;

    public MusicService(MusicRepository repository) {
        this.repository = repository;
    }

    public Music save(Music music) {

        String platform= LinkUtils.detectPlatform(music.getLink());

        music.setPlatform(platform);
        music.setScore(0);

        return repository.save(music);
    }
}
