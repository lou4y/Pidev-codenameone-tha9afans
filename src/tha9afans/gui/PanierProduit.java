package tha9afans.gui;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;


public class PanierProduit extends Form {
    private Container productsContainer;
    private Container totalContainer;
    private Label totalPriceLabel;
    private int totalPrice;

    public PanierProduit() {
        super("Shopping Cart", new BorderLayout());

        productsContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        totalContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        totalPriceLabel = new Label("Total: 0");

        // Add some sample products to the cart
        addProduct("test", 40);
        addProduct("alibaba", 100);


        totalContainer.add(productsContainer);
        totalContainer.add(totalPriceLabel);

        add(BorderLayout.CENTER, totalContainer);

        // Add a checkout button to the bottom of the screen
        Button checkoutButton = new Button("Checkout");
        checkoutButton.addActionListener(e -> {
            // TODO: Implement checkout logic
            Dialog.show("Checkout", "Thank you for your purchase!", new Command("OK"));
        });

        add(BorderLayout.SOUTH, checkoutButton);
    }

    private void addProduct(String name, int price) {
        Container productContainer = new Container(new GridLayout(1, 3));

        Label nameLabel = new Label(name);
        Label priceLabel = new Label(Integer.toString(price));
        Button removeButton = new Button("Remove");

        productContainer.add(nameLabel);
        productContainer.add(priceLabel);
        productContainer.add(removeButton);

        // Update the total price and label
        totalPrice += price;
        totalPriceLabel.setText("Total: " + totalPrice);

        // Remove the product when the button is pressed
        removeButton.addActionListener(e -> {
            productsContainer.removeComponent(productContainer);
            totalPrice -= price;
            totalPriceLabel.setText("Total: " + totalPrice);
            productsContainer.revalidate();
            //productsContainer.repaint();
        });

        productsContainer.add(productContainer);
    }

    public void show() {
        super.show();
        Display.getInstance().getCurrent().setBackCommand(null);
    }
}
