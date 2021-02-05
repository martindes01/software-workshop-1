import java.util.Scanner;

public class TestScore {

    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        int[][] students = new int[5][2];

        for (int i = 0; i < 5; ++i) {
            students[i][0] = i;

            try {
                students[i][1] = getStudentScore(i);
            } catch (ScoreException e) {
                students[i][1] = 0;
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 5; ++i) {
            System.out.println("Student " + students[i][0] + " achieved a score of " + students[i][1] + ".");
        }

        sc.close();
    }

    public static int getStudentScore(int studentID) throws ScoreException {
        System.out.println("Enter score for student " + studentID + ":");
        int score = Integer.parseInt(sc.nextLine());

        if (score > 100) {
            throw new ScoreException(score);
        }

        return score;
    }

}
