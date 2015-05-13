/**
 *  클래스 이름 = function(){}
 *  클래스이름.prototype.함수이름 = function() {}
 *  자바스크립트에서 this는 생략 불가능
 */

Fruit = function(){
	this.msg="마시는"; //this 전역변수 var 지역변수
}

Fruit.prototype.taste = function(){
	var str="과일";
	
	this.aa="gkgkgk";
	
	alert(this.msg + str); 
}

Fruit.prototype.disp=function(){
	alert("disp function");
}


Apple=function(){}

Apple.prototype=new Fruit(); //상속

Apple.prototype.taste=function(){
	var str="사과";
	alert(this.msg + str);
}

Orange=function(){}

Orange.prototype=new Fruit();
Orange.prototype.taste=function(){
	var str="orange";
	alert(this.msg + str);
}