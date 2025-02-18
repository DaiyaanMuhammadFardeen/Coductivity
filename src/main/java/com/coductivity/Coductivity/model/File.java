package com.coductivity.Coductivity.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileID;

    @Column(nullable = false)
    private String path; // e.g., "src/main/java/App.java"

    @Column(nullable = false)
    private boolean isFolder; // true = folder, false = file

    @Lob
    private byte[] content; // Stores file data (null if folder)

    @ManyToOne
    @JoinColumn(name = "repo_id", nullable = false)
    private Repo repository;
}
