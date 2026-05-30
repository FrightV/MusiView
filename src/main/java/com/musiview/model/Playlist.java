package com.musiview.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Setter
@Getter
@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy="playlist", cascade=CascadeType.ALL)
    @JsonIgnore
    private List<Music> musics;


}
