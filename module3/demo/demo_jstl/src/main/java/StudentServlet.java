import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet",urlPatterns = {"/student","/sinh-vien"})
public class StudentServlet extends HttpServlet {
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"chanh",true,"12/12/2022",8,"chanhtv",1,"chanhtv@1"));
        studentList.add(new Student(2,"hậu",false,"12/12/2022",7,"chanhtv",1,"chanhtv@1"));
        studentList.add(new Student(3,"chanh",true,"12/12/2022",3,"chanhtv",1,"chanhtv@1"));
        studentList.add(new Student(4,"chanh",true,"12/12/2022",5,"chanhtv",1,"chanhtv@1"));
        studentList.add(new Student(5,"chanh",true,"12/12/2022",9,"chanhtv",1,"chanhtv@1"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("studentList",studentList);
        request.getRequestDispatcher("views/list.jsp").forward(request,response);
    }
}
