package com.cang.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StreamUtils {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:\\test");
        FileInputStream fileInputStream = new FileInputStream(file);
    }
}
