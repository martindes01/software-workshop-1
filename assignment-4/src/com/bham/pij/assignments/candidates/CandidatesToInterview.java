package com.bham.pij.assignments.candidates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * CandidatesToInterview
 *
 * @author Martin de Spirlet
 */
public class CandidatesToInterview {

    private static final String CSV_FILE = "to-interview-table-format.csv";
    private static final String INTERVIEW_FILE = "to-interview.txt";
    private static final String INTERVIEW_EXPERIENCE_FILE = "to-interview-experience.txt";

    private static final String CSV_FIELD_DELIM = ",";
    private static final String INTERVIEW_FIELD_DELIM = " ";

    private static final int IDENTIFIER_INDEX = 0;
    private static final int QUALIFICATION_INDEX = 1;
    private static final int POSITION_START_INDEX = 2;
    private static final int POSITION_STEP = 2;
    private static final int POSITION_END_OFFSET = 2;
    private static final int CURRENT_EXPERIENCE_INDEX = 3;

    private static final List<String> QUALIFICATION_OPTIONS = new ArrayList<>(
            Arrays.asList("degree in computer science", "masters in computer science"));
    private static final List<String> POSITION_OPTIONS = new ArrayList<>(
            Arrays.asList("data analyst", "programmer", "computer programmer", "operator"));
    private static final int CURRENT_EXPERIENCE_THRESHOLD = 5;

    private static final int CSV_COLUMNS = 7;
    private static final int REPORT_COLUMNS = 5;

    private static final String IDENTIFIER_HEADING = "Identifier";
    private static final String QUALIFICATION_HEADING = "Qualification";
    private static final String POSITION_HEADING = "Position";
    private static final String EXPERIENCE_HEADING = "Experience";
    private static final String POSITION_ONE_HEADING = "Position1";
    private static final String EXPERIENCE_ONE_HEADING = "Experience1";
    private static final String POSITION_TWO_HEADING = "Position2";
    private static final String EXPERIENCE_TWO_HEADING = "Experience2";
    private static final String EMAIL_HEADING = "eMail";

    private static List<List<String>> intervieweeFields = new ArrayList<>();

    /**
     * Reads CVs in the "clean" format from an existing file `CleaningUp.CLEAN_FILE`
     * in the current directory, filters them according to qualification and
     * position, and writes them in the "interview" format to a file
     * `INTERVIEW_FILE` in the current directory. If `CleaningUp.CLEAN_FILE` does
     * not exist in the current directory, nothing will be written to
     * `INTERVIEW_FILE`.
     * <p>
     * The following assumptions are made regarding the "clean" format. Each CV
     * contains a number of fields separated by `CleaningUp.CLEAN_FIELD_DELIM`. Each
     * CV appears on its own line. Leading and trailing whitespace is stripped from
     * each field and no field contains the string `CleaningUp.CLEAN_FIELD_DELIM`.
     * The fields are not case sensitive. Each line contains, in this order, one
     * identifier, one qualification, a position and corresponding experience
     * (optional), a second position and corresponding experience (optional), and
     * one email address. A trailing delimiter exists at the end of each line.
     * <p>
     * The CVs written to `INTERVIEW_FILE` are those that contain a qualification
     * field listed in `QUALIFICATION_OPTIONS` and at least one position field
     * listed in `POSITION_OPTIONS`.
     * <p>
     * If the above assumptions regarding the "clean" format are correct, the
     * following assumptions can be made regarding the "interview" format. Each
     * "interview" CV comprises the same fields as its original "clean" CV, in the
     * same order, joined into a single line by the delimiter
     * `INTERVIEW_FIELD_DELIM`. There is no trailing delimiter at the end of the
     * line.
     */
    public void findCandidates() {
        // read all clean CVs into list
        List<String> cvs = FileUtils.readLinesFromFile(CleaningUp.CLEAN_FILE);

        List<String> interviewCVs = new ArrayList<>();

        // for each CV
        for (String cv : cvs) {
            // split CV into fields, including empty strings at end
            List<String> fields = new ArrayList<>(Arrays.asList(cv.split(CleaningUp.CLEAN_FIELD_DELIM, -1)));

            // if sufficient fields for CV to contain at least one position
            if (fields.size() > (POSITION_START_INDEX + POSITION_END_OFFSET)) {
                // map fields to lower case for comparison
                List<String> lowerCaseFields = fields.stream().map(e -> e.toLowerCase()).collect(Collectors.toList());

                // if lower case qualification field is listed in qualification options
                if (QUALIFICATION_OPTIONS.contains(lowerCaseFields.get(QUALIFICATION_INDEX))) {
                    // if at least one lower case position field is listed in position options
                    if (IntStream.range(POSITION_START_INDEX, lowerCaseFields.size() - POSITION_END_OFFSET)
                            .filter(e -> ((e - POSITION_START_INDEX) % POSITION_STEP) == 0)
                            .mapToObj(lowerCaseFields::get).anyMatch(POSITION_OPTIONS::contains)) {
                        // remove field caused by trailing delimiter
                        fields.remove(fields.size() - 1);

                        // add list of fields to list of interviewee fields
                        intervieweeFields.add(fields);

                        // join fields into interview CV and add to list of interview CVs
                        interviewCVs.add(String.join(INTERVIEW_FIELD_DELIM, fields));
                    }
                }
            }
        }

        // write interview CVs to file
        FileUtils.printLinesToFile(INTERVIEW_FILE, interviewCVs);
    }

