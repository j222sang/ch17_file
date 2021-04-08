package step02_Encoding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CharEncodingTest {

	public static void main(String[] args) throws Exception {
		File in = new File("17File.txt");
		// Pipe Line : 스트림간 연결 > 편리성, 성능을 챙김
		InputStreamReader isr = new InputStreamReader(new FileInputStream(in), StandardCharsets.UTF_8);
		BufferedReader br = new BufferedReader(isr);
		
		String readMsg;
		while ((readMsg = br.readLine()) != null) {
			System.out.println(readMsg);
		}

	}

}
