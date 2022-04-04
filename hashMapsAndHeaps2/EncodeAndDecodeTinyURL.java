package hashMapsAndHeaps2;
import java.util.*;

public class EncodeAndDecodeTinyURL {
	HashMap<String, String> map = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        Random r = new Random();
        char ch = (char)r.nextInt(100);
        
        StringBuilder sb = new StringBuilder();
        sb.append(ch);
        
        while(map.containsKey(sb.toString())) {
            ch = (char)r.nextInt();
            sb.append(ch);
        }
        
        map.put(sb.toString(), longUrl);
        
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
