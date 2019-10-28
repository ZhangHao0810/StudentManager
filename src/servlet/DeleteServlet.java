package servlet;

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
 * @date： 2019/10/28 10:24
 * @Description： 有一个属性sid,然后那他调用service的delete方法执行删除(service调用了dao的delete方法).再次返回页面进行显示.显示应该默认执行查询操作,所以请求转发到StudentServlet.
 */
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            Integer sid = Integer.valueOf(request.getParameter("sid"));

            StudentService service = new StudentServiceImpl();
            service.delete(sid);

            //再次显示
            request.getRequestDispatcher("StudentListServlet").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
