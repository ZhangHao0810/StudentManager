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
 * @date： 2019/10/28 14:06
 * @Description：
 */
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");

//            获取客户端提交上来的数据.
            int sid = Integer.parseInt(request.getParameter("sid"));
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
            hobby = hobby.substring(1, hobby.length() - 1);

//            数据添加到数据库.
//        String->Date
            Date date = null;

            date = new SimpleDateFormat("yyy-MM-dd").parse(birthday);

            Student student = new Student(sid,name, gender, phone, hobby, info, date);

//            更新数据库的数据
            StudentService service= new StudentServiceImpl();
            service.update(student);

//            跳转
            request.getRequestDispatcher("StudentListServlet").forward(request,response);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
