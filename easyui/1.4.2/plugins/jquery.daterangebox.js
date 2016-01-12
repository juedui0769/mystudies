/**
 * jQuery EasyUI 1.4.2
 * 
 * Copyright (c) 2009-2015 www.jeasyui.com. All rights reserved.
 *
 * Licensed under the GPL license: http://www.gnu.org/licenses/gpl.txt
 * To use it on other terms please contact us at info@jeasyui.com
 *
 */

/**
 * daterangebox - jQuery EasyUI
 * 
 * Dependencies:
 * 	 calendar
 *   combo
 * 
 * del:
 * (1)去除对'sharedCalendar'的支持. 'sharedCalendar'作用可以参考datebox的API .
		相应去除'createBox'中的'onBeforeDestroy'.
 * (2)删除'doQuery'方法.因为范围日期选择不需要设计此功能.
 * (3)删除'cloneFrom'.范围日期选择暂时不考虑支持拷贝.
 * (4)删除okText:'Ok'
 * (5)删除bindEvents, setButtons
 * (6)删除doEnter
 * 
 * 重要:
 * (1)不能删除'doEnter',因为测试发现->Today btn->用到此方法. 所以保留'keyHandler'的存在.
 *
 * 其他:
 * (1)state.calendar -> 
		(1.1)createBox
		(1.2)setCalendar
		(1.3)doEnter
		(1.4)setValue
 * (2)setValue -> 
		(2.1)onShowPanel
		(2.2)onSelect
		(2.3)doEnter
		(2.4)$.fn.daterangebox.methods.setValue
 * (3)
 * 
 * add:
 * (1)
 * 
 * 特性:
 * (1)基本功能->支持日期范围选取
 * (2)右边日期必须大于左边,否则无法'确认'提交.
		(2.1)左边日历选中某个日期后,右边日历会计算可以选择的日期. 不能选择的日期颜色呈灰色.
		(2.2)'确定'时会再次判断左边日期是否小于右边. 若不满足会对右边日历对应文本框进行变色提示.
 * (3)支持required验证.继承自easyui validatebox .
 * 
 */
