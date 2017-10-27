package com.airbnb.web.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component @Data
public class Residence {
	private String hostSerial, memberId, residenceName, adult, teen, child, price, zipcode, detailImg, infoImg, regiContent, addr;

	public String getHostSerial() {
		return hostSerial;
	}

	public void setHostSerial(String hostSerial) {
		this.hostSerial = hostSerial;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getResidenceName() {
		return residenceName;
	}

	public void setResidenceName(String residenceName) {
		this.residenceName = residenceName;
	}

	public String getAdult() {
		return adult;
	}

	public void setAdult(String adult) {
		this.adult = adult;
	}

	public String getTeen() {
		return teen;
	}

	public void setTeen(String teen) {
		this.teen = teen;
	}

	public String getChild() {
		return child;
	}

	public void setChild(String child) {
		this.child = child;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getDetailImg() {
		return detailImg;
	}

	public void setDetailImg(String detailImg) {
		this.detailImg = detailImg;
	}

	public String getInfoImg() {
		return infoImg;
	}

	public void setInfoImg(String infoImg) {
		this.infoImg = infoImg;
	}

	public String getRegiContent() {
		return regiContent;
	}

	public void setRegiContent(String regiContent) {
		this.regiContent = regiContent;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Residence [hostSerial=" + hostSerial + ", memberId=" + memberId + ", residenceName=" + residenceName
				+ ", adult=" + adult + ", teen=" + teen + ", child=" + child + ", price=" + price + ", zipcode="
				+ zipcode + ", detailImg=" + detailImg + ", infoImg=" + infoImg + ", regiContent=" + regiContent
				+ ", addr=" + addr + "]";
	}
}