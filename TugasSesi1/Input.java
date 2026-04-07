import javax.swing.JOptionPane;

public class Input {
    public static void main(String[] args) {
        String pelajaran = JOptionPane.showInputDialog("Anda sedang belajar apa?");
        JOptionPane.showMessageDialog(null,
            "Belajar " + pelajaran + " sangat mudah");
    }
}