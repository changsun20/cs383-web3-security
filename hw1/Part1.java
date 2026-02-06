import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Part1 {
    // -----------------------------
    // Part 1: Message Digests
    // -----------------------------
    
    /**
     * Compute the message digest of a message using specified hash function.
     * 
     * @param message the message to hash
     * @param hashFunction which hash to use:
     *                     1 = full SHA-256 (256 bits)
     *                     2 = SHA-256 truncated to 8 bits
     *                     3 = SHA-256 truncated to 16 bits
     *                     other = print error and return null
     * @return the message digest as a byte array
     */
    public static byte[] computeDigest(byte[] message, int hashFunction)  throws NoSuchAlgorithmException {
        byte[] digest = switch (hashFunction) {
        case 1 -> Utils.sha256(message);
        case 2 -> Utils.hashTruncated(message, 8);
        case 3 -> Utils.hashTruncated(message, 16);
        default -> message;
        };
        return digest;
    }

    /**
     * Verify that a message matches an expected digest.
     * 
     * @param message the message to verify
     * @param expectedDigest the expected digest
     * @param hashFunction which hash function to use (1, 2, or 3)
     * @return true if message's digest matches expectedDigest
     */
    public static boolean verifyIntegrity(byte[] message, byte[] expectedDigest, 
                                          int hashFunction) throws NoSuchAlgorithmException {
        return Arrays.equals(expectedDigest, computeDigest(message, hashFunction));
    }
}
