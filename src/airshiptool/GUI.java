package airshiptool;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUI extends JFrame implements ActionListener , ChangeListener{

	private JPanel contentPane;
	private JTextField bow_textField;
	private JTextField bow_textField_1;
	private JTextField bow_textField_2;
	private JTextField bow_textField_3;
	private JTextField bow_textField_4;
	private JTextField bow_textField_5;
	private JTextField bow_textField_6;
	private JTextField bow_textField_7;
	private JTextField hull_textField;
	private JTextField hull_textField_1;
	private JTextField hull_textField_2;
	private JTextField hull_textField_3;
	private JTextField hull_textField_4;
	private JTextField hull_textField_5;
	private JTextField hull_textField_6;
	private JTextField hull_textField_7;
	private JTextField rigging_textField;
	private JTextField rigging_textField_1;
	private JTextField rigging_textField_2;
	private JTextField rigging_textField_3;
	private JTextField rigging_textField_4;
	private JTextField rigging_textField_5;
	private JTextField rigging_textField_6;
	private JTextField rigging_textField_7;
	private JTextField stern_textField;
	private JTextField stern_textField_1;
	private JTextField stern_textField_2;
	private JTextField stern_textField_3;
	private JTextField stern_textField_4;
	private JTextField stern_textField_5;
	private JTextField stern_textField_6;
	private JTextField stern_textField_7;
	private JTextField sum_textField;
	private JTextField sum_textField_1;
	private JTextField sum_textField_2;
	private JTextField sum_textField_3;
	private JTextField sum_textField_4;
	private JTextField sum_textField_5;
	private JTextField sum_textField_6;
	private JTextField cap_textField;
	//船首のドロップダウンリスト
	JComboBox<String> comboBox = new JComboBox<String>();
	//船体のドロップダウンリスト
	JComboBox<String> comboBox_1 = new JComboBox<String>();
	//艤装のドロップダウンリスト
	JComboBox<String> comboBox_2 = new JComboBox<String>();
	//船尾のドロップダウンリスト
	JComboBox<String> comboBox_3 = new JComboBox<String>();
	//飛空艇のコスト選択
	private JSpinner spinner = new JSpinner();

	private JLabel label_15;


	/**
	 * Launch the application.
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		Table.makelist();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 290);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("飛空艇デザインシミュレータ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(367, 10, 180, 13);
		contentPane.add(label);

		JLabel label_1 = new JLabel("飛空艇ランク");
		label_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		label_1.setBounds(12, 42, 75, 20);
		contentPane.add(label_1);

		//飛空艇のランク選択
		spinner.setModel(new SpinnerNumberModel(1, 1, 50, 1));
		spinner.setBounds(118, 43, 50, 20);
		spinner.addChangeListener(this);
		contentPane.add(spinner);

		JLabel label_2 = new JLabel("船首");
		label_2.setBounds(12, 109, 50, 13);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("船体");
		label_3.setBounds(12, 132, 50, 13);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("艤装");
		label_4.setBounds(12, 155, 50, 13);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("船尾");
		label_5.setBounds(12, 178, 50, 13);
		contentPane.add(label_5);

		//ドロップダウンリストに要素を追加
		for(int i = 0;i<Table.bow.size();i++){
			comboBox.addItem(Table.bow.get(i).name);
		}
		comboBox.setEditable(false);
		comboBox.setEnabled(true);
		comboBox.setBounds(59, 106, 160, 19);
		int bow_num = comboBox.getSelectedIndex();
		comboBox.setActionCommand("bow_list");
		comboBox.addActionListener(this);
		contentPane.add(comboBox);

		//ドロップダウンリストに要素を追加
		for(int i = 0;i<Table.hull.size();i++){
			comboBox_1.addItem(Table.hull.get(i).name);
		}
		comboBox_1.setEditable(false);
		comboBox_1.setEnabled(true);
		comboBox_1.setBounds(59, 129, 160, 19);
		int hull_num = comboBox_1.getSelectedIndex();
		comboBox_1.setActionCommand("hull_list");
		comboBox_1.addActionListener(this);
		contentPane.add(comboBox_1);

		//ドロップダウンリストに要素を追加
		for(int i = 0;i<Table.rigging.size();i++){
			comboBox_2.addItem(Table.rigging.get(i).name);
		}
		comboBox_2.setEditable(false);
		comboBox_2.setEnabled(true);
		comboBox_2.setBounds(59, 152, 160, 19);
		int rigging_num = comboBox_2.getSelectedIndex();
		comboBox_2.setActionCommand("rigging_list");
		comboBox_2.addActionListener(this);
		contentPane.add(comboBox_2);


		//ドロップダウンリストに要素を追加
		for(int i = 0;i<Table.stern.size();i++){
			comboBox_3.addItem(Table.stern.get(i).name);
		}
		comboBox_3.setEditable(false);
		comboBox_3.setEnabled(true);
		comboBox_3.setBounds(59, 175, 160, 19);
		int stern_num = comboBox_3.getSelectedIndex();
		comboBox_3.setActionCommand("stern_list");
		comboBox_3.addActionListener(this);
		contentPane.add(comboBox_3);

		JLabel label_6 = new JLabel("探査性能");
		label_6.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		label_6.setBounds(237, 82, 50, 13);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel("収集性能");
		label_7.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		label_7.setBounds(313, 82, 50, 13);
		contentPane.add(label_7);

		JLabel label_8 = new JLabel("巡航速度");
		label_8.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		label_8.setBounds(395, 82, 50, 13);
		contentPane.add(label_8);

		JLabel label_9 = new JLabel("航続距離");
		label_9.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		label_9.setBounds(472, 82, 50, 13);
		contentPane.add(label_9);

		JLabel label_10 = new JLabel("運");
		label_10.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(555, 82, 50, 13);
		contentPane.add(label_10);

		JLabel label_11 = new JLabel("修理材");
		label_11.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(645, 82, 50, 13);
		contentPane.add(label_11);

		JLabel label_12 = new JLabel("コスト");
		label_12.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(733, 82, 50, 13);
		contentPane.add(label_12);

		JLabel label_13 = new JLabel("装備可能ランク");
		label_13.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBounds(801, 82, 85, 13);
		contentPane.add(label_13);
		//船首のデータ表示
		bow_textField = new JTextField();
		bow_textField.setEditable(false);
		bow_textField.setText(Table.bow.get(bow_num).exp_perf);
		bow_textField.setBounds(237, 106, 50, 19);
		contentPane.add(bow_textField);
		bow_textField.setColumns(10);

		bow_textField_1 = new JTextField();
		bow_textField_1.setEditable(false);
		bow_textField_1.setText(Table.bow.get(bow_num).coll_perf);
		bow_textField_1.setColumns(10);
		bow_textField_1.setBounds(313, 106, 50, 19);
		contentPane.add(bow_textField_1);

		bow_textField_2 = new JTextField();
		bow_textField_2.setEditable(false);
		bow_textField_2.setText(Table.bow.get(bow_num).cru_perf);
		bow_textField_2.setColumns(10);
		bow_textField_2.setBounds(395, 106, 50, 19);
		contentPane.add(bow_textField_2);

		bow_textField_3 = new JTextField();
		bow_textField_3.setEditable(false);
		bow_textField_3.setText(Table.bow.get(bow_num).cru_dist);
		bow_textField_3.setColumns(10);
		bow_textField_3.setBounds(472, 106, 50, 19);
		contentPane.add(bow_textField_3);

		bow_textField_4 = new JTextField();
		bow_textField_4.setEditable(false);
		bow_textField_4.setText(Table.bow.get(bow_num).luck);
		bow_textField_4.setColumns(10);
		bow_textField_4.setBounds(555, 106, 50, 19);
		contentPane.add(bow_textField_4);

		bow_textField_5 = new JTextField();
		bow_textField_5.setEditable(false);
		bow_textField_5.setText(Table.bow.get(bow_num).repair);
		bow_textField_5.setColumns(10);
		bow_textField_5.setBounds(645, 106, 50, 19);
		contentPane.add(bow_textField_5);

		bow_textField_6 = new JTextField();
		bow_textField_6.setEditable(false);
		bow_textField_6.setText(Table.bow.get(bow_num).cost);
		bow_textField_6.setColumns(10);
		bow_textField_6.setBounds(733, 106, 50, 19);
		contentPane.add(bow_textField_6);

		bow_textField_7 = new JTextField();
		bow_textField_7.setEditable(false);
		bow_textField_7.setText(Table.bow.get(bow_num).rank);
		bow_textField_7.setColumns(10);
		bow_textField_7.setBounds(817, 105, 50, 19);
		contentPane.add(bow_textField_7);

		hull_textField = new JTextField();
		hull_textField.setText(Table.hull.get(hull_num).exp_perf);
		hull_textField.setEditable(false);
		hull_textField.setColumns(10);
		hull_textField.setBounds(237, 129, 50, 19);
		contentPane.add(hull_textField);

		hull_textField_1 = new JTextField();
		hull_textField_1.setText(Table.hull.get(hull_num).coll_perf);
		hull_textField_1.setEditable(false);
		hull_textField_1.setColumns(10);
		hull_textField_1.setBounds(313, 129, 50, 19);
		contentPane.add(hull_textField_1);

		hull_textField_2 = new JTextField();
		hull_textField_2.setText(Table.hull.get(hull_num).cru_perf);
		hull_textField_2.setEditable(false);
		hull_textField_2.setColumns(10);
		hull_textField_2.setBounds(395, 129, 50, 19);
		contentPane.add(hull_textField_2);

		hull_textField_3 = new JTextField();
		hull_textField_3.setText(Table.hull.get(hull_num).cru_dist);
		hull_textField_3.setEditable(false);
		hull_textField_3.setColumns(10);
		hull_textField_3.setBounds(472, 129, 50, 19);
		contentPane.add(hull_textField_3);

		hull_textField_4 = new JTextField();
		hull_textField_4.setText(Table.hull.get(hull_num).luck);
		hull_textField_4.setEditable(false);
		hull_textField_4.setColumns(10);
		hull_textField_4.setBounds(555, 129, 50, 19);
		contentPane.add(hull_textField_4);

		hull_textField_5 = new JTextField();
		hull_textField_5.setText(Table.hull.get(hull_num).repair);
		hull_textField_5.setEditable(false);
		hull_textField_5.setColumns(10);
		hull_textField_5.setBounds(645, 129, 50, 19);
		contentPane.add(hull_textField_5);

		hull_textField_6 = new JTextField();
		hull_textField_6.setText(Table.hull.get(hull_num).cost);
		hull_textField_6.setEditable(false);
		hull_textField_6.setColumns(10);
		hull_textField_6.setBounds(733, 129, 50, 19);
		contentPane.add(hull_textField_6);

		hull_textField_7 = new JTextField();
		hull_textField_7.setText(Table.hull.get(hull_num).rank);
		hull_textField_7.setEditable(false);
		hull_textField_7.setColumns(10);
		hull_textField_7.setBounds(817, 128, 50, 19);
		contentPane.add(hull_textField_7);

		rigging_textField = new JTextField();
		rigging_textField.setText(Table.rigging.get(rigging_num).exp_perf);
		rigging_textField.setEditable(false);
		rigging_textField.setColumns(10);
		rigging_textField.setBounds(237, 152, 50, 19);
		contentPane.add(rigging_textField);

		rigging_textField_1 = new JTextField();
		rigging_textField_1.setText(Table.rigging.get(rigging_num).coll_perf);
		rigging_textField_1.setEditable(false);
		rigging_textField_1.setColumns(10);
		rigging_textField_1.setBounds(313, 152, 50, 19);
		contentPane.add(rigging_textField_1);

		rigging_textField_2 = new JTextField();
		rigging_textField_2.setText(Table.rigging.get(rigging_num).cru_perf);
		rigging_textField_2.setEditable(false);
		rigging_textField_2.setColumns(10);
		rigging_textField_2.setBounds(395, 152, 50, 19);
		contentPane.add(rigging_textField_2);

		rigging_textField_3 = new JTextField();
		rigging_textField_3.setText(Table.rigging.get(rigging_num).cru_dist);
		rigging_textField_3.setEditable(false);
		rigging_textField_3.setColumns(10);
		rigging_textField_3.setBounds(472, 152, 50, 19);
		contentPane.add(rigging_textField_3);

		rigging_textField_4 = new JTextField();
		rigging_textField_4.setText(Table.rigging.get(rigging_num).luck);
		rigging_textField_4.setEditable(false);
		rigging_textField_4.setColumns(10);
		rigging_textField_4.setBounds(555, 152, 50, 19);
		contentPane.add(rigging_textField_4);

		rigging_textField_5 = new JTextField();
		rigging_textField_5.setText(Table.rigging.get(rigging_num).repair);
		rigging_textField_5.setEditable(false);
		rigging_textField_5.setColumns(10);
		rigging_textField_5.setBounds(645, 152, 50, 19);
		contentPane.add(rigging_textField_5);

		rigging_textField_6 = new JTextField();
		rigging_textField_6.setText(Table.rigging.get(rigging_num).cost);
		rigging_textField_6.setEditable(false);
		rigging_textField_6.setColumns(10);
		rigging_textField_6.setBounds(733, 152, 50, 19);
		contentPane.add(rigging_textField_6);

		rigging_textField_7 = new JTextField();
		rigging_textField_7.setText(Table.rigging.get(rigging_num).rank);
		rigging_textField_7.setEditable(false);
		rigging_textField_7.setColumns(10);
		rigging_textField_7.setBounds(817, 151, 50, 19);
		contentPane.add(rigging_textField_7);

		stern_textField = new JTextField();
		stern_textField.setText(Table.stern.get(stern_num).exp_perf);
		stern_textField.setEditable(false);
		stern_textField.setColumns(10);
		stern_textField.setBounds(237, 175, 50, 19);
		contentPane.add(stern_textField);

		stern_textField_1 = new JTextField();
		stern_textField_1.setText(Table.stern.get(stern_num).coll_perf);
		stern_textField_1.setEditable(false);
		stern_textField_1.setColumns(10);
		stern_textField_1.setBounds(313, 175, 50, 19);
		contentPane.add(stern_textField_1);

		stern_textField_2 = new JTextField();
		stern_textField_2.setText(Table.stern.get(stern_num).cru_perf);
		stern_textField_2.setEditable(false);
		stern_textField_2.setColumns(10);
		stern_textField_2.setBounds(395, 175, 50, 19);
		contentPane.add(stern_textField_2);

		stern_textField_3 = new JTextField();
		stern_textField_3.setText(Table.stern.get(stern_num).cru_dist);
		stern_textField_3.setEditable(false);
		stern_textField_3.setColumns(10);
		stern_textField_3.setBounds(472, 175, 50, 19);
		contentPane.add(stern_textField_3);

		stern_textField_4 = new JTextField();
		stern_textField_4.setText(Table.stern.get(stern_num).luck);
		stern_textField_4.setEditable(false);
		stern_textField_4.setColumns(10);
		stern_textField_4.setBounds(555, 175, 50, 19);
		contentPane.add(stern_textField_4);

		stern_textField_5 = new JTextField();
		stern_textField_5.setText(Table.stern.get(stern_num).repair);
		stern_textField_5.setEditable(false);
		stern_textField_5.setColumns(10);
		stern_textField_5.setBounds(645, 175, 50, 19);
		contentPane.add(stern_textField_5);

		stern_textField_6 = new JTextField();
		stern_textField_6.setText(Table.stern.get(stern_num).cost);
		stern_textField_6.setEditable(false);
		stern_textField_6.setColumns(10);
		stern_textField_6.setBounds(733, 175, 50, 19);
		contentPane.add(stern_textField_6);

		stern_textField_7 = new JTextField();
		stern_textField_7.setText(Table.stern.get(stern_num).rank);
		stern_textField_7.setEditable(false);
		stern_textField_7.setColumns(10);
		stern_textField_7.setBounds(817, 174, 50, 19);
		contentPane.add(stern_textField_7);

		sum_textField = new JTextField();
		sum_textField.setText((String) null);
		sum_textField.setEditable(false);
		sum_textField.setColumns(10);
		sum_textField.setBounds(237, 204, 50, 19);
		contentPane.add(sum_textField);

		sum_textField_1 = new JTextField();
		sum_textField_1.setText((String) null);
		sum_textField_1.setEditable(false);
		sum_textField_1.setColumns(10);
		sum_textField_1.setBounds(313, 204, 50, 19);
		contentPane.add(sum_textField_1);

		sum_textField_2 = new JTextField();
		sum_textField_2.setText((String) null);
		sum_textField_2.setEditable(false);
		sum_textField_2.setColumns(10);
		sum_textField_2.setBounds(395, 204, 50, 19);
		contentPane.add(sum_textField_2);

		sum_textField_3 = new JTextField();
		sum_textField_3.setText((String) null);
		sum_textField_3.setEditable(false);
		sum_textField_3.setColumns(10);
		sum_textField_3.setBounds(472, 204, 50, 19);
		contentPane.add(sum_textField_3);

		sum_textField_4 = new JTextField();
		sum_textField_4.setText((String) null);
		sum_textField_4.setEditable(false);
		sum_textField_4.setColumns(10);
		sum_textField_4.setBounds(555, 204, 50, 19);
		contentPane.add(sum_textField_4);

		sum_textField_5 = new JTextField();
		sum_textField_5.setText((String) null);
		sum_textField_5.setEditable(false);
		sum_textField_5.setColumns(10);
		sum_textField_5.setBounds(645, 204, 50, 19);
		contentPane.add(sum_textField_5);

		sum_textField_6 = new JTextField();
		sum_textField_6.setText((String) null);
		sum_textField_6.setEditable(false);
		sum_textField_6.setColumns(10);
		sum_textField_6.setBounds(733, 204, 50, 19);
		contentPane.add(sum_textField_6);

		JLabel label_14 = new JLabel("合計");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setBounds(169, 207, 50, 13);
		contentPane.add(label_14);

		label_15 = new JLabel("/");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setBounds(785, 207, 16, 13);
		contentPane.add(label_15);

		cap_textField = new JTextField();
		cap_textField.setText((String) null);
		cap_textField.setEditable(false);
		cap_textField.setColumns(10);
		cap_textField.setBounds(801, 204, 50, 19);
		contentPane.add(cap_textField);


	}

	public void actionPerformed(ActionEvent e){
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("bow_list")){
			int index = comboBox.getSelectedIndex();
			bow_textField.setText(Table.bow.get(index).exp_perf);
			bow_textField_1.setText(Table.bow.get(index).coll_perf);
			bow_textField_2.setText(Table.bow.get(index).cru_perf);
			bow_textField_3.setText(Table.bow.get(index).cru_dist);
			bow_textField_4.setText(Table.bow.get(index).luck);
			bow_textField_5.setText(Table.bow.get(index).repair);
			bow_textField_6.setText(Table.bow.get(index).cost);
			bow_textField_7.setText(Table.bow.get(index).rank);
		} else if (actionCommand.equals("hull_list")){
			int index = comboBox_1.getSelectedIndex();
			hull_textField.setText(Table.hull.get(index).exp_perf);
			hull_textField_1.setText(Table.hull.get(index).coll_perf);
			hull_textField_2.setText(Table.hull.get(index).cru_perf);
			hull_textField_3.setText(Table.hull.get(index).cru_dist);
			hull_textField_4.setText(Table.hull.get(index).luck);
			hull_textField_5.setText(Table.hull.get(index).repair);
			hull_textField_6.setText(Table.hull.get(index).cost);
			hull_textField_7.setText(Table.hull.get(index).rank);
		} else if (actionCommand.equals("rigging_list")){
			int index = comboBox_2.getSelectedIndex();
			rigging_textField.setText(Table.rigging.get(index).exp_perf);
			rigging_textField_1.setText(Table.rigging.get(index).coll_perf);
			rigging_textField_2.setText(Table.rigging.get(index).cru_perf);
			rigging_textField_3.setText(Table.rigging.get(index).cru_dist);
			rigging_textField_4.setText(Table.rigging.get(index).luck);
			rigging_textField_5.setText(Table.rigging.get(index).repair);
			rigging_textField_6.setText(Table.rigging.get(index).cost);
			rigging_textField_7.setText(Table.rigging.get(index).rank);
		} else if (actionCommand.equals("stern_list")){
			int index = comboBox_3.getSelectedIndex();
			stern_textField.setText(Table.stern.get(index).exp_perf);
			stern_textField_1.setText(Table.stern.get(index).coll_perf);
			stern_textField_2.setText(Table.stern.get(index).cru_perf);
			stern_textField_3.setText(Table.stern.get(index).cru_dist);
			stern_textField_4.setText(Table.stern.get(index).luck);
			stern_textField_5.setText(Table.stern.get(index).repair);
			stern_textField_6.setText(Table.stern.get(index).cost);
			stern_textField_7.setText(Table.stern.get(index).rank);
		}


		Parts sum = new Parts(null, null, null, null, null, null, null, null, null);;
		sum.exp_perf = String.valueOf(Integer.parseInt(bow_textField.getText()) + Integer.parseInt(hull_textField.getText()) +
				Integer.parseInt(rigging_textField.getText()) + Integer.parseInt(stern_textField.getText()));
		sum.coll_perf = String.valueOf(Integer.parseInt(bow_textField_1.getText()) + Integer.parseInt(hull_textField_1.getText()) +
				Integer.parseInt(rigging_textField_1.getText()) + Integer.parseInt(stern_textField_1.getText()));
		sum.cru_perf = String.valueOf(Integer.parseInt(bow_textField_2.getText()) + Integer.parseInt(hull_textField_2.getText()) +
				Integer.parseInt(rigging_textField_2.getText()) + Integer.parseInt(stern_textField_2.getText()));
		sum.cru_dist = String.valueOf(Integer.parseInt(bow_textField_3.getText()) + Integer.parseInt(hull_textField_3.getText()) +
				Integer.parseInt(rigging_textField_3.getText()) + Integer.parseInt(stern_textField_3.getText()));
		sum.luck = String.valueOf(Integer.parseInt(bow_textField_4.getText()) + Integer.parseInt(hull_textField_4.getText()) +
				Integer.parseInt(rigging_textField_4.getText()) + Integer.parseInt(stern_textField_4.getText()));
		sum.repair = String.valueOf(Integer.parseInt(bow_textField_5.getText()) + Integer.parseInt(hull_textField_5.getText()) +
				Integer.parseInt(rigging_textField_5.getText()) + Integer.parseInt(stern_textField_5.getText()));
		sum.cost = String.valueOf(Integer.parseInt(bow_textField_6.getText()) + Integer.parseInt(hull_textField_6.getText()) +
				Integer.parseInt(rigging_textField_6.getText()) + Integer.parseInt(stern_textField_6.getText()));

		sum_textField.setText(sum.exp_perf);
		sum_textField_1.setText(sum.coll_perf);
		sum_textField_2.setText(sum.cru_perf);
		sum_textField_3.setText(sum.cru_dist);
		sum_textField_4.setText(sum.luck);
		sum_textField_5.setText(sum.repair);
		sum_textField_6.setText(sum.cost);
	}
	public void stateChanged(ChangeEvent e) {
		String cap =String.valueOf((Integer)spinner.getValue() + 11);
		cap_textField.setText(cap);
	}
}