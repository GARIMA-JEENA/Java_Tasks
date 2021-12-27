package com.string_task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StudentsSortingComparator implements Comparator<Students> {
	@Override
	public int compare(Students sobj1, Students sobj2) {
		int compareSequenceNumber = sobj1.getSequenceNumber().compareTo(sobj2.getSequenceNumber());

		return compareSequenceNumber;
	}
}

class Students {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public Students(String name, String mobileNumber, String collegeName, String department, String year,
			String sequenceNumber) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.collegeName = collegeName;
		this.department = department;
		this.year = year;
		this.sequenceNumber = sequenceNumber;
		this.registrationNumber = collegeName + department + year + "-" + sequenceNumber;
	}

	String name;
	String mobileNumber;
	String collegeName;
	String department;
	String year;
	String sequenceNumber;
	String registrationNumber;

}

public class StudentMethods {
	public static void main(String args[]) {
		List<Students> studentRecordCS = new ArrayList<Students>();
		List<Students> studentRecordIT = new ArrayList<Students>();

		studentRecordCS.add(new Students("Anjali", "7654239878", "IITB", "CS", "2021", "01"));
		studentRecordCS.add(new Students("Anshika", "7654269876", "IIT", "DCS", "2021", "09"));
		studentRecordCS.add(new Students("Aman", "9954239876", "IITB", "CS", "2021", "08"));
		studentRecordCS.add(new Students("Ritika", "7634239876", "IITB", "CS", "2021", "56"));
		studentRecordCS.add(new Students("Aditi", "6054239876", "IITB", "CS", "2021", "11"));
		studentRecordCS.add(new Students("Raghav", "7854239876", "IITB", "CS", "2021", "02"));

		studentRecordIT.add(new Students("Kiran", "8054239876", "IIT", "DIT", "2022", "78"));
		studentRecordIT.add(new Students("John", "8456539876", "IIT", "DIT", "2022", "12"));
		studentRecordIT.add(new Students("Sanjeevani", "6354239876", "IIT", "DIT", "2022", "18"));
		studentRecordIT.add(new Students("Raj", "9754539876", "IIT", "DIT", "2022", "19"));
		studentRecordIT.add(new Students("Ram", "8054039879", "IIT", "DIT", "2022", "06"));

		List<Students> mergedStudentRecordCSandIT = Stream.of(studentRecordCS, studentRecordIT).flatMap(x -> x.stream())
				.collect(Collectors.toList());
		System.out.println();
		System.out.println("MERGED STUDENTS RECORD ( CS AND IT) ");
		for (Students student : mergedStudentRecordCSandIT) {

			System.out.print(student.registrationNumber);
			System.out.format("%15s", student.name);
			System.out.println();
		}
		System.out.println();
		System.out.println("SORTED STUDENTS RECORD ");
		System.out.println();
		Collections.sort(mergedStudentRecordCSandIT, new StudentsSortingComparator());

		for (Students student : mergedStudentRecordCSandIT) {
			System.out.print(student.registrationNumber);
			System.out.format("%15s", student.name);
			System.out.println();
		}

	}
}
