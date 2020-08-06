package backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.extra.spath.Step;

import backend.presentationlayer.UpdateProductController;
import entity.Account;
import entity.Product;
import utils.JdbcUtils;

public class UserRepository implements IUserRepository {
	private JdbcUtils jdbcUtils;

	public UserRepository() throws IOException {
		jdbcUtils = new JdbcUtils();
	}

	public ResultSet getAccountData(String userName, String passWord)
			throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
		Connection connection = jdbcUtils.connect();
		String sql = "SELECT * FROM `account` WHERE userName=? AND `passWord`=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, userName);
		preparedStatement.setString(2, passWord);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet;
	}

	@Override
	public List<Product> getListProduct()
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		List<Product> products = new ArrayList<Product>();
		Connection connection = jdbcUtils.connect();
		String sql = "SELECT * FROM product";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			Product product = new Product(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
			products.add(product);
		}
		connection.close();
		return products;
	}

	public int createProduct(String code, String name, String price)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection connection = jdbcUtils.connect();
		String sql = "INSERT INTO product VALUES (?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, code);
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, price);
		int status = preparedStatement.executeUpdate();
		return status;
	}

	public int updateProduct(String code, String name, String price)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection connection = jdbcUtils.connect();
		String sql = "UPDATE  product SET name=?, price =? WHERE code=?; ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(3, code);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, price);
		int status = preparedStatement.executeUpdate();
		return status;
	}

	public Product getProductByCode(String code)
			throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
		Connection connection = jdbcUtils.connect();
		String sql = "SELECT * FROM product Where `code`=?" ;
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, code);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		Product product = new Product(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
		return product;
	}
	public int deleteProduct(String code)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection connection = jdbcUtils.connect();
		String sql = "DELETE FROM product WHERE code=?; ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, code);
		int status = preparedStatement.executeUpdate();
		return status;
	} 
}
