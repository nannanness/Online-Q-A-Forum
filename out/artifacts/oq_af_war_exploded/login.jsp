<%--
  Created by IntelliJ IDEA.
  User: dell00
  Date: 2018/7/27
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
    <link href="css/login.css" rel="stylesheet" type="text/css">
    <link href="css/resigets.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/jigsaw.css">
    <link rel="icon" href="imgs/icon.png">
    <%--<script type="text/javascript" src="js/jigsaw.js"></script>--%>
    <script src="js/jquery-1.12.4.js"></script>
    <script src="js/move.js"></script>
    <script type="text/javascript">
        $(function () {
            var phoneCheck = false;
            $("#registe").click(function () {
                $("#registpannel").toggle();
                $("#registpannel").css("position","fixed");
                $(".Modal-backdrop").css("position","absolute");
            })
            $("#shoutdown").click(function () {
                $("#registpannel").toggle();
                $("#registpannel").removeClass("position","fixed");
                $(".Modal-backdrop").removeClass("position","absolute");
            })
            $("#surephone").blur(function () {
                var getphone = $(" input[ name='phoneNum' ] ").val();
                var isPhone = /^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/;//手机号码
                if (isPhone.test(getphone)) {
                    $("#imgs").attr("src","imgs/right.png");
                    phoneCheck =true;
                    $("#imgs").show();
                }else {
                    $("#imgs").attr("src","imgs/wrong.png");
                    $("#imgs").show();
                    phoneCheck = false;
                }

            })
            //给获取验证码绑定点击事件
            $("#gettime").click(function () {
                if(phoneCheck){
                    var countdown=60;
                    var resettim = setInterval(function() {
                        if (countdown == 0) {
                            $("#gettime").attr("disabled",false);
                            $("#gettime").text("获取短信验证码");
                            countdown = 60;
                            clearInterval(resettim) ;

                        } else {
                            $("#gettime").attr("disabled", true);
                            $("#gettime").text("重新发送验证码(" + countdown + ")");
                            countdown--;
                        }
                        if(countdown==50){
                            $.get(
                                "${pageContext.request.contextPath}/loginServlet?method=getCheck",
                                function (data) {
                                    console.log(data);
                            });
                        }
                    },1000);
                }
            })
            $("#login_zhuce").click(function () {
                $.get(
                    "${pageContext.request.contextPath}/loginServlet?method=register",
                    {
                        phoneNum:$('input[name="phoneNum"]').val(),
                        numCheck:$('input[name="numCheck"]').val()
                    },
                    function (data) {
                        alert(data);
                    }
                )

            })

        })
    </script>
    <script type="text/javascript">
        $(document).ready(function ()
            {
                var obox = $('#box');
                var obox1 = $('#box1');

                obox.mouseover(function () {
                    obox1.css('borderLeft','none');
                    obox.css('background','none');
                    startMove(3,obox1.get(0),{width:4,marginLeft:296},function () {
                        obox1.css('borderRight','4px solid #2e4372');
                        startMove(2,obox1.get(0),{height:32,marginTop:4})
                    })
                })
                obox.mouseout(function () {
                    obox1.css('borderRight','2px solid #2e4372');
                    startMove(2,obox1.get(0),{height:40,marginTop:0},function () {
                        startMove(3,obox1.get(0),{width:298,marginLeft:0},function () {
                            obox1.css('borderLeft','2px solid #2e4372');
                            obox.css('background','none');
                        })
                    })
                })
                var span = $('#span');
                var pwd = $('[name=password]')[0];
                var form = $('#form1');
                var warn = $('#warn');
                span.mousedown(function(){
                    this.className="span1";
                    pwd.get(0).type = 'text';

                });
                span.mouseout(function(){
                    this.className="span";
                    pwd.get(0).type = 'password'
                });
                var login = $('#login');
                var flage2 = false;
                login.click(function(){
                        if(form.get(0).username.value=="" || form.get(0).password.value==""){
                            warn.css('color' ,'red');
                            warn.html("你输入的用户名或密码为空");
                            login.get(0).type = 'button';
                        }else{
                            warn.html('');
                            if (flage2 == true) {
                                login.get(0).type = 'submit';
                            }else {
                                login.get(0).type = 'button';
                                warn.html("请先验证");
                            }

                        }
                })
                //滑块验证
                jigsaw.init(document.getElementById('captcha'), function () {
                        // document.getElementsById('msgs').innerHTML = '验证通过！';
                        flage2 = true;

                    }
                )
                $(".slider").mouseenter(function(){
                    $("#captcha").css("display","block");
                })
                $(".slider").mouseleave(function(){
                    $("#captcha").css("display","none");
                })
            })
    </script>

