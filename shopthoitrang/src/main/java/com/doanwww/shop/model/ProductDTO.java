package com.doanwww.shop.model;

public class ProductDTO {
	private int id;
	private String name;
	private float price;
	private String  image;
	private String  description;
	private ColorDTO colorDTO;
	private CategoryDTO categoryDTO;
	private TrademarkDTO tradeMarkDTO;
	private SizeDTO sizeDTO;
	private GenderDTO genderDTO;
	private int count;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ColorDTO getColorDTO() {
		return colorDTO;
	}

	public void setColorDTO(ColorDTO colorDTO) {
		this.colorDTO = colorDTO;
	}

	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}

	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}

	public TrademarkDTO getTradeMarkDTO() {
		return tradeMarkDTO;
	}

	public void setTradeMarkDTO(TrademarkDTO tradeMarkDTO) {
		this.tradeMarkDTO = tradeMarkDTO;
	}

	public SizeDTO getSizeDTO() {
		return sizeDTO;
	}

	public void setSizeDTO(SizeDTO sizeDTO) {
		this.sizeDTO = sizeDTO;
	}

	public GenderDTO getGenderDTO() {
		return genderDTO;
	}

	public void setGenderDTO(GenderDTO genderDTO) {
		this.genderDTO = genderDTO;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}
}
