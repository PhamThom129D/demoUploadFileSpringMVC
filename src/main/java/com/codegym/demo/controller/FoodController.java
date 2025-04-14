package com.codegym.demo.controller;

import com.codegym.demo.model.Food;
import com.codegym.demo.model.FoodForm;
import com.codegym.demo.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/manageFood")
public class FoodController {
//    @Value("${file-upload}")
//    private String fileUpload;

    private String fileUpload = "A:\\\\SpringMVC\\\\demo\\\\src\\\\main\\\\resources\\\\uploadFile\\\\";

    @Autowired
    private final IFoodService foodService;

    public FoodController(IFoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public String showListFood(Model model) {
        model.addAttribute("foods",foodService.getFoods());
        return "manageFood/list";
    }
    @GetMapping("/showAddForm")
    public String showAddForm(Model model) {
        model.addAttribute("food", new FoodForm());
        return "manageFood/add";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute FoodForm foodForm) {
        List<MultipartFile> multipartFiles = foodForm.getPath_image();
        List<String> pathFileNames = new ArrayList<>();
        for (MultipartFile file : multipartFiles) {
            if(!file.isEmpty()){
                String fileName = file.getOriginalFilename();
                try{
                    File dir = new File(fileUpload);
                    if(!dir.exists()){
                        dir.mkdirs();
                    }
                    File uploadedFile = new File(fileUpload + File.separator + fileName);
                    FileCopyUtils.copy(file.getInputStream(),new FileOutputStream(uploadedFile));
                    pathFileNames.add(fileName);
                    System.out.println("Cập nhật file thành công: " + fileName);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        Food food = new Food(
                foodForm.getId(),
                foodForm.getName(),
                pathFileNames
        );
        foodService.addFood(food);
        return "redirect:/manageFood";

    }
    @GetMapping("/image/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> getImage(@PathVariable String filename) throws IOException {
        Path imagePath = Paths.get("src/main/resources/uploadFile/" + filename);

        if (!Files.exists(imagePath)) {
            return ResponseEntity.notFound().build();
        }

        Resource resource = new UrlResource(imagePath.toUri());

        String contentType = Files.probeContentType(imagePath);
        if (contentType == null) {
            contentType = "application/octet-stream"; // fallback nếu không xác định được
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }


}
