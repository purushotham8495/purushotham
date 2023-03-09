//7th 
package Inheritance;

public class Teacher implements Resume{
	
		String personalInfo;
		String qualification;
		int experience;
		String achievements;
		Teacher(String personalInfo, String qualification, int experience, String achievements){
		this.personalInfo = personalInfo;
		this.qualification = qualification;
		this.experience = experience;
		this.achievements = achievements;
		}
		public void bioData(){
		System.out.println("----------Bio Data---------");
		System.out.println("Name: "+personalInfo);
		System.out.println("Qualification:"+qualification);
		System.out.println("Experience:"+experience);
		System.out.println("Achievements:"+achievements);
		}
		}



package Inheritance;

public class Student implements Resume{
	String personalInfo;
	Double result;
	String discipline;
	Student(String personalInfo, double result, String discipline){
	this.personalInfo = personalInfo;
	this.result = result;
	this.discipline = discipline;
	}
	public void bioData(){
	System.out.println("----------Bio Data---------");
	System.out.println("Name:" +personalInfo);
	System.out.println("Result:"+result);
	System.out.println("Discipline:"+discipline);
	}
}

package Inheritance;

public class ResumeDemo {
	public static void main(String[] args){
		Resume teacher = new Teacher("Prof. Ramakrishna", "Mtech PhD", 20," Research Papers");
		Resume student = new Student("Sunil", 97.8, "CSE");
		teacher.bioData();
		student.bioData();
		}
		}






package Inheritance;

public interface Resume {
	void bioData();

}
//8 th

package Inheritance;

class Square_Num extends Thread {
int n;
public void run() {
System.out.println("Square of a Number "+this.n+"is:"+Math.pow(this.n, 2)); }
public Square_Num(int a) {
this.n = a;
}
}
package Inheritance;

class Square_Num extends Thread {
int n;
public void run() {
System.out.println("Square of a Number "+this.n+"is:"+Math.pow(this.n, 2)); }
public Square_Num(int a) {
this.n = a;
}
}

package Inheritance;

class Cube_Num extends Thread {
int n;
public void run() {
System.out.println("\nCube of a Number "+this.n+"is:"+Math.pow(this.n, 3)); }
public Cube_Num(int a) {
this.n = a; 
}
}

package Inheritance;

public class multithread {
	public static void main(String[] args)
	{
	Thread thread1 = new Random_Num_Thread();
	thread1.start();
	Thread thread2 = new Square_Num(2);
	thread2.start();
	Thread thread3 = new Cube_Num(3);
	thread3.start();
	}
	}
package Inheritance;

import java.util.Random;
class Random_Num_Thread extends Thread {
public void run() {
Random rand; int i = 0, m;
do{
rand = new Random();
m=rand.nextInt(100);
System.out.println(m +" ");
i++;
try{
Thread.sleep(1000); }
catch (InterruptedException e) {
e.printStackTrace(); }
}while(i< 10); 
}
}

//9th

 package Inheritance;
import java.util.ArrayList;

public class Run1 {
	public static void main(String[] args)
	{
	ArrayList list = new ArrayList();
	list.add("Hello");
	list.add(new Integer(10));
	list.add(20);
	list.add(21.5);
	list.add("20");
	list.add(null);
	System.out.println("size of list" +list.size());
	System.out.println(list.get(0));
	System.out.println("For Loop");
	
	for(int i=0; i<list.size();i++)
	{
	System.out.println(list.get(i));
	} 
	System.out.println("For Each");
	for(Object i : list)
	{
	System.out.println(i);
	}
	}
}
//10th

package Inheritance;
import java.util.Scanner;


	
	public class division
	{
		
	public static void main(String args[])
	{
		int a , b;
	int quotient;
	Scanner scanner = new Scanner(System.in);
	System.out.println("Please enter first number (numerator) : ");
	a = scanner.nextInt();
	System.out.println("Please enter second number (denominator) : ");
	b = scanner.nextInt();
	try
	{
	quotient = a / b;
	System.out.println ("Quotient = " + quotient);
	}
	catch(ArithmeticException ae)
	{
	System.out.println (ae);
	}

}
	}
  
//11th

package Inheritance;

import java.io.File;
import java.util.Scanner;
class FileP
{
public static void main(String args[ ])
{
Scanner obj=new Scanner(System.in); 
String fname=obj.next();
File f1 = new File(fname); 
System.out.println("File Name: " + f1.getName()); 
f1.setWritable(false);
System.out.println(f1.exists() ? "File exists" : "File does not exist");
System.out.println(f1.canWrite() ? "File is writeable" : "File is not writeable");
System.out.println(f1.canRead() ? "File is readable" : "File is not readable"); 
String fileName = f1.toString();
int index = fileName.lastIndexOf('.'); 
if(index > 0)
{ 
	String type = fileName.substring(index + 1);
	System.out.println("File type is " + type);
}
else
{
	System.out.println("File doesn't have type");
} 
System.out.println("File size: " + f1.length() + " Bytes");
}
}



	
	
  
  
  
  
  
  
