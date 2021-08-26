package steganography;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.*;




public class Calculations_MainPart extends JFrame {

	private JPanel contentPane;
	JFileChooser fc = new JFileChooser();
	private JTextField OUTPUT_textField;
	private JTextField INPUT_textField;
	private JTextField KEY_textField;
	BufferedImage img;
	

		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculations_MainPart frame = new Calculations_MainPart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public Calculations_MainPart() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel =new JPanel();
		panel.setBounds(0, 0, 777, 545);
		panel.setBackground(new Color(102, 51, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnDecode = new JButton("STEGO-ANALYZE");
		btnDecode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					INPUT_textField.setText(LSB_decode.DecodeTheMessage(img));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(new JFrame(), "Your Text has been retrieved from the Image, You can start decryption now.");

			}
		});
		btnDecode.setBounds(416, 189, 340, 104);
		btnDecode.setBackground(new Color(51, 204, 255));
		btnDecode.setFont(new Font("Dialog", Font.BOLD, 16));
		panel.add(btnDecode);
		
		
		
		ImagePanel panel_1 = new ImagePanel();
		panel_1.setBounds(10, 52, 340, 200);
		panel.add(panel_1);
		
		JButton btnUploadImage = new JButton("CHOOSE IMAGE");
		btnUploadImage.setBounds(10, 258, 340, 35);
		btnUploadImage.setBackground(new Color(51, 204, 255));
		btnUploadImage.setFont(new Font("Dialog", Font.BOLD, 10));
		btnUploadImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnUploadImage) {
		            int returnVal = fc.showOpenDialog(Calculations_MainPart.this);
		            File f = fc.getSelectedFile();
		            
		        	try {
		        		img = ImageIO.read(f);
					} catch (IOException ex) {
						ex.printStackTrace();
					
					}
				
				panel_1.setImage(img);
				panel_1.repaint();
				}
			}
		});
		
		panel.add(btnUploadImage);
		
		JLabel lblNewLabel = new JLabel("CRYPTOGRAPHY");
		lblNewLabel.setBounds(0, 300, 777, 41);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 21));
		
		JLabel lblNewLabel_1 = new JLabel("IMAGE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 21));
		lblNewLabel_1.setBounds(0, 0, 777, 41);
		panel.add(lblNewLabel_1);
		
		OUTPUT_textField = new JTextField();
		OUTPUT_textField.setColumns(10);
		OUTPUT_textField.setBounds(416, 369, 340, 69);
		panel.add(OUTPUT_textField);
		
		JLabel lblInput = new JLabel("INPUT");
		lblInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblInput.setFont(new Font("Dialog", Font.BOLD, 14));
		lblInput.setBounds(10, 317, 340, 41);
		panel.add(lblInput);
		
		JLabel lblOutput = new JLabel("OUTPUT");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Dialog", Font.BOLD, 14));
		lblOutput.setBounds(416, 317, 340, 41);
		panel.add(lblOutput);
		
		INPUT_textField = new JTextField();
		INPUT_textField.setColumns(10);
		INPUT_textField.setBounds(10, 369, 340, 69);
		panel.add(INPUT_textField);
		
		KEY_textField = new JTextField();
		KEY_textField.setBounds(351, 404, 64, 20);
		panel.add(KEY_textField);
		KEY_textField.setColumns(10);
		
		JLabel lblKey = new JLabel("KEY");
		lblKey.setHorizontalAlignment(SwingConstants.CENTER);
		lblKey.setFont(new Font("Dialog", Font.BOLD, 14));
		lblKey.setBounds(350, 352, 66, 41);
		panel.add(lblKey);
		
		JButton btnEncrypt = new JButton("ENCRYPT");
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
				      FileWriter myWriter = new FileWriter("D:\\Burak\\Programming\\Eclipse workspace\\Engineering Project II\\src\\steganography\\Steganography Files\\message_encrypted.txt");
				      
				      String enc = OTPCipher.OTPEncryption(INPUT_textField.getText(),OTPCipher.KeyExtender(INPUT_textField.getText(),KEY_textField.getText()));
				      myWriter.write(enc);
				      myWriter.close();
				      System.out.println("Successfully wrote to the file.");
				      OUTPUT_textField.setText(enc);
				    } 
				catch (IOException e1) {
				      System.out.println("An error occurred.");
				      e1.printStackTrace();
				    }
				JOptionPane.showMessageDialog(new JFrame(), "Your message has been successfully Encrypted. "
						+ "You can see the ciphertext in the output section.");
			}
		});
		btnEncrypt.setFont(new Font("Dialog", Font.BOLD, 16));
		btnEncrypt.setBackground(new Color(51, 204, 255));
		btnEncrypt.setBounds(10, 449, 746, 35);
		panel.add(btnEncrypt);
		
		JButton btnDecrypt = new JButton("DECRYPT");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				      FileWriter myWriter = new FileWriter("D:\\Burak\\Programming\\Eclipse workspace\\Engineering Project II\\src\\steganography\\Steganography Files\\message_decrypted.txt");
				      
				      String dec = OTPCipher.OTPDecryption(INPUT_textField.getText(), OTPCipher.KeyExtender(INPUT_textField.getText(),KEY_textField.getText()));
				      myWriter.write(dec);
				      myWriter.close();
				      System.out.println("Successfully wrote to the file.");
				      OUTPUT_textField.setText(dec);
				    } 
				catch (IOException e1) {
				      System.out.println("An error occurred.");
				      e1.printStackTrace();
				    }
				JOptionPane.showMessageDialog(new JFrame(), "Your message has been successfully Decrypted. "
						+ "You can see the decrypted message in the output section.");
			}
		});
		btnDecrypt.setFont(new Font("Dialog", Font.BOLD, 16));
		btnDecrypt.setBackground(new Color(51, 204, 255));
		btnDecrypt.setBounds(10, 497, 746, 35);
		panel.add(btnDecrypt);
		
		JButton btnEncode = new JButton("CREATE STEGO IMAGE");
		btnEncode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					LSB_encode.hideTheMessage(LSB_encode.bit_Msg(OUTPUT_textField.getText()), img);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(new JFrame(), "Your Stego Image has been created in the file system. ");

			}
		});
		btnEncode.setFont(new Font("Dialog", Font.BOLD, 16));
		btnEncode.setBackground(new Color(51, 204, 255));
		btnEncode.setBounds(416, 52, 340, 104);
		panel.add(btnEncode);
		
	}
	
}
