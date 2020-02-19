package HW25;

import java.sql.*;
import java.util.ArrayList;

public class DBD {
    private static final String URL = "jdbc:mysql://localhost:3306/univer";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "000898";

    private static Connection connection;
    private static Statement statement;

    public DBD() throws ClassNotFoundException {
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
        resultSet.close();
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
        resultSet.close();
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
        resultSet.close();
    }

    public void getStudentLessonsMarksAndTeachers(int id) throws SQLException {
        ResultSet resultSet = statement.executeQuery
                ("select students_tb.name, students_tb.lastname, lectures_tb.name as lecture,  concat(lecturers_tb.first_name, ' ', lecturers_tb.last_name) as lecturer " +
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
        resultSet.close();
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
        resultSet.close();
    }

    public ArrayList<String> getAllStudentsList() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM students_tb;");
        ArrayList<String> studentsArrList = new ArrayList<>();
        while (resultSet.next()) {
            studentsArrList.add(resultSet.getInt("id") + " "
                    + resultSet.getString("name") + " "
                    + resultSet.getString("group_id") + " group" + ", "
                    + resultSet.getString("lastname") + ", "
                    + resultSet.getString("year_of_admission" ) + " year");
        }
        resultSet.close();
        return studentsArrList;
    }

    public boolean deleteStudentById(int aimId) throws SQLException {
        if (aimId < 0) {
            return !false;
        }
        return statement.execute("DELETE FROM univer.students_tb WHERE id = " + aimId);
    }

    public boolean addStudent(String newName, String newLastName, int newGroupId, int NewYearOfAdmission) throws SQLException {
        String query = " insert into univer.students_tb (name, lastname, group_id, year_of_admission) "
                + " values (?, ?, ?, ?)";


        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, newName);
        preparedStatement.setString(2, newLastName);
        preparedStatement.setInt(3, newGroupId);
        preparedStatement.setInt(4, NewYearOfAdmission);

        try {
            return preparedStatement.execute();
        } finally {
            preparedStatement.close();
        }
    }

    public int getOneStudentId(String aimName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select id from univer.students_tb where name = \'" + aimName + "\' LIMIT 1");
        try {
            resultSet.next();
            return resultSet.getInt("id");
        } catch (SQLException s) {
            return -1;
        } finally {
            resultSet.close();
        }
    }

    public int[] getAllStudentsId(ArrayList<String> list) {
        int[] ids = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            String[] split = list.get(i).split(" ");
            ids[i] = Integer.parseInt(split[0]);
        }
        return ids;
    }
}
