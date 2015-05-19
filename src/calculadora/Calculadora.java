package calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Calculadora extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	static public boolean temp= true;
	static public String sinal = "";
	static public String recebeNumeros = "";
	public int[] valorSoma;
	public int[] valorDiv;
	public int[] valorMult;
	public int[] valorSub;

	JPanel jpGeral = new JPanel(new BorderLayout());
	JPanel jpNorte = new JPanel(new BorderLayout());
	JPanel jpSul = new JPanel(new FlowLayout());
	JPanel jpLeste = new JPanel(new FlowLayout());
	JPanel jpOeste = new JPanel(new FlowLayout());
	JPanel jpDisplay = new JPanel(new BorderLayout());
	
	JPanel jpNumeros = new JPanel(new FlowLayout());
	JPanel jpOperadores = new JPanel(new FlowLayout());
	JPanel jpFuncoes = new JPanel(new FlowLayout());
	
	JMenuBar jmbMenu = new JMenuBar();
	JMenu jmExibir = new JMenu("Exibir");
	JMenuItem jmiPadrao = new JMenuItem("Padrão     alt+1");
	JMenuItem jmiCientifica = new JMenuItem("Ciêntifica     alt+2");
	JMenuItem jmiProgramador = new JMenuItem("Programador     alt+3");
	JMenuItem jmiEstatistica = new JMenuItem("Estatistica     alt+4");
	
	JMenu jmEditar = new JMenu("Editar");
	JMenu jmAjuda = new JMenu("Ajuda");
	JMenuItem jmSobre = new JMenuItem("Sobre");
	
	JTextField jtDisplay1 = new JTextField("",14);
	JTextField jtDisplay2 = new JTextField("",10);
	
	JRadioButton jrGraus = new JRadioButton("Graus");
	JRadioButton jrRadianos = new JRadioButton("Radianos");
	JRadioButton jrGrados = new JRadioButton("Grados");
	ButtonGroup bgBotoes = new ButtonGroup();
	
	String numeros[] = {"7","8","9","4","5","6","1","2","3","0","."};
	JButton jbNumeros[] = new JButton[numeros.length];
	
	String operadores[] = {"/","%","*","x^y","-","+","=" };
	JButton jbOperadores[] = new JButton[operadores.length];
	
	String outrasfuncoes[] = {"MC","MR","MS","M+","M-","←","CE","C","±","√"};
	JButton jbOutrasFuncoes[] = new JButton[outrasfuncoes.length];
	
	String funcoes[] = {" ","Inv","In","(",")","Int","sinh","sin","x²","n!",
			"dms","cosh","cos","1/x","√x","π","tanh","tan","x³","³√x","F-E",
			"Exp","Mod","log","10^x"};
	
	JButton jbFuncoes[] = new JButton[funcoes.length];
	
	public Calculadora() {
	/////////////////////////////////////////////////////////////////////////////////////	
		setTitle("Calculadora");
		setSize(485,382);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	/////////////////////////////////////////////////////////////////////////////////////
		jmExibir.add(jmiPadrao);
		jmExibir.add(jmiCientifica);
		jmExibir.add(jmiProgramador);
		jmExibir.add(jmiEstatistica);
		
		jmbMenu.add(jmExibir);	
		
		////////////////////////////
		jmbMenu.add(jmEditar);	
		jmAjuda.add(jmSobre);
		
		jmbMenu.add(jmAjuda);		
		jpNorte.add(jmbMenu);	
	/////////////////////////////////////////////////////////////////////////////////////
		bgBotoes.add(jrGraus);	
		bgBotoes.add(jrRadianos);		
		bgBotoes.add(jrGrados);		
		jpOeste.add(jrGraus);
		jpOeste.add(jrRadianos);
		jpOeste.add(jrGrados);
		jrGraus.setFont(new Font("Arial",Font.PLAIN,12));
		jrRadianos.setFont(new Font("Arial",Font.PLAIN,12));
		jrRadianos.setSelected(true);
		jrGrados.setFont(new Font("Arial",Font.PLAIN,12));
	//////////////////////////////////////////////////////////////////////////////////////	
	for(int i = 0; i < numeros.length; i++){
		jbNumeros[i] = new JButton(numeros[i]);
		jpNumeros.add(jbNumeros[i]).setPreferredSize(new Dimension(35,35));
		jbNumeros[i].setFont(new Font("Arial",Font.PLAIN, 12));
		jbNumeros[i].setMargin(new Insets(1,1,1,1));
		jbNumeros[i].addActionListener(this);
	}
	
	for(int i = 0; i < operadores.length; i++){
		jbOperadores[i] = new JButton(operadores[i]);
		jpOperadores.add(jbOperadores[i]).setPreferredSize(new Dimension(35,35));
		jbOperadores[i].setFont(new Font("Arial",Font.PLAIN, 12));
		jbOperadores[i].setMargin(new Insets(1,1,1,1));
		jbOperadores[i].addActionListener(this);
	}
	
	for(int i = 0; i < outrasfuncoes.length; i++){
		jbOutrasFuncoes[i] = new JButton(outrasfuncoes[i]);
		jpFuncoes.add(jbOutrasFuncoes[i]).setPreferredSize(new Dimension(35,35));
		jbOutrasFuncoes[i].setFont(new Font("Arial",Font.PLAIN, 12));
		jbOutrasFuncoes[i].setMargin(new Insets(1,1,1,1));
		jbOutrasFuncoes[i].addActionListener(this);
	}
	
	jpLeste.add(jpFuncoes);
	jpFuncoes.setPreferredSize(new Dimension(210,80));
	
	
	jpLeste.add(jpNumeros);
	jpNumeros.setPreferredSize(new Dimension(120,160));
	jbNumeros[9].setPreferredSize(new Dimension(74,35));
	
	jpLeste.add(jpOperadores);
	jpOperadores.setPreferredSize(new Dimension(80,160));
	jbOperadores[6].setPreferredSize(new Dimension(74,35));
	
	
	//jbNumeros[24].setPreferredSize(new Dimension(35,70));
	for(int j = 0; j <funcoes.length; j++){
		jbFuncoes[j] = new JButton(funcoes[j]);
		jpOeste.add(jbFuncoes[j]).setPreferredSize(new Dimension(35,35));
		jbFuncoes[j].setFont(new Font("Arial",Font.PLAIN, 12));
		jbFuncoes[j].setMargin(new Insets(1,1,1,1));
		jbFuncoes[j].addActionListener(this);
	}	
	/////////////////////////////////////////////////////////////////////////////////////
		//jpSul.setBorder(BorderFactory.createTitledBorder(" "));
		jpLeste.setBorder(BorderFactory.createTitledBorder(""));
		jpOeste.setBorder(BorderFactory.createTitledBorder(""));
	/////////////////////////////////////////////////////////////////////////////////////	
		jpOeste.setPreferredSize(new Dimension(229,270));
		jpLeste.setPreferredSize(new Dimension(229,270));
		jpSul.add(jpOeste);
		jpSul.add(jpLeste);
	/////////////////////////////////////////////////////////////////////////////////////	
		jtDisplay1.setPreferredSize(new Dimension(10,24));
		jtDisplay1.setBorder(null);
		jtDisplay2.setPreferredSize(new Dimension(10,24));
		//jtDisplay1.setEditable(false);
		//jtDisplay2.setEditable(false);
		jtDisplay1.setHorizontalAlignment(JTextField.RIGHT);
		jtDisplay2.setHorizontalAlignment(JTextField.RIGHT);
		jtDisplay2.setBorder(null);
		jtDisplay1.setFont(new Font("Arial",Font.PLAIN, 14));
		jtDisplay2.setFont(new Font("Arial",Font.PLAIN, 14));
		jpDisplay.setBorder(BorderFactory.createTitledBorder(""));
		jpDisplay.setPreferredSize(new Dimension(20, 20));
		
		
	/////////////////////////////////////////////////////////////////////////////////////	
		jpGeral.add(jpNorte,new BorderLayout().NORTH);
		jpDisplay.add(jtDisplay1,new BorderLayout().NORTH);
		jpDisplay.add(jtDisplay2,new BorderLayout().SOUTH);
		jpGeral.add(jpDisplay,new BorderLayout().CENTER);
		jpSul.setPreferredSize(new Dimension(300,280));;
		jpGeral.add(jpSul,new BorderLayout().SOUTH);
		jpGeral.setBackground(Color.blue);
	////////////////////////////////////////////////////////////////////////////////////
		setVisible(true);
	}
	
	String operador = "";
	double valorTotal = 0;
	double valorTemp = 0;
	boolean clicouFuncao = false;
	
	double radianosParaGraus(double valorTotal){
		if (jrGraus.isSelected()){
			return (valorTotal * (Math.PI/180));
		} else {
			return (valorTotal);
		}
	}
	
	double fatorial(double num){
		if (num <= 1)
			return 1;
		else
			return fatorial(num-1)*num;
	}
	
	public void metodoOperadores(String operador){
		if (operador.equals(""))
			valorTotal = valorTemp;
		else if (operador.equals(" + "))
			valorTotal += valorTemp;
		else if (operador.equals(" - "))
			valorTotal -= valorTemp;
		else if (operador.equals(" * "))
			valorTotal *= valorTemp;
		else if (operador.equals(" / "))
			valorTotal /= valorTemp;
		else if (operador.equals(" = "))
			valorTemp = 0;
		else if (operador.equals(" x^y "))
			valorTotal = Math.pow(valorTotal, valorTemp);
	}
	
	public void metodoFuncoes(String funcao){
		boolean alterou = false;
		if (valorTotal == 0)
			valorTotal = valorTemp;
		if (funcao.equals("sin")){
			valorTotal = Math.sin(radianosParaGraus(valorTotal));
			jtDisplay1.setText("" + " sin(" + jtDisplay2.getText() + ") ");
		} else if (funcao.equals("cos")){
			valorTotal = Math.cos(radianosParaGraus(valorTotal));
			jtDisplay1.setText("" + " cos(" + jtDisplay2.getText() + ") ");
		} else if (funcao.equals("tan")){
			valorTotal = Math.tan(radianosParaGraus(valorTotal));
			jtDisplay1.setText("" + " tan(" + jtDisplay2.getText() + ") ");
		} else if (funcao.equals("log")){
			valorTotal = Math.log(radianosParaGraus(valorTotal));
			jtDisplay1.setText("" + " log(" + jtDisplay2.getText() + ") ");
		} else if (funcao.equals("x²")){
			valorTotal = Math.pow(radianosParaGraus(valorTotal), 2);
			jtDisplay1.setText("" + " sqr(" + jtDisplay2.getText() + ") ");
		} else if (funcao.equals("x³")){
			valorTotal = Math.pow(radianosParaGraus(valorTotal), 3);
			jtDisplay1.setText("" + " cube(" + jtDisplay2.getText() + ") ");
		} else if (funcao.equals("10^x")){
			valorTotal = Math.pow(10, radianosParaGraus(valorTotal));
			jtDisplay1.setText("" + " powten(" + jtDisplay2.getText() + ") ");
		} else if (funcao.equals("√")){
			jtDisplay1.setText("" + " sqrt(" + jtDisplay2.getText() + ") ");
		} else if (funcao.equals("³√x")){
			valorTotal = Math.cbrt(radianosParaGraus(valorTotal));
			jtDisplay1.setText("" + " cuberoot(" + jtDisplay2.getText() + ") ");
		} else if (funcao.equals("cosh")){
			valorTotal = Math.cosh(radianosParaGraus(valorTotal));
			jtDisplay1.setText("" + " cosh(" + jtDisplay2.getText() + ") ");
		} else if (funcao.equals("sinh")){
			valorTotal = Math.sinh(radianosParaGraus(valorTotal));
			jtDisplay1.setText("" + " sinh(" + jtDisplay2.getText() + ") ");
		} else if (funcao.equals("tanh")){
			valorTotal = Math.tanh(radianosParaGraus(valorTotal));
			jtDisplay1.setText("" + " tanh(" + jtDisplay2.getText() + ") ");
		} else if (funcao.equals("n!")){
			valorTotal = fatorial(radianosParaGraus(valorTotal));
			jtDisplay1.setText("" + " fact(" + jtDisplay2.getText() + ") ");
		} else if (funcao.equals("Int")){
			valorTotal = (int)(radianosParaGraus(valorTotal));
			jtDisplay1.setText("" + " Int(" + jtDisplay2.getText() + ") ");
		} else if (funcao.equals("1/x")){
			valorTotal = 1/valorTotal;
			jtDisplay1.setText("" + " reciproc(" + jtDisplay2.getText() + ") ");
		} else if (funcao.equals("π")){
			jtDisplay2.setText("" + Math.PI);
			jtDisplay1.setText("");
			alterou = true;
		}
		if (!alterou)
			jtDisplay2.setText("" + valorTotal);
		clicouFuncao = true;
	}
	
	public void metodoOutrasFuncoes(String outrasFuncoes){
		if (valorTotal == 0)
			valorTotal = valorTemp;
		if (outrasFuncoes.equals("CE")){
			jtDisplay1.setText("");
			jtDisplay2.setText("");
			operador = "";
			valorTotal = 0;
			valorTemp = 0;
		} else if (outrasFuncoes.equals("√")){
			valorTotal = Math.sqrt(valorTotal);
			jtDisplay1.setText("" + " sqrt(" + jtDisplay2.getText() + ") ");
			jtDisplay2.setText("" + valorTotal);
		}
	}

	public void actionPerformed(ActionEvent e) {
		
		Object clicou = e.getSource();

		for (int i=0; i<numeros.length; i++)
			if(clicou.equals(jbNumeros[i]))
				jtDisplay2.setText(recebeNumeros + jtDisplay2.getText() + jbNumeros[i].getText());
		
		if (jtDisplay2.getText() != null)
			valorTemp = Double.parseDouble(jtDisplay2.getText());
		
		for (int i=0; i< operadores.length; i++)
			if(clicou.equals(jbOperadores[i])){
				metodoOperadores(operador);
				operador = " " + operadores[i] + " ";
				if (operador.equals(" = ")) {
					jtDisplay1.setText("");
					if (valorTotal % 1 == 0)
						jtDisplay2.setText("" + (int)valorTotal);
					else
						jtDisplay2.setText("" + valorTotal);
				} else {
					if (clicouFuncao)
						jtDisplay1.setText("" + jtDisplay1.getText() + " " + operadores[i]);
					else
						jtDisplay1.setText("" + jtDisplay1.getText() + jtDisplay2.getText() + operador);
					jtDisplay2.setText("");
					clicouFuncao = false;
				}
			}
		
		for (int i=0; i<funcoes.length; i++)
			if(clicou.equals(jbFuncoes[i])){
				metodoFuncoes(funcoes[i]);
			}
		
		for (int i=0; i<outrasfuncoes.length; i++)
			if(clicou.equals(jbOutrasFuncoes[i])){
				metodoOutrasFuncoes(outrasfuncoes[i]);
			}
	}
	
	public static void main(String[] args) {
		new Calculadora();
	}

}
