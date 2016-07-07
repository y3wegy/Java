package com.utils;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 3/22/13
 * Time: 9:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class FilePathUtils {
    private static final String classDirPath = FilePathUtils.class.getClassLoader().getResource("").getPath().substring(1);
    // = FilePathUtils.class.getResource("/").getPath().substring(1) =Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(1)

    private static final String currentClassFilePath = FilePathUtils.class.getResource("").getPath().substring(1);

    public static String getFilepathInClass(String path) {
        return classDirPath + path;
    }

    public static final String getFilePathInSrc(String path) {
        return classDirPath + "../src/" + path;
    }

    public static final String getFilepathInOtherDir(String dir, String path) {
        return classDirPath + "../" + dir + path;
    }

    public static final String getFilepathRelative(String path) {
        return null;
    }
}
