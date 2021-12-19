package com.cg.shopme.admin.brand;

import com.cg.shopme.common.entity.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private BrandRepository repository;

    public BrandService(BrandRepository repository) {
        this.repository = repository;
    }

    public List<Brand> getAllBrands(){
        return (List<Brand>) repository.findAll();
    }

    public List<Brand> findBrandByName(String searchTerm){
       return repository.findByName(searchTerm);
    }

    public Brand saveBrand(Brand brand) {
        return repository.save(brand);
    }

    public boolean isBrandUnique(Integer id, String name) {
        boolean isCreatingNewBrand = (id == null || id == 0);

        List<Brand> foundBrand = repository.findByName(name);

        if(isCreatingNewBrand){
            if(!foundBrand.isEmpty()){
                return false;
            }
        }else{
            if(!foundBrand.isEmpty() && foundBrand.get(0).getId() != id){
                return false;
            }
        }
        return true;
    }

    public void deleteBrand(Integer brandId) {
        repository.deleteById(brandId);
    }

    public Brand findBrandById(Integer brandId) {
        return repository.findById(brandId).get();
    }

}
