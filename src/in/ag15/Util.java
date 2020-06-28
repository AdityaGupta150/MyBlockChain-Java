package in.ag15;

import javafx.util.Pair;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Util {

	public static String pwd() { // Returns Present Working Directory
		String retVal = new File(".").getAbsolutePath();
		return retVal.substring(0, retVal.length() - 1);
	}

	public static Pair<Integer, Integer> getTerminalDimen() {
		// TODO
		return new Pair<>(150, 34);
	}

	public static void place_center(int i) {
	}

	public static void align_text_center(String key) {
	}

	public static void place_v_center(String string) {
	}

	public static void place_v_center(int i, String string) {
	}

	public static void align_text_center(int width, String content) {
		align_text_center(width, new StringBuilder(content));
	}

	public static void align_text_center(int width, StringBuilder content) {
	}

	public static void place_center(Integer key, String string) {
	}

	public static Boolean icompare(String a, String b) {    //Compares two strings, but considers there different forms too
		if (a.length() != b.length()) return false;
		for (int i = 0; i < a.length(); i++) {
			if (Character.toLowerCase(a.charAt(i)) != Character.toLowerCase(b.charAt(i))) return false;
		}
		return true;
	}

	static public class Hasher {
		public static String getMd5CheckSum(File file) throws IOException {
			return Hasher.getCheckSum(file, "MD5");
		}

		public static String getSHA2CheckSum(File file) throws IOException {
			return Hasher.getCheckSum(file, "SHA-256");
		}

		public static String getHash(Object obj, String Algorithm) {
			if(obj == null){
				return "0x0000000000000000";
			}

			MessageDigest md;
			byte[] buffer;
			try {
				md = MessageDigest.getInstance(Algorithm);
				buffer = obj.toString().getBytes(StandardCharsets.UTF_8);
			} catch (NoSuchAlgorithmException e) {
				System.err.println(e);
				e.printStackTrace();
				return null;
			}

			md.update(buffer);
			return encodeHex(md.digest());
		}

		public static String getCheckSum(File file, String Algorithm) throws IOException {  //Throws due to 'stream.read()'
			MessageDigest md;
			FileInputStream stream;
			try {
				md = MessageDigest.getInstance(Algorithm);
				stream = new FileInputStream(file); //Initialized from a 'File' object
			} catch (NoSuchAlgorithmException | FileNotFoundException e) {
				System.err.println(e);
				return "";
			}

			byte[] byteArray = new byte[1024];
			int bytesCount = 0;

			// Read file and update the message digest
			while ((bytesCount = stream.read(byteArray)) != -1) {
				md.update(byteArray, 0, bytesCount);
			}
			stream.close();
			//Currently bytesArray[] is holding the data in 'decimal' form

			//Now we will use another byte array, and a stringbuilder, to CONVERT IT TO HEXADECIMAL FORM
			return encodeHex(md.digest());
		}

		public static String encodeHex(byte[] digest) {
			StringBuilder builder = new StringBuilder();    //byteArray will store
			for (byte i : digest) {
				builder.append(Integer.toString((i & 0xff) + 0x100, 16).substring(1));
			}

			return builder.toString();
		}

		public static void main(String[] args) throws IOException {
			//        System.in.readLine()
			System.out.println("Enter file name : ");
			String filename = new Scanner(System.in).nextLine();

			System.out.println("MD5 Checksum of " + filename + " is : " + Hasher.getMd5CheckSum(new File(filename)));
		}

	}

}