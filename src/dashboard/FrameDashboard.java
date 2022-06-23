package dashboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.markers.SeriesMarkers;

import javafx.scene.chart.PieChart;

public class FrameDashboard {

	JTextField xinputField = new JTextField();
	JButton submitButton = new JButton("Submit");
	JButton stringButton = new JButton("Submit name");
	JTextField LineGrapField = new JTextField();
	JButton addLineGrapField = new JButton("Add new line graph");
	JTextField addInputField = new JTextField();
	JButton submitInputFieldButton = new JButton("Submit input");

	public FrameDashboard(XYChart chart) {


		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());

		JPanel chartJPanel = new XChartPanel<XYChart>(chart);
		frame.add(chartJPanel, BorderLayout.NORTH);
		
		JPanel centerJPanel = new JPanel();
		frame.add(centerJPanel, BorderLayout.CENTER);
		centerJPanel.add(new JLabel("Eingabe hinzufügen"));
		centerJPanel.add(addInputField);
		addInputField.setColumns(7);
		centerJPanel.add(submitInputFieldButton);

		JPanel bottInputJPanel = new JPanel();
		bottInputJPanel.setLayout(new BorderLayout());
		frame.add(bottInputJPanel, BorderLayout.SOUTH);

		JPanel centerPanel = new JPanel();
		bottInputJPanel.add(centerPanel, BorderLayout.CENTER);
		centerJPanel.add(new JLabel("Ausgabe in €"));
		centerJPanel.add(xinputField);
		xinputField.setColumns(7);

		JPanel rightPanel = new JPanel();
		frame.add(rightPanel, BorderLayout.CENTER);
		rightPanel.add(LineGrapField);
		LineGrapField.setColumns(9);
		rightPanel.add(stringButton);
	

		submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				

				chartJPanel.setVisible(false);
				

			}
		});



		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Test");
	}

	public static void main(String[] args) {

		final XYChart chart = new XYChartBuilder().xAxisTitle("x").yAxisTitle("y").title("Ausgaben").width(400)
				.height(300).build();

//		// Customize Chart
//		chart.getStyler().setLegendPosition(LegendPosition.InsideNE);
//		chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Area);

		// Series
		chart.addSeries("a", new double[] { 0, 3, 5, 7, 9 }, new double[] { -3, 5, 9, 6, 5 });
		chart.addSeries("b", new double[] { 0, 2, 4, 6, 9 }, new double[] { -1, 6, 4, 0, 4 });
		chart.addSeries("c", new double[] { 0, 1, 3, 8, 9 }, new double[] { -2, -1, 1, 0, 1 });

		new FrameDashboard(chart);

	}
}
