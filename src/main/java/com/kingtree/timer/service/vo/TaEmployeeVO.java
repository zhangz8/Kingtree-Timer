package com.kingtree.timer.service.vo;

import java.io.Serializable;
import java.util.Date;

import com.kingtree.timer.entity.TaEmployee;
import com.kingtree.timer.entity.TaSystemUser;
import com.kingtree.timer.util.BeanUtil;

public class TaEmployeeVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 683285177224922236L;

	private int id;

	private String empid;

	private String deptid;

	private String uid;

	private String empno;

	private String status;

	private String nativ;

	private String folk;

	private String polity;

	private String eduation;

	private String graduate;

	private String speciality;

	private String idcard;

	private String address;

	private Date birthday;

	private Date joindate;

	private Date awaydate;

	private String source;

	private String techtitle;

	private String archives;

	private String idio;

	private String brief;

	private String remark;

	private String bankname;

	private String bankacct;

	private String flagdeleted;

	private String flagtrashed;

	private Date deldate;

	private String delperson;

	private Date moddate;

	private Date exdate;

	private String qq;

	private String weixin;

	private Byte housefoldflag;

	private Byte inquiryflodflag;

	private Byte contractfloadflag;

	private Byte headerflodflag;

	private Byte leftflodflag;

	private String skin;

	private Boolean flagprincipal;

	private String contactname;

	private String contacttel;

	private String refereeid;

	private String refereedeptid;

	private String mobile;

	private int companyId;

	private int storeId;

	private String userName;

	public TaEmployeeVO() {

	}

	public TaEmployeeVO(int id) {
		this.id = id;
	}

	public static TaEmployeeVO build(int id, TaEmployee taEmployee, TaSystemUser taSystemUser) {
		TaEmployeeVO taEmployeeVO = new TaEmployeeVO(id);
		BeanUtil.copyFields(taEmployeeVO, taEmployee);
		taEmployeeVO.setMobile(taSystemUser.getMobile());
		taEmployeeVO.setUserName(taSystemUser.getUsername());
		return taEmployeeVO;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid == null ? null : empid.trim();
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid == null ? null : deptid.trim();
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid == null ? null : uid.trim();
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno == null ? null : empno.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getNativ() {
		return nativ;
	}

	public void setNativ(String nativ) {
		this.nativ = nativ == null ? null : nativ.trim();
	}

	public String getFolk() {
		return folk;
	}

	public void setFolk(String folk) {
		this.folk = folk == null ? null : folk.trim();
	}

	public String getPolity() {
		return polity;
	}

	public void setPolity(String polity) {
		this.polity = polity == null ? null : polity.trim();
	}

	public String getEduation() {
		return eduation;
	}

	public void setEduation(String eduation) {
		this.eduation = eduation == null ? null : eduation.trim();
	}

	public String getGraduate() {
		return graduate;
	}

	public void setGraduate(String graduate) {
		this.graduate = graduate == null ? null : graduate.trim();
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality == null ? null : speciality.trim();
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard == null ? null : idcard.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public Date getAwaydate() {
		return awaydate;
	}

	public void setAwaydate(Date awaydate) {
		this.awaydate = awaydate;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source == null ? null : source.trim();
	}

	public String getTechtitle() {
		return techtitle;
	}

	public void setTechtitle(String techtitle) {
		this.techtitle = techtitle == null ? null : techtitle.trim();
	}

	public String getArchives() {
		return archives;
	}

	public void setArchives(String archives) {
		this.archives = archives == null ? null : archives.trim();
	}

	public String getIdio() {
		return idio;
	}

	public void setIdio(String idio) {
		this.idio = idio == null ? null : idio.trim();
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief == null ? null : brief.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname == null ? null : bankname.trim();
	}

	public String getBankacct() {
		return bankacct;
	}

	public void setBankacct(String bankacct) {
		this.bankacct = bankacct == null ? null : bankacct.trim();
	}

	public String getFlagdeleted() {
		return flagdeleted;
	}

	public void setFlagdeleted(String flagdeleted) {
		this.flagdeleted = flagdeleted == null ? null : flagdeleted.trim();
	}

	public String getFlagtrashed() {
		return flagtrashed;
	}

	public void setFlagtrashed(String flagtrashed) {
		this.flagtrashed = flagtrashed == null ? null : flagtrashed.trim();
	}

	public Date getDeldate() {
		return deldate;
	}

	public void setDeldate(Date deldate) {
		this.deldate = deldate;
	}

	public String getDelperson() {
		return delperson;
	}

	public void setDelperson(String delperson) {
		this.delperson = delperson == null ? null : delperson.trim();
	}

	public Date getModdate() {
		return moddate;
	}

	public void setModdate(Date moddate) {
		this.moddate = moddate;
	}

	public Date getExdate() {
		return exdate;
	}

	public void setExdate(Date exdate) {
		this.exdate = exdate;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq == null ? null : qq.trim();
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin == null ? null : weixin.trim();
	}

	public Byte getHousefoldflag() {
		return housefoldflag;
	}

	public void setHousefoldflag(Byte housefoldflag) {
		this.housefoldflag = housefoldflag;
	}

	public Byte getInquiryflodflag() {
		return inquiryflodflag;
	}

	public void setInquiryflodflag(Byte inquiryflodflag) {
		this.inquiryflodflag = inquiryflodflag;
	}

	public Byte getContractfloadflag() {
		return contractfloadflag;
	}

	public void setContractfloadflag(Byte contractfloadflag) {
		this.contractfloadflag = contractfloadflag;
	}

	public Byte getHeaderflodflag() {
		return headerflodflag;
	}

	public void setHeaderflodflag(Byte headerflodflag) {
		this.headerflodflag = headerflodflag;
	}

	public Byte getLeftflodflag() {
		return leftflodflag;
	}

	public void setLeftflodflag(Byte leftflodflag) {
		this.leftflodflag = leftflodflag;
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin == null ? null : skin.trim();
	}

	public Boolean getFlagprincipal() {
		return flagprincipal;
	}

	public void setFlagprincipal(Boolean flagprincipal) {
		this.flagprincipal = flagprincipal;
	}

	public String getContactname() {
		return contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname == null ? null : contactname.trim();
	}

	public String getContacttel() {
		return contacttel;
	}

	public void setContacttel(String contacttel) {
		this.contacttel = contacttel == null ? null : contacttel.trim();
	}

	public String getRefereeid() {
		return refereeid;
	}

	public void setRefereeid(String refereeid) {
		this.refereeid = refereeid == null ? null : refereeid.trim();
	}

	public String getRefereedeptid() {
		return refereedeptid;
	}

	public void setRefereedeptid(String refereedeptid) {
		this.refereedeptid = refereedeptid == null ? null : refereedeptid.trim();
	}

}
