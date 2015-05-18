import java.lang.reflect.Array;

/**An instance representing a student with his grades, each student has a unique name and an array of assignment grades
 * @author yingzhou*/

public class Student {
	/**Student name cannot be empty*/
	private String StudentName;
	
	/**each grade should between 0-20*/
	private int[] StudentGrades;
	
	/**Constructor: 
	 * @param : String of student name, int array of student grades*/
	public Student(String name, int[] grades) throws noStudentNameException, invalidGradeException {
		checkNameValidation(name);
		StudentName = name;
		for (int i = 0; i < grades.length; i++){
			validateGrade(grades[i]);
		}
		StudentGrades = grades;
	}
	
	/**Constructor: 
	 * @param : the whole record including student name and assignments, student name is separated from grades by ":", assignment grades are
	 * separated by one or more spaces like "JON : 19 14 15 15 16"
	 * @throws noGradesException */
	public Student (String studentRecord) throws noStudentNameException, invalidGradeException, noGradesException{
		StudentName = extarctStudentName(studentRecord);
		String[] parsedGrades = extraStudentGrades(studentRecord);
		StudentGrades = new int[parsedGrades.length];
		for (int i = 0; i < parsedGrades.length; i++){
			int grade = Integer.parseInt(parsedGrades[i]); 
			validateGrade(grade);
			StudentGrades[i] = grade;
		}
	}
	
	public String getName(){
		return StudentName;
	}
	
	public int[] getGrades(){
		return StudentGrades;
	}
	
	/**@return a double representing this student's average grade of all assignments*/
	public double getMean(){
		int sum = 0;
		for (int grade : StudentGrades){
			sum += grade;
		}
		return (double)sum / StudentGrades.length;
	}
	
	/**This method checks if the student is empty, if yes, throw an noStudentNameException*/
	private void checkNameValidation(String name) throws noStudentNameException{
		if (name.isEmpty()){
			throw new noStudentNameException("Student Name Cannot be Empty!");
		}
	}
	
	/**This method checks if the grade is between 0~20, if not, throw an invalidGradeException*/
	private void validateGrade(int grade) throws invalidGradeException{
		if (grade > 20 || grade < 0){
				throw new invalidGradeException("Invalid grade input!Grade must be between 0~20.");
		}
	}	
	
	/**This method extracts the student name from a string of student record with both student name and grades,
	 * student name is separated by ":" from the grades
	 * @return a string of student name*/
	private String extarctStudentName(String record) throws noStudentNameException{
		String name = record.substring(0, record.indexOf(':'));
		name = name.trim();
		checkNameValidation(name);
		return name;
	}
	
	/**This method extracts the student grades from a string of student record with both student name and grades,
	 * student grades are separated by one or more spaces in the record
	 * @return a string array of the parsed stduent's grades
	 * @throws noGradesException */
	private String[] extraStudentGrades(String record) throws noGradesException{
		String grades = record.substring(record.indexOf(':') + 1);
		if (grades.trim().equals("")){
			throw new noGradesException("There are no grades for this student!");
		} 
		String[] parsedGrades = grades.trim().split("\\s+");
		return parsedGrades;
	}
	
}
