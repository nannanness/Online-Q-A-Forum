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
          $("#GoHome").click(function () {
              $.get(
                  "/indexServlet?method=init",
                  function () {
                      window.location.href="index.jsp";
                  }
              );
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
              if(p >= startPos) {
                  //$(ele).css({"position": "fixed", "top": 0, "right": "124px"});
                  // }else if(p < startPos){
                  //     $(ele).css({"position":"static"});
                  // }
              }});
          $("#cancleUser").click(function () {
              alert("已取消关注");
          });
          var careUserName = $("#careUserName").val();
          $("#careUser").click(function () {
              alert("关注成功"+careUserName);

          })
          //删除收藏
          $(".delete").click(function (e) {
              var index = $(".delete").index($(this));
              var deleteFlag = confirm("确定要删除吗？");
              if(deleteFlag){
                  alert("删除成功");
              }else {
                  e.preventDefault();
              }
          });
          //删除回答
          $(".deleteResponse").click(function (deleteResponse) {
              var index = $(".deleteResponse").index($(this));
              var deleteFlag = confirm("确定要删除吗？");
              if(deleteFlag){
                  alert("删除成功");
              }else {
                  deleteResponse.preventDefault();
              }
          });
          //删除问题
          $(".deleteQusetion").click(function (deleteQusetion) {
              var index = $(".deleteResponse").index($(this));
              var deleteFlag = confirm("确定要删除吗？");
              if(deleteFlag){
                  alert("删除成功");
              }else {
                  deleteQusetion.preventDefault();
              }
          });
          $(".deleteArticle").click(function (deleteArticle) {
              var index = $(".deleteResponse").index($(this));
              var deleteFlag = confirm("确定要删除吗？");
              if(deleteFlag){
                  alert("删除成功");
              }else {
                  deleteArticle.preventDefault();
              }
          })

      });

  </script>
  <style type="text/css">
    body{background: url("./${userInfo.user_bgc}") repeat;backgroundx-size: cover; font-size: 12px;}
  </style>
</head>
<body>
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
        <button><a href="resetUserInf.jsp">修改资料</a></button>
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
          <li class="active op" id="dongTai">我的动态</li>
          <li class="op" id="huiDa">我的回答</li>
          <li class="op" id="tiWen">我的提问</li>
          <li class="op" id="wenZhang">我的文章</li>
          <li class="op" id="shoucang">我的收藏</li>
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
              <h3>回答了:<b style="color: #259;">${userResponse.title}</b><span style="float: right;color: #999 ; font-size: 14px">${userResponse.replayDate}</span></h3>
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
                <h3>回答了:<b style="color: #259;">${userResponse.title}</b>&nbsp;&nbsp;<a href="/userDynamicsServlet?method=deleteResponse&problemId=${userResponse.problemId}" class="deleteResponse" style="color: red">删除</a> <span style="float: right;color: #999 ; font-size: 14px">${userResponse.replayDate}</span></h3>
                <div class="contentDetail">
                    ${userResponse.replayContent}
                </div>
                <div class="showAll"><span>显示全文</span></div>
                <div class="hideAll"><span>收回</span></div>
              </div>
          </c:forEach>
        </div>
        <%--提问--%>
        <div class="tab-item tiWen">
          <c:forEach items="${listUserQuestion}" var="userQuestion">
            <div class="contentCssSet">
              <h3>提出了:<b style="color: #259;">${userQuestion.title}</b> &nbsp;&nbsp;<a href="/userDynamicsServlet?method=deleteQusetion&problemId=${userQuestion.problemId}" class="deleteQusetion" style="color: red">删除</a><span style="float: right;color: #999 ; font-size: 14px">${userQuestion.problemDate}</span></h3>
              <div class="contentDetail">
                  ${userQuestion.content}
              </div>
              <div class="showAll"><span>显示全文</span></div>
              <div class="hideAll"><span>收回</span></div>
            </div>
          </c:forEach>
        </div>
        <%--文章--%>
        <div class="tab-item wenZhang">
          <c:forEach items="${listUserArticle}" var="userArticle">
            <div class="contentCssSet">
              <h3>发表了:<b style="color: #259;">${userArticle.articleTitle}</b> &nbsp;&nbsp;<a href="/userDynamicsServlet?method=deleteAriticle&articleId=${userArticle.articleId}" class="deleteArticle" style="color: red">删除</a> <span  style="float: right;color: #999 ; font-size: 14px">${userArticle.articleDate}</span></h3>
              <div class="contentDetail">
                  ${userArticle.articleContent}
              </div>
              <div class="showAll"><span>显示全文</span></div>
              <div class="hideAll"><span>收回</span></div>
            </div>
          </c:forEach>
        </div>
        <%--收藏--%>
        <div class="tab-item shoucang">
          <c:forEach items="${listUserCollection}" var="collection">
            <div class="contentCssSet">
              <h3>收藏了:<b style="color: #259;">${collection.user_Name}&nbsp;的回答</b>&nbsp;&nbsp;<a style="color: orangered" class="delete" href="/userDynamicsServlet?method=deleteCollection&problemId=${collection.problemId}&replayUserId=${collection.replayUserId}">删除</a> <span style="float: right;color: #999 ; font-size: 14px">${collection.replayDate}</span></h3>
                <div class="contentDetail">
                  ${collection.replayContent}
              </div>
              <div class="showAll"><span>显示全文</span></div>
              <div class="hideAll"><span>收回</span></div>
            </div>
          </c:forEach>
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
               <button style="margin: 18px 0 19px;float: right" id="cancleUser"> <a href="/userDynamicsServlet?method=cancleSight&Interviewed=${idol.careUserId}">取消关注</a></button>
              </div>
            <div style="clear:both"></div>
          </c:forEach>
        </div>
        <div class="tab-item">
          <c:forEach items="${listFans}" var="fans">
              <div class="list-link" style="display: block">
                  <a style="float: left"href="${pageContext.request.contextPath}/userDynamicsServlet?method=lookUserInfo&lookUserId=${fans.careUserId}"><b style="color: #259;" id="careUserName">${fans.fansUsername}</b></a>
                  <button style="margin: 18px 0 19px;float: right" id="careUser"><a href="${pageContext.request.contextPath}/userDynamicsServlet?method=sightUser&fans=${fans.fansId}">关注TA</a></button>
                  <div style="clear:both"></div>
              </div>
          </c:forEach>
        </div>
      </div>
    </div>
  </div>
</body>
</html>