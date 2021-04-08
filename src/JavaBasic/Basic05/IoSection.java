package JavaBasic.Basic05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class IoSection {
    public static void main(String[] args) throws FileNotFoundException {
        //获得当前工程的绝对路径
        File f = new File(IoSection.class.getResource("/").getPath());
        System.out.println(f);

        //获得当前类的绝对路径
        File f1 = new File(IoSection.class.getResource("").getPath());
        System.out.println(f1);

        File file = new File(f1.getAbsolutePath()+"/IoSection.md");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());

        RandomAccessFile raf = new RandomAccessFile("./IoSection.md","rw");

    }
}
