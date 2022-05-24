
package com.example.editorial.controller;

import com.example.editorial.model.Editorial;
import com.example.editorial.service.EditorialService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SAMIR
 */
@RestController
@RequestMapping("/editoriales")
public class EditorialRestController {

    @Autowired
    private EditorialService editorialesService;

    @GetMapping("/all")
    public List<Editorial> getEditorial() {
        return editorialesService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editorial> getEditorial(@PathVariable int id) {
        Editorial post = editorialesService.read(id);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{id}")
    public int deleteEditorial(@PathVariable int id) {
        return editorialesService.delete(id);
    }

    @PostMapping("/add")
    public int addEditorial(@RequestBody Editorial editoriales) {
        System.out.println(editoriales.getNombre());
        System.out.println(editoriales.getPais());
        return editorialesService.create(editoriales);
    }

    @PutMapping("/edit")
    public int editEditorial(@RequestBody Editorial editoriales) {
        Editorial post = new Editorial(editoriales.getIdeditorial(), editoriales.getNombre(), editoriales.getPais());
        System.out.println(editoriales.getIdeditorial() + " , " + editoriales.getNombre() + " , " + editoriales.getPais());
        return editorialesService.update(post);
    }

}
