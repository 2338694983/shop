<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>跳蚤市场-二手物品商城 - 首页</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <script type="text/javascript" src="scripts/function.js"></script>
    <style>
        .scroll_div {width:600px; height:62px;margin:0 auto; overflow: hidden; white-space: nowrap; background:#ffffff;}
        .scroll_div img {width:120px;height:60px;border: 0;margin: auto 8px; border:1px #efefef solid;}
        #scroll_begin, #scroll_end, #scroll_begin ul, #scroll_end ul, #scroll_begin ul li, #scroll_end ul li{display:inline;}
    </style>
    <style>
        .scroll_div {width:500px; height:100px;margin:0 auto; overflow: hidden; white-space: nowrap; background:#ffffff;}
        .scroll_div img {width:120px;height:100px;border: 0;margin: auto 8px; border:1px #efefef solid;}
        #scroll_begin, #scroll_end, #scroll_begin ul, #scroll_end ul, #scroll_begin ul li, #scroll_end ul li{display:inline;}
    </style>
    <script language="javascript">

        function ScrollImgLeft(){
            var speed=20
            var scroll_begin = document.getElementById("scroll_begin");
            var scroll_end = document.getElementById("scroll_end");
            var scroll_div = document.getElementById("scroll_div");
            scroll_end.innerHTML=scroll_begin.innerHTML
            function Marquee(){
                if(scroll_end.offsetWidth-scroll_div.scrollLeft<=0)
                    scroll_div.scrollLeft-=scroll_begin.offsetWidth
                else
                    scroll_div.scrollLeft++
            }
            var MyMar=setInterval(Marquee,speed)
            scroll_div.onmouseover=function() {clearInterval(MyMar)}
            scroll_div.onmouseout=function() {MyMar=setInterval(Marquee,speed)}
        }
        function selectname(){
            var name = document.getElementById("selectname").value;
            location.href='selectProductList?name='+name;
        }
        function searchHot(name){
            location.href='selectProductList?name='+name;
        }
        function check() {
            var num=parseInt(document.getElementById("y").value);
            if(num<0){
                document.getElementById("yy").innerHTML="<font color='red'>价格不能为负数</font>";
                document.getElementById("sub").disabled=true;
            }else{
                document.getElementById("yy").innerHTML="";
                document.getElementById("sub").disabled=false;
            }
        }
        function check2() {
            var num=parseInt(document.getElementById("k").value);
            if(num<0){
                document.getElementById("kk").innerHTML="<font color='red'>库存不能为负数</font>";
                document.getElementById("sub").disabled=true;
            }else{
                document.getElementById("kk").innerHTML="";
                document.getElementById("sub").disabled=false;
            }
        }

    </script>


</head>


<div id="header" class="wrap">
    <div id="logo"><img src="images/logo.gif" height="60" /></div>
    <div class="help"><c:if test="${name!=null}"><a href="selectdd?dd=${name.EU_USER_ID }">个人订单</a></c:if><c:if test="${name!=null}">当前用户${name.EU_USER_ID }</c:if><a href="ShopSelect" class="shopping">购物车</a><c:if test="${name==null}"><a href="login.jsp">登录</a>|<a href="register.jsp">注册</a></c:if><c:if test="${name!=null}"><a href="zx">退出</a></c:if><a href="SelallServlet">留言</a><c:if test="${name.EU_STATUS==2}"><a href="manage/index.jsp" >去后台</a></c:if></div>
    <div class="navbar">
        <ul class="clearfix">
            <c:choose>
                <c:when test="${empty selected_fid}">
                    <li class="current" ><a href="indexSelect">首页</a></li>
                </c:when>
                <c:otherwise>
                    <li ><a href="indexSelect">首页</a></li>
                </c:otherwise>
            </c:choose>
            <c:forEach var="f" items="${flist}">
                <c:choose>
                    <c:when test="${selected_fid == f.EPC_ID}">
                        <li class="current" ><a href="selectProductList?fid=${f.EPC_ID }">${f.EPC_NAME }</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="selectProductList?fid=${f.EPC_ID }">${f.EPC_NAME }</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </ul>
    </div>
</div>
<%@ include file="/include/search_bar.jsp" %>
<body>
<div id="main" class="wrap">
    <div id="menu-mng" class="lefter">
        <div class="box">
            <dl>
                <dd><a href="user">个人信息管理</a></dd>
                <dd><a href="ordersel">购买物品信息</a></dd>
                <dd><a href="ordersel">添加物品信息</a></dd>
            </dl>
        </div>
    </div>
    <div class="main">
        <h2>添加商品</h2>
        <div class="manage">
            <form action="release" method="get">
                <table class="form" align="left">
                    <tr>
                        <td class="field">商品名称：</td>
                        <td><input type="text" class="text" name="productName" maxlength="16"/></td>
                        <td><input type="hidden" name="id" /></td>
                    </tr>
                    <tr >
                       <td></td>
                        <td class="field">所属分类：
                            <select name="productId">
                                <option value ="61">手机</option>
                                <option value ="62">电脑</option>
                                <option value ="63">相机</option>
                                <option value ="64">自行车</option>
                                <option value ="65">服饰</option>
                                <option value ="66">机械器具</option>
                                <option value ="67">书籍</option>
                                <option value ="68">学习资料</option>
                                <option value ="69">试卷</option>
                                <option value ="70">其他</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="field">商品图片：</td>
                        <td><input type="file" class="text" name="photo" /></td>
                    </tr>
                    <tr>
                        <td class="field">商品价格：</td>
                        <td><input type="text" class="text tiny" name="productPrice"  onblur="check()" id="y" onkeyup="value=value.replace(/[^\d]/g,'') "
                                   onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"/> 元<span id="yy"></span></td>
                    </tr>
                    <tr>
                        <td class="field">描述：</td>
                        <td><input type="text" class="text" name="productDesc"  maxlength="100"/></td>
                    </tr>
                    <tr>
                        <td class="field">库存：</td>
                        <td><input type="text" class="text tiny" name="productStock"  onblur="check2()" id="k"/><span id="kk" onkeyup="value=value.replace(/[^\d]/g,'') "
                                                                                                                                            onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"></span></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><label class="ui-blue"><input type="submit" name="submit" value="提交" id="sub"/></label></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="clear"></div>
</div>
<%@ include file="/include/footer.jsp" %>
</body>
</html>

