package com.dock.desafio2.infra.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class Formatter {
	public static String formatoDecimalBR(Object value) {
		Locale localeBR = new Locale("pt","BR");
		NumberFormat numberFormat = NumberFormat.getNumberInstance(localeBR);
		return numberFormat.format(value);
	}

}
