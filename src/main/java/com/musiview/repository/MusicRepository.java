package com.musiview.repository;

import com.musiview.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MusicRepository extends JpaRepository<Music, Long> {
    List<Music> findByPlaylistId(Long playlistId);
}