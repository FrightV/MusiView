package com.musiview.service;

import com.musiview.model.Music;
import com.musiview.repository.MusicRepository;
import org.springframework.stereotype.Service;
import com.musiview.util.LinkUtils;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@Service
public class MusicService {

    private final MusicRepository repository;
    private final YoutubeService youtubeService;

    public MusicService(MusicRepository repository, YoutubeService youtubeService) {
        this.repository = repository;
        this.youtubeService= youtubeService;
    }

    public Music save(Music music) {

        String platform= LinkUtils.detectPlatform(music.getLink());

        music.setPlatform(platform);
        music.setScore(0);

        if (platform.equals("Youtube")) {
            String id = LinkUtils.extractYoutubeId(music.getLink());
            String[] data=youtubeService.dataSearch(id);

            if (data != null) {
                music.setName(data[0]);
                music.setCoverUrl(data[1]);
            } else {
                System.out.println("Error finding YouTube data");
            }
        }
        return repository.save(music);
    }

    public List<Music> listAll() {
        return repository.findAll();
    }
}
