package com.siemens.mindsphere.iotmd.integtest.util;

import java.io.File;
import java.io.FilenameFilter;

public class FileFilter implements FilenameFilter {

    private String filter;

    public FileFilter(String filter) {
        super();
        this.filter = filter;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.contains(filter);
    }
}
