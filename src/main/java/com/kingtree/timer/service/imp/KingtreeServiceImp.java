package com.kingtree.timer.service.imp;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kingtree.timer.dao.KingtreeConfigMapper;
import com.kingtree.timer.entity.KingtreeConfig;
import com.kingtree.timer.service.KingtreeConfigService;

@Service
public class KingtreeServiceImp implements KingtreeConfigService {

	@Resource
	private KingtreeConfigMapper kingtreeConfigMapper;

	@Override
	public List<KingtreeConfig> gets(String groupId) {
		if (StringUtils.isBlank(groupId)) {
			return null;
		}
		return kingtreeConfigMapper.selectByGroupId(groupId);
	}

	@Override
	public void modify(KingtreeConfig config) {
		if (config == null) {
			return;
		}
		kingtreeConfigMapper.updateByPrimaryKey(config);
	}

	@Override
	public List<KingtreeConfig> get(String groupId) {
		if (StringUtils.isBlank(groupId)) {
			return Collections.emptyList();
		}
		return kingtreeConfigMapper.selectByGroupId(groupId);
	}

}
