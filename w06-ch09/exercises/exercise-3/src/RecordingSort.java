import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * RecordingSort
 */
public class RecordingSort {

    private static final String TITLE_OPTION = "t";
    private static final String ARTIST_OPTION = "a";
    private static final String PLAYING_TIME_OPTION = "p";
    private static final String EXIT_OPTION = "x";

    public static void main(String[] args) {
        List<Recording> recordings = new ArrayList<>();
        recordings.add(new Recording("title-2", "artist-3", 180));
        recordings.add(new Recording("title-5", "artist-5", 190));
        recordings.add(new Recording("title-4", "artist-2", 170));
        recordings.add(new Recording("title-1", "artist-4", 160));
        recordings.add(new Recording("title-3", "artist-1", 200));

        try (Scanner sc = new Scanner(System.in)) {
            String input;

            do {
                System.out.println(recordings);

                System.out.println("Press a key to sort the recordings:");
                System.out.println(TITLE_OPTION + " - sort by title");
                System.out.println(ARTIST_OPTION + " - sort by artist");
                System.out.println(PLAYING_TIME_OPTION + " - sort by playing time");
                System.out.println(EXIT_OPTION + " - exit");

                input = sc.nextLine();

                switch (input.toLowerCase()) {
                    case TITLE_OPTION:
                        recordings.sort((a, b) -> a.getTitle().compareTo(b.getTitle()));
                        break;
                    case ARTIST_OPTION:
                        recordings.sort((a, b) -> a.getArtist().compareTo(b.getArtist()));
                        break;
                    case PLAYING_TIME_OPTION:
                        recordings.sort((a, b) -> a.getPlayingTimeSeconds() - b.getPlayingTimeSeconds());
                        break;
                    default:
                        break;
                }
            } while (!input.equalsIgnoreCase(EXIT_OPTION));
        } catch (Exception e) {
        }
    }

}
