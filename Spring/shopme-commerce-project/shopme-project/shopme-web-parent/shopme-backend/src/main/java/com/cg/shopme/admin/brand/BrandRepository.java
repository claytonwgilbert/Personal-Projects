package com.cg.shopme.admin.brand;

import com.cg.shopme.common.entity.Brand;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BrandRepository extends PagingAndSortingRepository<Brand, Integer> {
    List<Brand> findByName(String keywordSearch);
}
