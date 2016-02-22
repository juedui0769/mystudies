package com.wxg.app.osc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import com.wxg.app.osc.bean.HomePage;
import com.wxg.app.osc.dao.HomePageDao;

public class HomePageProcessor implements PageProcessor {

	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
	
	public void process(Page page) {
		Html html = page.getHtml();
		/**
		 * el.select("a[href]")
		 * el.select("a[href*=example.com]")
		 */
		Selectable selectable = html.$("div[id=IndustryNews]");
		
		/**
		 * 只是个demo
		 * 只抓取了p1
		 * 
		 */
		Selectable p1 = selectable.$("ul[class=p1]");
		
		List<Selectable> list = p1.xpath("li").nodes();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<HomePage> homepages = new ArrayList<HomePage>();
		for(Selectable sel : list){
			HomePage hp = new HomePage();
			hp.setType("综合资讯");
			hp.setAddTm(sdf.format(new java.util.Date()));
			hp.setTitle( sel.xpath("a/text()").toString() );
			hp.setUrl( sel.xpath("a/@href").toString() );
			homepages.add(hp);
		}
		
		//System.out.println(Arrays.toString(homepages.toArray()));
		new HomePageDao().save(homepages);
		
	}

	public static void main(String[] args){
		Spider.create(new HomePageProcessor())
			.addUrl("http://www.oschina.net/")
			.thread(5)
			.run();
	}
	
	
	public Site getSite() {
		return site;
	}

}
