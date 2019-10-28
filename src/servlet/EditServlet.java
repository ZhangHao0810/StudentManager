package servlet;

import bean.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author： ZhangHao
 * @date： 2019/10/28 10:47
 * @Description： 查询一个学生的信息, 跳转到更新界面.
 */
public class EditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            接收id
            int sid = Integer.parseInt(request.getParameter("sid"));
//            查询学生数据
            StudentService service = new StudentServiceImpl();
            Student stu = service.findStudentById(sid);

//            显示数据
            request.setAttribute("stu",stu);
//            跳转
            request.getRequestDispatcher("edit.jsp").forward(request,response);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
