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
            var $getPlayerList = $.ajax({
                type : "post",
                url : "/players",
                dataType : "json",
                success : function(data) {
                    var players = data.players;
                    $("#playerList").html("");
                    players.forEach(function(e){
                        var $newDiv = $("<div>");
                        $newDiv.text(e.name + " " + e.nickName + " " + e.competitivePoint + "점");
                        $("#playerList").append($newDiv);
                        console.log(e);
                    });
                }
            });
            $getPlayerList.done();

            $("#write").click(function(){
                $("#write").attr("disabled", true);
                var form = document.writeform;
                var name = form.name.value;
                var nickName = form.nickName.value;
                var battleTag = form.battleTag.value;

                var obj = new Object();
                obj.name = name;
                obj.nickName = nickName;
                obj.battleTag = battleTag;

                //alert(JSON.stringify(obj));

                var $sendRequset = $.ajax({
                    url : "/write",
                    method: "post",
                    type: "json",
                    contentType: "application/json",
                    data : JSON.stringify(obj),
                    success : function(msg) {
                        //alert(msg);
                    }
                });

                $sendRequset.done(function(msg){
                    if(msg == "OK")
                        $getPlayerList.done();
                    else
                        alert("ERROR");

                    $("#write").attr("disabled", false);
                });
            });

        });
    </script>
</head>
<body>
<form name=writeform method=post >
    <table>
        <tr>
            <td>&nbsp;</td>
            <td align="center">이름</td>
            <td><input id="name" size="50" maxlength="100" value="ex) 홍석진"></td>
            <td>&nbsp;</td>
        </tr>
        <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
        <tr>
            <td>&nbsp;</td>
            <td align="center">닉네임</td>
            <td><input id="nickName" size="50" maxlength="50" value="ex) Tuna"></td>
            <td>&nbsp;</td>
        </tr>
        <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
        <tr>
            <td>&nbsp;</td>
            <td align="center">배틀태그</td>
            <td><input id="battleTag" size="50" maxlength="50" value="ex) 3927"></td>
            <td>&nbsp;</td>
        </tr>
        <tr align="center">
            <td>&nbsp;</td>
            <td colspan="2">
                <input type=button value="등록" id="write">
            <td>&nbsp;</td>
        </tr>
    </table>
</form>
<div align="center" id="playerList">
</div>
</body>


