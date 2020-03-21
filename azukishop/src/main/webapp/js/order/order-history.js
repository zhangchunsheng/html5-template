/**
 *  查询登陆用户所有订单数据
 */
function getUserIdByOrderId() {

    $.ajax({
        type: "GET",
        url: "/getOrderInfoByUserId",
        success: function (data) {
            var paresData = JSON.parse(data);
            render(paresData);
        }
    });

}

/**
 * 渲染Json数据
 */
function render(datas){
    let renderTable = document.getElementById("renderTable");
    for (let i = 0; i < datas.length; i++) {
        let tr = document.createElement("tr");
        let orderInfoId = document.createElement("td");
        let sendType = document.createElement("td");
        let payType = document.createElement("td");
        let payCount = document.createElement("td");
        let created_date = document.createElement("td");
        let status = document.createElement("td");
        let view = document.createElement("td");
        renderTable.appendChild(tr);
        orderInfoId.innerHTML = datas[i].orderInfoId;
        tr.appendChild(orderInfoId);
        sendType.innerHTML = datas[i].sendType;
        sendType.style.textAlign = "right";
        tr.appendChild(sendType);
        payType.innerHTML = datas[i].payType;
        payType.style.textAlign = "right";
        tr.appendChild(payType);
        payCount.innerHTML = "$"+(datas[i].payCount/100).toFixed(2);
        payCount.style.textAlign = "right";
        tr.appendChild(payCount);
        created_date.innerHTML = datas[i].created_date;
        created_date.style.textAlign = "right";
        tr.appendChild(created_date);
        status.innerHTML = (datas[i].status == 0)? "未支付":"已支付";
        status.style.textAlign = "right";
        tr.appendChild(status);
        view.style.textAlign = "center";
        view.className = "views";
        tr.appendChild(view);
        view.innerHTML = "<a class=\"btn btn-info\" title=\"\" data-toggle=\"tooltip\"\n" +
            "                                                       href=\"order-information.html\" data-original-title=\"View\"><i\n" +
            "                                    class=\"fa fa-eye\"></i></a>";
        let views = document.getElementsByClassName("views");
        views[i].onclick = function () {
            var expiresTime = new Date();
            expiresTime.setTime(expiresTime.getTime() + 1 * 24 * 60 * 60 * 1000);
            document.cookie = "orderId  = "+datas[i].orderId+";" + "expires=" + expiresTime.toUTCString();

        }
        }


}

/**
 * 创建标签进行渲染
 */
function createTip(){

    td.className = "text-center"
}



onload = function () {
    getUserIdByOrderId();
};