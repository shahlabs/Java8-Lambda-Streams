import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionsLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = Arrays.asList("Jack", "Jill", "Drew", "Clark");
		Collections.sort(names, String.CASE_INSENSITIVE_ORDER);
		System.out.println(names);

		Book book1 = new Book("Miss Peregrine's Home for Peculiar Children", "Ranson", "Riggs", 382);
		Book book2 = new Book("Harry Potter and The Sorcerers Stone", "JK", "Rowling", 411);
		Book book3 = new Book("The Cat in the Hat", "Dr", "Seuss", 45);

		List<Book> books = Arrays.asList(book1, book2, book3);
		int total = books.stream()
				.collect(Collectors.summingInt(Book::getPages));
		System.out.println(total);
		
		
		// .map to get the last name of author and collect to aggregate authors name in list
		List<String> list = books.stream().
				map(Book::getAuthorLName).collect(Collectors.toList());
		System.out.println(list);
		
		//Adding duplicates
		List<Book> dupBooks = Arrays.asList(book1,book2, book3,book1, book2);
		System.out.println("After adding duplicates :"+ dupBooks.toString());
		
		Collection<Book> noDups = new HashSet<Book>(dupBooks);
		System.out.println("After removing duplicates"+ noDups.toString());
		
		Arrays.asList("red", "green", "blue")
			  .stream().
			  sorted().
			  findFirst().ifPresent(System.out::println);	
		
		Stream.of("apple", "banana", "mango","pear", "apricot")
			.filter((fruit)->{
				return fruit.startsWith("a");
			}).forEach(fruit -> System.out.println("Starts with A: " +fruit));
		
		List<String> collected = Stream.of("Java", " Rocks")
                .map(string -> string.toUpperCase())
                .collect(Collectors.toList());
		System.out.println(collected.toString());
		
		IntStream.range(1, 4).forEach(System.out::println);
		
		Arrays.stream(new int[] {1,2,3,4})
			.map(n -> n * n)
			.average()
			.ifPresent(System.out::println);
		
		Stream.of(1.5,2.3,3.7)
		.mapToInt(Double::intValue)
		.forEach(System.out::println);

	
		
	}

}
