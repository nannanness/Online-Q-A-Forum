<%--
  Created by IntelliJ IDEA.
  User: 士南
  Date: 2018/8/1
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OQ&AF--与世界分享你的故事</title>
    <script src="js/jquery-1.12.4.js"></script>
    <link rel="stylesheet" href="css/find.css">
    <link rel="stylesheet" href="css/stencil.css">
    <link rel="icon" href="imgs/icon.png">
    <script type="text/javascript">
        $(function () {
            var ifLogin =$("#ifLogin").val();
            if(ifLogin){
                $("#find_userName").text("${userInfo.user_Name}");
                $("#find_userName").click(function () {
                    window.location.href="userInfo.jsp";
                });
                $("#find_esc").html("<a style=\"color: #8590a6;\">退出</a>");
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
                })
            }
            $(".spanBtn").click(function(){
                $(".replay").css("display","block");
            })
            $("#replayBtn").click(function(){
                if(ifLogin){
                    $(this).attr("type","submit");
                    alert("小可爱您的评论已经发表，请到用户区查看呦");
                }else{
                    alert("请登录后再来发表您的评论哦");
                    $(this).attr("type","submit");
                    $(this).href="/index.jsp";
                }
            })
            $("#replayBtn1").click(function(){
                if(ifLogin){
                    $(this).attr("type","submit");
                    alert("小可爱您的评论已经发表，请到用户区查看呦");

                }else{
                    alert("请登录后再来发表您的评论哦");
                    $(this).attr("type","button");
                    $(this).href="/index.jsp";
                }
            })
            $(".spanBtn1").click(function(){
                $(".replay1").css("display","block");
            })
        })
    </script>
</head>
<body>
<input type="hidden" id="ifLogin" value="${ifLogin}">
<!-- <%--导航栏--%> -->
<div class="navigation-bar">
    <div class="navigation-bar-child">
        <div class="navigation-bar-child-context navigation-bar-child-title"><a href="${pageContext.request.contextPath}index.jsp">OQ&AF</a></div>
        <%--用户退出登陆--%>
        <div class="navigation-bar-child-context navigation-bar-child-textLogin"><a href="#" id="find_esc"></a></div>
        <div class="navigation-bar-child-context navigation-bar-child-textLogin">
            <%--用户名设置--%>
            <a id="find_userName"></a>
        </div>
        <div class="navigation-bar-child-context navigation-bar-child-textRegistered">
            <%--用户的头像设置--%>
            <img src="imgs/touxiang.png" style="height: 26px" id="find_userImg">
        </div>

        <form action="" class="navigation-bar-child-context navigation-bar-child-search">
            <input type="text" class="navigation-bar-child-context navigation-bar-child-searchBar" placeholder="搜索你感兴趣的内容..." >
            <button type="submit" class="navigation-bar-child-context navigation-bar-child-searchIco"><i class="iconfont icon-sousuo"></i></button>
        </form>
        <div class="navigation-bar-child-context navigation-bar-child-textThree"> <a href="${pageContext.request.contextPath}index.jsp">首页</a></div>
        <div class="navigation-bar-child-context navigation-bar-child-textThree"> <a href="${pageContext.request.contextPath}topic.jsp">话题</a></div>
        <div class="navigation-bar-child-context navigation-bar-child-textThree"> <a href="${pageContext.request.contextPath}find.jsp">发现</a></div>
    </div>
</div>


