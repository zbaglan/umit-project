package com.project.umit.repository;

import com.project.umit.entity.MomsHouse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MomsHouseRepository extends JpaRepository<MomsHouse, Long> {

    List<MomsHouse> findAllByLocale(String locale, Pageable pageable);
}
