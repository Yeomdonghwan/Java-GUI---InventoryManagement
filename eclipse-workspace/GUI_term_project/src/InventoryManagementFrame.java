import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

//물품추가 패널
class AddGoodsPanel extends JPanel {

	JPanel panel_input = new JPanel();

	JLabel label_id = new JLabel("등록할 물품 번호");
	JLabel label_name = new JLabel("등록할 물품 명");
	JLabel label_price = new JLabel("등록할 물품 가격");
	JTextField textField_id = new JTextField(30);
	JTextField textField_name = new JTextField(30);
	JTextField textField_price = new JTextField(30);

	JButton button_add = new JButton("등록");

	public InventoryManagementFrame frame = null;

	public AddGoodsPanel(InventoryManagementFrame frame) {
		this.frame = frame;
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setSize(new Dimension(250, 250));
		initView();
		eventHandler();
	}

	private void eventHandler() {
		button_add.addActionListener(new AddButtonListener(this));
	}

	private void initView() {

		TitledBorder titleBorder = new TitledBorder(new LineBorder(Color.black), "물품 추가");
		this.setBorder(titleBorder);
		panel_input.setLayout(new GridLayout(0, 2));
		panel_input.add(label_id);
		panel_input.add(textField_id);
		panel_input.add(label_name);
		panel_input.add(textField_name);
		panel_input.add(label_price);
		panel_input.add(textField_price);
		this.add(panel_input);
		this.add(button_add);

	}
}

//물품입고 패널
class WarehousingPanel extends JPanel {
	JPanel panel_input = new JPanel();
	JLabel label_id = new JLabel("입고할 물품 번호");
	JLabel label_amount = new JLabel("입고량");
	JTextField textField_id = new JTextField(30);
	JTextField textField_amount = new JTextField(30);
	JButton button_warehousing = new JButton("입고");

	InventoryManagementFrame frame = null;

	public WarehousingPanel(InventoryManagementFrame frame) {
		this.frame = frame;
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		initView();
		eventHandler();
	}

	private void eventHandler() {
		button_warehousing.addActionListener(new WarehousingButtonListener(this));

	}

	private void initView() {

		TitledBorder titleBorder = new TitledBorder(new LineBorder(Color.black), "재고 입고");
		this.setBorder(titleBorder);
		panel_input.setLayout(new GridLayout(0, 2));
		panel_input.add(label_id);
		panel_input.add(textField_id);
		panel_input.add(label_amount);
		panel_input.add(textField_amount);

		this.add(panel_input);
		this.add(button_warehousing);

	}
}

//물품출고 패널
class StockOutPanel extends JPanel {
	JPanel panel_input = new JPanel();
	JLabel label_id = new JLabel("출고할 물품 번호");
	JLabel label_amount = new JLabel("출고량");
	JTextField textField_id = new JTextField(30);
	JTextField textField_amount = new JTextField(30);
	JButton button_stockOut = new JButton("출고");

	InventoryManagementFrame frame = null;

	public StockOutPanel(InventoryManagementFrame frame) {
		this.frame = frame;
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		initView();
		eventHandler();
	}

	private void eventHandler() {
		button_stockOut.addActionListener(new StockOutButtonListener(this));

	}

	private void initView() {

		TitledBorder titleBorder = new TitledBorder(new LineBorder(Color.black), "재고 출고");
		this.setBorder(titleBorder);
		panel_input.setLayout(new GridLayout(0, 2));
		panel_input.add(label_id);
		panel_input.add(textField_id);
		panel_input.add(label_amount);
		panel_input.add(textField_amount);

		this.add(panel_input);
		this.add(button_stockOut);

	}
}

//물품수정 패널
class EditGoodsPanel extends JPanel {

	JPanel panel_input = new JPanel();

	JLabel label_id = new JLabel("수정할 물품 번호");
	JLabel label_name = new JLabel("수정할 물품 명");
	JLabel label_price = new JLabel("수정할 물품 가격");
	JTextField textField_id = new JTextField(30);
	JTextField textField_name = new JTextField(30);
	JTextField textField_price = new JTextField(30);

	JButton button_edit = new JButton("수정");

	InventoryManagementFrame frame = null;

	public EditGoodsPanel(InventoryManagementFrame frame) {
		this.frame = frame;
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setSize(new Dimension(250, 250));
		initView();
		eventHandler();
	}

	private void eventHandler() {
		button_edit.addActionListener(new EditButtonListener(this));

	}

	private void initView() {

		TitledBorder titleBorder = new TitledBorder(new LineBorder(Color.black), "물품 수정");
		this.setBorder(titleBorder);
		panel_input.setLayout(new GridLayout(0, 2));
		panel_input.add(label_id);
		panel_input.add(textField_id);
		panel_input.add(label_name);
		panel_input.add(textField_name);
		panel_input.add(label_price);
		panel_input.add(textField_price);
		this.add(panel_input);
		this.add(button_edit);

	}
}

//정렬옵션 패널
class SortOptionPanel extends JPanel {
	JRadioButton radioButton_ascending;
	JRadioButton radioButton_descending;

	InventoryManagementFrame frame;

	SortOptionPanel(InventoryManagementFrame frame) {
		this.frame = frame;
		initView();
		eventHandler();
	}

	private void eventHandler() {
		radioButton_ascending.addActionListener(new SortButtonListener(this, false));
		radioButton_descending.addActionListener(new SortButtonListener(this, true));

	}

	private void initView() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		radioButton_ascending = new JRadioButton("오름차순");
		radioButton_descending = new JRadioButton("내림차순");

		ButtonGroup bg = new ButtonGroup();
		bg.add(radioButton_ascending);
		bg.add(radioButton_descending);

		this.add(radioButton_ascending);
		this.add(radioButton_descending);
	}

}

