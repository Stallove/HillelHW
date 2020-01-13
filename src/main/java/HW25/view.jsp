<%@ page import="HW25.DBD" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.*" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>View all students</title>
</head>
<body>
<%
    String URL = "jdbc:mysql://localhost:3306/univer";
    String USERNAME = "root";
    String PASSWORD = "000898";

    Connection connection;
    Statement statement;

    Class.forName("com.mysql.cj.jdbc.Driver");
    connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    statement = connection.createStatement();

    DBD dbd =  new DBD();

    ArrayList<String> studentsList = dbd.getAllStudentsList();
    int[] ids = dbd.getAllStudentsId(studentsList);

    out.println("<form>");
    for(int i = 0; i < ids.length; i++ ) {
        out.print("<input type=\"checkbox\" value=\"" + ids[i] + "\">" + studentsList.get(i) + "</input>");
    }

    out.println("</form>");

    dbd.close();
%>
</body>
</html>