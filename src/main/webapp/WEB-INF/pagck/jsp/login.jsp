<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎来到中国象棋</title>
    <link href="res/css/login.css" type="text/css" rel="stylesheet"/>
    <link rel="shortcut icon" href="/img/icon/favicon.ico" />
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="js/layer/layer.js"></script>
    <script type="text/javascript" language="JavaScript">
        $("#login-button").click(function (event) {
            event.preventDefault();
            $('form').fadeOut(500);
            $('.wrapper').addClass('form-success');
        });

        function check() {
            {
                var $name = $("#user_name");
                var $pass = $("#user_password");
                if ($name.val() == "")//如果用户名为空
                {
                    // alert("您还没有填写用户名！");
                    layer.alert("您还没有填写用户名！",{icon:0});
                    $name.focus();

                    return false;
                }
                if ($pass.val() == "")//如果密码为空
                {
                    // alert("您还没有填写密码！");
                    layer.alert("您还没有填写密码！",{icon:0});
                    $pass.focus();
                    return false;
                }
            }
        }
        function register() {
            window.location.href = "register";
        }
    </script>
</head>
<body>
<div class="wrapper">
    <div class="container">
        <h1>Welcome</h1>
        <form name='form' class="form" method='post' action="user_login" onSubmit="return check()">
            <input type="text" placeholder="Username" name='user_name' class="input" id="user_name">
            <input type="password" placeholder="Password" name='user_password' class="input" id="user_password">
            <input type="submit" id="login-button" name="submit" value='submit' class="login_register"/>
            <input type="button"  id="register-button" value="register" onclick="register()"
                   class="login_register"/>
        </form>
    </div>

    <ul class="bg-bubbles">
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>
</body>
</html>