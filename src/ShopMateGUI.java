import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShopMateGUI {

    public ShopMateGUI() {

        JFrame frame = new JFrame("ShopMate-Product Recommendation System");

        frame.setSize(500,400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new FlowLayout());

        JLabel categoryLabel = new JLabel("Category");

        JComboBox<String> categoryBox =
                new JComboBox<>();

        categoryBox.addItem("Mobile");
        categoryBox.addItem("Laptop");

        JLabel budgetLabel = new JLabel("Budget");

        JTextField budgetField =
                new JTextField(10);

        JButton recommendButton =
                new JButton("Recommend");
        ArrayList<Product> products =
                new ArrayList<>();

        products.add(
                new Product(
                        "Samsung M35",
                        "Mobile",
                        18000));

        products.add(
                new Product(
                        "Realme Narzo",
                        "Mobile",
                        15000));

        products.add(
                new Product(
                        "HP Laptop",
                        "Laptop",
                        45000));

        products.add(
                new Product(
                        "Dell Inspiron",
                        "Laptop",
                        55000));
        frame.add(categoryLabel);
        frame.add(categoryBox);

        frame.add(budgetLabel);
        frame.add(budgetField);

        frame.add(recommendButton);
        JTextArea resultArea =
                new JTextArea(10, 30);
        resultArea.setText(
                "Welcome to ShopMate!\n" +
                        "Select a category and enter your budget.\n\n");
        resultArea.setEditable(false);
        frame.add(new JScrollPane(resultArea));
        recommendButton.addActionListener(e -> {

            resultArea.setText("");

            String selectedCategory =
                    categoryBox.getSelectedItem()
                            .toString();

            double budget =
                    Double.parseDouble(
                            budgetField.getText());

            for(Product p : products) {

                if(p.category.equalsIgnoreCase(
                        selectedCategory)
                        && p.price <= budget) {

                    resultArea.append(
                            "Product : " + p.name +
                                    "\nPrice   : ₹" + p.price +
                                    "\n-------------------------\n");
                }
            }
        });
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
