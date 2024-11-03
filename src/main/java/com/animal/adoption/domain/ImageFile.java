package com.animal.adoption.domain;

import lombok.Data;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

@Data
public class ImageFile {
    private String base64;
    private String fileName;

    private byte[] getBytes() {
        return Base64.getDecoder().decode(base64);
    }

    public String saveToFile(String folder) throws Exception {
        String name = System.currentTimeMillis() + fileName.substring(fileName.indexOf("."));
        FileOutputStream fos = new FileOutputStream(new File(folder + name));
        fos.write(getBytes());
        return name;
    }
}
