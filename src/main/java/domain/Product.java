package domain;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.web.multipart.MultipartFile;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	private int productid;
	private String productname;
	private String brand;
	private String symbolbrand;
	private String gendertype;
	private String machinetype;
	
	@NotNull(message = "Diameter could not be null")
	@Min(value = 30, message = "Diameter must be equal or greater than 30")
	@Max(value = 45, message = "Diameter must be equal or less than 48")	
	private Byte diameter;
	
	private String status;
	
	@NotNull(message = "Discount Percent could not be null")
	@Min(value = 0, message = "Discount Percent must be equal or greater than 0")
	@Max(value = 100, message = "Discount Percent must be equal or less than 100")
	private Byte discountpercent;
	
	private Integer discountprice;
	
	@NotNull(message = "Product Price could not be null")
	@Positive(message = "Product Price must be a positive number")
	private Integer oldprice;
	
	@NotBlank(message = "This Field could not be null")
	private String glass;
	
	@NotBlank(message = "This Field could not be null")
	private String material;
	@NotBlank(message = "This Field could not be null")
	private String original;
	private String image;
	private MultipartFile temporarysaveimg;

	
	public MultipartFile getTemporarysaveimg() {
		return temporarysaveimg;
	}

	public void setTemporarysaveimg(MultipartFile temporarysaveimg) {
		this.temporarysaveimg = temporarysaveimg;
	}

	public Product() {
		super();
	}

	public Product(int productid, String productname, String brand, String symbolbrand, String gendertype,
			String machinetype, Byte diameter, String status, Byte discountpercent, Integer discountprice, Integer oldprice,
			String glass, String material, String original, String image, MultipartFile temporarysaveimg) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.brand = brand;
		this.symbolbrand = symbolbrand;
		this.gendertype = gendertype;
		this.machinetype = machinetype;
		this.diameter = diameter;
		this.status = status;
		this.discountpercent = discountpercent;
		this.discountprice = discountprice;
		this.oldprice = oldprice;
		this.glass = glass;
		this.material = material;
		this.original = original;
		this.image = image;
		this.temporarysaveimg = temporarysaveimg;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSymbolbrand() {
		return symbolbrand;
	}

	public void setSymbolbrand(String symbolbrand) {
		this.symbolbrand = symbolbrand;
	}

	public String getGendertype() {
		return gendertype;
	}

	public void setGendertype(String gendertype) {
		this.gendertype = gendertype;
	}

	public String getMachinetype() {
		return machinetype;
	}

	public void setMachinetype(String machinetype) {
		this.machinetype = machinetype;
	}

	public Byte getDiameter() {
		return diameter;
	}

	public void setDiameter(Byte diameter) {
		this.diameter = diameter;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Byte getDiscountpercent() {
		return discountpercent;
	}

	public void setDiscountpercent(Byte discountpercent) {
		this.discountpercent = discountpercent;
	}

	public Integer getDiscountprice() {
		return discountprice;
	}

	public void setDiscountprice(Integer discountprice) {
		this.discountprice = discountprice;
	}

	public Integer getOldprice() {
		return oldprice;
	}

	public void setOldprice(Integer oldprice) {
		this.oldprice = oldprice;
	}

	public String getGlass() {
		return glass;
	}

	public void setGlass(String glass) {
		this.glass = glass;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + ", brand=" + brand
				+ ", symbolbrand=" + symbolbrand + ", gendertype=" + gendertype + ", machinetype=" + machinetype
				+ ", diameter=" + diameter + ", status=" + status + ", discountpercent=" + discountpercent
				+ ", discountprice=" + discountprice + ", oldprice=" + oldprice + ", glass=" + glass + ", material="
				+ material + ", original=" + original + ", image=" + image + "]";
	}

}