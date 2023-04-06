package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import personenKlassen.Student;

public class StudentTest {
    Student student;
    @Test

    @BeforeEach
    void neuerStudent(){
        student = new Student("Name", "Vorname", 1234567);
    }

    @Test
    @DisplayName("getName Test")
    void testGetName(){
        Assertions.assertEquals("Name", student.getName());
    }

    @Test
    @DisplayName("getVorname Test")
    void testGetVorname(){
        Assertions.assertEquals("Vorname", student.getVorname());
    }

    @Test
    @DisplayName("toString Test")
    void testToString(){
        Assertions.assertEquals("Name, Vorname, 1234567", student.toString());
    }

    @Test
    @DisplayName("getMatrikelnummer Test")
    void testGetMatrikelnummer(){
        Assertions.assertEquals(1234567, student.getMatrikelnummer());
    }

    @Test
    @DisplayName("equals Test")
    void testEquals(){
        Student tmpS = student;
        Assertions.assertTrue(student.equals(tmpS), "don't work when same object");
        tmpS = new Student("Name", "Vorname", 1234567);
        Assertions.assertTrue(student.equals(tmpS), "don't work when different Object, with same attributes");
        tmpS = new Student("N", "Vorname", 1234567);
        Assertions.assertFalse(student.equals(tmpS), "true, even when Name different");
        tmpS = new Student("Name", "VN", 1234567);
        Assertions.assertFalse(student.equals(tmpS), "true, even when Vorname different");
        tmpS = new Student("Name", "Vorname", 1234566);
        Assertions.assertFalse(student.equals(tmpS), "true, even when Matrikelnummer different");
        Assertions.assertFalse(student.equals(null), "true, even when null");
    }
}
