package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.BookDao;

public class BookSearch extends JFrame {
	
	JPanel AllPanel, TextPanel;
	JLabel SearchResultLabel;
	JTextField SearchResultText;
	JTable SearchResultTable;
	JScrollPane SearchResultPane;
	
	Vector SearchResultRow;
	Vector SearchResultCols;
	
	DefaultTableModel SRTModel;
	
	static BookSearch SearchList = null;
	
	static BookDao bookDao = null;
	
	public BookSearch() {

		iniComponent();

	}

	private void iniComponent() {
		
		BookDao bookDao = new BookDao(); 
		
		ArrayList list = bookDao.getBookList();
		
		this.setTitle("검색 목록리스트");
		
		AllPanel = new JPanel();
		TextPanel = new JPanel();
		SearchResultLabel = new JLabel("검색결과");
		
		TextPanel.setLayout(new FlowLayout());
		TextPanel.add(SearchResultLabel);
		SearchResultText = new JTextField("검색결과", 30);
		TextPanel.add(SearchResultText);
		TextPanel.setBorder(BorderFactory.createEmptyBorder(20, 5, 5, 5));
		AllPanel.add(TextPanel);
		
		
		SearchResultCols = new Vector<>();
		SearchResultCols.add("책 번호");
		SearchResultCols.add("책 제목");
		SearchResultCols.add("저자");
		SearchResultCols.add("출판사");
		
//		Vector SearchResultData = new Vector();
//		for (int i = 0; i < list.size(); i++) {
//			Vector SearchResultRow = new Vector();
//			ArrayList list2 = new ArrayList(); 
//			list2.add(list.get(i));
//			for (int j = 0; j < 4; j++) {
//				String[] line =  String.valueOf(Arrays.deepToString((Object[]) list2.get(0))).split(", ");
//				String number1 = line[0];
//				String number = number1.replace("[", "");
//				line[0] = number;
//				String title = line[1];
//				String author = line[2];
//				String psdf = line[3];
//				String publisher = psdf.replace("]", "");
//				line[3] = publisher;
////				System.out.println(String.valueOf(Arrays.deepToString(line)));
//				
//				SearchResultRow.add(line[j]);
//			
//	    		//SearchRow.add(Arrays.deepToString((Object[]) list2.get(0)));
//			}
//			SearchResultData.add(SearchResultRow);
//		}
//		
		
		Vector SearchResultData = new Vector();
		for (int i = 0; i < list.size(); i++) {
			Vector SearchResultRow = new Vector();
			ArrayList list2 = new ArrayList(); 
			list2.add(list.get(i));
			for (int j = 0; j < 4; j++) {
				String[] line =  String.valueOf(Arrays.deepToString((Object[]) list2.get(0))).split(", ");
				String number1 = line[0];
				String number = number1.replace("[", "");
				line[0] = number;
				String title = line[1];
				String author = line[2];
				String psdf = line[3];
				String publisher = psdf.replace("]", "");
				line[3] = publisher;
//				System.out.println(String.valueOf(Arrays.deepToString(line)));
				
				SearchResultRow.add(line[j]);
			
	    		//SearchRow.add(Arrays.deepToString((Object[]) list2.get(0)));
			}
			SearchResultData.add(SearchResultRow);
		}
		
		
		
		SRTModel = new DefaultTableModel(SearchResultData, SearchResultCols) { // 칼럼, 데이터 생성
			public boolean isCellEditable(int row, int column) {
				return false;

			}
		};
		
		SearchResultTable = new JTable(SRTModel);                                    // 리스트테이블 생성 -> 모델을 리스트테이블에 연결
		SearchResultPane = new JScrollPane(SearchResultTable);                          // 리스트패널 생성 -> 리스트테이블을 리스트패널에 연결
		SearchResultPane.add(SearchResultTable);                                        // 리스트테이블을 리스트패널에 포함
		AllPanel.add(SearchResultPane);                                          // 리스트패널을 검색패널에 포함
		SearchResultPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));

		SearchResultTable.setModel(SRTModel);             // 리스트테이블을 실행하기전에 테이블모델 실행
		SearchResultPane.setViewportView(SearchResultTable);
		
		this.add(AllPanel);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 600);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		if (SearchList != null)
			SearchList.dispose();
		SearchList = new BookSearch();
		
	}
		
}
