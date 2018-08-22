<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell00
  Date: 2018/8/2
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>OQ&AF--与世界分享你的故事</title>
    <script src="js/jquery-1.12.4.js"></script>
    <link rel="stylesheet" href="css/find.css">
    <link rel="stylesheet" href="css/topic.css">
    <link rel="stylesheet" href="css/xuanku.css">
    <link rel="stylesheet" href="css/remark.css">
    <link rel="stylesheet" href="css/page.css">
    <link rel="icon" href="imgs/icon.png">
    <script src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
        $(function (){
            var ifLogin =$("#ifLogin").val();
            if(ifLogin){
                $("#find_userName").text("${userInfo.user_Name}");
                $("#find_userName").click(function () {
                    $(this).attr("href","${pageContext.request.contextPath}/userDynamicsServlet?method=init&Interviewed=${userInfo.user_Id}");
                });
                $("#find_esc").text("退出");
                $("#find_esc").click(function () {
                    $.get(
                        "${pageContext.request.contextPath}/loginServlet?method=esc",
                        function (data) {
                            alert(data);
                        }

                    );
                    window.location.href="index.jsp";
                });
                $("#find_userImg").attr("src","${userInfo.user_Img}");
            }else {
                $("#find_userName").text("登陆/注册");
                $("#find_userName").click(function () {
                    window.location.href="login.jsp";
                });
            }
            $(window).scroll(function(){
                // var a = $("#idtop").height();
                // console.log(a);
                if($(window).scrollTop() >= 1 ){
                    $(".navigation-bar").addClass("fixed");
                    //  $(".main").css("marginTop",$(".nav").height()+10)
                }else{
                    $(".navigation-bar").removeClass("fixed");
                    //  $(".main").css("marginTop",10);
                }
            });
            //加关注点击特效
            var $arrryBtn1 = $(".btn1");
            // alert($arrryBtn1.length)
            $(".btn1").each(function(){
                $(this).bind('click',function(){
                    var x = 100;
                    var y = 900;
                    var num = Math.floor(Math.random() * 3 + 1);
                    var index=$(this).prev().children('.imgs').length;
                    var rand = parseInt(Math.random() * (x - y + 1) + y);
                    $(this).prev().append("<img src='' class='imgs'>");
                    $('.imgs:eq(' + index + ')').attr('src','imgs/'+num+'.png')
                    $(".imgs").animate({
                        bottom:"800px",
                        opacity:"0",
                        left: rand,
                    },3000)
                })
            })
            <!-- 开启拓展框 -->
            $(".reademore").click(function(){
                $(this).parent().parent().parent(".post-content").prev().addClass("RichContent");
                $(this).parent().parent().parent(".post-content").css("display","none");
                $(this).parent().parent().parent(".post-content").prev().css("display","block");
                $(".hindearticle").css("display","block");
            })

            $(".hindearticle").click(function(){
                $(".post-content").css("display","block");
                $(".RichContent").css("display","none");
                $(this).css("display","none");
            })
            // 开启图片浏览特效
            var cc5 = $('#card-container-5');
            cc5.click(function(){
                var firstCard = cc5.children('.card').first(),
                    cssRoll = {
                        transform: 'rotate(-45deg)',
                        opacity:0
                    };
                firstCard.css(cssRoll);
                setTimeout(function(){
                    cc5.append(firstCard);
                    firstCard.attr('style','');
                },300);
            });
            var num = 0;
            $("#j_silder_outer .img-item").each(function(index, el) {
                $(this).css({
                    "left":$(this).width() * index + "px",
                    /*让每个img-item延时一定时间执行动画*/
                    "transitionDelay": index * 0.3 + "s"
                });
                $(this).find(".img").css({
                    "backgroundPosition": -$(this).width() * index + "px"
                });;
            });

            $(".prev").on("click",function (){
                $("#j_silder_outer .img-item").css("transform", "rotateX(" + (++num * 90) + "deg)");
            });

            $(".next").on("click",function (){
                $("#j_silder_outer .img-item").css("transform", "rotateX(" + (--num * 90) + "deg)");
            });

            var timejg=4000;//轮播间隔时间
            var time = setInterval(move,timejg);
            function move(){
                $("#j_silder_outer .img-item").css("transform", "rotateX(" + (--num * 90) + "deg)");
            }
            $('.slider-outer').hover(function(){
                clearInterval(time);
            },function(){
                time = setInterval(move,timejg);
            });

        })
    </script>
    <script>
        $(document).ready(function() {
            var ifLogin =$("#ifLogin").val();
            $('.pinglun').click(function() {
                var index = $('.pinglun').index($(this));
                var proId = $(this).next().val();
                var userId = $(this).next().next().val();
                let that = $(this);
                console.log($(this));
                $.get(
                    "${pageContext.request.contextPath}remarksServlet",
                    {"proId":proId,"userId":userId},
                    function (data){
                        console.log(data);
                        for(var i = 0 ; i < data.length ; i++){
                            // that.parent().next().get(0).getElementsByClassName('yonghuming')[0].innerHTML=data[i].user_Name;
                            // that.parent().next().get(0).getElementsByClassName('pinglunneirong')[0].innerHTML=data[i].remarkContent;
                            // that.parent().next().get(0).getElementsByClassName('pinglunshijian')[0].innerHTML=data[i].remarkDate;
                            $('.com-users').eq(index).append("<div class=\"comment-user\">\n" +
                                "                                                                <%-- 用户名 --%>\n" +
                                "                                                            <span ><b class=\"yonghuming\">"+ data[i].user_Name +"</b></span>\n" +
                                "                                                                <%-- 评论时间 --%>\n" +
                                "                                                            <span class=\"pinglunshijian\">"+ data[i].remarkDate +"</span>\n" +
                                "                                                                <%--  评论内容  --%>\n" +
                                "                                                            <div class=\"comment-user-content pinglunneirong\">"+ data[i].remarkContent +"</div>\n" +
                                "                                                        </div>");
                        }
                    },
                    "json"
                );
                $(this).parent().next().show();
                $(this).hide().prev().show();
            });
            $(".pinglunAfter").click(function () {
                var index = $(".pinglunAfter").index($(this));
                $(".pinglunchuxian").eq(index).hide();
                $(".com-users").eq(index).html("");
                $(this).hide().next().show();
            });
            $('.btn-guanbi').click(function() {
                $(this).parent().parent().parent().parent().parent().css("display", "none");
            });

            $('.btn-reply').click(function() {
                // console.log($(this).index());
                // 获取回复按钮集合,getElementByClassName;
                var m = document.getElementsByClassName("btn-reply");
                var n = document.getElementsByClassName("user-reply");
                console.log('回复按钮集合' + m);
                // 获取回复按钮的索引
                var index = $(".btn-reply").index($(this));
                console.log(index);
                $(".user-reply").eq(index).css("display", "block");
            });
            $('.btn-comment').click(function () {
                var proId = $(this).parent().parent().parent().parent().parent().parent().prev().children(".pid").val();
                var userId = $(this).parent().parent().parent().parent().parent().parent().prev().children(".uid").val();
                var remId = $(this).parent().parent().parent().parent().parent().parent().prev().children(".rid").val();
                var test = $(this).parent().prev().children(".textRemark").val();
                var date =new Date();
                var timeStr = date.toString();
                var uName= $(this).parent().parent().parent().parent().parent().parent().prev().children(".uName").val();

                console.log(test.length);
                var index = $(".btn-comment").index($(this));
                var that = $(".com-users").eq(index);
                // 比如需要这样的格式 yyyy-MM-dd hh:mm:ss
                // var date = new Date(1398250549490);
                Y = date.getFullYear() + '-';
                M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
                D = date.getDate() + ' ';
                h = date.getHours() + ':';
                m = date.getMinutes() + ':';
                s = date.getSeconds();
                console.log(Y+M+D+h+m+s);
                timeStr = Y+M+D+h+m+s;
                // 输出结果：2014-04-23 18:55:49
                // let that = $(this);
                if (ifLogin) {
                    if(test.length!=0){
                        if(test.length<=100){
                            that.append("<div class=\"comment-user\">"+"<span ><b class=\"yonghuming\">"+uName+"</b></span>"+ "<span class=\"pinglunshijian\">"+timeStr+"</span>"+"<div class=\"comment-user-content pinglunneirong\">"+test+"</div>"+"</div>");
                            <%--<span ><b class="yonghuming"></b></span>--%>
                            <%--<span class="pinglunshijian"></span>--%>
                            <%--&lt;%&ndash;  评论内容  &ndash;%&gt;--%>
                            <%--<div class="comment-user-content pinglunneirong"></div>--%>
                            $.get(
                                "RemarkServlet",
                                {"proId":proId,"userId":userId,"remId":remId,"textRemark":test,"time":date},
                                function(data) {
                                    // that.parent().next().get(0).getElementsByClassName('yonghuming')[0].innerHTML=uName;
                                    // that.parent().next().get(0).getElementsByClassName('pinglunneirong')[0].innerHTML=data.remarkContent;
                                    // that.parent().next().get(0).getElementsByClassName('pinglunshijian')[0].innerHTML=data.remarkDate;
                                },
                                "json"
                            )

                            $(".user-reply").css("display", "none");
                            $("#input-pinglun").val("");
                            alert("评论发布成功")
                        }else {
                            alert("评论内容请不要超过100字")
                        }
                    }else {
                        alert("请输入评论内容")
                    }
                }else {
                    alert("请先登录")
                    window.location.href="login.jsp";
                }


                // $(this).disable();
            })
            $('.btn-cancel').click(function() {
                var m = document.getElementsByClassName("btn-reply");
                var n = document.getElementsByClassName("user-reply");
                var index = $(".btn-cancel").index($(this));
                console.log(index);
                $(".user-reply").eq(index).css("display", "none");
            });
            //分享
            window._bd_share_config={
                "common":{"bdSnsKey":{},
                    "bdText":"",
                    "bdMini":"2",
                    "bdPic":"",
                    "bdStyle":"0",
                    "bdSize":"16"},
                "share":{},
                "image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},
                "selectShare":{"bdContainerClass":null,
                    "bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}
            };
            with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];

            $("#prev").click(function (e) {
                var nowPage = $("#nowPage").val();
                var prevPage = nowPage - 1;
                if(prevPage <= 0){
                    alert("已经是第一页!");
                    e.preventDefault();
                }
            })
            $("#next").click(function (e) {
                var sumPage = $("#sumPage").val();
                var nowPage = $("#nowPage").val();
                var nextPage = nowPage + 1;
                if(nextPage > sumPage){
                    alert("已是最后一页！");
                    e.preventDefault();
                }
            })

        });
    </script>
