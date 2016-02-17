

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		MakeInput makeInput = new MakeInput();
		makeInput.fileRead(args[0]);
		Equation equation = new Equation(makeInput.getMap());
		BigInteger[] resultArray = null;

	
	//	System.out.println("Random NONO");
		resultArray = getNumber(calEquation(681));
		for(int i = 0;  i < resultArray.length();i++){ 
		System.out.println(getNumber(CalEquation(681))[i]);
	}	
	/*	System.out.println("Random");
		int count = 0;
		Randomic randomic = new Randomic();

		while (count <= 6) {
			randomic.randoming("input_random.txt");
			count++;
		}
	*/
	}

}
