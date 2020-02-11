import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Choice;
import javax.swing.border.BevelBorder;

public class Main_GUI extends MasaBul {

	JFrame frame;
	
	private JButton bttn_waiter;
	private JButton bttn_cashier;
	private JPanel static_panel;
	private JPanel dynamic_panel;
	private JPanel waiter_panel;
	
	
	private JPanel cashier_panel;
	private JTextField masaNo_txtfield;
	private JTextField adSoyad_txtfield;
	private JTextField mail_txtfield;
	private JTextField tel_txtfield;
	private JTextField masaNoGir_txtfield;
	private JTextField adisyon_txtfield;
	private JTextField cashier_txtfield;

	private JRadioButton radbttn_masaAc;
	private JRadioButton radbttn_adisyonBastir;
	private JRadioButton radbttn_siparisEkle;
	
	private JTextArea waiter_textarea;
	private JTextArea cashier_textarea;
	private JLabel masaNo_label;
	private JLabel adSoyad_label;
	private JLabel mail_label;
	private JLabel tel_label;

	Choice UrunList_choice;
	
	ItemList newItem =new ItemList();
	DataAccesLayer dt =new DataAccesLayer();
	TableList tL = new TableList();
	Cashier cashier =new Cashier();
	
	private JButton bttn_urunEkle;
	private JButton bttn_masaAc;
	private JButton bttn_masaNogir;
	private JButton bttn_urunBitir;
	private JButton bttn_adisyon_masaNo;
	private JPanel first_panel;
	
	private JButton cashier_button;
	private JButton odemealindi_Button;

	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try 
				{
					Main_GUI window = new Main_GUI();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}


	public Main_GUI() 
	{
		initialize();
	}

	
	private void initialize() 
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(new Color(255, 250, 240));
		frame.setBounds(100, 100, 802, 616);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		static_panel = new JPanel();
		static_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		static_panel.setBounds(0, 0, 784, 152);
		frame.getContentPane().add(static_panel);
		static_panel.setLayout(null);
		
