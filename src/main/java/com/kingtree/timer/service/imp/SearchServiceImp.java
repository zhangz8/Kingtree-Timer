package com.kingtree.timer.service.imp;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Service;

import com.kingtree.timer.service.KingtreeTaHouseService;
import com.kingtree.timer.service.SearchService;
import com.kingtree.timer.service.TaEmployeeService;
import com.kingtree.timer.service.TaEstateService;
import com.kingtree.timer.service.TaSystemUserService;
import com.kingtree.timer.service.vo.ResultHouseVO;
import com.kingtree.timer.service.vo.ResultVO;
import com.kingtree.timer.service.vo.TaEmployeeVO;
import com.kingtree.timer.service.vo.TaEstateVO;
import com.kingtree.timer.service.vo.TaHouseVO;
import com.kingtree.timer.service.vo.TaSystemUserVO;
import com.kingtree.timer.util.ContextFileUtil;
import com.kingtree.timer.util.KingtreeIkAnalyzer;
import com.kingtree.timer.util.PageUtil;

@Service
public class SearchServiceImp implements SearchService {

  @Resource
  private KingtreeTaHouseService kingtreeTaHouseService;
  @Resource
  private TaEstateService        taEstateService;
  @Resource
  private TaSystemUserService    taSystemUserService;
  @Resource
  private TaEmployeeService      taEmployeeService;

  private final static String    INDEX_PATH = ContextFileUtil.getSysDirectory(
                                                "index").toString();

  @Override
  public ResultVO search(String keywork, String borkerName,
      String communityName, int page, int length) throws Exception {
    Directory dir = FSDirectory.open(Paths.get(INDEX_PATH));
    IndexReader reader = DirectoryReader.open(dir);
    IndexSearcher is = new IndexSearcher(reader);
    String[] values = ArrayUtils.EMPTY_STRING_ARRAY;
    String[] keys = ArrayUtils.EMPTY_STRING_ARRAY;
    BooleanClause.Occur[] ands = new BooleanClause.Occur[0];
    if (StringUtils.isNotBlank(keywork)) {
      values = ArrayUtils.add(values, keywork);
      keys = ArrayUtils.add(keys, "content");
      ands = ArrayUtils.add(ands, BooleanClause.Occur.MUST);
    }
    if (StringUtils.isNotBlank(borkerName)) {
      values = ArrayUtils.add(values, borkerName);
      keys = ArrayUtils.add(keys, "brokerName");
      ands = ArrayUtils.add(ands, BooleanClause.Occur.MUST);
    }
    if (StringUtils.isNotBlank(communityName)) {
      values = ArrayUtils.add(values, communityName);
      keys = ArrayUtils.add(keys, "communityName");
      ands = ArrayUtils.add(ands, BooleanClause.Occur.MUST);
    }

    Query multi = MultiFieldQueryParser.parse(values, keys, ands,
        new KingtreeIkAnalyzer());

    TopDocs hits = is.search(multi, Integer.MAX_VALUE);
    List<ResultHouseVO> houseList = new ArrayList<ResultHouseVO>();
    ResultVO resultVO = new ResultVO();
    List<String> borkerNames = new LinkedList<String>();
    List<String> communityNames = new LinkedList<String>();

    if (hits.totalHits > 0) {
      for (int i = PageUtil.getStart(page, length), j = PageUtil.getStart(page,
          length); (i < j + length) && (i < hits.totalHits); i++) {
        ScoreDoc scoreDoc = hits.scoreDocs[i];
        houseList.add(get(is.doc(scoreDoc.doc)));
      }
      for (int i = 0; i < hits.totalHits; i++) {
        ScoreDoc scoreDoc = hits.scoreDocs[i];
        String broker = is.doc(scoreDoc.doc).get("brokerName");
        String community = is.doc(scoreDoc.doc).get("communityName");
        if (!borkerNames.contains(broker)) {
          borkerNames.add(broker);
        }
        if (!communityNames.contains(community)) {
          communityNames.add(community);
        }
      }
    }
    resultVO.setTotal(hits.totalHits);
    resultVO.setHouses(houseList);
    resultVO.setBrokerNames(borkerNames);
    resultVO.setCommunityNames(communityNames);

    reader.close();
    return resultVO;
  }

  private ResultHouseVO get(Document doc) {
    String houseId = doc.get("houseId");
    if (StringUtils.isBlank(houseId)) {
      return null;
    }
    TaHouseVO house = kingtreeTaHouseService.get(houseId);
    if (house == null) {
      return null;
    }
    TaEstateVO estate = taEstateService.get(house.getEstid());
    if (estate == null) {
      return null;
    }
    TaEmployeeVO empVO = taEmployeeService.get(house.getGsempid());
    if (empVO == null) {
      return null;
    }
    TaSystemUserVO user = taSystemUserService.get(empVO.getUid());
    if (user == null) {
      return null;
    }
    ResultHouseVO resultVO = new ResultHouseVO(house, estate, user);
    return resultVO;
  }

}
