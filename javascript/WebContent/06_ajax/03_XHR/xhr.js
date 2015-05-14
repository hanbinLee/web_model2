
var xhr=null;

function startRequest(){
	createXHR();
	
	xhr.open("GET","responseXML.xml",true);
	xhr.send(null);
	xhr.onreadystatechange=resultProcess;
}

function createXHR(){
	if(window.XMLHttpRequest){
		xhr=new XMLHttpRequest();
	}else if(window.ActiveXObject){
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
}

function resultProcess(){
	if(xhr.readyState == 4 && xhr.status==200){
		processXML();
	}
}

function processXML(){
	var xmlDoc = xhr.responseXML;
	var studentList = xmlDoc.getElementsByTagName("student");
	
	var root = document.getElementById("divResult");
	var str="";
	root.className="font_style";
	
	var array = ['blue','red','green'];
	
	for(var i=0 ; i<studentList.length ; i++){
		var student = studentList[i].childNodes;
		var div = document.createElement("div");
		div.style.color=array[i];
		
		for(var j=0 ; j<student.length; j++){
			if(student[j].nodeType==1){
				var span = document.createElement("span");
				span.innerHTML =  student[j].firstChild.nodeValue+"&nbsp";
				div.appendChild(span);
			}
		}
		root.appendChild(div);
	}
}