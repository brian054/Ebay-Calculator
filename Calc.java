import java.awt.Button;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * Purpose: This application was used to calculate net profits on items I resell on Ebay.
 * Author: Brian Rowell
 */

public class Calc {

	public static void main(String[] args) {
		 Font font = new Font("Comic Sans", 20, 20);
		    
		    final JFrame frame = new JFrame("Ebay Calculator");
		    frame.setIconImage(Toolkit.getDefaultToolkit().getImage("images/image.jpg"));
		    frame.setSize(600, 400);
		    frame.setResizable(false);
		    frame.setLocationRelativeTo(null);
		    frame.setDefaultCloseOperation(3);
		    frame.setLayout(null);

		    JLabel sellForText = new JLabel("How much you sell it for?");
		    sellForText.setBounds(5, 5, 300, 50);
		    sellForText.setFont(font);
		    frame.add(sellForText);
		    
		    final JTextField sellTextField = new JTextField();
		    sellTextField.setFont(font);
		    sellTextField.setBounds(20, 50, 200, 50);
		    frame.add(sellTextField);

		    JLabel buyForText = new JLabel("How much you pay for it?");
		    buyForText.setBounds(250, 5, 300, 50);
		    buyForText.setFont(font);
		    frame.add(buyForText);
		    
		    final JTextField buyText = new JTextField();
		    buyText.setFont(font);
		    buyText.setBounds(250, 50, 200, 50);
		    frame.add(buyText);

		    JLabel shipFeeLabel = new JLabel("Shipping Fee?");
		    shipFeeLabel.setBounds(5, 200, 300, 50);
		    shipFeeLabel.setFont(font);
		    frame.add(shipFeeLabel);
		    
		    final JTextField shipFeeText = new JTextField();
		    shipFeeText.setFont(font);
		    shipFeeText.setBounds(20, 250, 200, 50);
		    frame.add(shipFeeText);

		    Button netProf = new Button("Enter");
		    netProf.setBounds(300, 250, 100, 50);
		    netProf.setFocusable(true);
		    
		    netProf.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent arg0) {
		            double calcShip = Double.parseDouble(shipFeeText.getText());
		            double calcBuy = Double.parseDouble(buyText.getText());
		            double calcSell = Double.parseDouble(sellTextField.getText());
		            
		            double ppFee = calcSell * 0.029D + 0.3D;
		            double ebayFee = calcSell * 0.1D;
		            
		            calcSell = calcSell - ppFee - ebayFee - calcShip;
		            
		            double netProfit = calcSell - calcBuy;
		            
		            if (frame.getContentPane().getComponentCount() > 7) {
		              frame.getContentPane().remove(frame.getContentPane().getComponentCount() - 1);
		            }
		            
		            JLabel npText = new JLabel("Net profit is $ " + netProfit);
		            npText.setBounds(200, 300, 300, 50);
		            frame.add(npText);
		            frame.revalidate();
		            frame.repaint();
		          }
		        });
		    
		    frame.add(netProf);
		    
		    frame.setVisible(true);
	}

}
