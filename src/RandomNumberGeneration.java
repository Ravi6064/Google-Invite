import java.util.Random;

public class RandomNumberGeneration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getRandomNumberString());
	}

	public static String getRandomNumberString() {
		// It will generate 6 digit random Number.
		// from 0 to 999999
		Random rnd = new Random();
		//rnd.nex
		Long number = rnd.nextLong();

		// this will convert any number sequence into 6 character.
		return String.format("%09d", Math.abs(number));
	}

}
