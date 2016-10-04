<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
    <meta charset="UTF-8">
    <title>공부중</title>
    <style>
        body {
            font-size:9pt;
            font-family:"굴림";
        }
        div, p, ul, li {
            border:1px #eeeeee solid;
            margin:10px;
        }
        ul {
            padding:10px;
        }

    </style>
    <script src="jquery-3.1.0.js"></script>
    <script>
        $(document).ready(function(){
            $.ajax({
                type : "post",
                url : "/players",
                dataType : "json",
                success : function(data) {
                    var players = data.players;
                    players.forEach(function(e){
                        var $newDiv = $("<div>");
                        $newDiv.text(e.name + " " + e.nickName + " " + e.competitivePoint + "점");
                        $("#playerList").append($newDiv);
                        console.log(e);
                    });
                }
            });
        });
    </script>
</head>
<body>
<div align="center" id="playerList">
</div>
</body>


