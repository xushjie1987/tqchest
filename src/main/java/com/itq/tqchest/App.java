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

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        writeAll("D:\\game\\THQ\\database",
                 "records\\item\\equipmentamulet",
                 "test/1");
    }

    public static void writeAll(String root,
                                String prefix,
                                String out) throws IOException {
        Files.list(Paths.get(root,
                             prefix))
             .filter(p -> p.toFile()
                           .isFile() && p.getFileName()
                                         .toString()
                                         .endsWith(".dbr"))
             .forEach(a -> {
                 String itemName = a.getFileName()
                                    .toString();
                 String itemPath = prefix + "\\" + itemName;
                 String itemFile = out + "/" + itemName + ".TQChest";
                 //
                 writeInt(itemFile,
                          1,
                          4,
                          ByteOrder.LITTLE_ENDIAN);
                 writeStringAndLength(itemFile,
                                      "stackCount");
                 writeInt(itemFile,
                          0,
                          4,
                          ByteOrder.LITTLE_ENDIAN);
                 //
                 writeStringAndLength(itemFile,
                                      "begin_block");
                 writeBeginEndBlock(itemFile,
                                    0xCEFA1DB0);
                 //
                 writeStringAndLength(itemFile,
                                      "baseName");
                 //
                 writeStringAndLength(itemFile,
                                      itemPath);
                 //
                 writeStringAndLength(itemFile,
                                      "prefixName");
                 writeInt(itemFile,
                          0,
                          4,
                          ByteOrder.LITTLE_ENDIAN);
                 //
                 writeStringAndLength(itemFile,
                                      "suffixName");
                 writeInt(itemFile,
                          0,
                          4,
                          ByteOrder.LITTLE_ENDIAN);
                 //
                 writeStringAndLength(itemFile,
                                      "relicName");
                 writeInt(itemFile,
                          0,
                          4,
                          ByteOrder.LITTLE_ENDIAN);
                 //
                 writeStringAndLength(itemFile,
                                      "relicBonus");
                 writeInt(itemFile,
                          0,
                          4,
                          ByteOrder.LITTLE_ENDIAN);
                 //
                 writeStringAndLength(itemFile,
                                      "seed");
                 writeInt(itemFile,
                          0,
                          4,
                          ByteOrder.LITTLE_ENDIAN);
                 //
                 writeStringAndLength(itemFile,
                                      "var1");
                 writeInt(itemFile,
                          0,
                          4,
                          ByteOrder.LITTLE_ENDIAN);
                 //
                 writeStringAndLength(itemFile,
                                      "end_block");
                 writeBeginEndBlock(itemFile,
                                    0xDEC0ADDE);
                 //
                 writeStringAndLength(itemFile,
                                      "xOffset");
                 writeInt(itemFile,
                          0,
                          4,
                          ByteOrder.LITTLE_ENDIAN);
                 //
                 writeStringAndLength(itemFile,
                                      "yOffset");
                 writeInt(itemFile,
                          0,
                          4,
                          ByteOrder.LITTLE_ENDIAN);
             });
    }

    public static void writeBeginEndBlock(String file,
                                          int beginOrEnd) {
        writeInt(file,
                 beginOrEnd,
                 4,
                 ByteOrder.BIG_ENDIAN);
    }

    public static void writeStringAndLength(String file,
                                            String s) {
        writeInt(file,
                 s.length(),
                 4,
                 ByteOrder.LITTLE_ENDIAN);
        write(file,
              s.getBytes());
    }

    public static void writeInt(String file,
                                int i,
                                int length,
                                ByteOrder order) {
        ByteBuffer bb = ByteBuffer.allocate(length);
        bb.order(order);
        bb.putInt(i);
        write(file,
              bb.array());
    }

    private static void write(String file,
                              byte[] bs) {
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = FileUtils.openOutputStream(new File(file),
                                             true);
            dos = new DataOutputStream(fos);
            dos.write(bs);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fos);
            IOUtils.closeQuietly(dos);
        }
    }
}
