<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>

<style type="text/css">
     html { height: 100% }
     body { height: 100%; margin: 0; padding: 0 }
     #map_canvas { height: 100% }
</style>

<script type="text/javascript" src="../xhr/xhr.js"></script>
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=true"></script>	
	<!-- 구글맵스에서 제공하는 javascript -->
<script type="text/javascript">
	function toServer(){
		var addr=document.getElementById("addr").value;		//입력받은 주소
		//alert(addr);
		var url="http://maps.googleapis.com/maps/api/geocode/json";		//구글맵스에서 제공하는 접근가능한 서버?
		var params="address="+addr+"&sensor=true";						//꼭 함께 넘겨줘야하는 매개변수 address, sensor
		sendRequest("GET", url, fromServer, params);
	}
	
	function fromServer(){
		if(xhr.readyState==4&&xhr.status==200){
			//alert(xhr.responseText);	
			//json방식의 데이터(아직은 그냥 Text)가 넘어오겠지. url이 json형식으로 데이터를 넘겨받을 때 쓰는 서버의 주소거든
			//이제 넘어온 json방식의 데이터에서 위도와 경도를 꺼내 구글맵스에서 제공하는 javascript를 통해 지도를 뿌림 (style도 구글맵스에서 제공)
			//results 0번지의 geometry의 location의 lat과 lng를 꺼내야겠다.
			resultDisp(xhr.responseText);
		}
	}
	
	function resultDisp(responseText){
		alert(responseText);
		var obj=JSON.parse(responseText);		//Text로 받아온 데이터를 JSON으로 parse
		var lat=obj.results[0].geometry.location.lat;
		var lng=obj.results[0].geometry.location.lng;
		//alert(lat+" , "+lng);
		//이제 서버로부터 얻어서 뽑아온 위도와 경도를 지도를 뿌리는데 사용한다.		

		var mapOptions = {
			center : new google.maps.LatLng(lat, lng), /* 위도와 경도 */
			zoom : 15,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
		//구글맵스에서 제공하는 javascript에서  google.maps.LatLng랑 google.maps.Map라는 클래스의 정보들이 있다.
		//우리가 넣은 위도와 경도를 가지고 알아서 지도를 map_canvas에 뿌려줌

	}
</script>

</head>
<body>
	<input id="addr" type="text"/>
	<input type="button" value="클릭" onclick="toServer()"/>
	<br/><br/>
	
	 <div id="map_canvas" style="width:80%; height:80%"></div>
</body>
</html>