/**
 * Recording
 */
public class Recording {

    private static final int SECONDS_PER_MINUTE = 60;

    private String title;
    private String artist;
    private int playingTimeSeconds;

    public Recording(String title, String artist, int playingTimeSeconds) {
        this.title = title;
        this.artist = artist;
        this.playingTimeSeconds = playingTimeSeconds;
    }

    public Recording() {
        this(null, null, 0);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getPlayingTimeSeconds() {
        return playingTimeSeconds;
    }

    public void setPlayingTimeSeconds(int durationSeconds) {
        this.playingTimeSeconds = durationSeconds;
    }

    @Override
    public String toString() {
        return title + " by " + artist + " (" + playingTimeSeconds / SECONDS_PER_MINUTE + ":"
                + String.format("%02d", playingTimeSeconds % SECONDS_PER_MINUTE) + ")";
    }

}
