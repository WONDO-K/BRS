package view;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventObject;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import model.BookDao;
import model.BookVo;
import model.MemberDao;
import model.RentalDao;

public class BookMenu extends JFrame implements ActionListener, KeyListener, MouseListener {

	// Component 목록
	JPanel AllPanel, ReturnPanel, SearchPanel, SearchTextPanel, ButtonPanel1, ButtonPanel2;
	JTable ReturnListTable, BookListTable;
	JScrollPane ReturnPane, BookListPane;
	JLabel ReturnLabel, SearchLabel, ListLabel;
	JButton MyPageButton, SearchButton, LogoutButton, ReturnButton;
	JTextField SearchText;
	JList RentalList, BookList;
	MyPage mypage;

	// Vector 목록
	Vector SearchRow;
	Vector searchCols;
	Vector returnRow;
	Vector returnCols;

	// DefaultTableModel에 의해서 JTable의 행 추가, 행 삽입, 행 삭제, 열의 추가 등을 실행한다
	DefaultTableModel STModel, RTModel;

	static BookMenu List;
	static BookDao bookDao = null;
	static BookVo bookVo = null;

	BookInfom Bomformation = null;
	String memberId = null;
	Main main;

	// 생성자 : class를 new 할때 실행되는 명령들
	public BookMenu(String id) {
		memberId = id;
		iniComponent();
	}

