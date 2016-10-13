package ru.sbt.encripted;


import java.io.*;

public class EncryptedClassLoader extends ClassLoader {

    private final String key;

    private final File dir;

    public EncryptedClassLoader(String key, File dir, ClassLoader parent) {
        super(parent);
        this.key = key;
        this.dir = dir;
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = dir.getName().concat(name).concat(".class");
            byte[] bytes = Decript(key, path);
            return  super.defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] Decript(String key, String path){
        long length = new File(path).length();
        byte[] bytes = new byte[(int) length];
        try {
            InputStream in = new FileInputStream(new File(path));
            Byte byteKey = Byte.parseByte(key);
            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length
                    && (numRead = in.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }
            // Ensure all the bytes have been read in
            if (offset < bytes.length) {
                throw new IOException("Could not completely read file " + path);
            }

            // Close the input stream and return bytes
            in.close();
            for (byte b: bytes) {
                b = b++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return bytes;

    }
}
