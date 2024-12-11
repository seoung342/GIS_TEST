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
postgre sql에 더 편하게 올리는 방법    
1. PostgreSql에서 데이터 베이스를 만든다.
2. QGIS 열기 -> 레이어 -> 레이어 추가 -> 새 백터 레이어 -> shp 파일 선택
3. 탐색기 -> PostgreSQL -> 새 연결 -> 만든 데이터 베이스 연결 정보 입력 -> 확인    
4. 생긴 데이터베이스 접속 -> 만든 레이어 드래그 -> public 위에 드랍 -> 확인    

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
PostGIS 함수 목록   
1. Geometry 함수 (Geometry Functions)    
   ST_AsText(geometry): Geometry를 WKT(Well-Known Text)로 변환합니다.    
   ST_AsBinary(geometry): Geometry를 WKB(Well-Known Binary)로 변환합니다.    
   ST_GeometryType(geometry): Geometry 객체의 타입을 반환합니다.    
   ST_Area(geometry): 면적을 계산합니다.    
   ST_Perimeter(geometry): 경계를 계산합니다.    
   ST_Length(geometry): 선분의 길이를 계산합니다.    
   ST_Boundary(geometry): Geometry 객체의 경계를 반환합니다.    
   ST_Centroid(geometry): Geometry의 중심점을 반환합니다.    
   ST_ConvexHull(geometry): Geometry의 볼록한 외각을 반환합니다.    
   ST_Envelope(geometry): Geometry를 포함하는 최소 직사각형(bounding box)을 반환합니다.    
   ST_Union(geometry, geometry): 두 개 이상의 Geometry 객체를 결합합니다.    
   ST_Intersection(geometry, geometry): 두 Geometry 객체의 교차 부분을 반환합니다.    
   ST_Difference(geometry, geometry): 첫 번째 Geometry에서 두 번째 Geometry를 뺀 부분을 반환합니다.    
   ST_SymDifference(geometry, geometry): 두 Geometry 객체의 대칭 차집합을 반환합니다.    
   ST_Intersects(geometry, geometry): 두 Geometry가 교차하는지 여부를 반환합니다.    
   ST_Contains(geometry, geometry): 첫 번째 Geometry가 두 번째 Geometry를 포함하는지 확인합니다.    
   ST_Within(geometry, geometry): 첫 번째 Geometry가 두 번째 Geometry 내에 있는지 확인합니다.    
2. Spatial Relationships 함수 (Spatial Relationship Functions)    
   ST_Equal(geometry, geometry): 두 Geometry가 동일한지 확인합니다.    
   ST_Touches(geometry, geometry): 두 Geometry가 접하는지 확인합니다.    
   ST_Crosses(geometry, geometry): 두 Geometry가 교차하는지 확인합니다.    
   ST_Disjoint(geometry, geometry): 두 Geometry가 겹치지 않는지 확인합니다.    
   ST_Overlaps(geometry, geometry): 두 Geometry가 겹치는지 확인합니다.    
   ST_Within(geometry, geometry): 첫 번째 Geometry가 두 번째 Geometry 내에 포함되는지 확인합니다.    
   ST_Contains(geometry, geometry): 첫 번째 Geometry가 두 번째 Geometry를 포함하는지 확인합니다.    
   3. Distance 함수 (Distance Functions)    
   ST_Distance(geometry, geometry): 두 Geometry 간의 최단 거리를 계산합니다.    
   ST_MaxDistance(geometry, geometry): 두 Geometry 간의 최대 거리를 계산합니다.    
   ST_ClosestPoint(geometry, geometry): 두 Geometry 간 가장 가까운 점을 반환합니다.    
   ST_FurthestPoint(geometry, geometry): 두 Geometry 간 가장 먼 점을 반환합니다.    
4. 위치 및 좌표 함수 (Location & Coordinate Functions)    
   ST_X(geometry): Geometry 객체의 X 좌표를 반환합니다.    
   ST_Y(geometry): Geometry 객체의 Y 좌표를 반환합니다.    
   ST_Z(geometry): Geometry 객체의 Z 좌표를 반환합니다.   
   ST_Point(geometry): 좌표값을 이용해 포인트 객체를 생성합니다.    
   ST_SetSRID(geometry, srid): Geometry 객체에 SRID(Spatial Reference System Identifier)를 설정합니다.    
   ST_SRID(geometry): Geometry 객체의 SRID를 반환합니다.    
5. 데이터 변환 함수 (Transformation Functions)    
   ST_Transform(geometry, srid): Geometry를 다른 좌표계(SRID)로 변환합니다.    
   ST_Translate(geometry, x, y, z): Geometry 객체를 x, y, z 방향으로 이동시킵니다.    
   ST_Rotate(geometry, angle): Geometry 객체를 주어진 각도로 회전시킵니다.    
   ST_Scale(geometry, x, y, z): Geometry 객체를 주어진 비율로 확장 또는 축소시킵니다.    
6. 인덱스 및 성능 함수 (Index & Performance Functions)    
   ST_ClusterWithin(geometry[], distance): 주어진 거리 내에서 점들을 그룹화합니다.   
   ST_ClusterDBSCAN(geometry[], eps, minPoints): DBSCAN 알고리즘을 사용하여 공간 클러스터링을 수행합니다.    
   ST_ContainsProperly(geometry, geometry): 첫 번째 Geometry가 두 번째 Geometry를 제대로 포함하는지 확인합니다.    
   7. Geography 함수 (Geography Functions)    
   ST_AsGeography(geometry): Geometry 객체를 Geography 객체로 변환합니다.    
   ST_GeogFromText(text): WKT를 사용해 Geography 객체를 생성합니다.    
   ST_Distance(geography, geography): 두 Geography 객체 간의 거리를 계산합니다.    
   ST_Area(geography): Geography 객체의 면적을 계산합니다.    
   ST_Length(geography): Geography 객체의 길이를 계산합니다.    
8. 기타 유용한 함수 (Miscellaneous Functions)    
   ST_IsValid(geometry): Geometry 객체가 유효한지 확인합니다.    
   ST_IsSimple(geometry): Geometry 객체가 간단한지 확인합니다.    
   ST_IsEmpty(geometry): Geometry 객체가 비어있는지 확인합니다.    
   ST_IsRing(geometry): Geometry가 링(닫힌 경로)인지 확인합니다.    
   ST_Simplify(geometry, tolerance): Geometry 객체를 단순화하여 복잡도를 줄입니다.    
   ST_MemSize(geometry): Geometry 객체가 차지하는 메모리 크기를 반환합니다.    
9. Raster 함수 (Raster Functions)    
   ST_Clip(raster, geometry): 래스터 데이터를 지정된 Geometry로 자릅니다.    
   ST_Resample(raster, scaleX, scaleY): 래스터 데이터를 지정된 비율로 리샘플링합니다.    
   ST_Value(raster, x, y): 특정 x, y 위치에서 래스터의 값을 반환합니다.    

--------------------------------

ps. 궁금한거는 chat gpt 물어보기    
ps. Issues에 결과 화면 있음    
geoserver-2.26.1     
QGIS 3.34.13    
Postgre SQL 16.6.1
