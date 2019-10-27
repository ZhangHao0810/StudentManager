package dao.impl;

import bean.Student;
import dao.StudentDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.JDBCUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ZhangHao
 * @date 2019/10/27 22:14
 * @Description： StudentDao的实现.
 * 自定义了一个JDBC的工具类,使用连接池维护连接.
 * c3p0是数据库连接池,DBUtil是JDBC的简化操作.
 */
public class StudentDaoImpl implements StudentDao {

    /**
     * @param
     * @return java.util.List<bean.Student>
     * @author Zhanghao
     * @date 2019/10/27 22:20
     * @Description: 查询所有学生
     */
    @Override
    public List<Student> findAll() throws SQLException {

//     用了DBUtil之后,就不用配置ps了,简化了JDBC的使用.

        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        runner.query("select * from stu",new BeanListHandler<Student>(Student.class));

        return null;
    }
}
