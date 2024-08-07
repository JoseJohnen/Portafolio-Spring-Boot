package com.portafoliojj.portafolio_josejohnen.form;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Repository
public class FormRepository {
    //private final List<Run> runs = new ArrayList<>();
    private static final Logger log = LoggerFactory.getLogger(FormRepository.class);
    private final JdbcClient jdbcClient;

    public FormRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Form> findAll() {
        return jdbcClient.sql("select * from forms")
                .query(Form.class)
                .list();
    }

    public Optional<Form> findById(Integer id) {
        return jdbcClient.sql("SELECT id,nombre,fecha_nacimiento,edad FROM forms WHERE id = :id")
              .param("id",id)
              .query(Form.class)
              .optional();
    }

    public void create(Form form) {
        var updated = jdbcClient.sql("INSERT INTO forms(nombre,fecha_nacimiento,edad) values (?,?,?)")
                .params(List.of(form.nombre(), form.fecha_nacimiento(), form.edad()))
                .update();

        Assert.state(updated == 1, "Failed to create form " + form.nombre());
    }

    public void update(Form form, Integer id) {
        var updated = jdbcClient.sql("UPDATE forms SET nombre=?, fecha_nacimiento=?, edad=? where id = ?")
                .params(List.of(form.nombre(), form.fecha_nacimiento(), form.edad(), id))
                .update();

        Assert.state(updated == 1, "Failed to update form " + form.nombre());
    }

    public void delete(Integer id) {
        var updated = jdbcClient.sql("delete from forms where id = :id")
                .param("id", id)
                .update();

        Assert.state(updated == 1, "Failed to delete form " + id);
    }

    public int count() {
        return jdbcClient.sql("select * from forms").query().listOfRows().size();
    }

    public void saveAll(List<Form> runs) {
        runs.stream().forEach(this::create);
    }
}
