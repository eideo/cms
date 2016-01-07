package com.sbiao360.cmsadmin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbiao360.cmsadmin.core.JavaEEFrameworkBaseController;
import com.sbiao360.cmsadmin.model.Attachment;
import com.sbiao360.cmsadmin.service.AttachmentService;

/**
 * 附件的控制层
 * 
 * @author yujunwei
 */
@Controller
@RequestMapping("/sys/attachment")
public class AttachmentController extends
		JavaEEFrameworkBaseController<Attachment> {

	@Resource
	private AttachmentService attachmentService;

}