</head>
<body>
<input type="hidden" id="ifLogin" value="${ifLogin}">
<div class="topicLead" >
    <div class="navigation-bar-child">
        <div class="navigation-bar-child-context navigation-bar-child-title"><a href="index.jsp">OQ&AF</a></div>
        <%--用户退出登陆--%>
        <div class="navigation-bar-child-context navigation-bar-child-textLogin"><a href="#" id="find_esc"></a></div>
        <div class="navigation-bar-child-context navigation-bar-child-textLogin">
            <%--用户的头像设置--%>
            <a  href="#" id="find_userName"></a>
        </div>
        <div class="navigation-bar-child-context navigation-bar-child-textRegistered">
            <%--用户的头像设置--%>
            <img src="imgs/touxiang.png" style="height: 26px" id="find_userImg">
        </div>

        <%--搜索--%>
        <form action="/topicServlet" class="navigation-bar-child-context navigation-bar-child-search">
            <input type="hidden" name="method" value="topicSearch">
            <input type="hidden" name="page" value="home">
            <input type="text" name="searchContent" class="navigation-bar-child-context navigation-bar-child-searchBar" placeholder="搜索你感兴趣的内容..." >
            <button type="submit" class="navigation-bar-child-context navigation-bar-child-searchIco"><i class="iconfont icon-sousuo"></i></button>
        </form>

        <div class="navigation-bar-child-context navigation-bar-child-textThree"> <a href="index.jsp">首页</a></div>
        <div class="navigation-bar-child-context navigation-bar-child-textThree"> <a href="topic.jsp">话题</a></div>
    </div>
