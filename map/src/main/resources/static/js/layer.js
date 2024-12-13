function createMap() {
    // OpenLayers Map 객체 생성
    var map = new ol.Map({
        target: 'map', // map div에 지도 표시
        layers: [
            new ol.layer.Tile({
                source: new ol.source.OSM()  // OpenStreetMap 배경 지도
            }), // 0번
            new ol.layer.Tile({
                source: new ol.source.TileWMS({
                    url: 'http://localhost:8080/geoserver/ne/wms',  // GeoServer WMS URL
                    params: {
                        'LAYERS': 'ne:busan',  // 사용하려는 레이어 이름
                        'TILED': true,
                        'FORMAT': 'image/png',
                        'SRS': 'EPSG:4326'  // 좌표계 설정
                    },
                    serverType: 'geoserver'
                }),
                visible: false  // 기본적으로 WMS 레이어가 보이지 않도록 설정
            }), // 부산
            new ol.layer.Tile({
                source: new ol.source.TileWMS({
                    url: 'http://localhost:8080/geoserver/ne/wms',  // GeoServer WMS URL
                    params: {
                        'LAYERS': 'ne:chungcheongbuk-do',  // 사용하려는 레이어 이름
                        'TILED': true,
                        'FORMAT': 'image/png',
                        'SRS': 'EPSG:4326'  // 좌표계 설정
                    },
                    serverType: 'geoserver'
                }),
                visible: false  // 기본적으로 WMS 레이어가 보이지 않도록 설정
            }),// 경북
            new ol.layer.Tile({
                source: new ol.source.TileWMS({
                    url: 'http://localhost:8080/geoserver/ne/wms',  // GeoServer WMS URL
                    params: {
                        'LAYERS': 'ne:chungcheongnam-do',  // 사용하려는 레이어 이름
                        'TILED': true,
                        'FORMAT': 'image/png',
                        'SRS': 'EPSG:4326'  // 좌표계 설정
                    },
                    serverType: 'geoserver'
                }),
                visible: false  // 기본적으로 WMS 레이어가 보이지 않도록 설정
            }), // 경남
            new ol.layer.Tile({
                source: new ol.source.TileWMS({
                    url: 'http://localhost:8080/geoserver/ne/wms',  // GeoServer WMS URL
                    params: {
                        'LAYERS': 'ne:daegu',  // 사용하려는 레이어 이름
                        'TILED': true,
                        'FORMAT': 'image/png',
                        'SRS': 'EPSG:4326'  // 좌표계 설정
                    },
                    serverType: 'geoserver'
                }),
                visible: false  // 기본적으로 WMS 레이어가 보이지 않도록 설정
            }), // 대구
            new ol.layer.Tile({
                source: new ol.source.TileWMS({
                    url: 'http://localhost:8080/geoserver/ne/wms',  // GeoServer WMS URL
                    params: {
                        'LAYERS': 'ne:daejeon',  // 사용하려는 레이어 이름
                        'TILED': true,
                        'FORMAT': 'image/png',
                        'SRS': 'EPSG:4326'  // 좌표계 설정
                    },
                    serverType: 'geoserver'
                }),
                visible: false  // 기본적으로 WMS 레이어가 보이지 않도록 설정
            }), // 대전
            new ol.layer.Tile({
                source: new ol.source.TileWMS({
                    url: 'http://localhost:8080/geoserver/ne/wms',  // GeoServer WMS URL
                    params: {
                        'LAYERS': 'ne:gangwon',  // 사용하려는 레이어 이름
                        'TILED': true,
                        'FORMAT': 'image/png',
                        'SRS': 'EPSG:4326'  // 좌표계 설정
                    },
                    serverType: 'geoserver'
                }),
                visible: false  // 기본적으로 WMS 레이어가 보이지 않도록 설정
            }), // 강원도
            new ol.layer.Tile({
                source: new ol.source.TileWMS({
                    url: 'http://localhost:8080/geoserver/ne/wms',  // GeoServer WMS URL
                    params: {
                        'LAYERS': 'ne:gwangju',  // 사용하려는 레이어 이름
                        'TILED': true,
                        'FORMAT': 'image/png',
                        'SRS': 'EPSG:4326'  // 좌표계 설정
                    },
                    serverType: 'geoserver'
                }),
                visible: false  // 기본적으로 WMS 레이어가 보이지 않도록 설정
            }), // 광주
            new ol.layer.Tile({
                source: new ol.source.TileWMS({
                    url: 'http://localhost:8080/geoserver/ne/wms',  // GeoServer WMS URL
                    params: {
                        'LAYERS': 'ne:gyeonggi-do',  // 사용하려는 레이어 이름
                        'TILED': true,
                        'FORMAT': 'image/png',
                        'SRS': 'EPSG:4326'  // 좌표계 설정
                    },
                    serverType: 'geoserver'
                }),
                visible: false  // 기본적으로 WMS 레이어가 보이지 않도록 설정
            }), // 경기도
            new ol.layer.Tile({
                source: new ol.source.TileWMS({
                    url: 'http://localhost:8080/geoserver/ne/wms',  // GeoServer WMS URL
                    params: {
                        'LAYERS': 'ne:gyeongsangbuk-do',  // 사용하려는 레이어 이름
                        'TILED': true,
                        'FORMAT': 'image/png',
                        'SRS': 'EPSG:4326'  // 좌표계 설정
                    },
                    serverType: 'geoserver'
                }),
                visible: false  // 기본적으로 WMS 레이어가 보이지 않도록 설정
            }), // 경상북도
            new ol.layer.Tile({
                source: new ol.source.TileWMS({
                    url: 'http://localhost:8080/geoserver/ne/wms',  // GeoServer WMS URL
                    params: {
                        'LAYERS': 'ne:gyeongsangnam-do',  // 사용하려는 레이어 이름
                        'TILED': true,
                        'FORMAT': 'image/png',
                        'SRS': 'EPSG:4326'  // 좌표계 설정
                    },
                    serverType: 'geoserver'
                }),
                visible: false  // 기본적으로 WMS 레이어가 보이지 않도록 설정
            }), // 경상남도
            new ol.layer.Tile({
                source: new ol.source.TileWMS({
                    url: 'http://localhost:8080/geoserver/ne/wms',  // GeoServer WMS URL
                    params: {
                        'LAYERS': 'ne:\tincheon',  // 사용하려는 레이어 이름
                        'TILED': true,
                        'FORMAT': 'image/png',
                        'SRS': 'EPSG:4326'  // 좌표계 설정
                    },
                    serverType: 'geoserver'
                }),
                visible: false  // 기본적으로 WMS 레이어가 보이지 않도록 설정
            }), // 인천
            new ol.layer.Tile({
                source: new ol.source.TileWMS({
                    url: 'http://localhost:8080/geoserver/ne/wms',  // GeoServer WMS URL
                    params: {
                        'LAYERS': 'ne:jeju',  // 사용하려는 레이어 이름
                        'TILED': true,
                        'FORMAT': 'image/png',
                        'SRS': 'EPSG:4326'  // 좌표계 설정
                    },
                    serverType: 'geoserver'
                }),
                visible: false  // 기본적으로 WMS 레이어가 보이지 않도록 설정
            }), // 제주
            new ol.layer.Tile({
                source: new ol.source.TileWMS({
                    url: 'http://localhost:8080/geoserver/ne/wms',  // GeoServer WMS URL
                    params: {
                        'LAYERS': 'ne:jeollanam-do',  // 사용하려는 레이어 이름
                        'TILED': true,
                        'FORMAT': 'image/png',
                        'SRS': 'EPSG:4326'  // 좌표계 설정
                    },
                    serverType: 'geoserver'
                }),
                visible: false  // 기본적으로 WMS 레이어가 보이지 않도록 설정
            }), // 전남
            new ol.layer.Tile({
                source: new ol.source.TileWMS({
                    url: 'http://localhost:8080/geoserver/ne/wms',  // GeoServer WMS URL
                    params: {
                        'LAYERS': 'ne:jeonbuk',  // 사용하려는 레이어 이름
                        'TILED': true,
                        'FORMAT': 'image/png',
                        'SRS': 'EPSG:4326'  // 좌표계 설정
                    },
                    serverType: 'geoserver'
                }),
                visible: false  // 기본적으로 WMS 레이어가 보이지 않도록 설정
            }), // 전북
            new ol.layer.Tile({
                source: new ol.source.TileWMS({
                    url: 'http://localhost:8080/geoserver/ne/wms',  // GeoServer WMS URL
                    params: {
                        'LAYERS': 'ne:ulsan',  // 사용하려는 레이어 이름
                        'TILED': true,
                        'FORMAT': 'image/png',
                        'SRS': 'EPSG:4326'  // 좌표계 설정
                    },
                    serverType: 'geoserver'
                }),
                visible: false  // 기본적으로 WMS 레이어가 보이지 않도록 설정
            }), // 울산
            new ol.layer.Tile({
                source: new ol.source.TileWMS({
                    url: 'http://localhost:8080/geoserver/ne/wms',  // GeoServer WMS URL
                    params: {
                        'LAYERS': 'ne:seoul',  // 사용하려는 레이어 이름
                        'TILED': true,
                        'FORMAT': 'image/png',
                        'SRS': 'EPSG:4326'  // 좌표계 설정
                    },
                    serverType: 'geoserver'
                }),
                visible: false  // 기본적으로 WMS 레이어가 보이지 않도록 설정
            }), // 서울
            new ol.layer.Tile({
                source: new ol.source.TileWMS({
                    url: 'http://localhost:8080/geoserver/ne/wms',  // GeoServer WMS URL
                    params: {
                        'LAYERS': 'ne:sejong-si',  // 사용하려는 레이어 이름
                        'TILED': true,
                        'FORMAT': 'image/png',
                        'SRS': 'EPSG:4326'  // 좌표계 설정
                    },
                    serverType: 'geoserver'
                }),
                visible: false  // 기본적으로 WMS 레이어가 보이지 않도록 설정
            }) // 세종시
        ],
        view: new ol.View({
            projection: 'EPSG:4326',  // 지도 좌표계 설정
            center: [126.978, 37.566],  // 서울의 경도, 위도 좌표
            zoom: 11,  // 기본 줌 레벨
            minZoom: 1, // 최소 줌 레벨 설정
            maxZoom: 20, // 최대 줌 레벨 설정
        })
    });

    // 체크박스를 클릭할 때 레이어의 가시성 토글
    var wmsLayerCheckbox = document.getElementById('wmsLayerCheckbox');
    wmsLayerCheckbox.addEventListener('change', function() {
        for (let i = 1; i < 18; i++){ // let을 사용하여 반복 변수 선언
            var wmsLayer = map.getLayers().item(i); // WMS 레이어
            wmsLayer.setVisible(wmsLayerCheckbox.checked);  // 체크된 상태에 따라 레이어 표시/숨기기
        }
    });
    return map;
}
