package com.ev.conv;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ev.comp.Combo;
import com.ev.comp.Text;

public class XEVConv extends ApplicationWindow {
	private Text text_sc;
	private Text text_cim;
	private Text text_rm;
	private Text text_vin;
	private Text text_encry;
	private Text text_time;
	private Text text_accumulatedMileage;
	private Text text_vol;
	private Text text_current;
	private Text text_vehSpeed;
	private Text text_soc;
	private Text text_insulationResistance;
	private Text text_acceleratorPedal;
	private Text text_pedalState;
	private Text text_emQuantity;
	private Text text_emSn;
	private Text text_emCtlTemp;
	private Text text_emSpeed;
	private Text text_emTorque;
	private Text text_emTemp;
	private Text text_emVoltage;
	private Text text_emCurrent;
	private Text text_crankSpeed;
	private Text text_fuelConsumption;
	private Text text_longitude;
	private Text text_latitude;
	private Text text_25;
	private Text text_26;
	private Text text_27;
	private Text text_28;
	private Text text_29;
	private Text text_30;
	private Text text_31;
	private Text text_32;
	private Text text_33;
	private Text text_34;
	private Text text_35;
	private Text text_36;
	private Text text_highestLevel;
	private Text text_warningMark;
	private Text text_n1Codes;
	private Text text_n3Codes;
	private Text text_n2Codes;
	private Text text_n4Codes;

	Combo combo_vehicleStatus;
	Combo combo_chargeState;
	Combo combo_operationMode;
	Combo combo_gearPosition;
	Combo combo_dcdc;
	Combo combo_gearPos4;
	Combo combo_gearPos5;
	Combo combo_emState;
	Combo combo_engState;

	org.eclipse.swt.widgets.Combo combo_posState;

	/**
	 * Create the application window.
	 */
	public XEVConv() {
		super(null);
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
	}

