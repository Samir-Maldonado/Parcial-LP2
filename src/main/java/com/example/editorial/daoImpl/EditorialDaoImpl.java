
package com.example.editorial.daoImpl;

import com.example.editorial.dao.EditorialDao;
import com.example.editorial.model.Editorial;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SAMIR
 */
@Repository
public class EditorialDaoImpl implements EditorialDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int create(Editorial editoriales) {
        String SQL ="INSERT INTO editoriales(nombre, pais) VALUES(?,?)";
        return jdbcTemplate.update(SQL,new Object[]{editoriales.getNombre(),editoriales.getPais()});
    }
    @Override
    public int update(Editorial editoriales) {
        String SQL ="UPDATE editoriales SET nombre=?, pais=? WHERE ideditorial=?";                 
        return jdbcTemplate.update(SQL,new Object[]{editoriales.getNombre(), editoriales.getPais(), editoriales.getIdeditorial()});
    }
    @Override
    public int delete(int id) {
        String SQL ="DELETE FROM editoriales WHERE ideditorial=?"; 
        return jdbcTemplate.update(SQL,id);
    }
    @Override
    public Editorial read(int id) {
        String SQL ="SELECT *FROM editoriales WHERE ideditorial=?";
        try {
            Editorial editoriales = jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(Editorial.class),id);
            return editoriales;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Editorial> readAll() {
        String SQL ="SELECT ideditorial, nombre, pais FROM editoriales ORDER BY ideditorial ASC";        
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Editorial.class));
    }
    
}