	// initComponent()
	private void iniComponent() {

		BookDao bookDao = new BookDao();
		
		ArrayList list = bookDao.getBookList();
		BookVo book = bookDao.getbook(getTitle());

		this.setTitle("도서 대여 프로그램 v1.0");

		AllPanel = new JPanel(new GridLayout(1, 0)); // 전체 패널을 GridLayout으로 1행 2열
		ReturnPanel = new JPanel(); // 반납패널 생성
		ReturnPanel.setLayout(new BoxLayout(ReturnPanel, BoxLayout.Y_AXIS)); // 반납패널 BoxLayout으로 Y축 정렬
		SearchPanel = new JPanel(); // 검색패널 생성
		SearchPanel.setLayout(new BoxLayout(SearchPanel, BoxLayout.Y_AXIS)); // 검색패널 BoxLayout으로 Y축 정렬
		ReturnPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		SearchPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		ReturnLabel = new JLabel("내가 빌린 책"); // 반납레이블 생성
		ReturnPanel.add(ReturnLabel); // 반납레이블을 반납패널에 포함
		ReturnPanel.setBorder(BorderFactory.createEmptyBorder(83, 20, 20, 20));

		RTModel = new DefaultTableModel(getRentalDataList(), getRentalColumns()) { // 칼럼, 데이터 생성
			public boolean isCellEditable(int row, int column) {
				if (column <= 1) {
					return false;
				} else {
					return true;
				}

			}
		};
		
		ReturnListTable = new JTable(RTModel); // 반납테이블 생성 -> 모델을 반납테이블에 연결
		ReturnPane = new JScrollPane(ReturnListTable); // 반납 스크롤페인 생성
		ReturnPane.add(ReturnListTable); // 반납테이블을 반납 스크롤페인에 포함
		ReturnPanel.add(ReturnPane); // 반납 스크롤페인을 반납패널에 포함
		ReturnPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));

		ReturnListTable.getColumn("반납여부").setCellRenderer(new RendererAndEditor());
		ReturnListTable.getColumn("반납여부").setCellEditor(new RendererAndEditor());

		ReturnListTable.setModel(RTModel); // 반납테이블을 실행하기전에 테이블모델 실행
		ReturnPane.setViewportView(ReturnListTable);

		ButtonPanel1 = new JPanel(); // 로그아웃버튼 패널 생성
		ButtonPanel1.setLayout(new FlowLayout()); // 로그아웃버튼 패널 FlowLayout으로 정렬
		ReturnPanel.add(ButtonPanel1); // 로그아웃버튼 패널을 바납패널에 포함
		LogoutButton = new JButton("로그아웃"); // 로그아웃버튼 생성
		ButtonPanel1.add(LogoutButton); // 로그아웃버튼을 로그아웃버튼패널에 포함

		SearchLabel = new JLabel("도서 검색"); // 검색레이블 생성
		SearchPanel.add(SearchLabel); // 검색레이블을 검색패널에 포함
		SearchPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		SearchTextPanel = new JPanel(); // 검색텍스트패널 생성
		SearchTextPanel.setLayout(new FlowLayout()); // 검색텍스트패널을 FlowLayout으로 정렬
		SearchPanel.add(SearchTextPanel); // 검색텍스트패널을 검색패널에 포함

		SearchText = new JTextField(30); // 검색텍스트필드 생성(최대 30자)
		SearchTextPanel.add(SearchText); // 검색텍스트필드를 검색텍스트패널에 포함
		SearchButton = new JButton("검색"); // 검색버튼 생성
		SearchTextPanel.add(SearchButton); // 검색버튼을 검색텍스트패널에 포함

		ListLabel = new JLabel("책 리스트"); // 리스트레이블 생성
		SearchPanel.add(ListLabel); // 리스트레이블을 검색패널에 포함

		// 리스트테이블 제목줄 header 지정
		searchCols = new Vector<>();
		searchCols.add("책 번호");
		searchCols.add("책 제목");
		searchCols.add("저자");
		searchCols.add("출판사");

		// 리스트테이블에 출력할 자료
		Vector SearchData = new Vector();
		for (int i = 0; i < list.size(); i++) {
			Vector SearchRow = new Vector();
			ArrayList list2 = new ArrayList();
			list2.add(list.get(i));
			for (int j = 0; j < 4; j++) {
				String[] line = String.valueOf(Arrays.deepToString((Object[]) list2.get(0))).split(", ");
				String number1 = line[0];
				String number = number1.replace("[", "");
				line[0] = number;
				String b_title = line[1];
				String author = line[2];
				String psdf = line[3];
				String publisher = psdf.replace("]", "");
				line[3] = publisher;
//				System.out.println(String.valueOf(Arrays.deepToString(line)));

				SearchRow.add(line[j]);

				// SearchRow.add(Arrays.deepToString((Object[]) list2.get(0)));
			}
			SearchData.add(SearchRow);
		}

		STModel = new DefaultTableModel(SearchData, searchCols) { // 칼럼, 데이터 생성
			public boolean isCellEditable(int row, int column) {
				return false;

			}
		};

		BookListTable = new JTable(STModel); // 리스트테이블 생성 -> 모델을 리스트테이블에 연결
		BookListPane = new JScrollPane(BookListTable); // 리스트패널 생성 -> 리스트테이블을 리스트패널에 연결
		BookListPane.add(BookListTable); // 리스트테이블을 리스트패널에 포함
		SearchPanel.add(BookListPane); // 리스트패널을 검색패널에 포함
		BookListPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));

		BookListTable.setModel(STModel); // 리스트테이블을 실행하기전에 테이블모델 실행
		BookListPane.setViewportView(BookListTable);

		ButtonPanel2 = new JPanel(); // 마이페이지버튼패널 생성
		ButtonPanel2.setLayout(new FlowLayout()); // 마이페이지버튼패널을 FlowLayout으로 정렬
		SearchPanel.add(ButtonPanel2); // 마이페이지버튼패널을 검색패널에 포함
		MyPageButton = new JButton("마이페이지"); // 마이페이지버튼 생성
		ButtonPanel2.add(MyPageButton); // 마이페이지버튼을 마이페이지버튼패널에 포함

		this.add(AllPanel); // 전체패널 포함
		AllPanel.add(ReturnPanel); // 반납패널을 전체패널에 포함
		AllPanel.add(SearchPanel); // 검색패널을 전체패널에 포함

		// 버튼 기능부여 : 이벤트 연결
		this.LogoutButton.addActionListener(this); // -> actionPerformed
		this.SearchButton.addActionListener(this);
		this.MyPageButton.addActionListener(this);

		this.BookListTable.addMouseListener(this);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 사용자가 클로우즈를 눌렀을 경우 디폴트로 실행
		this.setSize(1000, 650); // 프레임 사이즈
		this.setVisible(true); // 프레임 보이게 하기

	}

	// 반납목록 가져오기
	private Vector getRentalDataList() {

		RentalDao rentalDao = new RentalDao();
		ArrayList returnList = rentalDao.getRentalList(memberId);
		
		Vector returnData = new Vector();
		for (int i = 0; i < returnList.size(); i++) {
			Vector returnRow = new Vector();
			ArrayList returnList2 = new ArrayList();
			returnList2.add(returnList.get(i));
			for (int j = 0; j < 4; j++) {
				String[] line = String.valueOf(Arrays.deepToString((Object[]) returnList2.get(0))).split(", ");
				String number1 = line[0];
				String number = number1.replace("[", "");
				line[0] = number;
				
				returnRow.add(line[j]);
			}
			returnData.add(returnRow);

		}

		return returnData;
	}
	
	// 반납테이블 제목줄 header 지정
	private Vector getRentalColumns() {
		returnCols = new Vector<>();
		returnCols.add("책 번호");
		returnCols.add("책 제목");
		returnCols.add("반납기간");
		returnCols.add("반납여부");
		
		return returnCols;
	}
	
	// 반납테이블 새로고침
	public void rentalTableRefresh() {		
		ReturnListTable.setModel(new DefaultTableModel(getRentalDataList(), getRentalColumns()) { // 칼럼, 데이터 생성
			public boolean isCellEditable(int row, int column) {
				if (column <= 1) {
					return false;
				} else {
					return true;
				}

			}
		});
		ReturnListTable.repaint(); // swing component : ui 요소를 새로그린다.
		// 반납버튼 재생성
		ReturnListTable.getColumn("반납여부").setCellRenderer(new RendererAndEditor());
		ReturnListTable.getColumn("반납여부").setCellEditor(new RendererAndEditor());
	}
	
