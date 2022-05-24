
package com.example.editorial.service;

import com.example.editorial.model.Editorial;
import java.util.List;

/**
 *
 * @author SAMIR
 */
public interface EditorialService {
    int create(Editorial editoriales);
    int update(Editorial editoriales);
    int delete(int id);
    Editorial read(int id);
    List<Editorial> readAll();
}
