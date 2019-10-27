package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description:    使用c3p0连接池,来维护数据库的链接.用xml配置文件的方式.
 * @author          ZhangHao
 * @CreateDate:     2019/10/27 22:29
*/
public class JDBCUtil {
	
	static ComboPooledDataSource dataSource = null;
	static{
		dataSource = new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	/**
	 * 获取连接对象
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConn() throws SQLException{
		return dataSource.getConnection();
	}
	
	/**
	 * 释放资源
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void release(Connection conn , Statement st , ResultSet rs){
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}
	public static void release(Connection conn , Statement st){
		closeSt(st);
		closeConn(conn);
	}

	
	private static void closeRs(ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			rs = null;
		}
	}
	
	private static void closeSt(Statement st){
		try {
			if(st != null){
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			st = null;
		}
	}
	
	private static void closeConn(Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn = null;
		}
	}
}
