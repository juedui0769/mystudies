package com.wxg.nutz.official.ioc.events;

import org.nutz.ioc.IocEventTrigger;

import com.wxg.nutz.official.ioc.bean.Pet;

/**
 * http://www.nutzam.com/core/ioc/events.html
 * OnFetchPet 必须是public的. why?
 * @author wxg
 *
 */
public class OnFetchPet implements IocEventTrigger<Pet> {
	public void trigger(Pet pet){
		pet.setFetchCount(pet.getFetchCount() + 1);
	}
}