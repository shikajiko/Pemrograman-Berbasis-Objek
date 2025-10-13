import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class ReplyGenerator {
    private Map<String, String> keywordReplies;
    private Random rand;
    
    public ReplyGenerator() {
        keywordReplies = new HashMap<>();
        rand = new Random();
        
        keywordReplies.put("ambil", "Apakah Anda mengalami kendala saat mengambil mata kuliah?");
        keywordReplies.put("help", "Bagaimana saya bisa membantu Anda?");
        keywordReplies.put("error", "Apakah ada pesan kesalahan yang muncul di layar?");
        keywordReplies.put("lambat", "Mungkin jaringan Anda sedang tidak stabil, coba periksa koneksi internet Anda.");
        keywordReplies.put("kuota", "Apakah kelas yang ingin Anda ambil sudah penuh?");
        keywordReplies.put("login", "Apakah Anda mengalami kesalahan saat mencoba login?");
        keywordReplies.put("drop", "Apakah Anda kesulitan saat mencoba menghapus atau drop kelas?");
        keywordReplies.put("penyetujuan", "Apakah ada kendala saat proses penyetujuan FRS?");
    }
    
    public String createReply(String userMessage) {
        String[] tokens = userMessage.toLowerCase().split("\\s+");
        
        for (String word : tokens) {
            if (keywordReplies.containsKey(word)) {
                return keywordReplies.get(word);
            }
        }
        
        String[] fallbackReplies = {
            "Coba jelaskan masalah Anda dengan lebih detail.",
            "Saya kurang paham, bisa dijelaskan lagi?",
            "Bisakah Anda memperjelas maksud Anda?"
        };
        
        return fallbackReplies[rand.nextInt(fallbackReplies.length)];
    }
}
