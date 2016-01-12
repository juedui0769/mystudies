
function test01(){
	var aaa = [200, 500, null, 12, 300, 90];
	// var aaa = [200, 500, undefined, 12, 300, 90];
	// var aaa = [200, 500, '', 12, 300, 90];
	
	var result = 0;
	$.each(aaa, function(i,n){
		result += n;
	});
	console.log(result);
}

function test02(){
	var aaa = [200, 500, null, 12, 300, 90];
	// var aaa = [200, 500, undefined, 12, 300, 90];
	// var aaa = [200, 500, '', 12, 300, 90];
	
	var result = new Decimal(0);
	$.each(aaa, function(i,n){
		result = result.plus( new Decimal(n) );
	});
	console.log(result.toString());
}


$(function(){
	test01();
	//test02();
});