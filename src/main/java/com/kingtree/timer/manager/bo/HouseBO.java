package com.kingtree.timer.manager.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

import com.kingtree.timer.entity.TaCompany;
import com.kingtree.timer.service.vo.TaDepartmentVO;
import com.kingtree.timer.service.vo.TaEmployeeVO;
import com.kingtree.timer.service.vo.TaEstateVO;
import com.kingtree.timer.service.vo.TaHouseVO;
import com.kingtree.timer.service.vo.TaPiceareaVO;
import com.kingtree.timer.util.ConstantsUtil;

/**
 * 房子信息
 * 
 * @author youchuan
 *
 */
public class HouseBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4720710550523441591L;

	private String houseId;// 房子编号
	private String userId;// 用户编号
	private String description;// 房子描述
	private String uniqueId;// 重复标识
	private String loupanId;// 楼盘编号，没有写houseid
	private String title;// 二手房标题
	private String price;// 房子价格
	private String roomCount;// 房间数
	private String hallCount;// 客厅数
	private String toiletCount;// 卫生间数
	private String space;// 房子面积
	private String houseType;// 房子类型
	private String currentFloor;// 当前楼层
	private String totalFloor;// 总楼层数
	private String decorationType;// 装修类型
	private String towardType;// 朝向
	private String buildingYear;// 建造年
	private String doorPlate;// 门牌号
	private String roomNO;// 房间号
	private String createTime;// 创建时间
	private String innerImg;// 室内图
	private String innerImgId;// 室内图编号
	private String outterImg;// 小区图
	private String outterImgId;// 小区图编号
	private String layoutImg;// 户型图
	private String layoutImgId;// 户型图编号

	private String brokerId;// 经纪人编号
	private String brokerName;// 经纪人姓名
	private String brokerMobile;// 经纪人电话
	private String brokerBankCard;// 经纪人银行帐号
	private String brokerIdentityCard;// 经纪人身份证号
	private String brokerCity;// 经纪人所在城市
	private String brokerArea;// 经纪人所在区
	private String brokerBlock;// 经纪人所在板块
	private String brokerCompanyId;// 经纪人公司编号
	private String brokerStoreId;// 经纪人门店编号

	private String companyName;// 公司名
	private String companyCity;// 公司所在城市
	private String companyFullName;// 公司全名
	private String companyId;// 公司编号

	private String deptId;// 部门编号
	private String deptName; // 部门名称
	private String deptAddress; // 部门地址
	private String parentDeptId;// 上级部门
	private String companyIdOfDept;// 部门所在公司

	private String communityId;
	private String communityName;// 小区名
	private String communityCityName;// 小区所在城市
	private String communityRegionName;// 小区所在区县
	private String communitySubRegionName;// 小区所在子区县
	private String communityAddress;// 小区地址

	public HouseBO() {

	}

	public HouseBO(TaHouseVO taHouse, TaEstateVO taEstate, TaDepartmentVO taDepartment, TaCompany taCompany, TaPiceareaVO taPicearea,
			TaEmployeeVO taEmployeeVO) {
		Random random1 = new Random(99999999);
		Random random2 = new Random(99999998);
		Random random3 = new Random(99999899);
		this.userId = taHouse.getUserId() + "";
		this.houseId = taHouse.getId() + "";
		this.title = taHouse.getTitle();
		this.roomCount = taHouse.getCountf();
		this.hallCount = taHouse.getCountt();
		this.toiletCount = taHouse.getCountw();
		this.innerImg = taHouse.getCoverphoto() == null ? "" : (ConstantsUtil.IMAGE_SERVER + taHouse.getCoverphoto());
		this.outterImg = taHouse.getCoverphoto() == null ? "" : (ConstantsUtil.IMAGE_SERVER + taHouse.getCoverphoto());
		this.layoutImg = taHouse.getLayoutImg() == null ? "" : (ConstantsUtil.IMAGE_SERVER + taHouse.getLayoutImg());
		this.innerImgId = random1.nextInt() + "";
		this.outterImgId = random2.nextInt() + "";
		this.layoutImgId = random3.nextInt() + "";
		this.description = taHouse.getPropdesc();
		this.price = taEstate.getPrice() == null ? "" : taEstate.getPrice().toString();
		this.space = taHouse.getSquare() == null ? "" : taHouse.getSquare().toString();
		this.currentFloor = taHouse.getFloor();
		this.totalFloor = taHouse.getFloorall();
		this.doorPlate = taEstate.getAddress();
		this.createTime = taHouse.getRegdate().getTime() + "";
		this.buildingYear = taEstate.getCompleteyear();
		this.roomNO = taHouse.getRoomno();
		this.deptId = taDepartment.getId() + "";
		this.deptName = taDepartment.getDepname();
		this.deptAddress = taDepartment.getAddress();
		this.parentDeptId = taDepartment.getParentId() + "";

		this.brokerName = taEmployeeVO.getUserName();
		this.brokerMobile = taEmployeeVO.getMobile();
		this.brokerIdentityCard = taEmployeeVO.getIdcard();
		this.brokerStoreId = taPicearea.getId() + "";
		this.brokerCompanyId = taCompany.getComid();
		this.brokerId = taEmployeeVO.getId() + "";

		this.companyIdOfDept = taCompany.getComid();
		this.communityName = taEstate.getEstatename();
		this.communityId = taEstate.getId() + "";
		this.communityCityName = "郑州";
		this.communityRegionName = taPicearea.getAreaname();
		this.communitySubRegionName = taPicearea.getAreaname();
		this.communityAddress = taEstate.getAddress();

		this.companyName = taCompany.getCompanyname();
		this.companyFullName = taCompany.getCompanyname();
		this.companyCity = "郑州";
		this.companyId = taCompany.getComid();
	}

	public String getCommunityId() {
		return communityId;
	}

	public String getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(String brokerId) {
		this.brokerId = brokerId;
	}

	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getLoupanId() {
		return loupanId;
	}

	public void setLoupanId(String loupanId) {
		this.loupanId = loupanId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(String roomCount) {
		this.roomCount = roomCount;
	}

	public String getHallCount() {
		return hallCount;
	}

	public void setHallCount(String hallCount) {
		this.hallCount = hallCount;
	}

	public String getToiletCount() {
		return toiletCount;
	}

	public void setToiletCount(String toiletCount) {
		this.toiletCount = toiletCount;
	}

	public String getSpace() {
		return space;
	}

	public void setSpace(String space) {
		this.space = space;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(String currentFloor) {
		this.currentFloor = currentFloor;
	}

	public String getTotalFloor() {
		return totalFloor;
	}

	public void setTotalFloor(String totalFloor) {
		this.totalFloor = totalFloor;
	}

	public String getDecorationType() {
		return decorationType;
	}

	public void setDecorationType(String decorationType) {
		this.decorationType = decorationType;
	}

	public String getTowardType() {
		return towardType;
	}

	public void setTowardType(String towardType) {
		this.towardType = towardType;
	}

	public String getBuildingYear() {
		return buildingYear;
	}

	public void setBuildingYear(String buildingYear) {
		this.buildingYear = buildingYear;
	}

	public String getDoorPlate() {
		return doorPlate;
	}

	public void setDoorPlate(String doorPlate) {
		this.doorPlate = doorPlate;
	}

	public String getRoomNO() {
		return roomNO;
	}

	public void setRoomNO(String roomNO) {
		this.roomNO = roomNO;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getInnerImg() {
		return innerImg;
	}

	public void setInnerImg(String innerImg) {
		this.innerImg = innerImg;
	}

	public String getInnerImgId() {
		return innerImgId;
	}

	public void setInnerImgId(String innerImgId) {
		this.innerImgId = innerImgId;
	}

	public String getOutterImg() {
		return outterImg;
	}

	public void setOutterImg(String outterImg) {
		this.outterImg = outterImg;
	}

	public String getOutterImgId() {
		return outterImgId;
	}

	public void setOutterImgId(String outterImgId) {
		this.outterImgId = outterImgId;
	}

	public String getLayoutImg() {
		return layoutImg;
	}

	public void setLayoutImg(String layoutImg) {
		this.layoutImg = layoutImg;
	}

	public String getLayoutImgId() {
		return layoutImgId;
	}

	public void setLayoutImgId(String layoutImgId) {
		this.layoutImgId = layoutImgId;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	public String getBrokerMobile() {
		return brokerMobile;
	}

	public void setBrokerMobile(String brokerMobile) {
		this.brokerMobile = brokerMobile;
	}

	public String getBrokerBankCard() {
		return brokerBankCard;
	}

	public void setBrokerBankCard(String brokerBankCard) {
		this.brokerBankCard = brokerBankCard;
	}

	public String getBrokerIdentityCard() {
		return brokerIdentityCard;
	}

	public void setBrokerIdentityCard(String brokerIdentityCard) {
		this.brokerIdentityCard = brokerIdentityCard;
	}

	public String getBrokerCity() {
		return brokerCity;
	}

	public void setBrokerCity(String brokerCity) {
		this.brokerCity = brokerCity;
	}

	public String getBrokerArea() {
		return brokerArea;
	}

	public void setBrokerArea(String brokerArea) {
		this.brokerArea = brokerArea;
	}

	public String getBrokerBlock() {
		return brokerBlock;
	}

	public void setBrokerBlock(String brokerBlock) {
		this.brokerBlock = brokerBlock;
	}

	public String getBrokerCompanyId() {
		return brokerCompanyId;
	}

	public void setBrokerCompanyId(String brokerCompanyId) {
		this.brokerCompanyId = brokerCompanyId;
	}

	public String getBrokerStoreId() {
		return brokerStoreId;
	}

	public void setBrokerStoreId(String brokerStoreId) {
		this.brokerStoreId = brokerStoreId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCity() {
		return companyCity;
	}

	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	public String getCompanyFullName() {
		return companyFullName;
	}

	public void setCompanyFullName(String companyFullName) {
		this.companyFullName = companyFullName;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptAddress() {
		return deptAddress;
	}

	public void setDeptAddress(String deptAddress) {
		this.deptAddress = deptAddress;
	}

	public String getParentDeptId() {
		return parentDeptId;
	}

	public void setParentDeptId(String parentDeptId) {
		this.parentDeptId = parentDeptId;
	}

	public String getCompanyIdOfDept() {
		return companyIdOfDept;
	}

	public void setCompanyIdOfDept(String companyIdOfDept) {
		this.companyIdOfDept = companyIdOfDept;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getCommunityCityName() {
		return communityCityName;
	}

	public void setCommunityCityName(String communityCityName) {
		this.communityCityName = communityCityName;
	}

	public String getCommunityRegionName() {
		return communityRegionName;
	}

	public void setCommunityRegionName(String communityRegionName) {
		this.communityRegionName = communityRegionName;
	}

	public String getCommunitySubRegionName() {
		return communitySubRegionName;
	}

	public void setCommunitySubRegionName(String communitySubRegionName) {
		this.communitySubRegionName = communitySubRegionName;
	}

	public String getCommunityAddress() {
		return communityAddress;
	}

	public void setCommunityAddress(String communityAddress) {
		this.communityAddress = communityAddress;
	}

}
