package com.bham.pij.assignments.candidates;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * FileUtils
 *
 * @author Martin de Spirlet
 */
public class FileUtils {

    /**
     * Returns a list of lines read from the file at the specified path. Note that
     * this method does not throw any of its exceptions to its caller.
     *
     * @param path the path to the file to be read.
     * @return a list of lines read from the file at the specified path.
     */
    public static List<String> readLinesFromFile(String path) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            System.out.println("Reading lines from " + path + "...");

            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file " + path + " does not exist or cannot be opened for reading.");
        } catch (Exception e) {
            System.out.println("An input error has occurred.");
            e.printStackTrace();
        }

        return lines;
    }

    /**
     * Prints the specified list of lines to a file at the specified path. Note that
     * this method does not throw any of its exceptions to its caller.
     *
     * @param path  the path of the file to be written.
     * @param lines the list of lines to be printed.
     */
    public static void printLinesToFile(String path, List<String> lines) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            System.out.println("Writing lines to " + path + "...");

            for (String line : lines) {
                writer.println(line);
            }

            System.out.println("Lines written to " + path + ".");
        } catch (Exception e) {
            System.out.println("The file " + path + " cannot be created or cannot be opened for writing.");
        }
    }

}
