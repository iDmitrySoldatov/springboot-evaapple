package ru.dmitrysoldatov.evaapple.controllers;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitrysoldatov.evaapple.dto.CategoriesDTO;
import ru.dmitrysoldatov.evaapple.exception.ResourceNotFoundException;
import ru.dmitrysoldatov.evaapple.services.CategoriesService;


import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CategoriesController {

    private CategoriesService service;

    @Autowired
    public CategoriesController(CategoriesService service) {
        this.service = service;
    }

    @GetMapping("/categories")
    public List<CategoriesDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoriesDTO> getCategories(@PathVariable Integer id) {
        CategoriesDTO categories = service.findById(id);
        if (categories == null) {
            throw new ResourceNotFoundException("Categories not exist with id :" + id);
        } else {
            return ResponseEntity.ok(categories);
        }
    }

    @PostMapping("/categories")
    public CategoriesDTO createCategories(@RequestBody CategoriesDTO categoriesDTO) {
        return service.save(categoriesDTO);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoriesDTO> updateCategories(@PathVariable Integer id,
                                                          @RequestBody CategoriesDTO categoriesDTO) {
        CategoriesDTO categories = service.findById(id);
        if (categories == null) {
            throw new ResourceNotFoundException("Categories not exist with id :" + id);
        } else {
            categories.setParentId(categoriesDTO.getParentId());
            categories.setName(categoriesDTO.getName());

            CategoriesDTO upadateCategories = service.save(categories);
            return ResponseEntity.ok(upadateCategories);
        }
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCategories(@PathVariable Integer id) {
        CategoriesDTO categories = service.findById(id);
        if (categories == null) {
            throw new ResourceNotFoundException("Categories not exist with id :" + id);
        } else {
            service.deleteById(id);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
        }
    }

    @RequestMapping(value = "/images/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImageCategories(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        String filePath = "/home/dmitry/" + id + ".jpg";
//        try {
//            File file = new File(filePath);
//            byte[] bytes = FileUtils.readFileToByteArray(file);
//
//            return ResponseEntity
//                    .ok()
//                    .contentType(MediaType.IMAGE_JPEG)
//                    .body(bytes);
//        }catch (FileNotFoundException e) {
//            throw new ResourceNotFoundException("Images not exist with id :" + id);
//        }
        try {
            InputStream inputStream = new FileInputStream(new File(filePath));
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            IOUtils.copy(inputStream, response.getOutputStream());
        } catch (FileNotFoundException e) {
            throw new ResourceNotFoundException("Images not exist with id :" + id);
        }
    }
}
