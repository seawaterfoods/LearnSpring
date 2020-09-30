package com.joe.retailforest.service.impl;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Security;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.joe.retailforest.service.AESService;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Service;




@Service("AESService")
public class AESServiceImpl implements AESService {

	private Logger logger = Logger.getLogger(AESServiceImpl.class.getName());

	/**
	 * 密钥算法
	 */
	private String KEY_ALGORITHM = "AES";

	/**
	 * 加密/解密算法 / 工作模式 / 填充方式 Java 6支持PKCS5Padding填充方式 Bouncy
	 * Castle支持PKCS7Padding填充方式
	 */
	private String CIPHER_ALGORITHM = "AES/CBC/PKCS7Padding";
	// private String ALGO_MODE = "AES/CBC/NoPadding";

	/**
	 * 偏移量，只有CBC模式才需要
	 */
	private String ivParameter = "CeazakeqPlPb1enP";
//	 private final static String ivParameter = "1234567890123456";

	/**
	 * AES要求密钥长度为128位或192位或256位，java默认限制AES密钥长度最多128位
	 */
	private String sKey = "htGp7OVgAsf7j3U4aCspRn1uBuVAwylp";
//	 public static String sKey="12345678901234567890123456789012";

	/**
	 * 编码格式
	 */
	public  String ENCODING = "utf-8";

	static {
		// 如果是PKCS7Padding填充方式，则必须加上下面这行
		Security.addProvider(new BouncyCastleProvider());
	}
	
	
	/**
	 * AES256加密
	 */
	public String encrypt(String value, String hashKey, String hashIv) {
		try {
			// Key 取  UTF-8 byte AES
			SecretKeySpec skeySpec = new SecretKeySpec(hashKey.getBytes("UTF-8"), "AES");
			// Iv 取 UTF-8 byte 
			IvParameterSpec iv = new IvParameterSpec(hashIv.getBytes("UTF-8"));
			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			// 透過 cipher 加密
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
			// 填充 PKCS7Padding
			byte[] encrypted = cipher.doFinal(addPKCS7Padding(value.getBytes("UTF-8"), 32));
			// 加密後字串轉16進制且小寫
			String encryResult = bytesToHex(encrypted).toLowerCase();

			return encryResult;
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return null;
	}
	
	
	
	public String getSHA256(String input){

	    	String toReturn = null;
	    	try {
	    	    MessageDigest digest = MessageDigest.getInstance("SHA-256");
	    	    digest.reset();
			digest.update(input.getBytes("utf8"));
			toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
			toReturn = toReturn.toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return toReturn;
	}
	
	/**
	 * PKCS7Padding 填充
	 */
	private static byte[] addPKCS7Padding(byte[] data, int iBlockSize) {
		int iLength = data.length;
		byte cPadding = (byte) (iBlockSize - (iLength % iBlockSize));
		byte[] output = new byte[iLength + cPadding];
		System.arraycopy(data, 0, output, 0, iLength);
		for (int i = iLength; i < output.length; i++)
			output[i] = (byte) cPadding;
		return output;
	}
	
	
	/**
	 * byte 轉 16進制並小寫
	 */
	public static String bytesToHex(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex);
		}
		return sb.toString();
	}
	
	/**
	 * AES256 解密
	 */
	public String decrypt(String value, String hashKey, String hashIv) {
		try {
			// Key 取  UTF-8 byte AES
			SecretKeySpec skeySpec = new SecretKeySpec(hashKey.getBytes("UTF-8"), "AES");
			// Iv 取 UTF-8 byte 
			IvParameterSpec iv = new IvParameterSpec(hashIv.getBytes("UTF-8"));
			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			// 透過 cipher 解密
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			// 16 進制轉為 byte
			byte[] decrypted = cipher.doFinal(HexToBytes(value.toUpperCase()));
			// 移除 PKCS7Padding填充
			byte[] unpadded = RemovePKCS7Padding(decrypted);
			return new String(unpadded, "UTF-8");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	/**
	 * 移除 PKCS7Padding 填充
	 */
	private byte[] RemovePKCS7Padding(byte[] data) {
		int ilength = data[data.length - 1];
		byte[] output = new byte[data.length - Math.abs(ilength)];
		logger.info("data=====>" + data.length);
		logger.info("ilength=====>" + ilength);
		logger.info("output=====>" + output.length);
		System.arraycopy(data, 0, output, 0, output.length);
		return output;
	}
	
	
	/**
	 * 16進制轉為二進制
	 */
	public byte[] HexToBytes(String hexString) {

		char[] hex = hexString.toCharArray();
		// 轉rawData長度減半
		int length = hex.length / 2;
		byte[] rawData = new byte[length];
		for (int i = 0; i < length; i++) {
			// 先將hex資料轉10進位數值
			int high = Character.digit(hex[i * 2], 16);
			int low = Character.digit(hex[i * 2 + 1], 16);
			// 將第一個值的二進位值左平移4位,ex: 00001000 => 10000000 (8=>128)
			// 然後與第二個值的二進位值作聯集ex: 10000000 | 00001100 => 10001100 (137)
			int value = (high << 4) | low;
			// 與FFFFFFFF作補集
			if (value > 127)
				value -= 256;
			// 最後轉回byte就OK
			rawData[i] = (byte) value;
		}
		return rawData;
	}
	

}