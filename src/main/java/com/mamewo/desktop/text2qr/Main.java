package com.mamewo.desktop.text2qr;

import java.security.MessageDigest;
import java.util.Map;
import java.util.HashMap;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.io.File;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class Main {
    public static void main(String argv[])
    {
        try {
            int width = 200;
            int height = 200;
            //
            Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
            hints.put(EncodeHintType.MARGIN, 2);
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            for(int i = 0; i < argv.length; i++){
                String text = argv[0];
                String filename = argv[1];
                QRCodeWriter writer = new QRCodeWriter();
                BitMatrix bitMat = writer.encode(text, BarcodeFormat.QR_CODE, width, height, hints);
                BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMat);
                ImageIO.write(image, "png", new File(filename));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
