package com.bham.pij.assignments.candidates;

import java.util.ArrayList;
import java.util.List;

/**
 * CV
 *
 * @author Martin de Spirlet
 */
public class CV {

    public static class Position {

        private String title = "";
        private String experience = "";

        /**
         * Creates a new position with the specified title and experience.
         *
         * @param title      the title of the position.
         * @param experience the experience of the position.
         */
        public Position(String title, String experience) {
            this.title = title;
            this.experience = experience;
        }

        /**
         * Creates a new position with the specified title.
         *
         * @param title the title of the position.
         */
        public Position(String title) {
            this(title, "");
        }

        /**
         * Sets the experience of this position.
         *
         * @param experience the experience to set.
         */
        public void setExperience(String experience) {
            this.experience = experience;
        }

    }

    private String identifierSuffix;
    private String fieldDelim;
    private String replacement;

    private String identifier = "";
    private String qualification = "";
    private List<Position> positions = new ArrayList<>();
    private String email = "";

    /**
     * Creates a new CV with the specified identifier suffix, field delimiter and
     * delimiter replacement. The identifier suffix is appended to the identifier of
     * this CV in its string representation. The field delimiter is used to join the
     * fields of this CV in its string representation. All occurrences of the field
     * delimiter within a field are replaced by the delimiter replacement when the
     * field is set.
     *
     * @param identifierSuffix the string to be appended to the identifier of this
     *                         CV in its string representation.
     * @param fieldDelim       the field delimiter to be used to join the fields of
     *                         this CV in its string representation.
     * @param replacement      the delimiter replacement for occurrences of the
     *                         field delimiter within a field.
     */
    public CV(String identifierSuffix, String fieldDelim, String replacement) {
        this.identifierSuffix = identifierSuffix;
        this.fieldDelim = fieldDelim;
        this.replacement = replacement;
    }

    /**
     * Creates a new CV with the specified field delimiter. The identifier suffix is
     * appended to the identifier of this CV in its string representation. The field
     * delimiter is used to join the fields of this CV in its string representation.
     *
     * @param identifierSuffix the string to be appended to the identifier of this
     *                         CV in its string representation.
     * @param fieldDelim       the field delimiter to be used to join the fields of
     *                         this CV in its string representation.
     */
    public CV(String identifierSuffix, String fieldDelim) {
        this(identifierSuffix, fieldDelim, null);
    }

    /**
     * Sets the identifier of this CV.
     *
     * @param identifier the identifier to set.
     */
    public void setIdentifier(String identifier) {
        this.identifier = sanitise(identifier);
    }

    /**
     * Sets the qualification of this CV.
     *
     * @param qualification the qualification to set.
     */
    public void setQualification(String qualification) {
        this.qualification = sanitise(qualification);
    }

    /**
     * Adds a position to this CV.
     *
     * @param position the position to add.
     */
    public void addPosition(Position position) {
        positions.add(new Position(sanitise(position.title), sanitise(position.experience)));
    }

    /**
     * Sets the email address of this CV.
     *
     * @param email the email address to set.
     */
    public void setEmail(String email) {
        this.email = sanitise(email);
    }

    /**
     * Returns the string representation of this CV by joining its fields into a
     * single line by the field delimiter of this CV in the order: identifier,
     * qualification, all position and experience pairs, and email. A trailing
     * delimiter exists at the end of the line.
     *
     * @return the string representation of this CV.
     */
    @Override
    public String toString() {
        String s = identifier + identifierSuffix + fieldDelim + qualification + fieldDelim;

        for (Position p : positions) {
            s += p.title + fieldDelim + p.experience + fieldDelim;
        }

        s += email + fieldDelim;

        return s;
    }

    /**
     * Returns the specified text with all occurrences of the field delimiter
     * replaced for the delimiter replacement if a delimiter replacement was
     * provided. If no delimiter replacement was provided, this method returns the
     * original text.
     *
     * @param text the text to sanitise.
     * @return the text with all occurrences of the field delimiter replaced for the
     *         delimiter replacement if a delimiter replacement was provided, or the
     *         original text otherwise.
     */
    private String sanitise(String text) {
        if (replacement == null) {
            return text;
        } else {
            return text.replaceAll(fieldDelim, replacement);
        }
    }

}
