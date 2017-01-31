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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.Data;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class App {
    @Data
    @Builder
    public static class Box {
        private String base;
        private String prefix;
        private String suffix;
    }

    public static void fun1() throws IOException {
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
        // 遗物、符文
        writeAll("D:\\game\\THQ\\database",
                 "records\\item\\animalrelics",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/relic/animalrelics",
                 1,
                 1);
        // 遗物、符文2
        writeAll("D:\\game\\THQ\\database",
                 "records\\item\\relics",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/relic/relics",
                 1,
                 1);
        // ///////////////////////////////////////////////////////////////////////////
        // 剑
        writeAll("D:\\game\\THQ\\database",
                 "records\\xpack\\item\\equipmentweapons\\sword",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/xpack/xpack/sword/swords",
                 1,
                 4);
        // 法杖
        writeAll("D:\\game\\THQ\\database",
                 "records\\xpack\\item\\equipmentweapons\\staff",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/xpack/staff/staffs",
                 2,
                 4);
        // 枪
        writeAll("D:\\game\\THQ\\database",
                 "records\\xpack\\item\\equipmentweapons\\spear",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/xpack/spear/spears",
                 1,
                 5);
        // 锤
        writeAll("D:\\game\\THQ\\database",
                 "records\\xpack\\item\\equipmentweapons\\club",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/xpack/club/clubs",
                 2,
                 3);
        // 弓
        writeAll("D:\\game\\THQ\\database",
                 "records\\xpack\\item\\equipmentweapons\\bow",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/xpack/bow/bows",
                 1,
                 4);
        // 斧
        writeAll("D:\\game\\THQ\\database",
                 "records\\xpack\\item\\equipmentweapons\\axe",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/xpack/axe/axes",
                 2,
                 3);
        // 盾
        writeAll("D:\\game\\THQ\\database",
                 "records\\xpack\\item\\equipmentweapons\\shield",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/xpack/shield/shields",
                 2,
                 3);
        // 戒指
        writeAll("D:\\game\\THQ\\database",
                 "records\\xpack\\item\\equipmentarmor\\ring",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/xpack/ring/rings",
                 1,
                 1);
        // 冠
        writeAll("D:\\game\\THQ\\database",
                 "records\\xpack\\item\\equipmentarmor\\helm",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/xpack/helm/helms",
                 2,
                 2);
        // 腿
        writeAll("D:\\game\\THQ\\database",
                 "records\\xpack\\item\\equipmentarmor\\greaves",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/xpack/greave/greaves",
                 2,
                 2);
        // 胸
        writeAll("D:\\game\\THQ\\database",
                 "records\\xpack\\item\\equipmentarmor\\torso",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/xpack/torso/torsos",
                 2,
                 3);
        // 腕
        writeAll("D:\\game\\THQ\\database",
                 "records\\xpack\\item\\equipmentarmor\\armband",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/xpack/armband/armbands",
                 2,
                 2);
        // 项链
        writeAll("D:\\game\\THQ\\database",
                 "records\\xpack\\item\\equipmentarmor\\amulet",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/xpack/amulet/amulets",
                 1,
                 1);
        // 遗物、符文
        writeAll("D:\\game\\THQ\\database",
                 "records\\xpack\\item\\relics",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/xpack/relic/relics",
                 1,
                 1);
        // 符咒
        writeAll("D:\\game\\THQ\\database",
                 "records\\xpack\\item\\charms",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/xpack/charm/charms",
                 1,
                 1);
        // 神器
        writeAll("D:\\game\\THQ\\database",
                 "records\\xpack\\item\\artifacts",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/xpack/artifact/artifacts",
                 2,
                 2);
        // 神器2
        writeAll("D:\\game\\THQ\\database",
                 "records\\xpack\\item\\artifacts\\arcaneformulae",
                 "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/all/xpack/artifact/arcaneformulae",
                 2,
                 2);
    }

    public static void fun2() throws IOException {
        writeFull("D:\\game\\THQ\\database",
                  "records\\item\\equipmentamulet\\c16_amulet03.dbr",
                  "C:/Users/shengjie/Documents/My Games/Titan Quest - Immortal Throne/SaveData/Sys/储物仓库/c16_amulet03/c16_amulet03",
                  1,
                  1);
    }

    public static void main(String[] args) throws IOException {
        //
        fun1();
        //
        // fun2();
    }

    public static void writeFull(String root,
                                 String item,
                                 String out,
                                 int w,
                                 int h) throws IOException {
        // prefix
        List<String> prefix = new ArrayList<String>();
        prefix.addAll(Files.list(Paths.get(root,
                                           "records\\item\\lootmagicalaffixes\\prefix\\default"))
                           .filter(p -> p.toFile()
                                         .isFile() && p.getFileName()
                                                       .toString()
                                                       .endsWith(".dbr"))
                           .map(path -> "records\\item\\lootmagicalaffixes\\prefix\\default\\" + path.getFileName()
                                                                                                     .toString())
                           .collect(Collectors.toList()));
        prefix.addAll(Files.list(Paths.get(root,
                                           "records\\xpack\\item\\lootmagicalaffixes\\prefix\\default"))
                           .filter(p -> p.toFile()
                                         .isFile() && p.getFileName()
                                                       .toString()
                                                       .endsWith(".dbr"))
                           .map(path -> "records\\xpack\\item\\lootmagicalaffixes\\prefix\\default\\" + path.getFileName()
                                                                                                            .toString())
                           .collect(Collectors.toList()));
        // suffix
        List<String> suffix = new ArrayList<String>();
        suffix.addAll(Files.list(Paths.get(root,
                                           "records\\item\\lootmagicalaffixes\\suffix\\default"))
                           .filter(p -> p.toFile()
                                         .isFile() && p.getFileName()
                                                       .toString()
                                                       .endsWith(".dbr"))
                           .map(path -> "records\\item\\lootmagicalaffixes\\suffix\\default\\" + path.getFileName()
                                                                                                     .toString())
                           .collect(Collectors.toList()));
        suffix.addAll(Files.list(Paths.get(root,
                                           "records\\xpack\\item\\lootmagicalaffixes\\suffix\\default"))
                           .filter(p -> p.toFile()
                                         .isFile() && p.getFileName()
                                                       .toString()
                                                       .endsWith(".dbr"))
                           .map(path -> "records\\xpack\\item\\lootmagicalaffixes\\suffix\\default\\" + path.getFileName()
                                                                                                            .toString())
                           .collect(Collectors.toList()));
        //
        long total = prefix.size() * suffix.size();
        System.out.println("总数：" + total);
        //
        final AtomicInteger roll = new AtomicInteger(0);
        final List<Box> boxes = new ArrayList<App.Box>();
        int[][] r = slots(w,
                          h);
        prefix.forEach(p -> {
            suffix.forEach(s -> {
                //
                if (boxes.size() >= r.length) {
                    writeBoxes(out + "_" + roll.getAndIncrement() + ".TQChest",
                               r,
                               boxes);
                    boxes.clear();
                }
                //
                boxes.add(Box.builder()
                             .base(item)
                             .prefix(p)
                             .suffix(s)
                             .build());
            });
        });
        //
        if (boxes.size() > 0) {
            writeBoxes(out + "_" + roll.get() + ".TQChest",
                       r,
                       boxes);
            boxes.clear();
        }
    }

    public static void writeAll(String root,
                                String prefix,
                                String out,
                                int w,
                                int h) throws IOException {
        //
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
        //
        final AtomicInteger roll = new AtomicInteger(0);
        final List<Box> boxes = new ArrayList<App.Box>();
        allPaths.forEach(a -> {
            //
            if (boxes.size() >= r.length) {
                writeBoxes(out + "_" + roll.getAndIncrement() + ".TQChest",
                           r,
                           boxes);
                boxes.clear();
            }
            //
            boxes.add(Box.builder()
                         .base(prefix + "\\" + a.getFileName()
                                                .toString())
                         .build());
        });
        //
        if (boxes.size() > 0) {
            writeBoxes(out + "_" + roll.get() + ".TQChest",
                       r,
                       boxes);
            boxes.clear();
        }
    }

    public static void writeBoxes(String itemFile,
                                  int[][] r,
                                  List<Box> boxes) {
        if (boxes.size() > r.length) {
            System.out.println("出现异常，最大容量数目：[" + r.length + "]，实际数目：[" + boxes.size() + "]");
        } else {
            final AtomicInteger index = new AtomicInteger(0);
            //
            writeInt(itemFile,
                     boxes.size(),
                     4,
                     ByteOrder.LITTLE_ENDIAN);
            boxes.forEach(box -> {
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
                                     box.getBase());
                //
                writeStringAndLength(itemFile,
                                     "prefixName");
                if (box.getPrefix() == null) {
                    writeInt(itemFile,
                             0,
                             4,
                             ByteOrder.LITTLE_ENDIAN);
                } else {
                    writeStringAndLength(itemFile,
                                         box.getPrefix());
                }
                //
                writeStringAndLength(itemFile,
                                     "suffixName");
                if (box.getSuffix() == null) {
                    writeInt(itemFile,
                             0,
                             4,
                             ByteOrder.LITTLE_ENDIAN);
                } else {
                    writeStringAndLength(itemFile,
                                         box.getSuffix());
                }
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
            });
        }
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
