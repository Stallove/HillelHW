package HW22;


import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        DBDoer dbDoer = new DBDoer();
        dbDoer.getAllStudents();
        System.out.println();
        dbDoer.getStudentsByGroup(3);
        System.out.println();
        dbDoer.getStudentLessonsMarksAndTeachers(2);

        System.out.println();
        dbDoer.getStudentsAverage(2);




        dbDoer.close();
    }
}
