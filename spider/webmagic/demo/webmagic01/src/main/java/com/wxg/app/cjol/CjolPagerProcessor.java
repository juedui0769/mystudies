package com.wxg.app.cjol;

import java.util.ArrayList;
import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import com.wxg.app.cjol.bean.CjolJobItem;

public class CjolPagerProcessor implements PageProcessor{

	private Site site = Site.me().setRetryTimes(3).setSleepTime(2000);
	
	public static void main(String[] args){
		Spider.create(new CjolPagerProcessor())
			.addUrl("http://s.cjol.com/f0102-l200805/?SearchType=4&KeywordType=3&Education=50")
			.thread(5)
			.run();
	}
	
	
	public void process(Page page) {
		Html html = page.getHtml();
		Selectable root = html.$("div[id=searchlist]");
		
		List<Selectable> ulList = root.xpath("ul").nodes();
		List<CjolJobItem> cjolJobList = new ArrayList<CjolJobItem>();
		for (Selectable sel : ulList){
			CjolJobItem jobitem = new CjolJobItem();
			jobitem.setPosition( sel.xpath("li[@class='list_type_first']//a/text()").toString() );
			jobitem.setCorporation( sel.xpath("li[@class='list_type_second']//a/text()").toString() );
			jobitem.setOfficialurl( sel.xpath("li[@class='list_type_second']//a/@href").toString() );
			jobitem.setRegion( sel.xpath("li[@class='list_type_third']/text()").toString() );
			jobitem.setGender( sel.xpath("li[@class='list_type_fourth']/text()").toString() );
			jobitem.setEducation( sel.xpath("li[@class='list_type_fifth']/text()").toString() );
			jobitem.setExperience( sel.xpath("li[@class='list_type_sixth']/text()").toString() );
			jobitem.setSalary( sel.xpath("li[@class='list_type_seventh']/text()").toString() );
			jobitem.setUpdatTm( sel.xpath("li[@class='list_type_eighth']/text()").toString() );
			cjolJobList.add(jobitem);
		}
		System.out.println(cjolJobList.get(0));
	}

	public Site getSite() {
		return site;
	}

}
