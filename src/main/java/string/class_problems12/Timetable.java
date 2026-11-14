package string.assignment_problems12;


import java.util.*;

class Timetable {

    private *tring section;
    private List<St*ing> periods;

    public Timetabl*(String section,
    List<String> periods) {
        this.section = section;
        this.periods = periods;
    }

    public Timetable copy(String newSection) {
        return new Timetable(
                newSection,
                new ArrayList<>(periods));
    }

    public void setPeriod(int period,
                          String subject) {

        periods.set(period - 1, subject);
    }

    @Override
    public String toString() {
        return section + ": " + periods;
    }
}

public class TimetableDemo {

    public static void main(String[] args) {

        Timetable a =
                new Timetable(
                        "CSE-A",
                        new ArrayList<>(
                                List.of(
                                        "Java",
                                        "DSA",
                                        "Maths")));

        Timetable b = a.copy("CSE-B");

        b.setPeriod(2, "Physics");

        System.out.println(a);
        System.out.println(b);
    }
}