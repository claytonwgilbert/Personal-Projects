package com.cg.eazyschool.repository;

import com.cg.eazyschool.model.EazyClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EazyClassRepository extends JpaRepository<EazyClass, Integer> {
}
