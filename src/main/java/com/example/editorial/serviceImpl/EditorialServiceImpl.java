
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.editorial.serviceImpl;

import com.example.editorial.dao.EditorialDao;
import com.example.editorial.model.Editorial;
import com.example.editorial.service.EditorialService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SAMIR
 */
@Service
public class EditorialServiceImpl implements EditorialService {
    @Autowired
    private EditorialDao editorialesDao;
    @Override
    public int create(Editorial editoriales) {
        return editorialesDao.create(editoriales);
    }
    @Override
    public int update(Editorial editoriales) {
        return editorialesDao.update(editoriales);
    }
    @Override
    public int delete(int id) {
        return editorialesDao.delete(id);
    }
    @Override
    public Editorial read(int id) {
        return editorialesDao.read(id);
    }
    @Override
    public List<Editorial> readAll() {
        return editorialesDao.readAll();
    }
}
