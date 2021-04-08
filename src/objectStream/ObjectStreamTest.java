package objectStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class ObjectStreamTest implements Serializable {
	private String name;
	private int age;
	private Date day;
	
	public ObjectStreamTest(String name, int age, Date day) {
		super();
		this.name = name;
		this.age = age;
		this.day = day;
	}


	@Override
	public String toString() {
		return "ObjectStreamTest [name=" + name + ", age=" + age + ", day=" + day + "]";
	}


	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectStreamTest person = new ObjectStreamTest("안녕", 12, new Date());
		
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("object.dat"));
				ObjectInputStream in = new ObjectInputStream(new FileInputStream("object.dat"));
				){
			out.writeObject(person);
//			out.writeObject("안녕하세여");
			out.flush();
			ObjectStreamTest date = (ObjectStreamTest) in.readObject();
			
			System.out.println(date.toString());
		}
	}

}
