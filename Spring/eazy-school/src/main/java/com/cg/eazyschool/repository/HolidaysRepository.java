package com.cg.eazyschool.repository;

import com.cg.eazyschool.model.Holiday;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends PagingAndSortingRepository<Holiday, String> {
}
