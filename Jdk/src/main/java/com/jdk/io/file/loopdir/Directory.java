package com.jdk.io.file.loopdir;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/3/13
 * Time: 5:58 PM
 * To change this template use File | Settings | File Templates.
 */
public final class Directory {
    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    public static File[] local(String path, final String regex) {
        return local(new File(path), regex);
    }

    public static TreeInfo walk(File dir, final String regex) {
        return recureseDirs(dir, regex);
    }

    public static TreeInfo walk(String dir, final String regex) {
        return walk(new File(dir), regex);
    }

    public static TreeInfo walk(File file) {
        return recureseDirs(file, ".*");
    }

    public static TreeInfo walk(String dir) {
        return walk(new File(dir));
    }

    static TreeInfo recureseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        for (File file : startDir.listFiles()) {
            if (file.isDirectory()) {
                result.dirs.add(file);
                result.addAll(recureseDirs(file, regex));
            } else if (file.getName().matches(regex))
                result.files.add(file);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(walk("."));
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<File>();
        public List<File> dirs = new ArrayList<File>();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Dirs:");
            for (File file : dirs)
                stringBuilder.append(file.getName()).append("\n");
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append("\nFiles:");
            for (File file : files)
                stringBuilder.append(file.getName()).append("\n");
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return stringBuilder.toString();
        }
    }
}
