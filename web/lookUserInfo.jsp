<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@page pageEncoding="UTF-8"%>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户中心</title>
    <link rel="stylesheet" href="./css/userInfo.css">
    <link rel="stylesheet" href="./css/show.css">
    <link rel="icon" href="imgs/icon.png">
    <script src="./js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
        $(function() {
            var ifLogin =$("#ifLogin").val();
            $("#careUserA").click(function () {
                if(ifLogin){
                    $("#careUserA").attr("href","/userDynamicsServlet?method=careLookUser");
                    alert("关注成功");
                }else{
                    alert("请登陆后再关注");
                    $("#careUserA").attr("href","/login.jsp");
                }
            })
            $("#GoHome").click(function () {
                $.get(
                    "${pageContext.request.contextPath}/indexServlet?method=init",
                    function () {
                        window.location.href="index.jsp";
                    }
                );
            });
            $('.content .main .tab li').on({
                click: function () {
                    $('.content .main .tab li').removeClass('active');
                    $('.content .main .tab-content .tab-item').removeClass('active');
                    $(this).addClass('active');
                    $('.content .main .tab-content .tab-item').eq($(this).index()).addClass('active')
                }
            });
            $('.content .right .tab li').on({
                click: function () {
                    $('.content .right .tab li').removeClass('active');
                    $('.content .right .tab-content .tab-item').removeClass('active');
                    $(this).addClass('active');
                    $('.content .right .tab-content .tab-item').eq($(this).index()).addClass('active')
                }
            });

            $('.showAll span').click(function () {
                $(this).parent().hide().parent().children(".contentDetail").removeClass('contentDetail').addClass('contentDetail-showall');
                $(this).parent().next().show();
            })
            $('.hideAll span').click(function () {
                $(this).parent().hide().parent().children(".contentDetail-showall").removeClass('contentDetail-showall').addClass('contentDetail');
                $(this).parent().prev().show();
            })
            var ele = $(".right");
            var startPos  = $(ele).offset().top;
            $(window).scroll(function () {
                var p = $(this).scrollTop();
                if(p >= startPos){
                    $(ele).css({"position":"fixed","top":0 , "right": "124px"});
                }else if(p < startPos){
                    $(ele).css({"position":"static"});
                }
            });
            $("#cancleUser").click(function () {
                alert("已取消关注");
            });
            var careUserName = $("#careUserName").val();
            $("#careUser").click(function () {
                alert("关注成功"+careUserName);

            })

        });

    </script>
    <style type="text/css">
        body{background: url("./${userInfo.user_bgc}") repeat;backgroundx-size: cover; font-size: 12px;}
    </style>
