package HW25Test;

import HW25.DBD;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DBDoerTest {

    @Test
    public void addAndDelete() throws ClassNotFoundException, SQLException {
        DBD dbd = new DBD();
        assertFalse(dbd.addStudent("TestName","TestLastName", 2,1000));
        assertFalse(dbd.deleteStudentById(dbd.getOneStudentId("TestName")));
        dbd.close();
    }

    @Test
    public void getAllStudentsListTest() throws ClassNotFoundException, SQLException {
        DBD dbd = new DBD();

        ArrayList<String> allStudentsList;
        allStudentsList = dbd.getAllStudentsList();

        for (int i = 0; i < allStudentsList.size(); i++) {
            System.out.println(allStudentsList.get(i));
        }
        dbd.close();
    }

    @Test
    public void getStudentsIdTest() throws ClassNotFoundException, SQLException {
        DBD dbd = new DBD();
        ArrayList<String> studentsList = dbd.getAllStudentsList();
        int[] studentsIds = dbd.getAllStudentsId(studentsList);

        for (int i = 0; i < studentsIds.length; i++) {
            System.out.println(studentsIds[i] + " " + studentsList.get(i));
        }
        dbd.close();
    }

}
