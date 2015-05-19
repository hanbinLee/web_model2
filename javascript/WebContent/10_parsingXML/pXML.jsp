<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<!--user-scalable=no :: 확대 축소를 못하게 막아놨다는 뜻  -->
<title>Insert title here</title>
    
    <style type="text/css">
      html { height: 100% }
      body { height: 100%; margin: 0; padding: 0 }
      #map_canvas { height: 100% }
    </style>
    <script type="text/javascript"
      src="http://maps.googleapis.com/maps/api/js?sensor=true">
   			 /* 인터넷으로 연결하는 것 도메인 주소로 javascript를 가져옴?? */
    		/*아래 google.maps.LatLng 나 google.maps.Map 객체에 대한 내용은 요기에 있겠지 */
    		/*sensor는 GPS? false로 해도 true로 해도 되네 :) */
    </script>
    <script type="text/javascript">
      function initialize() { //키 : 값 
        var mapOptions = {							
          center: new google.maps.LatLng(37.5240220, 126.9265940),		/* 위도와 경도 */
          																//지오코딩을 참조
          zoom: 8,//숫자가 작을수록 작아지고 클수록 확대되겠지!!! 구글에서 막아놔서 이걸로 확대축소해야된다.
          mapTypeId: google.maps.MapTypeId.ROADMAP				/* 구글 맵 사이트에서 여러가지 종류를 볼 수 있다. */
      	  //ROADMAP, SATELLITE, HYBRID, TERRAIN
        };
        var map = new google.maps.Map(document.getElementById("map_canvas"),
            mapOptions);
     /*
               참조 사이트 ::
          https://developers.google.com/maps/documentation/javascript/services#Geocoding
     */
        
      };
    </script>

</head>
  <body>
  	<a href="http://maps.googleapis.com/maps/api/geocode/json?address='서울시마포구상암동'&sensor='true'">서울시 마포구 상암동</a>
  	<!-- json방식으로 데이터를 가져온다. -->
  	<!-- 그럼 데이터 중 서울시마포구상암동의 위도와 경도를 가져와서 위에 javascript에서 mapOptions변수로 위도경도 설정한 것처럼 설정해서 지도를 가져와야겠다. -->
  	<!-- pMaps.jsp에서 주소를 입력받아 지도 띄우는 것을 해보자 -->
  	<!-- address와 sensor는 꼭 값을 지정해주어야하는 필수 매개변수. -->
  	<br/><br/>
  	
  	<input type="button" value="클릭" onclick="initialize()"/>
    <div id="map_canvas" style="width:100%; height:100%"></div>
    <!-- 전체화면이 100% -->
      
  </body>
</html>