package view.ui.swing;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.Money;

public class MoneyDisplay extends JFrame{
    
    public MoneyDisplay(Money money) {
        super("Resultado");
        add(new JLabel(money + " " + money.getCurrency()));
        setSize(new Dimension(200,100));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
