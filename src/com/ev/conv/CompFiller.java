package com.ev.conv;

import com.ev.comp.Combo;
import com.ev.comp.Text;

public class CompFiller {

	public static void fill(String signalName, Combo combo) {
		Signal signal = SignalList.getSignal(signalName);
		if (signal == null)
			return;
		String desc = signal.getDesc();
		if (desc == null || !"enum".equals(signal.getDataType()))
			return;
		String[] vals = desc.replace("\n", "").split(";");
		for (int i = 0; i < vals.length; i++) {
			String val = vals[i];
			vals[i] = val.trim();
		}

		combo.setItems(vals);
		combo.select(Integer.valueOf(signal.getDefVal()));
		combo.setTagName(signalName);
	}

	public static void fill(String signalName, Text text) {
		Signal signal = SignalList.getSignal(signalName);
		if (signal == null)
			return;

		text.setText(signal.getDefVal());
		text.setToolTipText(signal.getDesc());
		text.setTagName(signalName);
	}

	public static void select(Combo combo, String value) {
		Signal signal = SignalList.getSignal(combo.getTagName());
		if (signal == null)
			return;
		String desc = signal.getDesc();
		if (desc == null || !"enum".equals(signal.getDataType()))
			return;
		String[] items = desc.replace("\n", "").split(";");
		int index = 0;
		for (int i = 0; i < items.length; i++) {
			String item = items[i].replace("0x", "");
			if (item.substring(0, item.indexOf(":")).equals(value)) {
				index = i;
				break;
			}
		}

		combo.select(index);
	}

}
