/**
 * 
 */
/*
Member=function(arg){
	this.arg = arg;
}

Member.prototype.vegetableView=function(){
	var msg="양파";
	this.disp(msg);
}

Member.prototype.fruitView=function(){
	var msg="딸기";
	this.disp(msg);
}

Member.prototype.disp=function(msg){
	var str=this.arg + msg;
	//alert(str);
	
	div=document.createElement("div");
	div.innerHTML=str;
	br=document.createElement("br");
	
	document.body.appendChild(div);
	document.body.appendChild(br);
}

*/

//JSON (Javascript Object Notation) {이름:값 , 이름:값}
Member=function(arg){
	this.arg=arg;
};

Member.prototype={
	vegetableView:function(){
		msg="양파";
		this.disp(msg);
	},	
	
	fruitView:function(){
		msg="딸기";
		this.disp(msg);
	},
	
	disp:function(msg){
		str=this.arg + msg;
		
		div=document.createElement("div");
		div.innerHTML=str;
		br=document.createElement("br");
		
		document.body.appendChild(div);
		document.body.appendChild(br);
	}
};
