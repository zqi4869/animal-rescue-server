package com.animal.adoption.controller;

import com.animal.adoption.domain.ImageFile;
import com.animal.adoption.domain.User;
import com.animal.adoption.service.UserService;
import com.animal.adoption.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Value("${upload.path}")
    public String uploadPath;

    @GetMapping("/info")
    public RestResult getInfo(String username) {
        return RestResult.success(userService.findUserByUsername(username));
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('admin')")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/save")
    public RestResult save(@RequestBody User user) {
        return RestResult.success(userService.save(user));
    }

    @PutMapping("/update")
    public RestResult update(@RequestBody User user) {
        return RestResult.success(userService.update(user));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public String deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
        return "";
    }

    @PostMapping("/upload")
    public RestResult mobileUpload(@RequestBody ImageFile image) {
        try {
            return RestResult.success(image.saveToFile(uploadPath));
        } catch (Exception e) {
            e.printStackTrace();
            return RestResult.error("Failed to upload file");
        }
    }

    @PostMapping("/pc/upload")
    public RestResult pcUpload(@RequestParam("file") MultipartFile myfile) {
        try {
            String name = System.currentTimeMillis() + myfile.getOriginalFilename().substring(myfile.getOriginalFilename().indexOf("."));
            myfile.transferTo(new File(uploadPath + name));
            return RestResult.success(name);
        } catch (Exception e) {
            e.printStackTrace();
            return RestResult.error("Failed to upload file");
        }
    }
}
