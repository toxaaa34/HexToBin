import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;

public class main {
    public static void main(String[] args) {
        try {
            String s1 = new String(Files.readAllBytes(FileSystems.getDefault().getPath("C:/test/test1.txt")));
            InputStream is = new FileInputStream("C:/test/test_1.docx");
            String s2;
            byte[] data = new byte[s1.length() / 3];
            StringBuilder sb = new StringBuilder();
            for (byte b : is.readAllBytes()) {
                sb.append(String.format("%02X ", b));
            }
            s2 = sb.toString();
            // System.out.println(s2);
            if (s1.equals(s2)) System.out.println("s1 = s2");
            else System.out.println("s1 != s2");
            int j = 0;
            for (int i = 0; i < s1.length(); i = i+3) {
                s1 = s1.trim();
                data[i/3] = (byte) ((Character.digit(s1.charAt(i), 16) << 4) + Character.digit(s1.charAt(i+1), 16));;
            }
            OutputStream os = new FileOutputStream("C:/test/final.docx");
            os.write(data);

            System.out.println(java.util.Arrays.toString(data));


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
