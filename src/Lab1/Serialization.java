package lab1;
import java.io.*;

	public class Serialization{
	    static class Person implements  Serializable{
	        private String name;
	        private int age;

	        public Person(String name, int age) {
	            this.name = name;
	            this.age = age;
	        }

	        @Override
	        public String toString() {
	            return "Person{name='" + name + "', age=" + age + '}';
	        }
	    }

	    public static void main(String[] args) {
	        String filePath = "person.ser";

	        Person person = new Person("John Doe", 30);
	        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
	            out.writeObject(person);
	            System.out.println("Person object serialized to file.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
	            Person deserializedPerson = (Person) in.readObject();
	            System.out.println("Deserialized Person object:");
	            System.out.println(deserializedPerson);
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	}


