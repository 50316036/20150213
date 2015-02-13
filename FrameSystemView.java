package framesystem;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class FrameSystemView extends Frame implements ActionListener,WindowListener{ 
	private Button button1 = new Button("表示");
	CardLayout cardlayout;
	Panel panel;
	Panel buttonpanel;
	
	public FrameSystemView(FrameSystemController controller){
		
		panel=new Panel();
		buttonpanel=new Panel();
		addWindowListener(this);
		setTitle("mie-temp");
		cardlayout=new CardLayout();
		setLayout(cardlayout);
		buttonpanel.add(button1,BorderLayout.CENTER);
		add(buttonpanel);
        add(panel);
        button1.addActionListener(this);
    	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if(e.getSource()==button1){
		int month;
		double max,min;
		ResultSet rs;
		lib.MySQL mysql = new lib.MySQL();
		rs=mysql.selectAll();
		DefaultCategoryDataset data =new DefaultCategoryDataset();
		try{
			while(rs.next()){
	            month = rs.getInt("month");
	            max = rs.getDouble("max");
	            min = rs.getDouble("min");
	            data.addValue(max,"max",month+"");
	            data.addValue(min,"min",month+"");
	            panel.add(new Label("月"+month));
			}
			}catch (SQLException et){}
		JFreeChart chart = 
			      ChartFactory.createLineChart("mie-temp",
			                                   "month",
			                                   "temperature",
			                                   data,
			                                   PlotOrientation.VERTICAL,
			                                   true,
			                                   false,
			                                   false);
	    ChartPanel cpanel = new ChartPanel(chart);
	    panel.add(cpanel);
	    cardlayout.next(this);	
		}
			   
			



    }

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

		System.exit(0);

	
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	
}
