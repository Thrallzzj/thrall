<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/jsp/common/head.jsp"%>




<div class="right">
       <div class="location">
           <strong>你现在所在的位置是:</strong>
           <span>订单管理页面</span>
       </div>
       <div class="search">
       <form method="get" action="searchbill">
			<input name="method" value="query" class="input-text" type="hidden">
			<span>商品名称：</span>
			<input name="queryProductName" id="proname" type="text">
			 
			<span>供应商：</span>
			<select id="pid" name="queryProviderId">
				<c:if test="${listsp != null }"> 
				   <option value="请选择">--请选择--</option>
				   <c:forEach var="pro" items="${listsp}">
				   		<option value="${pro.proname}">${pro.proname}</option>
				   </c:forEach>
				</c:if> 
       		</select>
			 
			<span>是否付款：</span>
			<select id="ispay" name="queryIsPayment">
				<option value="0">--请选择--</option>
			 <c:forEach items="${listbs }" var="sb">
					<option value="${sb.ispayment }">
						<c:if test="${sb.ispayment == 1}">
							未付款
						</c:if>
						<c:if test="${sb.ispayment == 2}">
							已付款
						</c:if>
					</option>
				</c:forEach> 
				<%-- <option value="1" ${queryIsPayment == 1 ? "selected=\"selected\"":"" }>未付款</option>
				<option value="2" ${queryIsPayment == 2 ? "selected=\"selected\"":"" }>已付款</option> --%>
       		</select>
			
			 <input	value="查 询" type="button" id="searchbutton">
			 <a href="${pageContext.request.contextPath }/jsp/billadd.jsp">添加订单</a>
		</form>
       </div>
      <!--账单表格 样式和供应商公用-->
      <table class="providerTable" cellpadding="0" cellspacing="0" id="tt">
          <tr class="firstTr">
              <th width="10%">订单编码</th>
              <th width="20%">商品名称</th>
              <th width="10%">供应商</th>
              <th width="10%">订单金额</th>
              <th width="10%">是否付款</th>
              <th width="10%">创建时间</th>
              <th width="30%">操作</th>
          </tr>
          <tbody id="tby">
          <c:forEach var="sb" items="${listsb }" varStatus="status">
				<tr>
					<td>
					<span>${sb.BILLCODE }</span>
					</td>
					<td>
					<span>${sb.PRODUCTNAME }</span>
					</td>
					<td>
					<span>${sb.PRONAME}</span>
					</td>
					<td>
					<span>${sb.TOTALPRICE}</span>
					</td>
					<td>
					<span>
						<c:if test="${sb.ISPAYMENT == 1}">未付款</c:if>
						<c:if test="${sb.ISPAYMENT == 2}">已付款</c:if>
					</span>
					</td>
					<td>
					<span>
					<fmt:formatDate value="${sb.CREATIONDATE}" pattern="yyyy-MM-dd"/>
					</span>
					</td>
					<td>
					<span><a class="viewBill" href="javascript:;" billid=${sb.id } billcc=${sb.billcode }><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>
					<span><a class="modifyBill" href="jsp/billmodify.jsp?sid=${sb.id }"><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
					<span><a class="deleteBill" href="delBill?sid=${sb.id }&pid=${sb.spro.id}"><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
					</td>
				</tr>
			</c:forEach>
			</tbody>
      </table>
  </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/billlist.js"></script>
<script src="${pageContext.request.contextPath }/js/json2.js"></script>
<script>
$(function(){
	alert("1111");
	$("input[id='searchbutton']").click(function(){
		//获取
		var proname=$("input[id='proname']").val();
		var pid=$("#pid").val();
		var ispay=$("#ispay").val();
// 		alert(proname+" : "+pid+"  :  "+ispay);
		var product={
				"proname":proname,
				"pid":pid,
				"ispay":ispay
		};
		$.ajax({
			url:"ajax.action?pro="+JSON.stringify(product),
			type:"POST",
			//data:JSON.stringify(product),
			success:function(mess){
				
				//var mess=eval("("+message+")");
				
				$("tbody[id='tby']>tr").remove();
				alert(mess);
				if(mess.length!=0){
					for(var i=0;i<mess.length;i++){
						var mm=mess[i];
						var yy=(mm["CREATIONDATE"]["year"]+1900)+"-"+mm["CREATIONDATE"]["date"]+"-"+mm["CREATIONDATE"]["day"];
						var $tby=$("<tr><td>"+mm["BILLCODE"]+"</td>"+"<td>"+mm["PRODUCTNAME"]+"</td>"+
								"<td>"+mm["PRONAME"]+"</td>"+"<td>"+mm["TOTALPRICE"]+"</td>"+
								"<td>"+mm["ISPAYMENT"]+"</td>"+"<td>"+yy+"</td></tr>");
						$("table[id='tt']").append($tby);
					}
				}
				//window.location.href="${pageContext.request.contextPath }/ajax2.action?pro="+JSON.stringify(product);
			},
			error:function(){
				alert("error!!!");
			}
		});
	});
});
</script>