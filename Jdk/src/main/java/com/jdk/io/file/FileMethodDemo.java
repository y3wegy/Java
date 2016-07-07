package com.jdk.io.file;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by a549238 on 4/16/2015.
 */
public class FileMethodDemo {
    @Test
    public void testFileSep() {
        System.out.println(File.separator);
        System.out.println(File.separatorChar);
    }

    @Test
    public void testFilterByType() {
        String path = getClass().getClassLoader().getResource(".").getPath();
        final String regex = ".+\\.ini";
        File file = new File(path);
        String[] list = file.list(
                new FilenameFilter() {
                    private Pattern pattern = Pattern.compile(regex);

                    @Override
                    public boolean accept(File dir, String name) {
                        return pattern.matcher(name).matches();
                    }
                }
        );
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String name : list)
            System.out.println(name);
    }

    @Test
    public void testPath() {
        File file = new File(".");
        System.out.println("file.getPath():" + file.getPath());
        System.out.println("file.getAbsolutePath():" + file.getAbsolutePath());
        try {
            System.out.println("file.getCanonicalPath():" + file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("System.getProperty(\"user.dir\"):" + System.getProperty("user.dir"));
    }

    @Test
    public void testResourcePath() {
        System.out.println(this.getClass().getClassLoader().getResource("").getPath());
        System.out.println(this.getClass().getResource("/").getPath());
        System.out.println(this.getClass().getResource("").getPath());
        String currentThreadPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(currentThreadPath);
        /*
        /C:/Workspace/IDEA_WS/Learning/JavaLearning/target/classes/
        /C:/Workspace/IDEA_WS/Learning/JavaLearning/target/classes/
        /C:/Workspace/IDEA_WS/Learning/JavaLearning/target/classes/com/demo/io/file/
        /C:/Workspace/IDEA_WS/Learning/JavaLearning/target/classes/
        */
    }

    @Test
    public void testRedirect() {
        PrintStream printStream = System.out;

    }

}
