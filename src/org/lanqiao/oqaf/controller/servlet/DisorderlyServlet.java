package org.lanqiao.oqaf.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/disorderlyServlet")
public class DisorderlyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method=request.getParameter("method");
        switch(method){
            case "zhinan":
                getZhinan(request, response);
                break;
            case "xieyi":
                getXieyi(request, response);
                break;
            case "yingsi":
                getYingsi(request,response);
                break;
            case "jubao":
               getJubao(request, response);
                break;
            case "guanyu":
                getGuanyu(request,response);
                break;
            case "jiaru":
                getJiaru(request,response);
                break;
            case "yijian":
                getJianyi(request,response);
                break;
            case "lianxi":
                getJiaru(request,response);
                break;

        }

    }
    protected  void getZhinan(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
//        将文字传入div中
        String title = new String("联系我们");
        String whe = new String("OQ&AF属于太原蓝桥四期一班公司旗下品牌。OQ&AF，中文互联网知名的知识社交平台。OQ&AF以知识连接一切为使命，凭借认真、专业和友善的社区氛围和独特的产品机制，聚集了中国互联网上科技、商业、文化等领域里最具创造力的人群，将高质量的内容透过人的节点来成规模地生产和分享，构建高价值人际关系网络。用户通过问答等交流方式建立信任和连接，打造和提升个人品牌价值，并发现、获得新机会。\n");
        String wher= new String("公司名称：太原蓝桥四期一班公司\n" +"</br>"+ "地址：北京市海淀区学院路甲 5 号 768 创意园 A 座西区四通道 3-010\n"  +"</br>"+ "电话：010-61190680");
        session.setAttribute("title",title);
        session.setAttribute("whe",whe);
        session.setAttribute("wher",wher);
        request.getRequestDispatcher("disorderly.jsp").forward(request,response);
    }
    protected  void getXieyi(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
//        将文字传入div中
        String title = new String("OQ&AF协议（草案）");
        String whe = new String("用户注册成功后，OQ&AF将给予每个用户一个用户帐号及相应的密码，该用户帐号和密码由用户负责保管；用户应当对以其用户帐号进行的所有活动和事件负法律责任。\n" +"</br>"+ "用户须对在OQ&AF的注册信息的真实性、合法性、有效性承担全部责任，用户不得冒充他人；不得利用他人的名义发布任何信息；不得恶意使用注册帐号导致其他用户误认；否则OQ&AF有权立即停止提供服务，收回其帐号并由用户独自承担由此而产生的一切法律责任。\n" +"</br>"+ "用户直接或通过各类方式（如 RSS 源和站外 API 引用等）间接使用OQ&AF服务和数据的行为，都将被视作已无条件接受本协议全部内容；若用户对本协议的任何条款存在异议，请停止使用OQ&AF所提供的全部服务。\n" +"</br>"+ "OQ&AF是一个信息分享、传播及获取的平台，用户通过OQ&AF发表的信息为公开的信息，其他第三方均可以通过OQ&AF获取用户发表的信息，用户对任何信息的发表即认可该信息为公开的信息，并单独对此行为承担法律责任；任何用户不愿被其他第三人获知的信息都不应该在OQ&AF上进行发表。\n" + "用户承诺不得以任何方式利用OQ&AF直接或间接从事违反中国法律以及社会公德的行为，OQ&AF有权对违反上述承诺的内容予以删除。");
        String wher= new String("OQ&AF是一个信息获取、分享及传播的平台，我们尊重和鼓励OQ&AF用户创作的内容，认识到保护知识产权对OQ&AF生存与发展的重要性，承诺将保护知识产权作为OQ&AF运营的基本原则之一。");
        session.setAttribute("title",title);
        session.setAttribute("whe",whe);
        session.setAttribute("wher",wher);
        request.getRequestDispatcher("disorderly.jsp").forward(request,response);
    }
    protected  void getYingsi(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
//        将文字传入div中
        String title = new String("隐私政策");
        String whe = new String("当您注册OQ&AF帐号和使用我们的服务时，我们会根据您的同意和提供服务的需要，收集您的姓名、性别、年龄、个人资料照片或视频、身份证号、电话号码、电子邮件、社交帐号、身份验证信息、位置信息和日志信息等个人信息。\n" +"</br>"+ "除了产品的核心功能外，OQ&AF提供一些附加功能来提升用户体验，包括：消息设置、邮件设置、推送通知设置、OQ&AF实验室等。当您使用OQ&AF的附加功能时，我们不会额外收集您的个人信息，除非根据本政策告知并取得您的同意。\n" +"</br>"+ " 当您在未登录状态下时，将显示为「游客」。为了更好地为您提供便捷流畅的社区体验，「游客」同样可以进行关注、点赞、收藏、试读电子书等基础社区行为。为了方便您查阅这些过往信息，我们需要获取您的设备号(IMEI码)以便记录存档。");
        String wher= new String("目前，除法律法规、法律程序、诉讼或政府主管部门强制性要求外，OQ&AF不会主动公开披露您的个人信息，如果存在其他需要公开披露个人信息的情形，我们会征得您的明示同意。同时，我们保证披露采取符合法律和业界标准的安全防护措施。");
        session.setAttribute("title",title);
        session.setAttribute("whe",whe);
        session.setAttribute("wher",wher);
        request.getRequestDispatcher("disorderly.jsp").forward(request,response);
    }
    protected  void getJubao(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
//        将文字传入div中
        String title = new String("举报条理");
        String whe = new String("互联网给我们带来便利的同时，也给我们造成了一些困扰。网络侵权，就是其中之一。今天小管家想和各位知友聊一聊，关于OQ&AF侵权举报流程的一些思考。\n" + "</br>"+ "一直以来，我们都鼓励大家分享自己的知识、经验和见解，希望有价值信息得到更好地传播与分享。我们不欢迎侵权、谣言、诽谤类信息，也从未借助自有渠道主动传播或间接鼓励过任何谣言及疑似诽谤内容。作为平台方，我们为知友们发布的内容提供展示空间，大家在OQ&AF发表的内容仅代表个人，并不代表OQ&AF的立场或观点。根据《中华人民共和国侵权责任法》以及《最高人民法院关于审理利用信息网络侵害人身权益民事纠纷案件适用法律若干问题的规定》，OQ&AF作为网络服务提供者，有义务在权利人发出有效通知后，及时处理相关涉嫌侵权的内容。\n" + "\n" + "OQ&AF于 2014 年开始支持邮件侵权举报，自上线至今，日均收到企业侵权举报 32 例，平均处理时效为 5 个工作日；个人侵权举报 8 例，平均处理时效为 2 个工作日。因个人侵权与企业侵权的处理方式并不相同，同时出于对个人权益的保护，所以个人侵权的平均处理时效相对于企业侵权的较短。");
        String wher= new String("在使用侵权举报产品的过程中，如果你遇到相关问题，欢迎你发送私信与OQ&AF小管家进行联系，");
        session.setAttribute("title",title);
        session.setAttribute("whe",whe);
        session.setAttribute("wher",wher);
        request.getRequestDispatcher("disorderly.jsp").forward(request,response);
    }
    protected  void getGuanyu(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
//        将文字传入div中
        String title = new String("关于我们");
        String whe = new String("OQ&AF属于太原蓝桥四期一班公司旗下品牌。OQ&AF，中文互联网知名的知识社交平台。OQ&AF以知识连接一切为使命，凭借认真、专业和友善的社区氛围和独特的产品机制，聚集了中国互联网上科技、商业、文化等领域里最具创造力的人群，将高质量的内容透过人的节点来成规模地生产和分享，构建高价值人际关系网络。用户通过问答等交流方式建立信任和连接，打造和提升个人品牌价值，并发现、获得新机会。");
        String wher= new String("同样欢迎各位加入我们，与我们共同建设好这个网站");
        session.setAttribute("title",title);
        session.setAttribute("whe",whe);
        session.setAttribute("wher",wher);
        request.getRequestDispatcher("disorderly.jsp").forward(request,response);
    }
    protected  void getJiaru(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
//        将文字传入div中
        String title = new String("加入我们");
        String whe = new String("每个人都有值得分享的知识，每个认真分享知识的人都应该被尊重。\n" + "</br>" +  "</br>" + "\n" + "OQ&AF是中文互联网知识分享平台。\n" +  "</br>" +  "</br>"+  "</br>"+ "以「知识连接一切」为愿景，致力于构建一个人人都可以便捷接入的知识分享网络，让人们便捷地与世界分享知识、经验和见解，发现更大的世界。 \n" +  "</br>"+  "</br>" + "</br>" + "以「帮助人们更好地认识世界」为使命，凭借认真、专业、友善的社区氛围和独特的产品机制，聚集了中国互联网上科技、商业、文化等领域里最具创造力的人群。OQ&AF用户们通过知识建立信任和连接，对热点事件或话题进行理性、深度、多维度的讨论，分享专业、有趣、多元的高质量内容，打造和提升个人品牌价值，发现并获得新机会。\n" +  "</br>" + "未来，OQ&AF将持续打造以知识分享为核心的生态，建设可持续发展的内容和专家网络，用以帮助人们实现生活、工作、学习和创新场景中的需求，并对相关的行业有深刻的影响和积极的改变。"+"</br>" +"联系方式：15988952080");
        String wher= new String("欢迎各位加入我们，与我们共同建设好这个网站");
        session.setAttribute("title",title);
        session.setAttribute("whe",whe);
        session.setAttribute("wher",wher);
        request.getRequestDispatcher("disorderly.jsp").forward(request,response);
    }
    protected  void getJianyi(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
//        将文字传入div中
        String title = new String("建议我们");
        String whe = new String("<textarea style=\"height:180px;width:600px\" name=\"text\" maxlength=\"300\" placeholder=\"请输入问题描述\"></textarea>\n" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" + "<input type=\"submit\" value=\"提交\" id=\"btn\" style=\"height:30px;width:70px;outline: #2255a6;border:none;line-height: 32px;padding: 0px 12px;\">");
        String wher= new String("欢迎各位加入我们，与我们共同建设好这个网站");
        session.setAttribute("title",title);
        session.setAttribute("whe",whe);
        session.setAttribute("wher",wher);
        request.getRequestDispatcher("disorderly.jsp").forward(request,response);
    }
}
