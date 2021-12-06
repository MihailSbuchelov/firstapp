package ru.gb.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.gb.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


//@Component
@RequiredArgsConstructor
public class NamedParameterJdbcTemplateProductDaoImpl implements ProductDao {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Iterable<Product> findAll() {
        String sql = "SELECT * FROM product";
        return namedParameterJdbcTemplate.query(sql, new ProductMapper());
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public String findTitleById(Long id) {
        String sql = "select title from product where id=:productId";
        HashMap<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productId", id);

        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
    }

    private static class ProductMapper implements RowMapper<Product> {

        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Product.builder()
                    .id(rs.getLong("id"))
                    .cost(rs.getBigDecimal("cost"))
                    .title(rs.getString("title"))
                    .id(rs.getLong("manufacturer_id"))
                    .build();
        }
    }
}
