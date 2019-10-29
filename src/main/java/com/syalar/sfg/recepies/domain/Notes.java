package com.syalar.sfg.recepies.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Created by jd.rodriguez
 */
@Data
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
