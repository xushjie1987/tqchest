package com.itq.tqchest;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void test1() {
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = FileUtils.openOutputStream(new File("test/test1.bin"),
                                             true);
            dos = new DataOutputStream(fos);
            dos.writeInt(59);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fos);
            IOUtils.closeQuietly(dos);
        }
    }

    @Test
    public void test2() {
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = FileUtils.openOutputStream(new File("test/test2.bin"),
                                             true);
            dos = new DataOutputStream(fos);
            dos.write(59);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fos);
            IOUtils.closeQuietly(dos);
        }
    }

    @Test
    public void test3() {
        ByteBuffer bb = ByteBuffer.allocate(100);
        bb.putInt(59);
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = FileUtils.openOutputStream(new File("test/test3.bin"),
                                             true);
            dos = new DataOutputStream(fos);
            dos.write(bb.array());
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fos);
            IOUtils.closeQuietly(dos);
        }
    }

    @Test
    public void test4() {
        ByteOrder bo = ByteOrder.LITTLE_ENDIAN;
        ByteBuffer bb = ByteBuffer.allocate(4);
        bb.order(bo);
        bb.putInt(59);
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = FileUtils.openOutputStream(new File("test/test4.bin"),
                                             true);
            dos = new DataOutputStream(fos);
            dos.write(bb.array());
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fos);
            IOUtils.closeQuietly(dos);
        }
    }

    @Test
    public void test5() throws IOException {
        Files.list(Paths.get("F:/github/tqchest/test"))
             .forEach(System.out::println);
    }

    @Test
    public void test6() throws IOException {
        Files.list(Paths.get("F:/github/tqchest/test"))
             .forEach(p -> System.out.println(p.getFileName()));
    }

    @Test
    public void test7() throws IOException {
        Files.list(Paths.get("D:/game/THQ/database/records"))
             .forEach(p -> System.out.println(p.getFileName()));
    }

    @Test
    public void test8() {
        ByteBuffer bb = ByteBuffer.allocate(100);
        bb.putInt(0xCEFA1DB0);
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = FileUtils.openOutputStream(new File("test/test8.bin"),
                                             true);
            dos = new DataOutputStream(fos);
            dos.write(bb.array());
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fos);
            IOUtils.closeQuietly(dos);
        }
    }

}
