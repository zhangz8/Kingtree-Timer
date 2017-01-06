package com.kingtree.timer.service;

import java.util.List;

import com.kingtree.timer.entity.KingtreeConfig;

public interface KingtreeConfigService {

	List<KingtreeConfig> gets(String groupId);

	void modify(KingtreeConfig config);

	List<KingtreeConfig> get(String groupId);
}
