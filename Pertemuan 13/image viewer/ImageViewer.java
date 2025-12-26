import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageViewer extends JFrame {

    private final JLabel imageLabel = new JLabel((Icon)null, JLabel.CENTER);
    private Image sourceImage;
    private double scale = 1.0;

    public ImageViewer() {
        setTitle("Simple Image Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new JScrollPane(imageLabel), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createButtonPanel() {
        JButton open = new JButton("Open Image");
        JButton zoomIn = new JButton("Zoom In");
        JButton zoomOut = new JButton("Zoom Out");

        open.addActionListener(e -> openImage());
        zoomIn.addActionListener(e -> zoom(1.25));
        zoomOut.addActionListener(e -> zoom(0.8));

        JPanel panel = new JPanel();
        panel.add(open);
        panel.add(zoomIn);
        panel.add(zoomOut);
        return panel;
    }

    private void openImage() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(
                new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif")
        );

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            sourceImage = new ImageIcon(chooser.getSelectedFile().getAbsolutePath()).getImage();
            scale = 1.0;
            updateImage();
        }
    }

    private void zoom(double factor) {
        if (sourceImage == null) return;
        scale *= factor;
        updateImage();
    }

    private void updateImage() {
        int w = (int) (sourceImage.getWidth(null) * scale);
        int h = (int) (sourceImage.getHeight(null) * scale);
        Image scaled = sourceImage.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaled));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImageViewer::new);
    }
}
