package com.codegym.demo.controller;

import com.codegym.demo.model.Product;
import com.codegym.demo.model.ProductForm;
import com.codegym.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/upload")
public class UploadController {
    @Value("${file-upload}")
    private String fileUpload;

    private final IProductService productService;

    @Autowired
    public UploadController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ModelAndView showForm(Model model) {
        ModelAndView view = new ModelAndView("upload/uploadFile");
        model.addAttribute("productForm", new ProductForm());
        return view;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute ProductForm productForm) {
        MultipartFile[] multipartFiles = productForm.getProductImage();

        List<String> uploadedFileNames = new ArrayList<>();

        for (MultipartFile file : multipartFiles) {
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                try {
                    File desDir = new File(fileUpload);
                    if (!desDir.exists()) {
                        desDir.mkdirs();
                    }
                    File uploadFile = new File(fileUpload + File.separator + fileName);
                    FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(uploadFile));
                    uploadedFileNames.add(fileName);
                    System.out.println("Upload thành công file: " + fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Upload thất bại: " + file.getOriginalFilename(), e);
                }
            }
        }


        Product product = new Product(
                productForm.getProductID(),
                productForm.getProductName(),
                productForm.getProductPrice(),
                productForm.getProductQuantity(),
                uploadedFileNames
        );

        productService.addProduct(product);

        ModelAndView modelAndView = new ModelAndView("redirect:/");
        modelAndView.addObject("productForm", productForm);
        modelAndView.addObject("message", "Product has been created");
        return modelAndView;
    }
}
