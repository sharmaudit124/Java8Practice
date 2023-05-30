import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Set;

public class DateTimePractice {


    public static void main(String[] args) {
        LocalDate systemLocalDate = LocalDate.now();
        LocalDate customLocalDate = LocalDate.of(2023, 11, 1);
        LocalDate customLocalDate1 = LocalDate.of(2023, Month.MARCH, 1);

        LocalTime systemTime = LocalTime.now();
        LocalTime customLocalTime = LocalTime.of(13, 20, 5, 23);
        LocalTime customTimeWithoutNano = LocalTime.of(14, 34, 14);
        LocalTime customTimeWithHourMinute = LocalTime.of(6, 45);
        LocalTime noonTime = LocalTime.NOON;
        LocalTime midnightTime = LocalTime.MIDNIGHT;
        LocalTime maxTime = LocalTime.MAX;
        LocalTime minTime = LocalTime.MIN;

        LocalDateTime systemDateTime = LocalDateTime.now();
        LocalDateTime customDateTime = LocalDateTime.of(2022, 05, 20, 22, 34, 54, 23);
        LocalDateTime customDateTime1 = LocalDateTime.of(customLocalDate, customLocalTime);


        Set<String> zoneIdList = ZoneId.getAvailableZoneIds();
        for (String obj : zoneIdList) {
            //System.out.println(obj);
            ZoneId id = ZoneId.of(obj);
            String displayName = id.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
            String shortName = id.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
            //System.out.println(obj +" ----> "+displayName+ " -----shortForm----> " + shortName);

        }
        zoneIdList.stream().filter(o -> o.contains("Canada/Central")).forEach(System.out::println);
        System.out.println(zoneIdList.size());

        //Create DateTime using ZoneId
        ZoneId zoneId = ZoneId.of("Asia/Kolkata");
        //system ki hi value deta
        //ZonedDateTime zonedDateTime = ZonedDateTime.of(systemDateTime, zoneId);

        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        System.out.println(zonedDateTime);
        ZonedDateTime systemZonedDateTime = ZonedDateTime.now();
        System.out.println(systemZonedDateTime);

        //Comparison
        System.out.println(systemZonedDateTime.getZone());
        System.out.println("Is System or Custom time equal : " + customDateTime.equals(systemDateTime));
        System.out.println("Is Custom time after System time : " + customDateTime.isAfter(systemDateTime));
        System.out.println("Is Custom time before System time : " + customDateTime.isBefore(systemDateTime));

        //Clock
        Clock clock = Clock.systemDefaultZone();
        System.out.println("System Clock : " + clock.getZone() + "Time : " + clock.instant());
        ZoneId zone = ZoneId.of("US/Pacific");
        Clock clock1 = Clock.system(zone);
        System.out.println("Zoned Clock : " + clock1.getZone() + "Time : " + clock1.instant());
        //System.out.println(clock1.instant());
        Clock clock2 = Clock.offset(clock, Duration.ofHours(2));
        System.out.println("Derived Clock : " + "Time : " + clock2.instant());

        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(systemDateTime));
        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).format(zonedDateTime));

        LocalDate dob = LocalDate.of(1999, 11, 01);
        Period yourAge = Period.between(dob, systemLocalDate);
        System.out.println("Your are " + yourAge.getYears() + " years " + yourAge.getMonths() +
                " months " + yourAge.getDays() + " days older.");

        long noOfDays = ChronoUnit.DAYS.between(dob, systemDateTime);
        System.out.println("You are " + noOfDays + " days older!!");
        Duration duration = Duration.of(noOfDays, ChronoUnit.DAYS);
        long noOfHours = duration.toHours();
        System.out.println("You are " + noOfHours + " hours older!!");
        System.out.println("You are " + duration.toMinutes() + " minutes older!!");
        System.out.println("You are " + duration.toSeconds() + " seconds older!!");


    }
}
