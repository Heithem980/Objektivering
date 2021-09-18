package container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;


import javax.swing.JTextArea;


public class MessageListener implements ActionListener{
	
	private JTextArea data;
	private static String COMMA_DELIMITER = ",";
	private static ArrayList<ArrayList<String>> wholeSheet = new ArrayList<>();
	private static ArrayList<String> sortedList = new ArrayList<String>();

	public MessageListener(JTextArea data) {
		// TODO Auto-generated constructor stub
		this.data = data;
	}
	
	// when "update" button is pressed, CSV File is loaded, sorted then displayed.
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		loadCSV();
		//System.out.print(wholeSheet);
		sortCSV();
		
		
		
		String newList = "Rep1[0, OrderDate, Region, Rep1, Rep2, Item, Units, UnitCost, Total]";
		
		for(int i = 0; i<sortedList.size(); i++) {
			
			newList = newList + "\n" + sortedList.get(i);
		}
		
		
		
		data.append(newList);
		
		sortedList.clear();
		wholeSheet.clear();
		
		
		
	}
	
	// Load CSV and scan rows
	public static void loadCSV() {
		
		String csvFile = "src/sample.csv";
		File file = new File(csvFile);
		
		try  {
			Scanner scanner = new Scanner(file);
			int i = 0;
			while (scanner.hasNextLine()) {
				wholeSheet.add(getRows(scanner.nextLine(), i));
				i++;
			}
			scanner.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	// Get row values separeted by ","
	private static ArrayList<String> getRows(String row, int i) {
		
		ArrayList<String> rowValues = new ArrayList<String>();
		
		try (Scanner rowScanner = new Scanner(row)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);

			
			rowValues.add(String.valueOf(i));
			while (rowScanner.hasNext()) {
				String currentCell = rowScanner.next();
				

				
					rowValues.add(currentCell);
				

			}
		}

		return rowValues;
	}
	// This method sorts rows by "rep1" and add to ArrayList sortedList
	public static void sortCSV() {
		
		for (int i = 1; i< wholeSheet.size(); i++) {
			
			String name = wholeSheet.get(i).get(3);
			
			sortedList.add(name + wholeSheet.get(i));
			
		}
		
		Collections.sort(sortedList);
	}

}
