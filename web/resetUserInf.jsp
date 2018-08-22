<%--
  Created by IntelliJ IDEA.
  User: dell00
  Date: 2018/8/1
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/amazeui.css">
    <!--引入CSS-->
    <link rel="stylesheet" type="text/css" href="css/webuploader.css">
    <link href="css/resetUserInfo.css" rel="stylesheet" type="text/css">
    <link rel="icon" href="imgs/icon.png">
    <!--引入JS-->
    <script src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/webuploader.js"></script>

    <script>
        $(function () {
            var flag = true;
            var flagAvatar = true;
            // 初始化Web Uploader
            var uploaderAvatar = WebUploader.create({
                // 选完文件后，是否自动上传。
                auto: true,
                // swf文件路径
                swf: 'js/Uploader.swf',
                // 文件接收服务端。
                server: 'avatarUpLoadServlet',
                // 选择文件的按钮。可选。
                // 内部根据当前运行是创建，可能是input元素，也可能是flash.
                pick: '#avatarfile',
                // 只允许选择图片文件。
                accept: {
                    title: 'Images',
                    extensions: 'gif,jpg,jpeg,bmp,png',
                    mimeTypes: 'image/*'
                }
            });
            uploaderAvatar.on( 'fileQueued', function( file ) {
                var $li = $(
                    '<div id="' + file.id + '" class="file-item thumbnail">' +
                    '<img>' +
                    '</div>'
                    ),
                    $img = $li.find('img');
                // console.log(file.id);

                // $list为容器jQuery实例
                // if( $('#av-img').length > 0){
                //     $('#avatarList').html('');
                // }
                // if(!flagAvatar){
                //     $('#avatarList').html('');
                // }
                $('#avatarList').html('');
                $('#avatarList').append( $li );
                flagAvatar = false;
                // 创建缩略图
                // 如果为非图片文件，可以不用调用此方法。
                // thumbnailWidth x thumbnailHeight 为 100 x 100
                uploaderAvatar.makeThumb( file, function( error, src ) {
                    if ( error ) {
                        $img.replaceWith('<span>不能预览</span>');
                        return;
                    }
                    $img.attr( 'src', src );
                }, 168, 168 );
            });
            // 文件上传成功，给item添加成功class, 用样式标记上传成功。
            uploaderAvatar.on( 'uploadSuccess', function( file ) {
                // alert("头像更新成功");
                $( '#'+file.id ).addClass('upload-state-done');
            });
            // 文件上传失败，显示上传出错。
            uploaderAvatar.on( 'uploadError', function( file ) {
                var $li = $( '#'+file.id ),
                    $error = $li.find('div.error');
                // 避免重复创建
                if ( !$error.length ) {
                    $error = $('<div class="error"></div>').appendTo( $li );
                }
                $error.text('上传失败');
            });
            // 完成上传完了，成功或者失败，先删除进度条。
            uploaderAvatar.on( 'uploadComplete', function( file ) {
                $( '#'+file.id ).find('.progress').remove();
            });


            // 初始化Web Uploader
            var uploader = WebUploader.create({
                // 选完文件后，是否自动上传。
                auto: true,
                // swf文件路径
                swf: 'js/Uploader.swf',
                // 文件接收服务端。
                server: 'userInfoBGPServlet',
                // 选择文件的按钮。可选。
                // 内部根据当前运行是创建，可能是input元素，也可能是flash.
                pick: '#filePicker',
                // 只允许选择图片文件。
                accept: {
                    title: 'Images',
                    extensions: 'gif,jpg,jpeg,bmp,png',
                    mimeTypes: 'image/*'
                }
            });
            uploader.on( 'fileQueued', function( file ) {
                var $li = $(
                    '<div id="' + file.id + '" class="file-item thumbnail">' +
                    '<img>' +
                    '</div>'
                    ),
                    $img = $li.find('img');
                console.log(file.id);
                    // $list为容器jQuery实例
                // if(!flag){
                //     $('#fileList').html('');
                // }
                $('#fileList').html('');
                $('#fileList').append( $li );
                flag = false;
                // 创建缩略图
                // 如果为非图片文件，可以不用调用此方法。
                // thumbnailWidth x thumbnailHeight 为 100 x 100
                uploader.makeThumb( file, function( error, src ) {
                    if ( error ) {
                        $img.replaceWith('<span>不能预览</span>');
                        return;
                    }
                    $img.attr( 'src', src );
                }, 1000, 260 );
            });
            // 文件上传成功，给item添加成功class, 用样式标记上传成功。
            uploader.on( 'uploadSuccess', function( file ) {
                // alert("背景上传成功");
                $( '#'+file.id ).addClass('upload-state-done');
            });
            // 文件上传失败，显示上传出错。
            uploader.on( 'uploadError', function( file ) {
                var $li = $( '#'+file.id ),
                    $error = $li.find('div.error');
                // 避免重复创建
                if ( !$error.length ) {
                    $error = $('<div class="error"></div>').appendTo( $li );
                }
                $error.text('上传失败');
            });
            // 完成上传完了，成功或者失败，先删除进度条。
            uploader.on( 'uploadComplete', function( file ) {
                $( '#'+file.id ).find('.progress').remove();
            });
        });
    </script>
