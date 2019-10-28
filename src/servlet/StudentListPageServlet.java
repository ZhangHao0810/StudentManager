package servlet;

import bean.PageBean;
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
 * @date： 2019/10/28 15:01
 * @Description： 用于分页显示学生列表的Servlet
 */
public class StudentListPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//        获取需要现实的页码数字
            int currentPage = Integer.parseInt(request.getParameter("currentPage"));

//        获取数据
            StudentService service = new StudentServiceImpl();
            PageBean pageBean = service.findStudentByPage(currentPage);

            request.setAttribute("pageBean", pageBean);
//        跳转页面
            request.getRequestDispatcher("list_page.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
