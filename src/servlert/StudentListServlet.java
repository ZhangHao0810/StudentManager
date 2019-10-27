package servlert;

import bean.Student;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author： ZhangHao
 * @date： 2019/10/27 22:05
 * @Description： 负责查询所有的学生信息,呈现在页面上.
 */
public class StudentListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            StudentServiceImpl service = new StudentServiceImpl();
            List<Student> studentList = service.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
