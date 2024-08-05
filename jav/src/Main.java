public class Main {
    public static void main(String[] args) {
      Integer[] numbers = {1,2,3,4,5,6};
      Integer[] anotherNumbers = {4,5,6,7,8,9,10};
  
    //   boolean isSubset = true;
    //   for (Integer number : numbers) {
    //     if (!Arrays.asList(anotherNumbers).contains(number)) {
    //       isSubset = false;
    //       break;
    //     }
    //   }
    for (int i = 0; i < numbers.length; i++) {
        for (int j = 0; j < anotherNumbers.length; j++) {
            if (numbers[i] == anotherNumbers[j]) {
                System.out.println(anotherNumbers[j]);
            }
            // System.out.println(anotherNumbers[j]);
        }
        
    }
    }
}
