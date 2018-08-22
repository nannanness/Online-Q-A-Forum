
<%@ page import="org.lanqiao.oqaf.service.IUserService" %>
<%@ page import="org.lanqiao.oqaf.service.impl.UserServiceImpl" %>
<%@ page import="org.lanqiao.oqaf.domain.User" %><%--<!DOCTYPE html>--%>
<%@ page  contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <meta content="分享你想表达的，让全世界都能听到你的心声！" name="description" />
  <title>OQ&AF--与世界分享你的故事</title>
  <link rel="stylesheet" href="css/shouye.css">
  <link rel="stylesheet" href="css/imaglook.css">
  <link rel="stylesheet" href="css/remark.css">
  <link rel="stylesheet" href="css/indexPanel.css">
  <link rel="icon" href="imgs/icon.png">
  <script src="js/jquery-1.12.4.js"></script>
  <link href="css/zoomify.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="js/zoomify.js"></script>
  <script type="text/javascript">
      $(function(){
          //后台的链接
          $.get(
              "/indexServlet?method=init",
              function () {
                  // 回掉函数页面只刷新一次
                  if(location.href.indexOf('#reloaded')==-1) {
                      location.href = location.href + "#reloaded";
                      location.reload();
                  }
              }
          );
          $("#GoHome").click(function () {
              $.get(
                  "/indexServlet?method=init",
                  function () {
                      window.location.href="index.jsp";
                  }
              );
          });
          //加载更多
          $("#loadMore").click(function () {
              var index = $("#index").val();
              $.get(
                  "/indexServlet?method=loadMore",
                  function () {

                  }
              )
          })
          var ifLogin =$("#ifLogin").val();
          if(ifLogin){
              $("#index_right_login").attr("style","display:none");
              if("${userImg}"){
                  $("#user_img").attr("src","${userInfo.user_Img}");
              }
              $("#user_img_Btn").attr("href","/userDynamicsServlet?method=init&Interviewed=${userInfo.user_Id}");

          }else {
              $("#esc").attr("style","display:none");
              $("#user_img_Btn").click(function () {
                  alert("请登陆后再进入");
                  $("#user_img_Btn").attr("href","login.jsp");

              });
          }
          var login = $("#index_login");//登陆事件
          login.click(function () {
              window.location.href="login.jsp";
          })
          var zuce = $("#index_zuce");//注册按钮
          zuce.click(function () {
              window.location.href="login.jsp";
          });
          $("#esc").click(function () {
              $.get(
                  "/loginServlet?method=esc",
                  function (data) {
                      alert(data);
                  }
              );
              window.location.href ="login.jsp";
          })

          $("#btn").click(function(){
              if(ifLogin){
                  $(this).attr("type","submit");
                  alert("小可爱您的问题我们已经获取到了呢！嘻嘻")
              }else{
                  $(this).attr("type","button");
                  alert("小可爱您还没有登录呦，请登录后在来提问哦");
              }
          });
          $("#publishArticle").click(function () {
              if(ifLogin){
                  alert("即将跳转到写文章页面");
                  window.location.href="editor.jsp";
              }else{
                  alert("小可爱您还没有登录呦，请登录后在来发表文章哦");
              }
          })
          //开启提问窗口
          var flage = true;
          $('.QuestionAskButton').on({
              click: function () {
                  if (flage) {
                      flage = false;
                      $('.QuestionAskButton').removeClass('active');
                      $('.table-div').removeClass('active');
                      $('.table-content').addClass('active');
                      $(this).addClass('active');
                      $('.table-div').eq($(this).index()).addClass('active')
                  }else {
                      flage = true;
                      $('.QuestionAskButton').addClass('active');
                      $('.table-div').addClass('active');
                      $('.table-content').removeClass('active');
                      $(this).removeClass('active');
                      $('.table-div').eq($(this).index()).removeClass('active')
                  }

              }
          })
          //固定导航头
          $(window).scroll(function(){
              if($(window).scrollTop() >=1){
                  $("#nav").addClass("is-fixed");
                  $(".App-main").css("marginTop",-10);
                  $(".ContentLayout-sideColumn").css("marginTop",62);
              }else{
                  $("#nav").removeClass("is-fixed");
                  $(".App-main").css("marginTop",0);
                  $(".ContentLayout-sideColumn").css("marginTop",0);
              }
          });
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
          // 开启收藏特效功能

          // 开启收藏特效功能
          var flage2 = true;
          $(".btn-shoucang").each(function() {
              $(this).bind('click',function(){
                  var index = $(".btn-shoucang").index($(this));
                  var pid = $(".pid").eq(index).val();
                  var uid = $(".uid").eq(index).val();
                  if(ifLogin){
                      if(flage2){
                          $.get(
                              "collectionServlet?method=collectReplay",
                              {"pid":pid,"uid":uid},
                              function () {

                              }
                          )
                          $(this).text("已收藏");
                          $.tipsBox({
                              obj: $(this),
                              str: "已收藏",
                              callback: function() {
                              }
                          });
                          flage2= false;
                      }else {
                          $.get(
                              "collectionServlet?method=cancelCollectReplay",
                              {"pid":pid,"uid":uid},
                              function () {

                              }
                          )
                          $(this).text("收藏");
                          $.tipsBox({
                              obj: $(this),
                              str: "取消收藏",
                              callback: function() {
                              }
                          });
                          flage2 = true;
                      }
                  }else{
                      alert("你还没有登陆，请登录后再进行收藏")
                  }

              })
          });
          //开启图片浏览特效
          var cc6 = $("#card-container-6"),
              cssAppear = {
                  opacity: 0
              }
          cc6.children('.card').click(function(e){
              cc6.prepend($(this));
          });
          //加载更多
          $("#loadMore").click(function () {
              var index = $("#index").val();//
              $.get(
                  "/indexServlet?method=loadMore",
                  {
                      index:index
                  },
                  function (data) {
                      window.location.href="index1.jsp";
                  }
              );

          });
          var searchContent;//搜索内容
          $("#search").keyup(function () {
              searchContent = $(this).val();//获取到搜索框中的内容
          });
          $("#searchBtn").click(function () {
              $.get(
                  "/indexServlet?method=search",
                  {
                      searchContent:searchContent
                  },
                  function () {
                      window.location.href="index1.jsp";
                  }


              )
          })

      });
  </script>
  <script>
      (function($) {
          $.extend({
              tipsBox: function(options) {
                  options = $.extend({
                      obj: null,  //jq对象，要在那个html标签上显示
                      str: "+1",  //字符串，要显示的内容;也可以传一段html，如: "<b style='font-family:Microsoft YaHei;'>+1</b>"
                      startSize: "12px",  //动画开始的文字大小
                      endSize: "30px",    //动画结束的文字大小
                      interval: 600,  //动画时间间隔
                      color: "#175199",    //文字颜色
                      callback: function() {}    //回调函数
                  }, options);
                  $("body").append("<span class='num'>"+ options.str +"</span>");
                  var box = $(".num");
                  var left = options.obj.offset().left + options.obj.width() / 2;
                  var top = options.obj.offset().top - options.obj.height();
                  box.css({
                      "position": "absolute",
                      "left": left + "px",
                      "top": top + "px",
                      "z-index": 9999,
                      "font-size": options.startSize,
                      "line-height": options.endSize,
                      "color": options.color
                  });
                  box.animate({
                      "font-size": options.endSize,
                      "opacity": "0",
                      "top": top - parseInt(options.endSize) + "px"
                  }, options.interval , function() {
                      box.remove();
                      options.callback();
                  });
              }
          });
      })(jQuery);
  </script>
  <script>
      $(document).ready(function() {
          var ifLogin =$("#ifLogin").val();
          $('.pinglun').click(function() {
              var index = $('.pinglun').index($(this));
              var proId = $(".pid").eq(index).val();
              var userId = $(".uid").eq(index).val();
              // var proId = $(this).next().val();
              // var userId = $(this).next().next().val();
              let that = $(this);
              console.log($(this));
              $.get(
                  "${pageContext.request.contextPath}remarksServlet",
                  {"proId":proId,"userId":userId},
                  function (data){
                      console.log(data);
                      for(var i = 0 ; i < data.length ; i++){
                          $(".com-users").eq(index).append("<div class=\"comment-user\">\n" +
                              "    <%-- 用户名 --%>\n" +
                              "   <span ><b class=\"yonghuming\">"+ data[i].user_Name +"</b></span>\n" +
                              "   <%-- 评论时间 --%>\n" +
                              "     <span class=\"pinglunshijian\">"+ data[i].remarkDate +"</span>\n" +
                              "      <%--  评论内容  --%>\n" +
                              "        <div class=\"comment-user-content pinglunneirong\">"+ data[i].remarkContent +"</div>\n" +
                              "   </div>")
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
          })


          $('.btn-guanbi').click(function() {
              $(this).parent().parent().parent().parent().parent().css("display", "none");
          });

          $('.btn-reply').click(function() {
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
              Y = date.getFullYear() + '-';
              M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
              D = date.getDate() + ' ';
              h = date.getHours() + ':';
              m = date.getMinutes() + ':';
              s = date.getSeconds();
              console.log(Y+M+D+h+m+s);
              timeStr = Y+M+D+h+m+s;
              // 输出结果：2014-04-23 18:55:49
              if (ifLogin) {
                if(test.length!=0){
                    if(test.length<=100){
                      that.append("<div class=\"comment-user\">"+"<span ><b class=\"yonghuming\">"+uName+"</b></span>"+ "<span class=\"pinglunshijian\">"+timeStr+"</span>"+"<div class=\"comment-user-content pinglunneirong\">"+test+"</div>"+"</div>");
                      $.get(
                          "${pageContext.request.contextPath}RemarkServlet",
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
          })
          $('.btn-cancel').click(function() {
              var m = document.getElementsByClassName("btn-reply");
              var n = document.getElementsByClassName("user-reply");
              var index = $(".btn-cancel").index($(this));
              console.log(index);
              $(".user-reply").eq(index).css("display", "none");
          });







          $(".replayProblem").click(function(eee) {
              if (ifLogin) {
                  var index = $(".replayProblem").index($(this));
                  var problemId = $(".pid").eq(index).val();
                  var problemTile = $(".proTitle").eq(index).val();
                  $.get(
                      "${pageContext.request.contextPath}indexServlet?method=ifReplay",
                      {
                          "problemId":problemId,
                          "problemTitle":problemTile
                      },
                      function (data) {
                          if(data){
                              window.location.href="/replay.jsp";
                          }else {
                              alert("你已经回答过了");
                          }
                      }
                  );
              } else {
                  alert("您还没有登录，请登录后再来写你的回答");
              }
          })
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
          //提问取消
          $("#askProblemCancle").click(function () {
              $("#b").css("display","none");
          });
          $("#askBtn").click(function () {
              $("#b").css("display","block");
          });
          $("#writeArticle").click(function () {
              $("#b").css("display","none");
          });

      });
  </script>

</head>
<body>
<%--判断是否登陆--%>
<input type="hidden" id="ifLogin" value="${ifLogin}">
<input type="hidden" id="userId"  value="${userId}">
<!-- 导航栏 -->
<div class="topalways">
  <div>
    <!-- 导航栏头 -->
    <header role="banner" id="nav"  class="Sticky AppHeader " date-za-module="TopNavBar">
      <!-- 导航栏内置块 -->
      <div class="AppHeader-inner">
        <!-- oaqf图标 -->
        <div class="gn_logo">
          <a href="${pageContext.request.contextPath}index.jsp" aria-label="OQ&AF" style="height:30px;width: 64px">
            <h1 style="color:#105eeec2;font-size: 26px">OQ&AF</h1>
          </a>
        </div>
        <!-- 跳转的几个链接 -->
        <div class="gn_nav">
          <ul class="gn_nav_list">
            <li>
              <a href="" class="AppHeader-navItem1 is-active" id="GoHome">
                <em class="shouyeziti">首页</em>
              </a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/topicServlet?method=init&page=home" class="AppHeader-navItem is-active">
                <em>话题</em>
              </a>
            </li>
          </ul>
        </div>

        <!-- 搜索栏 -->
        <div class="gn_search">
          <a href="" class="W_ficon ficon_search S_ficon"  target="_top" >
            <img src="imgs/search.png" style="height:20px;width:20px;" id="searchBtn">
          </a>
          <input type="text"  placeholder="前方不高能不要搜索" id="search" class="shuru" >
        </div>

        <!-- 用户的信息的显示 -->
        <div class="AppHeader-userInfo">
          <div class="AppHeader-profile">
            <div class="Popover AppHeader-menu">
              <a href="" id="user_img_Btn">
                <img src="imgs/touxiang.png" id="user_img" alt="显示用户"style="height:24px;width:26px;">
              </a>
            </div>
          </div>
          &nbsp; &nbsp; &nbsp;<button id="esc" style="color: #8590a6;">退出</button>
        </div>
      </div>
    </header>
  </div>

  <!-- 页面主体 -->
  <main role="main" class="App-main">
    <!-- 整体块 -->
    <div class="Topstory">
      <!-- 中间块 -->
      <div class="Topstory-container">
        <!-- 提问横栏 -->
        <div class="ContentLayout-mainColumn">
          <div class="Card">
            <div class="TopstoryHeader">
              <div class="TopstoryHeader-nav">
                <a href="#" class="Button QuestionAskButton tiwen TopstoryHeader-navItem Button--plain" id="askBtn">
                  <span>
                       <img src="imgs/tiwen.png" alt="" style="height:22px;width:22px;" class="Icon">
                            提问
                          </span>
                </a>
                <a href="#" class="TopstoryHeader-navItem TopstoryHeader-navItemArticle" id="aPublishArticle" id="writeArticle">
                    <span id="publishArticle">
                      <img src="imgs/xiewenzhang.png" alt="" style="height:20px;width:20px;" class="Icon Icon-write">
                      写文章
                    </span>
                </a>
              </div>
            </div>
          </div>

          <div id="b" class="table-content">
            <!-- 提问 -->
            <div class="table-div tiwen ">
              <form action="${pageContext.request.contextPath}/problemServlet" method="post" style="font-size:14px ;font-weight: bold;color: #2255a6">
                提问标题：<input style="height:30px;width:300px"type="text" name="title" value="" placeholder="输入问题并以问号结尾"><br><br>
                问题类型：<select name="Type" style="height:30px;width:200px">
                <option name="type">生活类</option>
                <option name="type">感情类</option>
                <option name="type">疾病类</option>
                <option name="type">学习类</option>
                <option name="type">编程类</option>
                <option name="type">游戏类</option>
                <option name="type">事业类</option>
              </select><br><br>
                问题描述：<textarea style="height:90px;width:300px" name="text" maxlength="300" placeholder="请输入问题描述（选填）"></textarea>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="提交" id="btn" style="cursor: pointer;height:30px;width:70px;outline: #2255a6;border:none;padding: 0px 12px;border-radius: 8px;color:#225599;font-weight: bold">
                <input type="button" value="取消" id="askProblemCancle" style="cursor: pointer;height:30px;width:70px;outline: #2255a6;border:none;padding: 0px 12px;border-radius: 8px;color:#225599;font-weight: bold">
                <br><br>
              </form>
            </div>
          </div>
          <div>
            <!-- 数据展示 -->
            <c:forEach items="${problem_replayList}" var="problem">
              <div >
                <div class="main-context-complete Card">
                  <h1 class="blue underline"><a>${problem.title} &nbsp; &nbsp;${problem.content}</a></h1>
                  <div>
                    <div class="feed-main-complete">
                      <div class="author-info">
                        <div class="avatar-div">
                          <img class="touxiang-img" src="${problem.user_Img}" alt="" style="height:24px;width:24px">
                        </div>
                        <span class="author-link-line"><a href="/userDynamicsServlet?method=lookUserInfo&lookUserId=${problem.replayUserId}" class="underline">${problem.user_Name}</a></span>
                        <span class="bio"><a href="/topicServlet?method=codeClass&type=${problem.problemType}">${problem.problemType}</a></span>
                      </div>
                      <div style="display: none">
                        <%--<p><img src=imgs/text7.jpg id=""></p>--%>
                        <p>${problem.replayContent}</p>
                        <button type="button" class="ButtonPlain hindearticle" id="hindearticle" style="display:none" >收起全文</button>
                      </div>
                      <div class="post-content">
                        <div class="card-container-6" id="card-container-6">
                          <div class="card"><img src="imgs/text6.jpg" alt="" class="origin-image"></div>
                          <div class="card"><img src="imgs/text5.jpg" alt="" class="origin-image"></div>
                          <div class="card"><img src="imgs/text7.jpg" alt="" class="origin-image"></div>
                        </div>
                        <div class="post-content-main" >
                          <h2 style="height:80px">
                            <p>${problem.replayContent}</p>
                          </h2>
                          <div style="float: right;padding-left:420px;padding-top:7px;position: absolute">
                            <button type="button" class="ButtonPlain reademore" id="reademore">阅读全文</button>
                          </div>
                        </div>
                      </div>
                      <!-- 点赞评论功能栏 -->

                        <%--评论框--%>
                      <div class="meta-panel bio">
                        <button  class="underline btn-shoucang">收藏</button>
                        <button class="underline pinglunAfter" style="display: none">评论</button>
                        <button class="underline pinglun">评论</button>
                          <%--回答--%>
                        <span  class="underline replayProblem" >回答</span>
                        <input type="hidden" value="${problem.title}" class="proTitle"></input>
                        <input type="hidden" value="${problem.problemId}" class="pid" >
                        <input type="hidden" value="${problem.replayUserId}"  class="uid">
                        <input type="hidden" value="${sessionScope.userInfo.user_Id}"  class="rid">
                        <input type="hidden" value="${sessionScope.userInfo.user_Name}"  class="uName">
                        <%--<a class="underline ">分享</a>--%>
                        <div class="bdsharebuttonbox" style="display: inline">
                          <a href="#" class="bds_more" data-cmd="more"></a>
                          <a href="#" class="bds_qzone" data-cmd="qzone"></a>
                          <a href="#" class="bds_tsina" data-cmd="tsina"></a>
                          <a href="#" class="bds_tqq" data-cmd="tqq"></a>
                          <a href="#" class="bds_renren" data-cmd="renren"></a>
                          <a href="#" class="bds_weixin" data-cmd="weixin"></a>
                        </div>
                      </div>
                        <%--评论框--%>
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
              </div>
            </c:forEach>

          </div>
          <%--加载更多--%>
          <div>
            <div class="Card">
              <div>
                <input type="hidden" id="index" value="0">
                <button class="Button getMore" type="button" value="加载更多" id="loadMore" >加载更多</button>
              </div>
            </div>
          </div>

          <div class="TopstoryMain">
            <div class>

            </div>
          </div>
        </div>

        <div class="ContentLayout-sideColumn" style="position: fixed;margin-left:730px;overflow: hidden">
          <div class>
            <div>
              <div class="Sticky">
                <div class="Card">
                  <div class="HomeSidebar-signBanner">
                    <div class="HomeSidebar-signBannerHeader">
                      <div class="HomeSidebar-signBannerTitle">
                        加入我们<br>
                        发现更美好的世界
                      </div>
                      <div class="HomeSidebar-signBannerActions" id="index_right_login">
                        <button  type="button" class="Button HomeSidebar-signBannerButton Button--blue Button--spread" id="index_login">
                          登录
                        </button>
                        <button  type="button" class="Button HomeSidebar-signBannerButton Button--primary Button--blue Button--spread" id="index_zuce" >
                          注册
                        </button>
                      </div>
                    </div>
                    <div class="HomeSidebar-signBannerFooter">
                      <div class="Card AppBanner HomeSidebar-download">
                        <a class="AppBanner-link" href="">
                          <div class="AppBanner-layout">
                            <img class="AppBanner-qrcode" src="imgs/erweima.jpg" >
                            <div class="AppBanner-content">
                              <div class="AppBanner-title">
                                扫码下载OQ&AF App
                              </div>
                              <div class="AppBanner-description">
                                立即体验更多精彩内容
                              </div>
                            </div>
                          </div>
                        </a>
                      </div>
                    </div>
                  </div>
                </div>
                <div >
                  <div>
                    <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" id=scriptmain name=scriptmain codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="296" height="206">
                      <param name="movie" value="bcastr.swf?bcastr_xml_url=xml/bcastr.xml">
                      <param name="quality" value="high">
                      <param name=scale value=noscale>
                      <param name="LOOP" value="false">
                      <param name="menu" value="false">
                      <param name="wmode" value="transparent">
                      <embed src="bcastr.swf?bcastr_xml_url=xml/bcastr.xml" width="296" height="206" loop="false" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" salign="T" name="scriptmain" menu="false" wmode="transparent"></embed>
                    </object>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
</div>

</body>
</html>