    /**
     * Filters according to experience the CVs that were parsed and filtered by
     * `findCandidates()` during its most recent call and writes them in the
     * "experience" format to a file `INTERVIEW_EXPERIENCE_FILE` in the current
     * directory. This method relies on `findCandidates()` having been called
     * previously during this session. The method `findCandidates()` stores the CV
     * fields it parses and filters in a private static list that can be accessed
     * anywhere within `CandidatesToInterview` as long as it remains in memory.
     * Although this is not standard practice, it allows the parsing of a space
     * delimited file whose fields contain arbitrary spaces to be avoided. A hint
     * towards using this approach is presented in the assignment brief.
     * Additionally, the use of the static modifier allows this method to be called
     * on a separate instance of the `CandidatesToInterview` from the one on which
     * `findCandidates()` was originally called. If `findCandidates()` has not been
     * called correctly during this session, nothing will be written to
     * `INTERVIEW_EXPERIENCE_FILE`.
     * <p>
     * This method follows the same assumptions as `findCandidates()` regarding the
     * "clean" format. In particular, it is assumed that leading and trailing
     * whitespace is stripped from each field, and that no field contains the string
     * `CleaningUp.CLEAN_FIELD_DELIM`. It is also assumed that each CV stored by
     * `findCandidates()` contains at least `CURRENT_EXPERIENCE_INDEX` + 1 fields .
     * <p>
     * The CVs written to `INTERVIEW_EXPERIENCE_FILE` are a subset of those written
     * to `INTERVIEW_FILE` by `findCandidates()` during its most recent call. In
     * particular, this is the subset of CVs whose first experience field has a
     * value greater than `CURRENT_EXPERIENCE_THRESHOLD`.
     * <p>
     * If the above assumptions regarding the "clean" format and the method
     * `findCandidates()` are correct, the following assumptions can be made
     * regarding the "experience" format. Each "experience" entry comprises, in this
     * order, the identifier and first experience fields of its original "clean" CV,
     * joined into a single line by the delimiter `INTERVIEW_FIELD_DELIM`. There is
     * no trailing delimiter at the end of the line.
     */
    public void candidatesWithExperience() {
        List<String> intervieweeExperiences = new ArrayList<>();

        // for each list of fields
        for (List<String> fields : intervieweeFields) {
            int experience = 0;

            // try parsing current experience field as integer
            try {
                experience = Integer.parseInt(fields.get(CURRENT_EXPERIENCE_INDEX));
            } catch (Exception e) {
                // thrown if field cannot be parsed as integer
            }

            // if current experience exceeds threshold
            if (experience > CURRENT_EXPERIENCE_THRESHOLD) {
                // join identifier and experience and add to list of interviewee experiences
                intervieweeExperiences.add(fields.get(IDENTIFIER_INDEX) + INTERVIEW_FIELD_DELIM + experience);
            }
        }

        // write interviewee experiences to file
        FileUtils.printLinesToFile(INTERVIEW_EXPERIENCE_FILE, intervieweeExperiences);
    }

