import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class StudentScoreTest  {
		
	@Test
	public void classMean_isCorrect() throws noStudentNameException, invalidGradeException, studentRepeatException, noGradesException, noStudentsSpecifiedException{
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
	public void student_ConstructorThrowsExceptionIfNameIsNotSpecified() throws noStudentNameException, invalidGradeException, studentRepeatException, noGradesException{
		new Student("  : 19  14  15  15 16");
	}
	
	@Test(expected = invalidGradeException.class)
	public void student_ConstructorThrowsExceptionIfInvalidGradeIsSpecified() throws noStudentNameException, invalidGradeException, studentRepeatException, noGradesException{
		new Student("JON : 22  14  15  15 16");
	}
    
	@Test(expected = noGradesException.class)
	public void student_ConstructorThrowsExceptionIfNoGradesSpecified() throws noStudentNameException, invalidGradeException, studentRepeatException, noGradesException{
		new Student("JON : ");
	}
	
	@Test(expected = studentRepeatException.class)
	public void addStudentToClass_throwsExceptionIfTwoStudentsHaveTheSameName() throws noStudentNameException, invalidGradeException, studentRepeatException, noGradesException{
		Student JON = new Student("JON : 19  14  15  15 16");
		Student JEREMY = new Student("JON : 19  14  15  15 16");
		FinalGrades class2 = new FinalGrades();
		class2.addStudent(JON);
		class2.addStudent(JEREMY);
	}
	
	@Test
	public void classMean_isCorrect_ifWeRemoveAStudent() throws noStudentNameException, invalidGradeException, studentRepeatException, noGradesException, noStudentsSpecifiedException{
		Student JON = new Student("JON : 19  14  15  15 16");
		Student JEREMY = new Student("JEREMY : 19  14  15  15 16");
		FinalGrades class3 = new FinalGrades();
		class3.addStudent(JON);
		class3.addStudent(JEREMY);
		class3.removeStudent(JON);
		assertEquals(15.80, class3.getClassMean(), 0.005);
	}
	
	@Test
	public void studentMean_isCorrect() throws noStudentNameException, invalidGradeException, noGradesException {
		Student JON = new Student("JON : 19  14  15  15 16");
		assertEquals(15.80, JON.getMean(), 0.005);
	}
	
	@Test(expected = noStudentsSpecifiedException.class)
	public void classMean_ThrowsNoStudentsSpecifiedException() throws noStudentsSpecifiedException {
		FinalGrades class1 = new FinalGrades();
		class1.getClassMean();
	}
	
	@Test
	public void printMessage_isCorrect() throws noStudentNameException, invalidGradeException, noGradesException, studentRepeatException, noStudentsSpecifiedException{
		Student JON = new Student("JON : 19  14  15  15 16");
		Student JEREMY = new Student("JEREMY", new int[] {15, 11, 10, 15, 16});
		Student JESSE = new Student ("JESSE", new int[] {19 ,17 ,20 ,19 ,18});
		FinalGrades class1 = new FinalGrades();
		class1.addStudent(JON);
		class1.addStudent(JEREMY);
		class1.addStudent(JESSE);
		String expectedMessage = "JON 15.80\n" + "JEREMY 13.40\n" + "JESSE 18.60\n" + "OVERALL 15.93";
        assertEquals(expectedMessage, class1.getMessage());
	
	}

}
