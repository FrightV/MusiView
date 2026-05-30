package com.musiview.service;

import com.musiview.model.Playlist;
import com.musiview.repository.PlaylistRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlaylistService {

    private final PlaylistRepository repository;

    public PlaylistService(PlaylistRepository repository) {
        this.repository=repository;
    }
    public Playlist create(Playlist playlist) {
        return repository.save(playlist);
    }
    public List<Playlist> list() {
        return repository.findAll();
    }
    public Playlist searchId(Long id) {
        return repository.findById(id).orElseThrow();
    }
    public void delete(Long id) { repository.deleteById(id);}

    public Playlist update(Long id, Playlist updated) {
        Playlist playlist= repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
        playlist.setName(updated.getName());
        return repository.save(playlist);
    }
}
