package br.com.dxt.formacao.utils;

import javax.swing.JOptionPane;

public class Utils {

	public static Integer getInt(String msg) {
		return Integer.parseInt(getString(msg));
	}

	public static String getString(String msg) {
		return JOptionPane.showInputDialog((msg));
	}
	
	public static boolean confirm(String msg) {
		return JOptionPane.showConfirmDialog(null, msg + "?") == 0;
	}


}
