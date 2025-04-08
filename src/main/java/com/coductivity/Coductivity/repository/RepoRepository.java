package com.coductivity.Coductivity.repository;

import com.coductivity.Coductivity.model.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoRepository extends JpaRepository <Repo, Long> {
}
