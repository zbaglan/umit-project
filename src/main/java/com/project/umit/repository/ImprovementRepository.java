package com.project.umit.repository;

import com.project.umit.entity.Improvement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImprovementRepository extends JpaRepository<Improvement, Long> {
}