<!DOCTYPE html>
<html>
<head>
    <%@page pageEncoding="utf-8" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="css/editor.css" rel="stylesheet" type="text/css">
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/froala_editor.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/froala_page.min.css">
</head>

<body>

<div class="topalways">
    <!-- 导航栏头 -->
    <header  class="Sticky AppHeader" >
        <!-- 导航栏内置块 -->
        <div class="AppHeader-inner">
            <!-- oaqf图标 -->
            <div class="gn_logo">
                <h2>写文章</h2>
            </div>
            <div class="gn_logo1">
                <a href="index.jsp">返回首页</a>
            </div>
        </div>
    </header>
    <div class="ArticleTitle">
        <form id="form" class="formTest" action="${pageContext.request.contextPath}/ArticleServlet" method="post">
            <input type="text" name="title" placeholder="请在这里写您文章的标题" style="width:700px;height:30px;position:absolute;top:5px;left:10px  ">
            <select style="width:100px;height:35px;position:absolute;top:5px;left:800px " name="text">
                <option>生活</option>
                <option>编程</option>
                <option>音乐</option>
                <option>运动</option>
                <option>花艺</option>
                <option>数学</option>
                <option>科学</option>
            </select>
            <input type="hidden" name="articleContent" id ="content">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" name="sub" value="发布文章" id="publish">
        </form>
    </div>
</div>


<section id="editor">
    <div id='edit' style="margin-top: 30px;">
    </div>
</section>

        <script src="js/jquery-1.12.4.js"></script>
        <script src="js/froala_editor.min.js"></script>

        <script src="js/editorPlugins/tables.min.js"></script>
        <script src="js/editorPlugins/lists.min.js"></script>
        <script src="js/editorPlugins/colors.min.js"></script>
        <script src="js/editorPlugins/media_manager.min.js"></script>
        <script src="js/editorPlugins/font_family.min.js"></script>
        <script src="js/editorPlugins/font_size.min.js"></script>
        <script src="js/editorPlugins/block_styles.min.js"></script>
        <script src="js/editorPlugins/video.min.js"></script>

<script>
    $(function(){
        $('#edit').editable({
            inlineMode: false,
            buttons: ['bold', 'italic', 'underline', 'strikeThrough', 'fontSize', 'formatBlock', 'align', 'insertOrderedList', 'insertUnorderedList', 'outdent', 'indent', 'sep', 'createLink', 'insertImage', 'undo', 'redo', 'inserthorizontalrule'],
        })
        $("#publish").click(function(){
            var content = $('#edit')[0].childNodes[1].innerHTML;
            //通过val()给input设置value值
            $("#content").val(content);
            alert("成功发表！");
            //让表单自动提交
            $("#form").submit();
        })
    });
</script>
</body>
</html>