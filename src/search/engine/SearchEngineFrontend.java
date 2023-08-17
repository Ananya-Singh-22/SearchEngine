/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package search.engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchEngineFrontend extends JFrame {
    private JTextField searchField;
    private JButton searchButton;
    private JTextArea resultsArea;

    public SearchEngineFrontend() {
        setTitle("Search Engine");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel to hold the search components
        JPanel searchPanel = new JPanel();

        // Create a JLabel and JTextField for the search input field
        JLabel searchLabel = new JLabel("Search:");
        searchField = new JTextField(30);

        // Create a JButton for the search action
        searchButton = new JButton("Search");

        // Add an ActionListener to the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform the search action when the button is clicked
                String query = searchField.getText();
                performSearch(query);
            }
        });

        // Add the search components to the search panel
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Create a JTextArea for displaying the search results
        resultsArea = new JTextArea();

        // Set the layout manager and add components to the main window
        setLayout(new BorderLayout());
        add(searchPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultsArea), BorderLayout.CENTER);
    }

    private void performSearch(String query) {
        AVLTree avlTree = new AVLTree();

        // Read data from a text file
       try {
    File file1 = new File("data1.txt");  // First text file
    File file2 = new File("data2.txt");  // Second text file
    File file3 = new File("data3.txt");

    // Create a scanner for the first file
    Scanner scanner1 = new Scanner(file1);
    while (scanner1.hasNextLine()) {
        String line = scanner1.nextLine();
        avlTree.insert(line);
    }
    scanner1.close();

    // Create a scanner for the second file
    Scanner scanner2 = new Scanner(file2);
    while (scanner2.hasNextLine()) {
        String line = scanner2.nextLine();
        avlTree.insert(line);
    }
    scanner2.close();

    Scanner scanner3 = new Scanner(file3);
    while (scanner3.hasNextLine()) {
        String line = scanner3.nextLine();
        avlTree.insert(line);
    }
    scanner3.close();

} catch (FileNotFoundException e) {
    e.printStackTrace();
    return;
}


        // Search for the query in the AVL tree
        boolean found = avlTree.search(query);

        if (found) {
            resultsArea.setText("Search query found: " + query);
        } else {
            resultsArea.setText("Search query not found: " + query);
        }
    }

    public static void main(String[] args) {
        // Create an instance of the SearchEngineFrontend class
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SearchEngineFrontend().setVisible(true);
            }
        });
    }
}
