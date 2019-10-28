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
 * @date 2019/10/28 15:10
 * @Description:  一页显示多少条记录
*/
    int PAGE_SIZE=5;

    /**
     * @author Zhanghao
     * @date 2019/10/27 22:13
     * 
     * @param 	
     * @return java.util.List<bean.Student>
     * @Description: 查询所有数据.
    */
    List<Student> findAll() throws SQLException;


    /**
     * @author Zhanghao
     * @date 2019/10/28 10:50
     *
     * @param sid
     * @return bean.Student
     * @Description: 根据id查询单个学生对象.
    */
     Student findStudentById(int sid) throws SQLException;

     
/**
 * @author Zhanghao
 * @date 2019/10/28 15:06
 * 
 * @param currentPage	
 * @return java.util.List<bean.Student>
 * @Description: 查询某页的学生数据
*/
    List<Student> findStudentByPage(int currentPage) throws SQLException;


    /**
     * @author Zhanghao
     * @date 2019/10/28 15:24
     * 
     * @param 	
     * @return int
     * @Description:   查询总的学生记录数.
    */
    int findCount() throws  SQLException;
     
     
     /**
      * @author Zhanghao
      * @date 2019/10/28 14:27
      * 
      * @param sname	
      * @param gender	
      * @return java.util.List<bean.Student>
      * @Description: 根据姓名或者根据性别或者两者兼有,进行模糊查询.
     */
     List<Student> searchStudent(String sname,String gender) throws SQLException;


    /**
     * @author Zhanghao
     * @date 2019/10/28 9:30
     *
     * @param student
     * @return void
     * @Description: 添加学生.
    */
    void insert(Student student) throws SQLException;



    /**
     * @author Zhanghao
     * @date 2019/10/28 10:28
     *
     * @param sid
     * @return void
     * @Description: 根据id删除学生信息.
    */
    void delete(int sid) throws SQLException;

    
    /**
     * @author Zhanghao
     * @date 2019/10/28 14:08
     * 
     * @param student	需要更新的学生数据.
     * @return void
     * @Description: 更新学生信息
    */
    void update(Student student) throws SQLException;
}
