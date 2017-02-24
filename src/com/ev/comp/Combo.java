package com.ev.comp;

import org.eclipse.swt.widgets.Composite;

public class Combo extends org.eclipse.swt.widgets.Combo {

	private String tagName;

	public Combo(Composite parent, int style) {
		super(parent, style);
		checkSubclass();
	}

	protected void checkSubclass() {

	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}
