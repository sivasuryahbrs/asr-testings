package project.speech.userInterface;


import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Toolkit;

public class UiResultFrame1 {

	private static JFrame frameResult;
	private static JPanel contentPane;
	private static String pathName;

	//private JFrame localFrame;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void initialise(String p) {
		
		pathName = p;
		frameResult =  new JFrame();
		frameResult.setIconImage(Toolkit.getDefaultToolkit().getImage(UiResultFrame1.class.getResource("/project/speech/userInterface/logo.jpg")));
		frameResult.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameResult.setBounds(100, 100, 718, 473);
		frameResult.setTitle("Evaluation result...");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frameResult.setContentPane(contentPane);
		contentPane.setLayout(null);
		frameResult.setResizable(false);
		
		JTextArea txtAreaResult2 = new JTextArea();
		txtAreaResult2.setEditable(false);
		txtAreaResult2.setBounds(10, 11, 545, 293);
		//=================== Action listener ===================//
		
		try {
				FileReader reader = new FileReader(pathName);
				BufferedReader br = new BufferedReader(reader);
				txtAreaResult2.read(br, null);
				br.close();
				txtAreaResult2.requestFocus();
				JScrollPane scroll = new JScrollPane (txtAreaResult2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				scroll.setSize(697, 429);
				scroll.setLocation(5, 5);
				frameResult.getContentPane().add(scroll);
				frameResult.setVisible(true);
		}
		catch (Exception e){
				JOptionPane.showMessageDialog(null, e);
		}
	}	
}
