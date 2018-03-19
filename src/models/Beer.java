package models;

public class Beer {
	private String name;
	private String type;
	private Double ibu;
	
	public Beer() {
		this.name		="";
		this.type		="";
		this.ibu		=null;
	}
	
	public Beer(String name, String type,Double ibu) {
		this.name	=name;
		this.type	=type;
		this.ibu	=ibu;
	}
	
	public Beer(Beer Beer) {
		this.name	=Beer.getName();
		this.type	=Beer.getType();
		this.ibu	=Beer.getIbu();
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setType(String type) {
		this.type=type;
	}
	
	public void setIbu(Double ibu) {
		this.ibu=ibu;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}
	
	public Double getIbu(){
		return this.ibu;
	}
	
}
