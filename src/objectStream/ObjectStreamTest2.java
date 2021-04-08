package objectStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ObjectStreamTest2 {
	private String name;
	private int age;
	private Date day;
	private List<Book> books = new ArrayList<>();

	public ObjectStreamTest2(String name, int age, Date day) {
		super();
		this.name = name;
		this.age = age;
		this.day = day;
	}

	private void addBook(Book book) {
		books.add(book);
	}

	@Override
	public String toString() {
		return "ObjectStreamTest2 [name=" + name + ", age=" + age + ", day=" + day + ", books=" + books + "]";
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("object.dat"));
				ObjectInputStream in = new ObjectInputStream(new FileInputStream("object.dat"));) {
			ObjectStreamTest2 person = new ObjectStreamTest2("홍길동", 12, new Date());

			person.addBook(new Book("사랑이란", 10000));
			person.addBook(new Book("헤어짐이란", 10000));
//			out.writeObject(person);
//			out.flush();

			Gson gson = new GsonBuilder().create();
			String serializedPerson = gson.toJson(person);

//			ObjectStreamTest2 date = (ObjectStreamTest2) in.readObject();

			System.out.println(serializedPerson);
		}
	}

}
