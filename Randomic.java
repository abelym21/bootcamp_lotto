

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Randomic {
	private Set<Integer> randomSet;

	public Randomic() {
		this.randomSet = new HashSet<Integer>();
	}

	public void randoming(String fileName) throws FileNotFoundException {
		int[] result = new int[6];
		setInput(fileName);
		setData();
		Random random = new Random();
		for(int i = 0 ; i < 6; i++){
			int tmp = (int)randomSet.toArray()[random.nextInt(randomSet.size())];
			result[i] = tmp;
			randomSet.remove(tmp);
		}
		printRandomNumbers(result);
	}
	
	private void printRandomNumbers(int[] array){
		for(int  i = 0; i < array.length; i++){
			System.out.print(array[i] + "\t");
		}
		System.out.println();
	}

	private void setInput(String fileName) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(fileName));
		while (sc.hasNext()) {
			randomSet.add(Integer.valueOf(sc.next()));
		}
		sc.close();
	}

	private void setData() {
		Random random = new Random();
		int num4 = 0;
		int[] num1 = new int[3];
		while (randomSet.size() <= 40) {
			num4 = random.nextInt(46000000);
			num1 = cutNum(num4);
			randomSet.add(num1[0]);
			randomSet.add(num1[1]);
			randomSet.add(num1[2]);
		}
	}

	private int[] cutNum(int num) {
		int quotion = num;
		int[] result = new int[3];
		for (int i = 0; i < 3; i++) {
			result[i] = quotion % 100;
			if (result[i] > 45) {
				result[i] = result[i] % 45;
			}
			quotion = quotion / 100;
		}
		return result;
	}
}
