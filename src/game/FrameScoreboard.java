package game;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import gestioneClassifica.*;

public class FrameScoreboard extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton reset;
	private Dimension dim;
	private final Classifica c; 
	/**
	 * Create the panel.
	 */
	
	public FrameScoreboard(Classifica c) {
		this.c = c;
		initComponents();
		refreshClassifica(c);
	}
	
	public final void refreshClassifica(Classifica c){
        int i=0;
        for(Giocatore g: c){
            this.table.setValueAt(g.getTagGiocatore(),i,1);
            this.table.setValueAt(g.getPunteggio(),i,2);
            this.table.setValueAt(DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ITALY).format(g.getData()), i, 3);
            this.table.setValueAt(g.getVisibleData(), i, 3);
            i++; 
        }
    }
	
	private void resetClassifica(MouseEvent evt) {                                         
        c.resetClassifica();
        int i=0;
        while(i<10){
            this.table.setValueAt(null,i,0);
            this.table.setValueAt(null,i,1);
            this.table.setValueAt(null, i, 2);
            this.table.setValueAt(null, i, 3);
            i++; 
        }
    }  
	
	@SuppressWarnings("serial")
	public void initComponents() {
		setSize(new Dimension(500, 700));
		setTitle("Scoreboard");
		setResizable(false);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 15, 100));
		
		Dimension dimDisplay = Toolkit.getDefaultToolkit().getScreenSize();
		
		int widthMenu = (int) ((dimDisplay.getWidth() * 35) / 100); //i numeri moltiplicati devono essere uguali sia per la width che per la height
		int heightMenu = (int) ((dimDisplay.getHeight() * 35) / 100);
		dim = new Dimension(widthMenu, heightMenu);
		this.setPreferredSize(dim.getSize());
		this.setLocation((int) dimDisplay.getWidth() / 2 - widthMenu / 2, (int) dimDisplay.getHeight() / 2 - heightMenu / 2);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"   1", null, null, null},
				{"   2", null, null, null},
				{"   3", null, null, null},
				{"   4", null, null, null},
				{"   5", null, null, null},
				{"   6", null, null, null},
				{"   7", null, null, null},
				{"   8", null, null, null},
				{"   9", null, null, null},
				{"  10", null, null, null},
			},
			new String[] {
				"Rank", "Player", "Score", "Date"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(46);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.setRowSelectionAllowed(false);
		table.setRowHeight(40);
		scrollPane.setSize(400, 500);
		table.setSize(400, 500);
		table.setDefaultRenderer(String.class, centerRenderer);
		
		scrollPane.setViewportView(table);
		getContentPane().add(scrollPane);
		
		reset = new JButton("Reset");
		reset.setMaximumSize(new Dimension(65, 29));
		reset.setMargin(new Insets(0, 14, 2, 14));
		reset.setLayout(null);
		reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetClassifica(evt);
            }
        });
		
		getContentPane().add(reset);
		
		this.addWindowListener(new WindowAdapter()
	    {
	        @Override
	        public void windowClosing(WindowEvent e)
	        {
	            MenuFrame.flagScoreboard = false;
	            e.getWindow().dispose();
	        }
	    });
	}
	
	

	 

	 
}