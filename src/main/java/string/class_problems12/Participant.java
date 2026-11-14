package string.assignment_problems12;


class Participant {
    String name;
    int score;

    Participant(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class Leaderboard {

    static void sortParticipants(Participant[] arr) {

        for (int i = 1; i < arr.length; i++) {

            Participant key = arr[i];
            int j = i - 1;

            while (j >= 0 &&
                    arr[j].score < key.score) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    static void printRanks(Participant[] arr) {

        sortParticipants(arr);

        int rank = 1;

        for (int i = 0; i < arr.length; i++) {

            if (i > 0 &&
                    arr[i].score != arr[i - 1].score)
                rank = i + 1;

            System.out.println(
                    rank + " " +
                            arr[i].name + " " +
                            arr[i].score);
        }
    }
}