import java.util.Arrays;
import java.util.List;

public class buram_irisan {
  public static void main(String[] args) {
    Integer[] numbers = {1, 2, 3, 4, 5, 6};
    Integer[] anotherNumbers = {4, 5, 6, 7, 8, 9, 10};

    List<Integer> numbersList = Arrays.asList(numbers);
    List<Integer> anotherNumbersList = Arrays.asList(anotherNumbers);

    boolean containsAll = numbersList.containsAll(anotherNumbersList);

    System.out.println("anotherNumbers contains all elements of numbers: " + containsAll);
  }
}