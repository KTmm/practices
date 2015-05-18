import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;


public class StudentScoreTest  {
	Student JON;
	Student JEREMY;
	Student JESSE;
	Student MIKE;
	Student NANCY;
	FinalGrades class1;
	
	@Before
	public void setUp() throws noStudentNameException, invalidGradeException, noGradesException {
		Student JON = new Student("JON : 19  14  15  15 16");
		Student JEREMY = new Student("JEREMY", new int[] {15, 11, 10, 15, 16});
		Student JESSE = new Student ("JESSE", new int[] {19 ,17 ,20 ,19 ,18});
		Student MIKE = new Student ("MIKE", new int[] {20 ,17 ,20 ,19 ,18});
		Student NANCY = new Student ("NANCY", new int[] {16 ,17 ,15 ,19 ,18});
		FinalGrades class1 = new FinalGrades();
	}
		
	@Test
	public void test1() throws noStudentNameException, invalidGradeException, studentRepeatException, noGradesException{
		FinalGrades class1 = new FinalGrades();
		Student JON = new Student("JON : 19  14  15  15 16");
		Student JEREMY = new Student("JEREMY", new int[] {15, 11, 10, 15, 16});
		Student JESSE = new Student ("JESSE", new int[] {19 ,17 ,20 ,19 ,18});
		class1.addStudent(JON);
		class1.addStudent(JEREMY);
		class1.addStudent(JESSE);
		assertEquals(15.93, class1.getClassMean(), 0.005);
	}
	
	@Test(expected = noStudentNameException.class) 
	public void test2() throws noStudentNameException, invalidGradeException, studentRepeatException, noGradesException{
		FinalGrades class1 = new FinalGrades();
		Student JON = new Student("  : 19  14  15  15 16");
	}
	
	@Test(expected = invalidGradeException.class)
	public void test3() throws noStudentNameException, invalidGradeException, studentRepeatException, noGradesException{
		Student JON = new Student("JON : 22  14  15  15 16");
	}
    
	@Test(expected = noGradesException.class)
	public void test4() throws noStudentNameException, invalidGradeException, studentRepeatException, noGradesException{
		Student JON = new Student("JON : ");
	}
	
	@Test(expected = studentRepeatException.class)
	public void test5() throws noStudentNameException, invalidGradeException, studentRepeatException, noGradesException{
		Student JON = new Student("JON : 19  14  15  15 16");
		Student JEREMY = new Student("JON : 19  14  15  15 16");
		FinalGrades class2 = new FinalGrades();
		class2.addStudent(JON);
		class2.addStudent(JEREMY);
	}
	
}
