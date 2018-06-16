<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>秒杀活动列表</title>
    <style>
        .mask{
            position:absolute;
            top:0%; /**遮罩全屏top,left都为0,width,height为100%**/
            left:0%;
            width:100%;
            height:100%;
            filter:alpha(opacity=50);
            opacity: 0.5;
            -moz-opacity:0.5;
            -khtml-opacity: 0.5;
            background-color:black;
            z-index: 1001;
            display:none;
            z-index: 888;
        }
        .itemDiv{

            background-color: white;
            z-index: 999;
            display: none;
            width: 80%;
            height: 80%;
            overflow:auto
        }
    </style>
</head>
<body>
<jsp:include page="../static/public/public.jsp"/>
<div class="mask"></div>
<div id="content">
    <!-- Start .content-wrapper -->


    <div class="row">
        <div class="col-lg-12">
            <!-- col-lg-12 start here -->
            <div class="panel panel-default plain toggle panelClose panelRefresh">
                <!-- Start .panel -->
                <div class="panel-heading white-bg">
                    <h4 class="panel-title">Data table</h4>
                    当前在${page}页 可以在→选择跳转页面
                </div>
                <div class="panel-body">
                    <table class="table display" id="datatable">
                        <thead>
                        <tr>
                            <th>开始时间</th>
                            <th>结束时间</th>
                            <th>创建时间</th>
                            <th>查看秒杀产品</th>
                        </tr>
                        </thead>

                        <tbody>
                        <form action="/delItemDo">
                            <c:forEach items="${list}" var="item">
                                <tr>
                                   <td>${item.startTime}</td>
                                    <td>${item.endTime}</td>
                                    <td>${item.createTime}</td>
                                    <td><a class="printItem" id="${item.id}">查看秒杀产品</a></td>

                                </tr>
                            </c:forEach>


                        </form>
                        </tbody>


                    </table>
                </div>
            </div>
            <!-- End .panel -->
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="http://localhost:8089/seckiil?page=${previousPage}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li>
                        <a href="http://localhost:8089/seckiil?page=${nextPage}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                    <li>
                        <form action="http://localhost:8089/seckiil" method="get">
                            <div class="input-group" width="20%">
                                <input type="text" class="form-control" name="page" width="20%" placeholder="Search for...">
                                <span class="input-group-btn">
                                            <input class="btn btn-default" type="submit">跳转</input>
                                        </span>
                            </div>
                        </form>

                    </li>
                </ul>
            </nav>
        </div>
        <!-- col-lg-12 end here -->
    </div>


</div>
<!-- End .content-wrapper -->
<div class="itemDiv">
    <p align="right" id="itemDivClose" style="font-size: 50px;cursor:pointer ">X</p>
    <table class="table">
        <thead>
        <tr>
            <th>产品</th>
            <th>秒杀价</th>
            <th>秒杀数量</th>

        </tr>
        </thead>
        <tbody class="item">

        </tbody>
    </table>
</div>

<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
    $(function() {
        function funShowDivCenter() {
            var top = ($(window).height() - $(".mask").height()) / 2;
            var left = ($(window).width() - $(".mask").width()) / 2;
            var scrollTop = $(document).scrollTop();
            var scrollLeft = $(document).scrollLeft();
            $(".mask").css({position: 'absolute', 'top': top + scrollTop, left: left + scrollLeft}).toggle(500);
        }

        function funShowDivCenter1() {
            var top = ($(window).height() - $(".itemDiv").height()) / 2;
            var left = ($(window).width() - $(".itemDiv").width()) / 2;
            var scrollTop = $(document).scrollTop();
            var scrollLeft = $(document).scrollLeft();
            $(".itemDiv").css({position: 'absolute', 'top': top + scrollTop, left: left + scrollLeft}).toggle();
        }

        $(document).on("click", "#itemDivClose", function () {
            funShowDivCenter()
            funShowDivCenter1()
        })
        $(document).on("click",".printItem",function(){
            var id
            var html=""
            var that = $(this)
            id = that.attr("id")
       //     console.log(id)
            $.ajax({
                url:"http://localhost:8089/seckiilItem",
                data:{
                    "id":id,
                },
                dataType:"json",
                type:"GET",
                success:function (res) {
                  //  console.log(res)
                    if (res.status==200){
                        html = ""

                        for (var i = 0;i < res.data.length;i++){
                            html += "<tr>"
                            html+="<td>"+res.data[i].item.title+"</td>"
                            html+="<td>"+res.data[i].newPrice+"</td>"
                            html+="<td>"+res.data[i].num+"</td>"
                            html += "</tr>"
                        }

                        $(".item").append(html)
                        funShowDivCenter()
                        funShowDivCenter1()
                    }
                }
            })
        })
    })
</script>
</body>
</html>