import java.util.Scanner;

/*
You need to be able to create a list of students and specify time and weekdays for
classes. Classes can be held on any day of week between 1 pm and 6 pm. Multiple classes
can be held on a single day. However, total classes per week cannot exceed 10.
Maximum number of students in the timetable is also 10. Maximum length of a student’s name is 10 (no spaces).
You should also provide an ability to record student’s attendance. To do so, time
and date of classes shall be specified next to each student’s name along with attendance
status (HERE, NOT_HERE). You do not need to record attendance for all classes in a
month.
Therefore, application’s life cycle is as follows:
• Creating a list of students
• Populating a timetable—each class (time, day of week) is entered in a separate row
• Attendance recording
11
Java - Module 00 Primitive types, IO, String, Arrays
• Displaying the timetable in tabular form with attendance statuses.
Each application operation stage is divided by "." (period). Absolute correctness
of data is guaranteed, except for sequential ordering of classes when populating the
timetable.
*/

public class Program {
    private static final String PERIOD = ".";
    private static final int STUDENT_MAX_LEN = 10;
    private static final int STUDENT_MAX_NUM = 10;
    private static final String[] DAYS = { "MO", "TU", "WE", "TH", "FR", "SA", "SU" };
    private static final int[] TIMES = { 1, 2, 3, 4, 5, 6 };

    private static String[] students = new String[STUDENT_MAX_NUM];
    privat static int[][] classDates = new int[40][2];

    private static String trim(String str) {
        char[] strArray = str.toCharArray();
        String result = "";

        int i = 0;
        int j = strArray.length - 1;
        // skip leading spaces
        for (; i < strArray.length; i++) {
            if (strArray[i] == ' ') {
                continue;
            }
        }
        // skip trailing spaces
        for (; j >= 0; j--) {
            if (strArray[j] == ' ') {
                continue;
            }
        }
        // copy the rest and if there is a space, break
        for (; i <= j; i++) {
            if (strArray[i] == ' ') {
                System.err.println("Student name cannot contain spaces");
                System.exit(-1);
            }
            result += strArray[i];
        }
        return result;
    }

    private static String[] split(String str) {
        String[] result = new String[5];
        String temp = "";
        char[] strArray = str.toCharArray();
        int resuleIndex = 0;
        
        for (int i = 0; i <= str.length(); i++) {
            if (strArray[i] == ' ') {
                result[resuleIndex] = temp;
                temp = "";
            } else {
                temp += strArray[i];
            }
            resuleIndex++;
        }
        result[resuleIndex] = temp;
        return result;
    }

    private static int strToInt(String str) {
        char[] strArray = str.toCharArray();
        int result = 0;
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i] < '0' || strArray[i] > '9') {
                System.err.println("Invalid number");
                System.exit(-1);
            }
            result = result * 10 + (strArray[i] - '0');
        }
        return result;
    }

    private static void getStudents(Scanner scanner) {
        // get names in a loop until the user enters "PERIOD"
        int i = 0;

        while (true) {
            System.out.println("-> ");
            String name = scanner.nextLine();
            if (name.equals(PERIOD)) {
                break;
            }
            students[i] = trim(name);
            i++;
            if (i > STUDENT_MAX_NUM || name.length() > STUDENT_MAX_LEN) {
                System.err.println("Student name is too long or there are too many students");
                System.exit(-1);
            }
        }
    }

    private static void getClassDates(Scanner scanner) {
        // get class dates in a loop until the user enters "PERIOD"
        // the input will be time day. ex: 1 MO or 2 TU

        int i = 0;
        while (true) {
            System.out.println("-> ");
            String classDate = scanner.nextLine();
            if (classDate.equals(PERIOD)) {
                break;
            }
            String[] classDateArray = split(classDate);
            int time = strToInt(trim(classDateArray[0]));
            if (time < 1 || time > 6) {
                System.err.println("Invalid time");
                System.exit(-1);
            }
            int day = -1;
            for (int j = 0; j < DAYS.length; j++) {
                if (DAYS[j].equals(classDateArray[1])) {
                    day = j;
                    break;
                }
            }
            if (day == -1) {
                System.err.println("Invalid day");
                System.exit(-1);
            }
            classDates[i][0] = time;
            classDates[i][1] = day;
            i++;
            if (i > 40) {
                System.err.println("Too many classes");
                System.exit(-1);
            }
        }
    }

    private static void getStudentsAttendance(Scanner scanner) {
        // get attendance in a loop until the user enters "PERIOD"
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        getStudents(scanner);
        getClassDates(scanner);
    }
    

}