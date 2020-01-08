package game;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import rankingManagement.*;

public class FrameScoreboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable tableScoreboard;
	private JButton resetButton;
	private Dimension dimFrame;
	private final Scoreboard scoreboard; 
	 
	public FrameScoreboard(Scoreboard scoreboard) {
		this.scoreboard = scoreboard;
		initComponents();
		refreshScoreboard(scoreboard);
	}
	
	public final void refreshScoreboard(Scoreboard scoreboard){
        int i=0;
        for(Player g: scoreboard){
            this.tableScoreboard.setValueAt(g.getPlayerTag(),i,1);
            this.tableScoreboard.setValueAt(g.getScore(),i,2);
            this.tableScoreboard.setValueAt(DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ITALY).format(g.getDate()), i, 3);
            this.tableScoreboard.setValueAt(g.getVisibleData(), i, 3);
            i++; 
        }
    }
	
	private void resetClassifica(MouseEvent evt) throws IOException {                                         
		scoreboard.resetScoreboard();
        int i=0;
        while(i<10){
            this.tableScoreboard.setValueAt(null,i,0);
            this.tableScoreboard.setValueAt(null,i,1);
            this.tableScoreboard.setValueAt(null, i, 2);
            this.tableScoreboard.setValueAt(null, i, 3);
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
		dimFrame = new Dimension(500, 700);
		this.setPreferredSize(dimFrame.getSize());
		this.setLocation((int) dimDisplay.getWidth() / 2 - (int)dimFrame.getWidth() / 2, (int) dimDisplay.getHeight() / 2 - (int)dimFrame.getHeight()/ 2);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		
		tableScoreboard = new JTable();
		tableScoreboard.setModel(new DefaultTableModel(
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
		tableScoreboard.getColumnModel().getColumn(0).setResizable(false);
		tableScoreboard.getColumnModel().getColumn(0).setPreferredWidth(46);
		tableScoreboard.getColumnModel().getColumn(1).setResizable(false);
		tableScoreboard.getColumnModel().getColumn(2).setResizable(false);
		tableScoreboard.getColumnModel().getColumn(3).setResizable(false);
		tableScoreboard.setRowSelectionAllowed(false);
		tableScoreboard.setRowHeight(40);
		scrollPane.setSize(400, 500);
		tableScoreboard.setSize(400, 500);
		tableScoreboard.setDefaultRenderer(String.class, centerRenderer);
		
		scrollPane.setViewportView(tableScoreboard);
		getContentPane().add(scrollPane);
		
		resetButton = new JButton("Reset");
		resetButton.setMaximumSize(new Dimension(65, 29));
		resetButton.setMargin(new Insets(0, 14, 2, 14));
		resetButton.setLayout(null);
		resetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
					resetClassifica(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });
		
		getContentPane().add(resetButton);
		
		this.addWindowListener(new WindowAdapter(){
			
	        @Override
	        public void windowClosing(WindowEvent e){
	            MenuFrame.flagScoreboard = false;
	            e.getWindow().dispose();
	        }
	    });
	}
	
	

	 

	 
}