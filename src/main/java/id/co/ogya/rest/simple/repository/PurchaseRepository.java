package id.co.ogya.rest.simple.repository;

import id.co.ogya.rest.simple.config.Purchase;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class PurchaseRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Purchase findByCustomerId(String customerId) {
		String sql = "SELECT tp.ID AS PRODUCT_ID, tp.PRODUCT_NAME , tp.PRICE , tcp.QUANTITY  FROM TBL_CUSTOMER tc " +
				"INNER JOIN TBL_CUSTOMER_PURCHASE tcp ON " +
				"tc.ID = tcp.CUSTOMER_ID " +
				"INNER JOIN TBL_PRODUCT tp  ON " +
				"tp.ID = tcp.PRODUCT_ID " +
				"WHERE tc.ID = ?";
		return jdbcTemplate.queryForObject(sql, new PurcaseRowMapper(), customerId);
	}

	private static class PurcaseRowMapper implements RowMapper<Purchase> {
		public Purchase mapRow(ResultSet rs, int rowNum) throws SQLException {
			Purchase person = new Purchase();
			person.setProductId(rs.getString("product_id"));
			person.setPrice(rs.getDouble("price"));
			person.setQuantity(rs.getInt("quantity"));
			person.setProductName(rs.getString("product_name"));
			return person;
		}
	}
}