//재고 있는 물품만 나타내기
class DisplayOptionPanel extends JPanel {
	JCheckBox checkBox_displayOption = new JCheckBox("재고 있는 물품만 표시");
	InventoryManagementFrame frame;

	public DisplayOptionPanel(InventoryManagementFrame frame) {
		this.frame = frame;

		initView();
		eventHandler();
	}

	private void eventHandler() {
		checkBox_displayOption.addActionListener(new displayOptionButtonListener(this));

	}

	private void initView() {
		this.add(checkBox_displayOption);
	}
}

//메인프레임
public class InventoryManagementFrame extends JFrame {
	JTable table;
	JScrollPane scrollTable;
	DefaultTableModel model;
	String[] columns = { "물품번호", "물품명", "물품가격", "재고량", "최종변경일자" };
	ArrayList<Goods> goods_list = new ArrayList<>();// 상품 어레이리스트 생성
	JPanel controlPanel = new JPanel();

	JPanel menu = new JPanel();
	JPanel leftPanel = new JPanel();

	AddGoodsPanel addGoodsPanel = new AddGoodsPanel(this);
	WarehousingPanel warehousingPanel = new WarehousingPanel(this);
	StockOutPanel stockOutPanel = new StockOutPanel(this);
	EditGoodsPanel editGoodsPanel = new EditGoodsPanel(this);

	SortOptionPanel sortOptionPanel = new SortOptionPanel(this);
	DisplayOptionPanel displayOptionPanel = new DisplayOptionPanel(this);
	JButton initButton = new JButton("초기화");

	public InventoryManagementFrame() {
		this.setTitle("재고 관리 프로그램"); // 타이틀 설정
		this.setSize(new Dimension(700, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 1번구현. x버튼누르면 꺼지게함
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		initView();
		eventHandler();
		this.setVisible(true);
	}

	public void initView() {
		model = new DefaultTableModel(columns, 0) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};// 테이블을 수정불가하게 설정
		table = new JTable(model);

		menu.setLayout(new BoxLayout(menu, BoxLayout.X_AXIS));
		menu.add(sortOptionPanel);
		menu.add(displayOptionPanel);
		menu.add(initButton);

		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		leftPanel.add(menu);
		scrollTable = new JScrollPane(table);
		scrollTable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		leftPanel.add(scrollTable);

		this.add(leftPanel);

		controlPanel.setBackground(Color.white);
		controlPanel.setLayout(new GridLayout(4, 1));

		controlPanel.add(addGoodsPanel);
		controlPanel.add(warehousingPanel);
		controlPanel.add(stockOutPanel);
		controlPanel.add(editGoodsPanel);

		this.add(controlPanel);

	}

	public void eventHandler() {
		table.addMouseListener(new TableClickListener(this));

		initButton.addActionListener(new InitButtonListener(this));

	}

	public void addGoods(Goods goods) {
		goods_list.add(goods);
		Object record[] = new Object[5];

		record[0] = goods.getId();
		record[1] = goods.getName();
		record[2] = goods.getPrice();
		record[3] = goods.getStock();
		record[4] = goods.getDate();

		model.addRow(record);
	}

	public void warehousing(String id, int amount) {
		for (Goods goods : goods_list) {
			if (goods.getId().equals(id)) {
				goods.setDate();
				goods.setStock(goods.getStock() + amount);
				table.setValueAt(goods.getStock(), goods_list.indexOf(goods), 3);
				table.setValueAt(goods.getDate(), goods_list.indexOf(goods), 4);
			}
		}

	}

	public void stockOut(String id, int amount) {
		for (Goods goods : goods_list) {
			if (goods.getId().equals(id)) {
				goods.setStock(goods.getStock() - amount);
				goods.setDate();
				table.setValueAt(goods.getStock(), goods_list.indexOf(goods), 3);
				table.setValueAt(goods.getDate(), goods_list.indexOf(goods), 4);
			}
		}

	}

	public void editGoods(String id, String name, int price) {
		for (Goods goods : goods_list) {
			if (goods.getId().equals(id)) {
				goods.setPrice(price);
				goods.setName(name);
				goods.setDate();
				table.setValueAt(goods.getName(), goods_list.indexOf(goods), 1);
				table.setValueAt(goods.getPrice(), goods_list.indexOf(goods), 2);
				table.setValueAt(goods.getDate(), goods_list.indexOf(goods), 4);
			}
		}
	}

	public void sortingGoods(boolean reverse) {
		int numOfRow = model.getRowCount();
		Object record[] = new Object[5];
		for (int i = 0; i < numOfRow; i++) {
			model.removeRow(0);
		} // 모두 삭제 후
		if (reverse == false)
			Collections.sort(goods_list, new UserComparator());
		else
			Collections.sort(goods_list, new UserComparator().reversed());
		for (Goods goods : goods_list) {
			record[0] = goods.getId();
			record[1] = goods.getName();
			record[2] = goods.getPrice();
			record[3] = goods.getStock();
			record[4] = goods.getDate();
			model.addRow(record);
		}

	}

	public void initialize() {
		int numOfRow = model.getRowCount();
		for (int i = 0; i < numOfRow; i++) {
			model.removeRow(0);
			goods_list.remove(0);
		}
	}

	public void displayOnlyInStock(boolean flag) {

		int numOfRow = model.getRowCount();
		for (int i = 0; i < numOfRow; i++) {
			model.removeRow(0);
		}
		Object[] record = new Object[5];

		for (Goods goods : goods_list) {

			if (flag && goods.getStock() <= 0)
				continue;

			record[0] = goods.getId();
			record[1] = goods.getName();
			record[2] = goods.getPrice();
			record[3] = goods.getStock();
			record[4] = goods.getDate();
			model.addRow(record);

		}
	}
}
