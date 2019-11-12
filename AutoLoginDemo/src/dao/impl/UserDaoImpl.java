package dao.impl;

import dao.UserDao;
import domain.UserBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.JDBCUtil02;

import java.sql.SQLException;


public class UserDaoImpl implements UserDao {

	@Override
	public UserBean login(UserBean user) throws SQLException {
		
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select * from t_user where username = ? and password = ?";
		UserBean query = runner.query(sql, new BeanHandler<>(UserBean.class) , user.getUsername() , user.getPassword());
		return query;
	}

}
