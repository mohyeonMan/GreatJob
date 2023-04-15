<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <title>daum Address</title>
</head>
<body>
<div id="wrap" style="display:none; width:100%; height:100%; margin:5px 0; position:relative"></div>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>

    var element_wrap = document.getElementById('wrap');
    element_wrap.style.display = 'block';

    var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
        new daum.Postcode({
            onClose: function(state){
                if(state == "FORCE_CLOSE"){
                    window.GreatJob.setClose();
                }
            },
            oncomplete: function(data) {
                if(data.userSelectedType=="R"){
                    window.GreatJob.setAddress(data.zonecode, data.roadAddress, data.buildingName);
                }
                else{
                    window.GreatJob.setAddress(data.zonecode, data.jibunAddress, data.buildingName);
                }

                element_wrap.style.display = 'none';
                document.body.scrollTop = currentScroll;
            },
            onresize : function(size) {
                element_wrap.style.height = size.height+'px';
            },
            width : '100%',
            height : '100%'
        }).embed(element_wrap);
</script>
</body>
</html>