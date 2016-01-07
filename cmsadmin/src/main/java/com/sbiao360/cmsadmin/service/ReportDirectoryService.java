package com.sbiao360.cmsadmin.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sbiao360.cmsadmin.dao.ReportDirectoryDao;
import com.sbiao360.cmsadmin.model.ReportDirectory;

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

	public List<ReportDirectory> getReportDirectory(Long reportId) {
		return this.reportDirectoryDao.getReportDirectory(reportId);
	}

	public int updateByProperties(Map<String, Object> paramMap) {
		return this.reportDirectoryDao.updateByProperties(paramMap);
	}

	public int save(
			Long reportId,
			LinkedHashMap<String, LinkedHashMap<String, List<String>>> catalogMap) {
		int i = 0;
		if (null != catalogMap && !catalogMap.isEmpty()) {
			int dirIndexOne = 0;
			for (Map.Entry<String, LinkedHashMap<String, List<String>>> entryOne : catalogMap
					.entrySet()) {
				dirIndexOne++;
				String oneLevel = entryOne.getKey();
				// oneLevel = oneLevel.substring(oneLevel.indexOf("|") + 1);
				String[] oneLevelArr = oneLevel.split("\\|");
				oneLevel = oneLevelArr[1];
				int dirPageOne = Integer.parseInt(oneLevelArr[2]);
				ReportDirectory reportDirectoryOne = new ReportDirectory();
				reportDirectoryOne.setReportId(reportId);
				reportDirectoryOne.setDirIndex(dirIndexOne);
				reportDirectoryOne.setDirHierachy(1);
				reportDirectoryOne.setDirParentId(0L);
				reportDirectoryOne.setDirConext(oneLevel);
				reportDirectoryOne.setDirPage(dirPageOne);
				i += save(reportDirectoryOne);
				// System.out.println("oneLevel===" + oneLevel);
				Map<String, List<String>> oneValue = entryOne.getValue();
				int dirIndexTwo = 0;
				for (Map.Entry<String, List<String>> entryTwo : oneValue
						.entrySet()) {
					dirIndexTwo++;
					String twoLevel = entryTwo.getKey();
					// twoLevel = twoLevel.substring(twoLevel.indexOf("|") + 1);
					String[] twoLevelArr = twoLevel.split("\\|");
					twoLevel = twoLevelArr[1];
					int dirPageTwo = Integer.parseInt(twoLevelArr[2]);
					// System.out.println("twoLevel===" + twoLevel);
					ReportDirectory reportDirectoryTwo = new ReportDirectory();
					reportDirectoryTwo.setReportId(reportId);
					reportDirectoryTwo.setDirIndex(dirIndexTwo);
					reportDirectoryTwo.setDirHierachy(2);
					reportDirectoryTwo.setDirParentId(reportDirectoryOne
							.getId());
					reportDirectoryTwo.setDirConext(twoLevel);
					reportDirectoryTwo.setDirPage(dirPageTwo);
					i += save(reportDirectoryTwo);
					List<String> twoValue = entryTwo.getValue();
					int dirIndexThree = 0;
					for (String threeLevel : twoValue) {
						dirIndexThree++;
						// threeLevel = threeLevel.substring(threeLevel.indexOf("|") + 1);
						String[] threeLevelArr = threeLevel.split("\\|");
						threeLevel = threeLevelArr[1];
						int dirPageThree = Integer.parseInt(threeLevelArr[2]);
						// System.out.println("threeLevel===" + threeLevel);
						ReportDirectory reportDirectoryThree = new ReportDirectory();
						reportDirectoryThree.setReportId(reportId);
						reportDirectoryThree.setDirIndex(dirIndexThree);
						reportDirectoryThree.setDirHierachy(3);
						reportDirectoryThree.setDirParentId(reportDirectoryTwo
								.getId());
						reportDirectoryThree.setDirConext(threeLevel);
						reportDirectoryThree.setDirPage(dirPageThree);
						i += save(reportDirectoryThree);
					}
				}
			}
		}
		return i;
	}

}
