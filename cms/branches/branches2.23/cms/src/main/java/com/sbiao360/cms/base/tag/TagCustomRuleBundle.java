package com.sbiao360.cms.base.tag;

import org.sitemesh.SiteMeshContext;
import org.sitemesh.content.ContentProperty;
import org.sitemesh.content.tagrules.TagRuleBundle;
import org.sitemesh.content.tagrules.html.ExportTagToContentRule;
import org.sitemesh.tagprocessor.State;

/**
 * 自定义SiteMesh tag,增加了myFooter,tMaincontent,TsubNav,TdivStart,TdivEnd
 *
 */
public class TagCustomRuleBundle implements TagRuleBundle {

	@Override
	public void install(State defaultState, ContentProperty contentProperty,
			SiteMeshContext siteMeshContext) {
		defaultState.addRule("myFooter", new ExportTagToContentRule(
				siteMeshContext, contentProperty.getChild("myFooter"), false));
		defaultState.addRule("tMaincontent", new ExportTagToContentRule(
				siteMeshContext, contentProperty.getChild("tMaincontent"), false));
		defaultState.addRule("TsubNav", new ExportTagToContentRule(
				siteMeshContext, contentProperty.getChild("TsubNav"), false));
		defaultState.addRule("TdivStart", new ExportTagToContentRule(
				siteMeshContext, contentProperty.getChild("TdivStart"), false));
		defaultState.addRule("TdivEnd", new ExportTagToContentRule(
				siteMeshContext, contentProperty.getChild("TdivEnd"), false));
		defaultState.addRule("myScript", new ExportTagToContentRule(
				siteMeshContext, contentProperty.getChild("myScript"), false));
		defaultState.addRule("myCss", new ExportTagToContentRule(
				siteMeshContext, contentProperty.getChild("myCss"), false));
	}

	@Override
	public void cleanUp(State defaultState, ContentProperty contentProperty,
			SiteMeshContext siteMeshContext) {
	}

}
