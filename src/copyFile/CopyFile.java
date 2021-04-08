package copyFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

	public CopyFile() throws IOException  {

		try (FileInputStream in = new FileInputStream("17File.txt");
				FileOutputStream out = new FileOutputStream("output.txt")) {
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		}
	}

	public static void main(String[] args) {
		try {
			new CopyFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
