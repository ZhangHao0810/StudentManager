package servlet;

import bean.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author： ZhangHao
 * @date： 2019/10/28 14:24
 * @Description：
 */
public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        try {
//        取到关键的查询信息.
            String name = request.getParameter("name");
            String gender = request.getParameter("gender");

//        找Service去查询.
            StudentService service = new StudentServiceImpl();
            List<Student> list = service.searchStudent(name, gender);

            request.setAttribute("list",list);

//        跳转界面
            request.getRequestDispatcher("list.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

