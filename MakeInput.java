

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MakeInput {
	Map<Integer, BigInteger> map;

	public MakeInput() {
		map = new HashMap<Integer, BigInteger>();
	}

	
	public void fileRead(String inputFile) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(inputFile));
		int count = 0;
		while (sc.hasNextLine()) {
			setInput(sc.nextLine(), count);
			count++;
		}
		sc.close();
	}

	public Map<Integer, BigInteger> getMap() {
		return map;
	}


	private BigInteger getFortyfifthPowSevenNumeral(String line) {
		Scanner sc = new Scanner(line);
		StringBuilder sb = new StringBuilder();
		while (sc.hasNext()) {
			sb.append(sc.next());
		}
		sc.close();
		return new BigInteger(sb.toString());
	}

	private void setInput(String line, int time) {
		map.put(time, getFortyfifthPowSevenNumeral(line));
	}

}
