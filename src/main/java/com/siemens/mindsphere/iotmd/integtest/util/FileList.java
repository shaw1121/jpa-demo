package com.siemens.mindsphere.iotmd.integtest.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class FileList {

    public static List<String> getFileList(String filePath) {
        FilenameFilter filter = new FileFilter("tenant");
        List<String> list = new ArrayList<String>();
        File dir = new File(filePath);
        putName2List(list,filter, dir);

        return list;
    }

    private static void putName2List(List<String> list, FilenameFilter filter, File dir) {
        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                putName2List(list, filter, file);
            } else {
                if (filter.accept(file, file.getName())) {
                    list.add(file.getAbsolutePath());
                }
            }
        }
    }
}
