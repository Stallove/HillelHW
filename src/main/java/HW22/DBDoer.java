package HW22;

import java.sql.*;

public class DBDoer {
    private static final String URL = "jdbc:mysql://localhost:3306/univer";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "000898";

    private static Connection connection;
    private static Statement statement;

    public DBDoer() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() throws SQLException {
        statement.close();
        connection.close();
    }

    public void getAllStudents() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM students_tb;");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " "
                    + resultSet.getString("lastname") + ", "
                    + resultSet.getString("group_id") + " group" + ", "
                    + resultSet.getString("year_of_admission" ) + " year");
        }
    }

    public void getStudentsByGroup(int group_id) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from students_tb" +
                " where group_id = " + group_id + ";");

        while (resultSet.next()){
            System.out.println(resultSet.getString("name") + " "
                    + resultSet.getString("lastname") + ", "
                    + resultSet.getString("group_id") + " group" + ", "
                    + resultSet.getString("year_of_admission" ) + " year");
        }
    }

    public void getStudentsByYear(int year_of_admission) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * " +
                "FROM students_tb where year_of_admission = " + year_of_admission + ";");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " "
                    + resultSet.getString("lastname") + ", "
                    + resultSet.getString("group_id") + " group" + ", "
                    + resultSet.getString("year_of_admission" ) + " year");
        }
    }
    
    public void getStudentLessonsMarksAndTeachers(int id) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select students_tb.name, students_tb.lastname, lectures_tb.name as lecture,  concat(lecturers_tb.first_name, ' ', lecturers_tb.last_name) as lecturer " +
                "from students_tb " +
                "left join grades_tb on grades_tb.student_id = students_tb.id " +
                "left join lectures_tb on grades_tb.lecture_id = lectures_tb.id " +
                "left join lecturers_tb on lectures_tb.lecturer_id = lecturers_tb.id " +
                "where students_tb.id = " + id + ";");
        while (resultSet.next()){
            System.out.println(resultSet.getString("name") + " "
                    + resultSet.getString("lastname") + ", "
                    + " lecture: " + resultSet.getString("lecture") + ", "
                    + " lecturer: " + resultSet.getString("lecturer"));
        }
    }

    public void getStudentsAverage(int id) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select name, lastname, avg(grade) " +
                "from grades_tb " +
                "left join students_tb on grades_tb.student_id = students_tb.id " +
                "where students_tb.id = " + id + ";");
        while (resultSet.next()) {
            System.out.println("Name: " +  resultSet.getString("name") + " " + resultSet.getString("lastname")
                    + ", average grade = " +  resultSet.getDouble("avg(grade)"));
        }
    }
}
