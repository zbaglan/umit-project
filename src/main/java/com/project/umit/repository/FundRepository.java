package com.project.umit.repository;

import com.project.umit.entity.Fund;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FundRepository extends JpaRepository<Fund, Long> {
    List<Fund> findAllByLocale(String locale, Pageable pageable);
}