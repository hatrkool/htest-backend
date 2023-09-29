package com.htest.htest.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "formdata")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column
    String name;
    @Column
    int[] sectorSelection;
    @Column
    boolean agreeToTerms;
}
