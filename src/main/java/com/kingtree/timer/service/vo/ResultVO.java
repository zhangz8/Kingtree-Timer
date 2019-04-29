package com.kingtree.timer.service.vo;

import java.io.Serializable;
import java.util.List;

public class ResultVO implements Serializable {

  /**
	 * 
	 */
  private static final long   serialVersionUID = 3331861613647681466L;

  private int                 total;
  private List<ResultHouseVO> houses;
  private List<String>        communityNames;
  private List<String>        brokerNames;

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public List<ResultHouseVO> getHouses() {
    return houses;
  }

  public void setHouses(List<ResultHouseVO> houses) {
    this.houses = houses;
  }

  public List<String> getCommunityNames() {
    return communityNames;
  }

  public void setCommunityNames(List<String> communityNames) {
    this.communityNames = communityNames;
  }

  public List<String> getBrokerNames() {
    return brokerNames;
  }

  public void setBrokerNames(List<String> brokerNames) {
    this.brokerNames = brokerNames;
  }

}
