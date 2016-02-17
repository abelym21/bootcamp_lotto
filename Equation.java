

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Equation {
	private Map<Integer, BigInteger> map;

	public Equation(Map<Integer, BigInteger> map) {
		this.map = map;
	}

	public BigInteger CalEquation(int x) {
		return getBran().multiply(BigInteger.valueOf(x)).add(getCons());
	}

	public BigInteger[] getNumber(BigInteger result) {
		BigInteger quotion = new BigInteger("0");
		BigInteger rest = new BigInteger("0");
		BigInteger[] resultArray = new BigInteger[6];
		quotion = result.divide(BigInteger.valueOf(45));
		rest = result.mod(BigInteger.valueOf(45));
		for (int i = 0; i < 5; i++) {
			resultArray[5 - i] = rest;
			if (!quotion.equals(0)) {
				quotion = quotion.divide(BigInteger.valueOf(45));
				rest = quotion.mod(BigInteger.valueOf(45));
			}
		}
		return resultArray;
	}

	private int getXMean() {
		int sum = 0;
		for (int i : map.keySet()) {
			sum = sum + i;
		}
		return sum / map.size();
	}

	private BigInteger getYMean() {
		BigInteger sum = new BigInteger("0");
		for (int i : map.keySet()) {
			sum = sum.add(BigInteger.valueOf(i));
		}
		return sum.divide(BigInteger.valueOf(map.size()));

	}

	private BigInteger getBran() {
		BigInteger sum1 = new BigInteger("0");
		int sum2 = 0;
		int xMean = getXMean();
		BigInteger yMean = getYMean();
		for (int i = 0; i < map.size(); i++) {
			sum1 = map.get(i).subtract(yMean).multiply(BigInteger.valueOf(i - xMean));
			sum2 = (i - xMean) * (i - xMean);
		}
		return sum1.divide(BigInteger.valueOf(sum2));
	}

	private BigInteger getCons() {
		return map.get(1).subtract(getBran());
	}

}
