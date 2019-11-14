package com.syalar.sfg.recepies.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by jd.rodriguez
 */
@Getter
@Setter
@Entity
@EqualsAndHashCode(exclude="recipe")
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Recipe recipe;
    @Lob
    private String recipeNotes;

}