	/**
	 * Create contents of the application window.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = new Composite(container, SWT.NONE);
		composite.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		composite.setLayout(new GridLayout(14, false));
		new Label(composite, SWT.NONE);

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("SC:");

		text_sc = new Text(composite, SWT.BORDER);
		text_sc.setText("23 23");
		GridData gd_text_sc = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
		gd_text_sc.widthHint = 60;
		text_sc.setLayoutData(gd_text_sc);
		new Label(composite, SWT.NONE);

		Label lblNewLabel_5 = new Label(composite, SWT.NONE);
		lblNewLabel_5.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_5.setText("VIN:");

		text_vin = new Text(composite, SWT.BORDER);
		text_vin.setText("1FTEW1EG0GKD20191");
		GridData gd_text_vin = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text_vin.widthHint = 147;
		text_vin.setLayoutData(gd_text_vin);
		new Label(composite, SWT.NONE);

		Label lblIp = new Label(composite, SWT.NONE);
		lblIp.setText("IP:");

		text_ip = new Text(composite, SWT.BORDER);
		text_ip.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		text_ip.setSize(148, 21);
		CompFiller.fill("Srv_Ip", text_ip);

		new Label(composite, SWT.NONE);

		Label label_5 = new Label(composite, SWT.SEPARATOR | SWT.VERTICAL);
		label_5.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 3));

		Label lblTip = new Label(composite, SWT.NONE);
		lblTip.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 3));
		lblTip.setText(
				"Simulate Step:\r\n1.Input vin, \"vehicle Login\";\r\n2.After login, generate real time data using \r\n   \"convert\", \"send\" the packet;\r\n3.\"Vehicle logout\";");
		new Label(composite, SWT.NONE);

		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_2.setText("CIM:");

		text_cim = new Text(composite, SWT.BORDER);
		text_cim.setText("02");
		GridData gd_text_cim = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
		gd_text_cim.widthHint = 134;
		text_cim.setLayoutData(gd_text_cim);
		new Label(composite, SWT.NONE);

		Label lblNewLabel_6 = new Label(composite, SWT.NONE);
		lblNewLabel_6.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_6.setText("ENCRY:");

		text_encry = new Text(composite, SWT.BORDER);
		text_encry.setText("01");
		text_encry.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(composite, SWT.NONE);

		Label lblPort = new Label(composite, SWT.NONE);
		lblPort.setSize(22, 15);
		lblPort.setText("Port");

		text_port = new Text(composite, SWT.BORDER);
		text_port.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		text_port.setSize(63, 21);
		CompFiller.fill("Srv_Port", text_port);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label lblNewLabel_4 = new Label(composite, SWT.NONE);
		lblNewLabel_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_4.setText("RM:");

		text_rm = new Text(composite, SWT.BORDER);
		text_rm.setText("FE");
		GridData gd_text_rm = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
		gd_text_rm.heightHint = 15;
		text_rm.setLayoutData(gd_text_rm);
		new Label(composite, SWT.NONE);

		Label lblNewLabel_8 = new Label(composite, SWT.NONE);
		lblNewLabel_8.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_8.setText("Time:");

		text_time = new Text(composite, SWT.BORDER);
		text_time.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		text_time.setText("17 01 01 00 00 00");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Button btnVehicleLogin_1 = new Button(composite, SWT.NONE);
		btnVehicleLogin_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					String ret = vehLogin();

					String curtext = text_response.getText();

					Display.getCurrent().asyncExec(new Runnable() {
						@Override
						public void run() {
							text_response.setText(new Date() + ": " + ret + "\n" + curtext);
						}
					});
				} catch (Exception e1) {
					e1.printStackTrace();
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					e1.printStackTrace(new PrintStream(baos));
					MessageDialog.openError(getParentShell(), "", "Socket error: \n" + baos.toString());
				}

			}
		});
		btnVehicleLogin_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnVehicleLogin_1.setText("Vehicle Login");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Composite composite_2 = new Composite(composite, SWT.NONE);
		composite_2.setLayout(new GridLayout(1, false));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label lblIccid = new Label(composite, SWT.NONE);
		lblIccid.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblIccid.setText("ICCID:");

		text_iccid = new Text(composite, SWT.BORDER);
		text_iccid.setText("89860616010045220858");
		text_iccid.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Button btnVehicleLogout = new Button(composite, SWT.NONE);
		btnVehicleLogout.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					String ret = vehLogout();

					String curtext = text_response.getText();

					Display.getCurrent().asyncExec(new Runnable() {
						@Override
						public void run() {
							text_response.setText(new Date() + ": " + ret + "\n" + curtext);
						}
					});
				} catch (Exception e1) {
					e1.printStackTrace();
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					e1.printStackTrace(new PrintStream(baos));
					MessageDialog.openError(getParentShell(), "", "Socket error: \n" + baos.toString());
				}
			}
		});
		btnVehicleLogout.setText("Vehicle Logout");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Button btnSocketReset = new Button(composite, SWT.NONE);
		btnSocketReset.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_MAGENTA));
		btnSocketReset.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				socket = null;
			}
		});
		btnSocketReset.setText("Socket Reset");
		new Label(composite, SWT.NONE);

		Label lblDataUnit = new Label(composite, SWT.NONE);
		lblDataUnit.setText("Data Unit:");

		TabFolder tabFolder = new TabFolder(composite, SWT.NONE);
		tabFolder.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 12, 1));

		TabItem tbtmCompleteVehicleData = new TabItem(tabFolder, SWT.NONE);
		tbtmCompleteVehicleData.setText("Complete vehicle");

		Group group = new Group(tabFolder, SWT.NONE);
		tbtmCompleteVehicleData.setControl(group);
		group.setText("Vehicle Data");
		group.setLayout(new GridLayout(5, false));

		Label label = new Label(group, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label.setText("Vehicle status:");

		combo_vehicleStatus = new Combo(group, SWT.NONE);
		GridData gd_combo_vehicleStatus = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_combo_vehicleStatus.widthHint = 142;
		combo_vehicleStatus.setLayoutData(gd_combo_vehicleStatus);
		new Label(group, SWT.NONE);
		CompFiller.fill("Ignition_status", combo_vehicleStatus);

		Label lblAccumulatedMileagekm = new Label(group, SWT.NONE);
		lblAccumulatedMileagekm.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAccumulatedMileagekm.setText("Accumulated mileage(km):");

		text_accumulatedMileage = new Text(group, SWT.BORDER);
		text_accumulatedMileage.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		CompFiller.fill("OdometerMasterValue", text_accumulatedMileage);

		Label label_2 = new Label(group, SWT.NONE);
		label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_2.setText("Charging state:");

		combo_chargeState = new Combo(group, SWT.NONE);
		combo_chargeState.setItems(new String[] {});
		GridData gd_combo_chargeState = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_combo_chargeState.widthHint = 155;
		combo_chargeState.setLayoutData(gd_combo_chargeState);
		new Label(group, SWT.NONE);
		CompFiller.fill("ChrgStat_D_ActlMntr", combo_chargeState);

		Label lblTotalVoltagev = new Label(group, SWT.NONE);
		lblTotalVoltagev.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTotalVoltagev.setText("Total voltage(V):");

		text_vol = new Text(group, SWT.BORDER);
		text_vol.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		CompFiller.fill("BattTrac_U_Actl", text_vol);

		Label label_4 = new Label(group, SWT.NONE);
		label_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_4.setText("Operation mode:");

		combo_operationMode = new Combo(group, SWT.NONE);
		combo_operationMode.setItems(new String[] {});
		GridData gd_combo_operationMode = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_combo_operationMode.widthHint = 166;
		combo_operationMode.setLayoutData(gd_combo_operationMode);
		combo_operationMode.select(0);
		CompFiller.fill("HybVehMde_D_ActlMntr", combo_operationMode);
		new Label(group, SWT.NONE);

		Label lblTotalCurrenta = new Label(group, SWT.NONE);
		lblTotalCurrenta.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTotalCurrenta.setText("Total current(A):");

		text_current = new Text(group, SWT.BORDER);
		text_current.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		CompFiller.fill("BattTrac_I_Actl", text_current);

		Label lblVehicleSpeedkmh = new Label(group, SWT.NONE);
		lblVehicleSpeedkmh.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblVehicleSpeedkmh.setText("Vehicle speed(km/h):");

		text_vehSpeed = new Text(group, SWT.BORDER);
		CompFiller.fill("Veh_V_ActlEng", text_vehSpeed);
		GridData gd_text_vehSpeed = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text_vehSpeed.widthHint = 175;
		text_vehSpeed.setLayoutData(gd_text_vehSpeed);
		new Label(group, SWT.NONE);

		Label lblSoc = new Label(group, SWT.NONE);
		lblSoc.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSoc.setText("SOC(%):");

		text_soc = new Text(group, SWT.BORDER);
		text_soc.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		CompFiller.fill("BattTracSoc2_Pc_Actl", text_soc);

		Label label_8 = new Label(group, SWT.NONE);
		label_8.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_8.setText("Gear position:");

		combo_gearPosition = new Combo(group, SWT.NONE);
		combo_gearPosition.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		CompFiller.fill("GearLvrPos_D_Actl", combo_gearPosition);

		new Label(group, SWT.NONE);

		Label label_9 = new Label(group, SWT.NONE);
		label_9.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_9.setText("DC/DC state:");

		combo_dcdc = new Combo(group, SWT.NONE);
		combo_dcdc.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		CompFiller.fill("PwSrcULoOn_B_Actl", combo_dcdc);

		Label lblBit = new Label(group, SWT.NONE);
		lblBit.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblBit.setText("Bit4:");

		combo_gearPos4 = new Combo(group, SWT.NONE);
		combo_gearPos4.setItems(new String[] { "0: without braking force ", "1: with braking force" });
		combo_gearPos4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		combo_gearPos4.select(0);
		new Label(group, SWT.NONE);

		Label lblStrokeOfAccelerator = new Label(group, SWT.NONE);
		lblStrokeOfAccelerator.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblStrokeOfAccelerator.setText("Stroke of accelerator pedal(%):");

		text_acceleratorPedal = new Text(group, SWT.BORDER);
		text_acceleratorPedal.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		CompFiller.fill("ApedPos_Pc_ActlArb", text_acceleratorPedal);

		Label lblBit_1 = new Label(group, SWT.NONE);
		lblBit_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblBit_1.setText("Bit5:");

		combo_gearPos5 = new Combo(group, SWT.NONE);
		combo_gearPos5.setItems(new String[] { "0: without driving force  ", "1: with driving force" });
		combo_gearPos5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		combo_gearPos5.select(0);
		new Label(group, SWT.NONE);

		Label lblBrakePedalState = new Label(group, SWT.NONE);
		lblBrakePedalState.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblBrakePedalState.setText("Brake pedal state(%):");

		text_pedalState = new Text(group, SWT.BORDER);
		text_pedalState.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		CompFiller.fill("BrakePedalPosition", text_pedalState);

		Label lblInsulationResistancek = new Label(group, SWT.NONE);
		lblInsulationResistancek.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblInsulationResistancek.setText("Insulation resistance(kΩ):");

		text_insulationResistance = new Text(group, SWT.BORDER);
		text_insulationResistance.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		CompFiller.fill("BattTracInsltn_R_Actl", text_insulationResistance);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);

		Label label_13 = new Label(group, SWT.NONE);
		label_13.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);

		TabItem tbtmVehicleData = new TabItem(tabFolder, SWT.NONE);
		tbtmVehicleData.setText("Electrical machine");

		Group grpElectricalMachine = new Group(tabFolder, SWT.NONE);
		grpElectricalMachine.setText("Electrical machine");
		tbtmVehicleData.setControl(grpElectricalMachine);
		grpElectricalMachine.setLayout(new GridLayout(5, false));

		Label lblQuantityOfElectrical = new Label(grpElectricalMachine, SWT.NONE);
		lblQuantityOfElectrical.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblQuantityOfElectrical.setText("Quantity of electrical machines:");

		text_emQuantity = new Text(grpElectricalMachine, SWT.BORDER);
		text_emQuantity.setText("1");
		text_emQuantity.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(grpElectricalMachine, SWT.NONE);
		new Label(grpElectricalMachine, SWT.NONE);
		new Label(grpElectricalMachine, SWT.NONE);
		new Label(grpElectricalMachine, SWT.NONE);
		new Label(grpElectricalMachine, SWT.NONE);
		new Label(grpElectricalMachine, SWT.NONE);
		new Label(grpElectricalMachine, SWT.NONE);
		new Label(grpElectricalMachine, SWT.NONE);

		Label lblSnOfElectrical = new Label(grpElectricalMachine, SWT.NONE);
		lblSnOfElectrical.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSnOfElectrical.setText("SN of electrical machine:");

		text_emSn = new Text(grpElectricalMachine, SWT.BORDER);
		text_emSn.setText("1");
		text_emSn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(grpElectricalMachine, SWT.NONE);
		new Label(grpElectricalMachine, SWT.NONE);
		new Label(grpElectricalMachine, SWT.NONE);

		Label lblStateOfElectrical = new Label(grpElectricalMachine, SWT.NONE);
		lblStateOfElectrical.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblStateOfElectrical.setText("State of electrical machine:");

		combo_emState = new Combo(grpElectricalMachine, SWT.NONE);
		combo_emState.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		CompFiller.fill("Mtr2State_D_ActlMntr", combo_emState);
		new Label(grpElectricalMachine, SWT.NONE);

		Label lblTemperatureOfElectrical = new Label(grpElectricalMachine, SWT.NONE);
		lblTemperatureOfElectrical.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTemperatureOfElectrical.setText("Temperature of electrical machine controller:");

		text_emCtlTemp = new Text(grpElectricalMachine, SWT.BORDER);
		text_emCtlTemp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		CompFiller.fill("MtrTrac2Inv_Te_Actl", text_emCtlTemp);

		Label lblSpeedOfElectrical = new Label(grpElectricalMachine, SWT.NONE);
		lblSpeedOfElectrical.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSpeedOfElectrical.setText("Speed of electrical machine:");

		text_emSpeed = new Text(grpElectricalMachine, SWT.BORDER);
		text_emSpeed.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		CompFiller.fill("Mtr2Aout_W_ActlMntr", text_emSpeed);
		new Label(grpElectricalMachine, SWT.NONE);

		Label lblTorqueOfElectrical = new Label(grpElectricalMachine, SWT.NONE);
		lblTorqueOfElectrical.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTorqueOfElectrical.setText("Torque of electrical machine:");

		text_emTorque = new Text(grpElectricalMachine, SWT.BORDER);
		text_emTorque.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		CompFiller.fill("MtrTrac2_Tq_Actl", text_emTorque);

		Label lblTemperatureOfElectrical_1 = new Label(grpElectricalMachine, SWT.NONE);
		lblTemperatureOfElectrical_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTemperatureOfElectrical_1.setText("Temperature of electrical machine:");

		text_emTemp = new Text(grpElectricalMachine, SWT.BORDER);
		text_emTemp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		CompFiller.fill("MtrTrac2Coil_Te_Actl", text_emTemp);
		new Label(grpElectricalMachine, SWT.NONE);

		Label lblInputVoltageOf = new Label(grpElectricalMachine, SWT.NONE);
		lblInputVoltageOf.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblInputVoltageOf.setText("Input voltage of electrical machine controller:");

		text_emVoltage = new Text(grpElectricalMachine, SWT.BORDER);
		text_emVoltage.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		CompFiller.fill("TtrnAin_U_Hi_Actl ", text_emVoltage);

		Label lblCurrentOfDc = new Label(grpElectricalMachine, SWT.NONE);
		lblCurrentOfDc.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCurrentOfDc.setText("Current of DC bus of electrical machine controller:");

		text_emCurrent = new Text(grpElectricalMachine, SWT.BORDER);
		text_emCurrent.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		CompFiller.fill("Inv1Ain_I_ActlMntr", text_emCurrent);
		new Label(grpElectricalMachine, SWT.NONE);
		new Label(grpElectricalMachine, SWT.NONE);
		new Label(grpElectricalMachine, SWT.NONE);

		TabItem tbtmNewItem_1 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem_1.setText("Engine");

		Group grpElectri = new Group(tabFolder, SWT.NONE);
		tbtmNewItem_1.setControl(grpElectri);
		grpElectri.setText("Engine");
		grpElectri.setLayout(new GridLayout(3, false));
		new Label(grpElectri, SWT.NONE);
		new Label(grpElectri, SWT.NONE);
		new Label(grpElectri, SWT.NONE);
		new Label(grpElectri, SWT.NONE);
		new Label(grpElectri, SWT.NONE);
		new Label(grpElectri, SWT.NONE);
		new Label(grpElectri, SWT.NONE);

		Label lblEngineState = new Label(grpElectri, SWT.NONE);
		lblEngineState.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblEngineState.setText("Engine state:");

		combo_engState = new Combo(grpElectri, SWT.NONE);
		GridData gd_combo_engState = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_combo_engState.widthHint = 163;
		combo_engState.setLayoutData(gd_combo_engState);
		CompFiller.fill("Eng_D_Stat", combo_engState);
		new Label(grpElectri, SWT.NONE);

		Label lblCrankshaftSpeed = new Label(grpElectri, SWT.NONE);
		lblCrankshaftSpeed.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCrankshaftSpeed.setText("Crankshaft speed(r/min):");

		text_crankSpeed = new Text(grpElectri, SWT.BORDER);
		GridData gd_text_crankSpeed = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text_crankSpeed.widthHint = 195;
		text_crankSpeed.setLayoutData(gd_text_crankSpeed);
		CompFiller.fill("EngAout_N_Actl", text_crankSpeed);
		new Label(grpElectri, SWT.NONE);

		Label lblFuelConsumption = new Label(grpElectri, SWT.NONE);
		lblFuelConsumption.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFuelConsumption.setText("Fuel consumption:");

		text_fuelConsumption = new Text(grpElectri, SWT.BORDER);
		text_fuelConsumption.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		CompFiller.fill("ConsAvgTrip_Fe_Dsply", text_fuelConsumption);

		TabItem tbtmNewItem_2 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem_2.setText("GPS");

		Group grpGps = new Group(tabFolder, SWT.NONE);
		grpGps.setText("GPS");
		tbtmNewItem_2.setControl(grpGps);
		grpGps.setLayout(new GridLayout(3, false));
		new Label(grpGps, SWT.NONE);
		new Label(grpGps, SWT.NONE);
		new Label(grpGps, SWT.NONE);
		new Label(grpGps, SWT.NONE);

		Label lblPositioningState = new Label(grpGps, SWT.NONE);
		lblPositioningState.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPositioningState.setText("Positioning state:");

		combo_posState = new Combo(grpGps, SWT.NONE);
		combo_posState.setToolTipText(
				"0: Invalid positioning; 1: Valid positioning (If the data communication remains normal, but the positioning information cannot be acquired, the final run of effective positioning information shall be transmitted and the positioning state shall be set to ‘invalid’.)");
		combo_posState.setItems(new String[] { "0: Invalid positioning", "1: Valid positioning" });
		combo_posState.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		combo_posState.select(0);
		new Label(grpGps, SWT.NONE);

		Label lblLongitude = new Label(grpGps, SWT.NONE);
		lblLongitude.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLongitude.setText("Longitude:");

		text_longitude = new Text(grpGps, SWT.BORDER);
		text_longitude.setToolTipText("Longitude is multiplied by 106, with precision up to 0.000001 (in degree).");
		text_longitude.setText("118.5");
		text_longitude.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(grpGps, SWT.NONE);

		Label lblLatitude = new Label(grpGps, SWT.NONE);
		lblLatitude.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLatitude.setText("Latitude:");

		text_latitude = new Text(grpGps, SWT.BORDER);
		text_latitude.setToolTipText("Longitude is multiplied by 106, with precision up to 0.000001 (in degree).");
		text_latitude.setText("32.03");
		text_latitude.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		TabItem tbtmNewItem_3 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem_3.setText("Limit value");

		Group grpLimitValue = new Group(tabFolder, SWT.NONE);
		grpLimitValue.setText("Limit Value");
		tbtmNewItem_3.setControl(grpLimitValue);
		grpLimitValue.setLayout(new GridLayout(7, false));
		new Label(grpLimitValue, SWT.NONE);
		new Label(grpLimitValue, SWT.NONE);
		new Label(grpLimitValue, SWT.NONE);
		new Label(grpLimitValue, SWT.NONE);
		new Label(grpLimitValue, SWT.NONE);
		new Label(grpLimitValue, SWT.NONE);
		new Label(grpLimitValue, SWT.NONE);
		new Label(grpLimitValue, SWT.NONE);

		Label lblIdNoOf = new Label(grpLimitValue, SWT.NONE);
		lblIdNoOf.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblIdNoOf.setText("ID No. of battery subsystem with max. voltage:");

		text_25 = new Text(grpLimitValue, SWT.BORDER);
		text_25.setText("1");
		text_25.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpLimitValue, SWT.NONE);
		new Label(grpLimitValue, SWT.NONE);

		Label lblIdNoOf_1 = new Label(grpLimitValue, SWT.NONE);
		lblIdNoOf_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblIdNoOf_1.setText("ID No. of cell with max. voltage:");

		text_26 = new Text(grpLimitValue, SWT.BORDER);
		text_26.setText("1");
		text_26.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpLimitValue, SWT.NONE);

		Label lblMaxCellVoltage = new Label(grpLimitValue, SWT.NONE);
		lblMaxCellVoltage.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblMaxCellVoltage.setText("Max. cell voltage:");

		text_27 = new Text(grpLimitValue, SWT.BORDER);
		text_27.setText("4.35");
		text_27.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpLimitValue, SWT.NONE);
		new Label(grpLimitValue, SWT.NONE);

		Label lblIdNoOf_2 = new Label(grpLimitValue, SWT.NONE);
		lblIdNoOf_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblIdNoOf_2.setText("ID No. of battery subsystem with min. voltage:");

		text_28 = new Text(grpLimitValue, SWT.BORDER);
		text_28.setText("1");
		text_28.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpLimitValue, SWT.NONE);

		Label lblIdNoOf_3 = new Label(grpLimitValue, SWT.NONE);
		lblIdNoOf_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblIdNoOf_3.setText("ID No. of cell with min. voltage:");

		text_29 = new Text(grpLimitValue, SWT.BORDER);
		text_29.setText("1");
		text_29.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpLimitValue, SWT.NONE);
		new Label(grpLimitValue, SWT.NONE);

		Label lblMinCellVoltage = new Label(grpLimitValue, SWT.NONE);
		lblMinCellVoltage.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblMinCellVoltage.setText("Min. cell voltage:");

		text_30 = new Text(grpLimitValue, SWT.BORDER);
		text_30.setText("-2");
		text_30.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpLimitValue, SWT.NONE);

		Label lblIdNoOf_4 = new Label(grpLimitValue, SWT.NONE);
		lblIdNoOf_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblIdNoOf_4.setText("ID No. of subsystem with max. temperature:");

		text_31 = new Text(grpLimitValue, SWT.BORDER);
		text_31.setText("1");
		text_31.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpLimitValue, SWT.NONE);
		new Label(grpLimitValue, SWT.NONE);

		Label lblCodeOfSingle = new Label(grpLimitValue, SWT.NONE);
		lblCodeOfSingle.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCodeOfSingle.setText("Code of single probe with max. temperature:");

		text_32 = new Text(grpLimitValue, SWT.BORDER);
		text_32.setText("2");
		text_32.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpLimitValue, SWT.NONE);

		Label lblMaxTemperatureValue = new Label(grpLimitValue, SWT.NONE);
		lblMaxTemperatureValue.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblMaxTemperatureValue.setText("Max. temperature value:");

		text_33 = new Text(grpLimitValue, SWT.BORDER);
		text_33.setText("60");
		text_33.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpLimitValue, SWT.NONE);
		new Label(grpLimitValue, SWT.NONE);

		Label lblIdNoOf_5 = new Label(grpLimitValue, SWT.NONE);
		lblIdNoOf_5.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblIdNoOf_5.setText("ID No. of subsystem with min. temperature:");

		text_34 = new Text(grpLimitValue, SWT.BORDER);
		text_34.setText("1");
		text_34.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpLimitValue, SWT.NONE);

		Label lblCodeOfProbe = new Label(grpLimitValue, SWT.NONE);
		lblCodeOfProbe.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCodeOfProbe.setText("Code of probe subsystem with min. temperature:");

		text_35 = new Text(grpLimitValue, SWT.BORDER);
		text_35.setText("1");
		text_35.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpLimitValue, SWT.NONE);
		new Label(grpLimitValue, SWT.NONE);

		Label lblMinTemperatureValue = new Label(grpLimitValue, SWT.NONE);
		lblMinTemperatureValue.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblMinTemperatureValue.setText("Min. temperature value:");

		text_36 = new Text(grpLimitValue, SWT.BORDER);
		text_36.setText("-20");
		text_36.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		TabItem tbtmNewItem_4 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem_4.setText("Warning");

		Group grpWarning = new Group(tabFolder, SWT.NONE);
		grpWarning.setText("Warning");
		tbtmNewItem_4.setControl(grpWarning);
		grpWarning.setLayout(new GridLayout(6, false));
		new Label(grpWarning, SWT.NONE);

		Composite composite_1 = new Composite(grpWarning, SWT.NONE);
		composite_1.setLayout(new GridLayout(2, false));
		GridData gd_composite_1 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 4, 1);
		gd_composite_1.heightHint = 217;
		composite_1.setLayoutData(gd_composite_1);

		Button btn_wbit0 = new Button(composite_1, SWT.CHECK);
		btn_wbit0.setBounds(0, 0, 93, 16);
		btn_wbit0.setText("Temperature difference");

		Button btn_wbit10 = new Button(composite_1, SWT.CHECK);
		btn_wbit10.setText("Cell poor-consistency");

		Button btn_wbit1 = new Button(composite_1, SWT.CHECK);
		btn_wbit1.setBounds(0, 0, 93, 16);
		btn_wbit1.setText("Battery high-temperature");

		Button btn_wbit11 = new Button(composite_1, SWT.CHECK);
		btn_wbit11.setText("Insulation");

		Button btn_wbit2 = new Button(composite_1, SWT.CHECK);
		btn_wbit2.setText("Vehicle energy-storage device type over-voltage");

		Button btn_wbit12 = new Button(composite_1, SWT.CHECK);
		btn_wbit12.setText("DC-DC temperature");

		Button btn_wbit3 = new Button(composite_1, SWT.CHECK);
		btn_wbit3.setText("Vehicle energy-storage device type under-voltage");

		Button btn_wbit13 = new Button(composite_1, SWT.CHECK);
		btn_wbit13.setText("Brake system ");

		Button btn_wbit4 = new Button(composite_1, SWT.CHECK);
		btn_wbit4.setText("Low SOC");

		Button btn_wbit14 = new Button(composite_1, SWT.CHECK);
		btn_wbit14.setText("DC-DC state");

		Button btn_wbit5 = new Button(composite_1, SWT.CHECK);
		btn_wbit5.setText("Cell over-voltage");

		Button btn_wbit15 = new Button(composite_1, SWT.CHECK);
		btn_wbit15.setText("Electrical machine controller temperature ");

		Button btn_wbit6 = new Button(composite_1, SWT.CHECK);
		btn_wbit6.setText("Cell under-voltage");

		Button btn_wbit16 = new Button(composite_1, SWT.CHECK);
		btn_wbit16.setText("High-voltage interlocking state");

		Button btn_wbit7 = new Button(composite_1, SWT.CHECK);
		btn_wbit7.setText("Excessively-high SOC");

		Button btn_wbit17 = new Button(composite_1, SWT.CHECK);
		btn_wbit17.setText("Electrical machine temperature");

		Button btn_wbit8 = new Button(composite_1, SWT.CHECK);
		btn_wbit8.setText("SOC jump");

		Button btn_wbit18 = new Button(composite_1, SWT.CHECK);
		btn_wbit18.setText(" Vehicle energy-storage device type over-charging");

		Button btn_wbit9 = new Button(composite_1, SWT.CHECK);
		btn_wbit9.setText("Chargeable energy-storage system unmatched");

		Button btn_wbit19 = new Button(composite_1, SWT.CHECK);
		btn_wbit19.setText("Reserved");

		addMarkListener(btn_wbit0, 0);
		addMarkListener(btn_wbit1, 1);
		addMarkListener(btn_wbit2, 2);
		addMarkListener(btn_wbit3, 3);
		addMarkListener(btn_wbit4, 4);
		addMarkListener(btn_wbit5, 5);
		addMarkListener(btn_wbit6, 6);
		addMarkListener(btn_wbit7, 7);
		addMarkListener(btn_wbit8, 8);
		addMarkListener(btn_wbit9, 9);
		addMarkListener(btn_wbit10, 10);
		addMarkListener(btn_wbit11, 11);
		addMarkListener(btn_wbit12, 12);
		addMarkListener(btn_wbit13, 13);
		addMarkListener(btn_wbit14, 14);
		addMarkListener(btn_wbit15, 15);
		addMarkListener(btn_wbit16, 16);
		addMarkListener(btn_wbit17, 17);
		addMarkListener(btn_wbit18, 18);
		new Label(grpWarning, SWT.NONE);
		new Label(grpWarning, SWT.NONE);

		Label lblHighestWarningLevel = new Label(grpWarning, SWT.NONE);
		lblHighestWarningLevel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblHighestWarningLevel.setText("Highest warning level :");

		text_highestLevel = new Text(grpWarning, SWT.BORDER);
		text_highestLevel.setText("0");
		text_highestLevel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpWarning, SWT.NONE);

		Label lblGeneralWarningMark = new Label(grpWarning, SWT.NONE);
		lblGeneralWarningMark.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblGeneralWarningMark.setText("General warning mark:");

		text_warningMark = new Text(grpWarning, SWT.BORDER);
		text_warningMark.setText("00 00 00 00");
		text_warningMark.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpWarning, SWT.NONE);

		Label lblListOfCodes = new Label(grpWarning, SWT.NONE);
		lblListOfCodes.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblListOfCodes.setText("List of codes of chargeable energy-storage device faults:");

		text_n1Codes = new Text(grpWarning, SWT.BORDER);
		text_n1Codes.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpWarning, SWT.NONE);

		Label lblListOfEngine = new Label(grpWarning, SWT.NONE);
		lblListOfEngine.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblListOfEngine.setText("List of engine faults:");

		text_n2Codes = new Text(grpWarning, SWT.BORDER);
		text_n2Codes.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpWarning, SWT.NONE);

		Label lblListOfCodes_1 = new Label(grpWarning, SWT.NONE);
		lblListOfCodes_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblListOfCodes_1.setText("List of codes of electrical machine faults:");

		text_n3Codes = new Text(grpWarning, SWT.BORDER);
		text_n3Codes.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpWarning, SWT.NONE);

		Label lblListOfCodes_2 = new Label(grpWarning, SWT.NONE);
		lblListOfCodes_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblListOfCodes_2.setText("List of codes of other faults:");

		text_n4Codes = new Text(grpWarning, SWT.BORDER);
		text_n4Codes.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		TabItem tbtmNewItem_5 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem_5.setText("Voltage");

		Group grpVoltage = new Group(tabFolder, SWT.NONE);
		grpVoltage.setText("Voltage");
		tbtmNewItem_5.setControl(grpVoltage);
		grpVoltage.setLayout(new GridLayout(3, false));
		new Label(grpVoltage, SWT.NONE);

		new Label(grpVoltage, SWT.NONE);
		new Label(grpVoltage, SWT.NONE);
		new Label(grpVoltage, SWT.NONE);

		Label lblQuantityOfChargeable = new Label(grpVoltage, SWT.NONE);
		lblQuantityOfChargeable.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblQuantityOfChargeable.setText("Quantity of chargeable energy-storage subsystem:");

		text_volQuantity = new Text(grpVoltage, SWT.BORDER);
		text_volQuantity.setText("1");
		text_volQuantity.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpVoltage, SWT.NONE);

		Label lblCodeOfChargeable = new Label(grpVoltage, SWT.NONE);
		lblCodeOfChargeable.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCodeOfChargeable.setText("Code of chargeable energy-storage subsystem:");

		text_volSysCode = new Text(grpVoltage, SWT.BORDER);
		text_volSysCode.setText("1");
		text_volSysCode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpVoltage, SWT.NONE);

		Label lblVoltageOfChargeable = new Label(grpVoltage, SWT.NONE);
		lblVoltageOfChargeable.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblVoltageOfChargeable.setText("Voltage of chargeable energy-storage device:");

		text_volSys = new Text(grpVoltage, SWT.BORDER);
		text_volSys.setText("200");
		text_volSys.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		CompFiller.fill("BattTrac_U_Actl", text_volSys);
		new Label(grpVoltage, SWT.NONE);

		Label lblCurrentOfChargeable = new Label(grpVoltage, SWT.NONE);
		lblCurrentOfChargeable.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCurrentOfChargeable.setText("Current of chargeable energy-storage device:");

		text_currentSys = new Text(grpVoltage, SWT.BORDER);
		text_currentSys.setText("100");
		text_currentSys.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpVoltage, SWT.NONE);
		CompFiller.fill("BattTrac_I_Actl", text_currentSys);

		Label lblTotalNumberOf = new Label(grpVoltage, SWT.NONE);
		lblTotalNumberOf.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTotalNumberOf.setText("Total number of cell:");

		text_cellNum = new Text(grpVoltage, SWT.BORDER);
		text_cellNum.setText("84");
		text_cellNum.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		CompFiller.fill("BattTracCellCnt_No_Actl_Tol", text_cellNum);
		new Label(grpVoltage, SWT.NONE);

		Label lblSnOfThe = new Label(grpVoltage, SWT.NONE);
		lblSnOfThe.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSnOfThe.setText("SN of the starting battery of this frame:");

		text_SysStartSn = new Text(grpVoltage, SWT.BORDER);
		text_SysStartSn.setText("1");
		text_SysStartSn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpVoltage, SWT.NONE);

		Label lblTotalCellNumber = new Label(grpVoltage, SWT.NONE);
		lblTotalCellNumber.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTotalCellNumber.setText("Total cell number of this frame:");

		text_CellNumSys = new Text(grpVoltage, SWT.BORDER);
		text_CellNumSys.setText("84");
		text_CellNumSys.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		CompFiller.fill("BattTracCellCnt_No_Actl", text_CellNumSys);
		new Label(grpVoltage, SWT.NONE);

		Label lblVoltageOfCell = new Label(grpVoltage, SWT.NONE);
		lblVoltageOfCell.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblVoltageOfCell.setText("Voltage of cell:");

		text_cellVol = new Text(grpVoltage, SWT.BORDER);
		text_cellVol.setText("2.38");
		text_cellVol.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		CompFiller.fill("BattTracCellCnt_No_Actl_vol", text_cellVol);
		TabItem tbtmNewItem = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem.setText("Temperature");

		Group grpTemperature = new Group(tabFolder, SWT.NONE);
		grpTemperature.setText("Temperature");
		tbtmNewItem.setControl(grpTemperature);
		grpTemperature.setLayout(new GridLayout(3, false));
		new Label(grpTemperature, SWT.NONE);

		new Label(grpTemperature, SWT.NONE);
		new Label(grpTemperature, SWT.NONE);

		new Label(grpTemperature, SWT.NONE);

		Label lblQuantityOfChargeable_1 = new Label(grpTemperature, SWT.NONE);
		lblQuantityOfChargeable_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblQuantityOfChargeable_1.setText("Quantity of chargeable energy-storage subsystem:");

		text_tempSysCount = new Text(grpTemperature, SWT.BORDER);
		text_tempSysCount.setText("1");
		text_tempSysCount.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(grpTemperature, SWT.NONE);

		Label lblCodeOfChargeable_1 = new Label(grpTemperature, SWT.NONE);
		lblCodeOfChargeable_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCodeOfChargeable_1.setText("Code of chargeable energy-storage subsystem:");

		text_SysCode = new Text(grpTemperature, SWT.BORDER);
		text_SysCode.setText("1");
		text_SysCode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(grpTemperature, SWT.NONE);

		Label lblQuantityOfChargeable_2 = new Label(grpTemperature, SWT.NONE);
		lblQuantityOfChargeable_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblQuantityOfChargeable_2.setText("Quantity of chargeable energy-storage temperature probes:");

		text_probeNum = new Text(grpTemperature, SWT.BORDER);
		text_probeNum.setText("84");
		text_probeNum.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		CompFiller.fill("BattTracTeCnt_No_Actl", text_probeNum);
		new Label(grpTemperature, SWT.NONE);

		Label lblNewLabel_1 = new Label(grpTemperature, SWT.WRAP);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_1.setText("Temperature value each probe:");

		text_probeTemp = new Text(grpTemperature, SWT.BORDER);
		text_probeTemp.setText("45");
		text_probeTemp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		CompFiller.fill("BattTracTe01_Te_Actl", text_probeTemp);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Button btnConvert = new Button(composite, SWT.NONE);
		btnConvert.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				String packet = convert();

				Display.getCurrent().asyncExec(new Runnable() {
					@Override
					public void run() {
						txt_packet.setText(packet);
						MessageDialog.openInformation(getParentShell(), "Tip", "convert success !");
					}
				});

			}
		});
		GridData gd_btnConvert = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnConvert.widthHint = 80;
		btnConvert.setLayoutData(gd_btnConvert);
		btnConvert.setText("Generate->");

		Button btnCalcBcc = new Button(composite, SWT.NONE);
		btnCalcBcc.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String packet = txt_packet.getText().trim();
				if (packet.length() <= 70) {
					MessageDialog.openWarning(getParentShell(), "Warning", "packet length too short !");
					return;
				}
				String data = packet.substring(6, packet.lastIndexOf(" "));
				String bcc = DataUtil.getBcc(data);
				String newPacket = packet.substring(0, packet.lastIndexOf(" ")) + " " + bcc;

				Display.getCurrent().asyncExec(new Runnable() {
					@Override
					public void run() {
						txt_packet.setText(newPacket);
					}
				});

			}
		});
		btnCalcBcc.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		btnCalcBcc.setText("Calc BCC");
		new Label(composite, SWT.NONE);

		Button btnReversePacket = new Button(composite, SWT.NONE);
		btnReversePacket.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				try {
					reverse();
					MessageDialog.openInformation(getParentShell(), "", "Decode success !");
				} catch (Exception ex) {
					ex.printStackTrace();
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ex.printStackTrace(new PrintStream(baos));
					MessageDialog.openError(getParentShell(), "", "Decode data packet error: \n" + baos.toString());
				}
			}
		});
		btnReversePacket.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnReversePacket.setText("Decode Packet");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label lblNewLabel_10 = new Label(composite, SWT.NONE);
		lblNewLabel_10.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_10.setText("Packet:");

		txt_packet = new Text(composite, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		GridData gd_txt_packet = new GridData(SWT.FILL, SWT.CENTER, true, false, 12, 1);
		gd_txt_packet.heightHint = 60;
		txt_packet.setLayoutData(gd_txt_packet);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Button btnSend = new Button(composite, SWT.NONE);
		GridData gd_btnSend = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnSend.widthHint = 78;
		btnSend.setLayoutData(gd_btnSend);
		btnSend.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String packet = txt_packet.getText().trim();
				try {
					String res = sendPacket(packet);

					String curtext = text_response.getText();

					Display.getCurrent().asyncExec(new Runnable() {
						@Override
						public void run() {
							text_response.setText(new Date() + ": " + res + "\n" + curtext);
						}
					});
				} catch (Exception e1) {
					e1.printStackTrace();
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					e1.printStackTrace(new PrintStream(baos));
					MessageDialog.openError(getParentShell(), "", "Send data packet error: \n" + baos.toString());
				}
			}
		});
		btnSend.setText("Send->");

		Composite composite_3 = new Composite(composite, SWT.NONE);
		composite_3.setLayout(new GridLayout(1, false));
		GridData gd_composite_3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 10, 1);
		gd_composite_3.heightHint = 34;
		gd_composite_3.widthHint = 402;
		composite_3.setLayoutData(gd_composite_3);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label lblResponse = new Label(composite, SWT.NONE);
		lblResponse.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblResponse.setText("Response:");

		text_response = new Text(composite, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		GridData gd_text_response = new GridData(SWT.FILL, SWT.CENTER, false, false, 12, 1);
		gd_text_response.heightHint = 22;
		text_response.setLayoutData(gd_text_response);

		Menu menu = new Menu(parent);
		parent.setMenu(menu);

		MenuItem mntmBcc = new MenuItem(menu, SWT.NONE);
		mntmBcc.setText("BCC");

		return container;
	}

	protected String vehLogout() throws Exception {

		String vin = DataUtil.str2Hex(text_vin.getText().trim());
		String sc = "23 23";
		String data = getTime() + " 00 01";
		String head = "04 FE " + vin + " 01 " + DataUtil.dec2Hex(data.split(" ").length, 2);
		String bcc = DataUtil.getBcc(head + " " + data);

		String packet = sc + " " + head + " " + data + " " + bcc;

		String ret = sendPacket(packet);
		return ret;
	}

	protected String vehLogin() throws Exception {

		String vin = DataUtil.str2Hex(text_vin.getText().trim());
		String iccid = DataUtil.str2Hex(text_iccid.getText().trim());
		String sc = "23 23";
		String data = getTime() + " " + "00 01 " + iccid + " 01 00";
		String head = "01 FE " + vin + " " + "01 " + DataUtil.dec2Hex(data.split(" ").length, 2);
		String bcc = DataUtil.getBcc(head + " " + data);
		String packet = sc + " " + head + " " + data + " " + bcc;

		String ret = sendPacket(packet);

		Thread beat = new Thread(new HeartBeat(vin, socket));
		beat.setDaemon(true);
		beat.start();

		return ret;
	}

	protected void reverse() throws Exception {

		String packet = txt_packet.getText().trim();
		String[] arr = packet.split(" ");
		if (arr.length < 31) {
			throw new Exception("Data packet length too short : " + arr.length);
		}
		String sc = arr[0] + arr[1];
		String cim = arr[2];
		String rm = arr[3];
		String vin = DataUtil.hex2Str(get(arr, 4, 17));
		String encry = arr[21];
		int datalen = DataUtil.hex2Dec(get(arr, 22, 2));
		String data = get(arr, 24, datalen);

		switch (cim) {
		case "01": {
			if (arr.length != 55)
				throw new Exception("vehicle login data length != 55");

			String[] dataarr = data.split(" ");
			String time = get(dataarr, 0, 6);
			int loginsn = DataUtil.hex2Dec(get(dataarr, 6, 2));
			String iccid = DataUtil.hex2Str(get(dataarr, 8, 20));
			int chargeNum = DataUtil.hex2Dec(get(dataarr, 28, 1));

			Display.getCurrent().asyncExec(new Runnable() {
				@Override
				public void run() {
					text_sc.setText(sc);
					text_cim.setText(cim);
					text_rm.setText(rm);
					text_vin.setText(vin);
					text_encry.setText(encry);
					text_time.setText(time);
					text_iccid.setText(iccid);
				}
			});
		}
			break;
		case "02": {
			String[] dataArr = data.split(" ");
			String time = get(dataArr, 0, 6);
			String dataType = dataArr[7];
			if ("01".equals(dataType)) {
				String vehData = get(dataArr, 1, 20);
				String[] vehDataArr = vehData.split(" ");
				int vehState = DataUtil.hex2Dec(get(vehDataArr, 0, 1));
			}

		}
			break;
		case "03":

			break;
		case "04":

			break;
		case "05":

			break;
		case "06":

			break;
		default:
			throw new Exception("data not accept !");
		}

	}

	private String get(String[] arr, int startIndex, int length) {

		String out = "";
		for (int i = startIndex; i < startIndex + length; i++) {
			out = out + arr[i] + " ";
		}

		return out.trim();
	}

	private void addMarkListener(Button btn, int i) {
		btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String sel = btn.getSelection() ? "1" : "0";
				String mark = text_warningMark.getText().trim();
				String newMark = changeWarnMark(mark, i, sel);

				Display.getCurrent().asyncExec(new Runnable() {
					@Override
					public void run() {
						text_warningMark.setText(newMark);
					}
				});
			}
		});
	}

	protected String changeWarnMark(String mark, int bit, String sel) {
		int newVal = Integer.valueOf(mark.replace(" ", ""), 16);
		String markStr = DataUtil.dec2Bin(newVal, 4);

		byte[] markBytes = markStr.getBytes();
		markBytes[31 - bit] = sel.getBytes()[0];
		return DataUtil.dec2Hex(Integer.parseInt(new String(markBytes), 2), 4);
	}

	Socket socket;
	int tryCount = 0;

	protected String sendPacket(String packet) throws Exception {

		String ret = "";

		String ip = text_ip.getText().trim();
		String port = text_port.getText().trim();

		try {
			if (socket == null) {
				socket = new Socket(ip, Integer.valueOf(port));
			}
			// 向服务器端发送数据
			System.out.println("Send To Server: " + packet);

			OutputStream socketWriter = socket.getOutputStream();
			socketWriter.write(DataUtil.str2HexBytes(packet.trim()));

			// 读取服务器端数据
			InputStream input = socket.getInputStream();
			byte[] out = new byte[input.available()];
			input.read(out);
			ret = DataUtil.byteArr2HexStr(out);
			System.out.println("Response from Server: " + ret);
			// out.close();
			// input.close();
		} catch (Exception e) {
			e.printStackTrace();
			socket = null;
			tryCount++;
			if (tryCount < 3) {
				sendPacket(packet);
			}
		}

		return ret;
	}

	protected String convert() {

		// Get basic data
		String startChar = text_sc.getText().trim();
		String cim = text_cim.getText();
		String rm = text_rm.getText();
		String vin = DataUtil.str2Hex(text_vin.getText().trim());
		String encry = text_encry.getText();

		String one = startChar + " " + cim + " " + rm + " " + vin + " " + encry;

		String time = getTime();

		// Get vehicle data
		String vehStatus = getComboVal(combo_vehicleStatus);
		String chargeState = getComboVal(combo_chargeState);
		String operateMode = getComboVal(combo_operationMode);
		String speed = getVal(text_vehSpeed);
		String gearPos = getComboVal(combo_gearPosition);
		String gearPos4 = combo_gearPos4.getText().trim().split(":")[0];
		String gearPos5 = combo_gearPos5.getText().trim().split(":")[0];
		String gearPosition = DataUtil.dec2Hex((Integer.valueOf("00" + gearPos5 + gearPos4 + gearPos, 2) & 0xFF), 1);
		String resistance = getVal(text_insulationResistance);
		String mileage = getVal(text_accumulatedMileage);
		String voltage = getVal(text_vol);
		String current = getVal(text_current);
		String soc = getVal(text_soc);
		String dcdcState = getComboVal(combo_dcdc);
		String strokePedal = getVal(text_acceleratorPedal);
		String brakeState = getVal(text_pedalState);

		String dataVeh = "01 " + vehStatus + " " + chargeState + " " + operateMode + " " + speed + " " + mileage + " "
				+ voltage + " " + current + " " + soc + " " + dcdcState + " " + gearPosition + " " + resistance + " "
				+ strokePedal + " " + brakeState;

		// Get electrical machine
		String emQuantity = DataUtil.dec2Hex(text_emQuantity.getText().trim(), 1);
		String emSn = DataUtil.dec2Hex(text_emSn.getText().trim(), 1);
		String emState = getComboVal(combo_emState);
		String emSpeed = getVal(text_emSpeed);
		String emTemp = getVal(text_emTemp);
		String emCurrent = getVal(text_emCurrent);
		String emCtlTemp = getVal(text_emCtlTemp);
		String emTorque = getVal(text_emTorque);
		String emVoltage = getVal(text_emVoltage);

		String dataEm = "02 " + emQuantity + " " + emSn + " " + emState + " " + emCtlTemp + " " + emSpeed + " "
				+ emTorque + " " + emTemp + " " + emVoltage + " " + emCurrent;

		// Get Fuel Cell Data
		// String dataBattery = "03 10 00 10 00 10 00 00 01 40 00 40 00 01 10 00
		// 01 00 40 01 01";

		// Get engine data
		String engState = getComboVal(combo_engState);
		String crankSpeed = getVal(text_crankSpeed);
		String fuelConsumption = getVal(text_fuelConsumption);
		String dataEng = "04 " + engState + " " + crankSpeed + " " + fuelConsumption + " ";

		// Get gps data
		String posState = combo_posState.getText().trim().substring(0, 1);
		String gpsState = DataUtil.dec2Hex(Integer.valueOf(posState + "0000000", 2), 1);
		String longtitude = formatGps(text_longitude.getText().trim());
		String latitude = formatGps(text_latitude.getText().trim());
		String dataGps = "05 " + gpsState + " " + longtitude + " " + latitude;

		// Get limit value
		String dataLimit = "06 01 01 10 00 01 01 00 00 01 01 40 01 01 00";

		// Get warning data
		String highestLevel = DataUtil.dec2Hex(text_highestLevel.getText().trim(), 1);
		String genMark = text_warningMark.getText().trim();
		String n1codes = getWarnCodes(text_n1Codes.getText().trim());
		String n2codes = getWarnCodes(text_n2Codes.getText().trim());
		String n3codes = getWarnCodes(text_n3Codes.getText().trim());
		String n4codes = getWarnCodes(text_n4Codes.getText().trim());

		String dataWarning = "07 " + highestLevel + " " + genMark + " " + n1codes + " " + n2codes + " " + n3codes + " "
				+ n4codes;

		// Get voltage data
		String volSysQuantity = DataUtil.dec2Hex(text_volQuantity.getText().trim(), 1);
		String volSysCode = DataUtil.dec2Hex(text_volSysCode.getText().trim(), 1);
		String volSys = getVal(text_volSys);
		String currentSys = getVal(text_currentSys);
		String cellNum = getVal(text_cellNum);
		String sysStartSn = DataUtil.dec2Hex(text_SysStartSn.getText().trim(), 2);
		String cellNumSys = getVal(text_CellNumSys);
		int cellNumSysInt = Double.valueOf((text_CellNumSys.getText().trim())).intValue();
		String cellVol = getVal(text_cellVol);
		StringBuilder cellVolStr = new StringBuilder();
		for (int i = 0; i < cellNumSysInt; i++) {
			cellVolStr.append(cellVol + " ");
		}
		cellVol = cellVolStr.toString().trim();

		// String dataVol = "08 01 01 00 10 00 10 00 02 00 01 02 00 10 00 10";
		String dataVol = "08 " + volSysQuantity + " " + volSysCode + " " + volSys + " " + currentSys + " " + cellNum
				+ " " + sysStartSn + " " + cellNumSys + " " + cellVol;

		// Get probe temperature data
		String tempSysQuantity = DataUtil.dec2Hex(text_tempSysCount.getText().trim(), 1);
		String tempSysCode = DataUtil.dec2Hex(text_SysCode.getText().trim(), 1);
		String probeNum = getVal(text_probeNum);
		String probeTemp = getVal(text_probeTemp);
		int probeNumVal = Double.valueOf(text_probeNum.getText().trim()).intValue();
		StringBuilder probeTempStr = new StringBuilder();
		for (int i = 0; i < probeNumVal; i++) {
			probeTempStr.append(probeTemp + " ");
		}
		probeTemp = probeTempStr.toString().trim();

		// String dataTemp = "09 01 01 00 02 00 10 00 10";
		String dataTemp = "09 " + tempSysQuantity + " " + tempSysCode + " " + probeNum + " " + probeTemp;

		// Total data
		// check some logic
		// all electric,not send engine data
		if ("01".equals(operateMode)) {
			dataEng = "";
		}
		String data = time + " " + dataVeh + " " + dataEm + " " + dataEng + dataGps + " " + dataLimit + " "
				+ dataWarning + " " + dataVol + " " + dataTemp;
		String dataLen = DataUtil.dec2Hex(data.split(" ").length, 2);
		String bcc = DataUtil.getBcc(cim + " " + rm + " " + vin + " " + encry + " " + dataLen + " " + data);
		String packet = one + " " + dataLen + " " + data + " " + bcc;

		return packet;
	}

	private String getTime() {
		String timeVal = text_time.getText().trim();
		String timestr = "17 01 01 00 00 00";
		if ("17 01 01 00 00 00".equals(timeVal)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yy MM dd HH mm ss");
			timestr = sdf.format(new Date());
		}

		return formatTime(timestr);
	}

	private String getWarnCodes(String codes) {
		if ("".equals(codes)) {
			return "00";
		}
		String out = "";
		String[] codeArr = codes.split(",");
		for (int i = 0; i < codeArr.length; i++) {
			String code = codeArr[i].replace("0x", "").trim();

			out = out + "00 " + code.substring(0, 2) + " " + code.substring(2, 4) + " " + code.substring(4) + " ";
		}

		int count = codeArr.length;
		return DataUtil.dec2Hex(count, 1) + " " + out.trim();
	}

	private String formatGps(String val) {

		int ll = (int) (Double.valueOf(val) * 1000000);

		return DataUtil.dec2Hex(ll, 4);
	}

	private String formatTime(String time) {
		String[] timestr = time.split(" ");
		String out = "";
		for (int i = 0; i < timestr.length; i++) {
			String str = timestr[i];
			String strhex = DataUtil.dec2Hex(Integer.valueOf(str), 1);
			out += strhex + " ";
		}
		return out.trim();
	}

	private String getVal(Text text) {
		String val = text.getText().trim();
		Signal signal = SignalList.getSignal(text.getTagName());
		if (signal == null)
			return val;

		int offset = signal.getOffset();
		double resolution = signal.getResolution();
		int destVal = (int) Math.round((Double.valueOf(val) + offset) * resolution);
		return DataUtil.dec2Hex(destVal, signal.getLength());
	}

	private String getComboVal(Combo combo) {
		String valstr = combo.getText().trim();
		if (valstr.startsWith("0x"))
			valstr = valstr.replace("0x", "");

		if (valstr.indexOf(":") > -1) {
			return valstr.split(":")[0];
		}

		return valstr;
	}

	private Text text_response;
	private Text text_volQuantity;
	private Text text_volSysCode;
	private Text text_volSys;
	private Text text_currentSys;
	private Text text_cellNum;
	private Text text_SysStartSn;
	private Text text_CellNumSys;
	private Text text_cellVol;
	private Text text_tempSysCount;
	private Text text_SysCode;
	private Text text_probeNum;
	private Text text_probeTemp;
	private Text text_iccid;
	private Text text_ip;
	private Text text_port;
	private Text txt_packet;

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Create the menu manager.
	 * 
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager("menu");
		return menuManager;
	}

	/**
	 * Create the status line manager.
	 * 
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			XEVConv window = new XEVConv();
			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Configure the shell.
	 * 
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Data Monitor Simulate Client");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(995, 790);
	}
}
