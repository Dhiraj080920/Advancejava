package com.demo.beans;

public class Product {
 private int pid;
 private String pname;
 private int qty;
 private float price;
public Product() {
	super();
	System.out.println(" in product default constructor ");
}
public Product(int pid, String pname, int qty, float price) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.qty = qty;
	this.price = price;
}
public int getPid() {
	System.out.println(" in getpid ");
	return pid;
}
public void setPid(int pid) {
	System.out.println(" in setpid ");
	this.pid = pid;
}
public String getPname() {
	System.out.println(" in getpname ");
	return pname;
}
public void setPname(String pname) {
	System.out.println(" in setpname ");
	this.pname = pname;
}
public int getQty() {
	System.out.println(" in getqty ");
	return qty;
}
public void setQty(int qty) {
	System.out.println(" in setqty ");
	this.qty = qty;
}
public float getPrice() {
	System.out.println(" in getprice ");
	return price;
}
public void setPrice(float price) {
	System.out.println(" in setprice ");
	this.price = price;
}
@Override
public String toString() {
	return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", price=" + price + "]";
}
 
}
