package org.yoking.qr;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.yoking.vo.Gender;
import org.yoking.vo.User;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.ImageReader;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;

public class QRGeneratorTest {

	public static void main(String[] args) {
		try {
			generate();
			parse();
		} catch (WriterException | IOException | NotFoundException | ChecksumException | FormatException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Generate QRCode PNG image.
	 *
	 * @throws WriterException the writer exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private static void generate() throws WriterException, IOException {
		String contents = new User(1l, "yoking.zhang@d1m.cn", "yoking", "123456".toCharArray(), Gender.MALE).toString();
		
		Map<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
		hints.put(EncodeHintType.CHARACTER_SET, Charset.forName("UTF-8").toString());
		
		BitMatrix matrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, 200, 200, hints);
				
        MatrixToImageWriter.writeToPath(matrix, "PNG", Paths.get("d:/qr.png"));
	}

	private static void parse() throws IOException, NotFoundException, ChecksumException, FormatException {
		BufferedImage image = ImageReader.readImage(Paths.get("d:/qr.png").toUri());
		LuminanceSource source = new BufferedImageLuminanceSource(image);
		Binarizer bin = new HybridBinarizer(source);
		BinaryBitmap bitmap = new BinaryBitmap(bin);
		Result result = new QRCodeReader().decode(bitmap);
		System.out.println(result.toString());
	}
}
