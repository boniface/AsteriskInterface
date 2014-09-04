/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.dayler.common.util.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author asalazar
 */
public class IOUtils {

//    InputStream is = ...
//ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//
//int nRead;
//byte[] data = new byte[16384];
//
//while ((nRead = is.read(data, 0, data.length)) != -1) {
//  buffer.write(data, 0, nRead);
//}
//
//buffer.flush();
//
//return buffer.toByteArray();


//    byte[] imgDataBa = new byte[(int)imgFile.length()];
//DataInputStream dataIs = new DataInputStream(new FileInputStream(imgFile));
//dataIs.readFully(imgDataBa);

    public static byte[] inputStreamToByteArray(InputStream is) throws IOException {

        ByteArrayOutputStream os = null;

        try {
            os = new ByteArrayOutputStream();
            byte[] buffer = new byte[0xFFFF];

            for (int len; (len = is.read(buffer)) != -1; ) {
                os.write(buffer, 0, len);
            }

            os.flush();

            return os.toByteArray();
        } catch (IOException ex) {
            return null;
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }
}
