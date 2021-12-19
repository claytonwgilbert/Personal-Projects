package com.cg.shopme.admin.category;

import com.cg.shopme.admin.FileUploadUtil;
import com.cg.shopme.admin.user.UserCsvExporter;
import com.cg.shopme.admin.user.UserNotFoundException;
import com.cg.shopme.common.entity.Category;
import com.cg.shopme.common.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String showFirstPage(Model model){
        return listByPage(1,"name", "asc", null, model);
    }

    @GetMapping("/categories/page/{number}")
    public String listByPage(@PathVariable(name="number") int pageNumber, @RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, @RequestParam(name="keyword", required = false) String searchTerm, Model model){
        Page<Category> categoryPage = categoryService.listByPage(pageNumber, sortField, sortDir, searchTerm);
        List<Category> categories = categoryPage.getContent();

        long startCount = (pageNumber - 1) * CategoryService.CATEGORIES_PER_PAGE + 1;
        long endingCount = startCount + CategoryService.CATEGORIES_PER_PAGE - 1;
        if(endingCount > categoryPage.getTotalElements()){
            endingCount = categoryPage.getTotalElements();
        }

        String reverseSortOrder = sortDir.equals("asc") ? "desc" : "asc";

        model.addAttribute("startCount", startCount);
        model.addAttribute("endingCount", endingCount);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalElements", categoryPage.getTotalElements());
        model.addAttribute("totalPages", categoryPage.getTotalPages());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", reverseSortOrder);
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("categories", categories);

        return "categories/categories";
    }


    @GetMapping("/categories/new")
    public String showNewCategoryForm(Model model){
        List<Category> categories = categoryService.listCategoriesForForm();

        model.addAttribute("category", new Category());
        model.addAttribute("categories", categories);

        return "categories/category_new_form";
    }

    @PostMapping("/categories/save")
    public String saveCategory(Category category, @RequestParam("fileImage") MultipartFile multipartFile, RedirectAttributes redirectAttributes) throws IOException {
        if(!multipartFile.isEmpty()){
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename()); // - Get simple filename
            fileName = fileName.replace(' ', '-'); // - Remove space and replace with dash
            category.setImage(fileName); // - Assign photo to category from form

            Category newCategoryWithPhoto = categoryService.saveCategory(category);
            String uploadDir = "../category-photos/" + newCategoryWithPhoto.getId(); // - Create directory path for photo

            FileUploadUtil.cleanDirectory(uploadDir); // - Remove old photos before adding new one...
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile); // - Save new photo for category
        }else{
            this.categoryService.saveCategory(category);
        }

        redirectAttributes.addFlashAttribute("message", "The category was saved successfully.");

        return "redirect:/categories";
    }

    @GetMapping("/categories/edit/{id}")
    public String updateCategoryForm(@PathVariable("id") Integer categoryId, Model model, RedirectAttributes redirectAttributes) throws CategoryNotFoundException {
        Category category = new Category();
        Category parent = category.getParent();
        try {
            category = this.categoryService.findCategoryById(categoryId);
            model.addAttribute("category", category);
            model.addAttribute("parentCategory", parent);
            model.addAttribute("categories", categoryService.listCategoriesForForm());
            model.addAttribute("pageTitle", "Edit Category (ID: " + category.getId() + ")");

            return "categories/category_edit_form";
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:/categories";
        }
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable("id") Integer categoryId, RedirectAttributes redirectAttributes) throws CategoryNotFoundException {
        try {
            categoryService.deleteCategory(categoryId);
            redirectAttributes.addFlashAttribute("message", "Deleting category with ID of " + categoryId + " was deleted successfully.");
        }catch (CategoryNotFoundException ex){
            redirectAttributes.addFlashAttribute("message", ex.getMessage());
            return "redirect:/categories";
        }
        return "redirect:/categories";
    }

    @GetMapping("/categories/export/csv")
    public void exportCategoryToCsv(HttpServletResponse httpServletResponse) throws IOException {
        CategoryCsvExporter exporter = new CategoryCsvExporter();
        exporter.export(categoryService.getAllCategories(), httpServletResponse);
    }

}
