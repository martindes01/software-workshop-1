package com.bham.pij.assignments.candidates;

/**
 * JobCandidatesMain
 *
 * @author Martin de Spirlet
 */
public class JobCandidatesMain {

    public static void main(String[] args) {
        new CleaningUp().cleanUpFile();

        new CandidatesToInterview().findCandidates();

        new CandidatesToInterview().candidatesWithExperience();

        new CandidatesToInterview().createCSVFile();

        new CandidatesToInterview().createReport();
    }

}
