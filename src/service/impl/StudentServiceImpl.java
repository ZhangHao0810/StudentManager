package service.impl;

import bean.PageBean;
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

    @Override
    public Student findStudentById(int sid) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.findStudentById(sid);
    }

    @Override
    public PageBean findStudentByPage(int currentPage) throws SQLException {
//        封装该页的分页数据.
        PageBean<Student> pageBean = new PageBean<>();

        int pageSize = StudentDao.PAGE_SIZE;

        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);

        StudentDao studentDao = new StudentDaoImpl();
        List<Student> list = studentDao.findStudentByPage(currentPage);
        pageBean.setList(list);

        int count = studentDao.findCount();
        pageBean.setTotalSize(count);

        pageBean.setTotalPage(count % pageSize == 0 ? count /pageSize: (count / pageSize) + 1);

        return pageBean;
    }

    @Override
    public List<Student> searchStudent(String name, String gender) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.searchStudent(name, gender);
    }

    @Override
    public void insert(Student student) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.insert(student);
    }

    @Override
    public void delete(int sid) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.delete(sid);
    }

    @Override
    public void update(Student student) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.update(student);
    }
}
