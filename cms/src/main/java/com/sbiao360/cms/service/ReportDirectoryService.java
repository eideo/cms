package com.sbiao360.cms.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sbiao360.cms.dao.ReportDirectoryDao;
import com.sbiao360.cms.domain.ReportDirectory;

/**
 * 行业报告目录的业务逻辑层的实现
 * 
 * @author yujunwei
 */
@Service
public class ReportDirectoryService {

	@Resource
	private ReportDirectoryDao reportDirectoryDao;

	public int save(ReportDirectory reportDirectory) {
		return this.reportDirectoryDao.save(reportDirectory);
	}

	public int update(ReportDirectory reportDirectory) {
		return this.reportDirectoryDao.update(reportDirectory);
	}

	public ReportDirectory getByPrimaryKey(Long id) {
		return this.reportDirectoryDao.getByPrimaryKey(id);
	}

	public int delete(Long[] ids) {
		return this.reportDirectoryDao.delete(ids);
	}

	public int delete(Long id) {
		return this.reportDirectoryDao.deleteByPrimaryKey(id);
	}

	public List<ReportDirectory> getListByReportId(Long reportId) {
		return this.reportDirectoryDao.getListByReportId(reportId);
	}

	public List<ReportDirectory> getListByDirParentId(Long dirParentId) {
		return this.reportDirectoryDao.getListByDirParentId(dirParentId);
	}

	public int updateByProperties(Map<String, Object> paramMap) {
		return this.reportDirectoryDao.updateByProperties(paramMap);
	}

	public int save(Long reportId, String cmd,
			TreeMap<String, TreeMap<String, List<String>>> catalogMap) {
		int i = 0;
		if (null != catalogMap && !catalogMap.isEmpty()) {
			if ("edit".equals(cmd)) {
				this.reportDirectoryDao.deleteByReportId(reportId);
			}
			int dirIndexOne = 0;
			for (Map.Entry<String, TreeMap<String, List<String>>> entryOne : catalogMap
					.entrySet()) {
				dirIndexOne++;
				String oneLevel = entryOne.getKey();
				oneLevel = oneLevel.substring(oneLevel.indexOf("|") + 1);
				ReportDirectory reportDirectoryOne = new ReportDirectory();
				reportDirectoryOne.setReportId(reportId);
				reportDirectoryOne.setDirIndex(dirIndexOne);
				reportDirectoryOne.setDirHierachy(1);
				reportDirectoryOne.setDirParentId(0L);
				reportDirectoryOne.setDirConext(oneLevel);
				i += save(reportDirectoryOne);
				// System.out.println("oneLevel===" + oneLevel);
				Map<String, List<String>> oneValue = entryOne.getValue();
				int dirIndexTwo = 0;
				for (Map.Entry<String, List<String>> entryTwo : oneValue
						.entrySet()) {
					dirIndexTwo++;
					String twoLevel = entryTwo.getKey();
					twoLevel = twoLevel.substring(twoLevel.indexOf("|") + 1);
					// System.out.println("twoLevel===" + twoLevel);
					ReportDirectory reportDirectoryTwo = new ReportDirectory();
					reportDirectoryTwo.setReportId(reportId);
					reportDirectoryTwo.setDirIndex(dirIndexTwo);
					reportDirectoryTwo.setDirHierachy(2);
					reportDirectoryTwo.setDirParentId(reportDirectoryOne
							.getId());
					reportDirectoryTwo.setDirConext(twoLevel);
					i += save(reportDirectoryTwo);
					List<String> twoValue = entryTwo.getValue();
					int dirIndexThree = 0;
					for (String threeLevel : twoValue) {
						dirIndexThree++;
						threeLevel = threeLevel.substring(threeLevel
								.indexOf("|") + 1);
						// System.out.println("threeLevel===" + threeLevel);
						ReportDirectory reportDirectoryThree = new ReportDirectory();
						reportDirectoryThree.setReportId(reportId);
						reportDirectoryThree.setDirIndex(dirIndexThree);
						reportDirectoryThree.setDirHierachy(3);
						reportDirectoryThree.setDirParentId(reportDirectoryTwo
								.getId());
						reportDirectoryThree.setDirConext(threeLevel);
						i += save(reportDirectoryThree);
					}
				}
			}
		}
		return i;
	}

}
