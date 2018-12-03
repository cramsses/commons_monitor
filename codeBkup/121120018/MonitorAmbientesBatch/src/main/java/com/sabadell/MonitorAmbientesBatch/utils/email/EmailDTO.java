package com.sabadell.MonitorAmbientesBatch.utils.email;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sabadell.MonitorAmbientesBatch.utils.Utils;

public class EmailDTO {
	
	private String from;

	private List<String> to;

	private List<String> cc;

	private String subject;

	private String message;
	
	private boolean isHtml;

	/*Constructors*/
	public EmailDTO() {
		this.to = new ArrayList<String>();
		this.cc = new ArrayList<String>();
	}

	public EmailDTO(String from, String toList, String subject, String message) {
		this();
		this.from = from;
		this.subject = subject;
		this.message = message;
		this.to.addAll(Arrays.asList(splitByComma(toList)));
	}

	public EmailDTO(String from, String toList, String ccList, String subject, String message) {
		this();
		this.from = from;
		this.subject = subject;
		this.message = message;
		this.to.addAll(Arrays.asList(splitByComma(toList)));
		this.cc.addAll(Arrays.asList(splitByComma(ccList)));
	}
	
	/*Getter and Setter*/
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public List<String> getTo() {
		return to;
	}

	public void setTo(List<String> to) {
		this.to = to;
	}

	public List<String> getCc() {
		return cc;
	}

	public void setCc(List<String> cc) {
		this.cc = cc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isHtml() {
		return isHtml;
	}

	public void setHtml(boolean isHtml) {
		this.isHtml = isHtml;
	}
	
	
	/*Utils*/
	private String[] splitByComma(String toMultiple) {
		String[] toSplit = toMultiple.split(",");
		return toSplit;
	}

	public String getToAsList() {
		return Utils.concatenate(this.to, ",");
	}

}
