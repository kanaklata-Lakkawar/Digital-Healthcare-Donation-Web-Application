package model;

public class Medicine {
private int medId;
private String ngo;
private String brand;
private String generic;
private int qty;
private String add;

private String senderMail;
private String mob;

public int getMedId() {
	return medId;
}

public void setMedId(int medId) {
	this.medId = medId;
}

public String getNgo() {
	return ngo;
}

public void setNgo(String ngo) {
	this.ngo = ngo;
}

public String getBrand() {
	return brand;
}

public void setBrand(String brand) {
	this.brand = brand;
}

public String getGeneric() {
	return generic;
}

public void setGeneric(String generic) {
	this.generic = generic;
}

public int getQty() {
	return qty;
}

public void setQty(int qty) {
	this.qty = qty;
}

public String getAdd() {
	return add;
}

public void setAdd(String add) {
	this.add = add;
}

public String getSenderMail() {
	return senderMail;
}

public void setSenderMail(String senderMail) {
	this.senderMail = senderMail;
}

public String getMob() {
	return mob;
}

public void setMob(String mob) {
	this.mob = mob;
}

public Medicine(int medId, String ngo, String brand, String generic, int qty, String add) {
	super();
	this.medId = medId;
	this.ngo = ngo;
	this.brand = brand;
	this.generic = generic;
	this.qty = qty;
	this.add = add;
}

public Medicine(int medId, String ngo, String brand, String generic, int qty, String add, String senderMail, String mob) {
	super();
	this.medId = medId;
	this.ngo = ngo;
	this.brand = brand;
	this.generic = generic;
	this.qty = qty;
	this.add = add;
	this.senderMail= senderMail;
	this.mob=mob;
}
}
