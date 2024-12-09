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
