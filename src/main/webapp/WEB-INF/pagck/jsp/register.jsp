<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link href="res/css/login.css" type="text/css" rel="stylesheet" />
    <link rel="shortcut icon" href="/img/icon/favicon.ico" />
    <script src="/js/jquery.js"></script>
    <script type="text/javascript">
        $("#login-button").click(function(event){
            event.preventDefault();
            $('form').fadeOut(500);
            $('.wrapper').addClass('form-success');
        });
        function check() {
            {
                $name = $("#name");
                $pass1 = $("#pass1");
                $pass2 = $("#pass2");
                <c:forEach items="${userList}" var="userList">
                    $user_name = ${userList.user_name};
                     console.log($user_name);
                    if($user_name == $name.val()){
                        alert("已经存在该用户名!");
                        $name.focus();
                        return false;
                    }
                </c:forEach>
                // for(var i = 0;i < userList.length;i++){
                //     alert(userList[i]);
                //     if($name.val() == userList[i].$name){
                //         alert("已经存在该用户名!");
                //         $name.focus();
                //         return false;
                //     }
                // }
                if ($name.val() == "")//如果用户名为空
                {
                    alert("您还没有填写用户名！");
                    $name.focus();
                    return false;
                }
                if ($pass1.val() == "")//如果密码为空
                {
                    alert("您还没有填写密码！");
                    $pass1.focus();
                    return false;
                }
                if($pass1.val() != $pass2.val()){
                    alert("您的确认密码输入不正确！")
                    $pass2.focus();
                    return false;
                }

            }
        }
    </script>
</head>
<body>
<div class="wrapper">
    <div class="container">
        <h1>Welcome</h1>
        <%--action='--%>
        <form name='form' class="form" method='post' action="register_login" onSubmit="return check();">
            <input type="text" placeholder="Username" name='user_name' class="input" id="name">
            <input type="password" placeholder="Password" name='user_password' class="input" id="pass1">
            <input type="password" placeholder="Reconfirm Your Password"    class="input" id="pass2">
            <input type="submit" id="login-button" name="login" value="login"  class="login_register" />
            <%--<button type="submit" id="register-button" value='submit' name='submit'  class="login_register"  >Register</button>--%>
        </form>


        <%--<form name='form' class="form" method='post' action="user_login" onSubmit="return check()">--%>
            <%--<input type="text" placeholder="Username" name='username' class="input">--%>
            <%--<input type="password" placeholder="Password" name='pass' class="input">--%>
            <%--<input type="submit" id="login-button" name="submit" value='submit' class="login_register"/>--%>
            <%--<input type="button"  id="register-button" value="register" onclick="register()"--%>
                   <%--class="login_register"/>--%>
        <%--</form>--%>
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