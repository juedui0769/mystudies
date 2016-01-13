/**
 * parse options including standard 'data-options' attribute.
 * 
 * calling example:
 * $.parser.parseOptions(target);
 * $.parser.parseOptions(target, ['id','title','width',{fit:'boolean',border:'boolean'},{min:'number'}]);
 */
parseOptions: function(target, properties){
	var t = $(target);
	var options = {};
	
	var s = $.trim(t.attr('data-options'));
	if(s){
		if(s.substring(0,1) != '{'){
			s = '{' + s + '}';
		}
		options = (new Function('return ' + s))();
	}
	$.map(['width','height','left','top','minWidth','maxWidth','minHeight','maxHeight'], function(p){
		var pv = $.trim(target.style[p] || '');
		if(pv){
			if(pv.indexOf('%') == -1){
				pv = parseInt(pv) || undefined;
			}
			options[p] = pv;
		}
	});
	
	if(properties){
		var opts = {};
		for(var i=0; i<properties.length; i++){
			var pp = properties[i];
			if(typeof pp == 'string'){
				opts[pp] = t.attr(pp);
			}else{
				for(var name in pp){
					var type = pp[name];
					if(type == 'boolean'){
						opts[name] = t.attr(name) ? (t.attr(name) == 'true') : undefined;
					}else if(type == 'number'){
						opts[name] = t.attr(name)=='0' ? 0 : parseFloat(t.attr(name)) || undefined;
					}
				}
			}
		}
		$.extend(options, opts);
	}
	
	return options;
}