//	public static void main(String[] args) {
//		if (List != null)
//			List.dispose();
//		List = new BookMenu(); // 책 메뉴 개체 생성
//
//	}

	// 이벤트 목록들
	// 버튼들의 기능연결 클릭될때

	@Override
	public void actionPerformed(ActionEvent e) {
		MyPage mypage = new MyPage(memberId);
		
		switch (e.getActionCommand()) {
		case "검색":
			SearchResult();
			break;
		case "마이페이지":
			mypage.frame.setVisible(true);
			break;
		case "로그아웃":
			dispose();
			main = new Main();
			break;
		}

	}

	private void SearchResult() {

		String title = SearchText.getText();

		// if( Bomformation != null )
		Bomformation = new BookInfom(title, this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int r = BookListTable.getSelectedRow();
		int b_number = Integer.parseInt(BookListTable.getValueAt(r, 0).toString());

		if (Bomformation != null)
			Bomformation.dispose();
		Bomformation = new BookInfom(b_number, this);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	class RendererAndEditor implements TableCellRenderer, TableCellEditor {
		RendererAndEditor() {

			ReturnButton = new JButton("반납");
			ReturnButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int r = ReturnListTable.getSelectedRow();
					int b_number = Integer.parseInt(ReturnListTable.getValueAt(r, 0).toString());
					
					int reusult = JOptionPane.showConfirmDialog(null, "반납하시겠습니까?", "반납여부", JOptionPane.YES_NO_OPTION);
					if (reusult == JOptionPane.CLOSED_OPTION) {

					} else if (reusult == JOptionPane.YES_OPTION) {
						RentalDao rentalDao = new RentalDao();
						rentalDao.returnBook(b_number);
						rentalDao.PlusCount(b_number);
						JOptionPane.showMessageDialog(null, "반납되었습니다.", "반납여부", JOptionPane.OK_OPTION);
						rentalTableRefresh();
					} else {

					}
				}
			});
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			return ReturnButton;
		}

		@Override
		public java.awt.Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			return ReturnButton;
		}

		@Override
		public Object getCellEditorValue() {
			return null;
		}

		@Override
		public boolean isCellEditable(EventObject anEvent) {
			return true;
		}

		@Override
		public boolean shouldSelectCell(EventObject anEvent) {
			return true;
		}

		@Override
		public boolean stopCellEditing() {
			return true;
		}

		@Override
		public void cancelCellEditing() {
		}

		@Override
		public void addCellEditorListener(CellEditorListener l) {
		}

		@Override
		public void removeCellEditorListener(CellEditorListener l) {
		}
	}

}
