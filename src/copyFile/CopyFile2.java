package copyFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile2 {
	private static final int EOF = -1;
	public CopyFile2() throws IOException  {

		try (FileInputStream in = new FileInputStream("car1.jpg");
				FileOutputStream out = new FileOutputStream("car0.jpg")) {
			int c;
			while ((c = in.read()) != EOF) {
				out.write(c);
			}
		}
	}

	public static void main(String[] args) {
		try {
			new CopyFile2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
