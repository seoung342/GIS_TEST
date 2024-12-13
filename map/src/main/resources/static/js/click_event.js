function setupClickEvent(map) {
    // 지도 클릭시
    map.on('click', function (event) {
        var coordinate = event.coordinate;
        var view = map.getView();
        var resolution = view.getResolution();
        var projection = view.getProjection();

        // 클릭한 위치 좌표
        var lonLatText = '클릭한 위치의 위도 : ' +  coordinate[1].toFixed(6) + ', 경도 : ' + coordinate[0].toFixed(6); // 위도, 경도
        let coordinateText = document.getElementById("map_position");
        coordinateText.textContent = lonLatText;

        // 클릭한 위치 이름
        var url1 = map.getLayers().item(1).getSource().getGetFeatureInfoUrl(coordinate, resolution, projection, {
            'INFO_FORMAT': 'application/json'
        });
        if (url1) {
            fetch(url1)
                .then(response => response.json())
                .then(data => {
                    const name = data.features[0].properties.name;
                    let text = document.getElementById("map_text");
                    text.textContent = '현재 클릭한 곳은 ' + name + ' 입니다.';
                })
                .catch(error => console.error('Error fetching feature info:', error));
        }
    });
}
