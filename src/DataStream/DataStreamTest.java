package DataStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest {
	public static void main(String[] args) throws IOException {

		try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("data.bin"))); 
				DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("data.bin")));) {
			int c;
			out.writeDouble(3.14);
			out.writeInt(100);
			out.writeUTF("자신의 생각을 바꾸지 못하는 사람은 결코 현실을 바꿀 수 없다.");
			out.flush();
			//out애ㅔ 값을 넣어준 순서대로 출력을 해야한다
			System.out.println(in.readDouble());
			System.out.println(in.readInt());
			System.out.println(in.readUTF());

		}
	}
}
