package hust.soict.hedspi.aims.gui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.book.Book;
import hust.soict.hedspi.aims.media.disc.CompactDisc;
import hust.soict.hedspi.aims.media.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.disc.Track;
import hust.soict.hedspi.aims.order.Order;

public class Dialogs extends JDialog{
	private JLabel idJLabel = new JLabel("ID");
	private JLabel costJLabel = new JLabel("Cost");
	private JLabel categoryJLabel = new JLabel("Category");
	private JLabel titleJLabel = new JLabel("Title");
	
	private JTextField idField = new JTextField();
	private JTextField costField = new JTextField();
	private JTextField cateField = new JTextField();
	private JTextField titleField = new JTextField();
	private JButton okJButton = new JButton("OK");
	
	
	public String getTitle() {
		return titleField.getText();
	}
	
	public String getCategory() {
		return cateField.getText();
	}
	
	private Float getCost() {
		float cost;
		try {
			cost = Float.parseFloat(costField.getText());
		} catch (Exception e) {
			cost = -1;
		}
		return cost;
	}
	private int getId() {
		int id;
		try {
			id = Integer.parseInt(idField.getText());
		} catch (Exception e) {
			id = -1;
		}
		return id;
	}
	public Dialogs(Frame frame) {
		super(frame);
		setSize(600,400);
		setLayout(null);
		setResizable(false);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 600))/2;
		int y = (int) ((dimension.getHeight() - 400))/2;
		setLocation(x, y);
		
		setVisible(false);
		setModal(true);
	}
	public Dialogs(Frame frame, String title) {
		super(frame);
		setSize(600,400);
		setLayout(null);
		setResizable(false);
		setTitle(title);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 600))/2;
		int y = (int) ((dimension.getHeight() - 400))/2;
		setLocation(x, y);
		
		setVisible(false);
		setModal(true);
	}
	public void setInfor() {
		
		// set thong tin cho label ID
				idJLabel.setSize(200,30);
				idJLabel.setLocation(100,20);
				add(idJLabel);
				idField.setSize(200, 30);
				idField.setLocation(300,20);
				add(idField);
				
				//set thong tin cho title label
				titleJLabel.setSize(200,30);
				titleJLabel.setLocation(100,60);
				add(titleJLabel);
				titleField.setSize(200, 30);
				titleField.setLocation(300,60);
				add(titleField);
				
				//set thong tin cho category label
				categoryJLabel.setSize(200,30);
				categoryJLabel.setLocation(100,100);
				add(categoryJLabel);
				cateField.setSize(200, 30);
				cateField.setLocation(300,100);
				add(cateField);
				
				// set thong tin cho cost label
				costJLabel.setSize(200,30);
				costJLabel.setLocation(100,140);
				add(costJLabel);
				costField.setSize(200, 30);
				costField.setLocation(300,140);
				add(costField);
				
				// set thong tin cho nut 'ok'	
				okJButton.setSize(100,30);
				okJButton.setLocation(250,330);
				okJButton.setFocusPainted(false);
				add(okJButton);
 
	}
	
	public boolean isEmpty() {
		return titleField.getText().equals("") || idField.getText().equals("") || cateField.getText().equals("") ||costField.getText().equals("");
	}
	
	public void bookDialog(Dialogs bookDialog,Order order) {
		bookDialog.setInfor();	
		
		//setup author field for book
		JTextField authorField = new JTextField();
		JLabel authorJLabel = new JLabel("Authors");
		authorJLabel.setSize(200,30);
		authorJLabel.setLocation(100,180);
		bookDialog.add(authorJLabel);
		authorField.setSize(200, 30);
		authorField.setLocation(300,180);
		bookDialog.add(authorField);
		
		// note when enter author for book
		JLabel noteJLabel = new JLabel("Enter authors list: author1, author2 , ...");
		noteJLabel.setSize(300,30);
		noteJLabel.setLocation(100,220);
		bookDialog.add(noteJLabel);
				
		bookDialog.okJButton.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				bookDialog.setVisible(false);
				float costBook = bookDialog.getCost();
				int idBook = bookDialog.getId();
				if(bookDialog.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Chua dien thong tin cho sach\n",
							"Warning",JOptionPane.WARNING_MESSAGE);
//					return;
				}
				else if(costBook == -1) {
					JOptionPane.showMessageDialog(null,"Gia sach vua nhap la khong hop le\n",
							"Warning",JOptionPane.WARNING_MESSAGE);
//					return;
				}
				else {
					String[] authors = authorField.getText().split(",");
					ArrayList<String> listAuthors = new ArrayList<String>();
					for(String author: authors) {
						listAuthors.add(author);
					}
					Book book = new Book(idBook, bookDialog.getTitle(), bookDialog.getCategory(), costBook, listAuthors);
					int check = order.addMedia(book);
					if(check == 0) {
						JOptionPane.showMessageDialog(null, "The Media has id entered is exits", "Warning", JOptionPane.ERROR_MESSAGE);
//						return;
					}
					else{
						JOptionPane.showMessageDialog(null, "Them thanh cong book vao Order", "Book", JOptionPane.INFORMATION_MESSAGE);
//						return;
					}
				}
			}
		});

		bookDialog.setVisible(true);
	}
	
	public void cdDialog(Dialogs CD,Order order) {
		CD.setInfor();
		
		// set Artist field
		JTextField artistField = new JTextField();
		JLabel textJLabel = new JLabel("Artist");
		textJLabel.setSize(200,30);
		textJLabel.setLocation(100, 180);
		CD.add(textJLabel);
		artistField.setSize(200,30);
		artistField.setLocation(300,180);
		CD.add(artistField);
		
		// set Director field
		JTextField directorField = new JTextField();
		JLabel directorJLabel = new JLabel("Director");
		directorJLabel.setSize(200,30);
		directorJLabel.setLocation(100,220);
		CD.add(directorJLabel);							
		directorField.setSize(200, 30);
		directorField.setLocation(300,220);
		CD.add(directorField);
		
		// set Track field
		JTextField trackField = new JTextField();
		JLabel trackJLabel = new JLabel("Track");
		trackJLabel.setSize(200,30);
		trackJLabel.setLocation(100,260);
		CD.add(trackJLabel);							
		trackField.setSize(200, 30);
		trackField.setLocation(300,260);
		CD.add(trackField);
		
		JLabel noteJLabel = new JLabel("* Track: <Track1>:<Length1>,<Track2>:<Lenght2>,...");
		noteJLabel.setSize(500,30);
		noteJLabel.setLocation(100,300);
		CD.add(noteJLabel);
		
		
		CD.okJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CD.setVisible(false);
				float costCD = CD.getCost();
				if(CD.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Ban chua nhap du thong tin cho CD","Warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(costCD == -1) {
					JOptionPane.showMessageDialog(null,"Gia cua CD vua nhap la khong hop le","Warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				else {
					CompactDisc cd = new CompactDisc(CD.getId(), CD.getTitle(), CD.getCategory(), CD.getCost(), directorField.getText(), artistField.getText());
									
					try {
						String strTrack[] = trackField.getText().split(",");
						for(String str : strTrack) {
							String inforTrack[] = str.split(":");
							Track track = new Track(inforTrack[0], Integer.parseInt(inforTrack[1]));
							cd.addTrack(track);
						}
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Nhap sai dinh dang cho truong track\n","Warning",JOptionPane.WARNING_MESSAGE);
						cd = null;
						return;
					}
					int check = order.addMedia(cd);
//					System.out.println(cd.getCost());
//					System.out.println(order.totalCost());
					if(check == 0) {
						JOptionPane.showMessageDialog(null, "CD vua nhap da ton tai trong order\n","Warning",JOptionPane.WARNING_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null,"Them CD thanh cong");
					}
				}
			}
		});
		CD.setVisible(true);
	}
	
	public void dvdDialog(Dialogs dvdDL, Order order) {
		dvdDL.setInfor();
		
		// set Director field
		JTextField directorField = new JTextField();
		JLabel directorJLabel = new JLabel("Director");
		directorJLabel.setSize(200,30);
		directorJLabel.setLocation(100,180);
		dvdDL.add(directorJLabel);							
		directorField.setSize(200, 30);
		directorField.setLocation(300,180);
		dvdDL.add(directorField);
		
		// set length field
		JTextField lengthField = new JTextField();
		JLabel lengthLabel = new JLabel("Length");
		lengthLabel.setSize(200,30);
		lengthLabel.setLocation(100, 220);
		dvdDL.add(lengthLabel);
		lengthField.setSize(200, 30);
		lengthField.setLocation(300, 220);
		dvdDL.add(lengthField);
		
		dvdDL.okJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dvdDL.setVisible(false);
				int length;
				try {
					length = Integer.parseInt(lengthField.getText());
				}catch (Exception e1) {
					length = -1;
				}
				if(dvdDL.isEmpty() || directorField.getText() == null) {
					JOptionPane.showMessageDialog(null, "Ban chua nhap day du thong tin cho DVD", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else if(length == -1) {
					JOptionPane.showMessageDialog(null, "Do dai DVD ban nhap khong hop le", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else {
					DigitalVideoDisc dvd = new DigitalVideoDisc(dvdDL.getId(), dvdDL.titleField.getText(), dvdDL.categoryJLabel.getText(),dvdDL.getCost(), length, directorField.getText());
					int check = order.addMedia(dvd);
							
					if(check == 0) {
						JOptionPane.showMessageDialog(null, "DVD co id vua nhap da ton tai", "Warning", JOptionPane.ERROR_MESSAGE);
						return;
					}
					else {
						JOptionPane.showMessageDialog(null, "Them thanh cong DVD", "DVD", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
			
		});
		dvdDL.setVisible(true);
	}
	
	public void removeDialog(ArrayList<Order> listOrder) {
		
		// setup field Order for remove dialog
		JLabel rmLabelOrder = new JLabel("Order's id");
		rmLabelOrder.setSize(80,40);
		rmLabelOrder.setLocation(100, 50);
		JTextField rmTextOrder = new JTextField();
		rmTextOrder.setSize(250,40);
		rmTextOrder.setLocation(250, 50);
		add(rmLabelOrder);
		add(rmTextOrder);
		
		// setup field Item for remove dialog
		JLabel rmLabelItem = new JLabel("Item's id");
		rmLabelItem.setSize(80,40);
		rmLabelItem.setLocation(100, 120);
		JTextField rmTextItem = new JTextField();
		rmTextItem.setSize(250,40);
		rmTextItem.setLocation(250, 120);
		add(rmLabelItem);
		add(rmTextItem);
		
		okJButton.setSize(100,30);
		okJButton.setLocation(250,330);
		okJButton.setFocusPainted(false);
		add(okJButton);
		okJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				int idOrder, idItem;
				
				try {
					idOrder = Integer.parseInt(rmTextOrder.getText());
					idItem = Integer.parseInt(rmTextItem.getText());
				} catch (Exception e1) {
					idOrder = -1;
					idItem = -1;
				}
				if(rmLabelOrder.getText() == null || rmLabelItem == null) {
					JOptionPane.showMessageDialog(null, "Ban chua nhap thong tin", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if(idOrder == -1 || idItem == -1) {
					JOptionPane.showMessageDialog(null, "Ban nhap sai dinh dang id", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else {
					if(listOrder.get(idOrder-1).removeMedia(idItem) == 1) {
						JOptionPane.showMessageDialog(null, "Remove Item complete!", "Remove Item", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "The id item is not exits", "Remove Item", JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
			
		});
		setVisible(true);
	}
}
