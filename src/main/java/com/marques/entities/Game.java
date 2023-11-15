package com.marques.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_game")
@EqualsAndHashCode(of = "id")
public class Game {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tittle;
    private String name;
    @Column(name = "game_year")
    private Integer year;
    private String genre;
    private String platform;
    private String imgUrl;
    private String shortDescription;
    private String LongDescription;
}
