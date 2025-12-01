public class MainTest {
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(() -> {

            Visualise gui = new Visualise();

            BinaryTree tree = gui.binaryTree;

            int[] sampleValues = {50, 30, 70, 20, 40, 60, 80};

            for (int v : sampleValues) {
                tree.insert(v);
            }

            gui.repaint();
        });
    }
}
