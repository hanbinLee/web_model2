Sungjuk=function(num,name,kor,eng,mat){
	this.num=num;
	this.name=name;
	this.kor=parseInt(kor);
	this.eng=parseInt(eng);
	this.mat=parseInt(mat);
}

Sungjuk.prototype={
		disp:function(){
			var view = document.getElementById("view");
			var str ="결과:" + "<br/>" + "번호:" + this.num + "<br/>" + "이름:" + this.name + "<br>"
			             + "총점:" + (this.kor+this.eng+this.mat) +"<br/>" + "평균:" + 
			             Math.round(((this.kor+this.eng+this.mat)/3)*100)/100;
			view.innerHTML = str;
		}
}