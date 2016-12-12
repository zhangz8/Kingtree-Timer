package com.kingtree.timer.service.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kingtree.timer.entity.TaHouse;
import com.kingtree.timer.util.BeanUtil;

public class TaHouseVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5314091239167718511L;

	private int id;

	private int userId;

	private String houseid;

	private String hwid;

	private String propertyno;

	private String cityname;

	private String districtname;

	private String piceareaid;

	private String estid;

	private String buildingid;

	private String unitid;

	private String roomno;

	private String floor;

	private String floorall;

	private String countf;

	private String countt;

	private String countw;

	private String county;

	private String housegrade;

	private String propertyusage;

	private String propertytype;

	private String tradetype;

	private String propertysource;

	private String tradestatus;

	private String propertylook;

	private String keyno;

	private String trustmethod;

	private Date trustdate;

	private String trustno;

	private Date handoverdate;

	private BigDecimal square;

	private BigDecimal squareuser;

	private String propertydirction;

	private String completeyear;

	private String propertyoccupy;

	private String propertydecoration;

	private String propertyown;

	private String propertycertificate;

	private String idcard;

	private Date documentsdate;

	private String remark;

	private Date lastfollowdate;

	private Date lastguideviewdate;

	private Boolean tooutside;
	/** 房源标题 */
	private String title;

	private String workflowstatus;

	private String introauditstatus;

	private String regperson;

	private Date regdate;

	private String modperson;

	private Date moddate;

	private Boolean flagtrashed;

	private Boolean flagdeleted;

	private String delperson;

	private Date deldate;

	private Integer photocount;

	private String coverphoto;

	private Integer statisticshouse;

	private String privy;

	private String gsempid;

	private String gsempname;

	private String gsdeptid;

	private String gsdeptname;

	private String gsreason;

	private String qualityhouse;

	private String length;

	private String width;

	private String height;

	private String plan;

	private String plantcondition;

	private String displacement;

	private String position;

	private String basementtype;

	private String industry;

	private String officelevel;

	private BigDecimal effectiverate;

	private BigDecimal monthlyfee;

	private Integer viewnum;

	private Boolean flagrecommend;

	private String turnstatus;

	private String idcardaddr;

	private String propdesc;

	private Long verlock;

	private String residentflag;

	private Date privydate;

	private String layoutImg;

	private boolean isOffLine;

	private List<String> innerImgList = new ArrayList<String>();

	public String getLayoutImg() {
		return layoutImg;
	}

	public void setLayoutImg(String layoutImg) {
		this.layoutImg = layoutImg;
	}

	public TaHouseVO() {
	}

	public TaHouseVO(int id) {
		this.id = id;
	}

	public static TaHouseVO build(int id, TaHouse taHouse) {
		TaHouseVO taHouseVO = new TaHouseVO(id);
		BeanUtil.copyFields(taHouseVO, taHouse);
		return taHouseVO;
	}

	public boolean getIsOffLine() {
		return isOffLine;
	}

	public List<String> getInnerImgList() {
		return innerImgList;
	}

	public void setInnerImgList(List<String> innerImgList) {
		this.innerImgList = innerImgList;
	}

	public void setIsOffLine(boolean isOffLine) {
		this.isOffLine = isOffLine;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHouseid() {
		return houseid;
	}

	public void setHouseid(String houseid) {
		this.houseid = houseid == null ? null : houseid.trim();
	}

	public String getHwid() {
		return hwid;
	}

	public void setHwid(String hwid) {
		this.hwid = hwid == null ? null : hwid.trim();
	}

	public String getPropertyno() {
		return propertyno;
	}

	public void setPropertyno(String propertyno) {
		this.propertyno = propertyno == null ? null : propertyno.trim();
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname == null ? null : cityname.trim();
	}

	public String getDistrictname() {
		return districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname == null ? null : districtname.trim();
	}

	public String getPiceareaid() {
		return piceareaid;
	}

	public void setPiceareaid(String piceareaid) {
		this.piceareaid = piceareaid == null ? null : piceareaid.trim();
	}

	public String getEstid() {
		return estid;
	}

	public void setEstid(String estid) {
		this.estid = estid == null ? null : estid.trim();
	}

	public String getBuildingid() {
		return buildingid;
	}

	public void setBuildingid(String buildingid) {
		this.buildingid = buildingid == null ? null : buildingid.trim();
	}

	public String getUnitid() {
		return unitid;
	}

	public void setUnitid(String unitid) {
		this.unitid = unitid == null ? null : unitid.trim();
	}

	public String getRoomno() {
		return roomno;
	}

	public void setRoomno(String roomno) {
		this.roomno = roomno == null ? null : roomno.trim();
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor == null ? null : floor.trim();
	}

	public String getFloorall() {
		return floorall;
	}

	public void setFloorall(String floorall) {
		this.floorall = floorall == null ? null : floorall.trim();
	}

	public String getCountf() {
		return countf;
	}

	public void setCountf(String countf) {
		this.countf = countf == null ? null : countf.trim();
	}

	public String getCountt() {
		return countt;
	}

	public void setCountt(String countt) {
		this.countt = countt == null ? null : countt.trim();
	}

	public String getCountw() {
		return countw;
	}

	public void setCountw(String countw) {
		this.countw = countw == null ? null : countw.trim();
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county == null ? null : county.trim();
	}

	public String getHousegrade() {
		return housegrade;
	}

	public void setHousegrade(String housegrade) {
		this.housegrade = housegrade == null ? null : housegrade.trim();
	}

	public String getPropertyusage() {
		return propertyusage;
	}

	public void setPropertyusage(String propertyusage) {
		this.propertyusage = propertyusage == null ? null : propertyusage.trim();
	}

	public String getPropertytype() {
		return propertytype;
	}

	public void setPropertytype(String propertytype) {
		this.propertytype = propertytype == null ? null : propertytype.trim();
	}

	public String getTradetype() {
		return tradetype;
	}

	public void setTradetype(String tradetype) {
		this.tradetype = tradetype == null ? null : tradetype.trim();
	}

	public String getPropertysource() {
		return propertysource;
	}

	public void setPropertysource(String propertysource) {
		this.propertysource = propertysource == null ? null : propertysource.trim();
	}

	public String getTradestatus() {
		return tradestatus;
	}

	public void setTradestatus(String tradestatus) {
		this.tradestatus = tradestatus == null ? null : tradestatus.trim();
	}

	public String getPropertylook() {
		return propertylook;
	}

	public void setPropertylook(String propertylook) {
		this.propertylook = propertylook == null ? null : propertylook.trim();
	}

	public String getKeyno() {
		return keyno;
	}

	public void setKeyno(String keyno) {
		this.keyno = keyno == null ? null : keyno.trim();
	}

	public String getTrustmethod() {
		return trustmethod;
	}

	public void setTrustmethod(String trustmethod) {
		this.trustmethod = trustmethod == null ? null : trustmethod.trim();
	}

	public Date getTrustdate() {
		return trustdate;
	}

	public void setTrustdate(Date trustdate) {
		this.trustdate = trustdate;
	}

	public String getTrustno() {
		return trustno;
	}

	public void setTrustno(String trustno) {
		this.trustno = trustno == null ? null : trustno.trim();
	}

	public Date getHandoverdate() {
		return handoverdate;
	}

	public void setHandoverdate(Date handoverdate) {
		this.handoverdate = handoverdate;
	}

	public BigDecimal getSquare() {
		return square;
	}

	public void setSquare(BigDecimal square) {
		this.square = square;
	}

	public BigDecimal getSquareuser() {
		return squareuser;
	}

	public void setSquareuser(BigDecimal squareuser) {
		this.squareuser = squareuser;
	}

	public String getPropertydirction() {
		return propertydirction;
	}

	public void setPropertydirction(String propertydirction) {
		this.propertydirction = propertydirction == null ? null : propertydirction.trim();
	}

	public String getCompleteyear() {
		return completeyear;
	}

	public void setCompleteyear(String completeyear) {
		this.completeyear = completeyear == null ? null : completeyear.trim();
	}

	public String getPropertyoccupy() {
		return propertyoccupy;
	}

	public void setPropertyoccupy(String propertyoccupy) {
		this.propertyoccupy = propertyoccupy == null ? null : propertyoccupy.trim();
	}

	public String getPropertydecoration() {
		return propertydecoration;
	}

	public void setPropertydecoration(String propertydecoration) {
		this.propertydecoration = propertydecoration == null ? null : propertydecoration.trim();
	}

	public String getPropertyown() {
		return propertyown;
	}

	public void setPropertyown(String propertyown) {
		this.propertyown = propertyown == null ? null : propertyown.trim();
	}

	public String getPropertycertificate() {
		return propertycertificate;
	}

	public void setPropertycertificate(String propertycertificate) {
		this.propertycertificate = propertycertificate == null ? null : propertycertificate.trim();
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard == null ? null : idcard.trim();
	}

	public Date getDocumentsdate() {
		return documentsdate;
	}

	public void setDocumentsdate(Date documentsdate) {
		this.documentsdate = documentsdate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Date getLastfollowdate() {
		return lastfollowdate;
	}

	public void setLastfollowdate(Date lastfollowdate) {
		this.lastfollowdate = lastfollowdate;
	}

	public Date getLastguideviewdate() {
		return lastguideviewdate;
	}

	public void setLastguideviewdate(Date lastguideviewdate) {
		this.lastguideviewdate = lastguideviewdate;
	}

	public Boolean getTooutside() {
		return tooutside;
	}

	public void setTooutside(Boolean tooutside) {
		this.tooutside = tooutside;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getWorkflowstatus() {
		return workflowstatus;
	}

	public void setWorkflowstatus(String workflowstatus) {
		this.workflowstatus = workflowstatus == null ? null : workflowstatus.trim();
	}

	public String getIntroauditstatus() {
		return introauditstatus;
	}

	public void setIntroauditstatus(String introauditstatus) {
		this.introauditstatus = introauditstatus == null ? null : introauditstatus.trim();
	}

	public String getRegperson() {
		return regperson;
	}

	public void setRegperson(String regperson) {
		this.regperson = regperson == null ? null : regperson.trim();
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getModperson() {
		return modperson;
	}

	public void setModperson(String modperson) {
		this.modperson = modperson == null ? null : modperson.trim();
	}

	public Date getModdate() {
		return moddate;
	}

	public void setModdate(Date moddate) {
		this.moddate = moddate;
	}

	public Boolean getFlagtrashed() {
		return flagtrashed;
	}

	public void setFlagtrashed(Boolean flagtrashed) {
		this.flagtrashed = flagtrashed;
	}

	public Boolean getFlagdeleted() {
		return flagdeleted;
	}

	public void setFlagdeleted(Boolean flagdeleted) {
		this.flagdeleted = flagdeleted;
	}

	public String getDelperson() {
		return delperson;
	}

	public void setDelperson(String delperson) {
		this.delperson = delperson == null ? null : delperson.trim();
	}

	public Date getDeldate() {
		return deldate;
	}

	public void setDeldate(Date deldate) {
		this.deldate = deldate;
	}

	public Integer getPhotocount() {
		return photocount;
	}

	public void setPhotocount(Integer photocount) {
		this.photocount = photocount;
	}

	public String getCoverphoto() {
		return coverphoto;
	}

	public void setCoverphoto(String coverphoto) {
		this.coverphoto = coverphoto == null ? null : coverphoto.trim();
	}

	public Integer getStatisticshouse() {
		return statisticshouse;
	}

	public void setStatisticshouse(Integer statisticshouse) {
		this.statisticshouse = statisticshouse;
	}

	public String getPrivy() {
		return privy;
	}

	public void setPrivy(String privy) {
		this.privy = privy == null ? null : privy.trim();
	}

	public String getGsempid() {
		return gsempid;
	}

	public void setGsempid(String gsempid) {
		this.gsempid = gsempid == null ? null : gsempid.trim();
	}

	public String getGsempname() {
		return gsempname;
	}

	public void setGsempname(String gsempname) {
		this.gsempname = gsempname == null ? null : gsempname.trim();
	}

	public String getGsdeptid() {
		return gsdeptid;
	}

	public void setGsdeptid(String gsdeptid) {
		this.gsdeptid = gsdeptid == null ? null : gsdeptid.trim();
	}

	public String getGsdeptname() {
		return gsdeptname;
	}

	public void setGsdeptname(String gsdeptname) {
		this.gsdeptname = gsdeptname == null ? null : gsdeptname.trim();
	}

	public String getGsreason() {
		return gsreason;
	}

	public void setGsreason(String gsreason) {
		this.gsreason = gsreason == null ? null : gsreason.trim();
	}

	public String getQualityhouse() {
		return qualityhouse;
	}

	public void setQualityhouse(String qualityhouse) {
		this.qualityhouse = qualityhouse == null ? null : qualityhouse.trim();
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length == null ? null : length.trim();
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width == null ? null : width.trim();
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height == null ? null : height.trim();
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan == null ? null : plan.trim();
	}

	public String getPlantcondition() {
		return plantcondition;
	}

	public void setPlantcondition(String plantcondition) {
		this.plantcondition = plantcondition == null ? null : plantcondition.trim();
	}

	public String getDisplacement() {
		return displacement;
	}

	public void setDisplacement(String displacement) {
		this.displacement = displacement == null ? null : displacement.trim();
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position == null ? null : position.trim();
	}

	public String getBasementtype() {
		return basementtype;
	}

	public void setBasementtype(String basementtype) {
		this.basementtype = basementtype == null ? null : basementtype.trim();
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry == null ? null : industry.trim();
	}

	public String getOfficelevel() {
		return officelevel;
	}

	public void setOfficelevel(String officelevel) {
		this.officelevel = officelevel == null ? null : officelevel.trim();
	}

	public BigDecimal getEffectiverate() {
		return effectiverate;
	}

	public void setEffectiverate(BigDecimal effectiverate) {
		this.effectiverate = effectiverate;
	}

	public BigDecimal getMonthlyfee() {
		return monthlyfee;
	}

	public void setMonthlyfee(BigDecimal monthlyfee) {
		this.monthlyfee = monthlyfee;
	}

	public Integer getViewnum() {
		return viewnum;
	}

	public void setViewnum(Integer viewnum) {
		this.viewnum = viewnum;
	}

	public Boolean getFlagrecommend() {
		return flagrecommend;
	}

	public void setFlagrecommend(Boolean flagrecommend) {
		this.flagrecommend = flagrecommend;
	}

	public String getTurnstatus() {
		return turnstatus;
	}

	public void setTurnstatus(String turnstatus) {
		this.turnstatus = turnstatus == null ? null : turnstatus.trim();
	}

	public String getIdcardaddr() {
		return idcardaddr;
	}

	public void setIdcardaddr(String idcardaddr) {
		this.idcardaddr = idcardaddr == null ? null : idcardaddr.trim();
	}

	public String getPropdesc() {
		return propdesc;
	}

	public void setPropdesc(String propdesc) {
		this.propdesc = propdesc == null ? null : propdesc.trim();
	}

	public Long getVerlock() {
		return verlock;
	}

	public void setVerlock(Long verlock) {
		this.verlock = verlock;
	}

	public String getResidentflag() {
		return residentflag;
	}

	public void setResidentflag(String residentflag) {
		this.residentflag = residentflag == null ? null : residentflag.trim();
	}

	public Date getPrivydate() {
		return privydate;
	}

	public void setPrivydate(Date privydate) {
		this.privydate = privydate;
	}
}
