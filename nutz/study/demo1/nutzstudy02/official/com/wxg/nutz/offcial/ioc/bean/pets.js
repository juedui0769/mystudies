var ioc = {
	xiaobai : {
		name : 'XiaoBai',
		birthday : '2009-10-25 15:23:40'
	},
	xiaohei : {
		type : 'com.wxg.nutz.offcial.ioc.bean.Pet',
		singleton : false,
		args : [ 'XiaoHei' ],
		fields : {
			birthday : '2009-11-3 08:02:14',
			friend : {
				refer : 'xiaobai'
			}
		}
	}
}