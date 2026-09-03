public class FizzBuzz {
	public static void main(String[] args) {
		f5();
	}
	
	static void f1() {
		for (int i = 1; i <= 15; i++) {
			System.out.println(i);
		}
	}
	
	static void f2() {
		for (int i = 1; i <= 15; i++) {
			if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}

	static void f3() {
		for (int i = 1; i <= 15; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}

	static void f4() {
		for (int i = 1; i <= 15; i++) {
			if (i % 3 == 0 && i % 5 == 0 && i % 7 == 0) {
				System.out.println("FizzBuzzBeep");
			} else if (i % 3 == 0 && i % 7 == 0) {
				System.out.println("FizzBeep");
			} else if (i % 5 == 0 && i % 7 == 0) {
				System.out.println("BuzzBeep");
			} else if (i % 7 == 0) {
				System.out.println("Beep");
			} else if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}

	static void f5() {
		for (int i = 1; i <= 15; i++) {
			String out = "";
			
			if (i % 3 == 0) {
				out += "Fizz";
			}
			
			if (i % 5 == 0) {
				out += "Buzz";
			}
			
			if (out.equals("")) {
				out += i;
			}
			
			System.out.println(out);
		}
	}
}
