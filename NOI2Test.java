package com.p9;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

public class NOI2Test {
    public static void main(String[] args)
    throws IOException {
        Path path = Paths.get(
                System.getProperty("user.dir")
        );
        try(DirectoryStream<Path> stream =
                    Files.newDirectoryStream(path,"*.{png,java}")) {
            for (Path entry : stream) {
                ShowInfo(entry);
            }
        }
    }

    static void ShowInfo(Path path)
        throws IOException {
        System.out.print(path.getFileName());
        System.out.print(Files.isDirectory(path));
        System.out.print(Files.size(path));
        DosFileAttributes attributes = Files.readAttributes(
                path,DosFileAttributes.class
        );
        System.out.print(attributes.creationTime());
        System.out.print(attributes.isReadOnly());
        System.out.print(attributes.isDirectory());
        System.out.print(attributes.size());
        System.out.println(".");

    }
}
