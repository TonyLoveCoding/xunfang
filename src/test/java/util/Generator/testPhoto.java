package util.Generator;


import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;

import java.io.IOException;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/11 16:05
 */
public class testPhoto {
    public static void main(String[] args) throws IOException {

        Thumbnails.of("D://1.png").sourceRegion(1,1,300,300).scale(1,1).toFile("D://2.png");
    }

}
