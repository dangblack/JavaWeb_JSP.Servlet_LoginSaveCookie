package backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entity.Account;
import entity.Product;

public interface IUserRepository {
	ResultSet getAccountData(String userName, String passWord) throws SQLException, FileNotFoundException, ClassNotFoundException, IOException;
	List<Product> getListProduct() throws SQLException, FileNotFoundException, ClassNotFoundException, IOException;
	int createProduct(String code, String name, String price) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	int updateProduct(String code, String name, String price) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	Product getProductByCode(String code) throws SQLException, FileNotFoundException, ClassNotFoundException, IOException;
	int deleteProduct(String code) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
}

