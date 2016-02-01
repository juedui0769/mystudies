package com.wxg.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

public class OSCPageProcessor implements PageProcessor{

	public static void main(String[] args){
		Spider.create(new OSCPageProcessor())
			.addUrl("http://www.oschina.net/")
			.thread(5)
			.run();
	}
	
	public void process(Page page) {
		Html html = page.getHtml();
		/**
		 * el.select("a[href]")
		 * el.select("a[href*=example.com]")
		 */
		Selectable selectable = html.$("div[id=IndustryNews]");
		Selectable p1 = selectable.$("ul[class=p1]");
		Selectable p2 = selectable.$("ul[class=p2]");
		Selectable p3 = selectable.$("ul[class=p3]");
		
		
		System.out.println( p1.toString() );
	}

	public Site getSite() {
		return site;
	}
	
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

}
