package dao.impl;

import bean.Student;
import dao.StudentDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.JDBCUtil;
import util.MyUtil;

import java.sql.SQLException;
import java.util.ArrayList;
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
        return runner.query("select * from stu", new BeanListHandler<Student>(Student.class));

    }

    /**
     * @param sid
     * @return bean.Student
     * @author Zhanghao
     * @date 2019/10/28 10:53
     * @Description: 根据id查询单个学生.一定注意runner.query和runner.update 的参数有区别.
     */
    @Override
    public Student findStudentById(int sid) throws SQLException {

        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        return runner.query("select * from stu where sid=?", new BeanHandler<Student>(Student.class), sid);
    }

    /**
     * @author Zhanghao
     * @date 2019/10/28 15:25
     *
     * @param currentPage
     * @return java.util.List<bean.Student>
     * @Description: 分页查询记录
    */
    @Override
    public List<Student> findStudentByPage(int currentPage) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        //第一个问好代表一页返回多少条记录,第二个问好表示跳过前面的多少条数据.
//        5  0 第一页
//        5  5 第二页
//        5  10 第三页
        return runner.query("select * from stu limit ? offset ?",
                new BeanListHandler<Student>(Student.class), PAGE_SIZE, (currentPage - 1) * PAGE_SIZE);
    }

    /**
     * @author Zhanghao
     * @date 2019/10/28 15:26
     *
     * @param
     * @return int
     * @Description: 返回查询出来的记录数
    */
    @Override
    public int findCount() throws SQLException {

        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        Long result=(Long) runner.query("select count(*) from stu ", new ScalarHandler());
        return result.intValue();
    }

    /**
     * @param name
     * @param gender
     * @return java.util.List<bean.Student>
     * @author Zhanghao
     * @date 2019/10/28 14:30
     * @Description: 模糊查询.
     */
    @Override
    public List<Student> searchStudent(String name, String gender) throws SQLException {

        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());

        String sql = "select * from stu where 1=1";
        List<String> list = new ArrayList<>();

        if (!MyUtil.isEmpty(name)) {
            sql = sql + " and name like ?";
            list.add("%" + name + "%");
        }
        if (!MyUtil.isEmpty(gender)) {
            sql = sql + " and gender like ?";
            list.add(gender);
        }

        return runner.query(sql, new BeanListHandler<Student>(Student.class), list.toArray());

    }

    @Override
    public void insert(Student student) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        runner.update("insert into stu values(null,?,?,?,?,?,?)",
                student.getName(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo()
        );
    }

    @Override
    public void delete(int sid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        runner.update("delete from stu where sid=?", sid);
    }

    @Override
    public void update(Student student) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        runner.update("update stu set name=?,gender=?,phone=?,birthday=?,hobby=?,info=? where sid=?",
                student.getName(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo(),
                student.getSid()
        );
    }
}
