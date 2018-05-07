package GuiaFinanceiro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;

import java.awt.Choice;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class GuiaFinanceiroGUI {
	
	private JSONReader reader; 
	private JSONWriter writer;
	private JSONWriter writerPrices;
	private JFrame frmGuiaFinanceiro;
	private JTextField textFieldRazao;
	private JTextField textFieldCNPJ;
	private JTextField textFieldInscMunicipal;
	private JTextField textFieldEndereco;
	private JTextField textFieldComplemento;
	private JTextField textFieldNumero;
	private JTextField textFieldBairro;
	private JTextField textFieldMunicipio;
	private JTextField textFieldUF;
	private JTextField textFieldCEP;
	private JTextField textFieldRepLegal;
	private JTextField textFieldCPF;
	private JTextField textFieldRG;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefone;
	private JTextField textFieldFantasia;
	private JTextField textFieldParcelasImpresso;
	private JTextField textFieldParcelasBlog;
	private JTextField textFieldParcelasWeb;
	private JTextField textFieldParcelasApp;
	private JTextField textFieldValorParcelaImpresso;
	private JTextField textFieldValorParcelaBlog;
	private JTextField textFieldValorParcelaWeb;
	private JTextField textFieldValorParcelaApp;
	private JTextField textFieldValorTotalImpresso;
	private JTextField textFieldValorTotalBlog;
	private JTextField textFieldValorTotalWeb;
	private JTextField textFieldValorTotalApp;
	private JTextField textFieldBuscar;
	private JTable tableAnunciantes;
	private Choice choiceImpresso;
	private Choice choiceBlog;
	private Choice choiceWeb;
	private Choice choiceApp;
	
	private JFormattedTextField formattedTextFieldDiaPagamentoImpresso;
	private JFormattedTextField formattedTextFieldDiaPagamentoBlog;
	private JFormattedTextField formattedTextFieldDiaPagamentoWeb;
	private JFormattedTextField formattedTextFieldDiaPagamentoApp;
	
	private JFormattedTextField formattedTextFieldVinculoImpresso;
	private JFormattedTextField formattedTextFieldVinculoBlog;
	private JFormattedTextField formattedTextFieldVinculoWeb;
	private JFormattedTextField formattedTextFieldVinculoApp;
	
	private JCheckBox checkBoxImpresso;
	private JCheckBox checkBoxBlog;
	private JCheckBox checkBoxWeb;
	private JCheckBox checkBoxApp;
	private JTable tableIEspacos;
	private JTextField textFieldNomeEspaco;
	private JTextField textFieldValorEspaco;
	private Choice choiceMidiaEspaco;
	
	DefaultTableModel tableModelImpresso;
	DefaultTableModel tableModel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiaFinanceiroGUI window = new GuiaFinanceiroGUI();
					window.frmGuiaFinanceiro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GuiaFinanceiroGUI(){
		reader = new JSONReader();
		writer = new JSONWriter(reader.readFile("C:\\Users\\guianatal\\Desktop\\Guia Financeiro Dev\\GuiaFinanceiro\\src\\GuiaFinanceiro\\test.json"));
		writerPrices = new JSONWriter(reader.readFile("C:\\Users\\guianatal\\Desktop\\Guia Financeiro Dev\\GuiaFinanceiro\\src\\GuiaFinanceiro\\ValoresDosEspacos.json"));
		initialize();
	}
	
	
	private void initialize(){
			
		
		//Inicializando a Janela---------------------------------
		
		frmGuiaFinanceiro = new JFrame();
		frmGuiaFinanceiro.setBackground(Color.WHITE);
		frmGuiaFinanceiro.setTitle("Guia Financeiro");
		frmGuiaFinanceiro.setBounds(100, 100, 900, 600);
		frmGuiaFinanceiro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuiaFinanceiro.setResizable(false);
		frmGuiaFinanceiro.getContentPane().setLayout(null);
		
		//Inicializando os Paineis--------------------------------
		
		JPanel Menus = new JPanel();
		Menus.setBackground(Color.LIGHT_GRAY);
		Menus.setBounds(0, 0, 160, 571);
		frmGuiaFinanceiro.getContentPane().add(Menus);
		Menus.setLayout(null);
		
		JPanel Janelas = new JPanel();
		Janelas.setBounds(160, 0, 734, 571);
		frmGuiaFinanceiro.getContentPane().add(Janelas);
		Janelas.setLayout(new CardLayout(0, 0));
		
		JLayeredPane layeredPane = new JLayeredPane();
		Janelas.add(layeredPane, "name_522294532077461");
		
		JPanel Home = new JPanel();
		Home.setBounds(0, 0, 734, 571);
		layeredPane.add(Home);
		Home.setLayout(null);
		
		JPanel cadastrarNovo = new JPanel();
		layeredPane.setLayer(cadastrarNovo, 1);
		cadastrarNovo.setBounds(0, 0, 734, 571);
		layeredPane.add(cadastrarNovo);
		cadastrarNovo.setLayout(null);
		
		JPanel Listagem = new JPanel();
		layeredPane.setLayer(Listagem, 0);
		Listagem.setLayout(null);
		Listagem.setBounds(0, 0, 734, 571);
		layeredPane.add(Listagem);
		
		//Inicializando os Elementos do Painel Home---------------
		
		JLabel lblHome = new JLabel("HOME!!!!!!!!!!!");
		lblHome.setBounds(69, 49, 46, 14);
		Home.add(lblHome);
		
		//Inicializando os Elementos do Painel Novo Anunciante----
		
		JLabel lblAnunciante = new JLabel("Adicionar Anunciante");
		lblAnunciante.setBounds(10, 10, 160, 25);
		cadastrarNovo.add(lblAnunciante);
		
		JLabel labelRazaoSocial = new JLabel("Raz\u00E3o Social:");
		labelRazaoSocial.setBounds(20, 50, 80, 20);
		cadastrarNovo.add(labelRazaoSocial);
		
		JLabel labelCNPJ = new JLabel("CNPJ:");
		labelCNPJ.setBounds(300, 50, 50, 20);
		cadastrarNovo.add(labelCNPJ);
		
		JLabel labelInscMunicipal = new JLabel("Insc. Municipal:");
		labelInscMunicipal.setBounds(20, 80, 95, 20);
		cadastrarNovo.add(labelInscMunicipal);
		
		JLabel labelEndereco = new JLabel("Endere\u00E7o:");
		labelEndereco.setBounds(20, 120, 65, 20);
		cadastrarNovo.add(labelEndereco);
		
		JLabel labelBairro = new JLabel("Bairro:");
		labelBairro.setBounds(20, 150, 65, 20);
		cadastrarNovo.add(labelBairro);
		
		JLabel labelNumero = new JLabel("Numero:");
		labelNumero.setBounds(510, 120, 65, 20);
		cadastrarNovo.add(labelNumero);
		
		JLabel labelCEP = new JLabel("CEP:");
		labelCEP.setBounds(520, 150, 50, 20);
		cadastrarNovo.add(labelCEP);
		
		JLabel labelMunicipio = new JLabel("Munic\u00EDpio:");
		labelMunicipio.setBounds(230, 150, 65, 20);
		cadastrarNovo.add(labelMunicipio);
		
		JLabel labelUF = new JLabel("UF:");
		labelUF.setBounds(445, 151, 30, 20);
		cadastrarNovo.add(labelUF);
		
		JLabel labelFantasia = new JLabel("Fantasia:");
		labelFantasia.setBounds(300, 81, 60, 20);
		cadastrarNovo.add(labelFantasia);
		
		JLabel labelTelefone = new JLabel("Telefone:");
		labelTelefone.setBounds(230, 221, 65, 20);
		cadastrarNovo.add(labelTelefone);
		
		JLabel labelEmail = new JLabel("E-mail:");
		labelEmail.setBounds(20, 220, 50, 20);
		cadastrarNovo.add(labelEmail);
		
		JLabel labelRespLegal = new JLabel("Representante Legal:");
		labelRespLegal.setBounds(20, 190, 130, 20);
		cadastrarNovo.add(labelRespLegal);
		
		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setBounds(335, 190, 35, 20);
		cadastrarNovo.add(labelCPF);
		
		JLabel labelRG = new JLabel("RG:");
		labelRG.setBounds(525, 190, 35, 20);
		cadastrarNovo.add(labelRG);
		
		JLabel labelComplemento = new JLabel("Complemento:");
		labelComplemento.setBounds(250, 120, 90, 20);
		cadastrarNovo.add(labelComplemento);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 36, 734, 2);
		cadastrarNovo.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 110, 734, 2);
		cadastrarNovo.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 180, 734, 2);
		cadastrarNovo.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 250, 734, 2);
		cadastrarNovo.add(separator_3);
		
		textFieldRazao = new JTextField();
		textFieldRazao.setBounds(130, 50, 150, 20);
		cadastrarNovo.add(textFieldRazao);
		textFieldRazao.setColumns(10);
		
		textFieldCNPJ = new JTextField();
		textFieldCNPJ.setColumns(10);
		textFieldCNPJ.setBounds(360, 50, 130, 20);
		cadastrarNovo.add(textFieldCNPJ);
		
		textFieldInscMunicipal = new JTextField();
		textFieldInscMunicipal.setColumns(10);
		textFieldInscMunicipal.setBounds(130, 80, 150, 20);
		cadastrarNovo.add(textFieldInscMunicipal);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(90, 120, 150, 20);
		cadastrarNovo.add(textFieldEndereco);
		
		textFieldComplemento = new JTextField();
		textFieldComplemento.setColumns(10);
		textFieldComplemento.setBounds(350, 120, 150, 20);
		cadastrarNovo.add(textFieldComplemento);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(570, 120, 130, 20);
		cadastrarNovo.add(textFieldNumero);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(90, 150, 130, 20);
		cadastrarNovo.add(textFieldBairro);
		
		textFieldMunicipio = new JTextField();
		textFieldMunicipio.setColumns(10);
		textFieldMunicipio.setBounds(300, 150, 130, 20);
		cadastrarNovo.add(textFieldMunicipio);
		
		textFieldUF = new JTextField();
		textFieldUF.setColumns(10);
		textFieldUF.setBounds(475, 151, 35, 20);
		cadastrarNovo.add(textFieldUF);
		
		textFieldCEP = new JTextField();
		textFieldCEP.setColumns(10);
		textFieldCEP.setBounds(570, 151, 130, 20);
		cadastrarNovo.add(textFieldCEP);
		
		textFieldRepLegal = new JTextField();
		textFieldRepLegal.setColumns(10);
		textFieldRepLegal.setBounds(160, 190, 165, 20);
		cadastrarNovo.add(textFieldRepLegal);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(380, 190, 130, 20);
		cadastrarNovo.add(textFieldCPF);
		
		textFieldRG = new JTextField();
		textFieldRG.setColumns(10);
		textFieldRG.setBounds(570, 190, 130, 20);
		cadastrarNovo.add(textFieldRG);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(70, 220, 150, 20);
		cadastrarNovo.add(textFieldEmail);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(300, 220, 130, 20);
		cadastrarNovo.add(textFieldTelefone);
		
		textFieldFantasia = new JTextField();
		textFieldFantasia.setColumns(10);
		textFieldFantasia.setBounds(360, 80, 130, 20);
		cadastrarNovo.add(textFieldFantasia);
		
		choiceImpresso = new Choice();
		choiceImpresso.setEnabled(false);
		choiceImpresso.setBounds(100, 290, 90, 20);
		cadastrarNovo.add(choiceImpresso);
		
		choiceBlog = new Choice();
		choiceBlog.setEnabled(false);
		choiceBlog.setBounds(100, 320, 90, 20);
		cadastrarNovo.add(choiceBlog);
		
		choiceWeb = new Choice();
		choiceWeb.setEnabled(false);
		choiceWeb.setBounds(100, 350, 90, 20);
		cadastrarNovo.add(choiceWeb);
		
		choiceApp = new Choice();
		choiceApp.setEnabled(false);
		choiceApp.setBounds(100, 380, 90, 20);
		cadastrarNovo.add(choiceApp);
		
		addChoiceValues();
		
		JLabel labelMidias = new JLabel("M\u00EDdias");
		labelMidias.setBounds(20, 260, 50, 25);
		cadastrarNovo.add(labelMidias);
		
		JLabel labelEspaco = new JLabel("Espa\u00E7o");
		labelEspaco.setBounds(100, 260, 50, 25);
		cadastrarNovo.add(labelEspaco);
		
		JLabel labelInicioVinculo = new JLabel("Inicio do Vinculo ");
		labelInicioVinculo.setBounds(220, 260, 100, 25);
		cadastrarNovo.add(labelInicioVinculo);
		
		JLabel labelParcelas = new JLabel("Parcelas");
		labelParcelas.setBounds(440, 260, 60, 25);
		cadastrarNovo.add(labelParcelas);
		
		JLabel labelParcelaValor = new JLabel("Valor da Parcela");
		labelParcelaValor.setBounds(510, 260, 95, 25);
		cadastrarNovo.add(labelParcelaValor);
		
		JLabel labelValorTotal = new JLabel("Valor Total");
		labelValorTotal.setBounds(630, 260, 80, 25);
		cadastrarNovo.add(labelValorTotal);
		
		textFieldParcelasImpresso = new JTextField();
		textFieldParcelasImpresso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String imput = textFieldParcelasImpresso.getText();
				try {
					
					double parcelas = Double.parseDouble(imput);
					calcularOsPreços("Impresso", parcelas);
				}catch(Exception e)
				{
					//Não deu pra converter
				}
			}
		});
		textFieldParcelasImpresso.setEnabled(false);
		textFieldParcelasImpresso.setColumns(10);
		textFieldParcelasImpresso.setBounds(440, 290, 40, 20);
		cadastrarNovo.add(textFieldParcelasImpresso);
		
		textFieldParcelasBlog = new JTextField();
		textFieldParcelasBlog.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String imput = textFieldParcelasBlog.getText();
				try {
					
					double parcelas = Double.parseDouble(imput);
					calcularOsPreços("Blog", parcelas);
				}catch(Exception e1)
				{
					//Não deu pra converter
				}
			}
		});
		textFieldParcelasBlog.setEnabled(false);
		textFieldParcelasBlog.setColumns(10);
		textFieldParcelasBlog.setBounds(440, 320, 40, 20);
		cadastrarNovo.add(textFieldParcelasBlog);
		
		textFieldParcelasWeb = new JTextField();
		textFieldParcelasWeb.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String imput = textFieldParcelasWeb.getText();
				try {
					
					double parcelas = Double.parseDouble(imput);
					calcularOsPreços("Web", parcelas);
				}catch(Exception e2)
				{
					//Não deu pra converter
				}
			}
		});
		textFieldParcelasWeb.setEnabled(false);
		textFieldParcelasWeb.setColumns(10);
		textFieldParcelasWeb.setBounds(440, 350, 40, 20);
		cadastrarNovo.add(textFieldParcelasWeb);
		
		textFieldParcelasApp = new JTextField();
		textFieldParcelasApp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String imput = textFieldParcelasApp.getText();
				try {
					
					double parcelas = Double.parseDouble(imput);
					calcularOsPreços("App", parcelas);
				}catch(Exception e3)
				{
					//Não deu pra converter
				}
			}
		});
		textFieldParcelasApp.setEnabled(false);
		textFieldParcelasApp.setColumns(10);
		textFieldParcelasApp.setBounds(440, 380, 40, 20);
		cadastrarNovo.add(textFieldParcelasApp);
		
		// Impresso CheckBox****************************************
				checkBoxImpresso = new JCheckBox("Impresso");
				checkBoxImpresso.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if(checkBoxImpresso.isSelected())
						{
							choiceImpresso.setEnabled(true);
							textFieldParcelasImpresso.setEnabled(true);
							formattedTextFieldDiaPagamentoImpresso.setEnabled(true);
							formattedTextFieldVinculoImpresso.setEnabled(true);
						}
						else
						{
							choiceImpresso.setEnabled(false);
							textFieldParcelasImpresso.setEnabled(false);
							formattedTextFieldDiaPagamentoImpresso.setEnabled(false);
							formattedTextFieldVinculoImpresso.setEnabled(false);
							clearFields("Impresso");
						}
					}
				});
				checkBoxImpresso.setBounds(10, 290, 90, 20);
				cadastrarNovo.add(checkBoxImpresso);
		// Blog CheckBox********************************************		
				checkBoxBlog = new JCheckBox("Blog");
				checkBoxBlog.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if(checkBoxBlog.isSelected())
						{
							choiceBlog.setEnabled(true);
							textFieldParcelasBlog.setEnabled(true);
							formattedTextFieldDiaPagamentoBlog.setEnabled(true);
							formattedTextFieldVinculoBlog.setEnabled(true);
						}
						else
						{
							choiceBlog.setEnabled(false);
							textFieldParcelasBlog.setEnabled(false);
							formattedTextFieldDiaPagamentoBlog.setEnabled(false);
							formattedTextFieldVinculoBlog.setEnabled(false);
							clearFields("Blog");
						}
					}
				});
				checkBoxBlog.setBounds(10, 320, 75, 20);
				cadastrarNovo.add(checkBoxBlog);
		// Web CheckBox*********************************************
				checkBoxWeb = new JCheckBox("Web");
				checkBoxWeb.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if(checkBoxWeb.isSelected())
						{
							choiceWeb.setEnabled(true);
							textFieldParcelasWeb.setEnabled(true);
							formattedTextFieldDiaPagamentoWeb.setEnabled(true);
							formattedTextFieldVinculoWeb.setEnabled(true);
						}
						else
						{
							choiceWeb.setEnabled(false);
							textFieldParcelasWeb.setEnabled(false);
							formattedTextFieldDiaPagamentoWeb.setEnabled(false);
							formattedTextFieldVinculoWeb.setEnabled(false);
							clearFields("Web");
						}
					}
				});
				checkBoxWeb.setBounds(10, 350, 75, 20);
				cadastrarNovo.add(checkBoxWeb);
		// App CheckBox*********************************************
				checkBoxApp = new JCheckBox("App");
				checkBoxApp.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if(checkBoxApp.isSelected())
						{
							choiceApp.setEnabled(true);
							textFieldParcelasApp.setEnabled(true);
							formattedTextFieldDiaPagamentoApp.setEnabled(true);
							formattedTextFieldVinculoApp.setEnabled(true);
						}
						else
						{
							choiceApp.setEnabled(false);
							textFieldParcelasApp.setEnabled(false);
							formattedTextFieldDiaPagamentoApp.setEnabled(false);
							formattedTextFieldVinculoApp.setEnabled(false);
							clearFields("App");
						}
					}
				});
				checkBoxApp.setBounds(10, 380, 75, 20);
				cadastrarNovo.add(checkBoxApp);
				
		textFieldValorParcelaImpresso = new JTextField();
		textFieldValorParcelaImpresso.setEditable(false);
		textFieldValorParcelaImpresso.setColumns(10);
		textFieldValorParcelaImpresso.setBounds(510, 290, 80, 20);
		textFieldValorParcelaImpresso.setHorizontalAlignment(SwingConstants.RIGHT);
		cadastrarNovo.add(textFieldValorParcelaImpresso);
		
		textFieldValorParcelaBlog = new JTextField();
		textFieldValorParcelaBlog.setEditable(false);
		textFieldValorParcelaBlog.setColumns(10);
		textFieldValorParcelaBlog.setBounds(510, 320, 80, 20);
		textFieldValorParcelaBlog.setHorizontalAlignment(SwingConstants.RIGHT);
		cadastrarNovo.add(textFieldValorParcelaBlog);
		
		textFieldValorParcelaWeb = new JTextField();
		textFieldValorParcelaWeb.setEditable(false);
		textFieldValorParcelaWeb.setColumns(10);
		textFieldValorParcelaWeb.setBounds(510, 350, 80, 20);
		textFieldValorParcelaWeb.setHorizontalAlignment(SwingConstants.RIGHT);
		cadastrarNovo.add(textFieldValorParcelaWeb);
		
		textFieldValorParcelaApp = new JTextField();
		textFieldValorParcelaApp.setEditable(false);
		textFieldValorParcelaApp.setColumns(10);
		textFieldValorParcelaApp.setBounds(510, 380, 80, 20);
		textFieldValorParcelaApp.setHorizontalAlignment(SwingConstants.RIGHT);
		cadastrarNovo.add(textFieldValorParcelaApp);
		
		textFieldValorTotalImpresso = new JTextField();
		textFieldValorTotalImpresso.setEditable(false);
		textFieldValorTotalImpresso.setColumns(10);
		textFieldValorTotalImpresso.setBounds(630, 290, 80, 20);
		textFieldValorTotalImpresso.setHorizontalAlignment(SwingConstants.RIGHT);
		cadastrarNovo.add(textFieldValorTotalImpresso);
		
		textFieldValorTotalBlog = new JTextField();
		textFieldValorTotalBlog.setEditable(false);
		textFieldValorTotalBlog.setColumns(10);
		textFieldValorTotalBlog.setBounds(630, 320, 80, 20);
		textFieldValorTotalBlog.setHorizontalAlignment(SwingConstants.RIGHT);
		cadastrarNovo.add(textFieldValorTotalBlog);
		
		textFieldValorTotalWeb = new JTextField();
		textFieldValorTotalWeb.setEditable(false);
		textFieldValorTotalWeb.setColumns(10);
		textFieldValorTotalWeb.setBounds(630, 350, 80, 20);
		textFieldValorTotalWeb.setHorizontalAlignment(SwingConstants.RIGHT);
		cadastrarNovo.add(textFieldValorTotalWeb);
		
		textFieldValorTotalApp = new JTextField();
		textFieldValorTotalApp.setEditable(false);
		textFieldValorTotalApp.setColumns(10);
		textFieldValorTotalApp.setBounds(630, 380, 80, 20);
		textFieldValorTotalApp.setHorizontalAlignment(SwingConstants.RIGHT);
		cadastrarNovo.add(textFieldValorTotalApp);
		
		// Botão salvar edição de Anunciante
		JButton btnSalvarEdit = new JButton("Salvar");
		btnSalvarEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarAnunciante();
				refreshTableAnunciante();
				Listagem.setVisible(true);
				Home.setVisible(false);
				cadastrarNovo.setVisible(false);
			}
		});
		btnSalvarEdit.setVisible(false);
		
		//Botão Salvar Infos*************************************
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarAnunciante(criarAnunciante());
				refreshTableAnunciante();
			}
		});
		btnSalvar.setBounds(640, 535, 80, 25);
		cadastrarNovo.add(btnSalvar);
		btnSalvarEdit.setBounds(640, 535, 80, 25);
		cadastrarNovo.add(btnSalvarEdit);
		
		MaskFormatter mascaraData = null;
		
		try {
			mascaraData = new MaskFormatter("##/##/####");
			mascaraData.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			//A geração das mascaras de formatação deu errado!!!
			e1.printStackTrace();
		}
		
		formattedTextFieldDiaPagamentoImpresso = new JFormattedTextField(mascaraData);
		formattedTextFieldDiaPagamentoImpresso.setBounds(335, 290, 70, 20);
		formattedTextFieldDiaPagamentoImpresso.setColumns(10);
		formattedTextFieldDiaPagamentoImpresso.setHorizontalAlignment(SwingConstants.RIGHT);
		formattedTextFieldDiaPagamentoImpresso.setEnabled(false);
		cadastrarNovo.add(formattedTextFieldDiaPagamentoImpresso);
		
		formattedTextFieldDiaPagamentoBlog = new JFormattedTextField(mascaraData);
		formattedTextFieldDiaPagamentoBlog.setBounds(335, 320, 70, 20);
		formattedTextFieldDiaPagamentoBlog.setColumns(10);
		formattedTextFieldDiaPagamentoBlog.setHorizontalAlignment(SwingConstants.RIGHT);
		formattedTextFieldDiaPagamentoBlog.setEnabled(false);
		cadastrarNovo.add(formattedTextFieldDiaPagamentoBlog);
		
		formattedTextFieldDiaPagamentoWeb = new JFormattedTextField(mascaraData);
		formattedTextFieldDiaPagamentoWeb.setHorizontalAlignment(SwingConstants.RIGHT);
		formattedTextFieldDiaPagamentoWeb.setColumns(10);
		formattedTextFieldDiaPagamentoWeb.setBounds(335, 350, 70, 20);
		formattedTextFieldDiaPagamentoWeb.setEnabled(false);
		cadastrarNovo.add(formattedTextFieldDiaPagamentoWeb);
		
		formattedTextFieldDiaPagamentoApp = new JFormattedTextField(mascaraData);
		formattedTextFieldDiaPagamentoApp.setHorizontalAlignment(SwingConstants.RIGHT);
		formattedTextFieldDiaPagamentoApp.setColumns(10);
		formattedTextFieldDiaPagamentoApp.setBounds(335, 380, 70, 20);
		formattedTextFieldDiaPagamentoApp.setEnabled(false);
		cadastrarNovo.add(formattedTextFieldDiaPagamentoApp);
		
		JLabel labelDiaPagamento = new JLabel("Dia do Pgmto");
		labelDiaPagamento.setBounds(335, 260, 90, 25);
		cadastrarNovo.add(labelDiaPagamento);
		
		formattedTextFieldVinculoImpresso = new JFormattedTextField(mascaraData);
		formattedTextFieldVinculoImpresso.setHorizontalAlignment(SwingConstants.RIGHT);
		formattedTextFieldVinculoImpresso.setColumns(10);
		formattedTextFieldVinculoImpresso.setBounds(220, 290, 70, 20);
		formattedTextFieldVinculoImpresso.setEnabled(false);
		cadastrarNovo.add(formattedTextFieldVinculoImpresso);
		
		formattedTextFieldVinculoBlog = new JFormattedTextField(mascaraData);
		formattedTextFieldVinculoBlog.setHorizontalAlignment(SwingConstants.RIGHT);
		formattedTextFieldVinculoBlog.setColumns(10);
		formattedTextFieldVinculoBlog.setBounds(220, 320, 70, 20);
		formattedTextFieldVinculoBlog.setEnabled(false);
		cadastrarNovo.add(formattedTextFieldVinculoBlog);
		
		formattedTextFieldVinculoWeb = new JFormattedTextField(mascaraData);
		formattedTextFieldVinculoWeb.setHorizontalAlignment(SwingConstants.RIGHT);
		formattedTextFieldVinculoWeb.setColumns(10);
		formattedTextFieldVinculoWeb.setBounds(220, 350, 70, 20);
		formattedTextFieldVinculoWeb.setEnabled(false);
		cadastrarNovo.add(formattedTextFieldVinculoWeb);
		
		formattedTextFieldVinculoApp = new JFormattedTextField(mascaraData);
		formattedTextFieldVinculoApp.setHorizontalAlignment(SwingConstants.RIGHT);
		formattedTextFieldVinculoApp.setColumns(10);
		formattedTextFieldVinculoApp.setBounds(220, 380, 70, 20);
		formattedTextFieldVinculoApp.setEnabled(false);
		cadastrarNovo.add(formattedTextFieldVinculoApp);
		
		//Incializando os Elementos do Painel Listagem------------
		
		// Campo Buscar*******************************************
		textFieldBuscar = new JTextField();
		textFieldBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if( arg0.getKeyCode() == KeyEvent.VK_ENTER && !textFieldBuscar.getText().equals("")) {
					String BuscaArg = textFieldBuscar.getText();
					textFieldBuscar.setText(null);
				}
					
			}
		});
		textFieldBuscar.setBounds(10, 70, 165, 20);
		Listagem.add(textFieldBuscar);
		textFieldBuscar.setColumns(10);
		
		Object[] colunas = {"Razão Social", "Fantasia", "Responsavel Legal"};
		tableAnunciantes = new JTable();
		tableAnunciantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAnunciantes.setBounds(10, 100, 714, 461);
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(colunas);
		tableAnunciantes.setModel(tableModel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 714, 461);
		scrollPane.add(tableAnunciantes);
		scrollPane.setViewportView(tableAnunciantes);
		Listagem.add(scrollPane);
		
		//Botão Editar anunciante*********************************
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = tableAnunciantes.getSelectedRow();
				String razao = (String) tableModel.getValueAt(index,0);
				setFields(findAnunciante(razao));
				lblAnunciante.setText("Editar Anunciante");
				cadastrarNovo.setVisible(true);
				btnSalvar.setVisible(false);
				btnSalvarEdit.setVisible(true);
				Home.setVisible(false);
				Listagem.setVisible(false);
				
			}
		});
		btnEditar.setBounds(534, 68, 90, 25);
		Listagem.add(btnEditar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tableAnunciantes.getSelectedRow();
				String razao = (String) tableModel.getValueAt(index,0);
				removerAnunciante(razao);
				tableModel.removeRow(index);
			}
		});
		btnRemover.setBounds(634, 68, 90, 25);
		Listagem.add(btnRemover);
		JPanel Espacos = new JPanel();
		layeredPane.setLayer(Espacos, 0);
		Espacos.setBounds(0, 0, 734, 571);
		layeredPane.add(Espacos);
		Espacos.setLayout(null);
		//Painel de Configurações dos espaços--------------------------------------------------------------------------------
		
		JLabel labelEspacos = new JLabel("Configurar Espa\u00E7os");
		labelEspacos.setBounds(10, 11, 160, 25);
		Espacos.add(labelEspacos);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 40, 734, 2);
		Espacos.add(separator_4);
		
		
		String[] colunasImpresso = {"Mídia", "Espaço", "Valor"};		
		tableIEspacos = new JTable();
		tableIEspacos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableIEspacos.setBounds(484, 32, 240, 321);
		tableModelImpresso = new DefaultTableModel();
		tableIEspacos.setModel(tableModelImpresso);
		tableModelImpresso.setColumnIdentifiers(colunasImpresso);
		
		JScrollPane scrollPaneEspacosImpresso = new JScrollPane();
		scrollPaneEspacosImpresso.setBounds(210, 146, 510, 404);
		scrollPaneEspacosImpresso.setViewportView(tableIEspacos);
		Espacos.add(scrollPaneEspacosImpresso);
		
		//Botão Salvar Espaço-----------------------------------------
				JButton buttonSalvarEspaco = new JButton("Salvar");
				buttonSalvarEspaco.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JSONObject novo = criarEspaco();
						adicionarEspaco(novo);
						tableModelImpresso.addRow(new Object[] {novo.get("Mídia"), novo.get("Nome"), novo.get("Valor")});
					}
				});
				buttonSalvarEspaco.setBounds(110, 146, 90, 25);
				Espacos.add(buttonSalvarEspaco);
				
				//Botão Salvar Edição de Espaço-------------------------------
				JButton buttonSalvarEdit = new JButton("Salvar");
				buttonSalvarEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int index = tableIEspacos.getSelectedRow();
						String midia = (String) tableModelImpresso.getValueAt(index, 0);
						String nome = (String) tableModelImpresso.getValueAt(index, 1);
						salvarEditEspaco(midia, nome);
						refreshTableEspaco();
						buttonSalvarEdit.setVisible(false);
						buttonSalvarEspaco.setVisible(true);
					}
				});
				buttonSalvarEdit.setBounds(110, 146, 90, 25);
				buttonSalvarEdit.setVisible(false);
				Espacos.add(buttonSalvarEdit);
		
		// Botão Editar Espaço----------------------------------------------------
		JButton buttonEditarEspaco = new JButton("Editar");
		buttonEditarEspaco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tableIEspacos.getSelectedRow();
				String midia = (String) tableModelImpresso.getValueAt(index, 0);
				String nome = (String) tableModelImpresso.getValueAt(index, 1);
				try {
					setFieldsEditarEspaco(findEspaco(midia, nome));
				}catch(Exception find) {}
				buttonSalvarEdit.setVisible(true);
				buttonSalvarEspaco.setVisible(false);
			}
		});
		buttonEditarEspaco.setBounds(530, 110, 90, 25);
		Espacos.add(buttonEditarEspaco);
		
		// Botão Remover Espaço----------------------------------------------------
		JButton buttonRemoverImpresso = new JButton("Remover");
		buttonRemoverImpresso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = tableIEspacos.getSelectedRow();
				String midia = (String) tableModelImpresso.getValueAt(index, 0);
				String nome = (String) tableModelImpresso.getValueAt(index, 1);
				try {
					deletarEspaco(findEspaco(midia, nome));
				}catch(Exception find) {}
				tableModelImpresso.removeRow(index);
				
			}
		});
		buttonRemoverImpresso.setBounds(630, 110, 90, 25);
		Espacos.add(buttonRemoverImpresso);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(10, 60, 50, 20);
		Espacos.add(labelNome);
		
		JLabel labelValorEspaco = new JLabel("Valor:");
		labelValorEspaco.setBounds(10, 90, 50, 20);
		Espacos.add(labelValorEspaco);
		
		JLabel labelMidiaDoEspaco = new JLabel("Midia Do Espa\u00E7o");
		labelMidiaDoEspaco.setBounds(10, 120, 97, 20);
		Espacos.add(labelMidiaDoEspaco);
		
		textFieldNomeEspaco = new JTextField();
		textFieldNomeEspaco.setColumns(10);
		textFieldNomeEspaco.setBounds(70, 60, 130, 20);
		Espacos.add(textFieldNomeEspaco);
		
		textFieldValorEspaco = new JTextField();
		textFieldValorEspaco.setColumns(10);
		textFieldValorEspaco.setBounds(70, 91, 130, 20);
		Espacos.add(textFieldValorEspaco);
		
		choiceMidiaEspaco = new Choice();
		choiceMidiaEspaco.setBounds(110, 120, 90, 20);
		choiceMidiaEspaco.add("");
		choiceMidiaEspaco.add("Impresso");
		choiceMidiaEspaco.add("Blog");
		choiceMidiaEspaco.add("Web");
		choiceMidiaEspaco.add("App");
		Espacos.add(choiceMidiaEspaco);
		
		//Inicializando os Elementos do Painel Menus---------------
		
				//Botão de navegação ---> NovoAnunciante******************
						JButton btnNewButton = new JButton("Novo");
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								lblAnunciante.setText("Adicionar Anunciante");
								clearFields();
								cadastrarNovo.setVisible(true);
								btnSalvar.setVisible(true);
								btnSalvarEdit.setVisible(false);
								Home.setVisible(false);
								Listagem.setVisible(false);
								Espacos.setVisible(false);
							}
						});
						btnNewButton.setBounds(10, 70, 90, 25);
						Menus.add(btnNewButton);
						
						//Botão de navegação ---> Home*****************************
						JButton btnHome = new JButton("Home");
						btnHome.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Home.setVisible(true);
								cadastrarNovo.setVisible(false);
								Listagem.setVisible(false);
								Espacos.setVisible(false);
							}
						});
						btnHome.setBounds(10, 35, 90, 25);
						Menus.add(btnHome);
						
						//Botão de navegação ---> Listar****************************
						JButton buttonListar = new JButton("Listar");
						buttonListar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Listagem.setVisible(true);
								Home.setVisible(false);
								cadastrarNovo.setVisible(false);
								Espacos.setVisible(false);
								refreshTableAnunciante();
							}
						});
						buttonListar.setBounds(10, 105, 90, 25);
						Menus.add(buttonListar);
						
						//Botão de navegaçao ---> Espaços***************************
						JButton buttonEspacos = new JButton("Espa\u00E7os");
						buttonEspacos.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Home.setVisible(false);
								cadastrarNovo.setVisible(false);
								Listagem.setVisible(false);
								Espacos.setVisible(true);
								refreshTableEspaco();
							}
						});
						buttonEspacos.setBounds(10, 141, 90, 25);
						Menus.add(buttonEspacos);
	}
	
	/**
	 * Metodo para criar Um espaço de midia
	 * @return Espaço: um JSONObject contendo as informaçoes do espaço (Valor, Mídia e Nome)
	 */
	@SuppressWarnings("unchecked")
	private JSONObject criarEspaco(){

		JSONObject Espaco = new JSONObject();

		Espaco.put("Mídia", choiceMidiaEspaco.getSelectedItem());
		Espaco.put("Nome", textFieldNomeEspaco.getText());
		Espaco.put("Valor", textFieldValorEspaco.getText());
		clearEspacoFields();
		return Espaco;
		
	}
	
	/**
	 * 
	 * @param Espaco: JSONObject contendo as informaçoes dos campos nome do espaço e Valor
	 */
	private void adicionarEspaco(JSONObject Espaco) {
		writerPrices.adicionarItem(Espaco);
		writerPrices.salvarDados("C:\\Users\\guianatal\\Desktop\\Guia Financeiro Dev\\GuiaFinanceiro\\src\\GuiaFinanceiro\\ValoresDosEspacos.json");
	}
	
	private JSONObject findEspaco(String midia, String nome)
	{
		for(int index = 0; index < writerPrices.getListaItems().size(); index++) {
			JSONObject item = (JSONObject) writerPrices.getListaItems().get(index);
			if(item.get("Nome").equals(nome) && item.get("Mídia").equals(midia)){
				return item;
			}
		}
		
		return null;
	}
	
	private void deletarEspaco(JSONObject Espaco) {
		writerPrices.getListaItems().remove(Espaco);
		writerPrices.salvarDados("C:\\Users\\guianatal\\Desktop\\Guia Financeiro Dev\\GuiaFinanceiro\\src\\GuiaFinanceiro\\ValoresDosEspacos.json");
	}
	
	/**
	 * Metodo para criar um JSONObject com as informaçoes dos campos
	 * @return  anunciante: JSONObject contendo as informaçoes dos campos
	 */
	@SuppressWarnings("unchecked")
	private JSONObject criarAnunciante()
	{
		JSONObject anunciante = new JSONObject();
		
		anunciante.put("RazaoSocial", (String)textFieldRazao.getText());
		anunciante.put("CNPJ", (String)textFieldCNPJ.getText());
		anunciante.put("InscMunicipal", (String)textFieldInscMunicipal.getText());
		anunciante.put("Fantasia", (String)textFieldFantasia.getText());
		
		anunciante.put("Endereco", (String)textFieldEndereco.getText());
		anunciante.put("Complemento", (String)textFieldComplemento.getText());
		anunciante.put("Numero", (String)textFieldNumero.getText());
		anunciante.put("Bairro", (String)textFieldBairro.getText());
		anunciante.put("Municipio", (String)textFieldMunicipio.getText());
		anunciante.put("UF", (String)textFieldUF.getText());
		anunciante.put("CEP", (String)textFieldCEP.getText());
		
		anunciante.put("RepLegal", (String)textFieldRepLegal.getText());
		anunciante.put("CPF", (String)textFieldCPF.getText());
		anunciante.put("RG", (String)textFieldRG.getText());
		anunciante.put("Email", (String)textFieldEmail.getText());
		anunciante.put("Telefone", (String)textFieldTelefone.getText());
		
		JSONArray planos = montarPlanos();
		
		anunciante.put("Planos", planos);
		
		clearFields();
		
		return anunciante;
	}
	/**
	 * Metodo para montar um JSONArray contendo todos os planos selecionados e suas respectivas informações
	 */
	@SuppressWarnings("unchecked")
	private JSONArray montarPlanos()
	{
		JSONArray planos = new JSONArray();
		
		if(checkBoxImpresso.isSelected()) {
			JSONObject impresso = new JSONObject();				
			
			impresso.put("Espaco", choiceImpresso.getSelectedItem());
			impresso.put("InicioDoVinculo", formattedTextFieldVinculoImpresso.getValue());
			impresso.put("DiaDoPagamento", formattedTextFieldDiaPagamentoImpresso.getValue());
			impresso.put("Parcelas", textFieldParcelasImpresso.getText());
			impresso.put("Tipo", "Impresso");
			planos.add(impresso);
			clearFields("Impresso");
		}
		if(checkBoxBlog.isSelected()) {
			JSONObject blog = new JSONObject();				
			
			blog.put("Espaco", choiceBlog.getSelectedItem());
			blog.put("InicioDoVinculo", formattedTextFieldVinculoBlog.getValue());
			blog.put("DiaDoPagamento", formattedTextFieldDiaPagamentoBlog.getValue());
			blog.put("Parcelas", textFieldParcelasBlog.getText());
			blog.put("Tipo", "Blog");
			planos.add(blog);
			
			clearFields("Blog");
		}
		if(checkBoxWeb.isSelected()) {
			JSONObject web = new JSONObject();				
			
			web.put("Espaco", choiceWeb.getSelectedItem());
			web.put("InicioDoVinculo", formattedTextFieldVinculoWeb.getValue());
			web.put("DiaDoPagamento", formattedTextFieldDiaPagamentoWeb.getValue());
			web.put("Parcelas", textFieldParcelasWeb.getText());
			web.put("Tipo", "Web");
			planos.add(web);
			clearFields("Web");
		}
		if(checkBoxApp.isSelected()) {
			JSONObject app = new JSONObject();				
			
			app.put("Espaco", choiceApp.getSelectedItem());
			app.put("InicioDoVinculo", formattedTextFieldVinculoApp.getValue());
			app.put("DiaDoPagamento", formattedTextFieldDiaPagamentoApp.getValue());
			app.put("Parcelas", textFieldParcelasApp.getText());
			app.put("Tipo", "App");
			planos.add(app);
			clearFields("App");
		}
		
		return planos;	
	}
	
	/**
	 * Metodo para adicionar um anunciante
	 * @param anunciante
	 */
	private void adicionarAnunciante(JSONObject anunciante)
	{
		writer.adicionarItem(anunciante);
		writer.salvarDados("C:\\Users\\guianatal\\Desktop\\Guia Financeiro Dev\\GuiaFinanceiro\\src\\GuiaFinanceiro\\test.json");
	}
	
	/**
	 * Metodo para salvar as alteraçoes realizadas em um anunciante
	 */
	@SuppressWarnings("unchecked")
	private void editarAnunciante() {
		for(int i = 0; i < writer.getListaItems().size(); i++) {
			JSONObject item = (JSONObject) writer.getListaItems().get(i);
			if(item.get("RazaoSocial").equals(textFieldRazao.getText()) || item.get("CNPJ").equals(textFieldCNPJ.getText())){
				writer.getListaItems().set(i, criarAnunciante());
			}
		}
		writer.salvarDados("C:\\Users\\guianatal\\Desktop\\Guia Financeiro Dev\\GuiaFinanceiro\\src\\GuiaFinanceiro\\test.json");
	}
		
	/**
	 * Metodo de busca simples para encontrar um anunciante utilizando a Razão Social como chave
	 * @param Razao: String contendo a razão social selecionada
	 * @return no sucesso-> item: JSONObject contendo as informaçoes da razão social selecionada 
	 * 		   no fracasso-> null
	 */
	private JSONObject findAnunciante(String Razao) {
		for(int i = 0; i < writer.getListaItems().size(); i++) {
			JSONObject item = (JSONObject) writer.getListaItems().get(i);
			String RS = (String) item.get("RazaoSocial");
			if(RS.equals(Razao)){
				return item;
			}
		}
		return null;
	}
	
	/**
	 * Limpa todos os campos da pagina de adicionar/editar anunciante
	 */
	private void clearFields() {
		textFieldRazao.setText("");
		textFieldCNPJ.setText("");
		textFieldInscMunicipal.setText("");
		textFieldEndereco.setText("");
		textFieldComplemento.setText("");
		textFieldNumero.setText("");
		textFieldBairro.setText("");
		textFieldMunicipio.setText("");
		textFieldUF.setText("");
		textFieldCEP.setText("");
		textFieldRepLegal.setText("");
		textFieldCPF.setText("");
		textFieldRG.setText("");
		textFieldEmail.setText("");
		textFieldTelefone.setText("");
		textFieldFantasia.setText("");
		
		textFieldValorParcelaImpresso.setText("");
		textFieldValorTotalImpresso.setText("");
		textFieldValorParcelaBlog.setText("");
		textFieldValorTotalBlog.setText("");
		textFieldValorParcelaWeb.setText("");
		textFieldValorTotalWeb.setText("");
		textFieldValorParcelaApp.setText("");
		textFieldValorTotalApp.setText("");
	}
		
	private void clearFields(String tipo)
	{
		if(tipo.equals("Impresso"))
		{
			textFieldValorParcelaImpresso.setText("");
			textFieldValorTotalImpresso.setText("");
			formattedTextFieldDiaPagamentoImpresso.setValue("");
			textFieldParcelasImpresso.setText("");
			formattedTextFieldVinculoImpresso.setValue("");
			choiceImpresso.select(0);
		}
		if(tipo.equals("Blog"))
		{
			textFieldValorParcelaBlog.setText("");
			textFieldValorTotalBlog.setText("");
			formattedTextFieldDiaPagamentoBlog.setValue("");
			textFieldParcelasBlog.setText("");
			formattedTextFieldVinculoBlog.setValue("");
			choiceBlog.select(0);
		}
		if(tipo.equals("Web"))
		{
			textFieldValorParcelaWeb.setText("");
			textFieldValorTotalWeb.setText("");
			formattedTextFieldDiaPagamentoWeb.setValue("");
			textFieldParcelasWeb.setText("");
			formattedTextFieldVinculoWeb.setValue("");
			choiceWeb.select(0);
		}
		if(tipo.equals("App"))
		{
			textFieldValorParcelaApp.setText("");
			textFieldValorTotalApp.setText("");
			formattedTextFieldDiaPagamentoApp.setValue("");
			textFieldParcelasApp.setText("");
			formattedTextFieldVinculoApp.setValue("");
			choiceApp.select(0);
		}
	}
	/**
	 * Seta todos os campos da pagina adicionar/editar para o item selecionado na pagina Listar
	 * @param item: JSONObject contendo as informaçoes do item selecionado
	 */
	private void setFields(JSONObject item) {

		textFieldRazao.setText((String) item.get("RazaoSocial"));
		textFieldCNPJ.setText((String) item.get("CNPJ"));
		textFieldInscMunicipal.setText((String) item.get("InscMunicipal"));
		textFieldEndereco.setText((String) item.get("Endereco"));
		textFieldComplemento.setText((String) item.get("Complemento"));
		textFieldNumero.setText((String) item.get("Numero"));
		textFieldBairro.setText((String) item.get("Bairro"));
		textFieldMunicipio.setText((String) item.get("Municipio"));
		textFieldUF.setText((String) item.get("UF"));
		textFieldCEP.setText((String) item.get("CEP"));
		textFieldRepLegal.setText((String) item.get("RepLegal"));
		textFieldCPF.setText((String) item.get("CPF"));
		textFieldRG.setText((String) item.get("RG"));
		textFieldEmail.setText((String) item.get("Email"));
		textFieldTelefone.setText((String) item.get("Telefone"));
		textFieldFantasia.setText((String) item.get("Fantasia"));
		
		try {
				JSONArray planos = (JSONArray) item.get("Planos");
			
				for(int index = 0; index < planos.size(); index++)
				{
					setPlanos((JSONObject) planos.get(index));
				}
		} catch (Exception e) {}	
	}
	
	/**
	 * Metodo para exibir as informações dos planos do anunciante na interface
	 */
	private void setPlanos(JSONObject item)
	{
		if(item.get("Tipo").equals("Impresso"))
		{
			formattedTextFieldDiaPagamentoImpresso.setValue(item.get("DiaDoPagamento"));
			textFieldParcelasImpresso.setText((String) item.get("Parcelas"));
			formattedTextFieldVinculoImpresso.setValue(item.get("InicioDoVinculo"));
			choiceImpresso.select((String)item.get("Espaco"));
			double parcelas =  Double.parseDouble((String) item.get("Parcelas"));
			checkBoxImpresso.setSelected(true);
			calcularOsPreços("Impresso", parcelas);
			
		}
		if(item.get("Tipo").equals("Blog"))
		{
			formattedTextFieldDiaPagamentoBlog.setValue(item.get("DiaDoPagamento"));
			textFieldParcelasBlog.setText((String) item.get("Parcelas"));
			formattedTextFieldVinculoBlog.setValue(item.get("InicioDoVinculo"));
			choiceBlog.select((String)item.get("Espaco"));
			double parcelas =  Double.parseDouble((String) item.get("Parcelas"));
			checkBoxBlog.setSelected(true);
			calcularOsPreços("Blog", parcelas);
		}
		if(item.get("Tipo").equals("Web"))
		{
			formattedTextFieldDiaPagamentoWeb.setValue(item.get("DiaDoPagamento"));
			textFieldParcelasWeb.setText((String) item.get("Parcelas"));
			formattedTextFieldVinculoWeb.setValue(item.get("InicioDoVinculo"));
			choiceWeb.select((String)item.get("Espaco"));
			double parcelas =  Double.parseDouble((String) item.get("Parcelas"));;
			checkBoxWeb.setSelected(true);
			calcularOsPreços("Web", parcelas);
		}
		if(item.get("Tipo").equals("App"))
		{
			formattedTextFieldDiaPagamentoApp.setValue(item.get("DiaDoPagamento"));
			textFieldParcelasApp.setText((String) item.get("Parcelas"));
			formattedTextFieldVinculoApp.setValue(item.get("InicioDoVinculo"));
			choiceApp.select((String)item.get("Espaco"));
			double parcelas =  Double.parseDouble((String) item.get("Parcelas"));
			checkBoxApp.setSelected(true);
			calcularOsPreços("App", parcelas);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void salvarEditEspaco(String midia, String nome){
		for(int i = 0; i < writerPrices.getListaItems().size(); i++) {
			JSONObject item = (JSONObject) writerPrices.getListaItems().get(i);
			if(item.get("Nome").equals(nome) && item.get("Mídia").equals(midia)){
				writerPrices.getListaItems().set(i, criarEspaco());
			}
		}
		writerPrices.salvarDados("C:\\Users\\guianatal\\Desktop\\Guia Financeiro Dev\\GuiaFinanceiro\\src\\GuiaFinanceiro\\ValoresDosEspacos.json");
	}
	
	private void setFieldsEditarEspaco(JSONObject item)
	{
		choiceMidiaEspaco.select((String) item.get("Mídia"));
		textFieldNomeEspaco.setText((String) item.get("Nome"));
		textFieldValorEspaco.setText((String) item.get("Valor"));
	}
	
	private void clearEspacoFields() {
		choiceMidiaEspaco.select(0);
		textFieldNomeEspaco.setText("");
		textFieldValorEspaco.setText("");
	}
	
	/**
	 * Metodo para calcular e exibir o valor total e o valor das parcelas de um espaço
	 * @param tipo: String contendo o tipo do espaço (Impresso, Blog, Web ou App)
	 * @param parcelas: Double contendo o numero de parcelas
	 */
	private void calcularOsPreços(String tipo, double parcelas)
	{
		DecimalFormat df2 = new DecimalFormat(".##");
		
		if(tipo.equals("Impresso"))
		{
			String output = new String();
			double valor = 100;
			if(parcelas == 1)
			{
				output = df2.format(new Double((valor/10)*9)).toString();
				textFieldValorParcelaImpresso.setText(output);
				textFieldValorTotalImpresso.setText(output);
			}
			else {
				output = df2.format(new Double(valor/parcelas)).toString();
				textFieldValorParcelaImpresso.setText(output);
				output = df2.format(new Double(valor)).toString();
				textFieldValorTotalImpresso.setText(output);
			}
		}
		if(tipo.equals("Blog"))
		{
			String output = new String();
			double valor = 100;
			if(parcelas == 1)
			{
				output = df2.format(new Double((valor/10)*9)).toString();
				textFieldValorParcelaBlog.setText(output);
				textFieldValorTotalBlog.setText(output);
			}
			else {
				output = df2.format(new Double(valor/parcelas)).toString();
				textFieldValorParcelaBlog.setText(output);
				output = df2.format(new Double(valor)).toString();
				textFieldValorTotalBlog.setText(output);
			}
		}
		if(tipo.equals("Web"))
		{
			String output = new String();
			double valor = 100;
			if(parcelas == 1)
			{
				output = df2.format(new Double((valor/10)*9)).toString();
				textFieldValorParcelaWeb.setText(output);
				textFieldValorTotalWeb.setText(output);
			}
			else {
				output = df2.format(new Double(valor/parcelas)).toString();
				textFieldValorParcelaWeb.setText(output);
				output = df2.format(new Double(valor)).toString();
				textFieldValorTotalWeb.setText(output);
			}
			
		}
		if(tipo.equals("App"))
		{
			String output = new String();
			double valor = 100;
			if(parcelas == 1)
			{
				output = df2.format(new Double((valor/10)*9)).toString();
				textFieldValorParcelaApp.setText(output);
				textFieldValorTotalApp.setText(output);
			}
			else {
				output = df2.format(new Double(valor/parcelas)).toString();
				textFieldValorParcelaApp.setText(output);
				output = df2.format(new Double(valor)).toString();
				textFieldValorTotalApp.setText(output);
			}
			
		}
	}
	
	/**
	 * Metodo para procurar um valor de um esaço em um tipo de plataforma
	 * @param tipo: String contendo informaçoes da plataforma
	 * @param espaço: String contendo as informaçoes do espaço
	 * @return O valor do espaço em Reais
	 */
	private double descobrirValor(String tipo, String espaço)
	{
		return 100;
	}
	
	/**
	 * Medodo para Adicionar as opçoes de espaço de midia
	 */
	private void addChoiceValues()

	{
		//Adiciona as escolhas vazias
		choiceImpresso.add("");
		choiceBlog.add("");
		choiceWeb.add("");
		choiceApp.add("");
		
		JSONArray escolhas = writerPrices.getListaItems();
		JSONObject escolha = new JSONObject();
		
		for(int i = 0; i < escolhas.size(); i++) {		
			escolha = (JSONObject) escolhas.get(i);
			String midia = (String) escolha.get("Mídia");
			if(midia.equals("Impresso")) {
				choiceImpresso.add((String) escolha.get("Nome"));
			}
			if(midia.equals("Blog")) {
				choiceBlog.add((String) escolha.get("Nome"));
			}
			if(midia.equals("Web")) {
				choiceWeb.add((String) escolha.get("Nome"));
			}
			if(midia.equals("App")) {
				choiceApp.add((String) escolha.get("Nome"));
			}
		}	
	}
	
	private void refreshTableEspaco() {
		tableModelImpresso.getDataVector().removeAllElements();
		tableModelImpresso.fireTableDataChanged();
		
		for(int i = 0; i < writerPrices.getListaItems().size(); i++) {
			JSONObject item = (JSONObject) writerPrices.getListaItems().get(i);
			tableModelImpresso.addRow(new Object[] {item.get("Mídia"), item.get("Nome"), item.get("Valor")});
		}
	}
	
	private void refreshTableAnunciante() {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
		
		//Exibe todos os elementos do documento (trocar para uma valor x se tiver muitos clientes)
		for(int i = 0; i < writer.getListaItems().size(); i++) {
			JSONObject item = (JSONObject) writer.getListaItems().get(i);
			tableModel.addRow(new Object[] {item.get("RazaoSocial"), item.get("RepLegal"), item.get("Fantasia")});
		}
	}
	
	private void removerAnunciante(String razao) {
		writer.getListaItems().remove(findAnunciante(razao));
		writer.salvarDados("C:\\Users\\guianatal\\Desktop\\Guia Financeiro Dev\\GuiaFinanceiro\\src\\GuiaFinanceiro\\test.json");
	}
}

