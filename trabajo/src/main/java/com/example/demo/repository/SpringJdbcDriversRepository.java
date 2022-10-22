package com.example.demo.repository;
import com.example.demo.domain.driver.Driver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class SpringJdbcDriversRepository implements DriverRepository {
    private final JdbcTemplate jdbcTemplate;

    public SpringJdbcDriversRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Driver> rowMapper = (resultSet, rowNum) -> new Driver(
            resultSet.getString("name"),
            resultSet.getString("email"),
            resultSet.getString("number"),
            resultSet.getString("id_number"),
            resultSet.getString("address")
    );

    @Override
    public List<Driver> list() {
        String sqlQuery = "select * from driver";
        return jdbcTemplate.query(sqlQuery, rowMapper);
    }

    @Override
    public Driver getter(String id) {
        String sqlQuery = "select * from driver where id_number = ?";
        return jdbcTemplate.queryForObject(sqlQuery, rowMapper, id.toString());
    }

    @Override
    public void create(Driver driver) {
        String sqlQuery = "insert into driver(id_number, name, email, number, address) values(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlQuery, ps ->{
            ps.setString(1, String.valueOf(driver.getId()));
            ps.setString(2, driver.getName());
            ps.setString(3, driver.getEmail());
            ps.setString(4, String.valueOf(driver.getNumber()));
            ps.setString(5, driver.getAddress());
        });
    }

    @Override
    public void update(String id, Driver driver) {
        String sqlQuery = "update driver set id_number = ?, name = ?, email = ?, number = ?, address = ?, where id_number = ?";
        jdbcTemplate.update(sqlQuery, ps ->{
            ps.setString(1, String.valueOf(driver.getId()));
            ps.setString(2, driver.getName());
            ps.setString(3, driver.getEmail());
            ps.setString(4, String.valueOf(driver.getNumber()));
            ps.setString(5, driver.getAddress());
            ps.setString(6, String.valueOf(driver.getId()));
        });
    }

    @Override
    public void delete(String id) {
        String sqlQuery = "delete from driver where id_number = ?";
        jdbcTemplate.update(sqlQuery, String.valueOf(id));
    }


}
