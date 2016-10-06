<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
    <meta charset="UTF-8">
    <title>경쟁전 점수</title>
    <script src="jquery-3.1.0.js"></script>
    <script>

        $(document).ready(function(){

            $.ajax({
                type : "post",
                url : "/players",
                dataType : "json",
                success : function(data) {
                    var playerList = data.players;
                    writePlayerList(playerList);
                }
            });

            $("#write").click(function(){
                $("#write").attr("disabled", true);

                var obj = new Object();
                var form = document.writeform;
                obj.name = form.name.value;;
                obj.nickName = form.nickName.value;
                obj.battleTag = form.battleTag.value;

                var $sendRequest = $.ajax({
                    url : "/write",
                    method: "post",
                    type: "json",
                    contentType: "application/json",
                    data : JSON.stringify(obj),
                    success : function(msg){
                        if(msg == "OK") {
                            $.ajax({
                                type : "post",
                                url : "/players",
                                dataType : "json",
                                success : function(data) {
                                    var playerList = data.players;
                                    writePlayerList(playerList);
                                }
                            });
                        }
                        else
                            alert("ERROR");
                        $("#write").attr("disabled", false);
                    }
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
            <td><input id="name" size="50" maxlength="100" placeholder="ex) 홍석진"></td>
            <td>&nbsp;</td>
        </tr>
        <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
        <tr>
            <td>&nbsp;</td>
            <td align="center">닉네임</td>
            <td><input id="nickName" size="50" maxlength="50" placeholder="ex) Tuna"></td>
            <td>&nbsp;</td>
        </tr>
        <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
        <tr>
            <td>&nbsp;</td>
            <td align="center">배틀태그</td>
            <td><input id="battleTag" size="50" maxlength="50" placeholder="ex) 3927"></td>
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

<script>
    function writePlayerList(players) {
        $("#playerList").html("");
        players.forEach(function(e){
            var $newDiv = $("<div>");
            $newDiv.text(e.name + " " + e.nickName + " " + e.competitivePoint + "점");
            $("#playerList").append($newDiv);
            console.log(e);
        });
    };
</script>

</html>