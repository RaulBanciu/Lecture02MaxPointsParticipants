import domain.Student;
import org.junit.Test;
import repository.StudentFileRepository;
import validation.StudentValidator;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testAddSTudent(){
        StudentValidator validator = new StudentValidator();
        StudentFileRepository repo = new StudentFileRepository(validator,"E:\\Lecture02MaxPointsParticipants\\files\\studenti.txt");
        Student s1 = new Student("1313", "Bizonu",932);
        repo.save(s1);
        assertEquals(repo.findOne("1313").getGrupa(),932);

    }

    @Test
    public void testAddSTudentDuplicate(){
        StudentValidator validator = new StudentValidator();
        StudentFileRepository repo = new StudentFileRepository(validator,"E:\\Lecture02MaxPointsParticipants\\files\\studenti.txt");
        Student s1 = new Student("1313", "Bizonul",932);
        repo.save(s1);
        assertNotEquals(repo.findOne("1313").getGrupa(),"Bizonul");

    }
}
