<%@page pageEncoding="UTF-8" isELIgnored="false" %>


<script>
    function out() {
        window.location.href="${pageContext.request.contextPath}/user/out";
    }
</script>


<div>
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">所有用户</a></li>
        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab" onclick="out()">导出所有用户信息</a></li>
    </ul>
</div>
<table id="user-table"></table>
<div id="user-pager" style="height: 40px"></div>