package org.example;

import java.io.File;

public class MV {
    public void mv(String source, String destination) {
        File sourceFile = new File(source);
        File destinationFile = new File(destination);

        // Debugging output
        System.out.println("Source path: " + sourceFile.getAbsolutePath());
        System.out.println("Destination path: " + destinationFile.getAbsolutePath());

        // Check if source file/directory exists
        if (!sourceFile.exists()) {
            StatusReporter.ErrorMessage("Error: Source file/directory does not exist.");
            return;
        }

        // If destination is a directory, create the destination path
        if (destinationFile.isDirectory()) {
            destinationFile = new File(destinationFile, sourceFile.getName());
        } else {
            // If the destination exists and is not a directory, notify the user
            if (destinationFile.exists()) {
                StatusReporter.ErrorMessage("Error: Destination file already exists. Operation cannot proceed.");
                return;
            }
        }

        // Attempt to rename/move the file/directory
        if (sourceFile.renameTo(destinationFile)) {
            StatusReporter.SuccessMessage("File/Directory moved/renamed successfully to " + destinationFile.getAbsolutePath());
        } else {
            StatusReporter.ErrorMessage("Error: Failed to move/rename the file/directory. Check if the destination is valid and writable.");
        }
    }
}