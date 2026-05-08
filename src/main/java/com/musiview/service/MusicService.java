package com.musiview.service;

import com.musiview.model.Music;
import com.musiview.model.Playlist;
import com.musiview.repository.MusicRepository;
import com.musiview.repository.PlaylistRepository;
import org.springframework.stereotype.Service;
import com.musiview.util.LinkUtils;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@Service
public class MusicService {

    private final MusicRepository repository;
    private final YoutubeService youtubeService;
    private final PlaylistRepository playlistRepository;

    public MusicService(MusicRepository repository, YoutubeService youtubeService, PlaylistRepository playlistRepository) {
        this.repository = repository;
        this.youtubeService= youtubeService;
        this.playlistRepository = playlistRepository;
    }

    public Music save(Music music, Long playlistId) {

        Playlist playlist=playlistRepository.findById(playlistId).orElseThrow();
        music.setPlaylist(playlist);

        String platform= LinkUtils.detectPlatform(music.getLink());
        if (music.getLink()==null||music.getLink().isBlank()) {
            throw new RuntimeException("Link cannot be empty");
        }

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

    public List<Music> listByPlaylist(Long playlistId) {
        return repository.findByPlaylistId(playlistId);
    }
}
