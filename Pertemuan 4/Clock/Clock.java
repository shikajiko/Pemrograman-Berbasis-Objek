import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Clock{
    private JFrame frame;
    private JLabel label;
    private JLabel dateLabel;
    private ClockDisplay clock;
    private boolean clockRunning = false;
    private TimerThread timerThread;
    
    public Clock(){
        makeFrame();
        clock = new ClockDisplay(14, 50, 00);
    }
    
    private void start(){
        clockRunning = true; 
        timerThread = new TimerThread();
        timerThread.start();
        dateLabel.setText("16/9/2025");
    }
    
    private void stop(){
        clockRunning = false;
    }
    
    private void step(){
        clock.timeTick();
        label.setText(clock.getTime());
    }
    
    private void quit(){
        System.exit(0);
    }
    private void makeFrame(){
        frame = new JFrame("Jam");
        JPanel displayPanel = new JPanel(new GridLayout(2, 1));
        
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setBorder(new EmptyBorder(1, 60, 1, 60));
        makeMenuBar(frame);
        
        contentPane.setLayout(new BorderLayout(12, 20));
        label = new JLabel("00:00:00", SwingConstants.CENTER);
        Font displayFont = label.getFont().deriveFont(96.0f);
        label.setFont(displayFont);
        displayPanel.add(label);
        
        dateLabel = new JLabel("xx/xx/xx", SwingConstants.CENTER);
        Font dateFont = dateLabel.getFont().deriveFont(48.0f);
        dateLabel.setFont(dateFont);
        displayPanel.add(dateLabel);
        
        contentPane.add(displayPanel, BorderLayout.CENTER);
        
        
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new GridLayout(1,0));
        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> start());
        toolbar.add(startButton);
        
        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(e -> stop());
        toolbar.add(stopButton);
        
        JButton stepButton = new JButton("Step");
        stepButton.addActionListener(e -> step());
        toolbar.add(stepButton);
        
        JPanel flow = new JPanel();
        flow.add(toolbar);
        
        contentPane.add(flow, BorderLayout.SOUTH);
        frame.pack();
        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
    }
    
    private void makeMenuBar(JFrame frame){
        final int SHORTCUT_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        JMenu menu;
        JMenuItem item;
        
        menu = new JMenu("File");
        menubar.add(menu);
   
        item = new JMenuItem("Quit");
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
        item.addActionListener(e -> quit());
        menu.add(item);
    }
    
    class TimerThread extends Thread{
        public void run(){
            while(clockRunning){
                step();
                pause();
            }
        }
        
        private void pause(){
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException exc){}
        }
    }
}