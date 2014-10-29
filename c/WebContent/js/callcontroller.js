APPLICATION_CONTEXT = "/c/";
APPLICATION_CONTROLLER = "c";
APPLICATION_DOMAIN = "";
APPLICATION_PAGE_OBJECT = "";
UserEditCheckBox = [];
CONFIRM_STATUS = false;
var AJAX_PREFIX = "requesttype=AJAX&";
var AJAX_DATA;
var xmlObject;
function getAJAXObject() {
    var ajaxObject;
    try {
        ajaxObject = new XMLHttpRequest();
    } catch (e) {
        try {
            ajaxObject = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                ajaxObject = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
            }
        }
    }
    return ajaxObject;
}
function bingo(data){
	alert("i am back from controller");
	alert(data);
}
function sendAJAXRequest(method, query, bingo) {
    xmlObject = getAJAXObject();
    var currentPath = window.location.toString();
    APPLICATION_DOMAIN = currentPath.substring(0, currentPath.indexOf("/", 8));
    xmlObject.onreadystatechange = function() {
        if (xmlObject.readyState === 4) {
            var data = xmlObject.responseText;
            //redirect(JSON.parse(data));
            console.log(data);
            var fn = window[bingo];
            fn(data);
        }
    };
    if (method === "GET") {
        var url = encodeURI(APPLICATION_DOMAIN + APPLICATION_CONTEXT + APPLICATION_CONTROLLER + "?" + AJAX_PREFIX + query);
        xmlObject.open(method, url, true);
        xmlObject.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlObject.send();
    } else if (method === "POST") {
        xmlObject.open(method, APPLICATION_DOMAIN + APPLICATION_CONTEXT + APPLICATION_CONTROLLER, true);
        xmlObject.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlObject.send(AJAX_PREFIX + query);
    }
}

