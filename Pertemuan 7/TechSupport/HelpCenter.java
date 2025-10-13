public class HelpCenter {
    private TextReader textReader;
    private ReplyGenerator replyGenerator;
    
    public HelpCenter() {
        textReader = new TextReader();
        replyGenerator = new ReplyGenerator();
    }
    
    public void launch() {
        boolean exit = false;
        
        tampilkanSambutan();
        
        while (!exit) {
            String message = textReader.readMessage();
            
            if (message.startsWith("quit")) {
                exit = true;
            } else {
                String reply = replyGenerator.createReply(message);
                System.out.println(reply);
            }
        }
        
        tampilkanPerpisahan();
    }
    
    private void tampilkanSambutan() {
        System.out.println("Selamat datang di Pusat Bantuan Akademik!");
        System.out.println();
        System.out.println("Silakan ceritakan masalah Anda, kami akan membantu semampu kami.");
        System.out.println("Ketik 'quit' kapan saja untuk keluar dari sistem.");
    }
    
    private void tampilkanPerpisahan() {
        System.out.println("Terima kasih telah menghubungi kami. Sampai jumpa!");
    }
}