		JLabel lblSeimYapnz = new JLabel("\tSE\u00C7\u0130M YAPINIZ");
		lblSeimYapnz.setBounds(310, 13, 113, 25);
		static_panel.add(lblSeimYapnz);
		lblSeimYapnz.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeimYapnz.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		bttn_cashier = new JButton("CASHIER");
		bttn_cashier.setBounds(211, 51, 158, 45);
		static_panel.add(bttn_cashier);
		bttn_cashier.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				dynamic_panel.removeAll();
				dynamic_panel.add(cashier_panel);
				cashier_panel.setVisible(true);
				waiter_panel.setVisible(false);
			}
			
		});
		
		
		bttn_waiter = new JButton("WAITER");
		bttn_waiter.setBounds(381, 51, 150, 45);
		bttn_waiter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				dynamic_panel.removeAll();
				dynamic_panel.add(waiter_panel);
				cashier_panel.setVisible(false);
				waiter_panel.setVisible(true);
				
				bttn_urunEkle.setEnabled(false);
				bttn_masaAc.setEnabled(false);
				bttn_urunEkle.setEnabled(false);
				bttn_masaNogir.setEnabled(false);
				bttn_urunBitir.setEnabled(false);
				bttn_adisyon_masaNo.setEnabled(false);
				adisyon_txtfield.setEnabled(false);
				
				UrunList_choice.setEnabled(false);
				waiter_textarea.setEnabled(false);
				waiter_textarea.setEditable(false);
				
				masaNo_txtfield.setEnabled(false);
				adSoyad_txtfield.setEnabled(false);
				mail_txtfield.setEnabled(false);
				tel_txtfield.setEnabled(false);
				masaNoGir_txtfield.setEnabled(false);
			}
			
		});
		static_panel.add(bttn_waiter);
		
		dynamic_panel = new JPanel();
		dynamic_panel.setBounds(0, 154, 784, 415);
		frame.getContentPane().add(dynamic_panel);
		dynamic_panel.setLayout(new CardLayout(0, 0));
		
		first_panel = new JPanel();
		dynamic_panel.add(first_panel, "name_2303549035176705");
		
		cashier_panel = new JPanel();
		cashier_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		dynamic_panel.add(cashier_panel, "name_2301215105304930");
		cashier_panel.setLayout(null);
		
		JLabel cashier_label = new JLabel("Masa No Girin  :");
		cashier_label.setBounds(49, 59, 138, 37);
		cashier_panel.add(cashier_label);
		
		cashier_txtfield = new JTextField();
		cashier_txtfield.setColumns(10);
		cashier_txtfield.setBounds(49, 111, 138, 50);
		cashier_panel.add(cashier_txtfield);
		
		cashier_button = new JButton("Masa No Gir");
		
		cashier_button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				 int masaIndex = masabul(tL,Integer.parseInt(cashier_txtfield.getText()));
				String output2 = "";
				for(int a=0;a<tL.tableList.get(masaIndex).ItemName.size()  ;a++)
				{
					for(int i=0;i<newItem.getOrderList().size();i++)
					{
						if(tL.tableList.get(masaIndex).ItemName.get(a).equals(newItem.itemList.get(i).getOrderName()))
							output2 += tL.tableList.get(masaIndex).ItemName.get(a) + " " 
									   + newItem.itemList.get(i).getOrderCost() + "\n";	
					}
				}
				output2 += "Toplam Ücret : " + tL.tableList.get(masaIndex).getTotalCost() + "\n";
				output2 += "Müþteri bilgileri : "+ tL.tableList.get(masaIndex).customer.getAdSoyad() + " "
						+tL.tableList.get(masaIndex).customer.getePosta() + " " + 
						tL.tableList.get(masaIndex).customer.getTelefon();
				cashier_textarea.setText(output2);
				cashier_txtfield.setEditable(false);
			}
		});
		cashier_button.setBounds(49, 184, 138, 71);
		cashier_panel.add(cashier_button);
		
		cashier_textarea = new JTextArea();
		cashier_textarea.setEnabled(true);
		cashier_textarea.setEditable(false);
		cashier_textarea.setBounds(250, 13, 476, 376);
		cashier_panel.add(cashier_textarea);
		
		odemealindi_Button = new JButton("\u00D6deme Al\u0131nd\u0131");
		odemealindi_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int masaIndex = masabul(tL,Integer.parseInt(cashier_txtfield.getText()));
				tL.tableList.remove(masaIndex);
				cashier_txtfield.setEditable(true);
			}
		});
		odemealindi_Button.setBounds(49, 302, 138, 43);
		cashier_panel.add(odemealindi_Button);
		
		waiter_panel = new JPanel();
		dynamic_panel.add(waiter_panel, "name_2301202659774680");
		waiter_panel.setLayout(null);
		
		radbttn_masaAc = new JRadioButton("Masa A\u00E7");
		radbttn_masaAc.setBounds(86, 23, 138, 25);
		radbttn_masaAc.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				bttn_urunEkle.setEnabled(false);
				bttn_masaAc.setEnabled(true);
				bttn_masaNogir.setEnabled(false);
				bttn_urunBitir.setEnabled(false);
				masaNoGir_txtfield.setEnabled(false);
				UrunList_choice.setEnabled(false);
				waiter_textarea.setEnabled(false);
				masaNo_txtfield.setEnabled(true);
				adSoyad_txtfield.setEnabled(true);
				mail_txtfield.setEnabled(true);
				tel_txtfield.setEnabled(true);
				bttn_adisyon_masaNo.setEnabled(false);
				adisyon_txtfield.setEnabled(false);
			}
		});
		waiter_panel.add(radbttn_masaAc);
		
		radbttn_siparisEkle = new JRadioButton("Sipari\u015F Ekle");
		radbttn_siparisEkle.setBounds(345, 23, 127, 25);
		radbttn_siparisEkle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				bttn_urunEkle.setEnabled(false);
				bttn_masaAc.setEnabled(false);
				bttn_masaNogir.setEnabled(true);
				bttn_urunBitir.setEnabled(false);
				
				masaNoGir_txtfield.setEnabled(true);
				masaNo_txtfield.setEnabled(false);
				adSoyad_txtfield.setEnabled(false);
				mail_txtfield.setEnabled(false);
				tel_txtfield.setEnabled(false);
				
				UrunList_choice.setEnabled(false);
				waiter_textarea.setEnabled(true);
				waiter_textarea.setEditable(false);
				bttn_adisyon_masaNo.setEnabled(false);
				adisyon_txtfield.setEnabled(false);
				
				String output = "Açýk Masalar \n";
				for(int i=0;i<tL.tableList.size();i++)
				{
					output +=  String.valueOf(tL.tableList.get(i).getMasaNo()) + "\n";
				}
				waiter_textarea.setText(output);
				
				
				
			}
		});
		waiter_panel.add(radbttn_siparisEkle);
		
		radbttn_adisyonBastir = new JRadioButton("Adisyon Bast\u0131r");
		radbttn_adisyonBastir.setBounds(544, 23, 127, 25);
		radbttn_adisyonBastir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				bttn_urunEkle.setEnabled(false);
				bttn_masaAc.setEnabled(false);
				bttn_masaNogir.setEnabled(false);
				bttn_urunBitir.setEnabled(false);
				bttn_adisyon_masaNo.setEnabled(true);
				
				UrunList_choice.setEnabled(false);
				waiter_textarea.setEnabled(true);
				waiter_textarea.setEditable(false);
				waiter_textarea.setText("");
				
				masaNo_txtfield.setEnabled(false);
				masaNo_txtfield.setText("");
				adSoyad_txtfield.setEnabled(false);
				adSoyad_txtfield.setText("");
				mail_txtfield.setEnabled(false);
				mail_txtfield.setText("");
				tel_txtfield.setEnabled(false);
				tel_txtfield.setText("");
				masaNoGir_txtfield.setEnabled(false);
				masaNoGir_txtfield.setText("");
				adisyon_txtfield.setEnabled(true);
				adisyon_txtfield.setText("");
				
				
			}
		});
		waiter_panel.add(radbttn_adisyonBastir);
		
		ButtonGroup bttn_group = new ButtonGroup();
		bttn_group.add(radbttn_masaAc);
		bttn_group.add(radbttn_adisyonBastir);
		bttn_group.add(radbttn_siparisEkle);
		
		masaNo_label = new JLabel("Masa No  :");
		masaNo_label.setBounds(60, 81, 82, 16);
		waiter_panel.add(masaNo_label);
		
		adSoyad_label = new JLabel("Ad Soyad : ");
		adSoyad_label.setBounds(60, 137, 82, 16);
		waiter_panel.add(adSoyad_label);
		
		mail_label = new JLabel("Mail : ");
		mail_label.setBounds(60, 194, 82, 16);
		waiter_panel.add(mail_label);
		
		tel_label = new JLabel("Telefon : ");
		tel_label.setBounds(60, 249, 82, 16);
		waiter_panel.add(tel_label);
		
		masaNo_txtfield = new JTextField();
		masaNo_txtfield.setBounds(164, 78, 116, 22);
		waiter_panel.add(masaNo_txtfield);
		masaNo_txtfield.setColumns(10);
		
		adSoyad_txtfield = new JTextField();
		adSoyad_txtfield.setColumns(10);
		adSoyad_txtfield.setBounds(164, 134, 116, 22);
		waiter_panel.add(adSoyad_txtfield);
		
		mail_txtfield = new JTextField();
		mail_txtfield.setColumns(10);
		mail_txtfield.setBounds(164, 191, 116, 22);
		waiter_panel.add(mail_txtfield);
		
		tel_txtfield = new JTextField();
		tel_txtfield.setColumns(10);
		tel_txtfield.setBounds(164, 252, 116, 22);
		waiter_panel.add(tel_txtfield);
		
		masaNoGir_txtfield = new JTextField();
		masaNoGir_txtfield.setColumns(10);
		masaNoGir_txtfield.setBounds(345, 78, 127, 22);
		waiter_panel.add(masaNoGir_txtfield);
		
		adisyon_txtfield = new JTextField();
		adisyon_txtfield.setColumns(10);
		adisyon_txtfield.setBounds(547, 78, 182, 22);
		waiter_panel.add(adisyon_txtfield);
		
		bttn_masaAc = new JButton("Masa A\u00E7");
		bttn_masaAc.setBounds(60, 303, 220, 40);
		bttn_masaAc.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				TableInformation ti = new TableInformation();
				ti.masaNo = Integer.parseInt(masaNo_txtfield.getText());
				ti.customer.setAdSoyad(adSoyad_txtfield.getText());
				ti.customer.setePosta(mail_txtfield.getText());
				ti.customer.setTelefon(tel_txtfield.getText());
				tL.addTableList(ti);
				bttn_adisyon_masaNo.setEnabled(false);
				adisyon_txtfield.setEnabled(false);
				
			}
		});
		waiter_panel.add(bttn_masaAc);
		
		bttn_urunBitir = new JButton("Eklemeyi Bitir");
		bttn_urunBitir.setBounds(345, 303, 125, 40);
		bttn_urunBitir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				bttn_urunEkle.setEnabled(false);
				bttn_masaAc.setEnabled(false);
				bttn_urunEkle.setEnabled(false);
				bttn_masaNogir.setEnabled(false);
				bttn_urunBitir.setEnabled(false);
				bttn_adisyon_masaNo.setEnabled(false);
				
				
				UrunList_choice.setEnabled(false);
				waiter_textarea.setEditable(false);
				
				masaNo_txtfield.setEnabled(false);
				adSoyad_txtfield.setEnabled(false);
				mail_txtfield.setEnabled(false);
				tel_txtfield.setEnabled(false);
				masaNoGir_txtfield.setEnabled(false);
				adisyon_txtfield.setEnabled(false);
				
			}
		});
		waiter_panel.add(bttn_urunBitir);
		
		bttn_urunEkle = new JButton("\u00DCr\u00FCn Ekle");
		bttn_urunEkle.setBounds(343, 234, 127, 40);
		bttn_urunEkle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int mNo = Integer.parseInt(masaNoGir_txtfield.getText());
				int masaIndex = masabul(tL,mNo);	
				tL.tableList.get(masaIndex).ItemName.add(UrunList_choice.getSelectedItem());
				bttn_urunBitir.setEnabled(true);
				waiter_textarea.setEditable(false);
				bttn_adisyon_masaNo.setEnabled(false);
				adisyon_txtfield.setEnabled(false);
				String output = "";
				for(int i=0;i<tL.tableList.get(masaIndex).ItemName.size();i++)
				{
					output += tL.tableList.get(masaIndex).ItemName.get(i) + "\n";
				}
				waiter_textarea.setText(output);
			}
		});
		waiter_panel.add(bttn_urunEkle);
		
		bttn_masaNogir = new JButton("Masa No Gir");
		bttn_masaNogir.setBounds(345, 120, 127, 53);
		bttn_masaNogir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
				bttn_urunEkle.setEnabled(true);
				bttn_urunBitir.setEnabled(true);
				bttn_masaAc.setEnabled(false);
				bttn_masaNogir.setEnabled(false);
				
				UrunList_choice.setEnabled(true);	
				waiter_textarea.setEditable(true);
				
				masaNo_txtfield.setEnabled(false);
				adSoyad_txtfield.setEnabled(false);
				mail_txtfield.setEnabled(false);
				tel_txtfield.setEnabled(false);
				masaNoGir_txtfield.setEnabled(false);
				bttn_adisyon_masaNo.setEnabled(false);
				adisyon_txtfield.setEnabled(false);
				
			}
		});
		waiter_panel.add(bttn_masaNogir);
		
		bttn_adisyon_masaNo = new JButton("Adisyon \u0130\u00E7in Masa No Gir");
		bttn_adisyon_masaNo.setBounds(547, 120, 182, 53);
		bttn_adisyon_masaNo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				bttn_urunEkle.setEnabled(false);
				bttn_masaAc.setEnabled(false);
				bttn_urunEkle.setEnabled(false);
				bttn_masaNogir.setEnabled(false);
				bttn_urunBitir.setEnabled(false);
				bttn_adisyon_masaNo.setEnabled(false);
				adisyon_txtfield.setEnabled(false);
				
				UrunList_choice.setEnabled(false);
				waiter_textarea.setEditable(false);
				waiter_textarea.setEnabled(true);
				
				masaNo_txtfield.setEnabled(false);
				adSoyad_txtfield.setEnabled(false);
				mail_txtfield.setEnabled(false);
				tel_txtfield.setEnabled(false);
				masaNoGir_txtfield.setEnabled(false);
				
				int masaNo3 = Integer.parseInt(adisyon_txtfield.getText());
				int masaIndex3 = masabul(tL,masaNo3);
				String output = "";
				for(int i=0;i<tL.tableList.get(masaIndex3).ItemName.size();i++)
				{
					output += tL.tableList.get(masaIndex3).ItemName.get(i) + "\n" ; 
							
				}
				tL.tableList.get(masaIndex3).totalCost = tL.tableList.get(masaIndex3).calculate(tL.tableList.get(masaIndex3).ItemName, newItem);
				output += "Toplam Tutar : "+ String.valueOf(tL.tableList.get(masaIndex3).getTotalCost());
				waiter_textarea.setText(output);				
			}
		});
		waiter_panel.add(bttn_adisyon_masaNo);
		
		waiter_textarea = new JTextArea();
		waiter_textarea.setBounds(547, 188, 182, 155);
		waiter_panel.add(waiter_textarea);
		
		UrunList_choice = new Choice();
		UrunList_choice.setEnabled(false);
		UrunList_choice.setBounds(343, 199, 127, 22);
		addToChoice();
		waiter_panel.add(UrunList_choice);
		
		}
		
	
		
		private void addToChoice()
		{
		dt.readingFromFile(newItem);
		for(int i=0;i<newItem.getOrderList().size();i++)
		{
			UrunList_choice.add(newItem.getOrderList().get(i).getOrderName());
		}
		}
	
	
}
