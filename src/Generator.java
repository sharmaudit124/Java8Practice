import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Generator {
    public static void main(String[] args) {
        //12 digit number
        generatePrimaryId();
    }

    public static void generatePrimaryId() {
        //2023-267262-1234 Example
        LocalDateTime localDateTime = LocalDateTime.now();
        UUID uuid = UUID.randomUUID();
        String[] arr = uuid.toString().replace("-", "").split("");
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        String prefix = String.valueOf(localDateTime.getYear());
        String postfix = String.valueOf(localDateTime.getNano());
        List<String> newList = list.stream()
                .filter(O -> Character.isDigit(O.charAt(0)))
                .limit(6)
                .collect(Collectors.toList());
        String actualValue = prefix +
                "-"+
                newList.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining())
                +"-"
                + postfix.substring(0, 4);
        System.out.println(actualValue);

    }
}
