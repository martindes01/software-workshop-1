package com.bham.pij.assignments.candidates;

import java.util.ArrayList;
import java.util.List;

/**
 * CleaningUp
 *
 * @author Martin de Spirlet
 */
public class CleaningUp {

    public static final String CLEAN_FILE = "cleancv.txt";
    public static final String DIRTY_FILE = "dirtycv.txt";

    public static final String CLEAN_FIELD_DELIM = ",";
    public static final String KEY_VAL_DELIM = ":";

    private static final String CV_FLAG = "cv ";
    private static final String END_FLAG = "end";

    private static final String CV_NUMBER_FORMAT = "%04d";

    private static final String SURNAME_KEY = "surname";
    private static final String QUALIFICATION_KEY = "qualification";
    private static final String POSITION_KEY = "position";
    private static final String EXPERIENCE_KEY = "experience";
    private static final String EMAIL_KEY = "email";

    /**
     * Reads CVs in the "dirty" format from an existing file `DIRTY_FILE` in the
     * current directory and writes them in the "clean" format to a file
     * `CLEAN_FILE` in the current directory. If `DIRTY_FILE` does not exist in the
     * current directory, nothing will be written to `CLEAN_FILE`.
     * <p>
     * The following assumptions are made regarding the "dirty" format. Each CV
     * begins with `CV_FLAG`, a single valid integer (the CV number) and a line
     * terminator. Each CV contains a number of key-value pairs. The key and value
     * are separated by `KEY_VAL_DELIM`, and each pair appears on its own line. The
     * only value pairs parsed by this method are those that correspond to the keys
     * `SURNAME_KEY`, `QUALIFICATION_KEY`, `POSITION_KEY`, `EXPERIENCE_KEY` and
     * `EMAIL_KEY`. The keys are not case sensitive. Each CV contains, in this
     * order, one surname, one qualification, a position and corresponding
     * experience (optional), a second position and corresponding experience
     * (optional), and one email address. Within each CV, additional surname,
     * qualification and email lines cause their previous values to be overwritten.
     * Each CV ends with `END_FLAG` and a line terminator. Any lines that are not
     * part of a CV according to this format are ignored.
     * <p>
     * If the above assumptions regarding the "dirty" format are correct, the
     * following assumptions can be made regarding the "clean" format. Each value
     * parsed from a "dirty" CV becomes a field in the corresponding "clean" CV.
     * Leading and trailing whitespace is stripped from each field and all
     * occurrences of the string `CLEAN_FIELD_DELIM` within a field are removed. The
     * case of each character in a field is maintained. An identifier field is
     * created by appending the CV number, zero-padded to four digits, to the
     * surname field. The fields of each CV are joined into a single line by the
     * delimiter `CLEAN_FIELD_DELIM` in the order: identifier (required),
     * qualification (required), position and corresponding experience (optional),
     * second position and corresponding experience (optional), and email
     * (required). Where a required field is excluded, it appears as an empty string
     * (a blank field). Where an optional field is excluded, so is its following
     * delimiter. A trailing delimiter exists at the end of the line.
     */
    public void cleanUpFile() {
        // read all dirty lines into list
        List<String> dirtyLines = FileUtils.readLinesFromFile(DIRTY_FILE);

        List<String> cleanLines = new ArrayList<>();

        CV cv = null;
        CV.Position position = null;
        int cvNumber = 0;

        // for each dirty line
        for (String line : dirtyLines) {
            // if CV has not been created and line is CV header
            if ((cv == null) && (line.toLowerCase().startsWith(CV_FLAG))) {
                // get CV number
                try {
                    cvNumber = Integer.parseInt(line.substring(CV_FLAG.length()).strip());
                } catch (Exception e) {
                    System.out.println("The line \"" + line + "\" is invalid.");
                    System.out.println("The flag \"" + CV_FLAG
                            + "\" must be followed only by a single valid integer and a line terminator.");
                    System.out.println("The identifier of this CV entry will use the default or duplicate value "
                            + cvNumber + ".");
                }

                // create new CV
                cv = new CV(String.format(CV_NUMBER_FORMAT, cvNumber), CLEAN_FIELD_DELIM, "");
            } else {
                // split line into key-value pair
                String[] kvPair = line.split(KEY_VAL_DELIM, 2);

                switch (kvPair[0].strip().toLowerCase()) {
                    case SURNAME_KEY:
                        // set CV identifier to surname followed by formatted CV number
                        cv.setIdentifier(kvPair[1].strip());
                        break;
                    case QUALIFICATION_KEY:
                        // set CV qualification
                        cv.setQualification(kvPair[1].strip());
                        break;
                    case POSITION_KEY:
                        // create new position
                        position = new CV.Position(kvPair[1].strip());
                        break;
                    case EXPERIENCE_KEY:
                        // if position has been created
                        if ((position != null)) {
                            // set experience of position
                            position.setExperience(kvPair[1].strip());

                            // add position to CV
                            cv.addPosition(position);

                            // reset position
                            position = null;
                        }
                        break;
                    case EMAIL_KEY:
                        // set CV email
                        cv.setEmail(kvPair[1].strip());
                        break;
                    case END_FLAG:
                        // add CV line to list of clean lines
                        cleanLines.add(cv.toString());

                        // reset CV
                        cv = null;

                        // reset position
                        position = null;
                        break;
                }
            }
        }

        // write clean lines to file
        FileUtils.printLinesToFile(CLEAN_FILE, cleanLines);
    }

}
