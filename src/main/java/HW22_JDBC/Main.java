package HW22_JDBC;


import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        DBDoer dbDoer = new DBDoer();
        dbDoer.getAllStudents();
        System.out.println();
        dbDoer.getStudentsByGroup(3);
        System.out.println();
        dbDoer.getStudentsByYear(2000);
        System.out.println();
        dbDoer.getStudentLessonsMarksAndTeachers(2);
        System.out.println();
        dbDoer.getStudentsAverage(2);
        dbDoer.close();
    }
}
