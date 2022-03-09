package Interface;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class FrameUtil {

    //工具类最好将构造器私有化
    private FrameUtil() {

    }

    /**
     * 返回指定路径文件的图片对象
     *
     * @param path
     * @return
     */
    public static Image getImage(String path) {

        BufferedImage bi = null;
        try {

            URL u = FrameUtil.class.getClassLoader().getResource(path);
            bi = ImageIO.read(u);
        } catch (IOException e) {

            e.printStackTrace();
        }
        return bi;
    }
}
