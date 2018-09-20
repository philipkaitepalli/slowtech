package org.jc.kp.model;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service("CalService")
public class CalService   {
	private String fp;
	private String sp;
	private Integer fd;
	private Integer sd;
	private Integer nop;
	private Float total;
	private String dt;
	
	private Float percent; 
	public CalService() {}
	public String getFp() {
		return fp;
	}
	public void setFp(String fp) {
		this.fp = fp;
	}
	public String getSp() {
		return sp;
	}
	public void setSp(String sp) {
		this.sp = sp;
	}
	public Integer getFd() {
		return fd;
	}
	public void setFd(Integer fd) {
		this.fd = fd;
	}
	public Integer getSd() {
		return sd;
	}
	public void setSd(Integer sd) {
		this.sd = sd;
	}
	public Integer getNop() {
		return nop;
	}
	public void setNop(Integer nop) {
		this.nop = nop;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public Float getPercent() {
		return percent;
	}
	public void setPercent(Float percent) {
		this.percent = percent;
	}
	
		

}
