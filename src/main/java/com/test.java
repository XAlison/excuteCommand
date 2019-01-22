package com;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import sun.misc.BASE64Encoder;

/**
 * @ClassName: test
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2019/1/16 15:38
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) {

        String image = getImage();
        System.err.print(image);

    }

    private static String getImage() {
        File f = new File("e:/1.jpg");
        BufferedImage bi;
        try {
            bi = ImageIO.read(f);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", stream);
            byte[] bytes = stream.toByteArray();
            BASE64Encoder encoder = new sun.misc.BASE64Encoder();
            return encoder.encodeBuffer(bytes).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*public static void main(String[] args) {
        String s = "INSERT INTO `sys_menu` VALUES ('15E7FAA050D04E41AA58C8DD2BEA1EEE', NULL, '功能点', NULL, NULL, 250, '2', 1,  'NEW_TENANT_ID');\n" +
                "INSERT INTO `sys_menu` VALUES ('15E7FAE3A17042C2AF77407DB0DE555A', '15E7FAA050D04E41AA58C8DD2BEA1EEE', '通讯录', NULL, NULL, 200, '2', 2,  'NEW_TENANT_ID');\n";
        String str = "[?a-zA-Z0-9]{8}-?[?a-zA-Z0-9]{4}-?[?a-zA-Z0-9]{4}-?[?a-zA-Z0-9]{4}-?[?a-zA-Z0-9]{12}";
        Matcher m = Pattern.compile(str).matcher(s);
        List<String> uuidLists = new ArrayList<>();
        while (m.find()) {
            if (!uuidLists.contains(m.group(0))) {
                uuidLists.add(m.group(0));
            }
        }
        for (String uuid : uuidLists) {
            s = s.replaceAll(uuid, UUID.randomUUID().toString()).replaceAll("NEW_TENANT_ID",UUID.randomUUID().toString());
        }

        System.err.print(s);
    }*/
}
