package com.htest.htest.repository;

import com.htest.htest.entity.FormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<FormEntity, Integer> {
}
