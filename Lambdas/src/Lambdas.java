import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Lambdas {

	
	public static void main(String[] args) {
		Predicate<String> stringLen = (s) -> s.length() < 10; 
		System.out.println(stringLen.test("Apples") + "- Apples is less than 10");
		
		Consumer<String> consumerString = (s) -> System.out.println(s.toLowerCase());
		consumerString.accept("ABCDERFhsfjbkerbfkbe");
		
		Function<Integer, String> converter = (num)-> Integer.toString(num);
		System.out.println("length of 26:" + converter.apply(26).length());
		
		//requires empty argument list
		Supplier<String> s = () -> "Java is fun";
		System.out.println(s.get());
		
		BinaryOperator<Integer> add = (a,b) -> a + b;
		System.out.println("add 10 + 25: " + add.apply(10, 25));
		
		UnaryOperator<String> str = (msg)->msg.toUpperCase();
		System.out.println(str.apply("This is my message in upper case"));
		
		String st = "This is my second message in upper case";
		System.out.println(st.toUpperCase());
		
		BiFunction<String, String, String> concat = (a,b) -> a+b;
		String output = concat.apply("Today is ", "a great day!");
		System.out.println(output);
		
		//Consumer consumes data, does not return anything
		Consumer<String> hello = name -> System.out.println("Hello "+name);
		for(String name:Arrays.asList("Jack", "Jill", "Drew")) {
			hello.accept(name);
		}
		
		GreetingFunction greeting = msg -> System.out.println("Java 8"+msg);
		greeting.sayMessage(" is fun!");
		
		IntFunction<String> intToString = num -> Integer.toString(num);
		System.out.println("Length of 123 is: "+ intToString.apply(123).length());
		
		//Access to static method reference using ::
		IntFunction<String> intToStringCopy = Integer::toString;
		System.out.println("Length of 123 is: "+ intToStringCopy.apply(123).length());
		
		//lambda made using constructor
		Function<String, BigInteger> newBigInt = BigInteger::new;
		System.out.println(newBigInt.apply("123456789"));
		
		Consumer<String> print = System.out::println;
		print.accept("SOP using Consumer");
		
		
		//Using Custom Functional Interface
		Calculator adds = (a,b) -> a+b;
		Calculator diff = (a,b) -> Math.abs(a-b);
		Calculator divide = (a,b) ->(b != 0 ? a/b :0);
		
		System.out.println("Addition of 10,20 using FI :" + adds.calc(10, 20));
		System.out.println(diff.calc(20, 10));
		System.out.println(divide.calc(20, 10));
		System.out.println();
	}
	
	@FunctionalInterface
	interface GreetingFunction{
		void sayMessage(String message);
	}

}
