/**
 * ScoreException
 */
@SuppressWarnings("serial")
public class ScoreException extends Exception {

    public ScoreException(int score) {
        super("Score is greater than 100: " + score);
    }

}
