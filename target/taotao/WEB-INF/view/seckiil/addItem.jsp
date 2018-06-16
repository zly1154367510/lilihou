<%--
  Created by IntelliJ IDEA.
  User: zly11
  Date: 2018/6/15
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: zly11
  Date: 2018/4/30
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>编辑秒杀活动</title>
    <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js" type="text/javascript"></script>
    <style type="text/css">
        /*#itemList{*/
            /*display: none;*/
        /*}*/
    </style>
</head>
<body>
<jsp:include page="../static/public/public.jsp"/>
<div class="row">
    <div class="col-lg-12">

    </div>
</div>

<div id="content">
    <!-- Start .content-wrapper -->


    <div class="row">
        <div class = "col-lg-12">
            <!-- col-lg-12 start here -->
            <div class="panel panel-default plain toggle panelClose panelRefresh">
                <!-- Start .panel -->
                <div class="panel-heading white-bg">
                    <h4 class="panel-title">编辑秒杀活动</h4>
                </div>

            </div>
            <!-- End .panel -->


            <form action="saveSeckiil" method="post" class="form-horizontal" enctype="multipart/form-data">>
                <fieldset>
                    <div id="legend" class="">
                        <legend class="">编辑秒杀活动</legend>
                    </div>

                    <div class="control-group">
                        <!-- Text input-->
                        <label class="control-label" >秒杀开始时间</label>
                        <div class="controls">

                            <input name="startTime" class="input-xlarge" type="datetime-local"/>
                            <p class="help-block"></p>
                        </div>
                    </div>

                    <div class="control-group">
                        <!-- Text input-->
                        <label class="control-label" >秒杀结束时间</label>
                        <div class="controls">

                            <input  name="endTime" class="input-xlarge" type="datetime-local"/>
                            <p class="help-block"></p>
                        </div>
                    </div>

                    <label >商品选择</label>
                    <input type="button" value="点击商品选择"/>
                    <fieldset>
                        <legend>商品选择</legend>
                        <div id="itemList">

                        </div>
                    </fieldset>

                    <div class="control-group">
                        <input type="submit" class="btn btn-default" value="Submit" />
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
        <!-- col-lg-12 end here -->
    </div>

</div>
<!-- End .content-wrapper -->
<div class="clearfix"></div>
</div>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
<script type="text/javascript">
 var vm = new Vue({
     el:"#itemList",
     data:{
        itemJson:""
     },
     mounted:function(){
         var that = this
         var addHtml = ""
         var addHtml2 = ""
         $.ajax({
             url:"http://localhost:8089/api/item?page=1",
             dataType:"json",
             type:"GET",
             success:function(res){
               //  console.log(res)
                 if(res.status=200){
                     that.itemJson = res.data;
                     var data = res.data
                   //  console.log(that.itemJson)
                     for(var i=0;i<that.itemJson.length;i++){
                         addHtml += "<div>"
                         addHtml += "<input class='itemId' name='iId' value="+data[i].id+" type='checkbox' />"
                         addHtml += "<p>商品:"+data[i].title+"</p>";
                         addHtml += "<p>原价:"+data[i].price+"</p>";
                         addHtml += "<p>库存:"+data[i].num+"</p>";
                         addHtml += "</div>"
                         addHtml += "<hr>"
                         addHtml += "<br>"
                     }
                     $("#itemList").append(addHtml)
                     $(".itemId").each(function(){
                         $(this).click(function(){
                           //  console.log($(this).is(':checked'))
                             if($(this).is(':checked')) {
                                 addHtml2 = ""
                                 addHtml2 += "<div class='newNode input-group'>"
                                 addHtml2 += "<span class='input-group-addon'>秒杀价格:</span>"
                                 addHtml2 += "<input class='form-control' name='newPrice' type='text' ><br>"
                                 addHtml2 += "<span class='input-group-addon'>秒杀数量:</span>"
                                 addHtml2 += "<input class='form-control'  name='num' type='text' ><br>"
                                 addHtml2 += "</div>"
                                 console.log( addHtml2)
                                 $(this).parent().append(addHtml2)
                             }else{
                                $(this).parent().children(".newNode").remove()
                             }
                         })
                     })
                 }
             }
         })
     },
     methods:{
         addItem:function () {
             alert("选中我")
         }
     }
 })
</script>
</body>
</html>