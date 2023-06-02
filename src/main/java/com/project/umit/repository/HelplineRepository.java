package com.project.umit.repository;

import com.project.umit.entity.Helpline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HelplineRepository extends JpaRepository<Helpline, Long> {
    List<Helpline> findAllByLocale(String locale);
}
