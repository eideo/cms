package com.sbiao360.cms.web;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sbiao360.cms.domain.PublishInfo;
import com.sbiao360.cms.service.CustomerKeywordsService;
import com.sbiao360.cms.service.PublishInfoService;

@Controller
public class DetailInfoController {

	@Resource
	private PublishInfoService publishInfoService;

	@Resource
	private CustomerKeywordsService customerKeywordsService;

	/**
	 * 查看详情
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/detail/{id}", method = {RequestMethod.GET})
	public String getDetailInfo(HttpServletRequest request,
			HttpServletResponse response,@PathVariable(value="id")String id) {
		PublishInfo publishInfo = null;
		if(!id.contains("-")){
			publishInfo = publishInfoService.selectByPrimaryKey(id);
			request.setAttribute("infoType", "xmxx");
		}else{
			String []idtype = id.split("-");
			//中标公示
			if(idtype[0].equals("zbgs")){
				publishInfo = publishInfoService.selectByZBGSPrimaryKey(idtype[1]);
			}
			//招标公告
			else if(idtype[0].equals("zbgg")){
				publishInfo = publishInfoService.selectByZBGGPrimaryKey(idtype[1]);
			}
			else if(idtype[0].equals("cgxx")){
				publishInfo = new PublishInfo();
			}
		}
		
		//验证是否是html
		String description = publishInfo.getDescription();
		if (!(description.indexOf("<")==0&&description.lastIndexOf(">")==(description.length()-1))) {
			
			description = "<p style=\"font-size:14px;\">"
					+ description.replaceAll("\r\n",
							"</p><p style=\"font-size:14px;\">") + "</p>";
			publishInfo.setDescription(description);
		}
		request.setAttribute("publishInfo", publishInfo);
		request.setAttribute("hotKeyWords",
				customerKeywordsService.getHotKeyWordsList());
		Assertion assertion = AssertionHolder.getAssertion();
		if(assertion!=null){
			request.setAttribute("username", assertion.getPrincipal().getName());
		}
		request.setAttribute("notSearch", "true");
		return "/detail";
	}
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/recomzbxx")
	public void getRecomZBXX(HttpServletRequest request,
			HttpServletResponse response){
		String title = request.getParameter("title");
		cutXMXXTitle(title);
		
		
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	public void getRecomZBGS(HttpServletRequest request,
			HttpServletResponse response){
		
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	public void getRecomCGXX(HttpServletRequest request,
			HttpServletResponse response){
		
	}
	
	private void cutXMXXTitle(String title){
		title = title.replace("的", "").replace("项目", "").replace("工程", "").replace("（", "(").replace("）", ")");
		while(title.indexOf("(")!=-1){
			title =title.replace(title.substring(title.indexOf("("),title.indexOf(")")==-1?title.length():(title.indexOf(")")+1)), "");
		}
		title = title.replaceAll("[\\pP‘’“”]", "").replace("<","").replace(">", ""); 
		List<Word> re = WordSegmenter.seg(title);
	}
	
	private void cutZBGGTitle(String title){
		String word = "评标、招标、变更、资格预审、补充、延期开标、延长报名时间、竞争性谈判、比选、单一来源采购";
		String[] s = word.split("、");
		for (String string : s) {
			if(title.indexOf(string)!=-1){
				title = title.replace(title.substring(title.indexOf(string),title.length()),"");
			}
		}
		title = title.replaceAll("[公开|预|总承包的|公告|二次|【变更】|重新招标]","");
		if(title.lastIndexOf("的")==title.length()-1){
			title = title.substring(0,title.length()-1);
		}
		title = title.replaceAll("[\\pP‘’“”]", "").replace("<","").replace(">", ""); 
		List<Word> re = WordSegmenter.seg(title);
	}
	
	private void cutZBGSTitle(String title){
		String word = "中标、评标、变更、补充、竞争性谈判、比选";
		String[] s = word.split("、");
		for (String string : s) {
			if(title.indexOf(string)!=-1){
				title = title.replace(title.substring(title.indexOf(string),title.length()),"");
			}
		}
		title = title.replaceAll("[公开|预|结果公示|总承包的|公告|二次]","");
		if(title.lastIndexOf("的")==title.length()-1){
			title = title.substring(0,title.length()-1);
		}
		title = title.replaceAll("[\\pP‘’“”]", "").replace("<","").replace(">", ""); 
		List<Word> re = WordSegmenter.seg(title);
	}
}
