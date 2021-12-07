package view;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import controller.control;

public class main {
	public static void main(String[] args)  {
		control controle = new control();
		JOptionPane.showMessageDialog(null,"Atenção digite a unit corretamente, sendo necessário digitar em maiusculo/minusculo conforme a unit");
		String unit  = JOptionPane.showInputDialog("Digite o valor da unit: " );
		try {
			if(!unit.equals("")) {
			controle.Buscar(unit);
			}else {
				System.out.println("Entrada invalida, digite alguma unit");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}