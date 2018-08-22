<%--
  Created by IntelliJ IDEA.
  User: sword
  Date: 2018/8/9
  Time: 8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>OQ&AF--与世界分享你的故事</title>
    <script src="js/jquery-1.12.4.js"></script>
    <link rel="stylesheet" href="css/find.css">
    <link rel="stylesheet" href="css/topic.css">
    <link rel="stylesheet" href="css/disorderly.css">
    <link rel="icon" href="imgs/icon.png">
    <script src="js/jquery-1.12.4.js"></script>
    <%--<script>--%>
        <%--$.get(function () {--%>
            <%----%>
        <%--})--%>
    <%--</script>--%>
    <script type="text/javascript">
        $(function() {
            $("#btn").click(function () {
                    $(this).attr("type", "submit");
                    alert("小可爱您的问题我们已经获取到了呢！嘻嘻")

            });

        })


    </script>
</head>
<body>
    <input type="hidden" id="ifLogin" value="${ifLogin}">
    <div class="topicLead" >
        <div class="navigation-bar-child">
            <div class="navigation-bar-child-context navigation-bar-child-title"><a href="index.jsp">OQ&AF</a></div>
            <!-- <%--用户退出登陆--%> -->
            <div class="navigation-bar-child-context navigation-bar-child-textLogin"><a href="#" id="find_esc"></a></div>
            <div class="navigation-bar-child-context navigation-bar-child-textLogin">
                <!-- <%--用户的头像设置--%> -->
                <a  href="#" id="find_userName"></a>
            </div>
            <div class="navigation-bar-child-context navigation-bar-child-textRegistered">
                <!-- <%--用户的头像设置--%> -->
                <img src="imgs/touxiang.png" style="height: 26px" id="find_userImg">
            </div>

            <form action="" class="navigation-bar-child-context navigation-bar-child-search">
                <input type="text" class="navigation-bar-child-context navigation-bar-child-searchBar" placeholder="搜索你感兴趣的内容..." >
                <button type="submit" class="navigation-bar-child-context navigation-bar-child-searchIco"><i class="iconfont icon-sousuo"></i></button>
            </form>
            <div class="navigation-bar-child-context navigation-bar-child-textThree"> <a href="${pageContext.request.contextPath}index.jsp">首页</a></div>
            <div class="navigation-bar-child-context navigation-bar-child-textThree"> <a href="${pageContext.request.contextPath}topic.jsp">话题</a></div>
        </div>
    </div>
    <!-- 版心 -->
    <div class="dis-Main" >
        <div style="padding: 25px 0 50px;min-height: 340px;">
            <h1 class="ContactPage-title">
                ${sessionScope.title}
            </h1>
            <div class="ContactPage-para">
                <%--知乎属于北京智者天下科技有限公司旗下品牌。知乎，中文互联网知名的知识社交平台。知乎以知识连接一切为使命，凭借认真、专业和友善的社区氛围和独特的产品机制，聚集了中国互联网上科技、商业、文化等领域里最具创造力的人群，将高质量的内容透过人的节点来成规模地生产和分享，构建高价值人际关系网络。用户通过问答等交流方式建立信任和连接，打造和提升个人品牌价值，并发现、获得新机会。--%>
                ${sessionScope.whe}
            </div>
            <div class="ContactPage-para">
                <%--公司名称：北京智者天下科技有限公司<br>--%>
                <%--地址：北京市海淀区学院路甲 5 号 768 创意园 A 座西区四通道 3-010<br>--%>
                <%--电话：010-61190680--%>
                ${sessionScope.wher}
            </div>
        </div>
    </div>
    <div id="dis-footer" class="dis-footer">
        <div class="dis-content zg-wrap dis-clearfix">
            <ul>

                <li><a href="${pageContext.request.contextPath}/disorderlyServlet?method=zhinan" target="_blank">OQ&AF指南·</a></li>
                <li><a href="${pageContext.request.contextPath}/disorderlyServlet?method=yijian" id="js-feedback-button">·建议反馈·</a></li>

                <li><a href="${pageContext.request.contextPath}/disorderlyServlet?method=xieyi" target="_blank">·OQ&AF协议·</a></li>
                <li><a href="${pageContext.request.contextPath}/disorderlyServlet?method=guanyu" target="_blank">·关于我们·</a></li>
                <li><a href="${pageContext.request.contextPath}/disorderlyServlet?method=jiaru" target="_blank">·加入我们·</a></li>
                <li><a href="${pageContext.request.contextPath}/disorderlyServlet?method=jubao" target="_blank">·举报投诉·</a></li>
                <li><a href="${pageContext.request.contextPath}/disorderlyServlet?method=yingsi" target="_blank">·隐私政策·</a></li>
                <li><a href="${pageContext.request.contextPath}/disorderlyServlet?method=lianxi">·联系我们·</a></li>

            </ul>

            <span class="copy">© 2018 OQ&AF</span>

        </div>
    </div>
</body>
</html>