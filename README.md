postgre sql 부터 GeoServer 까지
1. postgre sql에 gis 데이터 베이스를 만든다.
2. test data 폴더 안에 있는 test.shp 파일을 postgre sql에 데이터 베이스를 만들어서 올린다.

   2.1 PostGIS Shapefile을 연다.

   2.2 view connection details 클릭해서 postgre sql 정보를 입력

   2.3 Add File을 눌러서 test.shp 파일을 찾아서 클릭한다.

   2.4 import 버튼을 누른다.
4. 1,2 번에서 만든 데이터 베이스에서 CREATE EXTENSION postgis; 쿼리를 친다.
5. geoserver에 로그인한다. admin / geoserver
6. 저장소 -> 새로운 저장소 -> PostGIS 클릭
7. 작업공간 ne, 데이터 저장소 이름 test, 연결 파라미터는 postgre sql 정보 ( 참고 : https://dev-h2.tistory.com/76 )
8. 자신이 설치한 geoserver 폴더에 webapps\geoserver\WEB-INF로 간다
9. web.xml 파일에 있는 jetty cors filter, filter-mapping cross-origin 주석 제거

---------------------------------
레이어 스타일 적용 방법(test_data 폴더에 있는 population.shp, population.sld 사용)
1. QGIS 사용할 레이어를 벡터 이미지로 띄운다.
2. 레이어 -> 오른쪽 마우스 클릭 -> 속성 -> 심볼
3. 스타일 설정을 한다
4. 왼쪽 아래 스타일 -> 스타일 저장 -> SLD 확장자로 저장
5. GeoServer에 들어가서 로그인을 한다.
6. 스타일을 만든 레이어 저장소에 추가하기
7. 데이터 -> 스타일 -> 새로운 스타일 추가
8. 이름, 작업공간을 알 수 있는 거로 적는다.
9. 파일 선택 -> QGIS에서 저장한 SLD 파일을 선택한다.
10. 유효성 검증에서 문제가 없으면 저장한다.
11. 레이어 -> 스타일 적용할 레이어 선택
12. 발행 -> WMS 설정 -> 기본 스타일 -> 내가 저장한 이름을 선택 -> 저장
13. 레이어 미리보기에서 스타일이 적용 되었나 확인

-----------------------------------

AppConfig.java : 외부 API 호출을 사용할때 필요하다.    
WebConfig.java : CORS 설정이 필요하다면 필요하다.    
MyController : map.html 사용하기위해서    
ol.css : 지도에 필요한 css    
ol.js : 지도에 필요한 js    
map.html : 지도 표시    

-----------------------------------    
data 폴더     
.shp 확장자는 레이어 파일이고    
.sld 확장자는 스타일 파일이다.   
스타일 파일은 이름이 같은 이름의 .shp 파일에 적용한다.    

-----------------------------------

ps. 궁금한거는 chat gpt 물어보기    
ps. Issues에 결과 화면 있음    
geoserver-2.26.1     
QGIS 3.34.13    
Postgre SQL 16.6.1
