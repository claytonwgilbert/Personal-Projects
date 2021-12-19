package com.cg.shopme.admin.brand;

import com.cg.shopme.admin.FileUploadUtil;
import com.cg.shopme.admin.category.CategoryCsvExporter;
import com.cg.shopme.admin.category.CategoryService;
import com.cg.shopme.admin.user.UserNotFoundException;
import com.cg.shopme.common.entity.Brand;
import com.cg.shopme.common.entity.Category;
import com.cg.shopme.common.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class BrandController {

    private BrandService brandService;
    private CategoryService categoryService;

    public BrandController(BrandService brandService, CategoryService categoryService) {
        this.brandService = brandService;
        this.categoryService = categoryService;
    }

    @GetMapping("/brands")
    public String displayBrandsHome(Model model){
        model.addAttribute("brands", brandService.getAllBrands());

        return "/brands/brands";
    }


    @GetMapping("/brands/search")
    public String searchBrands(@RequestParam(name="keyword") String searchTerm, Model model){
        if(searchTerm.isEmpty()){
            return "redirect:/brands";
        }

        List<Brand> foundBrands = brandService.findBrandByName(searchTerm);
        model.addAttribute("brands", foundBrands);

        return "/brands/brands";
    }

    @GetMapping("/brands/new")
    public String displayCreateBrandForm(Model model){
        model.addAttribute("brand", new Brand());
        model.addAttribute("categories", categoryService.listCategoriesForForm());

        return "/brands/brand_new_form";
    }

    @PostMapping("/brands/save")
    public String saveNewBrand(Brand brand, @RequestParam("fileImage") MultipartFile multipartFile, RedirectAttributes redirectAttributes) throws IOException {
        if(!multipartFile.isEmpty()){
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename()); // - Get simple filename
            fileName = fileName.replace(' ', '-'); // - Remove space and replace with dash
            brand.setLogo(fileName); // - Assign photo to brand from form

            Brand newBrandWithPhoto = brandService.saveBrand(brand);
            String uploadDir = "../brand-photos/" + newBrandWithPhoto.getId(); // - Create directory path for logo

            FileUploadUtil.cleanDirectory(uploadDir); // - Remove old photos before adding new one...
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile); // - Save new photo for brand
        }else{
            this.brandService.saveBrand(brand);
        }

        redirectAttributes.addFlashAttribute("message", "The brand was saved successfully.");

        return "redirect:/brands";
    }

    @GetMapping("/brands/edit/{id}")
    public String editExistingBrand(@PathVariable("id") Integer brandId, Model model, RedirectAttributes redirectAttributes){
        Brand brand = new Brand();
        brand = this.brandService.findBrandById(brandId);

        model.addAttribute("brand", brand);
        model.addAttribute("categories", categoryService.listCategoriesForForm());
        model.addAttribute("pageTitle", "Edit Brand (ID: " + brandId +")");

        return "/brands/brand_edit_form";
    }

    @GetMapping("/brands/delete/{id}")
    public String deleteBrand(@PathVariable("id") Integer brandId, RedirectAttributes redirectAttributes){
        brandService.deleteBrand(brandId);
        redirectAttributes.addFlashAttribute("message", "Deleting brand with ID of " + brandId + " was deleted successfully.");

        return "redirect:/brands";
    }

    @GetMapping("/brands/export/csv")
    public void exportBrandsToCsv(HttpServletResponse httpServletResponse) throws IOException {
        BrandCsvExporter exporter = new BrandCsvExporter();
        exporter.export(brandService.getAllBrands(), httpServletResponse);
    }



}
