package com.project.umit.repository;

import com.project.umit.entity.CrisisCenter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrisisCenterRepository extends JpaRepository<CrisisCenter, Long> {

    List<CrisisCenter> findAllByLocale(String locale, Pageable pageable);
}
