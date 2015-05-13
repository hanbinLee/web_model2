/**
 * 
 */

Yonsan=function(su1,buho,su2){
	this.su1 = parseInt(su1);
	this.buho = buho;
	this.su2 = parseInt(su2);
	this.result;
}

Yonsan.prototype={
		check:function(){
			if(this.buho=="+"){
				this.result=this.su1+this.su2;
			}else if(this.buho=="-"){
				this.result=this.su1-this.su2;
			}else if(this.buho=="*"){
				this.result=this.su1*this.su2;
			}else if(this.buho=="/"){
				this.result=Math.round((this.su1/this.su2)*100)/100; //소수 둘째짜리까지 반올림
			}else{
				this.result="Error";
			}
		},
		
		disp:function(){
			value = document.getElementById("value");
			value.innerHTML = this.result;
		}
};