<!-- 版心 -->
<div class="page-type page">
    <!-- 左边大板块 -->
    <div class="main">
        <div class="main-title">
            <i class="iconfont icon-tuijian"></i>
            编辑推荐
            <div class="main-title-more"><a class="underline">更多推荐>></a></div>
        </div>
        <!-- 推荐内容 -->
        <div class="main-title-context">
            <!-- 单个回答 -->
            <div class="main-title-context-big">
                <h2 class="blue underline"><a>RNG VS RW：锐利得足够切开生命与死亡之间的薄纱</a></h2>
                <div>
                    <div class="avatar-div">
                        <img src="imgs/test1-avatar.jpg" alt="" class="avatar-img">
                    </div>
                    <div class="feed-main">
                        <div class="author-info">
                            <span class="author-link-line"><a class="underline">和纱千晶</a></span>
                            <span class="bio">地理学，撰稿人，文博控，在路上</span>
                        </div>
                        <div class="post-content">
                            <img src="imgs/test2.jpg" alt="" class="origin-image">
                            <div class="post-content-main">（本文发表于澎湃新闻·私家地理，请勿转载。）浙南闽北的山区是中国廊桥最密集的区域，山势险峻、河流湍急、雨水充沛的地理及气候特点决定了这片地区成为了廊桥诞生的“温床”。浙闽交界的“景泰庆寿”四县是廊桥分布最密集、营造技艺最完善、保存类型最丰…</div>
                        </div>

                    </div>
                </div>
            </div>
            <!-- 标题们 -->
            <div class="feed-item">
                <h2>
                    <a class="blue underline">七月与细生 | 让这部动漫告诉你你的细胞在干嘛</a>
                    <button class="spanBtn" style="float:right"><span class="main-title-more">圆子Knock</span></button>
                </h2>
            </div>
            <div class="replay">
                <form action="${pageContext.request.contextPath}/RemarkServlet" method="post">
                    <textarea name="text" style="height:60px;width:400px;font-size:14px" type="text" value="" placeholder="请针对此问题做出你的评论" maxlength="400"></textarea>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id ="replayBtn"type="submit" value="发表" style="height:30px;width:50px;background-color: #0e93d7">
                </form>
            </div>
            <div class="feed-item">
                <h2>
                    <a class="blue underline">9000 万续约卡佩拉，火箭准备好和勇士打争冠持久战</a>
                    <button class="spanBtn1" style="float:right"><span class="main-title-more">范特西情报局</span></button>
                </h2>
            </div>
            <div class="replay1">
                <form action="${pageContext.request.contextPath}/RemarkServlet" method="post">
                    <textarea name = "text" style="height:60px;width:400px;font-size:14px" type="text" value="" placeholder="请在这里输入你的回答" maxlength="400"></textarea>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="replayBtn1" type="submit" value="发表" style="height:30px;width:50px;background-color: #0e93d7">
                </form>
            </div>
        <!-- 回答内容主干区 -->
        <!--  -->
        <div class="explore-tab">
            <ul class="tab-navs">
                <li class="tab-nav"><a href="" class="anchor">今日最热</a></li>
                <li class="tab-nav"><a href="" class="anchor">本月最热</a></li>
            </ul>
            <!-- 主要大板块 -->
            <div class="tab-panel">
                <div class="daily">
                    <!-- 单个回答模块 -->
                    <div class="main-context-complete">
                        <h2 class="blue underline"><a>RNG VS RW：锐利得足够切开生命与死亡之间的薄纱</a></h2>
                        <div>
                            <div class="avatar-div">
                                <a href="" class="vote-count">3322</a>
                            </div>
                            <div class="feed-main-complete">
                                <div class="author-info">
                                    <span class="author-link-line"><a class="underline">和纱千晶</a></span>
                                    <span class="bio">地理学，撰稿人，文博控，在路上</span>
                                </div>
                                <div class="post-content">
                                    <img src="imgs/test2.jpg" alt="" class="origin-image">
                                    <div class="post-content-main">（本文发表于澎湃新闻·私家地理，请勿转载。）浙南闽北的山区是中国廊桥最密集的区域，山势险峻、河流湍急、雨水充沛的地理及气候特点决定了这片地区成为了廊桥诞生的“温床”。浙闽交界的“景泰庆寿”四县是廊桥分布最密集、营造技艺最完善、保存类型最丰…</div>
                                </div>
                                <!-- 点赞评论功能栏 -->
                                <div class="meta-panel bio">
                                    <a class="underline ">+关注问题</a>
                                    <a class="underline ">100条评论</a>
                                    <a class="underline ">作者保留权利</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- 单个回答模块 -->
                    <div class="main-context-complete">
                        <h2 class="blue underline"><a>RNG VS RW：锐利得足够切开生命与死亡之间的薄纱</a></h2>
                        <div>
                            <div class="avatar-div">
                                <a href="" class="vote-count">3322</a>
                            </div>
                            <div class="feed-main-complete">
                                <div class="author-info">
                                    <span class="author-link-line"><a class="underline">和纱千晶</a></span>
                                    <span class="bio">地理学，撰稿人，文博控，在路上</span>
                                </div>
                                <div class="post-content">
                                    <img src="imgs/test2.jpg" alt="" class="origin-image">
                                    <div class="post-content-main">（本文发表于澎湃新闻·私家地理，请勿转载。）浙南闽北的山区是中国廊桥最密集的区域，山势险峻、河流湍急、雨水充沛的地理及气候特点决定了这片地区成为了廊桥诞生的“温床”。浙闽交界的“景泰庆寿”四县是廊桥分布最密集、营造技艺最完善、保存类型最丰…</div>
                                </div>
                                <!-- 点赞评论功能栏 -->
                                <div class="meta-panel bio">
                                    <a class="underline ">+关注问题</a>
                                    <a class="underline ">100条评论</a>
                                    <a class="underline ">作者保留权利</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- 单个回答模块 -->
                    <div class="main-context-complete">
                        <h2 class="blue underline"><a>RNG VS RW：锐利得足够切开生命与死亡之间的薄纱</a></h2>
                        <div>
                            <div class="avatar-div">
                                <a href="" class="vote-count">3322</a>
                            </div>
                            <div class="feed-main-complete">
                                <div class="author-info">
                                    <span class="author-link-line"><a class="underline">和纱千晶</a></span>
                                    <span class="bio">地理学，撰稿人，文博控，在路上</span>
                                </div>
                                <div class="post-content">
                                    <img src="imgs/test2.jpg" alt="" class="origin-image">
                                    <div class="post-content-main">（本文发表于澎湃新闻·私家地理，请勿转载。）浙南闽北的山区是中国廊桥最密集的区域，山势险峻、河流湍急、雨水充沛的地理及气候特点决定了这片地区成为了廊桥诞生的“温床”。浙闽交界的“景泰庆寿”四县是廊桥分布最密集、营造技艺最完善、保存类型最丰…</div>
                                </div>
                                <!-- 点赞评论功能栏 -->
                                <div class="meta-panel bio">
                                    <a class="underline ">+关注问题</a>
                                    <a class="underline ">100条评论</a>
                                    <a class="underline ">作者保留权利</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- 单个回答模块 -->
                    <div class="main-context-complete">
                        <h2 class="blue underline"><a>RNG VS RW：锐利得足够切开生命与死亡之间的薄纱</a></h2>
                        <div>
                            <div class="avatar-div">
                                <a href="" class="vote-count">3322</a>
                            </div>
                            <div class="feed-main-complete">
                                <div class="author-info">
                                    <span class="author-link-line"><a class="underline">和纱千晶</a></span>
                                    <span class="bio">地理学，撰稿人，文博控，在路上</span>
                                </div>
                                <div class="post-content">
                                    <img src="imgs/test2.jpg" alt="" class="origin-image">
                                    <div class="post-content-main">（本文发表于澎湃新闻·私家地理，请勿转载。）浙南闽北的山区是中国廊桥最密集的区域，山势险峻、河流湍急、雨水充沛的地理及气候特点决定了这片地区成为了廊桥诞生的“温床”。浙闽交界的“景泰庆寿”四县是廊桥分布最密集、营造技艺最完善、保存类型最丰…</div>
                                </div>
                                <!-- 点赞评论功能栏 -->
                                <div class="meta-panel bio">
                                    <a class="underline ">+关注问题</a>
                                    <a class="underline ">100条评论</a>
                                    <a class="underline ">作者保留权利</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- 单个回答模块 -->
                    <div class="main-context-complete">
                        <h2 class="blue underline"><a>RNG VS RW：锐利得足够切开生命与死亡之间的薄纱</a></h2>
                        <div>
                            <div class="avatar-div">
                                <span sclass="vote-count">3322</span>
                            </div>
                            <div class="feed-main-complete">
                                <div class="author-info">
                                    <span class="author-link-line"><a class="underline">和纱千晶</a></span>
                                    <span class="bio">地理学，撰稿人，文博控，在路上</span>
                                </div>
                                <div class="post-content">
                                    <img src="imgs/test2.jpg" alt="" class="origin-image">
                                    <div class="post-content-main">（本文发表于澎湃新闻·私家地理，请勿转载。）浙南闽北的山区是中国廊桥最密集的区域，山势险峻、河流湍急、雨水充沛的地理及气候特点决定了这片地区成为了廊桥诞生的“温床”。浙闽交界的“景泰庆寿”四县是廊桥分布最密集、营造技艺最完善、保存类型最丰…</div>
                                </div>
                                <!-- 点赞评论功能栏 -->
                                <div class="meta-panel bio">
                                    <a class="underline ">+关注问题</a>
                                    <a class="underline ">100条评论</a>
                                    <a class="underline ">作者保留权利</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <button class="btn-white main">更多</button>
            </div><!-- 包括主体内容和加载按钮 -->
        </div><!-- 包括今日最热和本月最热 -->
    </div><!-- 整个左边 -->
    <!-- 侧面 -->
    <div class="side-bar" style="position: fixed;margin-left: 780px;margin-top: 30px;">
        <div class="left-label main-title" >
            <span class="">Online Q&A Forum</span>
        </div>
        <div style="position:fixed;float:right">
        <img src="imgs/test4.jpg" alt="">
        </div>
        <div class="side-section-inner">
        </div>
        <div>
            <ul class="side-nav" >
                <li>
                    <a href="#">安阳</a>
                </li>
                <li>
                    <a href="#">用户指南</a>
                </li>
                <li>
                   <a href="#">联系我们</a>
                </li>
                <li>
                    <a href="#">@2018 oQ&Af</a>
                </li>
                <li>
                    <a href="#">举报投诉</a>
                </li>
                <li>
                    <a href="#">知乎协议</a>
                </li>
                <li>
                    <a href="#">移动应用</a>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
