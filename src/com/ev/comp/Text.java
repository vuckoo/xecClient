package com.ev.comp;

import org.eclipse.swt.widgets.Composite;

public class Text extends org.eclipse.swt.widgets.Text {

	public Text(Composite parent, int style) {
		super(parent, style);
		checkSubclass();
	}

	protected void checkSubclass() {

	}

	private String tagName;

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}
