package com.kingtree.timer.service.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.kingtree.timer.entity.TaEstate;
import com.kingtree.timer.util.BeanUtil;

public class TaEstateVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3487035564985557611L;

	private int id;

	private String estateid;

	private String areaid;

	private String estatename;

	private String spell;

	private String propertyusage;

	private String propertytype;

	private String estatenamea;

	private String completeyear;

	private String ownyear;

	private String surplusownyear;

	private String bulidingnum;

	private String address;

	private String addressd;

	private BigDecimal price;

	private BigDecimal mgtprice;

	private String remark;

	private String flaglock;

	private String buildingrule;

	private String roomrule;

	private String roomruleex;

	private BigDecimal square;

	private Integer room;

	private String framework;

	private String surface;

	private String landgrade;

	private String landno;

	private String devcompany;

	private String devtel;

	private String mgtcompany;

	private String mgttel;

	private String estatenamee;

	private String addresse;

	private String transportation;

	private String education;

	private String hospital;

	private String bank;

	private String otherenv;

	private BigDecimal cox;

	private BigDecimal coy;

	private Date opendate;

	private Date moddate;

	private String flagdeleted;

	private String flagtrashed;

	private Date deldate;

	private String delperson;

	private String estatetype;

	private String estatetx;

	private Date exdate;

	private String viewflag;

	private String lockflag;

	private String floorrule;

	private String chooseroomnoflag;

	private String newflag;

	private String ringrroute;

	private String subway;

	private String startnumrang;

	private String endnumrang;

	private String startletterrang;

	private String endletterrang;

	private String dutyflag;

	private BigDecimal coxmax;

	private BigDecimal coymax;

	private String coverphoto;

	private String developers;

	private BigDecimal planningarea;

	private String stall;

	private BigDecimal plotratio;

	private BigDecimal greeningrate;

	private String pmurl;

	private Boolean flagrecommend;

	private String regperson;

	private Date regdate;

	private BigDecimal caradminfee;

	private BigDecimal carrent;

	private String mgtunit;

	private Date launchdate;

	private String preferential;

	private BigDecimal pricemin;

	private BigDecimal liftprice;

	private String description;

	public TaEstateVO() {
	}

	public TaEstateVO(int id) {
		this.id = id;
	}

	public static TaEstateVO build(int id, TaEstate taEstate) {
		TaEstateVO taEstateVO = new TaEstateVO(id);
		BeanUtil.copyFields(taEstateVO, taEstate);
		return taEstateVO;
	}

	public String getEstateid() {
		return estateid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEstateid(String estateid) {
		this.estateid = estateid == null ? null : estateid.trim();
	}

	public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid == null ? null : areaid.trim();
	}

	public String getEstatename() {
		return estatename;
	}

	public void setEstatename(String estatename) {
		this.estatename = estatename == null ? null : estatename.trim();
	}

	public String getSpell() {
		return spell;
	}

	public void setSpell(String spell) {
		this.spell = spell == null ? null : spell.trim();
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

	public String getEstatenamea() {
		return estatenamea;
	}

	public void setEstatenamea(String estatenamea) {
		this.estatenamea = estatenamea == null ? null : estatenamea.trim();
	}

	public String getCompleteyear() {
		return completeyear;
	}

	public void setCompleteyear(String completeyear) {
		this.completeyear = completeyear == null ? null : completeyear.trim();
	}

	public String getOwnyear() {
		return ownyear;
	}

	public void setOwnyear(String ownyear) {
		this.ownyear = ownyear == null ? null : ownyear.trim();
	}

	public String getSurplusownyear() {
		return surplusownyear;
	}

	public void setSurplusownyear(String surplusownyear) {
		this.surplusownyear = surplusownyear == null ? null : surplusownyear.trim();
	}

	public String getBulidingnum() {
		return bulidingnum;
	}

	public void setBulidingnum(String bulidingnum) {
		this.bulidingnum = bulidingnum == null ? null : bulidingnum.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getAddressd() {
		return addressd;
	}

	public void setAddressd(String addressd) {
		this.addressd = addressd == null ? null : addressd.trim();
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getMgtprice() {
		return mgtprice;
	}

	public void setMgtprice(BigDecimal mgtprice) {
		this.mgtprice = mgtprice;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getFlaglock() {
		return flaglock;
	}

	public void setFlaglock(String flaglock) {
		this.flaglock = flaglock == null ? null : flaglock.trim();
	}

	public String getBuildingrule() {
		return buildingrule;
	}

	public void setBuildingrule(String buildingrule) {
		this.buildingrule = buildingrule == null ? null : buildingrule.trim();
	}

	public String getRoomrule() {
		return roomrule;
	}

	public void setRoomrule(String roomrule) {
		this.roomrule = roomrule == null ? null : roomrule.trim();
	}

	public String getRoomruleex() {
		return roomruleex;
	}

	public void setRoomruleex(String roomruleex) {
		this.roomruleex = roomruleex == null ? null : roomruleex.trim();
	}

	public BigDecimal getSquare() {
		return square;
	}

	public void setSquare(BigDecimal square) {
		this.square = square;
	}

	public Integer getRoom() {
		return room;
	}

	public void setRoom(Integer room) {
		this.room = room;
	}

	public String getFramework() {
		return framework;
	}

	public void setFramework(String framework) {
		this.framework = framework == null ? null : framework.trim();
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface == null ? null : surface.trim();
	}

	public String getLandgrade() {
		return landgrade;
	}

	public void setLandgrade(String landgrade) {
		this.landgrade = landgrade == null ? null : landgrade.trim();
	}

	public String getLandno() {
		return landno;
	}

	public void setLandno(String landno) {
		this.landno = landno == null ? null : landno.trim();
	}

	public String getDevcompany() {
		return devcompany;
	}

	public void setDevcompany(String devcompany) {
		this.devcompany = devcompany == null ? null : devcompany.trim();
	}

	public String getDevtel() {
		return devtel;
	}

	public void setDevtel(String devtel) {
		this.devtel = devtel == null ? null : devtel.trim();
	}

	public String getMgtcompany() {
		return mgtcompany;
	}

	public void setMgtcompany(String mgtcompany) {
		this.mgtcompany = mgtcompany == null ? null : mgtcompany.trim();
	}

	public String getMgttel() {
		return mgttel;
	}

	public void setMgttel(String mgttel) {
		this.mgttel = mgttel == null ? null : mgttel.trim();
	}

	public String getEstatenamee() {
		return estatenamee;
	}

	public void setEstatenamee(String estatenamee) {
		this.estatenamee = estatenamee == null ? null : estatenamee.trim();
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse == null ? null : addresse.trim();
	}

	public String getTransportation() {
		return transportation;
	}

	public void setTransportation(String transportation) {
		this.transportation = transportation == null ? null : transportation.trim();
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education == null ? null : education.trim();
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital == null ? null : hospital.trim();
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank == null ? null : bank.trim();
	}

	public String getOtherenv() {
		return otherenv;
	}

	public void setOtherenv(String otherenv) {
		this.otherenv = otherenv == null ? null : otherenv.trim();
	}

	public BigDecimal getCox() {
		return cox;
	}

	public void setCox(BigDecimal cox) {
		this.cox = cox;
	}

	public BigDecimal getCoy() {
		return coy;
	}

	public void setCoy(BigDecimal coy) {
		this.coy = coy;
	}

	public Date getOpendate() {
		return opendate;
	}

	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}

	public Date getModdate() {
		return moddate;
	}

	public void setModdate(Date moddate) {
		this.moddate = moddate;
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

	public String getEstatetype() {
		return estatetype;
	}

	public void setEstatetype(String estatetype) {
		this.estatetype = estatetype == null ? null : estatetype.trim();
	}

	public String getEstatetx() {
		return estatetx;
	}

	public void setEstatetx(String estatetx) {
		this.estatetx = estatetx == null ? null : estatetx.trim();
	}

	public Date getExdate() {
		return exdate;
	}

	public void setExdate(Date exdate) {
		this.exdate = exdate;
	}

	public String getViewflag() {
		return viewflag;
	}

	public void setViewflag(String viewflag) {
		this.viewflag = viewflag == null ? null : viewflag.trim();
	}

	public String getLockflag() {
		return lockflag;
	}

	public void setLockflag(String lockflag) {
		this.lockflag = lockflag == null ? null : lockflag.trim();
	}

	public String getFloorrule() {
		return floorrule;
	}

	public void setFloorrule(String floorrule) {
		this.floorrule = floorrule == null ? null : floorrule.trim();
	}

	public String getChooseroomnoflag() {
		return chooseroomnoflag;
	}

	public void setChooseroomnoflag(String chooseroomnoflag) {
		this.chooseroomnoflag = chooseroomnoflag == null ? null : chooseroomnoflag.trim();
	}

	public String getNewflag() {
		return newflag;
	}

	public void setNewflag(String newflag) {
		this.newflag = newflag == null ? null : newflag.trim();
	}

	public String getRingrroute() {
		return ringrroute;
	}

	public void setRingrroute(String ringrroute) {
		this.ringrroute = ringrroute == null ? null : ringrroute.trim();
	}

	public String getSubway() {
		return subway;
	}

	public void setSubway(String subway) {
		this.subway = subway == null ? null : subway.trim();
	}

	public String getStartnumrang() {
		return startnumrang;
	}

	public void setStartnumrang(String startnumrang) {
		this.startnumrang = startnumrang == null ? null : startnumrang.trim();
	}

	public String getEndnumrang() {
		return endnumrang;
	}

	public void setEndnumrang(String endnumrang) {
		this.endnumrang = endnumrang == null ? null : endnumrang.trim();
	}

	public String getStartletterrang() {
		return startletterrang;
	}

	public void setStartletterrang(String startletterrang) {
		this.startletterrang = startletterrang == null ? null : startletterrang.trim();
	}

	public String getEndletterrang() {
		return endletterrang;
	}

	public void setEndletterrang(String endletterrang) {
		this.endletterrang = endletterrang == null ? null : endletterrang.trim();
	}

	public String getDutyflag() {
		return dutyflag;
	}

	public void setDutyflag(String dutyflag) {
		this.dutyflag = dutyflag == null ? null : dutyflag.trim();
	}

	public BigDecimal getCoxmax() {
		return coxmax;
	}

	public void setCoxmax(BigDecimal coxmax) {
		this.coxmax = coxmax;
	}

	public BigDecimal getCoymax() {
		return coymax;
	}

	public void setCoymax(BigDecimal coymax) {
		this.coymax = coymax;
	}

	public String getCoverphoto() {
		return coverphoto;
	}

	public void setCoverphoto(String coverphoto) {
		this.coverphoto = coverphoto == null ? null : coverphoto.trim();
	}

	public String getDevelopers() {
		return developers;
	}

	public void setDevelopers(String developers) {
		this.developers = developers == null ? null : developers.trim();
	}

	public BigDecimal getPlanningarea() {
		return planningarea;
	}

	public void setPlanningarea(BigDecimal planningarea) {
		this.planningarea = planningarea;
	}

	public String getStall() {
		return stall;
	}

	public void setStall(String stall) {
		this.stall = stall == null ? null : stall.trim();
	}

	public BigDecimal getPlotratio() {
		return plotratio;
	}

	public void setPlotratio(BigDecimal plotratio) {
		this.plotratio = plotratio;
	}

	public BigDecimal getGreeningrate() {
		return greeningrate;
	}

	public void setGreeningrate(BigDecimal greeningrate) {
		this.greeningrate = greeningrate;
	}

	public String getPmurl() {
		return pmurl;
	}

	public void setPmurl(String pmurl) {
		this.pmurl = pmurl == null ? null : pmurl.trim();
	}

	public Boolean getFlagrecommend() {
		return flagrecommend;
	}

	public void setFlagrecommend(Boolean flagrecommend) {
		this.flagrecommend = flagrecommend;
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

	public BigDecimal getCaradminfee() {
		return caradminfee;
	}

	public void setCaradminfee(BigDecimal caradminfee) {
		this.caradminfee = caradminfee;
	}

	public BigDecimal getCarrent() {
		return carrent;
	}

	public void setCarrent(BigDecimal carrent) {
		this.carrent = carrent;
	}

	public String getMgtunit() {
		return mgtunit;
	}

	public void setMgtunit(String mgtunit) {
		this.mgtunit = mgtunit == null ? null : mgtunit.trim();
	}

	public Date getLaunchdate() {
		return launchdate;
	}

	public void setLaunchdate(Date launchdate) {
		this.launchdate = launchdate;
	}

	public String getPreferential() {
		return preferential;
	}

	public void setPreferential(String preferential) {
		this.preferential = preferential == null ? null : preferential.trim();
	}

	public BigDecimal getPricemin() {
		return pricemin;
	}

	public void setPricemin(BigDecimal pricemin) {
		this.pricemin = pricemin;
	}

	public BigDecimal getLiftprice() {
		return liftprice;
	}

	public void setLiftprice(BigDecimal liftprice) {
		this.liftprice = liftprice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}
}
