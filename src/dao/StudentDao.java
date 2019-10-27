package dao;

import bean.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ZhangHao
 * @date 2019/10/27 22:06
 * @Description： 针对学生表的数据库操作
 */
public interface StudentDao {


    /**
     * @author Zhanghao
     * @date 2019/10/27 22:13
     * 
     * @param 	
     * @return java.util.List<bean.Student>
     * @Description: 查询所有数据.
    */
    List<Student> findAll() throws SQLException;
}
