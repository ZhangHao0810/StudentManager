package servlet;

import bean.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author： ZhangHao
 * @date： 2019/10/28 9:25
 * @Description： 用于处理学生的添加请求.
 */
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");

//            获取客户端提交上来的数据.
            String name = request.getParameter("name");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            String birthday = request.getParameter("birthday");
            String info = request.getParameter("info");
//            因为hobby是一个复选框,但是getParameter永远只能取到第一个值.所以要把这里改一下.
//            String hobby = request.getParameter("hobby");
            String[] hobbies = request.getParameterValues("hobby");
//            [lanqiu,zuqiu,xiezi]---lanqiu,zuqiu,xiezi

            String hobby = Arrays.toString(hobbies);
            hobby = hobby.substring(1, hobby.length()-1);

//            数据添加到数据库.
//        String->Date
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);

            Student student = new Student(name, gender, phone, hobby, info, date);
            StudentService service = new StudentServiceImpl();
            service.insert(student);

//            跳转到列表列.
//            这里直接跳转到页面上,这个页面会重新翻译一次,上面的那个request的请求存放的数据是没有了.所以最好是跳转到另一个Servlet,这个Servlet再请求转发到jsp.
//            request.getRequestDispatcher("list.jsp").forward(request,response);
            request.getRequestDispatcher("StudentListServlet").forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
