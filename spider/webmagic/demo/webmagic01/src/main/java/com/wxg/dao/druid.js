var ioc = {
		conf: {
			type: "org.nutz.ioc.impl.PropertiesProxy",
			fields: {
				paths: ["com/wxg/dao/nutzbook.properties"]
			}
		}
	dataSource : {
		type: 'com.alibaba.druid.pool.DruidDataSource',
		events: {
			depose: 'close'
		},
		fields: {
			url : {java:"$conf.get('db.url')"},
            username : {java:"$conf.get('db.username')"},
            password : {java:"$conf.get('db.password')"},
            testWhileIdle : true,
            validationQuery : {java:"$conf.get('db.validationQuery')"},
            maxActive : {java:"$conf.get('db.maxActive')"},
            maxWait: {java:"$conf.get('db.maxWait')"},
            driverClassName: {java:"$conf.get('db.driverClassName')"}
		}
	}
}