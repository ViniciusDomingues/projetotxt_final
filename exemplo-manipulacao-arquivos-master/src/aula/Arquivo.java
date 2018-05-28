package aula;



import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;




public class Arquivo extends JFrame {
	JButton a,e;
	ImageIcon icon = new ImageIcon("a.png");
	JLabel label = new JLabel(icon);
	
public Arquivo() throws IOException {
	
	super ("Gasolina");
	Container tela = getContentPane();
	setLayout(null);
	
    
	     gravartxt();
		leituratxt();

	
		 
		 a=new JButton("Alterar valor da gasolina(i)");
		
		 e=new JButton("Excluir linha");
		
		 
		 a.setBounds(10,145,200,40);
		 label.setBounds(10,25,200,100);
			
		 e.setBounds(10,195,200,40);
		 
		 
		 

a.addActionListener(
        new ActionListener(){
        
        public void actionPerformed(ActionEvent e){
        int linhalt = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o número da linha que deseja alterar: "));
   	     int novo_valor = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o novo valor desejado para a gasolina (i): "));
   	     JOptionPane.showMessageDialog(null,"O valor da gasolina da linha "+linhalt+" foi alterado para "+novo_valor+" !");
   	  try {
		atualizartxt(linhalt, novo_valor);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
   	     
        }

   
}
);
		

e.addActionListener(
        new ActionListener(){
        
        public void actionPerformed(ActionEvent e){
        int linhaexc = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o número da linha que deseja excluir: "));
   	     JOptionPane.showMessageDialog(null,"A linha "+linhaexc+" foi excluída!");
   	    
   		 
   	  try {
   		 deletartxt(linhaexc);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
   	     
        }

}
);
	   
		 tela.add(a);
		 tela.add(e);
		 tela.add(label);
		 
		 
		 setSize(225,280);
		 setVisible(true);
		 setResizable(false);
		 setLocationRelativeTo(null);

	
	
}
	
	
	
	
 static String[] linhasdoarquivo = new String[1000];

 	public static void main(String args[]) throws Exception  {

 		Arquivo app = new Arquivo();
 	    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	    
	 

	}

	

	public static void gravartxt() throws IOException {

		FileWriter arq = new FileWriter("d:\\gasolina.txt");
		PrintWriter gravarArq = new PrintWriter(arq);

		 for(int i = 0; i < 1000; i++) {
			 gravarArq.println("Valor da gasolina a cada + 1 dia de greve dos caminhoneiros: " + i);
		 }
		 arq.close();
	}

	public static void leituratxt() throws IOException {

		FileReader arqleitura = new FileReader("d:\\gasolina.txt");
		BufferedReader lerArq = new BufferedReader(arqleitura);
	 
		String linha = lerArq.readLine(); 
	    int i = 0; 
	    
	     while (linha != null) {
	    	 i++;
	    	 if(linha.contains("Valor da gasolina a cada + 1 dia de greve dos caminhoneiros: ")) {
	    		 System.out.println("linha: " + i + "conteúdo: " + linha); 
	    	 } 
	    	 linha = lerArq.readLine();
	     }
	     arqleitura.close();
	}

	

	public static void atualizartxt(int linhalt, int novo_num) throws IOException {
		
		FileReader arqtemp = new FileReader("d:\\gasolina.txt");
		BufferedReader lerArq = new BufferedReader(arqtemp);

	     String linha = lerArq.readLine();
	     int i = 0;

	     while (linha != null) { 

	    	 if(linha.contains("Valor da gasolina a cada + 1 dia de greve dos caminhoneiros: ") && i+1 == linhalt) {
	    	linhasdoarquivo[i] = "Valor da gasolina a cada + 1 dia de greve dos caminhoneiros: " + novo_num;
	    	 }
	    	 else {
	    		 linhasdoarquivo[i] = ""+linha; 
	    	 }
	    	 i++;

	    	 linha = lerArq.readLine();

	     }

	
		 FileWriter arq = new FileWriter("d:\\gasolina.txt");
		 PrintWriter gravarArq = new PrintWriter(arq);

		 

		 for(int grav = 0; grav < 1000; grav++) {
			 gravarArq.println(linhasdoarquivo[grav]);
		 }

		 arq.close();

	}

	

	public static void deletartxt(int linhaexc) throws IOException {

		 FileReader arqtemp = new FileReader("d:\\gasolina.txt");
		 BufferedReader lerArq = new BufferedReader(arqtemp);

	    
	     String linha = lerArq.readLine(); 
	     int i = 0;

	     
	     while (linha != null) { 

	    	 if(linha.contains("Valor da gasolina a cada + 1 dia de greve dos caminhoneiros: ") && i+1 != linhaexc) {
	    		 linhasdoarquivo[i] = ""+linha; 

	    	 }else {

	    		 linha = lerArq.readLine();
	    		linhasdoarquivo[i] = ""+linha;

	    	 }

	    	 i++;
	    	 linha = lerArq.readLine();

	     }

		 FileWriter arq = new FileWriter("d:\\gasolina.txt");
		 PrintWriter gravarArq = new PrintWriter(arq);

		 for(int grav = 0; grav < 1000; grav++) {

			 gravarArq.println(linhasdoarquivo[grav]);

		 }

		 arq.close();

	}

}

