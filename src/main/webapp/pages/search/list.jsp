<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/common.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房源搜索</title>
</head>
<body>
	<div class="container-fluid">
		<form class="form-inline" role="form" style="margin-top: 10px;" action="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="小区名、经纪人、手机号、房源名称、地址等" name="keyword" value="${keyword}"> <input
					type="hidden" name="page"> <input type="hidden" name="length">
			</div>
		</form>
		<div style="height: 25px; margin-top: -5px; margin-bottom: 5px;">为您搜到${resultVO.total}个结果</div>
		<table class="table table-hover" id="J_scroll">
			<c:forEach var="item" items="${resultVO.houses}">
				<tr>
					<td style="height: 80px; padding-left: 0px;" data-houseid="${item.houseId}">
						<div style="float: left;">
							<img class="img-rounded" alt="" src="${item.houseImg}" style="width: 80px; height: 80px;">
						</div>
						<div style="float: left; margin-left: 5px; width: 60%;">
							<span style="font-size: 14px; font-weight: bold; display: block; overflow: hidden;">${item.houseName}</span> <span
								style="font-size: 13px;">经纪人：${item.brokerName} </span> <span style="display: block; font-size: 12px;">电话：${item.brokerTel}</span>
							<span style="font-size: 13px; display: block; overflow: hidden;">地址：${item.address}</span>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<script type="text/javascript">
	
</script>
</html>