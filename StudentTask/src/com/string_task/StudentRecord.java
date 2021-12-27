package com.string_task;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;

//class StudentsSortingComparator implements Comparator<Students> {
//	@Override
//	public int compare(Students sobj1, Students sobj2) {
//		int compareSequenceNumber = sobj1.getSequenceNumber().compareTo(sobj2.getSequenceNumber());
//
//		return compareSequenceNumber;
//	}
//}

class Students {

	@Override
	public String toString() {
		return "Students [name=" + name + ", mobileNumber=" + mobileNumber + ", registrationNumber="
				+ registrationNumber + "]";
	}

	public Students(String name, String mobileNumber, String registrationNumber) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.registrationNumber = registrationNumber;
	}

	String name;
	String mobileNumber;
//	String collegeName;
//	String department;
//	String year;
//	String sequenceNumber;
	String registrationNumber;

	public String getSequenceNumber() {
		String[] splittedRegistrationNumber = registrationNumber.split("-");
		return splittedRegistrationNumber[1];

	}

}

public class StudentRecord {
	public static void main(String args[]) {
		List<Students> studentRecordCS = new ArrayList<Students>();
		List<Students> studentRecordIT = new ArrayList<Students>();

		studentRecordCS.add(new Students("Anjali", "7654239878", "IITCS2021-01"));
		studentRecordCS.add(new Students("Anjali", "7654239878", "IITCS2021-11"));
		studentRecordCS.add(new Students("Aman", "9954239876", "IITCS2021-67"));
		studentRecordCS.add(new Students("Ritika", "7634239876", "IITCS2021-23"));
		studentRecordCS.add(new Students("Aditi", "6054239876", "IITCS2021-99"));
		studentRecordCS.add(new Students("Raghav", "7854239876", "IITCS2021-02"));

		studentRecordIT.add(new Students("Kiran", "8054239876", "IITCS2021-01"));
		studentRecordIT.add(new Students("John", "8456539876", "IITCS2021-09"));
		studentRecordIT.add(new Students("Sanjeevani", "6354239876", "IITCS2021-12"));
		studentRecordIT.add(new Students("Raj", "9754539876", "IITCS2021-18"));
		studentRecordIT.add(new Students("Ram", "8054039879", "IITCS2021-07"));

//		List<Students> mergedStudentRecordCSandIT = Stream.of(studentRecordCS, studentRecordIT).flatMap(x -> x.stream())
//				.collect(Collectors.toList());
		
		List<Students> mergedStudentRecordCSandIT = new ArrayList<Students>();
		mergedStudentRecordCSandIT.addAll(studentRecordCS);
		mergedStudentRecordCSandIT.addAll(studentRecordIT);
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

//		Collections.sort(mergedStudentRecordCSandIT, new StudentsSortingComparator());
		
		mergedStudentRecordCSandIT.sort(Comparator.comparing(Students::getSequenceNumber).reversed());

		for (Students student : mergedStudentRecordCSandIT) {
			System.out.print(student.registrationNumber);
			System.out.format("%15s", student.name);
			System.out.println();
		}

	}
}
