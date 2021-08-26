package steganography;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.*;




public class Steganography extends JFrame {
	
	public static Steganography stgSteganography;
	private JPanel contentPane;
	BufferedImage img;
	JFileChooser fc = new JFileChooser();
		
	public static void main(String[] args) {
		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stgSteganography=new Steganography();
					stgSteganography.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Steganography() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel =new JPanel();
		panel.setBounds(0, 0, 764, 518);
		panel.setBackground(new Color(102, 51, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(509, 292, 183, 85);
		btnExit.setBackground(new Color(51, 204, 255));
		btnExit.setFont(new Font("Dialog", Font.BOLD, 16));
		panel.add(btnExit);
		
		JButton btnUploadImage = new JButton("START");
		btnUploadImage.setBounds(509, 150, 183, 85);
		btnUploadImage.setBackground(new Color(51, 204, 255));
		btnUploadImage.setFont(new Font("Dialog", Font.BOLD, 16)); 
		 
		btnUploadImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Calculations_MainPart calculationframe =  new Calculations_MainPart();
				calculationframe.setVisible(true);	
				
			}
		});
		panel.add(btnUploadImage);
		
		JLabel lblNewLabel = new JLabel("IMAGE STEGANOGRAPHY");
		lblNewLabel.setBounds(0, 0, 764, 85);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		ImagePanel panel_1 = new ImagePanel();
		panel_1.setBounds(55, 104, 400, 300);
		panel.add(panel_1);
		
		try {
    		img = ImageIO.read(new File("D:\\Burak\\Programming\\Eclipse workspace\\Engineering Project II\\src\\steganography\\images\\MonaLisa400x300.jpg"));
		} catch (IOException ex) {
			ex.printStackTrace();
		
		}
		panel_1.setImage(img);
		panel_1.repaint();
	}
}
