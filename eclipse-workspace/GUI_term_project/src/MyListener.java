import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

class AddButtonListener implements ActionListener {
	AddGoodsPanel addGoodsPanel;

	public AddButtonListener(AddGoodsPanel addGoodsPanel) {
		this.addGoodsPanel = addGoodsPanel;
	}

	public void actionPerformed(ActionEvent e) {
		String id = addGoodsPanel.textField_id.getText();
		String name = addGoodsPanel.textField_name.getText();
		int price = Integer.parseInt(addGoodsPanel.textField_price.getText());

		addGoodsPanel.frame.addGoods(new Goods(id, name, price));
		
		addGoodsPanel.textField_id.setText("");
		addGoodsPanel.textField_name.setText("");
		addGoodsPanel.textField_price.setText("");
	}

}

class WarehousingButtonListener implements ActionListener {
	WarehousingPanel warehousingPanel;

	public WarehousingButtonListener(WarehousingPanel warehousingPanel) {
		this.warehousingPanel = warehousingPanel;
	}

	public void actionPerformed(ActionEvent e) {
		String id = warehousingPanel.textField_id.getText();
		int amount = Integer.parseInt(warehousingPanel.textField_amount.getText());

		warehousingPanel.frame.warehousing(id, amount);

		warehousingPanel.textField_id.setText("");
		warehousingPanel.textField_amount.setText("");
	}

}

class StockOutButtonListener implements ActionListener {
	StockOutPanel stockOutPanel;

	public StockOutButtonListener(StockOutPanel stockOutPanel) {
		this.stockOutPanel = stockOutPanel;
	}

	public void actionPerformed(ActionEvent e) {
		String id = stockOutPanel.textField_id.getText();
		int amount = Integer.parseInt(stockOutPanel.textField_amount.getText());

		stockOutPanel.frame.stockOut(id, amount);

		stockOutPanel.textField_id.setText("");
		stockOutPanel.textField_amount.setText("");
	}

}

class EditButtonListener implements ActionListener {
	EditGoodsPanel editGoodsPanel;

	public EditButtonListener(EditGoodsPanel editGoodsPanel) {
		this.editGoodsPanel = editGoodsPanel;
	}

	public void actionPerformed(ActionEvent e) {
		String id = editGoodsPanel.textField_id.getText();
		String name = editGoodsPanel.textField_name.getText();
		int price = Integer.parseInt(editGoodsPanel.textField_price.getText());

		editGoodsPanel.frame.editGoods(id, name, price);
		
		editGoodsPanel.textField_id.setText("");
		editGoodsPanel.textField_name.setText("");
		editGoodsPanel.textField_price.setText("");
	}

}

class SortButtonListener implements ActionListener {
	SortOptionPanel sortOptionPanel;
	boolean reverse;

	public SortButtonListener(SortOptionPanel sortOptionPanel, boolean reverse) {
		this.sortOptionPanel = sortOptionPanel;
		this.reverse = reverse;
	}

	public void actionPerformed(ActionEvent e) {

		sortOptionPanel.frame.sortingGoods(reverse);
	}

}

class displayOptionButtonListener implements ActionListener {
	DisplayOptionPanel displayOptionPanel;

	public displayOptionButtonListener(DisplayOptionPanel displayOptionPanel) {
		this.displayOptionPanel = displayOptionPanel;

	}

	public void actionPerformed(ActionEvent e) {

		if (displayOptionPanel.checkBox_displayOption.isSelected())
			displayOptionPanel.frame.displayOnlyInStock(true);
		else {
			displayOptionPanel.frame.displayOnlyInStock(false);
		}

	}

}

class TableClickListener extends MouseAdapter {
	InventoryManagementFrame inventoryManagementFrame;

	public TableClickListener(InventoryManagementFrame inventoryManagementFrame) {
		this.inventoryManagementFrame = inventoryManagementFrame;

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {

			JTable target = (JTable) e.getSource();
			int row = target.getSelectedRow();

			inventoryManagementFrame.goods_list.remove(row);
			inventoryManagementFrame.model.removeRow(row);
		}
	}

}

class InitButtonListener implements ActionListener {
	InventoryManagementFrame inventoryManagementFrame;

	InitButtonListener(InventoryManagementFrame inventoryManagementFrame) {
		this.inventoryManagementFrame = inventoryManagementFrame;
	}

	public void actionPerformed(ActionEvent e) {
		inventoryManagementFrame.initialize();

	}
}