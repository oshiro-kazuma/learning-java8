import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//stream api を使ってみる
public class stream {
    public static void main (String[] args) {
        // sample data
        List<String> list = Arrays.asList(
            "list1", "list2", "list3", "list4", "list5"
        );
        // add prefix
        Stream<String> prefixed = list.stream().map(e -> "prefix:" + e);
        // print
        prefixed.forEach(System.out::println);

        // sample data
        IntStream.range(1, 10).forEach(e -> {
            Integer i = e * 10;
            System.out.println("int: " + i);
        });

        // reduce
        Stream<Integer> intList = Arrays.asList(2, 3, 4).stream();
        Optional<Integer> product = intList.reduce((x, y) -> x * y);

        // Optional
        System.out.println("2*3*4=" + product.orElse(0));

        // flatMap
        Optional<Integer> maybeA = Optional.of(1);
        Optional<Integer> maybeB = Optional.of(2);
        Optional<Integer> maybeC = Optional.of(3);

        System.out.println(
          maybeA.flatMap(a ->
            maybeB.flatMap(b ->
              maybeC.map(c -> a + b + c)
            )
          )
        );
    }
}
