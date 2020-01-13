package HW25;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/view")
public class View extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        DBD dbd = null;
        try {
            dbd = new DBD();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        ArrayList<String> studentsList = null;
        try {
            studentsList = dbd.getAllStudentsList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int[] ids = dbd.getAllStudentsId(studentsList);

        writer.println("<form>");
        for(int i = 0; i < ids.length; i++ ) {
            writer.print("<input type=\"checkbox\" value=\"" + ids[i] + "\">" + studentsList.get(i) + "</input>");
        }

        writer.println("</form>");

        try {
            dbd.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}