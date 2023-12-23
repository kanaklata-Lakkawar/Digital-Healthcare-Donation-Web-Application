package model;

public class Donar {
	private int donorId;
	private String donor;
	private String brand;
	private String generic;
	private int qty;
	private String ngo;
	private String MftDt;
	private String ExpDt;
	private String imageName;
	
	
	public String getNgo() {
		return ngo;
	}
	public void setNgo(String ngo) {
		this.ngo = ngo;
	}
	public int getDonorId() {
		return donorId;
	}
	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}
	public String getDonor() {
		return donor;
	}
	public void setDonor(String donor) {
		this.donor = donor;
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
	
	public String getMftDt() {
		return MftDt;
	}
	public void setMftDt(String mftDt) {
		MftDt = mftDt;
	}
	public String getExpDt() {
		return ExpDt;
	}
	public void setExpDt(String expDt) {
		ExpDt = expDt;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public Donar(int donorId, String donor,String ngo, String brand, String generic, int qty, String mftDt,
			String expDt, String imageName) {
		super();
		this.donorId = donorId;
		this.donor = donor;
		this.ngo =ngo;
		this.brand = brand;
		this.generic = generic;
		this.qty = qty;
		
		MftDt = mftDt;
		ExpDt = expDt;
		this.imageName = imageName;
	}
	

}
