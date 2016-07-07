package com.jdk.io.file.loopdir;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/4/13
 * Time: 9:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProcessFiles {

    private Strategy strategy;
    private String ext;

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public static void main(String[] args) {
        Strategy strategy = new Strategy() {
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        };
        new ProcessFiles(strategy, "java").start(args);

    }

    public void start(String[] args) {

        try {
            if (args.length == 0)
                processDirectoryTree(new File("."));
            else
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory())
                        processDirectoryTree(fileArg);
                    else {
                        if (!arg.endsWith("." + ext))
                            arg += "." + ext;
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext))
            strategy.process(file.getCanonicalFile());
    }

    public interface Strategy {
        void process(File file);
    }
}