    /**
     * Writes the CVs that were parsed and filtered by `findCandidates()` during its
     * most recent call to a CSV file `CSV_FILE` in the current directory. This
     * method relies on `findCandidates()` having been called previously during this
     * session. The method `findCandidates()` stores the CV fields it parses and
     * filters in a private static list that can be accessed anywhere within
     * `CandidatesToInterview` as long as it remains in memory. Although this is not
     * standard practice, it allows the parsing of a space delimited file whose
     * fields contain arbitrary spaces to be avoided. A hint towards using this
     * approach is presented in the assignment brief. Additionally, the use of the
     * static modifier allows this method to be called on a separate instance of the
     * `CandidatesToInterview` from the one on which `findCandidates()` was
     * originally called. If `findCandidates()` has not been called correctly during
     * this session, only the field headings will be written to `CSV_FILE`.
     * <p>
     * This method follows the same assumptions as `findCandidates()` regarding the
     * "clean" format. In particular, it is assumed that leading and trailing
     * whitespace is stripped from each field, and that no field contains the string
     * `CleaningUp.CLEAN_FIELD_DELIM`. It is also assumed that the last field of
     * each CV stored by `findCandidates()` is the email field.
     * <p>
     * The CVs written to `CSV_FILE` are those written to `INTERVIEW_FILE` by
     * `findCandidates()` during its most recent call.
     * <p>
     * If the above assumptions regarding the "clean" format and the method
     * `findCandidates()` are correct, the following assumptions can be made
     * regarding the CSV format. The first line comprises, in this order, the field
     * headings `IDENTIFIER_HEADING`, `QUALIFICATION_HEADING`,
     * `POSITION_ONE_HEADING`, `EXPERIENCE_ONE_HEADING`, `POSITION_TWO_HEADING`,
     * `EXPERIENCE_TWO_HEADING` and `EMAIL_HEADING`, joined into a single line by
     * the delimiter `CSV_FIELD_DELIM`. The CVs are written on the following lines.
     * The fields of each CV are joined into a single line by the delimiter
     * `CSV_FIELD_DELIM` in the order: identifier, qualification, position and
     * corresponding experience, second position and corresponding experience, and
     * email. Where one of these fields is missing from a CV stored by
     * `findCandidates()`, it appears as an empty string (a blank field) such that
     * each line contains exactly `CSV_COLUMNS` fields, with the email field in the
     * last position. There is no trailing delimiter at the end of any line.
     */
    public void createCSVFile() {
        List<String> csvLines = new ArrayList<>();

        // add CSV column headings to CSV lines
        csvLines.add(String.join(CSV_FIELD_DELIM, IDENTIFIER_HEADING, QUALIFICATION_HEADING, POSITION_ONE_HEADING,
                EXPERIENCE_ONE_HEADING, POSITION_TWO_HEADING, EXPERIENCE_TWO_HEADING, EMAIL_HEADING));

        // for each list of fields
        for (List<String> fields : intervieweeFields) {
            // create blank CSV row
            String[] csvFields = new String[CSV_COLUMNS];
            Arrays.fill(csvFields, "");

            // for all CSV fields except last (email)
            int length = Math.min(fields.size(), CSV_COLUMNS) - 1;
            for (int i = 0; i < length; ++i) {
                // set CSV field to corresponding field
                csvFields[i] = fields.get(i);
            }

            // set last CSV field to last field (email)
            csvFields[CSV_COLUMNS - 1] = fields.get(fields.size() - 1);

            // join CSV fields into CSV line and add to CSV lines
            csvLines.add(String.join(CSV_FIELD_DELIM, csvFields));
        }

        // write CSV lines to file
        FileUtils.printLinesToFile(CSV_FILE, csvLines);
    }

    /**
     * Reads CVs from an existing CSV file `CSV_FILE` in the current directory and
     * prints them in a table to the default output stream. If `CSV_FILE` does not
     * exist in the current directory, only the field headings will be printed.
     * <p>
     * The following assumptions are made regarding the CSV format. The first line
     * contains only the field headings. Each CV is written on a subsequent line.
     * The fields of each CV are joined into a single line by the delimiter
     * `CSV_FIELD_DELIM` in the order: identifier, qualification, position and
     * corresponding experience, second position and corresponding experience, and
     * email. A field may be an empty string (a blank field) such that each line
     * contains exactly `CSV_COLUMNS` fields, with the email field in the last
     * position. There is no trailing delimiter at the end of any line.
     * <p>
     * If the above assumptions regarding the CSV file are correct, the following
     * assumptions can be made regarding the table. The first line comprises, in
     * this order, the field headings `IDENTIFIER_HEADING`, `QUALIFICATION_HEADING`,
     * `POSITION_HEADING`, `EXPERIENCE_HEADING` and `EMAIL_HEADING`, joined into a
     * single line by whitespace in a way that mimics the format shown in the
     * assignment brief. The CVs are printed on the following lines. The fields of
     * each CV are joined into a single line by the delimiter `\t` in the order:
     * identifier, qualification, position and corresponding experience, and email.
     * Note that the second position and corresponding experience of each CV is not
     * printed.
     */
    public void createReport() {
        // read all CSV lines into list
        List<String> csvLines = FileUtils.readLinesFromFile(CSV_FILE);

        // print report column headings
        System.out.println(String.join("\t", IDENTIFIER_HEADING, QUALIFICATION_HEADING + "\t\t", POSITION_HEADING,
                "\b   " + EXPERIENCE_HEADING, EMAIL_HEADING));

        // for each CSV line except first (column headings)
        for (String line : csvLines.subList(1, csvLines.size())) {
            // create blank report row
            String[] reportFields = new String[REPORT_COLUMNS];
            Arrays.fill(reportFields, "");

            // split CSV line into CSV fields
            String[] csvFields = line.split(CSV_FIELD_DELIM);

            // for all report fields except last (email)
            int length = Math.min(REPORT_COLUMNS, csvFields.length) - 1;
            for (int i = 0; i < length; ++i) {
                // set report field to corresponding CSV field
                reportFields[i] = csvFields[i];
            }

            // set last report field to last CSV field (email)
            reportFields[REPORT_COLUMNS - 1] = csvFields[csvFields.length - 1];

            // join report fields into report line and print
            System.out.println(String.join("\t", reportFields));
        }
    }

}
