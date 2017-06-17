package stock.data;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;


public class GUI implements ActionListener {
	JFrame frame = new JFrame("Gem");
	JPanel panel = new JPanel();
	protected JButton btn1 = new JButton("Examine Stock");
	JTextField box = new JTextField();
	JCheckBox checkBox1 = new JCheckBox("StockTwits");
	JCheckBox checkBox2 = new JCheckBox("Seeking Alpha");
	JCheckBox checkBox3 = new JCheckBox("Market Watch");
	JCheckBox checkBox4 = new JCheckBox("Market Beat");
	JCheckBox checkBox5 = new JCheckBox("Benzinga");
	JLabel label = new JLabel("Insert Ticker Symbol Here:");
	
	
	public GUI() {
        panel.setLayout(new GridLayout(8,1));
        label.setHorizontalAlignment(JLabel.CENTER);
        box.setHorizontalAlignment(JTextField.CENTER);
        
        panel.add(label);
		panel.add(box);
		panel.add(checkBox1);
		panel.add(checkBox2);
		panel.add(checkBox3);
		panel.add(checkBox4);
		panel.add(checkBox5);
		panel.add(btn1);
		
		btn1.setActionCommand("btn1");
		btn1.setBackground(Color.LIGHT_GRAY);
		btn1.addActionListener(this);		

		Container container = frame.getContentPane();		
		container.setPreferredSize(new Dimension(200,300));

		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("btn1")) {
			String symbol = box.getText();
			
			try {
				if(Desktop.isDesktopSupported())
				{
					if(checkBox1.isSelected()) {
						Desktop.getDesktop().browse(new URI("https://stocktwits.com/symbol/"+symbol));
					}
					if(checkBox2.isSelected()){
						Desktop.getDesktop().browse(new URI("https://seekingalpha.com/symbol/"+symbol));
					}
					if(checkBox3.isSelected()) {
						Desktop.getDesktop().browse(new URI("http://marketwatch.com/investing/stock/"+symbol));
					}
					if(checkBox4.isSelected()) {
						Desktop.getDesktop().browse(new URI("https://marketbeat.com/stocks/NYSE/"+symbol));
					}
					if(checkBox5.isSelected()) {
						Desktop.getDesktop().browse(new URI("https://www.benzinga.com/stock/"+symbol));
					}
				}
			}
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public static void invoke() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GUI();
			}
		});
	}
}	
