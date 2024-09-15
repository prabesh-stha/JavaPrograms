package lab1;

public class CustomException {

	static class InvalidAgeException extends Exception {
		 public InvalidAgeException(String message) {
		     super(message);
		 }
		}
	
	   static class Person {
	        private String name;
	        private int age;

	        public Person(String name, int age) throws InvalidAgeException {
	            if (age < 16) {
	                throw new InvalidAgeException("Invalid age: " + age + ". Age must be above 16");
	            }
	            this.name = name;
	            this.age = age;
	        }

	        public void Print() {
	        	System.out.println("Name " + this.name + " age is " + this.age);
	        }
	    }
	   
	   public static void main(String[] args) {
	        try {
	            Person person1 = new Person("Alice", 30); 
	            person1.Print();

	            Person person2 = new Person("Bob", -5); 
	            person2.Print();
	        } catch (InvalidAgeException e) {
	            System.out.println("Exception caught: " + e.getMessage());
	        }
	    }
}


