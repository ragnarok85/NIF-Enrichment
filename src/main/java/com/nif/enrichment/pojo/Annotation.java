package com.nif.enrichment.pojo;

public class Annotation {
	private String anchorOf;
	private String uri;
	private int bindex;
	private int eindex;
	private String type;
	
	public Annotation() {
		
	}

	public String getAnchorOf() {
		return anchorOf;
	}

	public void setAnchorOf(String anchorOf) {
		this.anchorOf = anchorOf;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getBindex() {
		return bindex;
	}

	public void setBindex(int bindex) {
		this.bindex = bindex;
	}

	public int getEindex() {
		return eindex;
	}

	public void setEindex(int eindex) {
		this.eindex = eindex;
	}

	public String getType() {
		return type;
	}

	public void setType(String string) {
		this.type = string;
	}
	
	
}
