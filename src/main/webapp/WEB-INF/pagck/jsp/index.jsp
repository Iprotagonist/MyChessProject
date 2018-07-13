<%@ page contentType="text/html;charset=gb2312" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>�й�������Ϸ</title>
    <link href="res/css/zzsc.css" type="text/css" rel="stylesheet" />
    <link rel="shortcut icon" href="/img/icon/favicon.ico" />
</head>
<body>
<div class="box" id="box">
    <div class="chess_left">
        <canvas id="chess">�Բ��������������֧��HTML5���������������IE9��firefox���߹ȸ��������</canvas>
        <audio src="audio/click.wav" id="clickAudio" preload="auto"></audio>
        <audio src="audio/select.wav" id="selectAudio" preload="auto"></audio>
        <div>
            <div class="bn_box" id="bnBox">
                <input type="button" name="offensivePlay" id="tyroPlay" value="����ˮƽ" />
                <input type="button" name="offensivePlay" id="mediumPlay" value="�м�ˮƽ" />
                <input type="button" name="offensivePlay" id="superPlay" value="��ʦˮƽ"  />
                <!--
            <input type="button" name="offensivePlay" id="offensivePlay" value="���ֿ�ʼ" />
            <input type="button" name="defensivePlay" id="defensivePlay" value="���ֿ�ʼ" />
            -->
                <input type="button" name="regret" id="regretBn" value="����" />
                <input type="button" name="billBn" id="billBn" value="����" class="bn_box" />
                <input type="button" name="stypeBn" id="stypeBn" value="����" />
            </div>
        </div>
    </div>
    <div class="chess_right" id="chessRight">
        <select name="billList" id="billList">
        </select>
        <ol id="billBox" class="bill_box">
        </ol>
    </div>
    <%--AI�������߷�--%>
    <div id="moveInfo" class="move_info">
    </div>
</div>
<script src="js/common.js"></script>
<script src="js/play.js"></script>
<script src="js/AI.js"></script>
<script src="js/bill.js"></script>
<script src="js/gambit.js"></script>
</body>
</html>