</head>
<body>
<!-- 导航栏 -->
<div class="topalways">
    <div>
        <!-- 导航栏头 -->
        <header role="banner" id="nav"  class="Sticky AppHeader " date-za-module="TopNavBar">
            <!-- 导航栏内置块 -->
            <div class="AppHeader-inner">
                <!-- oaqf图标 -->
                <div class="gn_logo">
                    <a href="index.jsp" aria-label="OQ&AF" style="height:30px;width: 64px">
                        <h1 style="color:#105eeec2;font-size: 26px;margin: 0">OQ&AF</h1>
                    </a>
                </div>
                <!-- 跳转的几个链接 -->
                <div class="gn_nav">
                    <ul class="gn_nav_list">
                        <li>
                            <a href="" class="AppHeader-navItem1 is-active">
                                <em class="shouyeziti">首页</em>
                            </a>
                        </li>
                        <li><a href="" class="AppHeader-navItem is-active">
                            <em>话题</em>
                        </a>
                        </li>

                    </ul>
                </div>
                <!-- 搜索栏 -->
                <div class="gn_search">
                    <a href="" class="W_ficon ficon_search S_ficon"  target="_top" >
                        <img src="imgs/search.png" style="height:20px;width:20px;">
                    </a>
                    <input type="text" placeholder="前方不高能不要搜索" name="15" class="shuru" >

                </div>
                <!-- 通知等实现 -->

            </div>
        </header>
    </div>
        <div class="middle" >
            <div id="uploader-demo" >
                <!--用来存放item-->
                <div id="fileList" class="uploader-list middle">
                    <img src="${userInfo.user_bgc}" alt="背景图片" id="bg-img" class="middle">
                </div>
                <div id="filePicker" class="buttonImg">背景图片</div>
            </div>
        </div>
    <%--</div>--%>
    <!-- 用户信息修改 -->
    <div class="tail">
        <!-- <div class="userImg">用户头像</div> -->
        <div class="am-form-group am-form-file imgDiv" >
            <%--<img src="./${userInfo.user_Img}" alt="用户头像" id="av-img" class="userImg">--%>
            <div class="userImg" id="avatarList">
                <img src="${userInfo.user_Img}" alt="用户头像" id="av-img" class="userImg">

            </div>
            <div class="uploadDiv">
                <div id="avatarfile" class="uploadAvatar">上传头像</div>
            </div>
        </div>

        <div class="userInfo">
            <!-- 详细信息 -->
            <div class="detailInfo">
                <form class="am-form am-form-horizontal" action="/updateUserInfoServlet">
                    <div class="am-form-group">
                        <label for="doc-ipt-3" class="am-u-sm-2 am-form-label">用户名</label>
                        <div class="am-u-sm-10">
                            <input name="username" type="text" id="doc-ipt-3" value="${userInfo.user_Name}">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="doc-ipt-3" class="am-u-sm-2 am-form-label">一句话描述</label>
                        <div class="am-u-sm-10">
                            <input name="userDetails" type="text" id="doc-ipt-3" value="${userInfo.user_Details}">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="doc-ipt-3" class="am-u-sm-2 am-form-label">性别</label>
                        <div class="am-u-sm-10">
                            <c:if test="${userInfo.user_Sex =='男'}">
                                <label class="am-radio-inline">
                                    <input type="radio" value="男" name="sex" checked="checked">男
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" value="女" name="sex"> 女
                                </label>
                            </c:if>
                            <c:if test="${userInfo.user_Sex =='女'}">
                                <label class="am-radio-inline">
                                    <input type="radio" value="男" name="sex">男
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" value="女" name="sex" checked="checked"> 女
                                </label>
                            </c:if>
                            <c:if test="${userInfo.user_Sex ==null}">
                                <label class="am-radio-inline">
                                    <input type="radio" value="男" name="sex">男
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" value="女" name="sex" > 女
                                </label>
                            </c:if>

                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="doc-ipt-3" class="am-u-sm-2 am-form-label">教育经历</label>
                        <div class="am-u-sm-10">
                            <input name="userSchool" type="text" id="doc-ipt-3" value="${userInfo.user_school}">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <div class="am-u-sm-2 am-u-sm-offset-2">
                            <button type="submit" class="am-btn am-btn-default am-btn-secondary" style="width:465px">保存修改</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
