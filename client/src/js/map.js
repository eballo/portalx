var map;
var pointMarker = new Array(); //store marker in array
var bounds;

var data = { "locations": [
  { "description":"Text1", "latitude": 52.353193, "longitude": 4.852484 },
  { "description":"Text2", "latitude": 52.355516, "longitude": 4.826854 },
  { "description":"Text3", "latitude": 52.350631, "longitude": 4.839959 }
]};

function initMap() {
  var myOptions = {
         center: new google.maps.LatLng(50.397, 5.644),
         zoom: 2,
         minZoom: 2,
         streetViewControl: false,
         mapTypeControl: false,
         mapTypeControlOptions: {
             mapTypeIds: ["custom"]
         }
     };

 map = new google.maps.Map(document.getElementById('map'), myOptions);
}

function handleClick(){
  var lat =  $('input[name=txtLat]').val();
  var long =  $('input[name=txtLong]').val();
  var dist =  $('input[name=txtDist]').val();
  console.log("Latitude: " + lat);
  console.log("Longitude: " + long);
  console.log("Distance: " + dist);
  //doAjaxCall(lat, long, dist);
  console.log('Call must be done.. for now..');
  console.log(data);

  drawData(map, data);

}

function doAjaxCall(lat, long, dist){
  $.ajax({
    url: "ajax.aspx",
    type: "get", //send it through get method
    data: {
      latitude: lat,
      longitude: long,
      distance: dist
    },
    success: function(response) {
      //Do Something
    },
    error: function(xhr) {
      //Do Something to handle error
    }
  });
}

function drawData(map, data){
  addMarkers(map, data);

  map.fitBounds(bounds);
}

function addMarkers(map, data){
  bounds = new google.maps.LatLngBounds();
  for (i = 0; i < data.locations.length; i++) {
    console.log(data.locations[i])
    marker = new google.maps.Marker({
         position: new google.maps.LatLng(data.locations[i].latitude, data.locations[i].longitude),
         map: map
    });
    bounds.extend(marker.position);
  }
  //now fit the map to the newly inclusive bounds
  map.fitBounds(bounds);
}
