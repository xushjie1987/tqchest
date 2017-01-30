package com.itq.tqchest;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class App {
    public static void main(String[] args) throws IOException {
        // 剑
        writeAll("D:\\game\\THQ\\database",
                 "records\\item\\equipmentweapon\\sword",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/sword/swords",
                 1,
                 4);
        // 法杖
        writeAll("D:\\game\\THQ\\database",
                 "records\\item\\equipmentweapon\\staff",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/staff/staffs",
                 2,
                 4);
        // 枪
        writeAll("D:\\game\\THQ\\database",
                 "records\\item\\equipmentweapon\\spear",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/spear/spears",
                 1,
                 5);
        // 锤
        writeAll("D:\\game\\THQ\\database",
                 "records\\item\\equipmentweapon\\club",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/club/clubs",
                 2,
                 3);
        // 弓
        writeAll("D:\\game\\THQ\\database",
                 "records\\item\\equipmentweapon\\bow",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/bow/bows",
                 1,
                 4);
        // 斧
        writeAll("D:\\game\\THQ\\database",
                 "records\\item\\equipmentweapon\\axe",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/axe/axes",
                 2,
                 3);
        // 盾
        writeAll("D:\\game\\THQ\\database",
                 "records\\item\\equipmentshield",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/shield/shields",
                 2,
                 3);
        // 戒指
        writeAll("D:\\game\\THQ\\database",
                 "records\\item\\equipmentring",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/ring/rings",
                 1,
                 1);
        // 冠
        writeAll("D:\\game\\THQ\\database",
                 "records\\item\\equipmenthelm",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/helm/helms",
                 2,
                 2);
        // 腿
        writeAll("D:\\game\\THQ\\database",
                 "records\\item\\equipmentgreaves",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/greave/greaves",
                 2,
                 2);
        // 胸
        writeAll("D:\\game\\THQ\\database",
                 "records\\item\\equipmentarmor",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/armor/armors",
                 2,
                 3);
        // 腕
        writeAll("D:\\game\\THQ\\database",
                 "records\\item\\equipmentarmband",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/armband/armbands",
                 2,
                 2);
        // 项链
        writeAll("D:\\game\\THQ\\database",
                 "records\\item\\equipmentamulet",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/amulet/amulets",
                 1,
                 1);
        // 符文
        writeAll("D:\\game\\THQ\\database",
                 "records\\item\\animalrelics",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/relic/relics",
                 1,
                 1);
    }

    public static void writeAll(String root,
                                String prefix,
                                String out,
                                int w,
                                int h) throws IOException {
        final AtomicInteger roll = new AtomicInteger(0);
        final AtomicInteger index = new AtomicInteger(0);
        int[][] r = slots(w,
                          h);
        List<Path> allPaths = Files.list(Paths.get(root,
                                                   prefix))
                                   .filter(p -> p.toFile()
                                                 .isFile() && p.getFileName()
                                                               .toString()
                                                               .endsWith(".dbr"))
                                   .collect(Collectors.toList());
        int total = allPaths.size();
        System.out.println("总数：" + total);
        final AtomicInteger counter = new AtomicInteger(0);
        allPaths.forEach(a -> {
            String itemName = a.getFileName()
                               .toString();
            String itemPath = prefix + "\\" + itemName;
            String baseName = out + "_";
            //
            String itemFile = null;
            if (index.get() < r.length) {
                itemFile = baseName + roll.get() + ".TQChest";
            } else {
                roll.incrementAndGet();
                index.set(0);
                itemFile = baseName + roll.get() + ".TQChest";
            }
            //
            if (index.get() == 0) {
                int less = total - counter.get();
                writeInt(itemFile,
                         less >= r.length
                                         ? r.length
                                         : less,
                         4,
                         ByteOrder.LITTLE_ENDIAN);
            }
            //
            writeStringAndLength(itemFile,
                                 "stackCount");
            writeInt(itemFile,
                     0,
                     4,
                     ByteOrder.LITTLE_ENDIAN);
            //
            writeStringAndLength(itemFile,
                                 "begin_block");
            writeBeginEndBlockOffset(itemFile,
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
            writeBeginEndBlockOffset(itemFile,
                                     0xDEC0ADDE);
            //
            writeStringAndLength(itemFile,
                                 "xOffset");
            writeInt(itemFile,
                     r[index.get()][0],
                     4,
                     ByteOrder.BIG_ENDIAN);
            //
            writeStringAndLength(itemFile,
                                 "yOffset");
            writeInt(itemFile,
                     r[index.get()][1],
                     4,
                     ByteOrder.BIG_ENDIAN);
            //
            index.incrementAndGet();
            counter.incrementAndGet();
        });
    }

    public static void writeBeginEndBlockOffset(String file,
                                                int beginEndOffset) {
        writeInt(file,
                 beginEndOffset,
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

    private static int[][] slots(int w,
                                 int h) {
        int[][] r = new int[(y.length / h) * (x.length / w)][2];
        int k = 0;
        for (int i = 0; i < x.length / w; i++) {
            for (int j = 0; j < y.length / h; j++) {
                r[k][0] = x[i * w];
                r[k][1] = y[j * h];
                k++;
            }
        }
        return r;
    }

    private static int[] x = { 0x0000, 0x803F, 0x0040, 0x4040, 0x8040, 0xA040 };
    private static int[] y = { 0x0000, 0x803F, 0x0040, 0x4040, 0x8040, 0xA040, 0xC040, 0xE040, 0x0041, 0x1041, 0x2041, 0x3041 };

}
