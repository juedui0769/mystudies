
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

function test03(){
	var aaa = [23,43, 11];
	var bb = aaa.concat(4,5);
	console.log('aaa : ', aaa);
	console.log('bb : ', bb);
}

function test04(){
	var aaa = [{aa:11},{aa:22}];
	var bb = aaa.concat({aa:333});
	console.log('aaa : ', aaa);
	console.log('bb : ', [{aa:444}].concat(aaa.join(',')));
}

function test05(){
	var aaa = [{aa:11},{aa:22}];
	var bb = aaa.concat({aa:333});
	var cc = $.merge([{aa:55}], bb);
	console.log('aaa : ', aaa);
	console.log('bb : ', bb);
	console.log('cc : ', cc);
}

function test06(){
	var aaa = {aa:0, bb:0, cc:0, _total_:0};
	var bbb = {aa:12,cc:13};
	var ccc = $.extend(true, aaa, bbb);
	console.log('aaa : ', aaa);
	console.log('bbb : ', bbb);
	console.log('ccc : ', ccc);
}

$(function(){
	//test01();
	//test02();
	test06();
});