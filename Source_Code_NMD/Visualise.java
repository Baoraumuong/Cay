import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class Visualise extends JFrame {

    public BinaryTree binaryTree;  

    private JPanel treePanel;

    public Visualise() {

        setTitle("Binary Tree Visualization");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        binaryTree = new BinaryTree();

        treePanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                if (binaryTree.getRoot() != null) {
                    binaryTree.drawTree(g, getWidth() / 2, 50, binaryTree.getRoot(), 0);
                }
            }
        };
        treePanel.setBackground(Color.WHITE);
        add(treePanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton insertButton = new JButton("Insert Node");
        insertButton.addActionListener((ActionEvent e) -> {
            try {
                String input = JOptionPane.showInputDialog("Enter a number:");
                if (input == null) return; 
                int v = Integer.parseInt(input);
                binaryTree.insert(v);
                repaint();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }
        });

        JButton leavesButton = new JButton("Show Leaves");
        leavesButton.addActionListener(e -> {
            List<Integer> leaves = binaryTree.findLeaves(binaryTree.getRoot());
            JOptionPane.showMessageDialog(null, "Leaves: " + leaves);
        });

        JButton minButton = new JButton("Find Min");
        minButton.addActionListener(e -> {
            try {
                int min = binaryTree.findMin(binaryTree.getRoot());
                JOptionPane.showMessageDialog(null, "Min: " + min);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Tree is empty.");
            }
        });

        JButton maxButton = new JButton("Find Max");
        maxButton.addActionListener(e -> {
            try {
                int max = binaryTree.findMax(binaryTree.getRoot());
                JOptionPane.showMessageDialog(null, "Max: " + max);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Tree is empty.");
            }
        });

        buttonPanel.add(insertButton);
        buttonPanel.add(leavesButton);
        buttonPanel.add(minButton);
        buttonPanel.add(maxButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
