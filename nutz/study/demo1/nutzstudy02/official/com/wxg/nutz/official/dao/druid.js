var ioc = {
	dataSource : {
		type: 'com.alibaba.druid.pool.DruidDataSource',
		events: {
			depose: 'close'
		},
		fields: {
			driverClassName: 'com.mysql.jdbc.Driver',
			url: 'jdbc:mysql://127.0.0.1:3306/nutzbook',
			username: 'root',
			password: 'root',
			maxWait: 15000
		}
	}
}