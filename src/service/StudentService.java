package service;

import bean.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ZhangHao
 * @date 2019/10/27 22:34
 * @Description： 这是学生的业务处理规范.基本上dao有啥,service就有啥.
 */
public interface StudentService {


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
