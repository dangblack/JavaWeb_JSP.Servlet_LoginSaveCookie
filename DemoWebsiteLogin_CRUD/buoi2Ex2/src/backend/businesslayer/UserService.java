      package backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import backend.datalayer.IUserRepository;
import backend.datalayer.UserRepository;
import entity.Account;
import entity.Product;

public class UserService implements IUserService {
	private IUserRepository userRepository;
	
	public UserService () throws IOException {
		userRepository=new UserRepository();
	}

	@Override
	public ResultSet getAccountData(String userName, String passWord) throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		return userRepository.getAccountData(userName, passWord);
	}

	@Override
	public List<Product> getListProduct()
			throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
		return userRepository.getListProduct();
	}

	@Override
	public int createProduct(String code, String name, String price)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		return userRepository.createProduct(code, name, price);
	}

	@Override
	public int updateProduct(String code, String name, String price)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		return userRepository.updateProduct(code, name, price);
	}

	@Override
	public Product getProductByCode(String code) throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		return userRepository.getProductByCode(code);
	}

	@Override
	public int deleteProduct(String code) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		return userRepository.deleteProduct(code);
	}

	


		
}