</div>
<div class="take-page">
    <div class="pagination"><a id="prev" href="/topicServlet?method=${topicmethod}&page=prev">上一页</a></div>
    <div class="pagination"><a id="next" href="/topicServlet?method=${topicmethod}&page=next">下一页</a></div>
</div>
<input type="hidden" id="nowPage" value="${sessionScope.nowPage}">
<input type="hidden" id="sumPage" value="${sessionScope.sumPage}">
<!-- 版心 -->
<div class="page-type page">
    <!-- 左边大板块 -->
    <div class="main">
        <div class="main-title">
            <i class="iconfont icon-tuijian"></i>
            已关注的话题
            <div class="main-title-more"><a class="underline">共关注3个话题</a></div>
        </div>
        <div class="topicTest" >
            <ul class="ulTest" id="liDiv">
                <li class="liTest">
                    <a href="/topicServlet?method=init">全部类</a>
                </li>
                <li class="liTest">
                    <a href="/topicServlet?method=codeClass&type=编程类&page=home">编程类</a>
                </li>
                <li class="liTest">
                    <a href="/topicServlet?method=codeClass&type=学习类&page=home">学习类</a>
                </li>
                <li class="liTest">
                    <a href="/topicServlet?method=codeClass&type=生活类&page=home">生活类</a>
                </li>
                <li class="liTest">
                    <a href="/topicServlet?method=codeClass&type=游戏类&page=home">游戏类</a>
                </li>
                <li class="liTest">
                    <a href="/topicServlet?method=codeClass&type=事业类&page=home">事业类</a>
                </li>
            </ul>
        </div>

        <div class="explore-tab">
            <ul class="tab-navs">
                &nbsp;  &nbsp; &nbsp;
                <li class="tab-nav" id="giveType"><a href="/topicServlet?method=moreHotTopic&page=home" class="anchor">热门话题</a></li>
            </ul>
            <!-- 主要大板块 -->
            <div class="tab-panel">
                <div class="daily">
                    <!-- 单个回答模块 -->
                    <c:forEach items="${Topiclist}" var="topic">
                        <div class="main-context-complete">
                            <h2 class="blue underline"><a>${topic.title}&nbsp;&nbsp;&nbsp;${topic.content}</a></h2>
                            <div>
                                    <%--<div class="avatar-div">--%>
                                    <%--<a href="" class="vote-count">${topic.problemId}</a>--%>
                                    <%--</div>--%>
                                <div class="feed-main-complete">
                                    <div class="author-info">
                                        <span class="author-link-line"><a href="/userDynamicsServlet?method=lookUserInfo&lookUserId=${topic.replayUserId}" class="underline">${topic.user_Name}</a></span>&nbsp;&nbsp;
                                        <span class="bio"><a href="/topicServlet?method=codeClass&type=${topic.problemType}">${topic.problemType}</a></span>
                                    </div>
                                    <div style="display: none" class="contentImg">
                                        <p><img src="imgs/text6.jpg"><img src="imgs/text7.jpg"></p>
                                        <p> ${topic.replayContent}</p>

                                        <button type="button" class="ButtonPlain hindearticle" id="hindearticle" style="display:none" >收起全文</button>
                                    </div>
                                    <div class="post-content">
                                        <div class="card-container-5" id="card-container-5">
                                            <div class="card"><img src="imgs/text6.jpg" alt="" class="origin-image"></div>
                                            <div class="card"><img src="imgs/text5.jpg" alt="" class="origin-image"></div>
                                            <div class="card"><img src="imgs/text7.jpg" alt="" class="origin-image"></div>
                                        </div>
                                        <div class="post-content-main">
                                            <h2 style="height:70px">
                                                    ${topic.replayContent}
                                            </h2>
                                            <div style="float: right;padding-left:310px;position: absolute">
                                                <button type="button" class="ButtonPlain reademore" id="reademore">阅读全文</button>
                                            </div>

                                        </div>

                                    </div>
                                    <!-- 点赞评论功能栏 -->
                                    <div class="meta-panel bio">
                                        <div class="demo" ></div>
                                        <a class="underline btn1" >笔芯</a>
                                        <a class="underline pinglunAfter" style="display: none">评论</a>
                                        <a class="underline pinglun">评论</a>
                                        <input type="hidden" value="${topic.problemId}" class="pid" >
                                        <input type="hidden" value="${topic.replayUserId}"  class="uid">
                                        <input type="hidden" value="${sessionScope.userInfo.user_Id}"  class="rid">
                                        <input type="hidden" value="${sessionScope.userInfo.user_Name}"  class="uName">
                                        <a class="underline ">作者保留权利</a>
                                    </div>
                                    <div  class="pinglunchuxian" style="width: 100%;float: left;background-color: #fff;display: none;border-bottom: 1px solid #a9a9a9;border-right: 1px solid #A9A9A9;border-left: 1px solid #A9A9A9;">
                                            <%--<c:forEach items="${remark}"  var="remark">--%>
                                        <div class="nr-comment">

                                            <div class="nr-comment-con">
                                                <div class="nr-comment-nav">
                                                    <div class="comment-number">
                                                            <%--<span>493</span>--%>
                                                        <span>全部评论</span>
                                                    </div>
                                                    <div class="comment-sort">
                                                        <button class="btn btn-primary btn-sm btn-reply">回复</button>
                                                        <button class="btn btn-primary btn-sm btn-guanbi">关闭</button>
                                                    </div>
                                                </div>

                                                <div class="comment-content">
                                                    <div class="com-users">
                                                    </div>
                                                    <div class="user-reply">
                                                        <div class="reply-in">
                                                            <input id="input-pinglun" class="textRemark" type="text" value="" name="textRemark" placeholder="请输入评论内容，字数请不要超过100字" />
                                                        </div>
                                                        <div class="reply-buttons">
                                                            <fmt:formatDate   value="${ user.lastConnectTime }"  type="both"/>
                                                            <button type="button" class="btn btn-primary btn-comment btn-sm">评论</button>
                                                            <button type="button" class="btn btn-default btn-cancel btn-sm">取消</button>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>

                                        </div>

                                    </div>
                                </div>

                            </div>
                        </div>
                    </c:forEach>

                </div>
                <%--<button class="btn-white main">更多</button>--%>
            </div><!-- 包括主体内容和加载按钮 -->
        </div><!-- 包括今日最热和本月最热 -->

    </div><!-- 整个左边 -->
    <!-- 侧面 -->
    <div class="side-bar" style="position: fixed;margin-left: 780px;margin-top: 30px;">
        <div class="left-label main-title">
            <span class="">Online Q&A Forum</span>
        </div>
        <!-- //炫酷的广告轮播图 -->
        <div class="slider-outer" id="j_silder_outer">
            <div class="img-item">
                <div class="img"></div>
                <div class="img"></div>
                <div class="img"></div>
                <div class="img"></div>
            </div>
            <div class="img-item">
                <div class="img"></div>
                <div class="img"></div>
                <div class="img"></div>
                <div class="img"></div>
            </div>
            <div class="img-item">
                <div class="img"></div>
                <div class="img"></div>
                <div class="img"></div>
                <div class="img"></div>
            </div>
            <div class="img-item">
                <div class="img"></div>
                <div class="img"></div>
                <div class="img"></div>
                <div class="img"></div>
            </div>
            <div class="btns" data-num="0">
                <div class="prev"><</div>
                <div class="next">></div>
            </div>
        </div>

        <div class="side-section-inner">
            <div>
            </div>
        </div>
        <div>
            <ul class="side-nav" >
                <li><a href="/disorderlyServlet?method=zhinan">·OQ&AF用户指南·</a></li>
                <li><a href="/disorderlyServlet?method=xieyi">·OQ&AF协议·</a></li>
                <li><a href="/disorderlyServlet?method=yingsi">·隐私政策·</a></li>
                 <li><a href="/disorderlyServlet?method=jubao">·侵权举报·</a></li>
                <li><a href="/disorderlyServlet?method=guanyu">关于我们</a></li>
                <li><a href="/disorderlyServlet?method=jiaru">·加入我们·</a></li>
                <li><a href="/disorderlyServlet?method=yijian">·意见反馈·</a></li>

            </ul>
        </div>
        </div>
    </div>
</div>
</body>
</html>
