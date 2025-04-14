package com.codegym.demo.controller;

import com.codegym.demo.model.Phone;
import com.codegym.demo.model.PhoneForm;
import com.codegym.demo.service.PhoneService;
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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/managePhone")
public class ManagePhoneController {
    @Value("${file-upload}")
    private String fileUpload;

    //    private String fileUpload = " A:\\\\SpringMVC\\\\demo\\\\src\\\\main\\\\resources\\\\uploadFile\\\\";
    @Autowired
    private final PhoneService phoneService;

    public ManagePhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("phones", phoneService.getAllPhone());
        return "managePhone/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("phone", new Phone());
        return "managePhone/add";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute PhoneForm phoneForm, Model model) {
        MultipartFile[] multipartFiles = phoneForm.getPhoneImage();
        List<String> fileNames = new ArrayList<>();

        for (MultipartFile file : multipartFiles) {
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                try{
                    File dir = new File(fileUpload);
                    if(!dir.exists()){
                        dir.mkdirs();
                    }
                    File uploadedFile = new File(fileUpload + File.separator + fileName);
                    FileCopyUtils.copy(file.getInputStream(),new FileOutputStream(uploadedFile));
                    fileNames.add(fileName);
                    System.out.println("Thêm file thành công " + fileName);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        Phone phone = new Phone(
                phoneForm.getPhoneID(),
                phoneForm.getPhoneName(),
                phoneForm.getPhonePrice(),
                phoneForm.getPhoneQuantity(),
                fileNames
        );
        phoneService.addPhone(phone);
        return "redirect:/managePhone";

    }
}
