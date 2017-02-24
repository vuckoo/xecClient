package com.ev.conv;

public class Signal {

	private String signalName;

	private String signalMeaning;

	private int length;

	private String dataType;

	private String desc;

	private int offset;

	private double resolution;

	private String defVal;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSignalName() {
		return signalName;
	}

	public void setSignalName(String signalName) {
		this.signalName = signalName;
	}

	public String getSignalMeaning() {
		return signalMeaning;
	}

	public void setSignalMeaning(String signalMeaning) {
		this.signalMeaning = signalMeaning;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public double getResolution() {
		return resolution;
	}

	public void setResolution(double resolution) {
		this.resolution = resolution;
	}

	public String getDefVal() {
		return defVal;
	}

	public void setDefVal(String defVal) {
		this.defVal = defVal;
	}

	@Override
	public String toString() {
		return "Signal [signalName=" + signalName + ", signalMeaning=" + signalMeaning + ", length=" + length
				+ ", dataType=" + dataType + ", offset=" + offset + ", resolution=" + resolution + ", defVal=" + defVal
				+ "]";
	}

}
