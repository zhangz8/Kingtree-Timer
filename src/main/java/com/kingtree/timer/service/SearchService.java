package com.kingtree.timer.service;

import com.kingtree.timer.service.vo.ResultVO;

public interface SearchService {

	ResultVO search(String keywork, String borkerName, String communityName, int page, int length) throws Exception;

}
