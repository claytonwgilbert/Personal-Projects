package com.cg.shopme.admin.category;

import com.cg.shopme.common.entity.Category;
import com.cg.shopme.common.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryService {

    public static final int CATEGORIES_PER_PAGE = 6;
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Page<Category> listByPage(int pageNum, String sortField, String sortDir, String keywordSearch){
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();

        Pageable pageable = PageRequest.of(pageNum - 1, CATEGORIES_PER_PAGE, sort);

        if(keywordSearch != null){
            return categoryRepository.findCategoriesThroughSearch(keywordSearch, pageable);
        }
        return categoryRepository.findAll(pageable);
    }

    public List<Category> listCategoriesForForm(){
        List<Category> categoriesForForm = new ArrayList<>();
        Iterable<Category> allCategoriesFromDb = categoryRepository.findAll();

        for(Category category : allCategoriesFromDb){
            if(category.getParent() == null){
                categoriesForForm.add(new Category(category.getId(), category.getName()));
            }
            Set<Category> childrenCat = sortedCategoryChildren(category.getChildren());

            for(Category subCat : childrenCat){
                String name = "--" + subCat.getName();
                categoriesForForm.add(new Category(subCat.getId(), name));

                listChildren(categoriesForForm, subCat, 1);
            }
        }
        return categoriesForForm;
    }

    private void listChildren(List<Category> categoriesForForm, Category parent, int subLevel){
        int newSublevel = subLevel + 1;
        Set<Category> children = sortedCategoryChildren(parent.getChildren());

        for(Category child : children){
            String name  = "-";
            for(int i = 0; i < newSublevel; i++){
                name += "-";
            }
            name += child.getName();

            categoriesForForm.add(new Category(child.getId(), name));
            listChildren(categoriesForForm, child, newSublevel);
        }
    }

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }


    public Category findCategoryById(Integer categoryId) throws CategoryNotFoundException {
        try{
            return categoryRepository.findById(categoryId).get();
        }catch (NoSuchElementException ex){
            throw new CategoryNotFoundException("Sorry, no category with ID of : " + categoryId + " exists.");
        }
    }

    public boolean isCategoryUnique(Integer id, String name, String alias){
        boolean isCreatingNewCategory = (id == null || id == 0);

        Category foundCategory = categoryRepository.findByName(name);

        if(isCreatingNewCategory){
            if(foundCategory != null){
                return false;
            }else{
                foundCategory = categoryRepository.findByAlias(alias);
                if(foundCategory != null){
                    return false;
                }
            }
        }else{
            if(foundCategory != null && foundCategory.getId() != id){
                return false;
            }
            Category foundCategoryByAlias = categoryRepository.findByAlias(alias);
            if(foundCategoryByAlias != null && foundCategoryByAlias.getId() != id){
                return false;
            }
        }
        return true;
    }

    private SortedSet<Category> sortedCategoryChildren(Set<Category> children){
        SortedSet<Category> sortedChildren = new TreeSet<>(new Comparator<Category>() {
            @Override
            public int compare(Category o1, Category o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        sortedChildren.addAll(children);

        return sortedChildren;
    }


    public void deleteCategory(Integer categoryId) throws CategoryNotFoundException {
        try{
            categoryRepository.deleteById(categoryId);
        }catch (NoSuchElementException ex){
            throw new CategoryNotFoundException("No category with id: " + categoryId + " exists.");
        }
    }

    public List<Category> getAllCategories() {
        return (List<Category>) categoryRepository.findAll(Sort.by("name").ascending());
    }
}
