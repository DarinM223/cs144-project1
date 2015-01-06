import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * Computes the SHA-1 hash over the content of an input file
 * @author Darin Minamoto <darinm223@gmail.com>
 * 
 * <pre>
 * {@code
 * java ComputeSHA filename.txt
 * -> 17a23c746fed66a6f285c665422deafcf51aca40
 * }
 * </pre>
 */
public class ComputeSHA {
	/**
	 * Computes the SHA of an array of bytes
	 * @param filebytes
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String computeSHA(byte[] filebytes) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
		byte[] hash = messageDigest.digest(filebytes);
		
		Formatter formatter = new Formatter();
		
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		
		return formatter.toString();
	}

	public static void main(String[] args) throws IOException {
		if (args.length < 1) {
			System.out.println("ComputeSHA needs a filename argument to compute the SHA");
			return;
		}
		
		String strPath = args[0];
		
		Path path = Paths.get(strPath);
		
		byte[] data = Files.readAllBytes(path);
		
		try {
			System.out.println(ComputeSHA.computeSHA(data));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Cannot find SHA-1 algorithm");
		}
	}
}