(function($){
	
	/**
	 * Add:
	 */
	function createRoot(target){
		
		var state = $.data(target, 'daterangebox');
		var opts = state.options;
		
		//Add:
		var leftRoot, rightRoot;
		
		//
		
		if (!state.topbar){
			var panel = $(target).combo('panel').css('overflow','hidden');
			state.topbar = $('<table cellspacing="0" cellpadding="0" style="width:100%;"><tr></tr></table>').appendTo(panel);
			var tr = state.topbar.find('tr');
			var td1 = $('<td></td>').appendTo(tr).css('width', '60%');
			var td2 = $('<td></td>').appendTo(tr).css('width', '40%');

			//td1 ->
			state.leftInput = $('<input>'), state.rightInput = $('<input>');
			$.each([state.leftInput, state.rightInput],function(i, n){
				if(i==1){
					$('<span>-</span>').css({'margin': '0 5px'}).appendTo(td1);
				}
				n.css('width',80).appendTo(td1);
				n.textbox();
				n.textbox('readonly',true);
			});

			//td2 ->
			state.zConfirmBtn = $('<a href="javascript:void(0);">确定</a>'),
			state.zCancelBtn = $('<a href="javascript:void(0);">取消</a>');
			$.each([state.zConfirmBtn,state.zCancelBtn],function(i,n){
				n.css({'float': 'right','width': '60px'}).appendTo(td2);
				n.linkbutton();
			});
			
			state.zConfirmBtn.on('click', function(){
				var lv = state.leftInput.textbox('getValue');
				var rv = state.rightInput.textbox('getValue');
				if( lv!='' && rv!='' ){
					var lt = new Date(lv.replace(/-/g,'/')).getTime(),
						rt = new Date(rv.replace(/-/g,'/')).getTime();
					if( rt >= lt ){
						$(target).combo('setValue', lv+' - '+rv).combo('setText', lv+' - '+rv);
						//
						$(target).combo('hidePanel');
					}else{
						state.rightInput.textbox('textbox').parent('span').addClass('daterangebox-alert-border');
					}
				}
			});
			state.zCancelBtn.on('click', function(){
				$(target).combo('hidePanel');
			});
		}
		
		
		/**
		 * if the calendar isn't created, create it.
		 * 创建日历
		 */
		if (!state.calendar){
			
			var panel = $(target).combo('panel').css('overflow','hidden');
			
			//Add: 
			leftRoot = $('<div class="daterangebox-calendar-left"></div>').css('float','left').appendTo(panel);
			
			//Update:
			var cc = $('<div class="daterangebox-calendar-inner"></div>').prependTo(leftRoot);
			
			state.calendar = $('<div></div>').appendTo(cc).calendar();
			
			$.extend(state.calendar.calendar('options'), {
				fit:true,
				//border:false,
				border:true,
				onSelect:function(date){
					var target = this.target;
					var opts = $(target).daterangebox('options');
					setValueLeft(target, opts.formatter.call(target, date));
					
					//点击日历后,隐藏日历面板.
					//$(target).combo('hidePanel');
					
					opts.onSelect.call(target, date);
				}
			});
		}
		
		//state.calendar
		if (!state.calendarRight){
			
			var panel = $(target).combo('panel').css('overflow','hidden');
			
			//Add: 
			rightRoot = $('<div class="daterangebox-calendar-right"></div>').css('float','left').appendTo(panel);
			
			//Update:
			var cc = $('<div class="daterangebox-calendar-inner"></div>').prependTo(rightRoot);
			
			state.calendarRight = $('<div></div>').appendTo(cc).calendar();
			
			$.extend(state.calendarRight.calendar('options'), {
				fit:true,
				//border:false,
				border:true,
				onSelect:function(date){
					var target = this.target;
					var opts = $(target).daterangebox('options');
					setValueRight(target, opts.formatter.call(target, date));
					
					//点击日历后,隐藏日历面板.
					//$(target).combo('hidePanel');
					
					opts.onSelect.call(target, date);
				}
			});
		}
		
	}
	
	/**
	 * create date box
	 */
	function createBox(target){

		var state = $.data(target, 'daterangebox');
		var opts = state.options;
		
		//在'onShowPanel'触发时会执行一系列的函数.
		$(target).addClass('daterangebox-f').combo($.extend({}, opts, {
			onShowPanel:function(){
				//bindEvents(this);
				//setButtons(this);
				setCalendar(this);
				setValue(this, $(this).daterangebox('getText'), true);
				opts.onShowPanel.call(this);
			},
			required:true
		}));
		//
		$(target).combo('textbox').attr('readonly',true);
		
		createRoot(target);

		$(target).combo('textbox').parent().addClass('daterangebox');
		//$(target).daterangebox('initValue', opts.value);
		
		//
		function setCalendar(target){
			var panel = $(target).combo('panel');
			
			var leftDiv = panel.children('div.daterangebox-calendar-left');
			var rightDiv = panel.children('div.daterangebox-calendar-right');
			
			var cc = $(leftDiv).children('div.daterangebox-calendar-inner');
			var ccRight = $(rightDiv).children('div.daterangebox-calendar-inner');
			
			//_outerWidth 在jquery.parser.js中有定义.
			//panel.children()._outerWidth(panel.width());
			panel.children().not('table')._outerWidth(panel.width()/2);
			
			state.calendar.appendTo(cc);
			state.calendarRight.appendTo(ccRight);
			
			//important
			state.calendar[0].target = target;
			state.calendarRight[0].target = target;
			
			
			if (opts.panelHeight != 'auto'){
				var height = panel.height();
				//panel.children().not(cc).each(function(){
				$(leftDiv).children().not(cc).each(function(){
					height -= $(this).outerHeight();
				});
				
				cc._outerHeight(height);
				ccRight._outerHeight(height);
				
			}
			
			state.calendar.calendar('resize');
			state.calendarRight.calendar('resize');
		}
	}

	function controlRightCalendar(state, leftTime){
		//右边的日期必须大于或等于左边的日期.
		state.calendarRight.calendar({
			validator: function(date){
				if(date.getTime() >= leftTime){
					return true;
				}
				return false;
			},
			styler: function(date){
				if(date.getTime() >= leftTime){
					return '';
				}
				return 'color:#cccccc';
			}
		});
		$.parser.parse(state.calendarRight);
	}
	
	function setValueLeft(target, value, remainText){
		var state = $.data(target, 'daterangebox');
		var opts = state.options;
		
		state.calendar.calendar('moveTo', opts.parser.call(target, value));
		state.leftInput.textbox('setValue', value);
		//
		var leftTime = new Date(value.replace(/-/g, '/')).getTime();
		controlRightCalendar(state, leftTime);
	}
	
	function setValueRight(target, value, remainText){
		var state = $.data(target, 'daterangebox');
		var opts = state.options;

		state.calendarRight.calendar('moveTo', opts.parser.call(target, value));		
		state.rightInput.textbox('setValue', value);
		state.rightInput.textbox('textbox').parent('span').removeClass('daterangebox-alert-border');
	}

	/**
	 * 
	 */
	function setValue(target, value, remainText){
		var state = $.data(target, 'daterangebox');
		var opts = state.options;
		var leftVal = '', rightVal = '';
		
		if(value){
			var valArr = value.split(' - ');
			leftVal = $.trim(valArr[0]);
			rightVal = $.trim(valArr[1]);
		}

		var leftDate = opts.parser.call(target, leftVal), ld = leftDate;
		//
		controlRightCalendar(state, new Date(ld.getFullYear()+'/'+(ld.getMonth()+1)+'/'+ld.getDate()).getTime());
		state.calendar.calendar('moveTo', leftDate);
		state.calendarRight.calendar('moveTo', opts.parser.call(target, rightVal));
		
		
		
		/*if (remainText){
			$(target).combo('setValue', value);
		} else {
			if (value){
				value = opts.formatter.call(target, calendar.calendar('options').current);
			}
			$(target).combo('setText', value).combo('setValue', value);
		}*/
	}
	
	/**
	 * 构造方法.
	 */
	$.fn.daterangebox = function(options, param){
		
		if (typeof options == 'string'){
			var method = $.fn.daterangebox.methods[options];
			if (method){
				//当 method 是"daterangebox"定义的方法是,直接调用.
				return method(this, param);
			} else {
				//否则,调用combo对应的方法.
				return this.combo(options, param);
			}
		}
		
		options = options || {};
		
		return this.each(function(){
			
			var state = $.data(this, 'daterangebox');
			
			if (state){
				$.extend(state.options, options);
			} else {
				//在元素上存放(set)数据. 除了'cloneFrom'方法外,其他地方都是获取(get).
				$.data(this, 'daterangebox', {
					// 拷贝 $.fn.daterangebox.defaults 数据.
					options: $.extend({}, $.fn.daterangebox.defaults, $.fn.daterangebox.parseOptions(this), options)
				});
			}
			//
			createBox(this);
		});
	};
	
	$.fn.daterangebox.methods = {
		
		//测试发现,'options'方法在内部调用非常频繁.
		options: function(jq){
			var copts = jq.combo('options');
			return $.extend($.data(jq[0], 'daterangebox').options, {
				width: copts.width,
				height: copts.height,
				originalValue: copts.originalValue,
				disabled: copts.disabled,
				readonly: copts.readonly
			});
		},
		
		//暴露给用户使用的API.获得calendar对象.
		calendar: function(jq){	// get the calendar object
			return $.data(jq[0], 'daterangebox').calendar;
		},
		
		initValue: function(jq, value){
			return jq.each(function(){
				var opts = $(this).daterangebox('options');
				var value = opts.value;
				if (value){
					//下文有定义'formatter','parser'方法.
					value = opts.formatter.call(this, opts.parser.call(this, value));
				}
				//最终还是会调用'combo'的方法, 并且还调用'setText'方法
				$(this).combo('initValue', value).combo('setText', value);
			});
		},
		setValue: function(jq, value){
			return jq.each(function(){
				//调用本模块定义的'setValue'函数.
				setValue(this, value);
			});
		},
		reset: function(jq){
			return jq.each(function(){
				var opts = $(this).daterangebox('options');
				// opts.originalValue -> 来自combo -> 为空字符串.
				$(this).daterangebox('setValue', opts.originalValue);
			});
		}
	};
	
	//此方法可提供给子类使用.譬如下面的"$.fn.combo.parseOptions(target)".
	$.fn.daterangebox.parseOptions = function(target){
		return $.extend({}, $.fn.combo.parseOptions(target), $.parser.parseOptions(target));
	};
	
	$.fn.daterangebox.defaults = $.extend({}, $.fn.combo.defaults, {
		//panelWidth:180,
		panelWidth:400,
		panelHeight:'auto',
		
		/*currentText:'Today',
		closeText:'Close',*/
		
		formatter:function(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			//return (m<10?('0'+m):m)+'/'+(d<10?('0'+d):d)+'/'+y;
			return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
		},
		parser:function(s){
			if (!s) return new Date();
			//var ss = s.split('/');
			var ss = s.split('-');
			var m = parseInt(ss[0],10);
			var d = parseInt(ss[1],10);
			var y = parseInt(ss[2],10);
			if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
				return new Date(y,m-1,d);
			} else {
				return new Date();
			}
		},
		
		onSelect:function(date){}
	});
})(jQuery);