</head>
<body>
    <div id="box" class="welcome"><a href="index.jsp">欢迎登录OQ&AF网站</a><span></span><div id="box1"></div></div>
    <form  id="form1" action="${pageContext.request.contextPath}/loginServlet?method=login"method="post">
        <div class="logoin">
            <h1>登录</h1>
            <%--滑块验证开始--%>
            <%--<div id="checkcode">--%>
            <div id="captcha" style="position: relative"></div>

            <%--<div id="msgs"></div>--%>
            <%--</div>--%>

            <div class="userbox">
                <input class="user" name="username" type="username" placeholder="请输入用户名/手机号">
            </div>
            <div class="paswbox">
                <input class="password" name="password" type="password" placeholder="请输入密码" id="getcheckcoude">
                <%--<span class="span" id="span"></span>--%>
            </div>

                <span class="spanWarn" style="color: red" id="warn">${msg}</span>
            <div class="next"><input class="next" id="login" type="submit" value="登陆"></div>

            <a class="forget"  href="#">忘了电子邮件/用户名或密码点击这儿</a>
            <div class="zuce" id="registe"><a href="#">新的用户？现在注册！</a></div>
        </div>
    </form>

    <div>
        <div>
        <span>
            <div class="Modal-wrapper" id="registpannel" style="display:none">
                <div class="Modal-backdrop"></div>
                <div class="Modal Modal--default signFlowModal" tabindex="0">
                    <div class="Modal-inner">
                        <div class="Modal-content">
                            <div class="Card SignContainer-content">
                                <div class="SignFlowHeader">
                                    <svg viewBox="0 0 200 91" class="Icon" width="98" height="45.9375" aria-hidden="true" style="height: 45.9375px; width: 98px;">
                                       <title></title>
                                        <g>
                                            <text x="98" y="48" text-anchor="middle" font-size="52" >OQ&AF</text>
                                        </g>
                                    </svg>
                                    <div class="SignFlowHeader-slogen">
                                          嗨！
                                        OQ&FA,你的世界有我更精彩！
                                    </div>
                                    <div>
                                    </div>
                                </div>
                                <div class="SignContainer">
                                    <form action="" method="post">
                                        <div class="phoneform">
                                            <div class="phonearea">
                                                <button  type="button" id="Popover160-toggle"   class="Button Select-button Select-plainButton Button--plain">
                                                    "中国 +86"
                                                </button>
                                                <span  class="SignFlow-accountSeperator">&nbsp;</span>
                                                <div class="getphone">
                                                    <input name="phoneNum" type="tel" id="surephone" class="Input" placeholder="手机号"  value>
                                                    <img src="" style="display: none" id="imgs">
                                                </div>

                                            </div>

                                        </div>
                                        <div class="shotmessagefrom">
                                            <div class="numbertable">
                                                <input  type="text" name="numCheck" class="Input" placeholder="输入 6 位短信验证码" value="" style="width: 352px;height:48px">
                                                <button type="button" class="Button CountingDownButton SignFlow-smsInputButton Button--plain" id="gettime"  >获取短信验证码</button>
                                            </div>

                                        </div>
                                        <button class="Button Register-submitButton Button--primary Button--blue" id="login_zhuce">注册</button>

                                    </form>
                                    <div class="Register-footer">
                                        <span class="Register-declaration">
                                            注册即代表同意
                                            <a href="#">《OQ&AF协议》</a>
                                            <a href="#">《隐私政策》</a>
                                        </span>
                                    </div>
                                    <div class="SignContainer-switch">
                                        已有帐号？
                                        <span> <a href="/login.jsp">登录</a> </span>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <button aria-label="关闭" type="button"  id="shoutdown" class="Button Modal-closeButton Button--plain" style="color: rgba(255,255,255,0.4)" >
                        <svg class="Zi Zi--Close Modal-closeIcon" fill="currentColor" viewBox="0 0 24 24" width="24" height="24">
                            <path d="M13.486 12l5.208-5.207a1.048 1.048 0 0 0-.006-1.483 1.046 1.046 0 0 0-1.482-.005L12 10.514 6.793 5.305a1.048 1.048 0 0 0-1.483.005 1.046 1.046 0 0 0-.005 1.483L10.514 12l-5.208 5.207a1.048 1.048 0 0 0 .006 1.483 1.046 1.046 0 0 0 1.482.005L12 13.486l5.207 5.208a1.048 1.048 0 0 0 1.483-.006 1.046 1.046 0 0 0 .005-1.482L13.486 12z" fill-rule="evenodd"></path>
                        </svg>
                    </button>
                </div>
            </div>
        </span>
        </div>
    </div>
    <div class="bqxxbox">
        <div class="bqxx">
            版权声明:蓝桥软件学院一组| <a href="#">&nbsp;&nbsp;联系我们</a>
        </div>
    </div>
    <script type="text/javascript" src="js/jigsaw.js"></script>
</body>
</html>
