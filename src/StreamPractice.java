import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamPractice {

    Predicate<Integer> checkOdd = val -> val % 2 != 0;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(6, 2, 9, 1, 5, 6, 8, 7, 3));
        //peekFunctionTest(list);
        skipFunctionTest(list);
        reduceMethod(list);
        StreamPractice obj = new StreamPractice();
        List<Integer> newList = obj.doubleListElements(list);
        //List<Integer> newList= obj.getEvenFilteredList(list);
        //List<Integer> newList = obj.getOddFilteredListUsingFnc(list);
        System.out.println(newList);
        obj.sortList(list);
        obj.removeDuplicates(list);
    }

    public static void peekFunctionTest(List<Integer> list) {
        list.stream().filter(o -> o % 5 == 0)
                .peek(System.out::println)
                .forEach(System.out::println);
    }

    public static void skipFunctionTest(List<Integer> list) {
        list.stream().skip(2)
                .filter((val) -> val % 2 == 0)
                .forEach(System.out::println);
    }

    public static void reduceMethod(List<Integer> list) {
        int val = list.stream().reduce(0, Integer::sum);
        System.out.println(val);
    }

    public List<Integer> getEvenFilteredList(List<Integer> list) {
        List<Integer> newList = list.stream()
                .filter((val) -> val % 2 == 0)
                .collect(Collectors.toList());
        return newList;
    }

    public List<Integer> getOddFilteredListUsingFnc(List<Integer> list) {
        List<Integer> newList = list.stream()
                .filter(checkOdd)
                .collect(Collectors.toList());
        return newList;
    }

    public List<Integer> doubleListElements(List<Integer> list) {
        List<Integer> newList = list.stream()
                .map(o -> 2 * o)
                .collect(Collectors.toList());
        return newList;
    }

    public void sortList(List<Integer> list) {
        list.stream().sorted().forEach(System.out::println);
    }

    public void removeDuplicates(List<Integer> list) {
        list.stream().distinct().forEach(System.out::println);
    }
}
