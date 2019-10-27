package service.impl;

import bean.Student;
import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import service.StudentService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ZhangHao
 * @date 2019/10/27 22:35
 * @Description： 这是学生业务实现. 把这个业务功能从Servlet中剥离.
 */
public class StudentServiceImpl implements StudentService {

    /**
     * @param
     * @return java.util.List<bean.Student>
     * @author Zhanghao
     * @date 2019/10/27 22:37
     * @Description: 返回所有的学生. 这是业务层的,去dao层找.
     */
    @Override
    public List<Student> findAll() throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.findAll();
    }
}