</head>
<body>
    <%--判断是否登陆--%>
    <input type="hidden" id="ifLogin" value="${ifLogin}">
    <div class="banner">
        <div class="pull-center">
            <img class="touxiang" src="./${userInfo.user_Img}" alt="">
            <div class="info">
                <p>用户昵称：<span class="niChen">${userInfo.user_Name}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    城市：<span class="city">${userInfo.user_city}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    性别：<span class="sex">${userInfo.user_Sex}</span>
                </p>
                介绍：<span class="jieshao">${userInfo.user_Details}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                教育经历：<span class="jiaoyu">${userInfo.user_school}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

            </div>
            <div class="caoZuo">
                <button><a href="#" id="careUserA">&nbsp;&nbsp;+关注&nbsp;&nbsp;&nbsp;</a></button>
                <br>
                <button><a href="" id="GoHome">返回首页</a> </button>
            </div>
        </div>
    </div>
    <div class="content pull-center">
        <div class="main">
            <!-- 选项卡 -->
            <div class="tab">
                <ul id="card">
                    <li class="active op" id="dongTai">TA的动态</li>
                    <li class="op" id="huiDa">TA的回答</li>
                    <li class="op" id="tiWen">TA的提问</li>
                    <li class="op" id="wenZhang">TA的文章</li>
                    <li class="op" id="shoucang">TA的收藏</li>
                </ul>
            </div>
            <!-- 选项卡切换内容区 -->
            <div class="tab-content">
                <div class="tab-item dongTai active">
                    <c:forEach items="${listUserArticle}" var="userArticle">
                        <div class="contentCssSet">
                            <h3>发表了:<b style="color: #259;">${userArticle.articleTitle}</b> <span style="float: right;color: #999 ; font-size: 14px">${userArticle.articleDate}</span></h3>
                            <div class="contentDetail">
                                    ${userArticle.articleContent}
                            </div>
                            <div class="showAll"><span>显示全文</span></div>
                            <div class="hideAll"><span>收回</span></div>
                        </div>
                    </c:forEach>

                    <c:forEach items="${listUserResponse}" var="userResponse">
                        <div class="contentCssSet">
                            <h3>回答了:<b style="color: #259;">${userResponse.title}</b> <span style="float: right;color: #999 ; font-size: 14px">${userResponse.replayDate}</span></h3>
                            <div class="contentDetail">
                                    ${userResponse.replayContent}
                            </div>
                            <div class="showAll"><span>显示全文</span></div>
                            <div class="hideAll"><span>收回</span></div>
                        </div>
                    </c:forEach>

                    <c:forEach items="${listUserQuestion}" var="userQuestion">
                        <div class="contentCssSet">
                            <h3>提出了:<b style="color: #259;">${userQuestion.title}</b> <span style="float: right;color: #999 ; font-size: 14px">${userQuestion.problemDate}</span></h3>
                            <div class="contentDetail">
                                    ${userQuestion.content}
                            </div>
                            <div class="showAll"><span>显示全文</span></div>
                            <div class="hideAll"><span>收回</span></div>
                        </div>
                    </c:forEach>
                </div>

                <div class="tab-item huiDa">
                    <%--回答--%>
                    <c:forEach items="${listUserResponse}" var="userResponse">
                        <div class="contentCssSet">
                            <h3>回答了:<b style="color: #259;">${userResponse.title}</b> <span style="float: right;color: #999 ; font-size: 14px">${userResponse.replayDate}</span></h3>
                            <div class="contentDetail">
                                    ${userResponse.replayContent}
                            </div>
                            <div class="showAll"><span>显示全文</span></div>
                            <div class="hideAll"><span>收回</span></div>
                        </div>
                    </c:forEach>
                </div>
                <div class="tab-item tiWen">
                    <c:forEach items="${listUserQuestion}" var="userQuestion">
                        <div class="contentCssSet">
                            <h3>提出了:<b style="color: #259;">${userQuestion.title}</b> <span style="float: right;color: #999 ; font-size: 14px">${userQuestion.problemDate}</span></h3>
                            <div class="contentDetail">
                                    ${userQuestion.content}
                            </div>
                            <div class="showAll"><span>显示全文</span></div>
                            <div class="hideAll"><span>收回</span></div>
                        </div>
                    </c:forEach>
                </div>
                <div class="tab-item wenZhang">
                    <c:forEach items="${listUserArticle}" var="userArticle">
                        <div class="contentCssSet">
                            <h3>发表了:<b style="color: #259;">${userArticle.articleTitle}</b> <span style="float: right;color: #999 ; font-size: 14px">${userArticle.articleDate}</span></h3>
                            <div class="contentDetail">
                                    ${userArticle.articleContent}
                            </div>
                            <div class="showAll"><span>显示全文</span></div>
                            <div class="hideAll"><span>收回</span></div>
                        </div>
                    </c:forEach>
                </div>
                <div class="tab-item shoucang">
                    
                </div>
            </div>
        </div>

        <!--关注 粉丝 动态区-->
        <div class="right">
            <!--选项卡-->
            <div class="tab">
                <ul>
                    <li class="active">关注</li>
                    <li>粉丝</li>
                </ul>
            </div>
            <!--动态切换-->
            <div class="tab-content">
                <div class="tab-item dongtai active">
                    <c:forEach items="${listIdol}" var="idol">
                        <div class="list-link" style="display: block">
                            <a style="float: left" href="${pageContext.request.contextPath}/userDynamicsServlet?method=lookUserInfo&lookUserId=${idol.careUserId}"><b style="color: #259;">${idol.careUsername}</b></a>
                            <%--<button style="margin: 18px 0 19px;float: right" id="cancleUser"> <a href="/userDynamicsServlet?method=cancleSight&Interviewed=${idol.careUserId}">关注TA</a></button>--%>
                        </div>
                        <div style="clear:both"></div>
                    </c:forEach>
                </div>
                <div class="tab-item">
                    <c:forEach items="${listFans}" var="fans">
                        <div class="list-link" style="display: block">
                            <a style="float: left"href="${pageContext.request.contextPath}/userDynamicsServlet?method=lookUserInfo&lookUserId=${fans.careUserId}"><b style="color: #259;" id="careUserName">${fans.fansUsername}</b></a>
                            <%--<button style="margin: 18px 0 19px;float: right" id="careUser"><a href="/userDynamicsServlet?method=sightUser&fans=${fans.fansId}">关注TA</a></button>--%>
                            <div style="clear:both"></div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</body>
</html>