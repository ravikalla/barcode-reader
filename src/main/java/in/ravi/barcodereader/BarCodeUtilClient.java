package in.ravi.barcodereader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.oned.CodaBarWriter;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * Sample function to show barcode features
 *
 */
public class BarCodeUtilClient {
	public static void main(String[] args) {

		// If parameters are passed from command line
		if (null != args && args.length >= 1) {
			System.out.println(readFromMultiformatReader(args[0]));
		}
		// If parameters are not passed from command line
		else {
			String strQRCodeFilePath = "resources/qrcode_1.png";
			String strCodeBarFilePath = "resources/codebar_1.png";

			// Creating barcodes of different formats
			printToQR("12345", "png" , strQRCodeFilePath);
			printToCodeBar("67890", "png" , strCodeBarFilePath);

			// Reading barcodes of different formats
			System.out.println("QR Code Value = " + readFromMultiformatReader(strQRCodeFilePath));
			System.out.println("Code Bar Value = " + readFromMultiformatReader(strCodeBarFilePath));
		}
	}

	public static String readFromMultiformatReader(String strFileName) {
		String strResult = null;
		try {
			InputStream barCodeInputStream = new FileInputStream(strFileName);
			BufferedImage barCodeBufferedImage = ImageIO.read(barCodeInputStream);

			LuminanceSource source = new BufferedImageLuminanceSource(barCodeBufferedImage);
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
			Reader reader = new MultiFormatReader();
			Result result = reader.decode(bitmap);
			strResult = result.getText();
		} catch (NotFoundException e) {
			System.out.println("NotFoundException e : " + e);
		} catch (ChecksumException e) {
			System.out.println("ChecksumException e : " + e);
		} catch (FormatException e) {
			System.out.println("FormatException e : " + e);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException e : " + e);
		} catch (IOException e) {
			System.out.println("IOException e : " + e);
		}
		return strResult;
	}

	/**
	 * 
	 * @param strText
	 * @param imageFormat - can be png, "gif", "tiff", "jpeg"
	 * @param strFilePath
	 */
	public static void printToQR(String strText, String imageFormat, String strFilePath) {
		int width = 400;
		int height = 300; // change the height and width as per your requirement

		BitMatrix bitMatrix;
		try {
			bitMatrix = new QRCodeWriter().encode(strText, BarcodeFormat.QR_CODE, width, height);
			MatrixToImageWriter.writeToStream(bitMatrix, imageFormat,
				new FileOutputStream(new File(strFilePath)));
		} catch (WriterException e) {
			System.out.println("WriterException e : " + e);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException e : " + e);
		} catch (IOException e) {
			System.out.println("IOException e : " + e);
		}
	}

	/**
	 * 
	 * @param strText
	 * @param imageFormat - can be png, "gif", "tiff", "jpeg"
	 * @param strFilePath
	 */
	public static void printToCodeBar(String strText, String imageFormat, String strFilePath) {
		int width = 400;
		int height = 300; // change the height and width as per your requirement

		BitMatrix bitMatrix;
		try {
			bitMatrix = new CodaBarWriter().encode(strText, BarcodeFormat.CODABAR, width, height);
			MatrixToImageWriter.writeToStream(bitMatrix, imageFormat,
				new FileOutputStream(new File(strFilePath)));
		} catch (WriterException e) {
			System.out.println("WriterException e : " + e);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException e : " + e);
		} catch (IOException e) {
			System.out.println("IOException e : " + e);
		}
	}
}
