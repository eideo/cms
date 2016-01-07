package com.sbiao360.cms.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		request.setAttribute("notSearch", "true");
		return "/detail";
	}
}
